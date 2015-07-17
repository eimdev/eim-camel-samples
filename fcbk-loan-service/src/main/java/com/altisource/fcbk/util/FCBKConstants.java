package com.altisource.fcbk.util;

/**
 * @author balamuruganm
 * 
 */
public class FCBKConstants {

	public static final String LOANS = "//LOANS";
	public static final String LOANNUMBER = "//LOAN/LOAN_IDENTIFIERS/LOAN_IDENTIFIER/"
			+ "LoanIdentifier";
	public static final String ISACQUIREDINFC = "//LOAN/FORECLOSURES/FORECLOSURE_DETAIL/"
			+ "ActiveForeclosureIndicator";
	public static final String ACQUISITIONDATE = "//LOAN/CLOSING_INFORMATION/"
			+ "CLOSING_INFORMATION_DETAIL/ClosingDate";
	// public static final String INSUREDTYPE =
	// "//LOAN/INSURER/LEGALENTITY/LEGAL_ENTITY_DETAIL/GlobalLegalEntityIdentifier";
	public static final String INVESTORID = "//LOAN/INVESTOR_LOAN_INFORMATION/"
			+ "InvestorInstitutionIdentifier";
	public static final String INVESTORLOANNUMBER = "//LOAN/LOAN_IDENTIFIERS/LOAN_IDENTIFIER/"
			+ "LoanIdentifier";
	public static final String LATECHARGE = "//LOAN/LATE_CHARGE/LATE_CHARGE_OCCURRENCES/"
			+ "LATE_CHARGE_OCCURRENCE/UncollectedLateChargeBalanceAmount";
	public static final String COORDINATORFIRSTNAME = "//LOAN/SERVICING/DELINQUENCIES/"
			+ "DELINQUENCY_DETAIL/ServicerCollectorName";
	public static final String COORDINATORLASTNAME = "//LOAN/SERVICING/DELINQUENCIES/"
			+ "DELINQUENCY_DETAIL/ServicerCollectorName";
	public static final String LOANORIGINATIONDATE = "//LOAN/CLOSING_INFORMATION/"
			+ "CLOSING_INFORMATION_DETAIL/ClosingDate";
	// public static final String LOANTYPE =
	// "//LOAN/TERMS_OF_LOAN/MortgageType";
	public static final String MICERTIFICATIONNO = "//LOAN/MI_DATA/MI_DATA_DETAIL/"
			+ "MICertificateIdentifier";
	public static final String MICOMPANY = "//LOAN/MI_DATA/MI_PAID_TO/LEGAL_ENTITY/"
			+ "LEGAL_ENTITY_DETAIL/GlobalLegalEntityIdentifier";
	public static final String MIPERCENT = "//LOAN/MI_DATA/MI_DATA_DETAIL/MICoveragePercent";

	// Payment
	public static final String PAIDTODATE = "//LOAN/PAYMENT/PAYMENT_SUMMARY/"
			+ "LastPaymentReceivedDate";
	public static final String NEXTDUEDATE = "//LOAN/PAYMENT/PAYMENT_SUMMARY/NextPaymentDueDate";
	public static final String PITI = "//LOAN/PAYMENT/PAYMENT_RULE/InitialPITIPaymentAmount";
	public static final String UNPAINDPRINCIPALBALANCE = "//LOAN/PAYMENT/PAYMENT_SUMMARY/"
			+ "UPBAmount";

	// Property
	public static final String MARKETVALUE = "//COLLATERAL/SUBJECT_PROPERTY/"
			+ "PROPERTY_VALUATIONS/PROPERTY_VALUATION/PROPERTY_VALUATION_DETAIL/"
			+ "PropertyValuationAmount";
	public static final String MARKETVALUATIONDATE = "//COLLATERAL/SUBJECT_PROPERTY/"
			+ "PROPERTY_VALUATIONS/PROPERTY_VALUATION/PROPERTY_VALUATION_DETAIL/"
			+ "PropertyValuationEffectiveDate";
	public static final String ORIGINALAPPRAISALAMOUNT = "//COLLATERAL/SUBJECT_PROPERTY/"
			+ "PROPERTY_VALUATIONS/PROPERTY_VALUATION/PROPERTY_VALUATION_DETAIL/"
			+ "PropertyValuationAmount";
	public static final String ORIGINALAPPRAISALDATE = "//COLLATERAL/SUBJECT_PROPERTY/"
			+ "PROPERTY_VALUATIONS/PROPERTY_VALUATION/PROPERTY_VALUATION_DETAIL/"
			+ "PropertyValuationEffectiveDate";

