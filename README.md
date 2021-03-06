# java-generic-validator
A general purpose validator that can be used by other projects

Example Usage: **Threshold Validation**
```java
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
		return new Threshold(value);
	}
}
```
```java
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
```
```java
ValidationRule<Threshold> rule = ThresholdValidationRule.of(.75);
boolean result1 = rule.isValid(Threshold.of(.32));
boolean result2 = rule.isValid(Threshold.of(.77));
```
