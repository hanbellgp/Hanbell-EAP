/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.ejb;

import cn.hanbell.oa.ejb.ProcessCheckBean;
import cn.hanbell.oa.ejb.VHTV006Bean;
import cn.hanbell.oa.entity.ProcessCheck;
import cn.hanbell.oa.entity.VHTV006;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;
import vn.hanbell.erp.comm.SuperEJBForERP;
import vn.hanbell.erp.entity.Cdrqdta;
import vn.hanbell.erp.entity.Cdrqhad;

/**
 *
 * @author ZFF
 */
@Stateless
@LocalBean
public class CdrqhadBean extends SuperEJBForERP<Cdrqhad> {

    @EJB
    private CdrqdtaBean cdrqdtaBean;
    @EJB
    private ProcessCheckBean processCheckBean;
    @EJB
    private VHTV006Bean vhtv006Bean;

    private List<Cdrqdta> cdrqdtaList;

    public CdrqhadBean() {
        super(Cdrqhad.class);
    }

    public Cdrqhad findByQuono(String quono) {
        Query query = this.getEntityManager().createNamedQuery("Cdrqhad.findByQuono");
        query.setParameter("quono", quono);
        try {
            return (Cdrqhad) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Cdrqhad> findNeedThrow() {
        Query query = this.getEntityManager().createNamedQuery("Cdrqhad.findNeedThrow").setFirstResult(0).setMaxResults(1);
        return query.getResultList();
    }

    public List<Cdrqdta> findNeedThrowDetail(String facno, String quono) {
        cdrqdtaBean.setCompany(facno);
        return cdrqdtaBean.findNeedThrowDetail(facno, quono);
    }

    public List<Cdrqdta> getCdrqdtaList() {
        return cdrqdtaList;
    }

    public void setCdrqdtaList(List<Cdrqdta> cdrqdtaList) {
        this.cdrqdtaList = cdrqdtaList;
    }

    public Boolean updateByOAVHTV006(String psn) {
        List<ProcessCheck> processList;
        VHTV006 h = vhtv006Bean.findByPSN(psn);
        if (h == null) {
            throw new NullPointerException();
        }
        String facno = h.getFacno();
        try {
            this.setCompany(facno);
            Cdrqhad cdrqhad = this.findByQuono(h.getQuono());
            if (cdrqhad != null) {
                cdrqhad.setHquosta('Y');
//                processList = processCheckBean.findByPSN(psn);
//                if (processList.size() > 0) {
//                    ProcessCheck pc = processList.get(processList.size() - 1);
//                    cdrqhad.setOacfuser(pc.getUserID());
//                }
                update(cdrqhad);
            }
            return true;
        } catch (NullPointerException | NumberFormatException ex) {
            Logger.getLogger(CdrqhadBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Boolean rollbackByOAHKVHTV006(String psn) {
        VHTV006 h = vhtv006Bean.findByPSN(psn);
        if (h == null) {
            throw new NullPointerException();
        }
        String facno = h.getFacno();
        try {
            this.setCompany(facno);
            Cdrqhad cdrqhad = this.findByQuono(h.getQuono());
            if (cdrqhad != null) {
                cdrqhad.setHquosta('N');
                //cdrqhad.setOacfuser("");
                update(cdrqhad);
            }
            return true;
        } catch (NullPointerException | NumberFormatException ex) {
            Logger.getLogger(CdrqhadBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
