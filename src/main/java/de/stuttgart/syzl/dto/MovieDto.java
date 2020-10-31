package de.stuttgart.syzl.dto;

import java.util.ArrayList;

import de.stuttgart.syzl.movieEnum.Genre;

public class MovieDto {

    private Long id;
    private String sourceId;
    private String fullTitle;
	private String shortTitle;
	private String ranking;
	private int year;
	private String image;
	private String crew;
	private String rating;
	private Long trailerId;
    private String plot;
    private ArrayList<Genre> genre;
    private boolean inTheater;
    private int length;
    
    public MovieDto (Long id, String sourceId, String fullTitle) {
    	this.id = id;
    	this.sourceId = sourceId;
    	this.fullTitle = fullTitle;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getFullTitle() {
		return fullTitle;
	}

	public void setFullTitle(String fullTitle) {
		this.fullTitle = fullTitle;
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

	public void setRanking(String ranking) {
		this.ranking = ranking;
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

	public boolean isInTheater() {
		return inTheater;
	}

	public void setInTheater(boolean isInTheater) {
		this.inTheater = isInTheater;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
        
    
}
