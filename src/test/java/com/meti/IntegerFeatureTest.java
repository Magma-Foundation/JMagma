package com.meti;

import org.junit.jupiter.api.Test;

import static com.meti.MagmaAssertions.assertCompile;

class IntegerFeatureTest {
	@Test
	void positive() throws CompileException {
		assertCompile("420", "420");
	}
}