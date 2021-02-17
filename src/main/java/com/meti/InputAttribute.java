package com.meti;

public class InputAttribute implements Attribute {
	private final Input input;

	public InputAttribute(Input input) {
		this.input = input;
	}

	@Override
	public Input computeInput() throws AttributeException {
		return input;
	}
}
