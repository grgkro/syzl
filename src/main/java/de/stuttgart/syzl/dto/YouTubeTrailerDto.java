package de.stuttgart.syzl.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class YouTubeTrailerDto {
    public String imDbId;

    public String title;;

    public String fullTitle;

    public String type;

    public String year;

    public String videoId;

    public String videoUrl;

    public String errorMessage;
}
