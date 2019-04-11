/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

import static com.appl.atm.model.Constants.*;

/**
 *
 * @author Annazar
 */
public class Account {
    
    private int accountNumber; // account number
    private int pin; // PIN for authentication
    private double availableBalance; // funds available for withdrawal
    private double totalBalance; // funds available & pending deposits
    private double transferLimit;
    private int accountType;//to know your account type
    private boolean blocked; // for blocking account

    // Account constructor initializes attributes
    public Account(int theAccountNumber, int thePIN, 
	double theAvailableBalance, double theTotalBalance, boolean blocked, int theAccountType) {

	accountNumber = theAccountNumber;
	pin = thePIN;
	availableBalance = theAvailableBalance;
	totalBalance = theTotalBalance;
        this.blocked = blocked;
        accountType = theAccountType;
        
        switch (accountType){
            case BISNIS:
                transferLimit = 10000.0;
                break;
            case MASA_DEPAN:
                transferLimit =  500.0;
                break;
            case ADMIN:
                transferLimit = 0.0;
                break;
            case STUDENT:
                transferLimit = 0.0;
                break;
        }
        
    } 

    public void credit(double amount) {
	totalBalance += amount;
    }

    public void debit(double amount) {
	availableBalance -= amount;
	totalBalance -= amount;
    }

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
     * @return the pin
     */
    public int getPin() {
        return pin;
    }

    /**
     * @param pin the pin to set
     */
    public void setPin(int pin) {
        this.pin = pin;
    }

    /**
     * @return the availableBalance
     */
    public double getAvailableBalance() {
        return availableBalance;
    }

    /**
     * @param availableBalance the availableBalance to set
     */
    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    /**
     * @return the totalBalance
     */
    public double getTotalBalance() {
        return totalBalance;
    }

    /**
     * @param totalBalance the totalBalance to set
     */
    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }
    
    public void setBlocked(boolean blocked){
        this.blocked = blocked;
    }
    
    public boolean isBlocked(){
        return blocked;
    }
    
     public int getAccountType() {
        return accountType;
    }
}