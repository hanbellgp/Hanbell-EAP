/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.edw.ejb;

import cn.hanbell.edw.comm.SuperEJBForEDW;
import cn.hanbell.edw.entity.EdwAMT;
import cn.hanbell.edw.entity.EhsHazardInspection;
import cn.hanbell.edw.entity.EhsSecure;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class EdwAMTBean extends SuperEJBForEDW<EdwAMT> {

    public EdwAMTBean() {
        super(EdwAMT.class);
    }

    public EdwAMT getByUUUD(String uuid) {
        Query query = getEntityManager().createNamedQuery("EdwAMT.findById");
        query.setParameter("id", uuid);
        try {
            return (EdwAMT) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

}
