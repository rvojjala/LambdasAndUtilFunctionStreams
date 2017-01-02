package com.udr013;


import java.util.function.Consumer;

public class Consumers {

	public static void main(String[] args) {

		/*forEach loop needs a Consumer */
		Consumer<String> consumer = s -> s.toUpperCase();
		/*or use method Reference*/
		Consumer<String> consumer1 = String::toUpperCase;

		Consumer<String> consumer2 = s -> System.out.println(s);
		/*or use method Reference*/
		Consumer<String> consumer3 = System.out::println;

		/*A consumer doesn't return anything, void so this ain't gonna work*/
//		System.out.println(consumer.accept("blabla"));

		/*We can chain them but still won't return anything*/
		consumer.andThen(consumer1).accept("blabla");
	}

}
