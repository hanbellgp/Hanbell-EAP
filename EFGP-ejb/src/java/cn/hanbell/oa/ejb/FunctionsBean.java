/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.Functions;
import java.util.List;
import java.util.function.Function;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class FunctionsBean extends SuperEJBForEFGP<Functions> {

    public FunctionsBean() {
        super(Functions.class);
    }

    public Functions findByUserOID(String value) {
        Query query = getEntityManager().createNamedQuery("Functions.findByUserOID");
        query.setParameter("userOID", value);
        try {
            Object entity = query.getSingleResult();
            if (entity != null) {
                return (Functions) entity;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public Functions findByOccupantOIDAndisMain(String occupantOID, boolean isMain) {
        try {
            Query q=getEntityManager().createNamedQuery("Functions.findByUserOID");
            q.setParameter("userOID", occupantOID);
            return (Functions)q.getSingleResult();
            
        } catch (Exception e) {
         
            return null;
        }
    }
}
