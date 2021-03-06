package com.meti.compile.app;

import com.meti.compile.parse.CompoundParser;
import com.meti.compile.parse.Parser;

import java.util.List;

import static com.meti.compile.feature.assign.AssignmentParser.AssignmentParser_;
import static com.meti.compile.feature.declare.DeclarationParser.DeclarationParser_;
import static com.meti.compile.feature.variable.VariableParser.VariableParser_;

public class MagmaParser extends CompoundParser {
	public static final Parser MagmaParser_ = new MagmaParser();

	public MagmaParser() {
	}

	@Override
	protected List<Parser> listParsers() {
		return List.of(DeclarationParser_, VariableParser_, AssignmentParser_);
	}
}
