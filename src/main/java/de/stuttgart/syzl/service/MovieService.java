package de.stuttgart.syzl.service;

import de.stuttgart.syzl.entity.Movie;
import de.stuttgart.syzl.dto.MovieDto;
import de.stuttgart.syzl.repository.MovieRepository;

import java.util.ArrayList;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	
    @Autowired
    private MovieRepository movieRepository;

    
    public ArrayList<MovieDto> fetchAllMovies() {
    	ArrayList<MovieDto> movies = new ArrayList<MovieDto>();
    	for (Movie movie: movieRepository.findAll()) {
    		movies.add(mapToDto(movie));
    	}
    	
    	return movies;
    }
    
    public ArrayList<MovieDto> fetchTopMovies(int max) {
    	ArrayList<MovieDto> movieDtos = new ArrayList<MovieDto>();
    	
    	movieRepository.findAll().stream()
			.filter(movie -> movie.getRatingCount() != null)
			.filter(movie -> movie.getRatingCount() > 100_000)
			.sorted(new Comparator() {
				@Override
				public int compare(Object o1, Object o2) {
					return -((Movie) o1).getRating().compareTo(((Movie) o2).getRating());
				}
			})
			.limit(max)
    		.forEach(e -> movieDtos.add(mapToDto((Movie) e)));
    	
    	return movieDtos;
    }
    
    public ArrayList<MovieDto> fetchTheaterMovies(int max) {
    	ArrayList<MovieDto> movieDtos = new ArrayList<MovieDto>();
    	
    	movieRepository.findAll().stream()
			.filter(movie -> movie.isInTheater())
			.limit(max)
    		.forEach(e -> movieDtos.add(mapToDto((Movie) e)));
    	
    	return movieDtos;
    }
    
    public MovieDto getMovie(Long id) {
    	Movie movie = movieRepository.findById(id);
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

