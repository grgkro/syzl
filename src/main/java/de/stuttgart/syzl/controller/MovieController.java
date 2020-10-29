package de.stuttgart.syzl.controller;


import de.stuttgart.syzl.service.MediaUpdateService;
import de.stuttgart.syzl.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin
@Api(tags = "Controller methods for managing Movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private MediaUpdateService updateService;


    @GetMapping("/retrieve")
    @ApiOperation(value = "Return the imdb top 250")
    public ResponseEntity getAllFilms() throws IOException {
    	return ResponseEntity.status(HttpStatus.OK).body(movieService.fetchMovies());
    }    
    
    @GetMapping("/updateDB")
    @ApiOperation(value = "Return the imdb top 250")
    public ResponseEntity fetchFilmsFromDB() throws IOException {
    	updateService.updateAllDB();
    	return ResponseEntity.status(HttpStatus.OK).body("Movie has been fetched");
    }    
    
    @GetMapping("/fetch/{id}")
    @ApiOperation(value = "Return a specific film")
    public ResponseEntity getFilm(@PathVariable String id) throws IOException {
    	return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovie(id));
    }    
    
/*

    @GetMapping("/movies/imdb/inTheaters")
    @ApiOperation(value = "Returns all movies currently in theaters (in the US) from imdb ")
    public ResponseEntity getIMBDMoviesInTheaters() throws IOException {
        List<NewMovieIMDBDto> moviesToReturn = movieServiceIMDB.getMoviesInTheatersFromIMDB();
        if (moviesToReturn != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(moviesToReturn);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The in theaters movies couldn't be downloaded from imdb.");
        }
    }

    @GetMapping("/movies/imdb/mostPopular")
    @ApiOperation(value = "Return most popular movies from imdb ")
    public ResponseEntity getMostPopularMoviesFromIMDB() throws IOException {
        List<MovieDto> moviesToReturn = movieServiceIMDB.getMostPopularMoviesFromIMDB();
        if (moviesToReturn != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(moviesToReturn);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The in theaters movies couldn't be downloaded from imdb.");
        }
    }

*/
}
