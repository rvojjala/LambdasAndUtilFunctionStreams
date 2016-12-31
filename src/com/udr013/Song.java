package com.udr013;


public class Song {

	private int track;
	private String Title;

	public Song(int track, String title) {
		this.track = track;
		Title = title;
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	@Override
	public String toString() {
		return "Song{" +
				"track=" + track +
				", Title='" + Title + '\'' +
				'}';
	}
}
