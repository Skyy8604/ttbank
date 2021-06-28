package ch.bbcag.jakarta.ttbank.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmailDTO {

	@Email(message = "email_format_invalid")
	@NotBlank(message = "email_cannot_be_blank")
	@NotNull(message = "email_cannot_be_null")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}