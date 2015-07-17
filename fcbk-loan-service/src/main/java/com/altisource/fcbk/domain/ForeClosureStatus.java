package com.altisource.fcbk.domain;

/**
 * @author balamuruganm
 * 
 */
public enum ForeClosureStatus {

	ACTIVE("A", "Active"), CLOSED("C", "Closed"), HOLD("H", "Hold"), STOP("S",
			"Stop");

	private final String value;
	private final String description;

	ForeClosureStatus(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public static String getDescriptionByValue(String value) {
		for (ForeClosureStatus status : ForeClosureStatus.values()) {
			if (value == status.value)
				return status.name();
		}
		return "";
	}

	public String getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}
}
