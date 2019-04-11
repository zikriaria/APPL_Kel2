/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

import static com.appl.atm.model.Constants.BISNIS;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anggita
 */
public class AccountTest {

    Account account;

    int accountNumber = 1234;
    int accountPIN = 4321;
    double expectedBalance = 1200;
    double debitAmount = 20;
    boolean isBlocked = false;
    int newType = BISNIS;

    public AccountTest() {
        account = new Account(accountNumber, accountPIN, expectedBalance, debitAmount, isBlocked, newType);
    }

//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
    /**
     * Test of getAccountNumber method, of class Account.
     */
    @Test
    public void testGetAccountNumber() {
        System.out.println("test accountNumber");
        //Message adalah pesan yang akan dikeluarkan ketika assert mengembalikan nilai false
        assertEquals("accountNumber terdaftar", accountNumber, account.getAccountNumber());
        
        accountNumber = 8888;
        //jika accountNumber tidak terdaftar
        assertNotEquals("accountNumber tidak terdaftar", accountNumber, account.getAccountNumber());
    }

    /**
     * Test of getPin method, of class Account.
     */
    @Test
    public void testGetPin() {
        System.out.println("test PIN");
        //Message adalah pesan yang akan dikeluarkan ketika assert mengembalikan nilai false
        assertEquals("PIN benar", accountPIN, account.getPin());
        
        accountPIN = 1111;
        //jika PIN tidak terdaftar
        assertNotEquals("PIN salah", accountPIN, account.getPin());
    }
    
    /**
     * Test of getAvailableBalance method, of class Account.
     */
    //ditest di withdrawalTest

    /**
     * Test of getTotalBalance method, of class Account.
     */
    //ditest di windrawalTest

    /**
     * Test of isBlocked method, of class Account.
     */
    @Test
    public void testIsBlocked() {
        System.out.println("test accountNumber");
        //Message adalah pesan yang akan dikeluarkan ketika assert mengembalikan nilai false
        assertFalse("account tidak terblokir", account.isBlocked());
        
        isBlocked = true;
        //jika account terblokir
        assertTrue("account terblokir", account.isBlocked());
    }

}
