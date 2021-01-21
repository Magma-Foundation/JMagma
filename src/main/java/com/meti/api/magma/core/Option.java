package com.meti.api.magma.core;

import com.meti.api.magma.except.Exception;

public interface Option<T> {
	<E extends Exception> void ifPresent(C1E1<T, E> actor) throws E;
}
