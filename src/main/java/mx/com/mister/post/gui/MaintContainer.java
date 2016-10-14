/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.mister.post.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javafx.scene.web.WebView;
import javafx.concurrent.Worker.State;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.com.mister.post.impl.access.StartAppImpl;

/**
 *
 * @author ignis
 */
public class MaintContainer extends JApplet {
    
    private static final int JFXPANEL_WIDTH_INT = 300;
    private static final int JFXPANEL_HEIGHT_INT = 250;
    private static JFXPanel fxContainer;
    private static StartAppImpl startApp;
    private String loginDialogURL;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                }
                ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
                startApp = (StartAppImpl) context.getBean("startApp");
                JFrame frame = new JFrame("Mister Post");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                JApplet applet = new MaintContainer();
                applet.init();
                
                frame.setContentPane(applet.getContentPane());
                
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
                applet.start();
            }
        });
    }
    
    @Override
    public void init() {
        fxContainer = new JFXPanel();
        fxContainer.setPreferredSize(new Dimension(JFXPANEL_WIDTH_INT, JFXPANEL_HEIGHT_INT));
        add(fxContainer, BorderLayout.CENTER);
        // create JavaFX scene
        Platform.runLater(new Runnable() {
            
            @Override
            public void run() {
                //createScene();
                createWebBrowser();
            }
        });
    }
    
    private void createScene() {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        fxContainer.setScene(new Scene(root));
    }
    
    private void createWebBrowser(){
        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();
        loginDialogURL = startApp.getLoginDialogURL();
        webEngine.load(loginDialogURL);
        browserEvent(webEngine);
        StackPane root = new StackPane();
        root.getChildren().add(browser);
        fxContainer.setScene(new Scene(root));
    }
    
    public void browserEvent(WebEngine webEngine) {
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
            @Override
            public void changed(ObservableValue observable, State oldValue, State newValue) {
                if (newValue == Worker.State.SUCCEEDED) {
                    if (startApp.isRedirectSuccess(webEngine.getLocation())) {
                        String code = startApp.getCode(webEngine.getLocation());
                        String urlAccessToken = startApp.getUrlAccessToken(startApp.getLoginURLRedirect(loginDialogURL), code);
                        String accessToken  = startApp.getAccessToken(urlAccessToken);
                    }
                }
            }
        });
    }
}
