/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.Title;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class TitleBean extends SuperEJBForEFGP<Title> {

    public TitleBean() {
        super(Title.class);
    }

    public Title findByOUOIDAndUserOID(String ouoid, String useroid) {
        Query query = getEntityManager().createNamedQuery("Title.findByOUOIDAndUserOID");
        query.setParameter("ouoid", ouoid);
        query.setParameter("useroid", useroid);
        try {
            Object o = query.getSingleResult();
            return (Title) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
