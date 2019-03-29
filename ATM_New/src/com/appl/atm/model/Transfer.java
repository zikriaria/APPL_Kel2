/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;
import static com.appl.atm.model.Constants.*;
import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;

/**
 *
 * @author USER
 */



public class Transfer extends Transaction {

    private int amount;
    private Keypad keypad;
    private Screen screen;
    private int targetAccount;
    

    public Transfer(int userAccountNumber, Screen atmScreen,
	    BankDatabase atmBankDatabase, Keypad atmKeyPad) {

	super(userAccountNumber, atmBankDatabase);
	keypad = atmKeyPad;
        screen = atmScreen;
        
    }

    @Override
    public int execute() {
	Account account = getBankDatabase().getAccount(getAccountNumber());
	Account target = getBankDatabase().getAccount(targetAccount);
	//double paymentTax = account.getTransferTax();
	if (target != null) {
	    if (amount < 0) {
		return NEGATIVE_AMOUNT;
	    } else if (account.getAccountType() == 1) {
                if (amount > 10000) {
                    return TRANSFER_UNSUCCESSFUL;
                }
            } else if (account.getAccountType() == 3) {
                if (amount > 500) {
                    return TRANSFER_UNSUCCESSFUL;
                }
        }
        else if (account.getAvailableBalance() < amount ) {
		return ACCOUNT_BALANCE_NOT_SUFFICIENT;
	    } else {
		account.debit(amount);
		target.debit(-1 * amount);
		//getBankDatabase().addBankStatement(new Statement(this, TRANSFER));
		return TRANSFER_SUCCESS;
	    } 
        }else {
	    return USER_NOT_FOUND;
        }
        return 0;

    }
  
//      public void limitTransfer(int target) {
//          if
//      }
//    public void limitTransfer(int target) {
//        if ( = BISNIS){
//            
//        }
//        if (amount > 500) {
//            this.targetAccount = target;
//            limitTransfer(target);
//        screen.displayMessageLine("Transfer unsuccessfull because limit Transfer");
//        }
//    }
// 

    /**
     * @return the amount
     */
    public int getAmount() {
	return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
	this.amount = amount;
    }

    /**
     * @return the keypad
     */
    public Keypad getKeypad() {
	return keypad;
    }

    /**
     * @param keypad the keypad to set
     */
    public void setKeypad(Keypad keypad) {
	this.keypad = keypad;
    }

    /**
     * @return the targetAccount
     */
    public int getTargetAccount() {
	return targetAccount;
    }

    /**
     * @param targetAccount the targetAccount to set
     */
    public void setTargetAccount(int targetAccount) {
	this.targetAccount = targetAccount;
    }

    @Override
    public String toString() {
	String res = "Transfer $" + amount + " to " + targetAccount + ".";
	return res;
    }

}

