package cn.tyshan.rest.test.resource;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import cn.tyshan.rest.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
@IntegrationTest("server.port=9000")
@WebAppConfiguration
public class MessageResourceTest {
	private RestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void helloTest() {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("http://localhost:9000/api/message/hello",
				String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		assertEquals("Hello the world!!!", entity.getBody());
	}
}
