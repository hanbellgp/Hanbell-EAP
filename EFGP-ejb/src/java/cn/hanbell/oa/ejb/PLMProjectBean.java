/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.PLMProject;
import cn.hanbell.oa.entity.PLMProjectDetail;
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
public class PLMProjectBean extends SuperEJBForEFGP<PLMProject> {

    @EJB
    private PLMProjectDetailBean plmProjectDetailBean;

    private List<PLMProjectDetail> detailList;

    public PLMProjectBean() {
        super(PLMProject.class);
    }

    public void setDetail(String fsn) {
        detailList = plmProjectDetailBean.findByFSN(fsn);
        if (getDetailList() == null) {
            detailList = new ArrayList<>();
        }
    }

    /**
     * @return the detailList
     */
    public List<PLMProjectDetail> getDetailList() {
        return detailList;
    }

}
