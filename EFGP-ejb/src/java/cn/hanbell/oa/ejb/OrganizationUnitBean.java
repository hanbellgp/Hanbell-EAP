/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.OrganizationUnit;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Named;

/**
 *
 * @author C0160
 */
@Named
@Stateless
@LocalBean
public class OrganizationUnitBean extends SuperEJBForEFGP<OrganizationUnit> {

    public OrganizationUnitBean() {
        super(OrganizationUnit.class);
    }

}
