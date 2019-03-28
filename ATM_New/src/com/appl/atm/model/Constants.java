package com.appl.atm.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Annazar
 */
public final class Constants {
    public static final int BALANCE_INQUIRY = 1;
    public static final int WITHDRAWAL = 2;
    public static final int DEPOSIT = 3;
    public static final int CHANGE_PIN = 4;
    public static final int TRANSFER = 5;
    public static final int VALIDATE_DEPOSIT = 6;
    public static final int EXIT = 7;
    
    // withdraw
    public static final int WITHDRAWAL_CANCELED = 6;
    public static final int WITHDRAW_SUCCESSFUL = 1;
    public static final int BALANCE_NOT_ENOUGH = 2;
    public static final int CASHDISPENSER_NOT_ENOUGH = 3;
    
    // deposit
    public static final int DEPOSIT_CANCELED = 0;
    public static final int DEPOSIT_SUCCESSFUL = 1;
    public static final int ENVELOPE_IS_NOT_RECEIVED = 2;
    
    //transfer
    public static final int TRANSFER_SUCCESS = 0;
    public static final int NEGATIVE_AMOUNT = 2;
    public static final int SAME_ACCOUNT_NUMBER = 3;
    public static final int ACCOUNT_BALANCE_NOT_SUFFICIENT = 4;
    public static final int USER_NOT_FOUND = 5;
    
    public static final int DEPOSIT_VALIDATE_SUCCESS = 0;
    public static final int USER_NOT_VALIDATE = 1;
    
}