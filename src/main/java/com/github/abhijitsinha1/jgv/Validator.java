package com.github.abhijitsinha1.jgv;

import java.util.Collection;

import com.github.abhijitsinha1.jgv.exception.ValidationError;

public class Validator {
	private Validator() {
		// utility class
	}

	private static void verify(boolean isTrue, String message) {
		if (!isTrue) {
			throw new ValidationError(message);
		}
	}

	public static <T extends Comparable<T>> void isEqual(T t1, T t2) {
		isEqual(t1, t2, String.format("expected %s to be equal to %s", t1, t2));
	}

	private static <T extends Comparable<T>> void isEqual(T t1, T t2, String message) {
		verify(t1.compareTo(t2) == 0, message);
	}

	public static <T extends Comparable<T>> void isGreaterThan(T t1, T t2) {
		isGreaterThan(t1, t2, String.format("expected %s to be equal to %s", t1, t2));
	}

	private static <T extends Comparable<T>> void isGreaterThan(T t1, T t2, String message) {
		verify(t1.compareTo(t2) > 0, message);
	}

	public static <T extends Comparable<T>> void isLesserThan(T t1, T t2) {
		isLesserThan(t1, t2, String.format("expected %s to be equal to %s", t1, t2));
	}

	private static <T extends Comparable<T>> void isLesserThan(T t1, T t2, String message) {
		verify(t1.compareTo(t2) < 0, message);
	}

	public static <T extends Comparable<T>> void isGreaterThanEqual(T t1, T t2) {
		isGreaterThanEqual(t1, t2, String.format("expected %s to be equal to %s", t1, t2));
	}

	private static <T extends Comparable<T>> void isGreaterThanEqual(T t1, T t2, String message) {
		verify(t1.compareTo(t2) >= 0, message);
	}

	public static <T extends Comparable<T>> void isLesserThanEqual(T t1, T t2) {
		isLesserThanEqual(t1, t2, String.format("expected %s to be equal to %s", t1, t2));
	}

	private static <T extends Comparable<T>> void isLesserThanEqual(T t1, T t2, String message) {
		verify(t1.compareTo(t2) <= 0, message);
	}

	public static void isEqual(Object t1, Object t2) {
		isEqual(t1, t2, String.format("expected %s to be equal to %s", t1, t2));
	}

	private static void isEqual(Object t1, Object t2, String message) {
		verify(t1.equals(t2), message);
	}

	public static void isNull(Object object) {
		isNull(object, String.format("expected %s to be null", object));
	}

	private static void isNull(Object object, String message) {
		verify(object == null, message);
	}

	public static void isNotNull(Object object) {
		isNotNull(object, String.format("expected %s to be non-null", object));
	}

	private static void isNotNull(Object object, String message) {
		verify(object != null, message);
	}

	public static <T> void isNotEmpty(Collection<T> collection) {
		isNotNull(collection, "collection should be not null");
		isGreaterThan(collection.size(), 0, "collection should be not empty");
	}

	public static <T> void isEmpty(Collection<T> list) {
		isNotNull(list, "collection should not be null");
		isEqual(list.size(), 0, "collection should be empty");
	}

	public static <T> void isNotEmpty(String string) {
		isNotNull(string, "string should be not null");
		isGreaterThan(string.length(), 0, "string should be not empty");
	}

	public static <T> void isEmpty(String string) {
		isNotNull(string, "string should not be null");
		isEqual(string.length(), 0, "string should be empty");
	}
}
