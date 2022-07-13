/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HZCW027Bean;
import cn.hanbell.oa.ejb.VHTV003Bean;
import cn.hanbell.oa.entity.HZCW027;
import cn.hanbell.oa.entity.HZCW027Detail;
import cn.hanbell.oa.entity.VHTV003;
import cn.hanbell.oa.entity.VHTV003reDetail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C2082
 */
public class VHTV003Report extends SuperMultiReportBean<VHTV003Bean, VHTV003, VHTV003reDetail> {

    @Override
    public List<VHTV003reDetail> getDetail(Object o) throws Exception {
//        VHTV003 entity = (VHTV003) o;
        return this.superEJB.getDetailList((String)o);
    }

    @Override
    public VHTV003 getEntity(Object o) throws Exception {
        return this.superEJB.findByPSN(o);
    }

}
