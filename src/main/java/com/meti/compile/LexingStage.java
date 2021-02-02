package com.meti.compile;

import com.meti.compile.token.Field;
import com.meti.compile.token.Input;
import com.meti.compile.token.Token;

public interface LexingStage {
	Field lexField(Input input);

	Token lexNode(Input input);

	Token lexType(Input input);
}
