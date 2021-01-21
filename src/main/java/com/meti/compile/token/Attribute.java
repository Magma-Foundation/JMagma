package com.meti.compile.token;

import java.util.List;

public interface Attribute {
	Field asField();

	List<Field> asFieldList();

	String asString();

	Token asToken();

	List<Token> asTokenList();

	enum Type {
		Field_,
		FieldList,
		Node,
		NodeList,
		Type,
		TypeList,
	}
}
