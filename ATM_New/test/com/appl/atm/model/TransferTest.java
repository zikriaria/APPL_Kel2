/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

import com.appl.atm.view.Keypad;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class TransferTest {
    
    public TransferTest() {
    }
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }

    /**
     * Test of execute method, of class Transfer.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        Transfer instance = null;
        int expResult = 0;
        int result = instance.execute();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmount method, of class Transfer.
     */
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        Transfer instance = null;
        int expResult = 0;
        int result = instance.getAmount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAmount method, of class Transfer.
     */
    @Test
    public void testSetAmount() {
        System.out.println("setAmount");
        int amount = 0;
        Transfer instance = null;
        instance.setAmount(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKeypad method, of class Transfer.
     */
    @Test
    public void testGetKeypad() {
        System.out.println("getKeypad");
        Transfer instance = null;
        Keypad expResult = null;
        Keypad result = instance.getKeypad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKeypad method, of class Transfer.
     */
    @Test
    public void testSetKeypad() {
        System.out.println("setKeypad");
        Keypad keypad = null;
        Transfer instance = null;
        instance.setKeypad(keypad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTargetAccount method, of class Transfer.
     */
    @Test
    public void testGetTargetAccount() {
        System.out.println("getTargetAccount");
        Transfer instance = null;
        int expResult = 0;
        int result = instance.getTargetAccount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTargetAccount method, of class Transfer.
     */
    @Test
    public void testSetTargetAccount() {
        System.out.println("setTargetAccount");
        int targetAccount = 0;
        Transfer instance = null;
        instance.setTargetAccount(targetAccount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Transfer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Transfer instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
