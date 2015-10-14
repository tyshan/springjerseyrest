package cn.tyshan.rest.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import cn.tyshan.rest.model.User;
import cn.tyshan.rest.repository.UserRepository;

/**
 * User resource
 *
 */
@Component
@Path("/api/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserRequestResource {

	private static final Logger log = LoggerFactory.getLogger(UserRequestResource.class);

	@Autowired
	private UserRepository userRepository;

	@Context
	private UriInfo uriInfo;

	/**
	 * save a user
	 * @param user
	 * @return
	 */
	@POST
	public Response save(User user) {
		log.debug("save user : {}", user);
		userRepository.save(user);
		log.debug("saved user : {}", user);
		URI location = uriInfo.getAbsolutePathBuilder().path("{id}").resolveTemplate("id", user.getId()).build();
		log.debug("find user by uri {}", location);
		return Response.created(location).build();
	}

	/**
	 * find a user by id
	 * @param id
	 * @return
	 */
	@GET
	@Path("{id}")
	public User findById(@PathParam("id") Long id) {
		log.debug("find user by id {}", id);
		return userRepository.findOne(id);
	}

	/**
	 * delete a user by id
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("{id}")
	public Response deleteUser(@PathParam("id") Long id) {
		log.debug("delete user by id {}", id);
		userRepository.delete(id);
		return Response.accepted().build();
	}

	/**
	 * find user by page,size
	 * @param page
	 * @param size
	 * @param sort
	 * @param direction
	 * @return
	 */
	@GET
	public Page<User> findUsers(@QueryParam("page") @DefaultValue("0") int page,
			@QueryParam("size") @DefaultValue("10") int size,
			@QueryParam("sort") @DefaultValue("username") List<String> sort,
			@QueryParam("direction") @DefaultValue("asc") String direction) {

		return userRepository.findAll(
				new PageRequest(page, size, Sort.Direction.fromString(direction), sort.toArray(new String[0])));
	}
}
