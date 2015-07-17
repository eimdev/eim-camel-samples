package com.altisource.fcbk.domain;

import java.util.Date;

/**
 * @author balamuruganm
 * 
 */
public class Payment {

	private Date paidToDate;
	private Date nextDueDate;
	private Double PITI;
	private Double unpaindPrincipalBalance;


	/**
	 * @return the paidToDate
	 */
	public Date getPaidToDate() {
		return paidToDate;
	}


	/**
	 * @param paidToDate
	 *            the paidToDate to set
	 */
	public void setPaidToDate(Date paidToDate) {
		this.paidToDate = paidToDate;
	}


	/**
	 * @return the nextDueDate
	 */
	public Date getNextDueDate() {
		return nextDueDate;
	}


	/**
	 * @param nextDueDate
	 *            the nextDueDate to set
	 */
	public void setNextDueDate(Date nextDueDate) {
		this.nextDueDate = nextDueDate;
	}


	/**
	 * @return the pITI
	 */
	public Double getPITI() {
		return PITI;
	}


	/**
	 * @param pITI
	 *            the pITI to set
	 */
	public void setPITI(Double pITI) {
		PITI = pITI;
	}


	/**
	 * @return the unpaindPrincipalBalance
	 */
	public Double getUnpaindPrincipalBalance() {
		return unpaindPrincipalBalance;
	}


	/**
	 * @param unpaindPrincipalBalance
	 *            the unpaindPrincipalBalance to set
	 */
	public void setUnpaindPrincipalBalance(Double unpaindPrincipalBalance) {
		this.unpaindPrincipalBalance = unpaindPrincipalBalance;
	}

}
