package com.meti.compile.scope.assign;

import com.meti.compile.Node;
import com.meti.compile.scope.vars.Variable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AssignmentTest {
    @Test
    void testEquals() {
        Node expected = createNode();
        Node actual = createNode();
        assertEquals(expected, actual);
    }

    @Test
    void is() {
        assertTrue(createNode().is(Node.Group.Assignment));
    }

    private Node createNode() {
        Node to = new Variable("to");
        Node from = new Variable("from");
        return new Assignment(to, from);
    }

    @Test
    void render() {
        assertEquals("to=from;", createNode().render());
    }
}