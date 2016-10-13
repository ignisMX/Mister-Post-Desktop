/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.mister.post.beans.graph.api;

import com.restfb.FacebookClient;
import com.restfb.scope.ScopeBuilder;
import com.restfb.scope.UserDataPermissions;
import mx.com.mister.post.beans.properties.PropertiesBean;

/**
 *
 * @author ignis
 */
public class GraphAPIBean {
    private FacebookClient facebookClient;
    private ScopeBuilder scopeBuilder;

    public FacebookClient getFacebookClient() {
        return facebookClient;
    }

    public void setFacebookClient(FacebookClient facebookClient) {
        this.facebookClient = facebookClient;
    }

    public ScopeBuilder getScopeBuilder() {        
        scopeBuilder.addPermission(UserDataPermissions.USER_STATUS);
        scopeBuilder.addPermission(UserDataPermissions.USER_ABOUT_ME);
        return scopeBuilder;
    }

    public void setScopeBuilder(ScopeBuilder scopeBuilder) {
        this.scopeBuilder = scopeBuilder;
    }    
}
