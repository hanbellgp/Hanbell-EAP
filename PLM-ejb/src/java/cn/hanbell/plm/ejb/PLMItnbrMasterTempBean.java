/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.plm.ejb;

import cn.hanbell.plm.comm.SuperEJBForPLM;
import cn.hanbell.plm.entity.PLMItnbrDetailTemp;
import cn.hanbell.plm.entity.PLMItnbrMasterTemp;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Named;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
@Named
public class PLMItnbrMasterTempBean extends SuperEJBForPLM<PLMItnbrMasterTemp> {

    @EJB
    private PLMItnbrDetailTempBean plmItnbrDetailTempBean;

    private List<PLMItnbrDetailTemp> detailList;

    public PLMItnbrMasterTempBean() {
        super(PLMItnbrMasterTemp.class);
    }

    public List<PLMItnbrMasterTemp> findNeedThrow() {
        Query query = this.getEntityManager().createNamedQuery("PLMItnbrMasterTemp.findNeedThrow").setFirstResult(0).setMaxResults(1);
        return query.getResultList();
    }

    public List<PLMItnbrDetailTemp> findNeedThrowDetail(String itemNumber) {
        return plmItnbrDetailTempBean.findByItemNumber(itemNumber);
    }

    /**
     * @return the detailList
     */
    public List<PLMItnbrDetailTemp> getDetailList() {
        return detailList;
    }

    /**
     * @param detailList the detailList to set
     */
    public void setDetailList(List<PLMItnbrDetailTemp> detailList) {
        this.detailList = detailList;
    }

}
