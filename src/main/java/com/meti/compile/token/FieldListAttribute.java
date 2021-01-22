package com.meti.compile.token;

import com.meti.api.java.collect.JavaList;
import com.meti.api.magma.collect.Sequence;

import java.util.List;

public record FieldListAttribute(List<Field> fields) implements Attribute {
	@Override
	public Field asField() {
		throw new UnsupportedOperationException("Not a field.");
	}

	@Override
	public Sequence<Field> asFieldList() {
		return new JavaList<>(asFieldList1());
	}

	private List<Field> asFieldList1() {
		return fields;
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
	public Sequence<Token> asTokenList() {
		return new JavaList<>(asTokenList1());
	}

	private List<Token> asTokenList1() {
		throw new UnsupportedOperationException("Not a list1 of tokens.");
	}
}