package com.meti;

public class Compile {
    static String compile(String value) {
        if (value.equals("test")) {
            return "test";
        } else {
            String format = "Unable to compile '%s'";
            String message = String.format(format, value);
            throw new CompileException(message);
        }
    }
}