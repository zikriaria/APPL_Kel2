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
import static com.appl.atm.model.Constants.*;
import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;
import java.util.Date;


public class SystemDate extends Transaction {

    //private static Date prevDate;
    private static Date date;
    private Keypad keypad; // reference to keypad
    private Screen screen;
    
    public SystemDate(int userAccountNumber, Screen atmScreen,
	    BankDatabase atmBankDatabase, Keypad atmKeypad) {

	super(userAccountNumber, atmBankDatabase);
	keypad = atmKeypad;
        screen = atmScreen;
	date = new Date(System.currentTimeMillis());
    }

    @Override
    public int execute() {
        
    return 0;
    }

   
    public Date getDate() {
	return date;
    }

   
    public void setDate(Date date) {
	this.date = date;
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

