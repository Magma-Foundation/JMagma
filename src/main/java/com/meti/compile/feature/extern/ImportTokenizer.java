package com.meti.compile.feature.extern;

import com.meti.compile.ListScript;
import com.meti.compile.feature.Node;
import com.meti.compile.feature.Tokenizer;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.meti.compile.feature.extern.Import.Import;

public class ImportTokenizer implements Tokenizer<Node> {
	public static final Tokenizer<Node> ImportTokenizer_ = new ImportTokenizer();

	private ImportTokenizer() {
	}

	@Override
	public Optional<Node> tokenize(String content) {
		if (content.startsWith("import native ")) {
			var slice = content.substring("import native ".length());
			var trim = slice.trim();
			return Optional.of(Directive.Include.toNode("<" + trim + ".h>"));
		}
		if (content.startsWith("import ")) {
			var slice = content.substring(7);
			var packageString = slice.trim();
			var scriptArgs = Arrays.stream(packageString.split("\\."))
					.filter(s -> !s.isBlank())
					.map(String::trim)
					.collect(Collectors.toList());
			var parent = scriptArgs.subList(0, scriptArgs.size() - 1);
			var name = scriptArgs.get(scriptArgs.size() - 1);
			return Optional.of(Import(new ListScript(parent, name)));
		}
		return Optional.empty();
	}
}
