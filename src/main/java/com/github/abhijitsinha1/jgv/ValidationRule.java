package com.github.abhijitsinha1.jgv;

public interface ValidationRule<T> {
	public boolean isValid(T t);
}
