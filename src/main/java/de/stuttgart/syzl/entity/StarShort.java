package de.stuttgart.syzl.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="star_short_imdb")
@Data
@NoArgsConstructor
public class StarShort {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long shortStarId;

    private String id;
    private String name;

//    @ManyToOne()
//    @JoinColumn(name = "newMoviesIMDB")
//    private NewMovieIMDB newMovieIMDB;

}
