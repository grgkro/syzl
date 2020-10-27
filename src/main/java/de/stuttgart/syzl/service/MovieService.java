package de.stuttgart.syzl.service;

import de.stuttgart.syzl.entity.Movie;
import de.stuttgart.syzl.repository.MovieRepository;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	
    @Autowired
    private MovieRepository movieRepository;

    
    public ArrayList<Movie> fetchMovies() {
    	ArrayList<Movie> movies = (ArrayList<Movie>) movieRepository.findAll();
    	return movies;
    }
    
    public Movie getMovie(String sourceId) {
    	return movieRepository.findBySourceId(sourceId);
    }
    

}

