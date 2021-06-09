package ch.bbcag.jakarta.ttbank.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.lang.model.element.NestingKind;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity(name = "money_account")
public class MoneyAccount {

    @Id
    @NotBlank(message = "email_cannot_be_blank")
    @NotNull(message = "email_cannot_be_null")
    private String id;

    @ManyToOne
    @JsonbTransient
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank(message = "email_cannot_be_blank")
    @NotNull(message = "email_cannot_be_null")
    private String name;

    @NotBlank(message = "email_cannot_be_blank")
    @NotNull(message = "email_cannot_be_null")
    private float balance;

    @OneToMany(mappedBy = "senderAcountId")
    private Set<Transaction> transactionsSend;

    @OneToMany(mappedBy = "receiverAcountId")
    private Set<Transaction> transactionsReceive;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Set<Transaction> getTransactionsSend() {
        return transactionsSend;
    }

    public void setTransactionsSend(Set<Transaction> transactionsSend) {
        this.transactionsSend = transactionsSend;
    }

    public Set<Transaction> getTransactionsReceive() {
        return transactionsReceive;
    }

    public void setTransactionsReceive(Set<Transaction> transactionsReceive) {
        this.transactionsReceive = transactionsReceive;
    }
}
