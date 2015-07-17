package com.altisource.fcbk.processor;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.commons.lang.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.altisource.fcbk.domain.Address;
import com.altisource.fcbk.domain.Borrower;
import com.altisource.fcbk.domain.Collateral;
import com.altisource.fcbk.domain.Contact;
import com.altisource.fcbk.domain.ForeClosure;
import com.altisource.fcbk.domain.Loan;
import com.altisource.fcbk.domain.Payment;
import com.altisource.fcbk.domain.Property;
import com.altisource.fcbk.util.EIMUtil;
import com.altisource.fcbk.util.FCBKConstants;
import com.altisource.fcbk.util.XMLUtil;

/**
 * @author balamuruganm
 * 
 */
public class FCBKLoanServiceProcessor {

	static Logger logger = LoggerFactory.getLogger(FCBKLoanServiceProcessor.class.getName());


	/**
	 * Method to read loanIds from File
	 * 
	 * @param exchange
	 *            contains header and body details of the message
	 */
	public void getLoanId(Exchange exchange) {
		logger.info("Getting loan id from rest service");
		String loanId = exchange.getIn().getBody(String.class);

		exchange.getOut().setBody(loanId);
	}


	/**
	 * Method to read loanIds from File
	 * 
	 * @param exchange
	 *            contains header and body details of the message
	 */
	public void getLoanIds(Exchange exchange) {
		String loanIds = new String((String) exchange.getIn().getBody(String.class));

		exchange.getOut().setBody(loanIds);
	}


	/**
	 * Method to convert xml message to string and store it in a exchange body
	 * 
	 * @param exchange
	 *            contains header and body details of the message
	 */
	public void decodeXMLResponse(Exchange exchange) {

		String xmlString = EIMUtil.getStringFromInputStream((InputStream) exchange.getIn()
				.getBody());
		xmlString = StringEscapeUtils.unescapeHtml(xmlString);
		exchange.getOut().setBody(xmlString.trim());
	}


	/**
	 * Method to construct loan response to the getLoanDetails service
	 * 
	 * @param exchange
	 *            contains header and body details of the message
	 * @throws ParseException
	 */
	public void constructLoanResponse(Exchange exchange) throws Exception {

		String xmlResponse = (String) exchange.getIn().getBody();

		Loan loan = constructLoan(xmlResponse);
		exchange.getOut().setBody(loan);
		/*
		 * String loanXmlResponse = XMLUtil.extractLoanXml(xmlResponse,
		 * "//return/LOANS"); if (loanXmlResponse != null &&
		 * !loanXmlResponse.trim().isEmpty()) { InputStream stream = new
		 * ByteArrayInputStream(loanXmlResponse.getBytes()); Object loans =
		 * EIMUtil.fromXmlToObject(LOANS.class, stream); if (loans instanceof
		 * LOANS) { exchange.getOut().setBody(loans); } } else { FailureResponse
		 * response = new FailureResponse();
		 * response.setErrorMsg("No Loans Found");
		 * exchange.getOut().setBody(response); }
		 */
	}


	/**
	 * Method to write loan response to the output file
	 * 
	 * @param exchange
	 *            contains header and body details of the message
	 * @throws ParseException
	 */
	public void extractLoanResponse(Exchange exchange) throws Exception {

		String xmlString = (String) exchange.getIn().getBody();
		String loanResponse = XMLUtil.extractLoanXml(xmlString, "//return/LOANS");

		exchange.getOut().setBody(loanResponse);
	}


	/**
	 * Method to write loan response to the output file
	 * 
	 * @param exchange
	 *            contains header and body details of the message
	 * @throws ParseException
	 */
	public void writeLoanResponse(Exchange exchange) throws Exception {

		String xmlString = (String) exchange.getIn().getBody();
		Loan loan = constructLoan(xmlString);
		exchange.getOut().setBody(loan.toString());
	}


	/**
	 * Method to construct loan
	 * 
	 * @param xmlString
	 *            contains response string
	 * @throws ParseException
	 */
	private Loan constructLoan(String xmlString) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		Date date = null;
		Loan loan = new Loan();
		if (!XMLUtil.verifyElementExists(xmlString, FCBKConstants.LOANS)) {
			return loan;
		}

