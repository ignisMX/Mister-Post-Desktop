/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.mister.post.impl.access;

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
public class StartAppImplTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
    public StartAppImplTest() {
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
     * Test of getLoginDialogURL method, of class StartAppImpl.
     */
    @Test
    public void testGetLoginDialogURL() {
        System.out.println("getLoginDialogURL");
        StartAppImpl instance = (StartAppImpl)context.getBean("startApp");
        String expResult = "https://www.facebook.com/dialog/oauth?client_id=315789555445692&redirect_uri=https%3A%2F%2Fomar-alvarez.herokuapp.com%2F&scope=public_profile%2Cuser_status%2Cuser_about_me";
        String result = instance.getLoginDialogURL();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        StartAppImpl instance = (StartAppImpl)context.getBean("startApp");
        String url = "https://omar-alvarez.herokuapp.com/?code=AQBKnLNqqnLQ-n9hoZWzJnQIIetB4uM5M6u2xL7zwpnTUVK5XPIQ_VX5j_yGOgxx2M5UeaNY_jvs_7B8XEBRc6I9EjxSqIOOAEgn2Rf13S8WooSVUjSAeUj1P5XU3p3N9pfhj"+
                "QUW67VipUKyaFMrS6MLcnmpbcYcjXxkdJdOJb6foDsAEm9zWXWVoq4c01sLFTlzZ7zu2FrTDiiuQIQIXFsOasJfSHSSdoUYrvSC3q8vIugECThFo1WQEh5mWdJIVF9UqHX7sKCAzHVDcj2MaIA1_6HIXdliaHtSZ-tlJgsrCNcFLi9_d7x_"+
                "p-qT_LgDMZiXvaxMgWDUDhK9_aQDpBVg#_=_";
        String expResult = "AQBKnLNqqnLQ-n9hoZWzJnQIIetB4uM5M6u2xL7zwpnTUVK5XPIQ_VX5j_yGOgxx2M5UeaNY_jvs_7B8XEBRc6I9EjxSqIOOAEgn2Rf13S8WooSVUjSAeUj1P5XU3p3N9pfhjQUW67VipUKyaFMrS6MLcnmpbcYcjXxkdJdO"
                + "Jb6foDsAEm9zWXWVoq4c01sLFTlzZ7zu2FrTDiiuQIQIXFsOasJfSHSSdoUYrvSC3q8vIugECThFo1WQEh5mWdJIVF9UqHX7sKCAzHVDcj2MaIA1_6HIXdliaHtSZ-tlJgsrCNcFLi9_d7x_p-qT_LgDMZiXvaxMgWDUDhK9_aQDpBVg#_=_";
        String result = instance.getCode(url);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetLoginURLRedirect() {
        System.out.println("getLoginURLRedirect");
        StartAppImpl instance = (StartAppImpl)context.getBean("startApp");
        String url = instance.getLoginDialogURL();
        String expResult = "https://omar-alvarez.herokuapp.com/&scope=public_profile,user_status,user_about_me";
        String result = instance.getLoginURLRedirect(url);
        assertEquals(expResult, result);
    }          
}
