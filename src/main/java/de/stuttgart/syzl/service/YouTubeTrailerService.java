package de.stuttgart.syzl.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.stuttgart.syzl.dto.YouTubeTrailerDto;
import de.stuttgart.syzl.entity.YouTubeTrailer;
import de.stuttgart.syzl.repository.YouTubeTrailerRepository;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class YouTubeTrailerService {

    @Autowired
    private YouTubeTrailerRepository youTubeTrailerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Value("${imdb.api_key}")
    private String IMDB_APIKey;

    @Value("${imdb.api_url}")
    private String IMDB_URL;

    public YouTubeTrailerDto getURL(String imdbId) {
        // get data from IMDB API
        String jsonData = getJSONDataFromIMDBBySubURL("YouTubeTrailer/", imdbId);
        // transform and save data to entity + return dto
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            YouTubeTrailer youTubeTrailer = objectMapper.readValue(jsonData, YouTubeTrailer.class);
            System.out.println(youTubeTrailer.getVideoUrl());
            YouTubeTrailer trailerFromDatabase = youTubeTrailerRepository.findByImDbId(youTubeTrailer.getImDbId());

            if (trailerFromDatabase == null) {
                youTubeTrailerRepository.save(youTubeTrailer);
                YouTubeTrailerDto trailer = modelMapper.map(youTubeTrailer, YouTubeTrailerDto.class);
                return trailer;
            } else {
                YouTubeTrailerDto trailer = modelMapper.map(trailerFromDatabase, YouTubeTrailerDto.class);
                return trailer;
            }

        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getJSONDataFromIMDBBySubURL(String subURL, String imdbId) {
        String jsonData = null;
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()

                    .build();

            Request request = new Request.Builder()

                    .url(IMDB_URL + subURL + IMDB_APIKey + "/" + imdbId )

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
}
