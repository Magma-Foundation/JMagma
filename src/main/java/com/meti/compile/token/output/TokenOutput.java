package com.meti.compile.token.output;

import com.meti.compile.render.RenderException;
import com.meti.core.F1E1;
import com.meti.compile.token.Token;

import java.util.Objects;

import static com.meti.compile.token.output.ListOutput.ListOutput;

public class TokenOutput implements Output {
	protected final Token token;

	public TokenOutput(Token token) {
		this.token = token;
	}

	@Override
	public Output append(Output output) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String compute() throws RenderException {
		throw new RenderException("Cannot render token of: " + token);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TokenOutput that = (TokenOutput) o;
		return Objects.equals(token, that.token);
	}

	@Override
	public int hashCode() {
		return Objects.hash(token);
	}

	@Override
	public Output prepend(Output output) {
		return ListOutput()
				.append(output)
				.append(this);
	}

	@Override
	public <E extends Exception> Output replaceNode(F1E1<Token, String, E> replacer) throws E {
		return new StringOutput(replacer.apply(token));
	}

	@Override
	public String toString() {
		return "{}";
	}
}
