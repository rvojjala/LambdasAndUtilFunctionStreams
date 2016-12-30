package com.udr013;


import java.util.Random;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Suppliers {

	public static void main(String[] args) {

		Random random = new Random();

		IntSupplier supplier = () -> random.nextInt(10);
		DoubleSupplier supplier2 = () -> random.nextInt(10);
		Supplier<Album> albumSupplier = () -> new AlbumListStub().getAlbumList().get(1);

		print(supplier);
		print(supplier2);
		print(albumSupplier);

	}

	private static void print(Supplier supplier) {
		System.out.println(supplier.get());
	}

	private static void print(IntSupplier supplier) {
		System.out.println(supplier.getAsInt());
	}

	private static void print(DoubleSupplier supplier) {
		System.out.println(supplier.getAsDouble());
	}
}
