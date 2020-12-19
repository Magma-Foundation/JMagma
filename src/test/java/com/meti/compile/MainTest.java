package com.meti.compile;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
	private final Path input = Paths.get("Main.mg");
	private final Path output = Paths.get("Main.exe");

	@BeforeEach
	void setUp() throws IOException {
		Files.deleteIfExists(input);
		Files.deleteIfExists(output);
		Files.createFile(input);
		Files.writeString(input, "def main() : I16 => {return 0}");
	}

	@AfterEach
	void tearDown() throws IOException {
		Files.delete(input);
		Files.delete(output);
	}

	@Test
	void main() throws IOException {
		Main.main(new String[0]);
		assertTrue(Files.exists(output));
		var builder = new ProcessBuilder("Main");
		var output = builder.start();
		var buffer = new ByteArrayOutputStream();
		output.getErrorStream().transferTo(buffer);
		var asString = buffer.toString();
		assertTrue(asString.isBlank());
	}
}