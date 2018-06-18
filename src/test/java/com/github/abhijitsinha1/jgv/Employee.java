package com.github.abhijitsinha1.jgv;

public class Employee {
	private final String id;

	private Employee(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public static Employee of(String id) {
		Validator.isNotEmpty(id);
		return new Employee(id);
	}

}
