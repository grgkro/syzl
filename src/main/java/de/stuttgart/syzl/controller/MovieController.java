package de.stuttgart.syzl.controller;

import de.stuttgart.syzl.dto.MovieDto;
import de.stuttgart.syzl.dto.NewMovieIMDBDto;
import de.stuttgart.syzl.entity.Movie;
import de.stuttgart.syzl.service.MovieService;
import de.stuttgart.syzl.service.MovieServiceIMDB;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@Api(tags = "Controller methods for managing Movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieServiceIMDB movieServiceIMDB;


    @GetMapping("/movies/imdb/top250")
    @ApiOperation(value = "Return the imdb top 250")
    public ResponseEntity getIMBDTop250() throws IOException {
        List<MovieDto> moviesToReturn = movieServiceIMDB.getTop250MoviesFromIMDB();
        if (moviesToReturn != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(moviesToReturn);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The top 250 imdb movies couldn't be downloaded from imdb.");
        }
    }

    @GetMapping("/movies/imdb/inTheaters")
    @ApiOperation(value = "Return in theaters movies from imdb ")
    public ResponseEntity getIMBDMoviesInTheaters() throws IOException {
        List<NewMovieIMDBDto> moviesToReturn = movieServiceIMDB.getMoviesInTheatersFromIMDB();
        if (moviesToReturn != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(moviesToReturn);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The in theaters movies couldn't be downloaded from imdb.");
        }
    }

    @GetMapping("/movies/imdb/mostPopular")
    @ApiOperation(value = "Return in theaters movies from imdb ")
    public ResponseEntity getMostPopularMoviesFromIMDB() throws IOException {
        List<MovieDto> moviesToReturn = movieServiceIMDB.getMostPopularMoviesFromIMDB();
        if (moviesToReturn != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(moviesToReturn);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The in theaters movies couldn't be downloaded from imdb.");
        }
    }


    @GetMapping("/users/{userId}/movies/next/{amount}")
    @ApiOperation(value = "Return next available movies for specific user")
    public String getNextMovies(@PathVariable int userId, @PathVariable int amount) throws IOException {

        return "Hello";
    }

    @GetMapping("/users/{userId}/movies/liked")
    @ApiOperation(value = "Return all liked movies for specific user")
    public String getLiked(@PathVariable int userId) {

        return "Hello";
    }

    @GetMapping("/users/{userId}/movies/disliked")
    @ApiOperation(value = "Return all disliked movies for specific user")
    public String getDisliked(@PathVariable int userId) {

        return "Hello";
    }

    @GetMapping("/users/{userId}/movies/swipedRight")
    @ApiOperation(value = "Return all liked movies for specific user")
    public String getSwipedRight(@PathVariable int userId) {

        return "Hello";
    }

    @GetMapping("/users/{userId}/movies/swipedLeft")
    @ApiOperation(value = "Return all liked movies for specific user")
    public String getSwipedLeft(@PathVariable int userId) {

        return "Hello";
    }



    @PutMapping("/add/{name}")
    @ApiOperation(value = "Return all available movies converted to DTOs")
    public void addNewMovie(@PathVariable String name) {
        Movie movie = new Movie();


        movieService.addNewMovie(movie);
    }
}
