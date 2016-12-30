package com.udr013;


import java.util.function.Consumer;

public class Consumers {

	public static void main(String[] args) {

		/*Consumer is used in forEach loop though remember it returns nothing*/

		Consumer<String> consumer = s -> s.toUpperCase();
		Consumer<String> consumer1 = s -> System.out.println(s);

		/*A consumer doesn't return anything, void so this ain't gonna work*/
//		System.out.println(consumer.accept("blabla"));

		/*We can chain them but still won't return anything*/
		consumer.andThen(consumer1).accept("blabla");
	}

}
