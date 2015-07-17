package com.altisource.fcbk.domain;

/**
 * @author balamuruganm
 * 
 */
public enum LienPosition {

	FIRST_MORTGAGE(1, "First Mortgage"), SECOND_MORTGAGE(2, "Second Mortgage");

	private final int value;
	private final String description;

	LienPosition(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public static String getDescriptionByValue(int value) {
		for (LienPosition position : LienPosition.values()) {
			if (value == position.value)
				return position.name();
		}
		return "";
	}

	public int getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}

}