	// Collateral
	// public static final String LIENPOSITION =
	// "//LOAN/TERMS_OF_LOAN/LienPriorityType";

	// Property
	public static final String ADDRESS1 = "//COLLATERAL/SUBJECT_PROPERTY/ADDRESS/AddressLine1Text";
	public static final String ADDRESS2 = "//COLLATERAL/SUBJECT_PROPERTY/ADDRESS/AddressLine2Text";
	public static final String ADDRESS3 = "//PARTY/ADDRESSES/ADDRESS/AddressLine3Text";
	public static final String CITY = "//COLLATERAL/SUBJECT_PROPERTY/ADDRESS/CityName";
	public static final String STATE = "//COLLATERAL/SUBJECT_PROPERTY/ADDRESS/CountyCode";
	public static final String COUNTRY = "//COLLATERAL/SUBJECT_PROPERTY/ADDRESS/StateCode";
	public static final String ZIPCODE = "//COLLATERAL/SUBJECT_PROPERTY/ADDRESS/PostalCode";

	// ForeClosure
	public static final String FORECLOSUREID = "//LOAN/FORECLOSURES/FORECLOSURE_DETAIL/"
			+ "ForeclosureCaseIdentifier";
	public static final String ISSALEDATECONFIRMED = "//LOAN/FORECLOSURES/FORECLOSURE_DETAIL/"
			+ "ForeclosureSaleConfirmedDate";
	public static final String SALECONFIRMEDDATE = "//LOAN/FORECLOSURES/FORECLOSURE_DETAIL/"
			+ "ForeclosureSaleConfirmedDate";
	public static final String FORECLOSURESTARTDATE = "//LOAN/FORECLOSURES/FORECLOSURE_DETAIL/"
			+ "ForeclosureStartDate";
	public static final String DEMANDLETTEREXPIRYDATE = "//LOAN/WORKOUTS/WORKOUT/SOLICITATIONS/"
			+ "SOLICITATION/SolicitationExpiryDate";
	public static final String DEMANDLETTERPRINTDATE = "//LOAN/WORKOUTS/WORKOUT/SOLICITATIONS/"
			+ "SOLICITATION/SolicitationPrintDate";
	public static final String DEMANDLETTERREQUESTDATE = "//LOAN/WORKOUTS/WORKOUT/SOLICITATIONS/"
			+ "SOLICITATION/SolicitationDate";

	// Borrower Contact
	public static final String FIRSTNAME = "//PARTY/INDIVIDUAL/NAME/FirstName";
	public static final String LASTNAME = "//PARTY/INDIVIDUAL/NAME/FirstName";
	public static final String HOMEPHONENUMBER = "//PARTY/INDIVIDUAL/CONTACT_POINTS/CONTACT_POINT/"
			+ "CONTACT_POINT_TELEPHONE/ContactPointTelephoneValue";
	public static final String BUSINESSPHONENUMBER = "//PARTY/INDIVIDUAL/CONTACT_POINTS/"
			+ "CONTACT_POINT/CONTACT_POINT_TELEPHONE/ContactPointTelephoneValue";
	public static final String EMAILADDRESS = "//PARTY/INDIVIDUAL/CONTACT_POINTS/CONTACT_POINT/"
			+ "CONTACT_POINT_EMAIL/ContactPointEmailValue";

	// Borrower Address
	public static final String BORROWER_ADDRESS1 = "//PARTY/ADDRESSES/ADDRESS/AddressLine1Text";
	public static final String BORROWER_ADDRESS2 = "//PARTY/ADDRESSES/ADDRESS/AddressLine2Text";
	public static final String BORROWER_ADDRESS3 = "//PARTY/ADDRESSES/ADDRESS/AddressLine3Text";
	public static final String BORROWER_CITY = "//PARTY/ADDRESSES/ADDRESS/CityName";
	public static final String BORROWER_STATE = "/PARTY/ADDRESSES/ADDRESS/StateCode";
	public static final String BORROWER_COUNTRY = "/PARTY/ADDRESSES/ADDRESS/PostalCode";

}
