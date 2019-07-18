/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperSyncBean;
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
public class SyncEFGPBean extends SuperSyncBean {

    @PersistenceContext(unitName = "EFGP-syncPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
