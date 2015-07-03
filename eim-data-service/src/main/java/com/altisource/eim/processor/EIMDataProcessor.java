package com.altisource.eim.processor;

import org.apache.camel.Exchange;

import com.altisource.eim.util.EIMUtils;

/**
 * @author balamuruganm
 * 
 */
public class EIMDataProcessor {

	private static final String JSON = "JSON";
	private static final String PIPE = "|";
	private static final String XML = "XML";

	/**
	 * Method to know the content type of the message
	 * 
	 * @param exchange
	 *            contains header and body details of the message
	 */
	public void getContentType(Exchange exchange) {

		String contentType = (String) exchange.getIn().getHeader("contentType");

		if (XML.equals(contentType)) {
			ConvertXMLtoPipeDelimted(exchange);
		} else if (JSON.equals(contentType)) {
			ConvertJSONtoPipeDelimted(exchange);
		}
	}

	/**
	 * Method to convert xml message to string and store it in a exchange body
	 * 
	 * @param exchange
	 *            contains header and body details of the message
	 */
	public void ConvertXMLtoPipeDelimted(Exchange exchange) {

		exchange.getIn().setBody(
				EIMUtils.getXMLNodeValue((String) exchange.getIn().getBody(),
						PIPE));
	}

	/**
	 * Method to convert json message to string and store it in a exchange body
	 * 
	 * @param exchange
	 *            contains header and body details of the message
	 */
	public void ConvertJSONtoPipeDelimted(Exchange exchange) {

		exchange.getIn().setBody(
				EIMUtils.getJSONNodeValue((String) exchange.getIn().getBody(),
						PIPE));

	}

}
