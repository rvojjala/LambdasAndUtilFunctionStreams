
package com.udr013;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface MoreFunction<T, U, V, R> {

	/**
	 * Applies this function to the given arguments.
	 *
	 * @param t the first function argument
	 * @param u the second function argument
	 * @return the function result
	 */
	R apply(T t, U u, V v);

	/**
	 * Returns a composed function that first applies this function to
	 * its input, and then applies the {@code after} function to the result.
	 * If evaluation of either function throws an exception, it is relayed to
	 * the caller of the composed function.
	 *
	 * @param <X> the type of output of the {@code after} function, and of the
	 *           composed function
	 * @param after the function to apply after this function is applied
	 * @return a composed function that first applies this function and then
	 * applies the {@code after} function
	 * @throws NullPointerException if after is null
	 */
	default <X> MoreFunction<T, U, V, X> andThen(Function<? super R, ? extends X> after) {
		Objects.requireNonNull(after);
		return (T t, U u, V v) -> after.apply(apply(t, u, v));
	}
}
