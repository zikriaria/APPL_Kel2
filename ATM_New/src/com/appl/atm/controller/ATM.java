/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.controller;

import com.appl.atm.model.BalanceInquiry;
import com.appl.atm.model.BankDatabase;
import com.appl.atm.model.CashDispenser;
import com.appl.atm.model.Deposit;
import com.appl.atm.model.DepositSlot;
import com.appl.atm.model.Transaction;
import com.appl.atm.model.Withdrawal;
import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;
import static com.appl.atm.model.Constants.*;

/**
 *
 * @author Annazar
 */
public class ATM {
    private int userAuthenticated;
    private int currentAccountNumber; // current user's account number
    private Screen screen; // ATM's screen
    private Keypad keypad; // ATM's keypad
    private CashDispenser cashDispenser; // ATM's cash dispenser
    private DepositSlot depositSlot;
    private BankDatabase bankDatabase; // account information database


    public ATM() {
	userAuthenticated = 0;
	currentAccountNumber = 0;
	screen = new Screen();
	keypad = new Keypad();
	cashDispenser = new CashDispenser();
	depositSlot = new DepositSlot();
	bankDatabase = new BankDatabase();
    }

    // start ATM 
    public void run() {
	// welcome and authenticate user; perform transactions
	while (true) {
	    // loop while user is not yet authenticated
	    screen.displayMessageLine("\nWelcome!\n");
	    while (userAuthenticated != 1) {
		authenticateUser(); // authenticate user
	    }

	    performTransactions(); // user is now authenticated
	    userAuthenticated = 0; // reset before next ATM session
	    currentAccountNumber = 0; // reset before next ATM session
	    screen.displayMessageLine("\nThank you! Goodbye!");
	}
    }

    // attempts to authenticate user against database
    private void authenticateUser() {
	screen.displayMessage("Please enter your account number\t: ");
	int accountNumber = keypad.getInput(); // input account number
	screen.displayMessage("Enter your PIN\t\t\t\t: "); // prompt for PIN
	int pin = keypad.getInput(); // input PIN

	// set userAuthenticated to boolean value returned by database
	userAuthenticated
		= bankDatabase.authenticateUser(accountNumber, pin);

	// check whether authentication succeeded
	if (userAuthenticated == 1) {
	    currentAccountNumber = accountNumber; // save user's account #
	} else {
	    screen.displayMessageLine(
		    "Invalid account number or PIN. Please try again.\n");
	}
    }

    // display the main menu and perform transactions
    private void performTransactions() {
	// local variable to store transaction currently being processed
	Transaction currentTransaction = null;
	TransactionController currentTransactionController = null;

	boolean userExited = false; // user has not chosen to exit

	// loop while user has not chosen option to exit system
	while (!userExited) {
	    // show main menu and get user selection
	    int mainMenuSelection = displayMainMenu();

	    // decide how to proceed based on user's menu selection
	    switch (mainMenuSelection) {
		// user chose to perform one of three transaction types
		case BALANCE_INQUIRY:

		    // initialize as new object of chosen type
		    currentTransaction
			    = createTransaction(mainMenuSelection);
		    currentTransactionController
			    = new BalanceInquiryController(currentTransaction, keypad, screen);
		    currentTransactionController.run(); // execute transaction
		    break;
		    
		case WITHDRAWAL:
		    currentTransaction
			    = createTransaction(mainMenuSelection);
		    currentTransactionController
			    = new WithdrawalController(currentTransaction, keypad, screen);
		    currentTransactionController.run(); // execute transaction
		    break;
		    
		case DEPOSIT:
		    currentTransaction
			    = createTransaction(mainMenuSelection);
		    currentTransactionController
			    = new DepositController(currentTransaction, keypad, screen);
		    currentTransactionController.run(); // execute transaction
		    break;
		    
		case EXIT: // user chose to terminate session
		    screen.displayMessageLine("\nExiting the system...");
		    userExited = true; // this ATM session should end
		    break;
		    
		default: // 
		    screen.displayMessageLine(
			    "\nYou did not enter a valid selection. Try again.");
		    break;
	    }
	}
    }

    // display the main menu and return an input selection
    private int displayMainMenu() {
	screen.displayMessageLine("\nMain menu:");
	screen.displayMessageLine("1 - View my balance");
	screen.displayMessageLine("2 - Withdraw cash");
	screen.displayMessageLine("3 - Deposit funds");
	screen.displayMessageLine("4 - Exit\n");
	screen.displayMessage("Enter a choice: ");
	return keypad.getInput(); // return user's selection
    }

    private Transaction createTransaction(int type) {
	Transaction temp = null;

	switch (type) {
	    case BALANCE_INQUIRY:
		temp = new BalanceInquiry(
			currentAccountNumber, bankDatabase);
		break;
	    case WITHDRAWAL:
		temp = new Withdrawal(
			currentAccountNumber, bankDatabase, cashDispenser);
		break;
	    case DEPOSIT:
		temp = new Deposit(
			currentAccountNumber, bankDatabase, depositSlot);
		break;
	}

	return temp;
    }

}