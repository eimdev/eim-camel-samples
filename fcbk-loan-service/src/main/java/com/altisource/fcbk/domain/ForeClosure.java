package com.altisource.fcbk.domain;

import java.util.Date;

/**
 * @author balamuruganm
 * 
 */
public class ForeClosure {

	private String foreClosureId;
	private Boolean isSaleDateConfirmed;
	private Date saleConfirmedDate;
	private Date foreClosureStartDate;
	private String foreClosureStatus;
	private String foreClosureType;
	private String holdDescription;
	private Boolean isAcquiredInFC;


	/**
	 * @return the foreClosureId
	 */
	public String getForeClosureId() {
		return foreClosureId;
	}


	/**
	 * @param foreClosureId
	 *            the foreClosureId to set
	 */
	public void setForeClosureId(String foreClosureId) {
		this.foreClosureId = foreClosureId;
	}


	/**
	 * @return the isSaleDateConfirmed
	 */
	public Boolean getIsSaleDateConfirmed() {
		return isSaleDateConfirmed;
	}


	/**
	 * @param isSaleDateConfirmed
	 *            the isSaleDateConfirmed to set
	 */
	public void setIsSaleDateConfirmed(Boolean isSaleDateConfirmed) {
		this.isSaleDateConfirmed = isSaleDateConfirmed;
	}


	/**
	 * @return the saleConfirmedDate
	 */
	public Date getSaleConfirmedDate() {
		return saleConfirmedDate;
	}


	/**
	 * @param saleConfirmedDate
	 *            the saleConfirmedDate to set
	 */
	public void setSaleConfirmedDate(Date saleConfirmedDate) {
		this.saleConfirmedDate = saleConfirmedDate;
	}


	/**
	 * @return the foreClosureStartDate
	 */
	public Date getForeClosureStartDate() {
		return foreClosureStartDate;
	}


	/**
	 * @param foreClosureStartDate
	 *            the foreClosureStartDate to set
	 */
	public void setForeClosureStartDate(Date foreClosureStartDate) {
		this.foreClosureStartDate = foreClosureStartDate;
	}


	/**
	 * @return the foreClosureStatus
	 */
	public String getForeClosureStatus() {
		return foreClosureStatus;
	}


	/**
	 * @param foreClosureStatus
	 *            the foreClosureStatus to set
	 */
	public void setForeClosureStatus(String foreClosureStatus) {
		this.foreClosureStatus = foreClosureStatus;
	}


	/**
	 * @return the foreClosureType
	 */
	public String getForeClosureType() {
		return foreClosureType;
	}


	/**
	 * @param foreClosureType
	 *            the foreClosureType to set
	 */
	public void setForeClosureType(String foreClosureType) {
		this.foreClosureType = foreClosureType;
	}


	/**
	 * @return the holdDescription
	 */
	public String getHoldDescription() {
		return holdDescription;
	}


	/**
	 * @param holdDescription
	 *            the holdDescription to set
	 */
	public void setHoldDescription(String holdDescription) {
		this.holdDescription = holdDescription;
	}


	/**
	 * @return the isAcquiredInFC
	 */
	public Boolean getIsAcquiredInFC() {
		return isAcquiredInFC;
	}


	/**
	 * @param isAcquiredInFC
	 *            the isAcquiredInFC to set
	 */
	public void setIsAcquiredInFC(Boolean isAcquiredInFC) {
		this.isAcquiredInFC = isAcquiredInFC;
	}

}
