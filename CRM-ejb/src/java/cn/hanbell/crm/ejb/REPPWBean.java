/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.DDGC;
import cn.hanbell.crm.entity.REPPW;
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
public class REPPWBean extends SuperEJBForCRM<REPPW> {

    public REPPWBean() {
        super(REPPW.class);
    }

    public List<REPPW> findByPw001AndPw002(String pw001, String pw002) {
        Query query = this.getEntityManager().createNamedQuery("REPPW.findByPw001AndPw002");
        query.setParameter("pw001", pw001);
        query.setParameter("pw002", pw002);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public List<REPPW> findByPw001AndPw002AndPW010AndPW019(String pw001, String pw002, String pw010,String pw019) {
        Query query = this.getEntityManager().createNamedQuery("REPPW.findByPw001AndPw002AndPw010AndPw019");
        query.setParameter("pw001", pw001);
        query.setParameter("pw002", pw002);
        query.setParameter("pw010", pw010);
        query.setParameter("pw019", pw019);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
       public List<REPPW> findByPw001AndPw002AndPW010(String pw001, String pw002, String pw010) {
        Query query = this.getEntityManager().createNamedQuery("REPPW.findByPw001AndPw002AndPw010");
        query.setParameter("pw001", pw001);
        query.setParameter("pw002", pw002);
        query.setParameter("pw010", pw010);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
