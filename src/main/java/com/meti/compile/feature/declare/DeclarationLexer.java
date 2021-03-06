package com.meti.compile.feature.declare;

import com.meti.compile.lex.LexException;
import com.meti.compile.lex.Lexer;
import com.meti.compile.token.Field;
import com.meti.compile.token.Input;
import com.meti.compile.token.Token;

import java.util.Optional;

import static com.meti.compile.token.FieldLexer.FieldLexer_;

public class DeclarationLexer implements Lexer<Token> {
	public static final Lexer<Token> DeclarationLexer_ = new DeclarationLexer();

	public DeclarationLexer() {
	}

	@Override
	public Optional<Token> lex(Input input) throws LexException {
		return FieldLexer_.lex(input)
				.filter(this::isDeclaration)
				.map(Declaration::new);
	}

	private boolean isDeclaration(Field identity) {
		return identity.isFlagged(Field.Flag.CONST) || identity.isFlagged(Field.Flag.LET);
	}
}
