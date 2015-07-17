package com.altisource.fcbk.domain;

/**
 * @author balamuruganm
 * 
 */
public class Contact {

	private String firstName;
	private String lastName;
	private String homePhoneNumber;
	private String businessPhoneNumber;
	private String emailAddress;

	private Address address;


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the homePhoneNumber
	 */
	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}


	/**
	 * @param homePhoneNumber
	 *            the homePhoneNumber to set
	 */
	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}


	/**
	 * @return the businessPhoneNumber
	 */
	public String getBusinessPhoneNumber() {
		return businessPhoneNumber;
	}


	/**
	 * @param businessPhoneNumber
	 *            the businessPhoneNumber to set
	 */
	public void setBusinessPhoneNumber(String businessPhoneNumber) {
		this.businessPhoneNumber = businessPhoneNumber;
	}


	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}


	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}


	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

}
