package com.meti.compile.token;

import java.util.List;

public enum GroupAttribute implements Attribute {
	Import, Structure, Implementation, Function, Block, Return, Integer, Pair, Parent, Abstraction, Primitive, Content;

	@Override
	public Field asField() {
		throw new UnsupportedOperationException("Not a field.");
	}

	@Override
	public List<Field> asFieldList() {
		throw new UnsupportedOperationException("Not a list of fields.");
	}

	@Override
	public String asString() {
		throw new UnsupportedOperationException("Not a string.");
	}

	@Override
	public Token asToken() {
		throw new UnsupportedOperationException("Not a token.");
	}

	@Override
	public List<Token> asTokenList() {
		throw new UnsupportedOperationException("Not a list of tokens.");
	}
}
