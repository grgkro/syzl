package de.stuttgart.syzl.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="youtube_trailers")
@Data
@NoArgsConstructor
public class YouTubeTrailer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String sourceId;
    private String title;
    private String fullTitle;
    private String year;
    private String videoId;
    private String videoUrl;
    private String errorMessage;

}
