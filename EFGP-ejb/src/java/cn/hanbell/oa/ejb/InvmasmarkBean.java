/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.Invmasmark;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class InvmasmarkBean extends SuperEJBForEFGP<Invmasmark> {

    public InvmasmarkBean() {
        super(Invmasmark.class);
    }

    @Override
    public List<Invmasmark> findAll() {
        try {
            Query query = getEntityManager().createNamedQuery("Invmasmark.findAll");
            Object entity = query.getResultList();
            if (entity != null) {
                return (List<Invmasmark>) entity;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }

    }

}
