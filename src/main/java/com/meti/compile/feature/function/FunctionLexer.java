package com.meti.compile.feature.function;

import com.meti.api.java.collect.JavaLists;
import com.meti.api.magma.collect.stream.StreamException;
import com.meti.api.magma.core.None;
import com.meti.api.magma.core.Option;
import com.meti.api.magma.core.Some;
import com.meti.compile.content.ParameterSplitter;
import com.meti.compile.feature.scope.Lexer;
import com.meti.compile.token.Token;

import java.util.ArrayList;

import static com.meti.compile.MagmaLexingStage.MagmaLexingStage_;

public class FunctionLexer implements Lexer<Token> {
	public static final Lexer<Token> FunctionLexer_ = new FunctionLexer();

	private FunctionLexer() {
	}

	private boolean canLex(String content) {
		return content.startsWith("def");
	}

	@Override
	public Option<Token> lex(String content) {
		return canLex(content) ? new Some<>(lex2(content)) : new None<>();
	}

	private Token lex2(String line) {
		var paramStart = line.indexOf('(');
		var paramEnd = line.indexOf(')');
		var returnsSeparator = line.indexOf(":");
		var bodySeparator = line.indexOf("=>");
		var keysSlice = line.substring(0, paramStart);
		var keysString = keysSlice.trim();
		var space = keysString.lastIndexOf(' ');
		var nameSlice = keysString.substring(space + 1);
		var name = nameSlice.trim();
		var paramSlice = line.substring(paramStart + 1, paramEnd);
		var paramString = paramSlice.trim();
		ArrayList<String> parameters;
		try {
			parameters = ParameterSplitter.ParameterSplitter_.stream(paramString)
					.filter(s -> !s.isBlank())
					.map(String::trim)
					.map(line1 -> MagmaLexingStage_.lexField(line1).render())
					.fold(new ArrayList<>(), JavaLists::add);
		} catch (StreamException e) {
			parameters = new ArrayList<>();
		}
		var typeSlice = line.substring(returnsSeparator + 1, bodySeparator);
		var typeString = typeSlice.trim();
		Token type = MagmaLexingStage_.lexType(typeString);

		var bodySlice = line.substring(bodySeparator + 2);
		var bodyString = bodySlice.trim();
		var body = MagmaLexingStage_.lexNode(bodyString).render();
		return new Implementation(parameters, name, type, body);
	}
}