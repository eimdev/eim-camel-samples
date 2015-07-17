package com.altisource.fcbk.domain;


/**
 * @author balamuruganm
 * 
 */
public class Borrower {

	private String agencyFlag;
	private Contact contact;


	/**
	 * @return the agencyFlag
	 */
	public String getAgencyFlag() {
		return agencyFlag;
	}


	/**
	 * @param agencyFlag
	 *            the agencyFlag to set
	 */
	public void setAgencyFlag(String agencyFlag) {
		this.agencyFlag = agencyFlag;
	}


	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}


	/**
	 * @param contact
	 *            the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
