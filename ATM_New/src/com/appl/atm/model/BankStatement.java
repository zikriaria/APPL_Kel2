/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

/**
 *
 * @author USER
 */
import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;
import java.util.ArrayList;


public class BankStatement extends Transaction {
    
    private Keypad keypad;
    private Screen screen;

    public BankStatement(int userAccountNumber, Screen atmScreen,
	    BankDatabase atmBankDatabase, Keypad atmKeypad) {

	super(userAccountNumber, atmBankDatabase);
	keypad = atmKeypad;
        screen = atmScreen;
    }

    @Override
    public int execute() {
	return 0;
    }

    public ArrayList<Statement> getBankStatements() {
	return getBankDatabase().getBankStatement(getAccountNumber());
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

    @Override
    public String toString() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

