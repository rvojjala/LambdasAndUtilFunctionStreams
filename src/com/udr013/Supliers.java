package com.udr013;


import java.util.Random;
import java.util.function.Supplier;

public class Supliers {

	public static void main(String[] args) {

		Random random = new Random();

		Supplier supplier = () -> random.nextInt();
		System.out.println(random.nextInt());
	}
}
