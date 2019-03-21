/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

/**
 *
 * @author Annazar
 */
public class CashDispenser {
    
    // the default initial number of bills in the cash dispenser
    private final static int INITIAL_COUNT = 25;
    private int count; // number of $20 bills remaining

    // no-argument CashDispenser constructor initializes count to default
    public CashDispenser() {
        count = INITIAL_COUNT; // set count attribute to default
    }

    // simulates dispensing of specified amount of cash
    public void dispenseCash(int amount) {
        int billsRequired = amount / 20; // number of $20 bills required
        count -= billsRequired; // update the count of bills
    }

    // indicates whether cash dispenser can dispense desired amount
    public boolean isSufficientCashAvailable(int amount) {
        int billsRequired = amount / 20; // number of $20 bills required
        if (count >= billsRequired) {
            return true; // enough bills available
        }
        else {
            return false; // not enough bills available
        }
    }
   
}