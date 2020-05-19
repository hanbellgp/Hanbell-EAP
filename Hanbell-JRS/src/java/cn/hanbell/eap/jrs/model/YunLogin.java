/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author C0160
 */
public class YunLogin {

    private String userName;
    private String password;
    private String type;

    private String status;
    private List<String> currentAuthority;

    public YunLogin() {
        currentAuthority = new ArrayList<>();
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the currentAuthority
     */
    public List<String> getCurrentAuthority() {
        return currentAuthority;
    }

    /**
     * @param currentAuthority the currentAuthority to set
     */
    public void setCurrentAuthority(List<String> currentAuthority) {
        this.currentAuthority = currentAuthority;
    }

}
