/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

import com.appl.atm.model.BankDatabase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gibran
 */
public class BankDatabaseTest {
    int accountNumber = 1234;
    int accountPasswd = 4321;
        
    BankDatabase bankDatabase;
    public BankDatabaseTest() {
        System.out.println("Test Started");
        
        bankDatabase = new BankDatabase();
    }
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void accountCheck() {
         
         //Message adalah pesan yang akan dikeluarkan ketika assert mengembalikan nilai false
         assertEquals("Akun Salah",1,bankDatabase.authenticateUser(accountNumber, accountPasswd));
         
         this.accountNumber = 4321;
         this.accountPasswd = 5678;
         
         assertEquals("Akun Terbaca",2,bankDatabase.authenticateUser(accountNumber, accountPasswd));
         
         this.accountNumber = 8765;
         assertEquals("Akun tidak terbaca", 1, bankDatabase.authenticateUser(accountNumber, accountPasswd));
     }
}
