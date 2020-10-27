package de.stuttgart.syzl.entity;

import lombok.Data;


import javax.persistence.*;

@Entity
@Table(name="movies")
@Data
public class Movie extends Media {

    private String rankUpDown;
    private boolean isInTheater;
    private int length;
    
    public Movie () {}
    
    
	public String getRankUpDown() {
		return rankUpDown;
	}

	public void setRankUpDown(String rankUpDown) {
		this.rankUpDown = rankUpDown;
	}

	public boolean isInTheater() {
		return isInTheater;
	}

	public void setInTheater(boolean isInTheater) {
		this.isInTheater = isInTheater;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
    
    
}
