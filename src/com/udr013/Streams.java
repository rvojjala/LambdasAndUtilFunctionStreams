package com.udr013;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Streams {

	public static void main(String[] args) {

		List<Album> albums = new AlbumListStub().getAlbumList();

		/*now let's get the Beastie Boys Albums and sort them on year*/

		List<Album> beastieAlbums = new ArrayList<>();

		albums.forEach(album -> {
			if (album.getArtist().equals("Beastie Boys")) {
				beastieAlbums.add(album);
			}
		});

		beastieAlbums.sort(Comparator.comparingInt(Album::getYear));
		beastieAlbums.forEach(System.out::println);

		/* Let's do the same with a stream*/

		Function<Album, String> albumFunction = a -> a.getArtist().toUpperCase();

		beastieAlbums.stream()
				.filter(album -> album.getArtist().equals("Beastie Boys")) //Predicate
				.sorted(Comparator.comparingInt(Album::getYear)) //Comparator
//				.map(albumFunction) //Function ,  the result wil be the new stream
				.forEach(System.out::println);  //Consumer (not the same forEach as in the function package)

	}
}
