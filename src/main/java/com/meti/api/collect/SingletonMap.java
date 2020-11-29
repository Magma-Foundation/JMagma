package com.meti.api.collect;

import com.meti.api.core.Option;

import static com.meti.api.core.Some.Some;
import static com.meti.api.collect.SingletonList.SingletonList;
import static com.meti.api.core.None.None;

public class SingletonMap<K, V> implements Map<K, V> {
	private final K key;
	private final V value;

	private SingletonMap(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public static <K, V> SingletonMap<K, V> SingletonMap(K key, V value) {
		return new SingletonMap<>(key, value);
	}

	@Override
	public Option<V> get(K key) {
		return this.key.equals(key) ? Some(value) : None();
	}

	@Override
	public List<K> orderedKeys() {
		return SingletonList(key);
	}

	@Override
	public boolean containsKey(K key) {
		return this.key.equals(key);
	}
}
