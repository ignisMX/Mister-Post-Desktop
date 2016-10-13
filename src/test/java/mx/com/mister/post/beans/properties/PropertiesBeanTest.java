/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.mister.post.beans.properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ignis
 */
public class PropertiesBeanTest {
    
    public PropertiesBeanTest() {
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
     * Test of getProperties method, of class PropertiesBean.
     */

    /**
     * Test of getAccessId method, of class PropertiesBean.
     */
    ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
    @Test
    public void testGetAccessId() {
        System.out.println("getAccessId");
        PropertiesBean instance = (PropertiesBean)context.getBean("properties");
        String expResult = "315789555445692";
        String result = instance.getAccessId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetAppSecret() {
        System.out.println("getAppSecret");
        PropertiesBean instance = (PropertiesBean)context.getBean("properties");
        String expResult = "25d5652beb5a92838df349a8bb38a195";
        String result = instance.getAppSecret();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetOAuth_Uri() {
        System.out.println("getOAuth_Uri");
        PropertiesBean instance = (PropertiesBean)context.getBean("properties");
        String expResult = "https://omar-alvarez.herokuapp.com/";
        String result = instance.getOAuth_Uri();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetAccess_Token_URL() {
        System.out.println("getAccess_Token_URL");
        PropertiesBean instance = (PropertiesBean)context.getBean("properties");
        String expResult = "https://graph.facebook.com/v2.8/oauth/access_token?client_id=";
        String result = instance.getAccess_Token_URL();
        assertEquals(expResult, result);
    }

}
