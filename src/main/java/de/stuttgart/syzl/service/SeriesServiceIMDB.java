package de.stuttgart.syzl.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.stuttgart.syzl.dto.MovieDto;
import de.stuttgart.syzl.dto.SeriesDto;
import de.stuttgart.syzl.entity.Movie;
import de.stuttgart.syzl.entity.Series;
import de.stuttgart.syzl.repository.MovieRepository;
import de.stuttgart.syzl.repository.SeriesRepository;
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
public class SeriesServiceIMDB {

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Value("${imdb.api_key}")
    private String IMDB_APIKey;

    @Value("${imdb.api_url}")
    private String IMDB_URL;

    public List<SeriesDto> getTop250SeriesFromIMDB() throws IOException {
        List<SeriesDto> seriesToReturn = new ArrayList<>();
        JSONObject jObject;
        JSONArray jArray = null;
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()

                    .build();

            Request request = new Request.Builder()

                    .url(IMDB_URL + "/Top250TVs/" + IMDB_APIKey )

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

//            for (int i = 0; i < jArray.length(); i++) {
//                JSONObject object = jArray.getJSONObject(i);
//            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            for (int i = 0; i < jArray.length(); i++) {
                String json = jArray.get(i).toString();
                ObjectMapper objectMapper = new ObjectMapper();
                Series series = objectMapper.readValue(json, Series.class);
                series.setImdb(true);
                System.out.println(series.getFullTitle());
                Series seriesFromDatabase = seriesRepository.findById(series.getId());
                System.out.println(seriesFromDatabase);

                if (seriesFromDatabase == null) {
                    seriesRepository.save(series);
                    SeriesDto seriesDto = modelMapper.map(series, SeriesDto.class);
                    seriesToReturn.add(seriesDto);
                } else {
                    SeriesDto seriesDto = modelMapper.map(seriesFromDatabase, SeriesDto.class);
                    seriesToReturn.add(seriesDto);
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return seriesToReturn;
    }

    public List<Series> getMostPopularSeriesFromIMDB() {

        return null;
    }
}
