package de.stuttgart.syzl.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.stuttgart.syzl.dto.MovieDto;
import de.stuttgart.syzl.entity.Movie;
import de.stuttgart.syzl.repository.MovieRepository;
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
    private ModelMapper modelMapper;

    @Value("${imdb.api_key}")
    private String IMDB_APIKey;

    private String IMDB_URL;

    public List<MovieDto> getAllMoviesFromIMDB() throws IOException {
        List<MovieDto> moviesToReturn = new ArrayList<>();
        JSONObject jObject;
        JSONArray jArray = null;
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()

                    .build();

            Request request = new Request.Builder()

                    .url("https://imdb-api.com/en/API/Top250Movies/" + IMDB_APIKey )

                    .method("GET", null)

                    .build();

            Response response = null;

            try {
                response = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String jsonData = response.body().string();
             jObject = new JSONObject(jsonData);
             jArray = jObject.getJSONArray("items");

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject object     = jArray.getJSONObject(i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            for (int i = 0; i < jArray.length(); i++) {
                String json = jArray.get(i).toString();
                System.out.println(json);
                ObjectMapper objectMapper = new ObjectMapper();
                Movie movie = objectMapper.readValue(json, Movie.class);
                System.out.println(movie.getFullTitle());
                movieRepository.save(movie);
                MovieDto movieDto = modelMapper.map(movie, MovieDto.class);
                moviesToReturn.add(movieDto);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return moviesToReturn;
    }

    public List<Movie> getTop250MoviesFromIMDB() {

        return null;
    }

    public List<Movie> getTop250TVsFromIMDB() {

        return null;
    }

    public List<Movie> getMostPopularMoviesFromIMDB() {

        return null;
    }
}
