/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskManager;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Skynet
 */
public class StorageTest {
    
    public StorageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   

  

    /**
     * Test of insertToTable method, of class Storage.
     */
    //@Test
    /*public void testInsertToTable() {
        System.out.println("insertToTable");
        String userToAdd = "TestUser";
        String taskToAdd = "Task1";
        String taskStatus = "To Do";
        Storage.insertToTable(userToAdd, taskToAdd, taskStatus);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }*/

    /**
     * Test of retrieveFromTable method, of class Storage.
     */
    @Test
    public void testRetrieveFromTable() {
        System.out.println("retrieveFromTable");
        String userToFind = "TestUser";
        String expResult = "Task1";
        String result = Storage.retrieveFromTable(userToFind);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveFromStatusTable method, of class Storage.
     */
    @Test
    public void testRetrieveFromStatusTable() {
        System.out.println("retrieveFromStatusTable");
        String userToFind = "TestUser";
        String expResult = "To Do";
        String result = Storage.retrieveFromStatusTable(userToFind);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveSingleStatusTable method, of class Storage.
     */
    @Test
    public void testRetrieveSingleStatusTable() {
        System.out.println("retrieveSingleStatusTable");
        String userToFind = "TestUser";
        String taskToFind = "Task1";
        String expResult = "To Do";
        String result = Storage.retrieveSingleStatusTable(userToFind, taskToFind);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteFromTable method, of class Storage.
     */
    @Test
    public void testDeleteFromTable() {
        System.out.println("deleteFromTable");
        String userToRemove = "TestUser";
        String taskToRemove = "Task1";
        Storage.deleteFromTable(userToRemove, taskToRemove);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
