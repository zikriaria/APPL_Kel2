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
import com.appl.atm.model.Transfer;
import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;

/**
 *
 * @author Annazar
 */
public class TransferController extends TransactionController {

    private Transfer transaction;

    public TransferController(Transaction theTransaction, Keypad theKeypad, Screen theScreen) {
        super(theKeypad, theScreen);
        transaction = (Transfer) theTransaction;
    }

    @Override
    public int run() {
        Screen screen = getScreen();
        Keypad keypad = getKeypad();
        Account account = getBankDatabase().getAccount(getAccountNumber());
        if (account.getAccountType() == 2) {
            screen.displayMessage("Your account is Student can't Transfer");
        } else {
            screen.displayMessage("\nTransfer Menu\n");

            screen.displayMessage("Input your target account number\t: ");
            int target = keypad.getInput();
            screen.displayMessage("Input your transfer amount\t\t: ");
            int amount = keypad.getInput();

            if (amount > 0) {
                transaction.setTargetAccount(target);
                transaction.setAmount(amount);
                int res = transaction.execute();

                switch (res) {
                    case TRANSFER_SUCCESS:
                        screen.displayMessage("Transfer success.\n");
                        break;
                    case TRANSFER_UNSUCCESSFUL:
                        screen.displayMessage("Transfer Unsuccessfull.\n");
                        break;
                    case NEGATIVE_AMOUNT:
                        screen.displayMessage("The amount of transfer cant be negative\n");
                        break;
                    case SAME_ACCOUNT_NUMBER:
                        screen.displayMessage(
                                "\"Your Target\" not \"Your\" account number!"
                                + "\nIf you want to deposit money into your account, use the deposit option.\n");
                        break;
                    case USER_NOT_FOUND:
                        screen.displayMessage("The account number you just inputed is not exist.\n");
                        break;
                    case ACCOUNT_BALANCE_NOT_SUFFICIENT:
                        screen.displayMessage("The amount of your balance is insufficient!.\n");
                        break;
                }
            } else {
                screen.displayMessage("Cancelling transaction...\n");
            }
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
