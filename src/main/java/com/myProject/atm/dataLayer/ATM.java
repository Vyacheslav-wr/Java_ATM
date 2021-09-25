package com.myProject.atm.dataLayer;

import com.myProject.atm.buisnessLayer.FileInputAndOutput;
import com.myProject.atm.buisnessLayer.MoneyTransactions;

import java.util.HashMap;
import java.util.Scanner;

public class ATM implements AtmInterface{
    private static HashMap<Long, Customer> Accounts = new HashMap<>();

    private static Integer atmBalance = 1000000000;

    public static HashMap<Long, Customer> getAccounts() {
        return Accounts;
    }

    public static Integer getAtmBalance() {
        return atmBalance;
    }

    public static void setAtmBalance(Integer atmBalance) {
        ATM.atmBalance = atmBalance;
    }

    public ATM() {
        FileInputAndOutput.fileRead();
    }

    public void createCustomer(){
        Long cardNumber;
        String fName;
        String lName;
        Integer pin;
        Integer balance;
        Scanner in = new Scanner(System.in);

        try{
            System.out.println("Enter your first name");
            fName = in.next();
            System.out.println("Enter your last name");
            lName = in.next();
            System.out.println("Enter your card number");
            cardNumber = in.nextLong();
            System.out.println("Enter your card pin");
            pin = in.nextInt();
            System.out.println("Enter your card balance");
            balance = in.nextInt();
            if(cardNumber < 1000000000000000L || cardNumber > 9999999999999999L || pin < 100 || pin > 999){
                System.out.println("Incorrect card number or card pin");
                return;
            }
            else{
                Customer customer = new Customer(fName, lName, cardNumber, pin, 1, balance);
                Accounts.put(customer.getCardNumber(), customer);
                System.out.println("New user added");
            }
        }
        catch(IllegalArgumentException ex){
            System.out.println("Incorrect input\n");
        }
        FileInputAndOutput.writeToFile();
    }

    public void getMoney(Long cardNumber){
        try{
        MoneyTransactions.getMoney(Accounts.get(cardNumber));
        }
        catch (NullPointerException ex){
            System.out.println("User doesnt exist\n");
        }
        FileInputAndOutput.writeToFile();
    }

    public Customer getCustomer(){
        Scanner in = new Scanner(System.in);

        try{
            System.out.println("Enter your card number");
            Customer customer = Accounts.get(in.nextLong());
            System.out.println("Enter your password");
            if (customer.getState() > 0){
                if(customer.getCardPIN() != in.nextInt()){
                    System.out.println("Incorrect password\n");
                }
                else{
                return customer;
                }
            }
        }
        catch(IllegalArgumentException ex){
            System.out.println("Invalid input\n");
        }
        return null;
    }

    public static void addToCustomersList(Customer customer){
        Accounts.put(customer.getCardNumber(), customer);
    }

    public void checkBalance(){
        try{
            getCustomer().checkBalance();
        }
        catch (NullPointerException ex){
            System.out.println("User doesnt exist or blocked\n");
        }
        FileInputAndOutput.writeToFile();
    }

    public void topUpBalance(){
        try{
            getCustomer().topUpBalance();
        }
        catch (NullPointerException ex){
            System.out.println("User doesnt exist or blocked");
        }
        FileInputAndOutput.writeToFile();
    }

    public Long getCardNumber(){
        try{
            return getCustomer().getCardNumber();
        }
        catch (NullPointerException ex){
            System.out.println("User doesnt exist or blocked");
        }
        return null;
    }
}
