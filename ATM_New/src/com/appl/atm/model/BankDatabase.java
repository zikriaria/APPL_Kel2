/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

import java.util.ArrayList;
import static com.appl.atm.model.Constants.*;

/**
 *
 * @author Annazar
 */
public class BankDatabase {

    private ArrayList<Account> accounts; // array of Accounts
    private ArrayList<Statement> bankStatements;

    public BankDatabase() {
        bankStatements = new ArrayList<Statement>();
        accounts = new ArrayList<Account>();
        accounts.add(new Account(1234, 4321, 200.0, 200.0, false, STUDENT));
        accounts.add(new Account(8765, 5678, 1000.0, 1200.0, false, MASA_DEPAN));
        accounts.add(new Account(5555, 5555, 500.0, 500.0, false, BISNIS));
        accounts.add(new Account(0, 0, 0, 0, false, ADMIN));
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
    
//    public int authenticateUser(int userAccountNumber, int userPIN) //1 = true; 2 = false;
    public boolean addAccount(int addAccountNumber, int addAccountPIN, double addAvailableBalance, double addTotalBalance, int newType) {
        return accounts.add(new Account(addAccountNumber, addAccountPIN, addAvailableBalance, addTotalBalance, false, newType));
    }

    public int authenticateUser(int userAccountNumber, int userPIN) {
        Account userAccount = getAccount(userAccountNumber);

        if (userAccount != null) {
            if (userAccount.getPin() == userPIN) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 3; //false user number
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
    

    public void addBankStatement(Statement theStatement) {
        bankStatements.add(theStatement);
    }

}
