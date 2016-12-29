package com.udr013;


import java.util.List;
import java.util.function.Function;

public class Functions {

	public static void main(String[] args) {

		List<Album> albums = new AlbumListStub().getAlbumList();

		/*function with arg Album and String returntype*/
		Function<Album , String> hexValueOfYear =(album) -> Integer.toHexString(album.getYear());
		Function<Album , String> titleToUpperCase =(album) -> album.getTitle().toUpperCase();
		Function<Album , String> titleReplaceStuff =(album) -> album.getTitle().replace('i','*');

//		albums.forEach(album -> System.out.println(hexValueOfYear.apply(album)));
		doSomething(albums, hexValueOfYear);
		doSomething(albums, titleToUpperCase);
		doSomething(albums, titleReplaceStuff);


	}

	public static void doSomething(List<Album> albums, Function<Album, String> someFunction){
		System.out.println("----- someFunction --------");
		albums.forEach(album -> System.out.println(someFunction.apply(album)));


	}
}
