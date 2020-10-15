package de.stuttgart.syzl.service;

import de.stuttgart.syzl.entity.Movie;
import de.stuttgart.syzl.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public void addNewMovie(Movie movie) {
        movieRepository.save(movie);
    }
}
