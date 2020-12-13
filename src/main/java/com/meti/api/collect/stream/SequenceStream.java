package com.meti.api.collect.stream;

import com.meti.api.collect.IndexException;
import com.meti.api.collect.Sequence;
import com.meti.api.extern.ExceptionFunction1;

import static com.meti.api.collect.stream.EndOfStreamException.EndOfStreamException;
import static com.meti.api.collect.stream.StreamException.StreamException;

public class SequenceStream<T> extends DelegatedStream<T> {
	private final Sequence<T> sequence;
	private int counter = 0;

	private SequenceStream(Sequence<T> sequence) {
		this.sequence = sequence;
	}

	public static <T> SequenceStream<T> SequenceStream(Sequence<T> sequence) {
		return new SequenceStream<>(sequence);
	}

	@Override
	protected T get() throws StreamException {
		if (counter < sequence.size()) {
			try {
				return sequence.apply(counter++);
			} catch (IndexException e) {
				throw StreamException("Stream encountered an invalid index.");
			}
		} else {
			throw EndOfStreamException("Sequence ran out of items.");
		}
	}

	@Override
	public <E extends Exception> Stream<T> filterExceptionally(ExceptionFunction1<T, Boolean, E> predicate) throws StreamException {
		return null;
	}

	@Override
	public <R, E extends Exception> Stream<R> mapExceptionally(ExceptionFunction1<T, R, E> predicate) throws StreamException {
		return null;
	}
}
