/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperSyncBean;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class SyncYCBean extends SuperSyncBean {

    @PersistenceContext(unitName = "PU_yinchuanerp")
    private EntityManager em;

    public SyncYCBean() {

    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
