package com.meti.api.core;

import com.meti.api.extern.*;

public interface Option<T> {
	boolean ifPresentOrElse(Action1<T> action, Action0 otherwise);

	<R> Option<R> map(Function1<T, R> mapper);

	Option<T> filter(Function1<T, Boolean> predicate);

	<E extends Exception> T orElseThrow(Function0<E> supplier) throws E;

	T orElse(T other);

	boolean isPresent();

	boolean isEmpty();

	<E extends Exception> T orElseGet(ExceptionFunction0<T, E> supplier) throws E;
}
