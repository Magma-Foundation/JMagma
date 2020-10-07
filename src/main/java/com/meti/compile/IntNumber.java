package com.meti.compile;

import java.math.BigInteger;

public class IntNumber implements Tokenizer.Token  {
    private final BigInteger value;

    public IntNumber(BigInteger value) {
        this.value = value;
    }

    @Override
    public String render() {
        return value.toString();
    }
}
