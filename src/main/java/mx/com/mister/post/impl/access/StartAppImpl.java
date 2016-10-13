/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.mister.post.impl.access;


import mx.com.mister.post.interfaces.access.StartApp;
import mx.com.mister.post.beans.properties.PropertiesBean;
import mx.com.mister.post.beans.graph.api.GraphAPIBean;
import mx.com.mister.post.beans.facebook.AccessTokenBean;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
/**
 *
 * @author ignis
 */
public class StartAppImpl implements StartApp{
    private PropertiesBean properties;
    private GraphAPIBean graphAPI;
    private AccessTokenBean accessToken;
    private Gson gson;
    public void setProperties(PropertiesBean properties) {
        this.properties = properties;
    }

    public void setGraphAPI(GraphAPIBean graphAPI) {
        this.graphAPI = graphAPI;
    }
    
    @Override
    public String getLoginDialogURL() {
        String url = graphAPI.getFacebookClient().getLoginDialogUrl(properties.getAccessId(), 
                properties.getOAuth_Uri(), graphAPI.getScopeBuilder());
        return url;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }
        
    
    @Override
    public String getCode(String uri) {
        return uri.substring(uri.indexOf("code=")+5);
    }

    @Override
    public boolean isRedirectSuccess(String uri) {
        return (uri.contains(properties.getOAuth_Uri()) && uri.contains("?code=")
                && !uri.contains("facebook"));
    } 

    @Override
    public String getUrlAccessToken(String redirecURL,String code) {
        return properties.getAccess_Token_URL()+properties.getAccessId()+"&redirect_uri="
                +redirecURL+"&client_secret="+properties.getAppSecret()+"&code="+code;
    }

    @Override
    public String getLoginURLRedirect(String loginDialogURL) {
       String loginURLRedirect = loginDialogURL.substring(loginDialogURL.indexOf("&redirect_uri=")+"&redirect_uri=".length());
        try {
            return URLDecoder.decode(loginURLRedirect,"UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(StartAppImpl.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    @Override
    public String getAccessToken(String urlAccessToken) {
        try {
            URL url = new URL(urlAccessToken);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //int responseCode = connection.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String input;
            StringBuffer response = new StringBuffer();

            while ((input = in.readLine()) != null) {
                response.append(input);
            }
            in.close();
            
            accessToken = gson.fromJson(response.toString(), AccessTokenBean.class);
            return accessToken.getAccess_token();
        } catch (Exception ex) {
            Logger.getLogger(StartAppImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
