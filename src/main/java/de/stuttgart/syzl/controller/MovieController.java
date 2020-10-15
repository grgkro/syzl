package de.stuttgart.syzl.controller;

import de.stuttgart.syzl.entity.Movie;
import de.stuttgart.syzl.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api(tags = "Controller methods for managing Movies")
public class MovieController {

    @Autowired
    private MovieService movieService;


    @GetMapping("/users/{userId}/movies/next/{amount}")
    @ApiOperation(value = "Return next available movies for specific user")
    public String getNextMovies(@PathVariable int userId, @PathVariable int amount) {

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
