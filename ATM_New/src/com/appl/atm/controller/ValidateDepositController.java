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
import com.appl.atm.model.Account;
import com.appl.atm.model.BankDatabase;
import static com.appl.atm.model.Constants.*;
import com.appl.atm.model.Transaction;
import com.appl.atm.model.ValidateDeposit;
import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;


public class ValidateDepositController extends TransactionController {
    
    private ValidateDeposit transaction;

    public ValidateDepositController(Transaction theTransaction,  Keypad theKeypad, Screen theScreen) {
	super(theTransaction, theKeypad, theScreen);
	transaction = (ValidateDeposit) theTransaction;
    }

    @Override
    public int run() {
	getScreen().displayMessage("\nInput target account number : ");
	int targetAccountNumber = getKeypad().getInput();
	transaction.setValidateTarget(targetAccountNumber);
	int res = transaction.execute();
	
	if (res == DEPOSIT_VALIDATE_SUCCESS) {
	    getScreen().displayMessageLine(targetAccountNumber + "'s deposit has been validated.");
	} else if (res == USER_NOT_VALIDATE) {
	    getScreen().displayMessageLine("Account not validate.");
	}
	
	return 0;
    }
    
    private int getAccountNumber() {
	return transaction.getAccountNumber();
    }

//    private Screen getScreen() {
//	return transaction.getScreen();
//    }

    private BankDatabase getBankDatabase() {
	return transaction.getBankDatabase();
    }

//    private Keypad getKeypad() {
//	return transaction.getKeypad();
//    }
    
}

