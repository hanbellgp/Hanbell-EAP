/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author C0160
 */
public class LoginYun {

    private String status;
    private String type;
    private List<String> currentAuthority;

    public LoginYun() {
        currentAuthority = new ArrayList<>();
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
