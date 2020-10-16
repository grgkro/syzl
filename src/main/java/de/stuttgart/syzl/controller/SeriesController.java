package de.stuttgart.syzl.controller;

import de.stuttgart.syzl.dto.MovieDto;
import de.stuttgart.syzl.dto.SeriesDto;
import de.stuttgart.syzl.entity.Movie;
import de.stuttgart.syzl.service.MovieService;
import de.stuttgart.syzl.service.MovieServiceIMDB;
import de.stuttgart.syzl.service.SeriesServiceIMDB;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@Api(tags = "Controller methods for managing Series")
public class SeriesController {



    @Autowired
    private SeriesServiceIMDB seriesServiceIMDB;


    @GetMapping("/TVShows/imdb/top250")
    @ApiOperation(value = "Return the imdb top 250 TV shows")
    public ResponseEntity getIMBDTop250() throws IOException {
        List<SeriesDto> seriesToReturn = seriesServiceIMDB.getTop250SeriesFromIMDB();
        if (seriesToReturn != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(seriesToReturn);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The top 250 imdb TV shows couldn't be downloaded.");
        }


    }

//    @GetMapping("/users/{userId}/series/next/{amount}")
//    @ApiOperation(value = "Return next available series for specific user")
//    public String getNextMovies(@PathVariable int userId, @PathVariable int amount) throws IOException {
//
//        return "Hello";
//    }
//
//    @GetMapping("/users/{userId}/ser/liked")
//    @ApiOperation(value = "Return all liked movies for specific user")
//    public String getLiked(@PathVariable int userId) {
//
//        return "Hello";
//    }
//
//    @GetMapping("/users/{userId}/movies/disliked")
//    @ApiOperation(value = "Return all disliked movies for specific user")
//    public String getDisliked(@PathVariable int userId) {
//
//        return "Hello";
//    }
//
//    @GetMapping("/users/{userId}/movies/swipedRight")
//    @ApiOperation(value = "Return all liked movies for specific user")
//    public String getSwipedRight(@PathVariable int userId) {
//
//        return "Hello";
//    }
//
//    @GetMapping("/users/{userId}/movies/swipedLeft")
//    @ApiOperation(value = "Return all liked movies for specific user")
//    public String getSwipedLeft(@PathVariable int userId) {
//
//        return "Hello";
//    }
//
//
//
//    @PutMapping("/add/{name}")
//    @ApiOperation(value = "Return all available movies converted to DTOs")
//    public void addNewMovie(@PathVariable String name) {
//        Movie movie = new Movie();
//
//
//        movieService.addNewMovie(movie);
//    }
}
