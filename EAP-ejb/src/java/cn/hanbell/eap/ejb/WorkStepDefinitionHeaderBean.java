/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.WorkStepDefinitionHeader;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class WorkStepDefinitionHeaderBean extends SuperEJBForEAP<WorkStepDefinitionHeader> {

    public WorkStepDefinitionHeaderBean() {
        super(WorkStepDefinitionHeader.class);
    }

}
