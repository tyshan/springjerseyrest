package cn.tyshan.rest.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import cn.tyshan.rest.model.Profile;
import cn.tyshan.rest.model.User;

@Service
public class UserService {

	private static final Log log = LogFactory.getLog(UserService.class);
	private static final AtomicInteger counter = new AtomicInteger(0);

	public User getUser() {
		log.debug("get user ...");
		int c = counter.incrementAndGet();
		User user = new User(String.format("u%d", c));
		user.setProfile(getProfile());
		return user;
	}

	private static Profile getProfile() {
		Profile profile = new Profile();
		int order = getFieldOrder();
		switch (order) {
		case 2:
			profile.setAttrC(String.format("C%d", getAttrSuffix()));
		case 1:
			profile.setAttrB(String.format("B%d", getAttrSuffix()));
		case 0:
			profile.setAttrA(String.format("A%d", getAttrSuffix()));
		default:
		}
		return profile;
	}

	private static int getFieldOrder() {
		return (int) (Math.random() * 100) % 3;
	}

	private static int getAttrSuffix() {
		return (int) (Math.random() * 200);
	}
}
