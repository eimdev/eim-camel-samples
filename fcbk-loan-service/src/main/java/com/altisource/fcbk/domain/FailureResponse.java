package com.altisource.fcbk.domain;

/**
 * @author balamuruganm
 * 
 */
public class FailureResponse {

	private String errorCode;
	private String errorMsg;


	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}


	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}


	/**
	 * @param errorMsg
	 *            the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
