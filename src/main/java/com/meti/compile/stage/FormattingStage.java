package com.meti.compile.stage;

import com.meti.compile.Stage;
import com.meti.compile.render.process.Formatter;
import com.meti.compile.render.process.State;

public class FormattingStage implements Stage<State, State> {
    public static final Stage<State, State> FormattingStage_ = new FormattingStage();

    public FormattingStage() {
    }

    @Override
    public State apply(State value) {
        return new Formatter(value).process().orElse(value);
    }
}