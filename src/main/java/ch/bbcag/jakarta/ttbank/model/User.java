package ch.bbcag.jakarta.ttbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity(name = "user")
public class User {

	@Id
	@NotBlank(message = "email_cannot_be_blank")
	@NotNull(message = "email_cannot_be_null")
	@Email(message = "email_format_invalid")
	private String email;

	@NotBlank(message = "name_cannot_be_blank")
	@NotNull(message = "name_cannot_be_null")
	@Column(name = "lname")
	private String lastName;

	@NotBlank(message = "name_cannot_be_blank")
	@NotNull(message = "name_cannot_be_null")
	@Column(name = "fname")
	private String firstName;

	@NotBlank(message = "password_cannot_be_blank")
	@NotNull(message = "password_cannot_be_null")
	@Pattern(regexp = "(?=.*[A-Z]+)(?=.*[0-9]+).{8,}", message = "invalid_password")
	private String password;

	@OneToMany(mappedBy = "user")
	private Set<Position> positions;

	@OneToMany(mappedBy = "user")
	private Set<MoneyAccount> moneyAccounts;


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Position> getPositions() {
		return positions;
	}

	public void setPositions(Set<Position> positions) {
		this.positions = positions;
	}

	public Set<MoneyAccount> getMoneyAccounts() {
		return moneyAccounts;
	}

	public void setMoneyAccounts(Set<MoneyAccount> moneyAccounts) {
		this.moneyAccounts = moneyAccounts;
	}
}
