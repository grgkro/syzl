package de.stuttgart.syzl.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.stuttgart.syzl.dto.MovieDto;
import de.stuttgart.syzl.dto.NewMovieIMDBDto;
import de.stuttgart.syzl.entity.Movie;
import de.stuttgart.syzl.entity.NewMovieIMDB;
import de.stuttgart.syzl.repository.MovieRepository;
import de.stuttgart.syzl.repository.NewMovieIMDBRepository;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceIMDB {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private NewMovieIMDBRepository newMovieIMDBRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Value("${imdb.api_key}")
    private String IMDB_APIKey;

    @Value("${imdb.api_url}")
    private String IMDB_URL;

    public List<MovieDto> getTop250MoviesFromIMDB() throws IOException {

        // get data from IMDB API
        String jsonData = getJSONDataFromIMDBBySubURL("Top250Movies/");
        //transform the items in jsonData to JSONArray
        JSONArray jArrayMovies = transformStringToJSONArray(jsonData, "items");
        // get error message
        String errorMessage = jsonData.split(",\"errorMessage\":")[1];
            System.out.println("---------Error Message:" + errorMessage + "---------");
        // transform JSONArray to Entities and save them in DB
        return transformJSONArrayToDTOs(jArrayMovies);
    }

    private JSONArray transformStringToJSONArray(String jsonData, String arrayIdentifier) {
        try {
            JSONObject jObject = new JSONObject(jsonData);
            return jObject.getJSONArray(arrayIdentifier);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<MovieDto> transformJSONArrayToDTOs(JSONArray jArrayMovies) {
        List<MovieDto> moviesToReturn = new ArrayList<>();
        try {
            for (int i = 0; i < jArrayMovies.length(); i++) {
                String json = jArrayMovies.get(i).toString();
                ObjectMapper objectMapper = new ObjectMapper();
                Movie movie = objectMapper.readValue(json, Movie.class);
                movie.setImdb(true);
                System.out.println(movie.getFullTitle());
                Movie movieFromDatabase = movieRepository.findById(movie.getId());

                if (movieFromDatabase == null) {
                    movieRepository.save(movie);
                    MovieDto movieDto = modelMapper.map(movie, MovieDto.class);
                    moviesToReturn.add(movieDto);
                } else {
                    MovieDto movieDto = modelMapper.map(movieFromDatabase, MovieDto.class);
                    moviesToReturn.add(movieDto);
                }

            }
        } catch (JSONException | JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
        return moviesToReturn;
    }

    public String getJSONDataFromIMDBBySubURL(String subURL) {
        String jsonData = null;
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()

                    .build();

            Request request = new Request.Builder()

                    .url(IMDB_URL + subURL + IMDB_APIKey )

                    .method("GET", null)

                    .build();

            Response response = null;

            try {
                response = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            jsonData = response.body().string();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    public List<NewMovieIMDBDto> getMoviesInTheatersFromIMDB() {
        List<NewMovieIMDBDto> moviesToReturn = new ArrayList<>();
        // get data from IMDB API
        String jsonData = getJSONDataFromIMDBBySubURL("InTheaters/");
        //transform the items in jsonData to JSONArray
        JSONArray jArrayMovies = transformStringToJSONArray(jsonData, "items");
        // get error message
        String errorMessage = jsonData.split(",\"errorMessage\":")[1];
        System.out.println("---------Error Message:" + errorMessage + "---------");

        try {
            for (int i = 0; i < jArrayMovies.length(); i++) {
                String json = jArrayMovies.get(i).toString();
                ObjectMapper objectMapper = new ObjectMapper();
                NewMovieIMDB movie = objectMapper.readValue(json, NewMovieIMDB.class);
                System.out.println(movie.getFullTitle());
                NewMovieIMDB movieFromDatabase = newMovieIMDBRepository.findById(movie.getId());

                if (movieFromDatabase == null) {
                    newMovieIMDBRepository.save(movie);
                    NewMovieIMDBDto movieDto = modelMapper.map(movie, NewMovieIMDBDto.class);
                    moviesToReturn.add(movieDto);
                } else {
                    NewMovieIMDBDto movieDto = modelMapper.map(movieFromDatabase, NewMovieIMDBDto.class);
                    moviesToReturn.add(movieDto);
                }

            }
        } catch (JSONException | JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
        return moviesToReturn;
    }

    public List<MovieDto> getMostPopularMoviesFromIMDB() {

        List<NewMovieIMDBDto> moviesToReturn = new ArrayList<>();
        // get data from IMDB API
        String jsonData = getJSONDataFromIMDBBySubURL("MostPopularMovies/");
        //transform the items in jsonData to JSONArray
        JSONArray jArrayMovies = transformStringToJSONArray(jsonData, "items");
        // get error message
        String errorMessage = jsonData.split(",\"errorMessage\":")[1];
        System.out.println("---------Error Message:" + errorMessage + "---------");
        // transform JSONArray to Entities and save them in DB
        return transformJSONArrayToDTOs(jArrayMovies);

    }
}
