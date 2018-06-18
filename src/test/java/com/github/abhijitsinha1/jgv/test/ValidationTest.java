package com.github.abhijitsinha1.jgv.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.github.abhijitsinha1.jgv.Threshold;
import com.github.abhijitsinha1.jgv.ThresholdValidationRule;
import com.abhijit.jrg.RandomGenerator;
import com.github.abhijitsinha1.jgv.Employee;
import com.github.abhijitsinha1.jgv.EmployeeValidationRule;
import com.github.abhijitsinha1.jgv.ValidationRule;

public class ValidationTest {

	public static void main(String[] args) {
		ValidationRule<Threshold> rule1 = ThresholdValidationRule.of(.75);
		ValidationRule<Employee> rule2 = EmployeeValidationRule
		    .of(Arrays.asList(new String[] { "EMP_001", "EMP_004", "EMP_010", "EMP_011" }));
		
		List<Threshold> list = RandomGenerator.numbers(Double.class).setMaxlimit(1.0).setMinlimit(0.0).setSize(100).build(t -> {
			return Threshold.of(t);
		});

		boolean result1 = rule1.isValid(Threshold.of(.32));
		boolean result2 = rule1.isValid(Threshold.of(.77));
		boolean result3 = rule2.isValid(Employee.of("EMP_030"));
		boolean result4 = rule2.isValid(Employee.of("EMP_001"));

		System.out.println("1:: " + result1);
		System.out.println("2:: " + result2);
		System.out.println("3:: " + result3);
		System.out.println("4:: " + result4);
		
		list.stream().filter(t -> rule1.isValid(t)).collect(Collectors.toList());
	}

}
