
package cn.hanbell.efgp.rpt;


import cn.hanbell.oa.ejb.HZCW005Bean;
import cn.hanbell.oa.entity.HZCW005;
import cn.hanbell.oa.entity.HZCW005Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C1491
 */
public class HZCW005Report extends SuperMultiReportBean<HZCW005Bean, HZCW005, HZCW005Detail> {

    public HZCW005Report() {

    }

    @Override
    public List<HZCW005Detail> getDetail(Object o) throws Exception {
        this.superEJB.setDetailList(o);
        return this.superEJB.getDetailList();
    }

    @Override
    public HZCW005 getEntity(Object o) throws Exception {
        return this.superEJB.findByPSN(o);
    }

}
