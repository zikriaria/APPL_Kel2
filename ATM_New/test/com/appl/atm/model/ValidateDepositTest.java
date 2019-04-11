/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anggita
 */
public class ValidateDepositTest {
    BankDatabase bankDatabase;

    int validateTarget = 1234;
    double expectedAvailableBalance = 1200;
    
    public ValidateDepositTest() {
        bankDatabase = new BankDatabase();
    }
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }

    /**
     * Test of execute method, of class ValidateDeposit.
     */
    @Test
    public void testValidate() {
        Account account;
        account = bankDatabase.getAccount(validateTarget);
        System.out.println("test Validate");
        if (account != null) {
            account.setAvailableBalance(account.getTotalBalance());
            assertEquals("validated", expectedAvailableBalance, account.getAvailableBalance(),0);
            
            expectedAvailableBalance = 1400;
            assertNotEquals("not validated", expectedAvailableBalance, account.getAvailableBalance(), 0);
        }
    }
    
}
