package com.meti.compile.feature.primitive;

import com.meti.api.magma.core.None;
import com.meti.api.magma.core.Option;
import com.meti.api.magma.core.Some;
import com.meti.compile.feature.scope.Lexer;
import com.meti.compile.token.Content;
import com.meti.compile.token.Token;

public class PrimitiveLexer implements Lexer<Token> {
	public static final Lexer<Token> PrimitiveLexer_ = new PrimitiveLexer();

	private PrimitiveLexer() {
	}

	private boolean canLex(String content) {
		return content.equals("I16");
	}

	@Override
	public Option<Token> lex(String content) {
		return canLex(content) ? new Some<>(lex2(content)) : new None<>();
	}

	private Token lex2(String content) {
		return new Content("int");
	}
}
