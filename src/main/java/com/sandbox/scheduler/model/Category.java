package com.sandbox.scheduler.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Category {
	RED(1), GREEN(2), BLUE(3);

	private int value;

	public int getValue() {
		return value;
	}

	private Category(int value) {
		this.value = value;
	}

	private static final List<Category> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	public static Category randomLetter() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
