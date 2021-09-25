package com.myProject.atm.buisnessLayer;

import com.myProject.atm.dataLayer.ATM;
import com.myProject.atm.dataLayer.Customer;

import java.io.*;

public class FileInputAndOutput {
    private final static String fileName = "src/main/resources/Customers.txt";

    public static void fileRead(){
        String[] subStr;
        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            subStr = line.split(" ");
            while(line != null){
                subStr = line.split(" ");
                try{
                    Customer cust = new Customer(subStr[0], subStr[1], Long.parseLong(subStr[2]), Integer.parseInt(subStr[3]),
                            Integer.parseInt(subStr[4]), Integer.parseInt(subStr[5]));
                    ATM.addToCustomersList(cust);
                }
                catch (IllegalArgumentException ex){
                    System.out.println("Incorrect file data");
                }
                line = br.readLine();
            }
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        catch (NullPointerException ex){
            ex.printStackTrace();
        }
    }

    public static void writeToFile(){
        try{
            FileWriter fw = new FileWriter(fileName, false);
            for(Customer customer : ATM.getAccounts().values()){
                String str = customer.toString() + "\n";
                fw.write(str);
                fw.flush();
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
