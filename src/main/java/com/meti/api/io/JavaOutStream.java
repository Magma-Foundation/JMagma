package com.meti.api.io;

import java.io.IOException;
import java.io.OutputStream;

public class JavaOutStream implements OutStream {
    private final OutputStream outputStream;

    private JavaOutStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public static JavaOutStream OutStream(OutputStream outputStream) {
        return new JavaOutStream(outputStream);
    }

    @Override
    public OutStream write(int value) throws IOException {
        outputStream.write(value);
        return this;
    }

    @Override
    public OutStream flush() throws IOException {
        outputStream.flush();
        return this;
    }

    @Override
    public void close() throws IOException {
        outputStream.close();
    }
}