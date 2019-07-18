/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.crm.ejb.WARTABean;
import cn.hanbell.crm.ejb.WARTBBean;
import cn.hanbell.crm.entity.WARTA;
import cn.hanbell.crm.entity.WARTB;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.ProcessInstance;
import cn.hanbell.oa.entity.WARMI05;
import cn.hanbell.oa.entity.WARMI05Detail;
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
public class WARMI05Bean extends SuperEJBForEFGP<WARMI05> {

    @EJB
    private WARMI05DetailBean warmi05DetailBean;

    @EJB
    private WARTABean wartaBean;

    @EJB
    private WARTBBean wartbBean;

    @EJB
    private ProcessInstanceBean processInstanceBean;

    private List<WARMI05Detail> detailList;

    public WARMI05Bean() {
        super(WARMI05.class);
    }

    @Override
    public void setDetail(Object value) {
        detailList = warmi05DetailBean.findByFSN(value);
        if (detailList == null) {
            detailList = new ArrayList<>();
        }
    }

    /**
     * @return the detailList
     */
    public List<WARMI05Detail> getDetailList() {
        return detailList;
    }

    public boolean rollbackWARTA(String psn) {
        WARMI05 w = findByPSN(psn);
        if (w == null) {
            throw new NullPointerException();
        }
        String ta001 = w.getTa001();
        String ta002 = w.getTa002();

        WARTA ta;
        ta = wartaBean.findByPK(ta001, ta002);
        ta.setTa200("0");
        wartaBean.update(ta);
        return true;
    }

    public boolean updateWARTB(String psn, String step) {
        WARMI05 w = findByPSN(psn);
        if (w == null) {
            throw new NullPointerException();
        }
        String ta001 = w.getTa001();
        String ta002 = w.getTa002();
        String ta025 = w.getTa025();
        String ta026 = w.getTa026();
        String ta028 = w.getTa028();
        String ta029 = w.getTa029();

        WARTA ta;
        ta = wartaBean.findByPK(ta001, ta002);

        List<WARMI05Detail> detail1 = warmi05DetailBean.findByFSN(w.getFormSerialNumber());
        for (int i = 0; i < detail1.size(); i++) {
            WARMI05Detail wd = detail1.get(i);
            String tb009 = wd.getTb009();
            if (tb009 == null || tb009.equals("")) {
                tb009 = wd.getTb007();
            }
            BigDecimal bd = new BigDecimal(tb009);
            WARTB tb;
            tb = wartbBean.findByPK(ta001, ta002, wd.getTb003());
            if ("1".equals(step)) {
                tb.setTb033(bd);
                wartbBean.update(tb);
            } else {
                tb.setTb032(tb.getTb032().add(BigDecimal.ONE));
                tb.setTb033(BigDecimal.ZERO);
                if ("FWLL".equals(ta001)) {
                    ta.setTa025(ta025);
                } else if ("JCDX".equals(ta001) || "JCDF".equals(ta001)) {
                    ta.setTa028(ta028);
                }
                wartbBean.update(tb);
            }
        }
        if (!"1".equals(step)) {
            ta.setTa200("3");
            ta.setTa006("Y");
            wartaBean.update(ta);
        }
        return true;

    }

    public boolean updateSubject(String psn) {
        WARMI05 w = findByPSN(psn);
        if (w == null) {
            throw new NullPointerException();
        }
        String TA032C;
        String TA039;
        String TA036;
        TA032C = w.getTa032c();
        TA039 = w.getTa039();
        TA036 = w.getTa036();
        TA032C = TA032C + "" + TA039 + "" + TA036;
        ProcessInstance PI;
        PI = processInstanceBean.findBySerialNumber(w.getProcessSerialNumber());
        PI.setSubject(TA032C);
        processInstanceBean.update(PI);
        return true;
    }

}
