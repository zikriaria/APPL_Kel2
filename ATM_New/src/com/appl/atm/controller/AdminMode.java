/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.controller;

import com.appl.atm.model.Account;
import com.appl.atm.model.BankDatabase;
import com.appl.atm.model.CashDispenser;
import com.appl.atm.model.Transaction;
import com.appl.atm.model.ValidateDeposit;
import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;

/**
 *
 * @author Asus
 */
public class AdminMode {

    private static final int ADD_ACCOUNT = 1;
    private static final int UNBLOCK_ACCOUNT = 2;
    private static final int VIEW_DISPENSER = 3;
    private static final int ADD_DISPENSER = 4;
    private static final int VALIDATE_DEPOSIT = 5;
    private static final int QUIT = 6;
    private BankDatabase bankDatabase;
    private CashDispenser cashDispenser;
    private Keypad keypad;
    private Screen screen;
    private int currentAccountNumber;

    AdminMode(BankDatabase paramBankDatabase, CashDispenser paramCashDispenser) {
        bankDatabase = paramBankDatabase;
        cashDispenser = paramCashDispenser;
        screen = new Screen();
        keypad = new Keypad();
    }

    public void execute() {

        Transaction currentTransaction = null;
        TransactionController currentTransactionController = null;

        int option = 0;
        while (option != 6) {
            screen.displayMessageLine("Admin Mode");
            screen.displayMessageLine("1. Add account");
            screen.displayMessageLine("2. Unblock account");
            screen.displayMessageLine("3. View money from Dispenser");
            screen.displayMessageLine("4. Add money to Dispenser");
            screen.displayMessageLine("5. Validasi Deposit");
            screen.displayMessageLine("6. Quit");
            screen.displayMessage("Choose an option number: ");
            option = keypad.getInput();
            switch (option) {
                case ADD_ACCOUNT:
                    screen.displayMessageLine("\nAdd Account");
                    screen.displayMessage("Insert new account number: ");
                    int addedAccountNumber = keypad.getInput();
                    screen.displayMessage("Insert new account PIN: ");
                    int addedAccountPIN = keypad.getInput();
                    screen.displayMessage("Insert Account Type: ");
                    int addedNewType = keypad.getInput();
                    screen.displayMessage("Insert available balance: ");
                    double addedAvailableBalance = keypad.getInput();
                    screen.displayMessage("Insert total balance: ");
                    double addedTotalBalance = keypad.getInput();
                    bankDatabase.addAccount(addedAccountNumber, addedAccountPIN, addedAvailableBalance, addedTotalBalance, addedNewType);
                    screen.displayMessageLine("New account has been added\n");
                    break;
                case UNBLOCK_ACCOUNT:
                    screen.displayMessage("Enter the account number to unblock: ");
                    int accountNumber = keypad.getInput();
                    bankDatabase.getAccount(accountNumber).setBlocked(false);
                    screen.displayMessageLine("The account has been unblocked.\n");
                    break;
                case VIEW_DISPENSER:
                    cashDispenser.displayDispenser();
//              screen.displayMessageLine("view dispenser");
                    break;
                case ADD_DISPENSER:
                    screen.displayMessage("Insert a number to cash dispenser : ");
                    double add = keypad.getInput();
                    cashDispenser.addCashDispenser((int) add);
//              screen.displayMessageLine("add dispenser");
                    break;
                case VALIDATE_DEPOSIT:
                    currentTransaction
                            = new ValidateDeposit(
                                    currentAccountNumber, screen, bankDatabase, keypad);
                    currentTransactionController
                            = new ValidateDepositController(currentTransaction, keypad, screen);
                    currentTransactionController.run(); // execute transaction
                    break;
                case QUIT:
                    screen.displayMessageLine("Quit....");
                    break;
                default:
                    break;
            }
        }
    }
}
