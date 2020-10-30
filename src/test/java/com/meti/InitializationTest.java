package com.meti;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class InitializationTest {

    @Test
    void render() {
        Field identity = Field.Field()
                .withName("value")
                .withType(Primitive.I16)
                .complete();
        Renderable node = new Initialization(identity, new Int(BigInteger.ZERO));
        assertEquals("int value=0;", node.render());
    }
}