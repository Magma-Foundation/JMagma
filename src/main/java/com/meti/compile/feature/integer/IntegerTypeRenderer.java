package com.meti.compile.feature.integer;

import com.meti.compile.token.attribute.Attribute;
import com.meti.compile.token.attribute.AttributeException;
import com.meti.compile.feature.primitive.PrimitiveRenderer;
import com.meti.compile.render.RenderException;
import com.meti.compile.render.Renderer;
import com.meti.compile.token.Field;
import com.meti.compile.token.Token;
import com.meti.compile.token.Tokens;

public class IntegerTypeRenderer extends PrimitiveRenderer {
	public static final Renderer<Field> IntegerRenderer_ = new IntegerTypeRenderer();

	public IntegerTypeRenderer() {
	}

	@Override
	protected boolean isPrimitive(Token type) throws AttributeException {
		return Tokens.is(type, Token.Type.Integer);
	}

	@Override
	protected String computeString(Token type) throws RenderException {
		try {
			var unsigned = type.apply(Attribute.Name.Sign).computeBoolean();
			var bits = type.apply(Attribute.Name.Bits).computeInt();
			return unsigned ?
					compute(bits, "signed char", "signed int", "signed long", "signed long long") :
					compute(bits, "unsigned char", "unsigned int", "unsigned long", "unsigned long long");
		} catch (AttributeException e) {
			throw new RenderException(e);
		}
	}

	private String compute(int bits,
	                       String as8,
	                       String as16,
	                       String as32,
	                       String as64) throws RenderException {
		return switch (bits) {
			case 8 -> as8;
			case 16 -> as16;
			case 32 -> as32;
			case 64 -> as64;
			default -> throw new RenderException("Invalid bits: " + bits);
		};
	}
}
