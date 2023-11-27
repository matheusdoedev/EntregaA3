package com.entregaa3.sellsserviceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.entregaa3.sellsserviceapi.config.broker.ReceiverChannel;

@SpringBootApplication
public class SellsServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellsServiceApiApplication.class, args);

	}

	@Bean
	public ReceiverChannel runReceiverChannel() {
		ReceiverChannel receiverChannel = new ReceiverChannel("sells-service");

		receiverChannel.run();

		return receiverChannel;
	}
}
