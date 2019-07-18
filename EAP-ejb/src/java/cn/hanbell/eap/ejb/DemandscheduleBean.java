/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.Demandschedule;
import com.lightshell.comm.SuperEJB;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class DemandscheduleBean extends SuperEJBForEAP<Demandschedule>{

    //@PersistenceContext(unitName="EAP-ejbPU")
    //private EntityManager em;
    
    public DemandscheduleBean() {
        super(Demandschedule.class);
    }
    
//    @Override
//    public List<Demandschedule> findAll(){
//       Query query=em.createNamedQuery("Demandschedule.findAll");
//       return query.getResultList();
//    }
    
//    @Override
//    public EntityManager getEntityManager() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    
}
