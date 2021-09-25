package com.myProject.atm.dataLayer;

public interface AtmInterface {
    void getMoney(Long cardNumber);

    void createCustomer();

    Customer getCustomer();

    void checkBalance();

    void topUpBalance();

    Long getCardNumber();
}
