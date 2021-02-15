package com.meti;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) {
		try {
			var source = Paths.get(".", "Main.mg");
			var input = Files.readString(source);
			var target = Paths.get(".", "Main.c");
			Files.writeString(target, java.lang.Compiler.Compiler_.compile(new Input(input)).getValue());
		} catch (IOException | CompileException e) {
			e.printStackTrace();
		}
	}

}