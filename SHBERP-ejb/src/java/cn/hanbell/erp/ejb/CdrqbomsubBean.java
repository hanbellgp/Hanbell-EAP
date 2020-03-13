/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrqbomsub;
import cn.hanbell.erp.entity.Invmas;
import cn.hanbell.oa.model.CdrqbomsubDetailModel;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class CdrqbomsubBean extends SuperEJBForERP<Cdrqbomsub> {

    @EJB
    private InvmasBean invmasBean;
    private List<CdrqbomsubDetailModel> listBomsubDetailModel;

    public CdrqbomsubBean() {
        super(Cdrqbomsub.class);
    }

    public Cdrqbomsub findByItnbrfAndCdrno(String facno, String itnbrf, String cdrno) {
        Query query = this.getEntityManager().createNamedQuery("Cdrqbomsub.findByItnbrfAndCdrno");
        query.setParameter("facno", facno);
        query.setParameter("itnbrf", itnbrf);
        query.setParameter("cdrno", cdrno);
        try {
            return (Cdrqbomsub) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Cdrqbomsub findByPK(String facno, String cdrno, short trseq) {
        Query query = this.getEntityManager().createNamedQuery("Cdrqbomsub.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("cdrno", cdrno);
        query.setParameter("trseq", trseq);
        try {
            return (Cdrqbomsub) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<CdrqbomsubDetailModel> querybomsubModelList(String facno, String cdrno, short trseq) {
        if (facno == null || cdrno == null) {
            return null;
        }
        Field f;
        Cdrqbomsub cqbomsub = findByPK(facno, cdrno, trseq);
        if (cqbomsub == null) {
            return null;
        }
        listBomsubDetailModel = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            try {
                CdrqbomsubDetailModel m = new CdrqbomsubDetailModel();
                m.setTrseq(String.valueOf(i));
                f = cqbomsub.getClass().getDeclaredField("itdesc" + i);
                f.setAccessible(true);
                if (f.get(cqbomsub) == null) {
                    break;
                }
                m.setItdesc(f.get(cqbomsub).toString());
                f = cqbomsub.getClass().getDeclaredField("itnbr" + i);
                f.setAccessible(true);
                m.setItnbr(f.get(cqbomsub).toString());
                f = cqbomsub.getClass().getDeclaredField("itscode" + i);
                f.setAccessible(true);
                m.setItscode(f.get(cqbomsub).toString());
                f = cqbomsub.getClass().getDeclaredField("itsdesc" + i);
                f.setAccessible(true);
                m.setItsdesc(f.get(cqbomsub).toString());
                f = cqbomsub.getClass().getDeclaredField("itnbrs" + i);
                f.setAccessible(true);
                m.setItnbrs(f.get(cqbomsub).toString());
                Invmas invmas = invmasBean.findByItnbr(m.getItnbrs());
                if (invmas != null) {
                    m.setItdsc(invmas.getItdsc());
                }
                listBomsubDetailModel.add(m);
            } catch (Exception ex) {
                Logger.getLogger(CdrqbomsubBean.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return listBomsubDetailModel;
    }

}
