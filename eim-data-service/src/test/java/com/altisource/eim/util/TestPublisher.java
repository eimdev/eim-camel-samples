package com.altisource.eim.util;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TestPublisher {

	public static void main(String[] a) throws Exception {
		
		/*final String message = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?> \n" +
							"<loanClosureDetails> <loanId>LN00025</loanId> \n" +
							"<propertyId>PID235</propertyId> \n" +
							"<foreclosureId>FID3435</foreclosureId> \n" +
							"<foreclosureStatus>Pending</foreclosureStatus> \n" +
							"<foreclosureSubStatus>New</foreclosureSubStatus> \n" +
							"<foreclosureAcquired>true</foreclosureAcquired> \n" +
							"<foreclosureComments>publish</foreclosureComments> \n" +
							"<submittedByUser>James</submittedByUser> \n" +
							"<submittedDate>2015-04-29T00:00:00+05:30</submittedDate> \n" +
							"<type>INVESTOR</type> \n" +
							"</loanClosureDetails>";*/
		
		final String message = "{ " +
							"\"foreclosureAcquired\": \"true\"," +
							"\"foreclosureComments\": \"publish message\"," +
							"\"foreclosureId\": \"FID1233\"," +
							"\"foreclosureStatus\": \"New\"," +
							"\"foreclosureSubStatus\": \"New\"," +
							"\"loanId\": \"LN00128\"," +
							"\"propertyId\": \"PID1234\"," +
							"\"submittedByUser\": \"thomas\"," +
							"\"submittedDate\": \"2015-04-17\"," +
							"\"type\": \"Borrower\" " +
							"}"; 

		if(TestPublisher.publishMessage(message, "PS_OUTQ")) 
			
			System.out.println("Below message is published(PS_OUTQ) successfully >> \n" + message);
		else
			System.out.println("Couldnt publish a message \n >> " + message);
	}
	
	public static boolean publishMessage(String message, String queueName) throws Exception {
		
		Connection connection = null;
		Session session = null;
		
		try {
			
			System.out.println("Queue Name >> " + queueName);
			connection = initializeMSGBroker();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue(queueName);
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			TextMessage txtMessage = session.createTextMessage(message);
			producer.send(txtMessage);
			return true;
		} catch (JMSException e) {
			return false;
		} finally {
			if (session != null) 
				session.close();
			if (connection != null)
				connection.close();
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
