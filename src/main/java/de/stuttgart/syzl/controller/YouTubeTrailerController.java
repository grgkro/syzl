package de.stuttgart.syzl.controller;

import de.stuttgart.syzl.dto.YouTubeTrailerDto;
import de.stuttgart.syzl.service.YouTubeTrailerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api(tags = "Controller methods for managing trailers")
public class YouTubeTrailerController {

    @Autowired
    private YouTubeTrailerService youTubeTrailerService;

    @GetMapping("/imdb/trailers/{imdbId}")
    @ApiOperation(value = "Returns one YouTube Trailer URL by imdbID")
    public ResponseEntity getYouTubeTrailerURL(@PathVariable String imdbId) {
        YouTubeTrailerDto trailer = youTubeTrailerService.getURL(imdbId);
        if (trailer != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(trailer);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The youtube trailer URL couldn't be downloaded from IMDB.");
        }
    }


    
    

}
