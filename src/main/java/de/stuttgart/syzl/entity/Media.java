package de.stuttgart.syzl.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import de.stuttgart.syzl.movieEnum.Genre;

@MappedSuperclass
public abstract class Media {
	
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;
	protected String sourceId;
	protected String fullTitle;
	protected String shortTitle;
	protected String ranking;
	protected int year;
	protected String image;
	protected String crew;
	protected String rating;
	protected Long ratingCount;
	protected Long trailerId;
    protected String plot;
    protected ArrayList<Genre> genre;
   
    public String getFullTitle () {
    	return this.fullTitle;
    }

	public String getShortTitle() {
		return shortTitle;
	}

	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String rank) {
		this.ranking = rank;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Long getRatingCount() {
		return ratingCount;
	}

	public void setRatingCount(Long ratingCount) {
		this.ratingCount = ratingCount;
	}

	public Long getTrailerId() {
		return trailerId;
	}

	public void setTrailerId(Long trailerId) {
		this.trailerId = trailerId;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public ArrayList<Genre> getGenre() {
		return genre;
	}

	public void setGenre(ArrayList<Genre> genre) {
		this.genre = genre;
	}

	public void setFullTitle(String fullTitle) {
		this.fullTitle = fullTitle;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
    
}
