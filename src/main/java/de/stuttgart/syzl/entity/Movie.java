package de.stuttgart.syzl.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="movies")
@Data
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long movieId;

    private boolean netflix;
    private boolean prime;
    private boolean youtube;
    private boolean imdb;

    //imdb top250Movies values
    private String id;
    private String rank;
    private String title;
    private String fullTitle;
    private String year;
    private String image;
    private String crew;
    private String imDbRating;
    private String imDbRatingCount;

    //imdb mostPopularMovie
    public String rankUpDown;
}
