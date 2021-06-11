package ch.bbcag.jakarta.ttbank.controller;

import ch.bbcag.jakarta.ttbank.model.User;
import ch.bbcag.jakarta.ttbank.service.JwtService;
import ch.bbcag.jakarta.ttbank.service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("user")
public class UserController {

	@Inject
	UserService userService;

	@Inject
	JwtService jwtService;

	@POST
	@Path("signup")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response register(@Valid User user) {
		user = userService.register(user.getEmail(), user.getLastName(), user.getFirstName(), user.getPassword());

		return Response
				.status(200)
				.entity(user)
				.build();
	}
}
