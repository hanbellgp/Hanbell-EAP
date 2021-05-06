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

    public List<Functions> findByUserOID(String value) {
        Query query = getEntityManager().createNamedQuery("Functions.findByUserOID");
        query.setParameter("userOID", value);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Functions findByUserOIDAndIsMain(String value) {
        try {
            Query query = getEntityManager().createNamedQuery("Functions.findByUserOIDAndIsMain");
            query.setParameter("userOID", value);
            return (Functions) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Functions findByUserOIDAndOrgUnitOID(String userOID, String orgUnitOID) {
        try {
            Query query = getEntityManager().createNamedQuery("Functions.findByUserOIDAndOrgUnitOID");
            query.setParameter("userOID", userOID);
            query.setParameter("orgUnitOID", orgUnitOID);
            return (Functions) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

}
