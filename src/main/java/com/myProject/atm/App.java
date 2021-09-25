package com.myProject.atm;

import com.myProject.atm.ConsoleView.AtmView;
import com.myProject.atm.dataLayer.ATM;
import com.myProject.atm.dataLayer.AtmInterface;

import java.util.Scanner;

public class App {
    public static void main(String[] argv) {
        AtmInterface ATM = new ATM();
        AtmView.showFunctions();
        Scanner in = new Scanner(System.in);

        //ATM.createCustomer();
while(true){
        switch(in.nextInt()){
            case 1:{
                ATM.checkBalance();
                break;
            }
            case 2:{
                ATM.getMoney(ATM.getCardNumber());
                break;
            }
            case 3:{
                ATM.topUpBalance();
                break;
            }
        }
}
    }
}
