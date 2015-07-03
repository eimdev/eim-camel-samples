package com.altisource.eim.util;

import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author balamuruganm
 * 
 */
public class EIMUtils {

	/**
	 * Method used to get xml value and store it in a string
	 * 
	 * @param body
	 *            contains actual message
	 * @param splitter
	 *            split xml value using it
	 * 
	 * @return String converted xmlstring
	 */
	public static StringBuilder getXMLNodeValue(String body, String splitter) {

		StringBuilder xmlMessage = new StringBuilder();
		try {

			DocumentBuilder documentBuilder = DocumentBuilderFactory
					.newInstance().newDocumentBuilder();
			ByteArrayInputStream stream = new ByteArrayInputStream(
					body.getBytes());
			Document document = documentBuilder.parse(stream);

			if (document.hasChildNodes()) {
				getXMLChildNodeValues(document.getChildNodes(), splitter,
						xmlMessage);
			}

		} catch (Exception e) {
			System.out.println("Error occured while getting XML value: " + e.getMessage());
		}
		return xmlMessage;

	}

	private static void getXMLChildNodeValues(NodeList nodeList,
			String splitter, StringBuilder xmlMessage) {

		for (int count = 0; count < nodeList.getLength(); count++) {

			Node elemNode = nodeList.item(count);

			if (elemNode.getNodeType() == Node.ELEMENT_NODE) {

				String value = elemNode.getFirstChild().getNodeValue();
				if (value != null && !value.trim().isEmpty()) {

					xmlMessage.append(value.trim()).append(splitter);
				}
				if (elemNode.hasChildNodes()) {
					// recursive call if the node has child nodes
					getXMLChildNodeValues(elemNode.getChildNodes(), splitter,
							xmlMessage);
				}
			}
		}
	}

	/**
	 * Method used to get json value and store it in a string
	 * 
	 * @param body
	 *            contains actual message
	 * @param splitter
	 *            split json value using it
	 * 
	 * @return String converted jsonstring
	 */
	public static StringBuilder getJSONNodeValue(String body, String splitter) {

		StringBuilder jsonMessage = new StringBuilder();

		getJsonValue(body, splitter, jsonMessage);

		return jsonMessage;
	}

	private static void getJsonValue(String body, String splitter,
			StringBuilder jsonMessage) {

		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = (JsonObject) jsonParser.parse(body);
		Set<Entry<String, JsonElement>> entrySet = jsonObject.entrySet();

		Iterator<?> iterator = entrySet.iterator();
		try {

			while (iterator.hasNext()) {
				Map.Entry<?, ?> pair = (Entry<?, ?>) iterator.next();
				String key = pair.getKey().toString();
				if (jsonObject.get(key) instanceof JsonObject) {
					getJsonValue(jsonObject.get(key).toString(), splitter,
							jsonMessage);
				} else {
					jsonMessage.append(jsonObject.get(key).toString()).append(splitter);
				}
			}
		} catch (Exception e) {
			System.out.println("Error occured while getting JSON value: " + e.getMessage());
		}
	}
}
