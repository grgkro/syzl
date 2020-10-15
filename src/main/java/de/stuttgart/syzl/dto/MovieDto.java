package de.stuttgart.syzl.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class MovieDto {

    private Long movieId;

    //imdb values
    private String id;
    private String imDbRating;
    private String imDbRatingCount;
    private String year;
    private String rank;
    private String image;
    private String fullTitle;
    private String title;
    private String crew;

    private String imdbId;
    private boolean netflix;
    private boolean prime;
    private boolean youtube;
    private boolean imdb;


}
