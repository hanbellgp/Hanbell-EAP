/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HZCW030Bean;
import cn.hanbell.oa.entity.HZCW030;
import cn.hanbell.oa.entity.HZCW030Detail1;
import cn.hanbell.oa.entity.HZCW030Detail2;
import cn.hanbell.oa.entity.HZCW030Detail3;
import cn.hanbell.oa.entity.HZCW030Detail4;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C2082
 */
public class HZCW030Report extends SuperMultiReportBean<HZCW030Bean, HZCW030, HZCW030Detail1> {

    public HZCW030Report() {
    }

    @Override
    public HZCW030 getEntity(Object o) throws Exception {
        return this.superEJB.findByPSN(o);
    }

    /**
     * 费用预算追加明细清单
     * @param o
     * @return
     * @throws Exception 
     */
    @Override
    public List<HZCW030Detail1> getDetail(Object o) throws Exception {
        this.superEJB.setDetail(o);
        return this.superEJB.getDetailList1(o);
    }

    /**
     * 费用预算追加明细之（通讯费/差率费/交际应酬费）
     * @param o
     * @return 
     * @throws Exception 
     */
    public List<HZCW030Detail2> getDetail2(Object o) throws Exception {
        this.superEJB.setDetail(o);
        return this.superEJB.getDetailList2(o);
    }

    /**
     * 费用预算调拨明细清单
     * @param o
     * @return 
     * @throws Exception 
     */
    public List<HZCW030Detail3> getDetail3(Object o) throws Exception {
        this.superEJB.setDetail(o);
        return this.superEJB.getDetailList3(o);
    }

    /**
     * 费用预算调拨明细之（通讯费/差率费/交际应酬费）
     * @param o
     * @return 
     * @throws Exception 
     */
    public List<HZCW030Detail4> getDetail4(Object o) throws Exception {
        this.superEJB.setDetail(o);
        return this.superEJB.getDetailList4(o);
    }
}
