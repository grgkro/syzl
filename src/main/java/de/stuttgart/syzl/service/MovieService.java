package de.stuttgart.syzl.service;

import de.stuttgart.syzl.entity.Movie;
import de.stuttgart.syzl.dto.MovieDto;
import de.stuttgart.syzl.repository.MovieRepository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	
    @Autowired
    private MovieRepository movieRepository;

    
    public ArrayList<MovieDto> fetchMovies() {
    	ArrayList<MovieDto> movies = new ArrayList<MovieDto> () ;
    	for (Movie movie: movieRepository.findAll()) {
    		movies.add(mapToDto(movie));
    	}
    	
    	return movies;
    }
    
    public MovieDto getMovie(String sourceId) {
    	Movie movie = movieRepository.findBySourceId(sourceId);
    	return (movie == null) ? null : mapToDto(movie);
    }
    
    private MovieDto mapToDto (Movie movie) {
    	MovieDto dto = new MovieDto(movie.getId(), movie.getSourceId(), movie.getFullTitle());
    	dto.setCrew(movie.getCrew() == null ? null: movie.getCrew());
    	dto.setShortTitle(movie.getShortTitle() == null ? null: movie.getShortTitle());
    	dto.setRanking(movie.getRanking() == null ? null: movie.getRanking());
    	dto.setYear(movie.getYear());
    	dto.setImage(movie.getImage() == null ? null: movie.getImage());
    	dto.setRating(movie.getRating() == null ? null: movie.getRating());
    	dto.setTrailerId(movie.getTrailerId() == null ? null: movie.getTrailerId());
    	dto.setPlot(movie.getPlot() == null ? null: movie.getPlot());
    	dto.setInTheater(movie.isInTheater());
    	dto.setLength(movie.getLength());
    	dto.setCrew(movie.getCrew() == null ? null: movie.getCrew());
    	return dto;
    }
    

}

