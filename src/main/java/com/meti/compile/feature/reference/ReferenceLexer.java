package com.meti.compile.feature.reference;

import com.meti.api.magma.core.None;
import com.meti.api.magma.core.Option;
import com.meti.api.magma.core.Some;
import com.meti.compile.feature.scope.Lexer;
import com.meti.compile.token.Content;
import com.meti.compile.token.Token;

import static com.meti.compile.MagmaLexingStage.MagmaLexingStage_;

public class ReferenceLexer implements Lexer<Token> {
	public static final ReferenceLexer ReferenceLexer_ = new ReferenceLexer();

	private ReferenceLexer() {
	}

	private boolean canLex(String content) {
		return content.startsWith("&");
	}

	@Override
	public Option<Token> lex(String content) {
		return canLex(content) ? new Some<>(lex2(content)) : new None<>();
	}

	private Token lex2(String line) {
		var slice = line.substring(1);
		var string = slice.trim();
		var node = MagmaLexingStage_.lexNode(string).render();
		return new Content("&%s".formatted(node));
	}
}