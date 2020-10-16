package de.stuttgart.syzl.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="movies_in_theater_imdb")
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewMovieIMDB {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
//    @OneToMany(targetEntity=KeyValueItem.class, mappedBy="keyValueItemId", fetch=FetchType.LAZY)
//    public HashMap<String, String> genreList;

    public String directors;

    @OneToMany(targetEntity=StarShort.class, mappedBy="shortStarId", fetch=FetchType.EAGER)
    public List<StarShort> directorList;
    public String stars;
    @OneToMany(targetEntity=StarShort.class, mappedBy="shortStarId", fetch=FetchType.EAGER)
    public List<StarShort> starList;
}
