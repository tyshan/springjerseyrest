package cn.tyshan.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.tyshan.rest.model.User;
import cn.tyshan.rest.service.UserService;

/**
 * User generate resource
 *
 */
@Component
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserGenerateResource {

	@Autowired
	private UserService userService;

	/**
	 * output a user with serializable username
	 * 
	 * @return
	 */
	@GET
	public User getUser() {
		return userService.getUser();
	}
}
