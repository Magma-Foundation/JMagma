package com.meti;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IfTokenizerTest {

    @Test
    void tokenize() {
        Node expected = new If_(new ContentNode("true"), new ContentNode("{}"));
        Node actual = new IfTokenizer("if(true){}")
                .tokenize()
                .orElseThrow();
        assertEquals(expected, actual);
    }
}