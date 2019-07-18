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
public class SyncJNBean extends SuperSyncBean {

    @PersistenceContext(unitName = "PU_jnerp")
    private EntityManager em;

    public SyncJNBean() {

    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
