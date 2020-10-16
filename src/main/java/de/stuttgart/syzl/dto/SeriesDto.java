package de.stuttgart.syzl.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SeriesDto {

    private Long seriesId;

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
