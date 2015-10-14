package cn.tyshan.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;

/**
 * message resource
 *
 */
@Component
@Path("/api/message")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	/**
	 * say hello
	 * 
	 * @return
	 */
	@Path("hello")
	@GET
	public Response hello() {
		return Response.status(Status.OK).entity("Hello the world!!!").build();
	}

}
