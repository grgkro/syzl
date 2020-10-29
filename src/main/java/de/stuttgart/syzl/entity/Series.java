package de.stuttgart.syzl.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="series")
@Data
@NoArgsConstructor
public class Series extends Media {
    private int seasons;
    

	public int getSeasons() {
		return seasons;
	}

	public void setSeasons(int seasons) {
		this.seasons = seasons;
	}

    
}
