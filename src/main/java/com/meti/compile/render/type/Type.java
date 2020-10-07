package com.meti.compile.render.type;

import com.meti.compile.render.Renderable;

import java.util.function.Function;

public interface Type extends Renderable {
    <T> T transformContent(Function<String, T> transformer);

    String render(String name);

    @Override
    default String render() {
        return render("");
    }
}