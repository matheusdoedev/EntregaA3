package com.entregaa3.customerserviceapi.config.broker;

import java.io.IOException;

public class ReceiverChannel extends ConnectionHandler {

	public ReceiverChannel(String queueName) {
		super(queueName);
	}

	@Override
	public void run() {
		try {
			channel.queueDeclare(this.queueName, false, false, false, null);
			System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		} catch (IOException exception) {
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
	}
}
