package com.entregaa3.customerserviceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApiApplication.class, args);
	}

	@Bean
	public ReceiverChannel runReceiverChannel() {
		ReceiverChannel receiverChannel = new ReceiverChannel("customer-service");

		receiverChannel.run();

		return receiverChannel;
	}
}
