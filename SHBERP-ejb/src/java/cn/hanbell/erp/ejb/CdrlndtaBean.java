/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrlndta;
import cn.hanbell.erp.entity.Cdrlnrenew;
import cn.hanbell.oa.ejb.HKJH005Bean;
import cn.hanbell.oa.entity.HKJH005;
import cn.hanbell.oa.entity.HKJH005Detail;
import cn.hanbell.util.BaseLib;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class CdrlndtaBean extends SuperEJBForERP<Cdrlndta> {

    @EJB
    private CdrlnrenewBean cdrlnrenewBean;
    @EJB
    private HKJH005Bean hkjh005Bean;

    public CdrlndtaBean() {
        super(Cdrlndta.class);
    }

    public Cdrlndta findByPK(String facno, String trno, short trseq) {
        Query query = getEntityManager().createNamedQuery("Cdrlndta.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("trno", trno);
        query.setParameter("trseq", trseq);
        try {
            return (Cdrlndta) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public Boolean updateByOAHKJH005(String psn) throws ParseException {
        try {
            HKJH005 h = hkjh005Bean.findByPSN(psn);
            if (h == null) {
                throw new NullPointerException();
            }
            String facno = h.getFacno();
            String trno = h.getBtrno();
            List<HKJH005Detail> details = hkjh005Bean.getDetailList(h.getFormSerialNumber());
            //表身循环
            for (int i = 0; i < details.size(); i++) {
                HKJH005Detail detail = details.get(i);
                this.setCompany(facno);
                Cdrlndta c = this.findByPK(facno, trno, Short.valueOf(detail.getBtrseq()));
                if (c == null) {
                    throw new NullPointerException();
                }
                c.setPrebkdate(BaseLib.getDate("yyyy/MM/dd", detail.getNprebkdatetxt()));
                update(c);
                //更新cdrlnrennew
                Cdrlnrenew cn = new Cdrlnrenew();
                cn.setFacno(facno);
                cn.setTrno(trno);
                cn.setTrseq(Short.valueOf(detail.getBtrseq()));
                cn.setBkdate(BaseLib.getDate("yyyy/MM/dd", detail.getOprebkdatetxt()));
                cn.setCreator(h.getApplyuser());
                cn.setCreatedate(BaseLib.getDate());
                cn.setSheetno(h.getProcessSerialNumber());
                cdrlnrenewBean.setCompany(facno);
                cdrlnrenewBean.persist(cn);
            }
            return true;
        } catch (NullPointerException | NumberFormatException ex) {
            Logger.getLogger(InvmasBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
