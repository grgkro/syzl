package de.stuttgart.syzl.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
public class NewMovieIMDBDto {

    private Long newMovieId;

    public String id;
    public String title;
    public String fullTitle;
    public String year;
    public String releaseState;
    public String image;
    public String runtimeMins;
    public String runtimeStr;
    public String plot;
    public String contentRating;
    public String iMDbRating;
    public String iMDbRatingCount;
    public String metacriticRating;
    public String genres;
//    public List<KeyValueItem> GenreList { get; set; }
    public String Directors;
//    public List<StarShort> DirectorList { get; set; }
    public String Stars;
//    public List<StarShort> StarList { get; set; }
}
