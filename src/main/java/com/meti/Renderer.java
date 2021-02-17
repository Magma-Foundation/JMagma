package com.meti;

import com.meti.output.Output;

import java.util.Optional;

public interface Renderer<T> {
	Optional<Output> render(T t) throws RenderException;
}
