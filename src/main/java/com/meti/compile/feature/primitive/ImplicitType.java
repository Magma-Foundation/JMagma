package com.meti.compile.feature.primitive;

import com.meti.compile.token.attribute.Attribute;
import com.meti.compile.token.attribute.AttributeException;
import com.meti.compile.token.Token;

public class ImplicitType implements Token {
	public static final Token ImplicitType_ = new ImplicitType();

	@Override
	public Attribute apply(Attribute.Name name) throws AttributeException {
		if (name == Attribute.Name.Type) return Token.Type.Implicit;
		throw new AttributeException();
	}
}
