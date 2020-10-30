package com.meti;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.meti.BracketStrategy.BracketStrategy_;
import static com.meti.ImmutableStrategyBuffer.EmptyBuffer;
import static com.meti.Node.Group.Content;

public class MagmaCompiler implements Compiler {
    static final Compiler MagmaCompiler_ = new MagmaCompiler();

    static Stream<String> split(String value) {
        return IntStream.range(0, value.length())
                .mapToObj(value::charAt)
                .reduce(EmptyBuffer, BracketStrategy_::process, (oldBuffer, newBuffer) -> newBuffer)
                .complete().trim();
    }

    @Override
    public String compile(String value) {
        return split(value)
                .map(this::tokenize)
                .map(Node::render)
                .collect(Collectors.joining());
    }

    private Node tokenize(String content) {
        return new NodeTokenizer(content)
                .tokenize()
                .orElseThrow(() -> invalidateToken(content))
                .mapByChild(this::tokenize)
                .mapByIdentity(this::tokenizeField);
    }

    private Field tokenizeField(Field field) {
        return field.mapByType(MagmaCompiler.this::tokenizeType);
    }

    private Type tokenizeType(Type type) {
        return type.is(Type.Group.Content) ? type.mapContent(String.class, MagmaCompiler.this::tokenizeTypeString) : type;
    }

    private Type tokenizeTypeString(String s) {
        return new TypeTokenizer(s)
                .tokenize()
                .orElseThrow(() -> invalidateType(s));
    }

    private IllegalArgumentException invalidateType(String s) {
        String format = "Unable to tokenize type: %s";
        String message = format.formatted(s);
        return new IllegalArgumentException(message);
    }

    private Node tokenize(Node node) {
        return node.is(Content) ? node.mapValue(String.class, this::tokenize) : node;
    }

    private IllegalArgumentException invalidateToken(String value) {
        String format = "Cannot tokenize '%s'.";
        String message = format.formatted(value);
        return new IllegalArgumentException(message);
    }

}