package com.altisource.fcbk.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.altisource.fcbk.util.EIMUtil;

/**
 * @author balamuruganm
 * 
 */
public class Loan {

	private String loanNumber;
	private Date acquisitionDate;
	private String insuredType;
	private String investorId;
	private String investorLoanNumber;
	private Double lateCharge;
	private String coordinatorFirstName;
	private String coordinatorLastName;
	private Date loanOriginationDate;
	private String loanType;
	private String miCertificationNo;
	private String miCompany;
	private Double miPercent;
	private String orgLoanAmount;
	private Date demandLetterExpiryDate;
	private Date demandLetterPrintDate;
	private Date demandLetterRequestDate;
	private String lienPosition;

	private List<Borrower> borrowers;
	private ForeClosure foreClosure;
	private Collateral collateral;
	private Payment payment;


	/**
	 * @return the loanNumber
	 */
	public String getLoanNumber() {
		return loanNumber;
	}


	/**
	 * @param loanNumber
	 *            the loanNumber to set
	 */
	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}


	/**
	 * @return the acquisitionDate
	 */
	public Date getAcquisitionDate() {
		return acquisitionDate;
	}


	/**
	 * @param acquisitionDate
	 *            the acquisitionDate to set
	 */
	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}


	/**
	 * @return the insuredType
	 */
	public String getInsuredType() {
		return insuredType;
	}


	/**
	 * @param insuredType
	 *            the insuredType to set
	 */
	public void setInsuredType(String insuredType) {
		this.insuredType = insuredType;
	}


	/**
	 * @return the investorId
	 */
	public String getInvestorId() {
		return investorId;
	}


	/**
	 * @param investorId
	 *            the investorId to set
	 */
	public void setInvestorId(String investorId) {
		this.investorId = investorId;
	}


	/**
	 * @return the investorLoanNumber
	 */
	public String getInvestorLoanNumber() {
		return investorLoanNumber;
	}


	/**
	 * @param investorLoanNumber
	 *            the investorLoanNumber to set
	 */
	public void setInvestorLoanNumber(String investorLoanNumber) {
		this.investorLoanNumber = investorLoanNumber;
	}


	/**
	 * @return the lateCharge
	 */
	public Double getLateCharge() {
		return lateCharge;
	}


	/**
	 * @param lateCharge
	 *            the lateCharge to set
	 */
	public void setLateCharge(Double lateCharge) {
		this.lateCharge = lateCharge;
	}


	/**
	 * @return the coordinatorFirstName
	 */
	public String getCoordinatorFirstName() {
		return coordinatorFirstName;
	}


	/**
	 * @param coordinatorFirstName
	 *            the coordinatorFirstName to set
	 */
	public void setCoordinatorFirstName(String coordinatorFirstName) {
		this.coordinatorFirstName = coordinatorFirstName;
	}


	/**
	 * @return the coordinatorLastName
	 */
	public String getCoordinatorLastName() {
		return coordinatorLastName;
	}


	/**
	 * @param coordinatorLastName
	 *            the coordinatorLastName to set
	 */
	public void setCoordinatorLastName(String coordinatorLastName) {
		this.coordinatorLastName = coordinatorLastName;
	}


	/**
	 * @return the loanOriginationDate
	 */
	public Date getLoanOriginationDate() {
		return loanOriginationDate;
	}


	/**
	 * @param loanOriginationDate
	 *            the loanOriginationDate to set
	 */
	public void setLoanOriginationDate(Date loanOriginationDate) {
		this.loanOriginationDate = loanOriginationDate;
	}


	/**
	 * @return the loanType
	 */
	public String getLoanType() {
		return loanType;
	}


	/**
	 * @param loanType
	 *            the loanType to set
	 */
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}


	/**
	 * @return the miCertificationNo
	 */
	public String getMiCertificationNo() {
		return miCertificationNo;
	}


	/**
	 * @param miCertificationNo
	 *            the miCertificationNo to set
	 */
	public void setMiCertificationNo(String miCertificationNo) {
		this.miCertificationNo = miCertificationNo;
	}


	/**
	 * @return the miCompany
	 */
	public String getMiCompany() {
		return miCompany;
	}


	/**
	 * @param miCompany
	 *            the miCompany to set
	 */
	public void setMiCompany(String miCompany) {
		this.miCompany = miCompany;
	}


	/**
	 * @return the miPercent
	 */
	public Double getMiPercent() {
		return miPercent;
	}


	/**
	 * @param miPercent
	 *            the miPercent to set
	 */
	public void setMiPercent(Double miPercent) {
		this.miPercent = miPercent;
	}


	/**
	 * @return the orgLoanAmount
	 */
	public String getOrgLoanAmount() {
		return orgLoanAmount;
	}


	/**
	 * @param orgLoanAmount
	 *            the orgLoanAmount to set
	 */
	public void setOrgLoanAmount(String orgLoanAmount) {
		this.orgLoanAmount = orgLoanAmount;
	}


	/**
	 * @return the borrowers
	 */
	public List<Borrower> getBorrowers() {
		if (borrowers == null) {
			borrowers = new ArrayList<Borrower>();
		}
		return borrowers;
	}


	/**
	 * @param borrowers
	 *            the borrowers to set
	 */
	public void setBorrowers(List<Borrower> borrowers) {
		this.borrowers = borrowers;
	}


	/**
	 * @return the foreClosure
	 */
	public ForeClosure getForeClosure() {
		if (foreClosure == null) {
			foreClosure = new ForeClosure();
		}
		return foreClosure;
	}


	/**
	 * @param foreClosure
	 *            the foreClosure to set
	 */
	public void setForeClosure(ForeClosure foreClosure) {
		this.foreClosure = foreClosure;
	}


	/**
	 * @return the collateral
	 */
	public Collateral getCollateral() {
		if (collateral == null) {
			collateral = new Collateral();
		}
		return collateral;
	}


	/**
	 * @param collateral
	 *            the collateral to set
	 */
	public void setCollateral(Collateral collateral) {
		this.collateral = collateral;
	}


	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		if (payment == null) {
			payment = new Payment();
		}
		return payment;
	}


	/**
	 * @param payment
	 *            the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}


	/**
	 * @return the demandLetterExpiryDate
	 */
	public Date getDemandLetterExpiryDate() {
		return demandLetterExpiryDate;
	}


	/**
	 * @param demandLetterExpiryDate
	 *            the demandLetterExpiryDate to set
	 */
	public void setDemandLetterExpiryDate(Date demandLetterExpiryDate) {
		this.demandLetterExpiryDate = demandLetterExpiryDate;
	}


	/**
	 * @return the demandLetterPrintDate
	 */
	public Date getDemandLetterPrintDate() {
		return demandLetterPrintDate;
	}


	/**
	 * @param demandLetterPrintDate
	 *            the demandLetterPrintDate to set
	 */
	public void setDemandLetterPrintDate(Date demandLetterPrintDate) {
		this.demandLetterPrintDate = demandLetterPrintDate;
	}


	/**
	 * @return the demandLetterRequestDate
	 */
	public Date getDemandLetterRequestDate() {
		return demandLetterRequestDate;
	}


	/**
	 * @param demandLetterRequestDate
	 *            the demandLetterRequestDate to set
	 */
	public void setDemandLetterRequestDate(Date demandLetterRequestDate) {
		this.demandLetterRequestDate = demandLetterRequestDate;
	}


	/**
	 * @return the lienPosition
	 */
	public String getLienPosition() {
		return lienPosition;
	}


	/**
	 * @param lienPosition
	 *            the lienPosition to set
	 */
	public void setLienPosition(String lienPosition) {
		this.lienPosition = lienPosition;
	}


	@Override
	public String toString() {

		return EIMUtil.validateBoolean(getForeClosure().getIsAcquiredInFC()) + EIMUtil.PIPE
				+ EIMUtil.validateDate(this.acquisitionDate) + EIMUtil.PIPE
				+ EIMUtil.getBorrowerAsString(getBorrowers()) + EIMUtil.PIPE
				+ EIMUtil.validateDate(getForeClosure().getSaleConfirmedDate()) + EIMUtil.PIPE
				+ EIMUtil.validateDate(this.demandLetterExpiryDate) + EIMUtil.PIPE
				+ EIMUtil.validateDate(this.demandLetterPrintDate) + EIMUtil.PIPE
				+ EIMUtil.validateDate(this.demandLetterRequestDate) + EIMUtil.PIPE
				+ EIMUtil.validateString(getForeClosure().getForeClosureId()) + EIMUtil.PIPE
				+ EIMUtil.validateDate(getForeClosure().getForeClosureStartDate()) + EIMUtil.PIPE
				+ EIMUtil.validateString(getForeClosure().getForeClosureStatus()) + EIMUtil.PIPE
				+ EIMUtil.validateString(getForeClosure().getForeClosureType()) + EIMUtil.PIPE
				+ EIMUtil.validateString(getForeClosure().getHoldDescription()) + EIMUtil.PIPE
				+ EIMUtil.validateString(this.insuredType) + EIMUtil.PIPE
				+ EIMUtil.validateString(this.investorId) + EIMUtil.PIPE
				+ EIMUtil.validateString(this.investorLoanNumber) + EIMUtil.PIPE
				+ EIMUtil.validateDouble(this.lateCharge) + EIMUtil.PIPE
				+ EIMUtil.validateString(this.lienPosition) + EIMUtil.PIPE
				+ EIMUtil.validateString(this.coordinatorFirstName) + EIMUtil.PIPE
				+ EIMUtil.validateString(this.coordinatorLastName) + EIMUtil.PIPE
				+ EIMUtil.validateString(this.loanNumber) + EIMUtil.PIPE
				+ EIMUtil.validateDate(this.loanOriginationDate) + EIMUtil.PIPE
				+ EIMUtil.validateString(this.loanType) + EIMUtil.PIPE
				+ EIMUtil.validateDouble(getCollateral().getProperty().getMarketValue())
				+ EIMUtil.PIPE
				+ EIMUtil.validateDate(getCollateral().getProperty().getMarketValuationDate())
				+ EIMUtil.PIPE + EIMUtil.validateString(this.miCertificationNo) + EIMUtil.PIPE
				+ EIMUtil.validateString(this.miCompany) + EIMUtil.PIPE
				+ EIMUtil.validateDouble(this.miPercent) + EIMUtil.PIPE
				+ EIMUtil.validateString(getCollateral().getProperty().getOccupancyStatus())
				+ EIMUtil.PIPE
				+ EIMUtil.validateDouble(getCollateral().getProperty().getOrgAppraisalAmount())
				+ EIMUtil.PIPE
				+ EIMUtil.validateDate(getCollateral().getProperty().getOrgAppraisalDate())
				+ EIMUtil.PIPE + EIMUtil.validateString(this.orgLoanAmount)
				+ EIMUtil.validateDate(getPayment().getPaidToDate()) + EIMUtil.PIPE
				+ EIMUtil.validateDate(getPayment().getNextDueDate()) + EIMUtil.PIPE
				+ EIMUtil.validateDouble(getPayment().getPITI()) + EIMUtil.PIPE
				+ EIMUtil.validateDouble(getPayment().getUnpaindPrincipalBalance()) + EIMUtil.PIPE
				+ EIMUtil.getAddressAsString(getCollateral().getProperty().getAddress())
				+ EIMUtil.PIPE
				+ EIMUtil.validateString(getCollateral().getProperty().getPropertyType())
				+ EIMUtil.PIPE + EIMUtil.validateBoolean(getForeClosure().getIsSaleDateConfirmed())
				+ EIMUtil.NEW_LINE;
	}
}
