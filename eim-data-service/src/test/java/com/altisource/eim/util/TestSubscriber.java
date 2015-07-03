package com.altisource.eim.util;

import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;

public class TestSubscriber {

	public static void main(String[] a) throws Exception {
		
		String message = TestSubscriber.subscribeMessage("LN00124");
		System.out.println("Loan closure details for the given loan id >> \n" + message);
	}
	
	
	/**
	 * Subscribe message based on given loan id.
	 * 
	 * @param loanId 
	 * @return
	 * @throws Exception
	 */
	private static String subscribeMessage(String loanId) throws Exception {
		
		String message = fetchMessage(loanId, "SS1_INQ");
		if ("NA".equals(message) || "Not Valid".equals(message)) {
			message = fetchMessage(loanId, "SS2_INQ");
		}
		return message;
	}
	
	/**
	 * Fetch message from configured queue.
	 * @return
	 * @throws Exception
	 */
	private static String fetchMessage(String loanId, String queueName) throws Exception {

		Connection connection = null;
		Session session = null;
		
		try {
			
			connection = initializeMSGBroker();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			String jmsMessageId = browseJMSMessageId(connection, session, queueName, loanId);
			Destination destination = session.createQueue(queueName);
			MessageConsumer consumer = session.createConsumer(destination, "JMSMessageID='"+jmsMessageId+"'");
			Message message = consumer.receive(1000);
			String text = "NA";
			
			if (message instanceof TextMessage) {
	            TextMessage textMessage = (TextMessage) message;
	            text = textMessage.getText();
	        }
			return text;
		} catch (JMSException e) {
			return "Not Valid";
		} finally {
			if (session != null) 
				session.close();
			if (connection != null)
				connection.close();
		}
	}
	
	
	/**
	 * Used to browse the queue and fetch the JMS message id.
	 * 
	 * @param queueName
	 * @param loanID
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private static String browseJMSMessageId(
			Connection connection,
			Session session, 
			String queueName, 
			String loanId) throws Exception {
		
		try {
			
			ActiveMQQueue prefetchQueue = new ActiveMQQueue(queueName + "?jms.prefetchSize=50");
			
			QueueBrowser browser = session.createBrowser(prefetchQueue);
			Enumeration<Message> browserView = browser.getEnumeration();
	    
			ActiveMQTextMessage message = null;
			String text;
	        while (browserView.hasMoreElements()) {
	        	
	        	message = (ActiveMQTextMessage) browserView.nextElement();
	        	text = message.getText();
	        	if (text.contains("\"loanId\": \"" + loanId + "\"")
	        			|| text.contains("<loanId>" + loanId + "</loanId>")) {
	        		return message.getJMSMessageID();
	        	}
	        }
	        
			return "NA";
		} catch (JMSException e) {
			return "Not Valid";
		} 
	}
	
	/**
	 * Initialize messaging broker context.
	 * 
	 * @throws Exception
	 */
	private static Connection initializeMSGBroker() throws JMSException {
		
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"admin", 
				"admin", 
//				"tcp://realeaidev01.altidev.net:61616");
				"tcp://localhost:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		return connection;
	}
}
