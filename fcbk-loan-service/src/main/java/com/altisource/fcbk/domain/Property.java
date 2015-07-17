package com.altisource.fcbk.domain;

import java.util.Date;

/**
 * @author balamuruganm
 * 
 */
public class Property {

	private Double marketValue;
	private Date marketValuationDate;
	private String propertyType;
	private String occupancyStatus;
	private Double orgAppraisalAmount;
	private Date orgAppraisalDate;

	private Address address;


	/**
	 * @return the marketValue
	 */
	public Double getMarketValue() {
		return marketValue;
	}


	/**
	 * @param marketValue
	 *            the marketValue to set
	 */
	public void setMarketValue(Double marketValue) {
		this.marketValue = marketValue;
	}


	/**
	 * @return the marketValuationDate
	 */
	public Date getMarketValuationDate() {
		return marketValuationDate;
	}


	/**
	 * @param marketValuationDate
	 *            the marketValuationDate to set
	 */
	public void setMarketValuationDate(Date marketValuationDate) {
		this.marketValuationDate = marketValuationDate;
	}


	/**
	 * @return the propertyType
	 */
	public String getPropertyType() {
		return propertyType;
	}


	/**
	 * @param propertyType
	 *            the propertyType to set
	 */
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}


	/**
	 * @return the occupancyStatus
	 */
	public String getOccupancyStatus() {
		return occupancyStatus;
	}


	/**
	 * @param occupancyStatus
	 *            the occupancyStatus to set
	 */
	public void setOccupancyStatus(String occupancyStatus) {
		this.occupancyStatus = occupancyStatus;
	}


	/**
	 * @return the orgAppraisalAmount
	 */
	public Double getOrgAppraisalAmount() {
		return orgAppraisalAmount;
	}


	/**
	 * @param orgAppraisalAmount
	 *            the orgAppraisalAmount to set
	 */
	public void setOrgAppraisalAmount(Double orgAppraisalAmount) {
		this.orgAppraisalAmount = orgAppraisalAmount;
	}


	/**
	 * @return the orgAppraisalDate
	 */
	public Date getOrgAppraisalDate() {
		return orgAppraisalDate;
	}


	/**
	 * @param orgAppraisalDate
	 *            the orgAppraisalDate to set
	 */
	public void setOrgAppraisalDate(Date orgAppraisalDate) {
		this.orgAppraisalDate = orgAppraisalDate;
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
