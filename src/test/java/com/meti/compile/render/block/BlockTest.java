package com.meti.compile.render.block;

import com.meti.compile.render.FeatureTest;
import org.junit.jupiter.api.Test;

public class BlockTest extends FeatureTest {
    @Test
    void empty(){
        assertCompile("{}", "{}");
    }

    @Test
    void withChild(){
        assertCompile("{10}", "{10}");
    }

    @Test
    void withChildren(){
        assertCompile("{1020}", "{10;20}");
    }

    @Test
    void withInner(){
        assertCompile("{{}{}}", "{{}{}}");
    }
}