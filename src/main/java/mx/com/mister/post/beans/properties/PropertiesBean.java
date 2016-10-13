/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.mister.post.beans.properties;

import java.util.Properties;
import java.util.Set;
/**
 *
 * @author ignis
 */
public class PropertiesBean {
    private Properties properties;
    private String accessId;
    private String appSecret;
    private String OAuth_Uri;
    private String access_Token_URL;
    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getAccessId() {
        return properties.getProperty("ACCESS_ID");
    }    

    public String getAppSecret() {
        return properties.getProperty("APP_SECRET");
    }

    public String getOAuth_Uri() {
        return properties.getProperty("OAuth_URI");
    }

    public String getAccess_Token_URL() {
        return properties.getProperty("ACCESS_TOKEN_URL");
    }

    public void setAccess_Token_URL(String access_Token_URL) {
        this.access_Token_URL = access_Token_URL;
    }    
    
}
