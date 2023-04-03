package com.acme.pulsar;

import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.common.schema.SchemaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.pulsar.annotation.PulsarListener;
import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class PulsarApplication {

	public static void main(String[] args) {
		SpringApplication.run(PulsarApplication.class, args);
	}

	@Autowired
	private PulsarTemplate<User> userTemplate;

	@Autowired
	private UserService userService;

	@Scheduled(initialDelay = 2_000, fixedDelay = 1_000)
	void sourceUserIntoPulsarTopic() throws PulsarClientException {
		var msgId = userTemplate.send(userService.singleUser());
		System.out.println("*** PRODUCE: " + msgId);
	}

	@PulsarListener
	void logUserFromPulsarTopic(User user) {
		System.out.println("*** CONSUME: " + user);
	}

	public record User(String uid, String username) {

	}
}
