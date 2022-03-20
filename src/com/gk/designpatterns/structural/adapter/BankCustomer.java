package com.gk.designpatterns.structural.adapter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BankCustomer extends BankDetails implements CreditCard{



    @Override
    public void giveBankDetails() {
        try{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the account holder name :");
        String customername=br.readLine();
        System.out.print("\n");

        System.out.print("Enter the account number:");
        long accno=Long.parseLong(br.readLine());
        System.out.print("\n");

        System.out.print("Enter the bank name :");
        String bankname=br.readLine();

        setAccountHolderName(customername);
        setAccountNo(accno);
        setBankName(bankname);
    }catch(Exception e){
        e.printStackTrace();
    }
}

    @Override
    public String getCreditCard() {
        long accno=getAccountNo();
        String accholdername=getAccountHolderName();
        String bname=getBankName();
        return ("The Account number "+accno+" of "+accholdername+" in "+bname+ " bank is valid and authenticated for issuing the credit card. ");
    }
}
