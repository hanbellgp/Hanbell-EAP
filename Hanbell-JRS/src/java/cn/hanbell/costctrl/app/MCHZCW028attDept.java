/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.app;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class MCHZCW028attDept {

    private String deptId;

    public MCHZCW028attDept() {
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}
