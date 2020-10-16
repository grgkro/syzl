package de.stuttgart.syzl.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="youtube_trailers")
@Data
@NoArgsConstructor
public class YouTubeTrailer {
    @Id
    public String imDbId;

    public String title;

    public String fullTitle;

    public String type;

    public String year;

    public String videoId;

    public String videoUrl;

    public String errorMessage;

}
