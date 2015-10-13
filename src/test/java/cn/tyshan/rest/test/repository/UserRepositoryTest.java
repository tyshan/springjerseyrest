package cn.tyshan.rest.test.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.tyshan.rest.Application;
import cn.tyshan.rest.model.User;
import cn.tyshan.rest.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class })
@Transactional
@WebAppConfiguration
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;
	private User user;

	@Before
	public void setUp() {
		user = new User("foobar");
	}

	@Test
	public void findUserById() {

		user = repository.save(user);

		assertEquals(user, repository.findOne(user.getId()));
	}

}
