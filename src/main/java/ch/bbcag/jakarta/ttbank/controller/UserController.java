package ch.bbcag.jakarta.ttbank.controller;

import ch.bbcag.jakarta.ttbank.common.RandomStringGenerator;
import ch.bbcag.jakarta.ttbank.exception.WrongEmailException;
import ch.bbcag.jakarta.ttbank.exception.WrongPasswordException;
import ch.bbcag.jakarta.ttbank.model.*;
import ch.bbcag.jakarta.ttbank.service.JwtService;
import ch.bbcag.jakarta.ttbank.service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
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
		EmailDTO emailDTO = new EmailDTO();
		try {
			userService.login(userEmailPassword.getEmail(), userEmailPassword.getPassword());
			userService.saveTwoFactorCode(RandomStringGenerator.getRandomString(8), userEmailPassword.getEmail());
			//todo send email with code
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

		emailDTO.setEmail(userEmailPassword.getEmail());
		return Response
				.status(Response.Status.OK)
				.entity(emailDTO)
				.build();
	}

	@POST
	@Path("tfa")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response twoFactor(@Valid TwoFactorAuthenticationDTO twoFactorAuthenticationDTO) {
		ResponseDTO responseDTO = new ResponseDTO();

		if (userService.checkTwoFactorCode(twoFactorAuthenticationDTO.getCode(), twoFactorAuthenticationDTO.getEmail())) {
			userService.deleteTwoFactorCode(twoFactorAuthenticationDTO.getEmail());
			User user = userService.getUserByEmail(twoFactorAuthenticationDTO.getEmail());
			responseDTO.setToken(jwtService.generateJwt(user.getEmail(), user.getFirstName(), user.getLastName()));
			return Response
					.status(Response.Status.OK)
					.entity(responseDTO)
					.build();
		} else {
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(responseDTO)
					.build();
		}
	}
}