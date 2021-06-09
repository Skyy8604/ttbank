package ch.bbcag.jakarta.ttbank.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity(name = "position")
public class Position {

    @Id
    @NotBlank(message = "email_cannot_be_blank")
    @NotNull(message = "email_cannot_be_null")
    private String id;

    @ManyToOne
    @JsonbTransient
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "purchase_date", insertable = false, updatable = false)
    private Timestamp purchaseDate;

    @Column(name = "purchase_price")
    private float purchasePrice;

    private float change;

    @Column(name = "change_percentage")
    private float changePercentage;

    private float high;

    private float low;

    @Column(name = "num_of_bought_stocks")
    private float numOfBoughtStocks;

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

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public float getChange() {
        return change;
    }

    public void setChange(float change) {
        this.change = change;
    }

    public float getChangePercentage() {
        return changePercentage;
    }

    public void setChangePercentage(float changePercentage) {
        this.changePercentage = changePercentage;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getNumOfBoughtStocks() {
        return numOfBoughtStocks;
    }

    public void setNumOfBoughtStocks(float numOfBoughtStocks) {
        this.numOfBoughtStocks = numOfBoughtStocks;
    }
}
