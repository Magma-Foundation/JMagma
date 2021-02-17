package com.meti;

import java.util.List;

import static com.meti.IntegerTypeLexer.IntegerTypeLexer_;

public class MagmaTypeLexer extends CompoundLexer {
	public static final Lexer<Token> MagmaTypeLexer_ = new MagmaTypeLexer();

	@Override
	public List<Lexer<Token>> listLexers() {
		return List.of(IntegerTypeLexer_);
	}
}