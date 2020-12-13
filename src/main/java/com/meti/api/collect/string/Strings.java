package com.meti.api.collect.string;

import com.meti.api.collect.list.ArrayList;
import com.meti.api.collect.stream.StreamException;
import com.meti.api.core.FormatException;
import com.meti.api.core.Option;
import com.meti.api.core.Primitives;
import com.meti.api.extern.Function1;

import static com.meti.api.collect.stream.SequenceStream.SequenceStream;
import static com.meti.api.collect.string.SimpleStringBuffer.StringBuffer;
import static com.meti.api.core.FormatException.FormatException;
import static com.meti.api.core.None.None;
import static com.meti.api.core.Some.Some;

public class Strings {
	public Strings() {
	}

	@Deprecated
	public static int indexOfChar(CharSequence self, char c) {
		for (int i = 0; i < self.length(); i++) {
			if (self.charAt(i) == c) {
				return i;
			}
		}
		return -1;
	}

	public static String slice(String self, int from, int to) {
		try {
			var list = ArrayList.range(from, to, Primitives::comparingInts, i -> i + 1);
			return SequenceStream(list)
					.map(self::charAt)
					.foldLeftExceptionally(StringBuffer(), StringBuffer::add)
					.toString();
		} catch (StreamException e) {
			return "";
		}
	}

	public static Option<Integer> firstIndexOf(String self, Function1<Character, Boolean> predicate) {
		for (int i = 0; i < self.length(); i++) {
			if (predicate.apply(self.charAt(i))) {
				return Some(i);
			}
		}
		return None();
	}

	public static Option<Integer> lastIndex(String self, Function1<Character, Boolean> predicate) {
		for (int i = self.length() - 1; i >= 0; i--) {
			if (predicate.apply(self.charAt(i))) {
				return Some(i);
			}
		}
		return None();
	}

	public static String trim(String self) {
		var first = firstIndexOf(self, Primitives::isWhitespace).orElse(0);
		var last = lastIndex(self, Character::isWhitespace).orElse(self.length());
		return slice(self, first, last);
	}

	public static long hash(CharSequence self) {
		long value = 0;
		for (int i = 0; i < self.length(); i++) {
			value += Primitives.hash(self.charAt(i));
		}
		return value;
	}

	public static int length(String self) {
		return self.length();
	}

	public static boolean equals(String self, String other) {
		return compareTo(self, other) == 0;
	}

	public static String concat(String self, String other) {
		return self + other;
	}

	public static int compareTo(String self, String other) {
		var lengthDelta = self.length() - other.length();
		var charDelta = 0;
		var minLength = Math.min(self.length(), other.length());
		for (int i = 0; i < minLength; i++) {
			charDelta += self.charAt(i) - other.charAt(i);
		}
		return lengthDelta + charDelta;
	}

	public static int asInt(String value) throws FormatException {
		if (value.length() == 0) throw FormatException("Value is blank.");
		if (value.charAt(0) == '-') return -asInt(slice(value, 1, value.length()));
		var last = value.charAt(value.length() - 1);
		if (Primitives.isDigit(last)) {
			var slice = slice(value, 0, value.length() - 1);
			var parent = (slice.length() == 0) ? 0 : asInt(slice) * 10;
			return parent + Primitives.asDigit(last);
		}
		throw FormatException("Not an integer: " + value);
	}

	public static String valueOfInt(int value) {
		if (value == 0) return "0";
		if (value < 0) return "-" + valueOfInt(-value);
		else {
			var parent = value / 10;
			var parentString = (parent == 0) ? "" : valueOfInt(parent);
			var digit = value % 10;
			var digitChar = '0' + digit;
			return parentString + (char) digitChar;
		}
	}

	public static boolean isBlank(String self) {
		for (int i = 0; i < self.length(); i++) {
			if (!Primitives.isWhitespace(self.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isContent(String self) {
		return !isBlank(self);
	}
}
