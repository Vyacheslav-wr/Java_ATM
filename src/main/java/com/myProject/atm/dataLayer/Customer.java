package com.myProject.atm.dataLayer;

import com.myProject.atm.buisnessLayer.MoneyTransactions;

public class Customer {
    private String firstName;

    private String lastName;

    private long cardNumber;

    private Integer cardPIN;

    private Integer state;

    private Integer balance;

    public void setState(Integer state) {
        this.state = state;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardPIN(Integer cardPIN) {
        this.cardPIN = cardPIN;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getBalance() {
        return balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public Integer getCardPIN() {
        return cardPIN;
    }

    public Integer getState() {
        return state;
    }

    public Customer() {
    }


    public Customer(String firstName, String lastName, long cardNumber, Integer cardPIN, Integer state, Integer balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardNumber = cardNumber;
        this.cardPIN = cardPIN;
        this.state = state;
        this.balance = balance;
    }

    protected void checkBalance(){
       MoneyTransactions.showBalance(this.balance);
    }

    protected void topUpBalance(){
        MoneyTransactions.putMoney(this.cardNumber);
    }

    @Override
    public String toString() {
        return (this.firstName + " " + this.lastName + " " + this.cardNumber + " " +
                this.cardPIN + " " + this.state + " " + this.balance);
    }
}
