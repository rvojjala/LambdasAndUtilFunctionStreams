package com.udr013;


import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Functions {

	public static void main(String[] args) {

		List<Album> albums = new AlbumListStub().getAlbumList();

		/*function with arg Album and String returntype*/
		Function<Album, String> hexValueOfYear = (album) -> Integer.toHexString(album.getYear());
		Function<Album, String> titleToUpperCase = (album) -> album.getTitle().toUpperCase();
		Function<Album, String> titleReplaceStuff = (album) -> album.getTitle().replace('i', '*');
		Function<String, String> toUpperCase = s -> s.toUpperCase();

//		albums.forEach(album -> System.out.println(hexValueOfYear.apply(album)));
		doSomething(albums, hexValueOfYear);
		doSomething(albums, titleToUpperCase);
		doSomething(albums, titleReplaceStuff);

		/* we can chain functions also.
		 because titleReplaceStuff returns a String we need an other function that takes a String as  */
		Function chainedFunction = titleReplaceStuff.andThen(toUpperCase);

		doSomething(albums, chainedFunction);

		BiFunction<Integer, Album, String> concatStuff = (integer, album) -> {
			return album.getTitle().concat(" " + integer);
		};

		System.out.println("BiFunction result: " + concatStuff.apply((int) (Math.random() * 1000), albums.get(0)));

	}

	private static void doSomething(List<Album> albums, Function someFunction) {
		System.out.println("----- someFunction --------");
		albums.forEach(album -> System.out.println(someFunction.apply(album)));


	}
}
