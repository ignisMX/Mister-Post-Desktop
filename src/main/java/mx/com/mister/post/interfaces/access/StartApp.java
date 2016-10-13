/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.mister.post.interfaces.access;

/**
 *
 * @author ignis
 */
public interface StartApp {
    String getLoginDialogURL();
    String getCode(String uri);
    String getUrlAccessToken(String redirecURL, String code);
    String getLoginURLRedirect(String loginDialogURL);
    String getAccessToken(String urlAccessToken);
    boolean isRedirectSuccess(String uri);
    
}
