package com.altisource.fcbk.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * @author balamuruganm
 * 
 */
public class XMLUtil {

	public static NodeList getNodesByXpath(String xml, String xpathValue) throws Exception {

		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

		Document doc = docBuilder.parse(new InputSource(new StringReader(xml)));

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile(xpathValue);

		Object result = expr.evaluate(doc, XPathConstants.NODESET);

		NodeList nodeList = (NodeList) result;
		return nodeList;
	}


	/**
	 * This method will return element value based on the given Xpath
	 * 
	 * @param xml
	 *            Input XML
	 * @param xpathValue
	 *            Xpath for requested element
	 * @return
	 * @throws Exception
	 */
	public static String getElementValueByXpath(String xml, String xpathValue) {

		NodeList nodeList = null;
		try {
			nodeList = getNodesByXpath(xml, xpathValue);
		} catch (Exception e) {
			System.out.println("Error Occured while xpath : " + e);
		}
		if (nodeList != null && nodeList.getLength() > 0) {
			if (nodeList.item(0).getFirstChild() != null) {
				return nodeList.item(0).getFirstChild().getNodeValue();
			}
		}
		return "";
	}


	/**
	 * This method will return element value based on the given Xpath
	 * 
	 * @param xml
	 *            Input XML
	 * @param xpathValue
	 *            Xpath for requested element
	 * @return
	 * @throws Exception
	 */
	public static boolean verifyElementExists(String xml, String xpathValue) {

		NodeList nodeList = null;
		try {
			nodeList = getNodesByXpath(xml, xpathValue);
		} catch (Exception e) {
			System.out.println("Error Occured while xpath : " + e);
		}
		if (nodeList != null && nodeList.getLength() > 0) {
			return true;
		}
		return false;
	}


	public static String extractLoanXml(String xmlString, String exprerssion) throws Exception {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		Document document = builderFactory.newDocumentBuilder().parse(
				new InputSource(new StringReader(xmlString)));

		XPath xPath = XPathFactory.newInstance().newXPath();
		Node node = (Node) xPath.evaluate(exprerssion, document, XPathConstants.NODE);

		return node != null ? nodeToString(node) : null;
	}


	private static String nodeToString(Node node) throws TransformerException {

		StringWriter writer = new StringWriter();
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.transform(new DOMSource(node), new StreamResult(writer));

		return writer.toString();
	}

}
