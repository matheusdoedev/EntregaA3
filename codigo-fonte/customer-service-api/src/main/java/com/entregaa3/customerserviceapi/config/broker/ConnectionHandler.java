package com.entregaa3.customerserviceapi.config.broker;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public abstract class ConnectionHandler implements Runnable {

	protected String queueName;
	protected Channel channel;
	protected Connection connection;

	protected ConnectionHandler(String queueName) {
		this.queueName = queueName;
		this.initConnection();
	}

	protected void initConnection() {
		try {
			ConnectionFactory factory = new ConnectionFactory();

			factory.setHost("localhost");
			factory.setUri("amqp://docker:docker@localhost:5672");

			connection = factory.newConnection();
			channel = connection.createChannel();
		} catch (TimeoutException | KeyManagementException | NoSuchAlgorithmException | URISyntaxException
				| IOException exception) {
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
	}
}
