package cn.tyshan.rest.test.resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import cn.tyshan.rest.Application;
import cn.tyshan.rest.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
@WebAppConfiguration
@org.springframework.boot.test.IntegrationTest("server.port=3000")
public class UserGenerateResourceTest {

	private static final String USER_URL = "http://localhost:3000/user";

	private RestTemplate restTemplate = new TestRestTemplate("demo", "123");

	@Test
	public void userGenerate() throws Exception {

		ResponseEntity<User> responseEntity = restTemplate.getForEntity(USER_URL, User.class);
		User user = responseEntity.getBody();
		Assert.assertNotNull(user.getUsername());
	}

}
