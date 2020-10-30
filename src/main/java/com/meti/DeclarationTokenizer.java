package com.meti;

import java.util.Optional;

public class DeclarationTokenizer extends StringTokenizer<Node> {
    public DeclarationTokenizer(String content) {
        super(content);
    }

    @Override
    public Optional<Node> tokenize() {
        return new FieldTokenizer(content)
                .tokenize()
                .map(Declaration::new);
    }
}