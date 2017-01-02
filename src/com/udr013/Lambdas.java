package com.udr013;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambdas {

	public static void main(String[] args) {

        /* runnable example*/
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("printing from override method");
			}
		}).start();

        /*
		*  the lambda expression starts with a no args list "()" which it is able to match to the Run method,
        *  to be able to match, an interface can only have one method that needs to be implemented,
        *  FunctionalInterfaces.
        *  */
		new Thread(() ->
				System.out.println("printing from lambda runnable")).start();

		System.out.println("===============");
		//***********************************************************************************************************/

        /* Anonymo with comparator */
		List<Album> albumList = new AlbumListStub().getAlbumList();

		albumList.sort(new Comparator<Album>() {
			@Override
			public int compare(Album first, Album second) {
				return first.getArtist().compareTo(second.getArtist());
			}
		});

		for (Album a : albumList) {
			System.out.println(a);
		}

        /*lambda*/
		Collections.sort(albumList, (Album album, Album album2) -> album.getTitle().compareTo(album2.getTitle()));

		albumList.sort((Album album, Album album2) -> album.getTitle().compareTo(album2.getTitle()));

        /*because the compiler knows it's a list of type album we can leave the type out too, though for readability
		 we could specify them
          */

		albumList.sort((album, album2) -> album.getTitle().compareTo(album2.getTitle()));


        /* This can even be shortened using Comparator.comparing*/
		albumList.sort((Comparator.comparing(Album::getTitle)));

		System.out.println("===============");

		for (Album a : albumList) {
			System.out.println(a);
		}

		System.out.println("===============");
        /*the same using forEach*/
//		albumList.forEach(album -> System.out.println(album));
		albumList.forEach(System.out::println);


		//***********************************************************************************************************/
        /* our own interface*/

		String firstArtist = albumList.get(0).getArtist();
		String secondArtist = albumList.get(1).getArtist();

		/* we give it our two parameters */
		String newBla = goUpCaser(new UpperCaser() {
			@Override
			public String doUpperCaser(String string) {
				return string.toUpperCase() + "!";
			}
		}, firstArtist);

		System.out.println(newBla);


		/*notice the return keyword is needed when having more statements*/
		UpperCaser upperCasert = ((input) -> {
			String output = input.toUpperCase() + "!!";
			return output;
		});

		System.out.println(upperCasert.doUpperCaser(firstArtist));

		String test = "final";
//		test = "notfinal";

		/*create 'instance' and implement at the same time, actually more like a block statement*/
		UpperCaser upperCaser = ((input) -> input.toUpperCase() + "!!!" + test);
		/*and use it*/
		String upper = upperCaser.doUpperCaser(secondArtist);

		System.out.println(upper);
	}


	public static String goUpCaser(UpperCaser uc, String s) {
		return uc.doUpperCaser(s);
	}

}