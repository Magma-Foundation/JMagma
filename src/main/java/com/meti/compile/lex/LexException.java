package com.meti.compile.lex;

import com.meti.compile.CompileException;

public class LexException extends CompileException {
	public LexException() {
	}

	public LexException(String message) {
		super(message);
	}

	public LexException(String message, Throwable cause) {
		super(message, cause);
	}

	public LexException(Throwable cause) {
		super(cause);
	}

	public LexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
