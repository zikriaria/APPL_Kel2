/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

/**
 *
 * @author Annazar
 */
public abstract class Transaction {
    private int accountNumber; // indicates account involved
    private BankDatabase bankDatabase; // account database
    
    public Transaction(int userAccountNumber, BankDatabase atmBankDatabase) {
        accountNumber = userAccountNumber;
        bankDatabase = atmBankDatabase;
    }
    
    public abstract int execute();

    /**
     * @return the accountNumber
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the bankDatabase
     */
    public BankDatabase getBankDatabase() {
        return bankDatabase;
    }

    /**
     * @param bankDatabase the bankDatabase to set
     */
    public void setBankDatabase(BankDatabase bankDatabase) {
        this.bankDatabase = bankDatabase;
    }
}