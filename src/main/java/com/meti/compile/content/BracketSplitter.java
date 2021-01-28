package com.meti.compile.content;

import com.meti.api.magma.collect.stream.Stream;
import com.meti.api.magma.collect.stream.StreamException;
import com.meti.api.magma.collect.stream.Streams;

public class BracketSplitter implements Splitter {
	public static final Splitter BracketSplitter_ = new BracketSplitter();

	BracketSplitter() {
	}

	@Override
	public Stream<String> stream(String content) {
		return processAll(content)
				.advance()
				.stream()
				.filter(s -> !s.isBlank())
				.map(String::trim);
	}

	State processAll(String content) {
		try {
			return Streams.ofIntRange(0, content.length())
					.map(content::charAt)
					.fold(new JavaState(), this::process);
		} catch (StreamException e) {
			return new JavaState();
		}
	}

	State process(State state, char c) {
		if (c == '}' && state.isShallow()) {
			return state.reset().append('}').advance();
		} else if (c == ';' && state.isLevel()) {
			return state.advance();
		} else if (c == '{') {
			return state.sink().append(c);
		} else if (c == '}') {
			return state.surface().append(c);
		} else {
			return state.append(c);
		}
	}
}