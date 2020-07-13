package org.corebanking.depositaccount.contract;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Map;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContractApplicationTests {
	/*
	@LocalServerPort
	private int port;
	private WebTestClient client;

	@BeforeAll
	public static void initAll() {
		System.out.println("---- Inside initAll() ----");
	}

	@BeforeEach
	public void init(TestInfo testInfo) {
		System.out.println("---- Starting... " + testInfo.getDisplayName() + " ----");
	}

	@Test
	public void test1() {
		client = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
		client.get().uri("/accounts")
			.exchange()
			.expectStatus().isOk()
			.expectBody(Map.class)
			.consumeWith(result -> {
				assertTrue(!result.getResponseBody().isEmpty());
			});
	}
	*/
}
