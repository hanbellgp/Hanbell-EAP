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
public class SyncSHBBean extends SuperSyncBean {

    @PersistenceContext(unitName = "PU_shberp")
    private EntityManager em;

    public SyncSHBBean() {

    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
