package cn.tyshan.rest.test.resource;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import cn.tyshan.rest.Application;
import cn.tyshan.rest.model.Campaign;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
@WebAppConfiguration
@org.springframework.boot.test.IntegrationTest("server.port=3000")
public class CampaignGenerateResourceTest {

	private static final String CAMPAIGN_URL = "http://localhost:3000/campaign?x=10&y=10&z=1000";

	private RestTemplate restTemplate = new TestRestTemplate("demo", "123");

	@Test
	public void compaignGenerate() throws Exception {

		ResponseEntity<List<Campaign>> responseEntity = restTemplate.exchange(CAMPAIGN_URL, HttpMethod.GET, null,
				getParameterizedPageTypeReference());
		List<Campaign> campaigns=responseEntity.getBody();
		Assert.assertEquals(1000, campaigns.size());
	}

	private ParameterizedTypeReference<List<Campaign>> getParameterizedPageTypeReference() {
		return new ParameterizedTypeReference<List<Campaign>>() {
		};
	}

}
