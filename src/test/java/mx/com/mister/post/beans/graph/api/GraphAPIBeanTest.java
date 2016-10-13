/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.mister.post.beans.graph.api;

import com.restfb.FacebookClient;
import com.restfb.scope.ScopeBuilder;
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
public class GraphAPIBeanTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
    public GraphAPIBeanTest() {
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
     * Test of getFacebookClient method, of class GraphAPIBean.
     */
    @Test
    public void testGetFacebookClient() {
        System.out.println("getFacebookClient");
        GraphAPIBean instance = (GraphAPIBean)context.getBean("facebookClient");
        FacebookClient expResult = null;
        FacebookClient result = instance.getFacebookClient();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getScopeBuilder method, of class GraphAPIBean.
     */
    @Test
    public void testGetScopeBuilder() {
        System.out.println("getScopeBuilder");
        GraphAPIBean instance = (GraphAPIBean)context.getBean("facebookClient");
        ScopeBuilder expResult = null;
        ScopeBuilder result = instance.getScopeBuilder();
        assertNotEquals(expResult, result);
    }
    
}
