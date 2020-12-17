package com.meti.compile;

import java.util.Optional;

public interface Tokenizer {
	Optional<String> tokenizeToString(String content);

	Optional<Node> tokenize(String content);
}
