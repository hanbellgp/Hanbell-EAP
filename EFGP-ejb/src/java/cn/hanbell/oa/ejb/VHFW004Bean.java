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
import cn.hanbell.oa.entity.VHFW004;
import cn.hanbell.oa.entity.VHFW004Detail;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author 
 */
@Stateless
@LocalBean
public class VHFW004Bean extends SuperEJBForEFGP<VHFW004> {

    @EJB
    private VHFW004DetailBean vhfw004DetailBean;

    @EJB
    private WARTABean wartaBean;

    @EJB
    private WARTBBean wartbBean;

    @EJB
    private ProcessInstanceBean processInstanceBean;

    private List<VHFW004Detail> detailList;

    public VHFW004Bean() {
        super(VHFW004.class);
    }

    @Override
    public void setDetail(Object value) {
        detailList = vhfw004DetailBean.findByFSN(value);
        if (detailList == null) {
            detailList = new ArrayList<>();
        }
    }

    /**
     * @param fsn
     * @return the detailList
     */
    public List<VHFW004Detail> getDetailList(String fsn) {
        detailList =  vhfw004DetailBean.findByFSN(fsn);
        return detailList;
    }

    public boolean rollbackWARTA(String psn) {
        VHFW004 w = findByPSN(psn);
        if (w == null) {
            throw new NullPointerException();
        }
        String ta001 = w.getTa001();
        String ta002 = w.getTa002();

        WARTA ta;
        //设置公司别，对应数据库连接
        wartaBean.setCompany(w.getTa014());
        ta = wartaBean.findByPK(ta001, ta002);
        ta.setTa200("0");
        wartaBean.update(ta);
        return true;
    }

    public boolean updateWARTB(String psn, String step) {
        VHFW004 w = findByPSN(psn);
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
        //设置公司别，对应数据库连接
        wartaBean.setCompany(w.getTa014());
        wartbBean.setCompany(w.getTa014());
        ta = wartaBean.findByPK(ta001, ta002);

        List<VHFW004Detail> detail1 = vhfw004DetailBean.findByFSN(w.getFormSerialNumber());
        for (int i = 0; i < detail1.size(); i++) {
            VHFW004Detail wd = detail1.get(i);
            String tb009 = wd.getTb009();
            if (tb009 == null || tb009.equals("")) {
                tb009 = wd.getTb007();
            }
            BigDecimal bd = new BigDecimal(tb009);
            WARTB tb;
            tb = wartbBean.findByPK(ta001, ta002, wd.getTb003());
            if ("1".equals(step)) {
                tb.setTb033(bd);
            } else {
                tb.setTb032(tb.getTb032().add(BigDecimal.ONE));
                tb.setTb033(BigDecimal.ZERO);
                if ("FWLL".equals(ta001)) {
                    ta.setTa025(ta025);
                } else if ("JCDX".equals(ta001) || "JCDF".equals(ta001)) {
                    ta.setTa028(ta028);
                }
            }
            //更新TB009实际领料数量 2023/11/9
            if (tb009 == null || tb009.equals("")) {
                tb009 = wd.getTb007();
            } else {
                tb009 = wd.getTb009();
            }
            tb.setTb009(BigDecimal.valueOf(Double.valueOf(tb009)));
            wartbBean.update(tb);
        }
        if (!"1".equals(step)) {
            ta.setTa200("3");
            ta.setTa006("Y");
            wartaBean.update(ta);
        }
        return true;

    }
    
    public boolean updateSubject(String psn) {
        VHFW004 w = findByPSN(psn);
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
