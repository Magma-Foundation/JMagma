package com.meti.compile.token;

import com.meti.core.F1;
import com.meti.core.F1E1;

import java.util.stream.Stream;

public interface Input {
	char apply(int i);

	int firstChar(char c);

	String format(String format);

	boolean is(String name);

	<T> T map(F1<String, T> peeker);

	int size();

	Input slice(int from);

	Input slice(int from, int to);

	Stream<Character> stream();

	<E extends Exception> boolean test(F1E1<String, Boolean, E> predicate) throws E;
}
