package de.stuttgart.syzl.service;

import de.stuttgart.syzl.entity.Movie;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.List;

public class MovieServiceIMDB {

    @Value("${imdb.api_key}")
    private String IMDB_APIKey;

    private String IMDB_URL;

    public List<Movie> getAllMoviesFromIMDB() {
        OkHttpClient client = new OkHttpClient().newBuilder()

                .build();

        Request request = new Request.Builder()

                .url("https://imdb-api.com/en/API/Title/k_1234567/tt1832382")

                .method("GET", null)

                .build();

        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
