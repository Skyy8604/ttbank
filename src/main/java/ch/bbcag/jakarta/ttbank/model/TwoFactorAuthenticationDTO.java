package ch.bbcag.jakarta.ttbank.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TwoFactorAuthenticationDTO {

	@NotBlank(message = "code_cannot_be_blank")
	@NotNull(message = "code_cannot_be_null")
	private String code;

	@Email(message = "email_format_invalid")
	@NotBlank(message = "email_cannot_be_blank")
	@NotNull(message = "email_cannot_be_null")
	private String email;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}