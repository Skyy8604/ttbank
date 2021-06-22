package ch.bbcag.jakarta.ttbank.controller;

import ch.bbcag.jakarta.ttbank.exception.WrongEmailException;
import ch.bbcag.jakarta.ttbank.exception.WrongPasswordException;
import ch.bbcag.jakarta.ttbank.model.AuthRequestDTO;
import ch.bbcag.jakarta.ttbank.model.ErrorResponseDTO;
import ch.bbcag.jakarta.ttbank.model.ResponseDTO;
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
	private UserService userService;

	@Inject
	private JwtService jwtService;

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

	@POST
	@Path("signin")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(@Valid AuthRequestDTO userEmailPassword) {
		ResponseDTO responseDTO = new ResponseDTO();
		User user;

		try {
			user = userService.login(userEmailPassword.getEmail(), userEmailPassword.getPassword());
		} catch (WrongEmailException e) {
			ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO("wrong_email");
			return Response
					.status(Response.Status.UNAUTHORIZED)
					.entity(errorResponseDTO)
					.build();
		} catch (WrongPasswordException e) {
			ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO("wrong_password");
			return Response
					.status(Response.Status.UNAUTHORIZED)
					.entity(errorResponseDTO)
					.build();
		}


		responseDTO.setToken(jwtService.generateJwt(user.getEmail(), user.getFirstName(), user.getLastName()));
		return Response
				.status(Response.Status.OK)
				.entity(responseDTO)
				.build();
	}
}
