package ch.bbcag.jakarta.ttbank.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "trading_account")
public class TradingAccount {

	@Id
	@NotBlank(message = "id_cannot_be_blank")
	@NotNull(message = "id_cannot_be_null")
	private String id;

	@ManyToOne
	@JsonbTransient
	@JoinColumn(name = "user_email")
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
