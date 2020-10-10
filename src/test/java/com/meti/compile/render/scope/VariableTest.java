package com.meti.compile.render.scope;

import com.meti.compile.render.FeatureTest;
import org.junit.jupiter.api.Test;

public class VariableTest extends FeatureTest {
    @Test
    void test(){
        assertCompile("{}", "{}");
    }

    @Test
    void testVariables(){
        assertCompile("{char x=10;x}", """
                {
                    const x = 10;
                    x
                }
                """);
    }

    @Test
    void throwsUndefined(){
        assertException(UndefinedException.class, "x");
    }
}
