package com.meti.compile;

import com.meti.compile.feature.Node;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static com.meti.compile.TokenizationException.TokenizationException;
import static com.meti.compile.TokenizationStage.TokenizationStage_;

public class Compiler {
	String compile(String content) throws CompileException {
		var list = new ArrayList<String>();
		var buffer = new StringBuilder();
		var depth = 0;
		for (int i = 0; i < content.length(); i++) {
			var c = content.charAt(i);
			if (c == '}' && depth == 1) {
				buffer.append('}');
				depth--;
				list.add(buffer.toString());
				buffer = new StringBuilder();
			} else if (c == ';' && depth == 0) {
				list.add(buffer.toString());
				buffer = new StringBuilder();
			} else {
				if (c == '{') {
					depth++;
				} else if (c == '}') {
					depth--;
				}
				buffer.append(c);
			}
		}
		list.add(buffer.toString());
		list.removeIf(String::isBlank);
		var nodes = new ArrayList<Node>();
		for (String s : list) {
			nodes.add(TokenizationStage_.apply(s));
		}
		if (nodes.isEmpty()) throw TokenizationException("No nodes were found.");
		return nodes.stream()
				.map(Node::render)
				.collect(Collectors.joining());
	}
}