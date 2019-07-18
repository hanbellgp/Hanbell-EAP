/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperSyncBean;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class SyncGZBean extends SuperSyncBean {

    @PersistenceContext(unitName = "PU_gzerp")
    private EntityManager em;

    public SyncGZBean() {

    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
