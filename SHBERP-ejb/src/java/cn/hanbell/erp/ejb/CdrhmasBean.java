/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrdmas;
import cn.hanbell.erp.entity.Cdrhmas;
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
 * @author C0160
 */
@Stateless
@LocalBean
public class CdrhmasBean extends SuperEJBForERP<Cdrhmas> {

    @EJB
    private CdrdmasBean cdrdmasBean;

    @EJB
    private HKYX013Bean hkyx013Bean;
    @EJB
    private HKYX013DetailBean hkyxDetail013Bean;

    public CdrhmasBean() {
        super(Cdrhmas.class);
    }

    @Override
    public Cdrhmas findById(Object value) {
        Query query = getEntityManager().createNamedQuery("Cdrhmas.findByCdrno");
        query.setParameter("cdrno", value);
        try {
            Object o = query.getSingleResult();
            return (Cdrhmas) o;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 修改订单业务员或部门代号
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
                    if ("1".equals(item.getInvoiceType())) {
                        this.setCompany(h.getFacno());
                        Cdrhmas c = this.findById(item.getSingleNumber());
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
                        cdrdmasBean.setCompany(h.getFacno());
                        Cdrdmas cdrdmas = cdrdmasBean.findByFacnoAndCdrnoAndItnbrAndTrseq(h.getFacno(), item.getSingleNumber(), item.getItnbr(), Integer.parseInt(item.getTrseq()));
                        if (cdrdmas != null) {
                            if (!"".equals(item.getNcodeDA()) && !"请选择".equals(item.getNcodeDA()) && !"0".equals(item.getNcodeDA())) {
                                cdrdmas.setNcodeDA(item.getNcodeDA());
                            }
                            if (!"".equals(item.getNcodeCD()) && !"请选择".equals(item.getNcodeCD()) && !"0".equals(item.getNcodeCD())) {
                                cdrdmas.setNcodeCD(item.getNcodeCD());
                            }
                            if (!"".equals(item.getNcodeDC()) && !"请选择".equals(item.getNcodeDC()) && !"0".equals(item.getNcodeDC())) {
                                cdrdmas.setNcodeDC(item.getNcodeDC());
                            }
                            if (!"".equals(item.getNcodeDD()) && !"请选择".equals(item.getNcodeDD()) && !"0".equals(item.getNcodeDD())) {
                                cdrdmas.setNcodeDD(item.getNcodeDD());
                            }
                            cdrdmasBean.update(cdrdmas);
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
