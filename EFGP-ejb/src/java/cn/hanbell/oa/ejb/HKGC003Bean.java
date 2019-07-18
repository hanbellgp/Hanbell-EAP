/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKGC001Detail;
import cn.hanbell.oa.entity.HKGC003;
import cn.hanbell.oa.entity.HKGC003Detail;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class HKGC003Bean extends SuperEJBForEFGP<HKGC003> {

    @EJB
    private HKGC001DetailBean hkgc001DetailBean;
    @EJB
    private HKGC003DetailBean hkgc003DetailBean;

    private List<HKGC003Detail> detailList;

    public HKGC003Bean() {
        super(HKGC003.class);
    }

    public Boolean rollbackHKGC001(String psn) throws Exception {
        try {
            HKGC003 h = this.findByPSN(psn);
            if (h == null) {
                throw new NullPointerException();
            }
            BigDecimal finqty, stockqty;
            List<HKGC003Detail> details = hkgc003DetailBean.findByFSN(h.getFormSerialNumber());
            if (details != null && !details.isEmpty()) {
                for (HKGC003Detail d : details) {
                    stockqty = BigDecimal.valueOf(Double.parseDouble(d.getStockqty()));
                    HKGC001Detail hkgc001Detail = hkgc001DetailBean.findByOID(d.getSrcOID());
                    if (hkgc001Detail != null) {
                        finqty = BigDecimal.valueOf(Double.parseDouble(hkgc001Detail.getFinqty()));
                        hkgc001Detail.setFinqty(String.valueOf(finqty.subtract(stockqty)));
                        hkgc001DetailBean.update(hkgc001Detail);
                    }
                }
            }
            return true;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public Boolean updateHKGC001(String psn) throws Exception {
        try {
            HKGC003 h = this.findByPSN(psn);
            if (h == null) {
                throw new NullPointerException();
            }
            BigDecimal inqty;
            List<HKGC003Detail> details = hkgc003DetailBean.findByFSN(h.getFormSerialNumber());
            if (details != null && !details.isEmpty()) {
                for (HKGC003Detail d : details) {
                    inqty = BigDecimal.ZERO;
                    HKGC001Detail hkgc001Detail = hkgc001DetailBean.findByOID(d.getSrcOID());
                    List<HKGC003Detail> stocks = hkgc003DetailBean.findBySrcOID(d.getSrcOID());
                    if (hkgc001Detail != null && stocks != null) {
                        for (HKGC003Detail s : stocks) {
                            //跳过撤销或终止流程
                            if (s.getParent().getProcessInstance() == null || s.getParent().getProcessInstance().getCurrentState() > 3) {
                                continue;
                            }
                            inqty = inqty.add(BigDecimal.valueOf(Double.parseDouble(s.getStockqty())));
                        }
                        hkgc001Detail.setFinqty(String.valueOf(inqty));
                        hkgc001DetailBean.update(hkgc001Detail);
                    }
                }
            }
            return true;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void setDetail(Object value) {
        detailList = hkgc003DetailBean.findByFSN(value.toString());
        if (detailList == null) {
            detailList = new ArrayList<>();
        }
    }

    /**
     * @return the detailList
     */
    public List<HKGC003Detail> getDetailList() {
        return detailList;
    }

}
