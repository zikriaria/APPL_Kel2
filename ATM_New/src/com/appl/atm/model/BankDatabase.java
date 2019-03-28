/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

import static com.appl.atm.model.Constants.TRANSFER;
import static com.appl.atm.model.Constants.WITHDRAWAL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author Annazar
 */
public class BankDatabase {
    
    private ArrayList<Account> accounts; // array of Accounts
    private ArrayList<Statement> bankStatements;
    
    public BankDatabase() {
        accounts = new ArrayList<Account>();
	accounts.add(new Account(1234, 4321, 1000.0, 1200.0));
	accounts.add(new Account(8765, 5678, 200.0, 200.0));
    }
    
    public Account getAccount(int accountNumber) {
	int i;
        for (i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accountNumber) {
                return accounts.get(i);
            }
        } 
        return null; // if no matching account was found, return null
    }
    
    public boolean addAccount(int addAccountNumber, int addAccountPIN, double addAvailableBalance, double addTotalBalance) {
        return accounts.add(new Account(addAccountNumber, addAccountPIN, addAvailableBalance, addTotalBalance)); 
    }
    
    public int authenticateUser(int userAccountNumber, int userPIN)
    {
	Account userAccount = getAccount(userAccountNumber);
	
	if(userAccount != null)
	{
	    if(userAccount.getPin() == userPIN)
	    {
		return 1;
	    }
	    else
	    {
		return 2;
	    }
	}
	else
	{
	    return 2;
	}
    }
       public ArrayList<Statement> getBankStatement(int accountNumber) {
	ArrayList<Statement> result = new ArrayList<Statement>();

	for (int i = 0; i < bankStatements.size(); i++) {
	    if (bankStatements.get(i).getTransaction().getAccountNumber() == accountNumber) {
		result.add(bankStatements.get(i));
	    }
	}

	return result.isEmpty() ? null : result;
    }

    public ArrayList<Statement> getBankStatementMonth(int accountNumber, int month) {
	ArrayList<Statement> result = new ArrayList<Statement>();

	for (int i = 0; i < bankStatements.size(); i++) {
	    if (bankStatements.get(i).getTransaction().getAccountNumber() == accountNumber
		    && bankStatements.get(i).getDate().getMonth() == month
		    && bankStatements.get(i).getTransacionType() == WITHDRAWAL) {
		
		result.add(bankStatements.get(i));
	    }
	}

	Collections.sort(result);
	Collections.reverse(result);
	return result.isEmpty() ? null : result;
    }

    public ArrayList<Statement> getBankStatementToday(int accountNumber) {
	ArrayList<Statement> result = new ArrayList<Statement>();
	Date date = new SystemDate(0,null,null,null).getCurrDate();
	
	for (int i = 0; i < bankStatements.size(); i++) {
	    if (bankStatements.get(i).getTransaction().getAccountNumber() == accountNumber
		    && bankStatements.get(i).getDate().compareTo(date) == 0
		    && bankStatements.get(i).getTransacionType() == TRANSFER) {
		
		result.add(bankStatements.get(i));
	    }
	}

	return result.isEmpty() ? null : result;
    }

    public void addBankStatement(Statement theStatement) {
	bankStatements.add(theStatement);
    }
}