		String acquisitionDate = XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.ACQUISITIONDATE);
		String loanOriginationDate = XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.LOANORIGINATIONDATE);
		String demandLetterExpiryDate = XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.DEMANDLETTEREXPIRYDATE);
		String demandLetterPrintDate = XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.DEMANDLETTERPRINTDATE);
		String demandLetterRequestDate = XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.DEMANDLETTERREQUESTDATE);

		loan.setLoanNumber(XMLUtil.getElementValueByXpath(xmlString, FCBKConstants.LOANNUMBER));

		if (acquisitionDate != null && !acquisitionDate.trim().isEmpty()) {
			date = dateFormat.parse(acquisitionDate);
			loan.setAcquisitionDate(date);
		}

		loan.setInvestorId(XMLUtil.getElementValueByXpath(xmlString, FCBKConstants.INVESTORID));
		loan.setInvestorLoanNumber(XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.INVESTORLOANNUMBER));
		loan.setLateCharge(Double.valueOf(XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.LATECHARGE)));
		loan.setCoordinatorFirstName(XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.COORDINATORFIRSTNAME));
		loan.setCoordinatorLastName(XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.COORDINATORLASTNAME));
		if (loanOriginationDate != null && !loanOriginationDate.trim().isEmpty()) {
			date = dateFormat.parse(loanOriginationDate);
			loan.setLoanOriginationDate(date);
		}
		loan.setMiCertificationNo(XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.MICERTIFICATIONNO));
		loan.setMiCompany(XMLUtil.getElementValueByXpath(xmlString, FCBKConstants.MICOMPANY));
		loan.setMiPercent(Double.valueOf(XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.MIPERCENT)));
		if (demandLetterExpiryDate != null && !demandLetterExpiryDate.trim().isEmpty()) {

			date = dateFormat.parse(demandLetterExpiryDate);
			loan.setDemandLetterExpiryDate(date);
		}

		if (demandLetterPrintDate != null && !demandLetterPrintDate.trim().isEmpty()) {

			date = dateFormat.parse(demandLetterPrintDate);
			loan.setDemandLetterPrintDate(date);
		}

		if (demandLetterRequestDate != null && !demandLetterRequestDate.trim().isEmpty()) {

			date = dateFormat.parse(demandLetterRequestDate);
			loan.setDemandLetterRequestDate(date);
		}

		loan.setPayment(constructPayment(xmlString));
		loan.setCollateral(constructCollateral(xmlString));
		loan.setForeClosure(constructForeClosure(xmlString));

		List<Borrower> borrowers = new ArrayList<Borrower>();
		borrowers.add(constructBorrower(xmlString, EIMUtil.FIRST_POSITION));
		borrowers.add(constructBorrower(xmlString, EIMUtil.SECOND_POSITION));
		loan.setBorrowers(borrowers);

		return loan;
	}


	/**
	 * Method to construct payment
	 * 
	 * @param xmlString
	 *            contains response string
	 * 
	 * @return payment
	 * @throws ParseException
	 */
	private Payment constructPayment(String xmlString) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		Date date = null;
		Payment payment = new Payment();
		String paidToDate = XMLUtil.getElementValueByXpath(xmlString, FCBKConstants.PAIDTODATE);
		String nextDueDate = XMLUtil.getElementValueByXpath(xmlString, FCBKConstants.NEXTDUEDATE);

		if (paidToDate != null && !paidToDate.trim().isEmpty()) {
			date = dateFormat.parse(paidToDate);
			payment.setPaidToDate(date);
		}

		if (nextDueDate != null && !nextDueDate.trim().isEmpty()) {
			date = dateFormat.parse(nextDueDate);
			payment.setNextDueDate(date);
		}

		payment.setPITI(Double.valueOf(XMLUtil
				.getElementValueByXpath(xmlString, FCBKConstants.PITI)));
		payment.setUnpaindPrincipalBalance(Double.valueOf(XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.UNPAINDPRINCIPALBALANCE)));

		return payment;
	}


	/**
	 * Method to construct Collateral
	 * 
	 * @param xmlString
	 *            contains response string
	 * 
	 * @return Collateral
	 * @throws ParseException
	 */
	private Collateral constructCollateral(String xmlString) throws ParseException {

		Collateral collateral = new Collateral();

		collateral.setProperty(constructProperty(xmlString));

		return collateral;
	}


	/**
	 * Method to construct Property
	 * 
	 * @param xmlString
	 *            contains response string
	 * 
	 * @return Property
	 * @throws ParseException
	 */
	private Property constructProperty(String xmlString) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		Date date = null;
		String marketValuationDate = XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.MARKETVALUATIONDATE);
		String originalAppraisalDate = XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.ORIGINALAPPRAISALDATE);
		Property property = new Property();

		if (marketValuationDate != null && !marketValuationDate.trim().isEmpty()) {
			date = dateFormat.parse(marketValuationDate);
			property.setMarketValuationDate(date);
		}

		property.setMarketValue(Double.valueOf(XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.MARKETVALUE)));
		property.setOrgAppraisalAmount(Double.valueOf(XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.ORIGINALAPPRAISALAMOUNT)));

		if (originalAppraisalDate != null && !originalAppraisalDate.trim().isEmpty()) {
			date = dateFormat.parse(originalAppraisalDate);
			property.setOrgAppraisalDate(date);
		}

		property.setAddress(constructAddress(xmlString));

		return property;
	}


	/**
	 * Method to construct Address
	 * 
	 * @param xmlString
	 *            contains response string
	 * 
	 * @return Address
	 */
	private Address constructAddress(String xmlString) {

		Address address = new Address();

		address.setAddress1(XMLUtil.getElementValueByXpath(xmlString, FCBKConstants.ADDRESS1));
		address.setAddress2(XMLUtil.getElementValueByXpath(xmlString, FCBKConstants.ADDRESS2));
		address.setAddress3(XMLUtil.getElementValueByXpath(xmlString, FCBKConstants.ADDRESS3));
		address.setCity(XMLUtil.getElementValueByXpath(xmlString, FCBKConstants.CITY));
		address.setCountry(XMLUtil.getElementValueByXpath(xmlString, FCBKConstants.COUNTRY));
		address.setState(XMLUtil.getElementValueByXpath(xmlString, FCBKConstants.STATE));
		address.setZipcode(XMLUtil.getElementValueByXpath(xmlString, FCBKConstants.ZIPCODE));

		return address;
	}


	/**
	 * Method to construct ForeClosure
	 * 
	 * @param xmlString
	 *            contains response string
	 * 
	 * @return ForeClosure
	 * @throws ParseException
	 */
	private ForeClosure constructForeClosure(String xmlString) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		Date date = null;
		String foreclosureStartDate = XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.FORECLOSURESTARTDATE);
		String saleConfirmedDate = XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.SALECONFIRMEDDATE);

		ForeClosure foreClosure = new ForeClosure();

		foreClosure.setIsAcquiredInFC(Boolean.valueOf(XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.ISACQUIREDINFC)));

		foreClosure.setForeClosureId(XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.FORECLOSUREID));

		if (foreclosureStartDate != null && !foreclosureStartDate.trim().isEmpty()) {
			date = dateFormat.parse(foreclosureStartDate);
			foreClosure.setForeClosureStartDate(date);
		}

		foreClosure.setIsSaleDateConfirmed(XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.ISSALEDATECONFIRMED) != null ? true : false);

		if (saleConfirmedDate != null && !saleConfirmedDate.trim().isEmpty()) {

			date = dateFormat.parse(saleConfirmedDate);
			foreClosure.setSaleConfirmedDate(date);
		}

		return foreClosure;
	}


	/**
	 * Method to construct Contact
	 * 
	 * @param xmlString
	 *            contains response string
	 * 
	 * @return Contact
	 */
	private Contact constructContact(String xmlString, String position) {

		Contact contact = new Contact();

		contact.setFirstName(XMLUtil.getElementValueByXpath(xmlString, FCBKConstants.FIRSTNAME
				+ position));
		contact.setLastName(XMLUtil.getElementValueByXpath(xmlString, FCBKConstants.LASTNAME
				+ position));
		contact.setHomePhoneNumber(XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.HOMEPHONENUMBER));
		contact.setBusinessPhoneNumber(XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.BUSINESSPHONENUMBER));
		contact.setEmailAddress(XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.EMAILADDRESS));
		contact.setAddress(constructBorrowerAddress(xmlString));

		return contact;
	}


	/**
	 * Method to construct Borrower Address
	 * 
	 * @param xmlString
	 *            contains response string
	 * 
	 * @return Address
	 */
	private Address constructBorrowerAddress(String xmlString) {

		Address address = new Address();

		address.setAddress1(XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.BORROWER_ADDRESS1));
		address.setAddress2(XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.BORROWER_ADDRESS2));
		address.setAddress3(XMLUtil.getElementValueByXpath(xmlString,
				FCBKConstants.BORROWER_ADDRESS3));
		address.setCity(XMLUtil.getElementValueByXpath(xmlString, FCBKConstants.BORROWER_CITY));
		address.setCountry(XMLUtil
				.getElementValueByXpath(xmlString, FCBKConstants.BORROWER_COUNTRY));
		address.setState(XMLUtil.getElementValueByXpath(xmlString, FCBKConstants.BORROWER_STATE));

		return address;
	}


	/**
	 * Method to construct Borrower
	 * 
	 * @param xmlString
	 *            contains response string
	 * 
	 * @return Borrower
	 */
	private Borrower constructBorrower(String xmlString, String position) {

		Borrower borrower = new Borrower();

		borrower.setContact(constructContact(xmlString, position));

		return borrower;
	}

}
