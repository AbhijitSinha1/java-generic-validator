package com.github.abhijitsinha1.jgv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeValidationRule implements ValidationRule<Employee> {

	private List<String> codes;

	// constructor
	// ------------------------------------------------------------------------
	private EmployeeValidationRule(List<String> codes) {
		this.codes = new ArrayList<>(codes);
	}

	// factory methods
	// ------------------------------------------------------------------------
	public static EmployeeValidationRule of(String code) {
		Validator.isNotEmpty(code);
		return new EmployeeValidationRule(Arrays.asList(code));
	}

	public static EmployeeValidationRule of(List<String> codes) {
		Validator.isNotEmpty(codes);
		return new EmployeeValidationRule(codes);
	}

	// add methods
	// ------------------------------------------------------------------------
	public void add(String code) {
		Validator.isNotEmpty(code);
		codes.add(code);
	}

	public void add(List<String> codes) {
		Validator.isNotEmpty(codes);
		codes.addAll(codes);
	}

	// overridden methods
	// ------------------------------------------------------------------------
	@Override
	public boolean isValid(Employee code) {
		return codes.contains(code.getId());
	}

}
