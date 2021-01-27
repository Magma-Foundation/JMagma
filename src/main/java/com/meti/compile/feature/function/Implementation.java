package com.meti.compile.feature.function;

import com.meti.compile.token.Token;

import java.util.List;
import java.util.stream.Collectors;

record Implementation(List<String> parameters, String name,
                      Token type, String body) implements Token {
	@Override
	public String render() {
		var renderedParameters = parameters.stream().collect(Collectors.joining(",", "(", ")"));
		var renderedType = type.render();
		return "%s %s%s%s".formatted(renderedType, name, renderedParameters, body);
	}
}