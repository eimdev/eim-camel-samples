package com.altisource.fcbk.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.altisource.fcbk.domain.Address;
import com.altisource.fcbk.domain.Borrower;
import com.altisource.fcbk.domain.Contact;

/**
 * @author balamuruganm
 * 
 */
public class EIMUtil {

	public static final String PIPE = "|";
	public static final String NEW_LINE = "\n";
	public static final String EMPTY_STRING = "";
	public static final String FIRST_POSITION = "[1]";
	public static final String SECOND_POSITION = "[2]";


	/**
	 * Converts object to XML
	 * 
	 * @param object
	 *            to be converted as xml
	 * @return the xml as string
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String fromObjectToXml(Object object, Class classType, QName qName) {

		try {

			JAXBContext context = JAXBContext.newInstance(classType);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			JAXBElement<Object> root = new JAXBElement<Object>(qName, classType, object);
			StringWriter sw = new StringWriter();
			marshaller.marshal(root, sw);
			return sw.toString();
		} catch (Exception e) {
			return "Exception occured " + e.getMessage();
		}
	}


	/**
	 * Method to convert xml to object
	 * 
	 * @param classType
	 * @param fileName
	 * 
	 * @return an object
	 */
	public static Object fromXmlToObject(Class<?> className, InputStream stream) {

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(className.getPackage().getName(),
					className.getClassLoader());
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			JAXBElement<?> unmarshalledObject = (JAXBElement<?>) unmarshaller.unmarshal(stream);
			return unmarshalledObject.getValue();
		} catch (Exception e) {
			return "Exception occured " + e.getMessage();
		}
	}


	public static StringBuilder getXMLNodeValue(String body, String splitter) {

		StringBuilder xmlMessage = new StringBuilder();
		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			builderFactory.setIgnoringElementContentWhitespace(true);
			DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
			ByteArrayInputStream stream = new ByteArrayInputStream(body.trim().getBytes());
			Document document = documentBuilder.parse(stream);

			if (document.hasChildNodes()) {
				getXMLChildNodeValues(document.getChildNodes(), splitter, xmlMessage);
			}

		} catch (Exception e) {
			System.out.println("Error occured while getting XML value: " + e.getMessage());
		}
		return xmlMessage;

	}


	private static void getXMLChildNodeValues(NodeList nodeList, String splitter,
			StringBuilder xmlMessage) {

		for (int count = 0; count < nodeList.getLength(); count++) {

			Node elemNode = nodeList.item(count);

			if (elemNode.getNodeType() == Node.ELEMENT_NODE) {

				String value = null;
				if (elemNode != null && elemNode.getFirstChild() != null) {
					value = elemNode.getFirstChild().getNodeValue();
				}
				if (value != null && !value.trim().isEmpty()) {
					xmlMessage.append(value.trim()).append(splitter);
				}
				if (elemNode.hasChildNodes()) {
					// recursive call if the node has child nodes
					getXMLChildNodeValues(elemNode.getChildNodes(), splitter, xmlMessage);
				}
			}
		}
	}


	public static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}


	public static String validateString(String value) {

		if (value != null && !value.trim().isEmpty()) {
			return value;
		}
		return "";
	}


	public static String validateInt(int value) {

		if (value != 0) {
			return String.valueOf(value);
		}
		return "";
	}


	public static String validateDouble(Double value) {

		if (value != 0) {
			return String.valueOf(value);
		}
		return "";
	}


	public static String validateBoolean(Boolean value) {

		if (value != null) {
			return String.valueOf(value);
		}
		return "false";
	}


	public static String validateDate(Date value) {

		if (value != null) {
			return String.valueOf(value);
		}
		return "";
	}


	public static String getBorrowerAsString(List<Borrower> borrowers) {

		String borrower1 = null;
		Borrower borrower = null;

		if (borrowers != null && borrowers.size() > 0) {
			borrower = borrowers.get(0);
			if (borrower != null) {

				borrower1 = EIMUtil.validateString(borrower.getAgencyFlag()) + PIPE
						+ EIMUtil.getContactAsString(borrower.getContact());
			}
		}

		return borrower1;
	}


	public static String getContactAsString(Contact contact) {

		return EIMUtil.validateString(contact.getFirstName()) + PIPE
				+ EIMUtil.validateString(contact.getLastName()) + PIPE
				+ getAddressAsString(contact.getAddress())
				+ EIMUtil.validateString(contact.getHomePhoneNumber()) + PIPE
				+ EIMUtil.validateString(contact.getBusinessPhoneNumber()) + PIPE
				+ EIMUtil.validateString(contact.getEmailAddress());
	}


	public static String getAddressAsString(Address address) {

		return EIMUtil.validateString(address.getAddress1()) + PIPE
				+ EIMUtil.validateString(address.getAddress2()) + PIPE
				+ EIMUtil.validateString(address.getAddress3()) + PIPE
				+ EIMUtil.validateString(address.getCity()) + PIPE
				+ EIMUtil.validateString(address.getState()) + PIPE
				+ EIMUtil.validateString(address.getZipcode());
	}

}
