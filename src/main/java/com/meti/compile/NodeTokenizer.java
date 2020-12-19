package com.meti.compile;

import com.meti.compile.feature.CompoundTokenizer;
import com.meti.compile.feature.Node;
import com.meti.compile.feature.Tokenizer;
import com.meti.compile.feature.block.BlockTokenizer;
import com.meti.compile.feature.condition.BooleanTokenizer;
import com.meti.compile.feature.condition.ConditionalTokenizer;
import com.meti.compile.feature.function.FunctionTokenizer;
import com.meti.compile.feature.function.ReturnTokenizer;

import java.util.List;

import static com.meti.compile.feature.block.BlockTokenizer.BlockTokenizer_;
import static com.meti.compile.feature.condition.BooleanTokenizer.BooleanTokenizer_;
import static com.meti.compile.feature.condition.ConditionalTokenizer.ConditionalTokenizer_;
import static com.meti.compile.feature.function.FunctionTokenizer.FunctionTokenizer_;
import static com.meti.compile.feature.function.ReturnTokenizer.ReturnTokenizer_;
import static com.meti.compile.feature.primitive.IntTokenizer.IntTokenizer_;
import static com.meti.compile.feature.scope.DeclarationTokenizer.DeclarationTokenizer_;
import static com.meti.compile.feature.struct.StructureTokenizer.StructureTokenizer_;

class NodeTokenizer extends CompoundTokenizer<Node> {
	static final NodeTokenizer NodeTokenizer_ = new NodeTokenizer();

	private NodeTokenizer() {
	}

	@Override
	protected List<Tokenizer<Node>> listChildren() {
		return List.of(
				StructureTokenizer_,
				BooleanTokenizer_,
				ConditionalTokenizer_,
				BlockTokenizer_,
				ReturnTokenizer_,
				FunctionTokenizer_,
				DeclarationTokenizer_,
				IntTokenizer_
		);
	}
}
