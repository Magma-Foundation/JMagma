package com.meti;

public class MagmaResolver {
	public static MagmaResolver MagmaResolver_ = new MagmaResolver();

	public MagmaResolver() {
	}

	Token resolve(State state) throws ResolutionException {
		try {
			if (Tokens.is(state.getCurrent(), Token.Type.Integer)) {
				return IntegerType.signed(16);
			}
			throw new ResolutionException("Cannot resolve: " + state.getCurrent());
		} catch (AttributeException e) {
			throw new ResolutionException(e);
		}
	}
}