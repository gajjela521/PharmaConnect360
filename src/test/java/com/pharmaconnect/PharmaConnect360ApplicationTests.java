package com.pharmaconnect;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


@TestPropertySource(properties = {
		"cloud.aws.region.static=us-east-1",
		"cloud.aws.credentials.access-key=AKIASFUIRL4KID22EZR2",
		"cloud.aws.credentials.secret-key=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",
		"cloud.aws.sqs.queue.url=https://sqs.us-east-1.amazonaws.com/149536464660/PharmOrderQueue_01"

})
@SpringBootTest(classes = PharmaConnect360Application.class)
public class PharmaConnect360ApplicationTests {

	@Test
	void contextLoads() {
	}

}
