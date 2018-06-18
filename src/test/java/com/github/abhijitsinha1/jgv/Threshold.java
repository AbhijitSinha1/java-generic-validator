package com.github.abhijitsinha1.jgv;

public class Threshold {
	private final Double value;

	private Threshold(Double value) {
		this.value = value;
	}

	public Double getValue() {
		return value;
	}

	public static Threshold of(Double value) {
		Validator.isNotNull(value);
		Validator.isGreaterThan(value, 0.0);
		Validator.isLesserThanEqual(value, 1.0);
		return new Threshold(value);
	}
	
	@Override
	public String toString() {
		return String.format("[THRESHOLD:: %s]", getValue());
	}
}
