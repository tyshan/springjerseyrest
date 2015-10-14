package cn.tyshan.rest.test.resource;

import java.net.URI;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import cn.tyshan.rest.Application;
import cn.tyshan.rest.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
@WebAppConfiguration
@org.springframework.boot.test.IntegrationTest("server.port=3000")
@Sql(scripts = "classpath:data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class UserRequestResourceTest {

	private static final String USER_URL = "http://localhost:3000/api/user";

	private RestTemplate restTemplate = new TestRestTemplate("demo", "123");

	private final User user=new User("username");
	@Test
	public void save() throws Exception {
		URI uri = restTemplate.postForLocation(USER_URL, user);
		// assert
		ResponseEntity<User> responseEntity = restTemplate.getForEntity(uri, User.class);

		User temp = responseEntity.getBody();

		Assert.assertNotNull(temp.getUsername());
	}

	@Test
	public void findUserByIdTest() throws Exception {
		// assert
		ResponseEntity<User> responseEntity = restTemplate.getForEntity(USER_URL + "/1", User.class);

		User user = responseEntity.getBody();
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getUsername());
	}

	@Test
	public void findAllTest() throws Exception {
		ResponseEntity<Page<User>> responseEntity = getUsers(USER_URL);
		Page<User> userPage = responseEntity.getBody();
		// assert
		PageAssertion.assertThat(userPage).hasTotalElements(2).hasTotalPages(1).hasPageSize(10).hasPageNumber(0)
				.hasContentSize(2);
	}

	@Test()
	public void findUserPage() throws Exception {

		// act
		ResponseEntity<Page<User>> responseEntity = getUsers(USER_URL + "?page=0&size=1&sort=username&direction=desc");
		// assert
		Page<User> userPage = responseEntity.getBody();

		PageAssertion.assertThat(userPage).hasTotalElements(2);
		PageAssertion.assertThat(userPage).hasTotalPages(2);
		PageAssertion.assertThat(userPage).hasPageSize(1);
		PageAssertion.assertThat(userPage).hasPageNumber(0);
		PageAssertion.assertThat(userPage).hasContentSize(1);
	}

	private ResponseEntity<Page<User>> getUsers(String uri) {
		return restTemplate.exchange(uri, org.springframework.http.HttpMethod.GET, null,
				getParameterizedPageTypeReference());
	}

	private ParameterizedTypeReference<Page<User>> getParameterizedPageTypeReference() {
		return new ParameterizedTypeReference<Page<User>>() {
		};
	}

}
