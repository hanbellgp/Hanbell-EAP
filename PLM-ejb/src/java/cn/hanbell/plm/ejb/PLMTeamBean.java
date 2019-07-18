/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.plm.ejb;

import cn.hanbell.plm.comm.SuperEJBForPLM;
import cn.hanbell.plm.entity.PLMTeam;
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
public class PLMTeamBean extends SuperEJBForPLM<PLMTeam> {

    @PersistenceContext(unitName = "PLM-projPU")
    private EntityManager em;

    public PLMTeamBean() {
        super(PLMTeam.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
