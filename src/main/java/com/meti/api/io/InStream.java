package com.meti.api.io;

import java.io.IOException;

public interface InStream extends Closeable<InStream> {
	int EndOfFile = -1;

	int read() throws IOException;
}
