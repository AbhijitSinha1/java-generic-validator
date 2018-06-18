package com.github.abhijitsinha1.jgv;

public class ThresholdValidationRule implements ValidationRule<Threshold> {

	private final double value;

	// constructor
	// ------------------------------------------------------------------------
	private ThresholdValidationRule(double value) {
		this.value = value;
	}

	// factory method
	// ------------------------------------------------------------------------
	public static ThresholdValidationRule of(Double threshold) {
		Validator.isNotNull(threshold);
		Validator.isGreaterThan(threshold, 0.0);
		Validator.isLesserThanEqual(threshold, 1.0);
		return new ThresholdValidationRule(threshold);
	}

	// overridden method
	// ------------------------------------------------------------------------
	@Override
	public boolean isValid(Threshold threshold) {
		return threshold.getValue() > value;
	}

}
