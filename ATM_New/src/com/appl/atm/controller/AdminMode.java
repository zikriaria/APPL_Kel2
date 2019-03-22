/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.controller;

import com.appl.atm.model.BankDatabase;
import com.appl.atm.model.CashDispenser;
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
  private static final int QUIT = 5;  
  private BankDatabase bankDatabase;
  private CashDispenser cashDispenser;
  private Keypad keypad;
  private Screen screen;
  
  AdminMode(BankDatabase paramBankDatabase, CashDispenser paramCashDispenser) {
    bankDatabase = paramBankDatabase;
    cashDispenser = paramCashDispenser;
    screen = new Screen();
    keypad = new Keypad();
  }
  
  public void execute() {

          screen.displayMessageLine("Admin Mode");
          screen.displayMessageLine("1. Add account");
          screen.displayMessageLine("2. Unblock account");
          screen.displayMessageLine("3. View money from Dispenser");
          screen.displayMessageLine("4. Add money to Dispenser");
          screen.displayMessageLine("5. Quit");
          screen.displayMessage("Choose an option: ");
          
          int option = keypad.getInput();
      switch (option) {
          case ADD_ACCOUNT:
              screen.displayMessageLine("tes add account");
              break;
          case UNBLOCK_ACCOUNT:
              screen.displayMessageLine("tes unblock account");
              break;
          case VIEW_DISPENSER:
              screen.displayMessageLine("view dispenser");
              break;
          case ADD_DISPENSER:
              screen.displayMessageLine("add dispenser");
              break;
          case QUIT:
              screen.displayMessageLine("Quit....");
              break;
          default:
              break;
      }

  }
  
}
