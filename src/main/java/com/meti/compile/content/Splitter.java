package com.meti.compile.content;

import com.meti.api.magma.collect.CollectionException;
import com.meti.api.magma.collect.Stream;

public interface Splitter {
	Stream<String> stream(String content) throws CollectionException;
}
