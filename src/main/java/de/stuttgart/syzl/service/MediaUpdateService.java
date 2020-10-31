package de.stuttgart.syzl.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stuttgart.syzl.entity.Movie;
import de.stuttgart.syzl.repository.MovieRepository;

@Service
public class MediaUpdateService {
  
	
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ConnectivityService connect;

	private String [] accessDB = {
			"https://imdb-api.com/en/API/Top250Movies/k_ul469h9q",
			"https://imdb-api.com/en/API/InTheaters/k_ul469h9q",
			"https://api.themoviedb.org/3/discover/movie?api_key=415bb43f2ce87c54d21b5aa21ba6d7b8"
	};

    public void updateAllDB() {
    	Arrays.asList(accessDB).forEach(e -> updateDB(e));
    }


    private void storeMovies(JSONArray array, String URL) {
    	ArrayList<Movie> movies = new ArrayList<Movie>();
        for (int i = 0; i < array.length(); i++) {
        	try {
        		if (URL.contains("imdb-api"))
        			movies.add(createMovieFromImdbJSON(array.getJSONObject(i)));
        		else if (URL.contains("api.themoviedb"))
        			movies.add(createMovieFromTmdbJSON(array.getJSONObject(i)));
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
        }
        for (int i = 0; i < movies.size(); i++) {
        	Movie movie = movieRepository.findBySourceId(movies.get(i).getSourceId());
        	if (movie != null) {
        		movies.get(i).setId(movie.getId());
        	}
        }
        movieRepository.saveAll(movies);
    }
	
    
    private Movie createMovieFromTmdbJSON(JSONObject obj) {
    	try {
    	Movie result = new Movie();
    	if (obj.has("id")) result.setSourceId(obj.get("id").toString());
    	if (obj.has("title")) result.setShortTitle(obj.get("title").toString());
    	if (obj.has("fullTitle")) result.setFullTitle(obj.get("fullTitle").toString());
    	if (obj.has("release_date")) result.setYear(Integer.parseInt(obj.get("release_date").toString().substring(0, 4)));
    	if (obj.has("overview")) result.setPlot(obj.get("overview").toString().substring(0, Math.min(obj.get("overview").toString().length(), 128)));
    	if (obj.has("image")) result.setImage(obj.get("image").toString());
    	if (obj.has("crew")) result.setCrew(obj.get("crew").toString());
    	if (obj.has("runtimeMins")) result.setLength(Integer.parseInt(obj.get("runtimeMins").toString()));
    	if (obj.has("imDbRating")) result.setRating(obj.get("imDbRating").toString());
    	if (obj.has("imDbRatingCount") && !obj.get("imDbRatingCount").toString().isEmpty()) result.setRatingCount(Long.parseLong(obj.get("imDbRatingCount").toString()));
    	return result;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
	
    
    private Movie createMovieFromImdbJSON(JSONObject obj) {
    	try {
    	Movie result = new Movie();
    	if (obj.has("id")) result.setSourceId(obj.get("id").toString());
    	if (obj.has("title")) result.setShortTitle(obj.get("title").toString());
    	if (obj.has("fullTitle")) result.setFullTitle(obj.get("fullTitle").toString());
    	if (obj.has("year")) result.setYear(Integer.parseInt(obj.get("year").toString()));
    	if (obj.has("plot")) result.setPlot(obj.get("plot").toString());
    	if (obj.has("image")) result.setImage(obj.get("image").toString());
    	if (obj.has("crew")) result.setCrew(obj.get("crew").toString());
    	if (obj.has("runtimeMins")) result.setLength(Integer.parseInt(obj.get("runtimeMins").toString()));
    	if (obj.has("imDbRating")) result.setRating(obj.get("imDbRating").toString());
    	if (obj.has("imDbRatingCount") && !obj.get("imDbRatingCount").toString().isEmpty()) result.setRatingCount(Long.parseLong(obj.get("imDbRatingCount").toString()));
    	return result;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    

    private void updateDB (String URL) {
    	System.out.println("Requesting payload for :" + URL);
    	String payload = connect.getPayloadFromURL(URL);
    	try {
    		if (URL.contains("imdb-api.com"))
    			storeMovies(new JSONObject(payload).getJSONArray("items"), URL);
    		else if (URL.contains("api.themoviedb"))
        		storeMovies(new JSONObject(payload).getJSONArray("results"), URL);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

}
