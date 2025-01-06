/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1030G3
 */
public class ChatserverTest {
    
    public ChatserverTest() {
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
     * Test of main method, of class Chatserver.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        Chatserver.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendingMessageToAll method, of class Chatserver.
     */
    @Test
    public void testSendingMessageToAll() {
        System.out.println("sendingMessageToAll");
        String username = "";
        String messageinform = "";
        Chatserver instance = new Chatserver();
        instance.sendingMessageToAll(username, messageinform);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startServer method, of class Chatserver.
     */
    @Test
    public void testStartServer() throws Exception {
        System.out.println("startServer");
        Chatserver instance = new Chatserver();
        instance.startServer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
