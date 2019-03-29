/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.controller;

/**
 *
 * @author USER
 */
import com.appl.atm.model.BankDatabase;
import com.appl.atm.model.BankStatement;
import com.appl.atm.model.Statement;
import com.appl.atm.model.Transaction;
import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;
import java.util.ArrayList;


public class BankStatementController extends TransactionController {

    private BankStatement transaction;

    public BankStatementController(Transaction theTransaction, Keypad theKeypad, Screen theScreen) {
	super(theTransaction, theKeypad, theScreen);
	transaction = (BankStatement) getTransaction();

    }

    @Override
    public int run() {
	ArrayList<Statement> bankStatement = new ArrayList<Statement>();

	getScreen().displayMessageLine("\nBank statements");
		bankStatement = transaction.getBankStatements();
	if (bankStatement == null) {
	    getScreen().displayMessage("\nNo Bank Statement for This Account.\n");
	} else {
	    getScreen().displayMessageLine("\nAccount number : " + getAccountNumber());
	    for (int i = 0; i < bankStatement.size(); i++) {
		getScreen().displayMessageLine("- " + bankStatement.get(i).getTransaction().toString()
		    + "( " + bankStatement.get(i).getDate() + " )");
		 //langsung toString biar gausah bedain withdraw / transfer dll
	    }
	}

	return 0;
    }

    private int getAccountNumber() {
	return transaction.getAccountNumber();
    }

    private BankDatabase getBankDatabase() {
	return transaction.getBankDatabase();
    }

}

