package com.udr013;


import java.util.ArrayList;
import java.util.List;

public class AlbumListStub {

	private List<Album>albumList = new ArrayList<>();

	public AlbumListStub() {

		Album album1 = new Album("Paul's Boutique","Beastie Boys",1989);
		Album album2 = new Album("Rainbow Bridge","Jimi Hendrix",1968);
		Album album3 = new Album("Kind of Blue","Miles Davis", 1959);
		Album album4 = new Album("Dark side of the Moon","Pink Floyd", 1973);
		Album album5 = new Album("Licensed to Ill","Beastie Boys", 1986);


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
