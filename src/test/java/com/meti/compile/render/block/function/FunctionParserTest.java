package com.meti.compile.render.block.function;

import com.meti.compile.render.scope.Initialization;
import com.meti.compile.render.scope.Variable;
import org.junit.jupiter.api.Test;

import static com.meti.compile.render.block.Block.Block;
import static com.meti.compile.render.block.function.Function.Function;
import static com.meti.compile.render.block.function.FunctionParser.FunctionParser;
import static com.meti.compile.render.block.function.Return.Return;
import static com.meti.compile.render.block.structure.Construction.Construction;
import static com.meti.compile.render.block.structure.NamedStructureType.StructureType;
import static com.meti.compile.render.block.structure.ObjectType.ObjectType;
import static com.meti.compile.render.field.InlineField.Field;
import static com.meti.compile.render.process.InlineState.State;
import static com.meti.compile.render.process.MappedStack.Stack_;
import static com.meti.compile.render.scope.Initialization.Initialization;
import static com.meti.compile.render.scope.Variable.This;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionParserTest {

    @Test
    void validateThisKeyword() {
        var node = Function("Dummy", StructureType("Dummy"), This);
        var state = State(node, Stack_);
        var actual = FunctionParser(state)
                .process()
                .orElseThrow()
                .getValue();
        var returnType = ObjectType("Dummy");
        var value = Block(
                Initialization(Field("this", returnType), Construction()),
                Return(This)
        );
        var expected = Function("Dummy", returnType, value);
        assertEquals(expected, actual);
    }
}