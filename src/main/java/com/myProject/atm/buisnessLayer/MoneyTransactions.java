package com.myProject.atm.buisnessLayer;

import com.myProject.atm.dataLayer.ATM;
import com.myProject.atm.dataLayer.Customer;
import java.util.Scanner;

public class MoneyTransactions {
    public static void putMoney(Long cardNumber){
        Integer money = 0;

        try{
            Customer customer = ATM.getAccounts().get(cardNumber);
            System.out.println("Enter the sum, that you want to put\n");
            Scanner in = new Scanner(System.in);
            money = in.nextInt();
            if(money >= 1000000){
                System.out.println("Invalid sum\n");
            }
            else{
                customer.setBalance(customer.getBalance() + money);
                System.out.println("Successful transaction");
            }
        }
        catch (IllegalArgumentException ex){
            System.out.println("Invalid sum\n");
        }
        catch (NullPointerException ex){
            System.out.println("User doesnt exist\n");
        }
    };

    public static void getMoney(Customer customer){
        Integer money = 0;

        try{
            System.out.println("Enter the sum, that you want to get\n");
            Scanner in = new Scanner(System.in);
            money = in.nextInt();
            if(ATM.getAtmBalance() < money || customer.getBalance() < money){
                System.out.println("Invalid sum\n");
            }
            else{
                customer.setBalance(customer.getBalance() - money);
                ATM.setAtmBalance(ATM.getAtmBalance() - money);
                System.out.println("Successful transaction");
            }
        }
        catch (IllegalArgumentException ex){
            System.out.println("Invalid sum\n");
        }
    }

    public static void showBalance(Integer balance){
        System.out.println("Your balance is: $ " + balance + "\n");
    }
}
