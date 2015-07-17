package com.altisource.fcbk.domain;

/**
 * @author balamuruganm
 * 
 */
public class Collateral {

	private Property property;


	/**
	 * @return the property
	 */
	public Property getProperty() {
		if (property == null) {
			property = new Property();
		}
		return property;
	}


	/**
	 * @param property
	 *            the property to set
	 */
	public void setProperty(Property property) {
		this.property = property;
	}

}
