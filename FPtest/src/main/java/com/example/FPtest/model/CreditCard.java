/*
package com.example.FPtest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "CreditCards")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CreditCard {

    @Id
    @Column(name = "cardNumber", unique = true, nullable = false)
    private BigInteger cardNumber;
    @Column(name = "expirationDate")
    private Integer expirationDate; //FIXX******
    @Column(name = "securityCode")
    private Integer securityCode;
    @Column(name = "cardName")
    private String cardName;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "userID", nullable = false)
    @JsonIgnore
    private User user;

    //For Deserialization
    public CreditCard() {}

    public CreditCard(String cardName, BigInteger cardNumber, Integer expirationDate, Integer securityCode) {
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }

    public BigInteger getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(BigInteger cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Integer expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(Integer securityCode) {
        this.securityCode = securityCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}

 */



