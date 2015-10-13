package cn.tyshan.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;

@Component
@Path("/api/message")
public class MessageResource {

	@Path("hello")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response hello() {
		return Response.status(Status.OK).entity("Hello the world!!!").build();
	}

}
