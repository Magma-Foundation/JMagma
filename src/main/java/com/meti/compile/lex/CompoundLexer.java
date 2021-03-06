package com.meti.compile.lex;

import com.meti.compile.token.Input;
import com.meti.compile.token.Token;

import java.util.List;
import java.util.Optional;

public abstract class CompoundLexer implements Lexer<Token> {
	@Override
	public Optional<Token> lex(Input input) throws LexException {
		for (Lexer<Token> lexer : listLexers()) {
			var option = lexer.lex(input);
			if (option.isPresent()) {
				return option;
			}
		}
		return Optional.empty();
	}

	public abstract List<Lexer<Token>> listLexers();
}
