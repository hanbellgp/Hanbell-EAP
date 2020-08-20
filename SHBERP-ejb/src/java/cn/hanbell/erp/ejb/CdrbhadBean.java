/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrbdta;
import cn.hanbell.erp.entity.Cdrbhad;
import cn.hanbell.oa.ejb.HKYX013Bean;
import cn.hanbell.oa.ejb.HKYX013DetailBean;
import cn.hanbell.oa.entity.HKYX013;
import cn.hanbell.oa.entity.HKYX013Detail;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1749
 */
@Stateless
@LocalBean
public class CdrbhadBean extends SuperEJBForERP<Cdrbhad> {

    @EJB
    private HKYX013Bean hkyx013Bean;
    @EJB
    private HKYX013DetailBean hkyxDetail013Bean;

    @EJB
    private CdrbdtaBean cdrbdtaBean;

    public CdrbhadBean() {
        super(Cdrbhad.class);
    }

    @Override
    public Cdrbhad findById(Object value) {
        Query query = getEntityManager().createNamedQuery("Cdrbhad.findByBakno");
        query.setParameter("bakno", value);
        try {
            Object o = query.getSingleResult();
            return (Cdrbhad) o;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 修改订单出货单
     *
     * @param psn
     * @return
     */
    public boolean updateByOAHKYX013(String psn) {
        HKYX013 h = hkyx013Bean.findByPSN(psn);
        if (h == null) {
            throw new NullPointerException();
        }
        List<HKYX013Detail> details = hkyxDetail013Bean.findByFSN(h.getFormSerialNumber());
        try {
            if (!details.isEmpty()) {
                for (HKYX013Detail item : details) {
                    if ("3".equals(item.getInvoiceType())) {
                        this.setCompany(h.getFacno());
                        Cdrbhad c = this.findById(item.getSingleNumber());
                        if (c != null) {
                            if (!"".equals(item.getNewDeptno())) {
                                c.setDepno(item.getNewDeptno());
                            }
                            if (!"".equals(item.getNewMancode())) {
                                c.setMancode(item.getNewMancode());
                            }
                            if (!"".equals(item.getNewDeptno()) || !"".equals(item.getNewMancode())) {
                                this.update(c);
                            }
                        }
                        //更新出货单表身明细
                        cdrbdtaBean.setCompany(h.getFacno());
                        Cdrbdta cdrbdta = cdrbdtaBean.findByFacnoAndBaknoAndItnbrAndTrseq(h.getFacno(), item.getSingleNumber(), item.getItnbr(), Integer.parseInt(item.getTrseq()));
                        if (cdrbdta != null) {
                            if (!"".equals(item.getNcodeDA()) && !"请选择".equals(item.getNcodeDA()) && !"0".equals(item.getNcodeDA())) {
                                cdrbdta.setNcodeDA(item.getNcodeDA());
                            }
                            if (!"".equals(item.getNcodeCD()) && !"请选择".equals(item.getNcodeCD()) && !"0".equals(item.getNcodeCD())) {
                                cdrbdta.setNcodeCD(item.getNcodeCD());
                            }
                            if (!"".equals(item.getNcodeDC()) && !"请选择".equals(item.getNcodeDC()) && !"0".equals(item.getNcodeDC())) {
                                cdrbdta.setNcodeDC(item.getNcodeDC());
                            }
                            if (!"".equals(item.getNcodeDD()) && !"请选择".equals(item.getNcodeDD()) && !"0".equals(item.getNcodeDD())) {
                                cdrbdta.setNcodeDD(item.getNcodeDD());
                            }
                            if (!"".equals(item.getIssevdta()) && !"请选择".equals(item.getIssevdta()) && !"0".equals(item.getIssevdta())) {
                                cdrbdta.setIssevdta(item.getIssevdta().charAt(0));
                            }
                            cdrbdtaBean.update(cdrbdta);
                        }
                    }
                }
            }
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
