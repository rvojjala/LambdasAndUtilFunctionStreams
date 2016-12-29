package com.udr013;


public class Album {

	private String artist;
	private String title;
	private int year;

	public Album(String title, String artist, int year) {
		this.title = title;
		this.artist = artist;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Album{" +
				"artist='" + artist + '\'' +
				", title='" + title + '\'' +
				", year=" + year +
				'}';
	}
}
