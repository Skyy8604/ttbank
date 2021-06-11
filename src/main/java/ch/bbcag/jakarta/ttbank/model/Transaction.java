package ch.bbcag.jakarta.ttbank.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity(name = "transaction")
public class Transaction {

	@Id
	@NotBlank(message = "id_cannot_be_blank")
	@NotNull(message = "id_cannot_be_null")
	private String id;

	@ManyToOne
	@JsonbTransient
	@JoinColumn(name = "sender_account_id")
	private MoneyAccount senderAccountId;

	@ManyToOne
	@JsonbTransient
	@JoinColumn(name = "receiver_account_id")
	private MoneyAccount receiverAccountId;

	@Column(name = "datetime", insertable = false, updatable = false)
	private Timestamp dateTime;

	private float amount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MoneyAccount getSenderAccountId() {
		return senderAccountId;
	}

	public void setSenderAccountId(MoneyAccount senderAccountId) {
		this.senderAccountId = senderAccountId;
	}

	public MoneyAccount getReceiverAccountId() {
		return receiverAccountId;
	}

	public void setReceiverAccountId(MoneyAccount receiverAccountId) {
		this.receiverAccountId = receiverAccountId;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
}
