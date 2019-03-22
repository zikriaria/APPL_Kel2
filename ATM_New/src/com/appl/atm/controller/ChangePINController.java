/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.controller;
import com.appl.atm.model.BankDatabase;
import com.appl.atm.model.Account;
import com.appl.atm.model.BankDatabase;
import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;
/**
 *
 * @author Asus-Pro
 */
public class ChangePINController {
    private int accountNumber;
    private int userAuthenticated;
    private Keypad keypad;
    private BankDatabase bankDatabase;
    private Screen screen;
    
public ChangePINController(int userAccountNumber, Screen atmScreen, 
                    BankDatabase atmBankDatabase, Keypad atmKeypad){
    keypad = atmKeypad;
    userAuthenticated = 2;
    this.accountNumber = userAccountNumber;
    bankDatabase = atmBankDatabase;
    screen = atmScreen;
}

public void execute(){
    Account userAccount = bankDatabase.getAccount(accountNumber);
    
    screen.displayMessageLine("Input your current PIN : ");
    int currentPIN = keypad.getInput();

    userAuthenticated = bankDatabase.authenticateUser(accountNumber, currentPIN);
    while(userAuthenticated != 1){
        screen.displayMessageLine("You input the wrong PIN");
        screen.displayMessageLine("Input your current PIN : ");
        currentPIN = keypad.getInput();
        
        userAuthenticated = bankDatabase.authenticateUser(accountNumber, currentPIN); 
    }
    
    if(userAuthenticated == 1){
        int newPIN;
        
        screen.displayMessageLine("Input your PIN : ");
        newPIN = keypad.getInput();
        
        while(newPIN == currentPIN){
            screen.displayMessageLine("You input the same PIN");
            screen.displayMessageLine("Input new PIN : ");
            newPIN = keypad.getInput();
        }
      Account account = bankDatabase.getAccount(accountNumber);
      account.setPin(newPIN);
    }else{
        screen.displayMessageLine("You input the wrong PIN");
    }

}
    
}
