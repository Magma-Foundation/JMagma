package com.meti.api.core;

import com.meti.api.extern.*;

public interface Option<T> {
	boolean ifPresentOrElse(Action1<T> action, Action0 otherwise);

	<R, E extends Exception> Option<R> map(ExceptionFunction1<T, R, E> mapper) throws E;

	Option<T> filter(Function1<T, Boolean> predicate);

	<E extends Exception> T orElseThrow(Function0<E> supplier) throws E;

	T orElse(T other);

	boolean isPresent();

	boolean isEmpty();

	<E extends Exception> T orElseGet(ExceptionFunction0<T, E> supplier) throws E;

	<R> Option<R> flatMap(Function1<T, Option<R>> mapper);
}
