package org.corebanking.gateway;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.test.web.reactive.server.WebTestClient;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GatewayApplicationTests {

	@LocalServerPort
	int port;
	private WebTestClient client;

	@BeforeAll
	public static void setup() {
		System.out.println("---Inside initAll---");
	}

	@BeforeEach
	public void init(TestInfo testInfo) {
		System.out.println("Start..." + testInfo.getDisplayName());
	}

	@Test
	public void temporal() {
		client = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
		client.get().uri("get")
			.exchange()
			.expectStatus().isOk()
			.expectBody(Map.class)
			.consumeWith(result -> {
				assertTrue(!result.getResponseBody().isEmpty());
			});
	}
}
