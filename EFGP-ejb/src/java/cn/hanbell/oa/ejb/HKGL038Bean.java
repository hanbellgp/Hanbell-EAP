/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKGL037;
import cn.hanbell.oa.entity.HKGL038;
import cn.hanbell.oa.entity.HKGL038Detail;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class HKGL038Bean extends SuperEJBForEFGP<HKGL038> {

    @EJB
    private HKGL037Bean hkgl037Bean;
    @EJB
    private HKGL038DetailBean hkgl038DetailBean;

    private List<HKGL038Detail> detailList;

    public HKGL038Bean() {
        super(HKGL038.class);
    }

    @Override
    public void setDetail(Object value) {
        this.detailList = hkgl038DetailBean.findByFSN(value); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HKGL038 findByPSN(Object value) {
        return super.findByPSN(value); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param value
     * @return the detailList
     */
    public List<HKGL038Detail> getDetailList(Object value) {
        return hkgl038DetailBean.findByFSN(value);
    }

    /**
     * @param detailList the detailList to set
     */
    public void setDetailList(List<HKGL038Detail> detailList) {
        this.detailList = detailList;
    }

    public Boolean updateHKGL037(String psn) throws Exception {
        try {
            HKGL038 h = this.findByPSN(psn);
            if (h == null) {
                throw new NullPointerException();
            }
            List<HKGL038Detail> details = this.getDetailList(h.getFormSerialNumber());
            if (details.size() > 0) {
                for (int i = 0; i < details.size(); i++) {
                    HKGL038Detail detail = details.get(i);
                    HKGL037 hkgl037 = hkgl037Bean.findByPSN(detail.getSrcno());
                    if (hkgl037 == null) {
                        throw new NullPointerException();
                    } else {
                        hkgl037.setIsPrint(psn);
                        hkgl037Bean.update(hkgl037);
                    }
                }
            }
            return true;
        } catch (Exception ex) {
            throw ex;
        }
    }

}
