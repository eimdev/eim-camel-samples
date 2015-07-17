package com.altisource.fcbk.domain;

/**
 * @author balamuruganm
 * 
 */
public enum InsuredType {

	AVM_INSURED("AV", "AVM Insured"),
	BORROWER_LENDER_PAID_GUARANTEED("BG", "Borrower & Lender Paid Guaranteed"),
	FHA_INSURED("FH", "FHA insured"),
	FH_COVERAGE_TERMINATED("HT", "FH Coverage Terminated"),
	INVESTOR_GUARANTEED("IG", "Investor Guaranteed"),
	INSURED_CONVENTIONAL("IN", "Insured Conventional"),
	INSURANCE_TERMINATED("IT", "Insurance Terminated"),
	RURAL_HOUSING("RH", "Rural Housing"),
	UNINSURED_CONVENTIONAL("UC", "Uninsured Conventional"),
	VA_INSURED("BG", "VA Insured");

	private final String value;
	private final String description;

	InsuredType(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public static String getDescriptionByValue(String value) {
		for (InsuredType status : InsuredType.values()) {
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
