/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.mister.post.beans.facebook;

/**
 *
 * @author ignis
 */
public class AccessTokenBean {
    private String access_token;
    private String token_type;
    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
    
    public String toString(){
        return "accessToken "+getAccess_token()+ "\n" + "token_type "+getToken_type()+
                "\n" + "expires_in "+getExpires_in();
    }
    
}
