package com.meti;

import com.meti.field.Field;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.meti.field.Field.Field;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StructureTest {
    private Field createFirst() {
        return Field()
                .withName("first")
                .withType(Primitive.U8)
                .complete();
    }

    private Field createSecond() {
        return Field()
                .withName("second")
                .withType(Primitive.I64)
                .complete();
    }

    private Node createRoot() {
        List<Field> members = List.of(createFirst(), createSecond());
        return new Structure("Wrapper", members);
    }

    @Test
    void is() {
        assertTrue(createRoot().is(Node.Group.Structure));
    }

    @Test
    void render() {
        assertEquals("struct Wrapper{unsigned char first;long long second;};", createRoot().render());
    }

    @Test
    void testEquals() {
        assertEquals(createRoot(), createRoot());
    }
}