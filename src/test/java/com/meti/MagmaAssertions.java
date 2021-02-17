package com.meti;

import com.meti.token.Input;

import static com.meti.app.MagmaCompiler.MagmaCompiler_;
import static org.junit.jupiter.api.Assertions.*;

public class MagmaAssertions {
	public MagmaAssertions() {
	}

	static void assertCompile(String expected, String source) {
		try {
			String result = compileImpl(source);
			assertEquals(expected, result);
		} catch (CompileException e) {
			fail(e);
		}
	}

	private static String compileImpl(String source) throws CompileException {
		var input = new Input(source);
		return MagmaCompiler_.compile(input);
	}

	public static void assertCompileThrows(String source) {
		assertThrows(CompileException.class, () -> compileImpl(source));
	}
}
