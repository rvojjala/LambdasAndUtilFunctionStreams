package com.udr013;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
//		beastieAlbums.forEach(System.out::println);


		print("---------------------------------");

		/* Let's do the same with a stream*/

		Function<Album, String> albumFunction = a -> a.getTitle().toUpperCase();

		beastieAlbums.stream()
				.peek(System.out::println)
				.sorted(Comparator.comparing(Album::getTitle).reversed())
				.peek(System.out::println)
				.map(albumFunction) //Function ,  the result wil be the new stream
				.skip(1)
				.forEach(System.out::println);  //Consumer (btw not the same forEach as java.lang.iterable)

		print("---------------------------------");

		Stream<Album> stream1 = albums.stream();
		Stream<Album> stream2 = albums.stream();
		Stream<Album> albumStream = Stream.concat(stream1, stream2);

		print(albumStream.count());
		/*stream has already been operated upon or closed, Exception in thread "main" java.lang.IllegalStateException */
//		System.out.println(albumStream.count() );

		Stream.concat(albums.stream(), albums.stream())
				.sorted(Comparator.comparingInt(Album::getYear)) //Comparator
//				.peek(System.out::println)
				.distinct()
				.map(albumFunction) //Function ,  the result wil be the new stream
				.forEach(System.out::println);

		print("---------------------------------");

		List<Album> albumsWithsongs = new ArrayList<>();
		albums.forEach(album -> {
			if (album.getSongs() != null) {
				albumsWithsongs.add(album);

			}
		});

		/*note the sort*/
		List<Song> songlist = albumsWithsongs.stream()
				.flatMap(album -> album.getSongs().subList(0, 3).stream().sorted(Comparator.comparing(Song::getTrack)))
				.peek(System.out::println)
				.sorted(Comparator.comparing(Song::getTrack))
				.collect(Collectors.toList());
		print(songlist);

		print("---------------------------------");

		/*find oldest album*/
		albums.stream()
				.reduce((album, album2) -> album.getYear() < album2.getYear() ? album : album2)
				.ifPresent(System.out::println);
	}

	public static void print(Object object) {
		System.out.println(object);


	}


}
