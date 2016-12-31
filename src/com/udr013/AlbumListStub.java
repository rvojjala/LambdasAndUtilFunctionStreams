package com.udr013;


import java.util.ArrayList;
import java.util.List;

public class AlbumListStub {

	private List<Album> albumList = new ArrayList<>();

	public AlbumListStub() {

		Album album1 = new Album("Paul's Boutique", "Beastie Boys", 1989);
		Album album2 = new Album("Rainbow Bridge", "Jimi Hendrix", 1968);
		Album album3 = new Album("Kind of Blue", "Miles Davis", 1959);
		Album album4 = new Album("Dark side of the Moon", "Pink Floyd", 1973);
		Album album5 = new Album("Licensed to Ill", "Beastie Boys", 1986);

		List<Song> paul = new ArrayList<>();
		paul.add(0, new Song(1, "To All The Girls"));
		paul.add(1, new Song(2, "Shake Your Rump"));
		paul.add(2, new Song(3, "Johnny Ryall"));
		paul.add(3, new Song(4, "Egg Man"));

		List<Song> rain = new ArrayList<>();
		rain.add(0, new Song(1, "Dolly Dagger"));
		rain.add(1, new Song(2, "Earth Blues"));
		rain.add(2, new Song(3, "Pali Gap"));
		rain.add(3, new Song(4, "Room Full Of Mirrors"));

		album1.setSongs(paul);
		album2.setSongs(rain);

		albumList.add(album1);
		albumList.add(album2);
		albumList.add(album3);
		albumList.add(album4);
		albumList.add(album5);
	}

	public List<Album> getAlbumList() {
		return albumList;
	}

	public void setAlbumList(List<Album> albumList) {
		this.albumList = albumList;
	}
}
