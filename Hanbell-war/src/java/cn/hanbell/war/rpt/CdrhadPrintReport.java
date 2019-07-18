/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.rpt;

import cn.hanbell.erp.ejb.CdrhadBean;
import cn.hanbell.erp.entity.Cdrdta;
import cn.hanbell.erp.entity.Cdrhad;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author C0160
 */
public class CdrhadPrintReport {

    private CdrhadBean cdrhadBean = lookupSuperEJBForERP();

    protected CdrhadBean lookupSuperEJBForERP() {
        try {
            Context c = new InitialContext();
            return (CdrhadBean) c.lookup("java:global/Hanbell-EAP/SHBERP-ejb/CdrhadBean!cn.hanbell.erp.ejb.CdrhadBean");
        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }
    }

    public void setEJB(String JNDIName) {
        try {
            Context c = new InitialContext();
            cdrhadBean = (CdrhadBean) c.lookup("java:global/Hanbell-EAP/SHBERP-ejb/CdrhadBean!cn.hanbell.erp.ejb.CdrhadBean");
        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }
    }

    public Cdrhad getEntity(String facno, String shpno) throws Exception {
        cdrhadBean.setCompany(facno);
        return cdrhadBean.findById(shpno);
    }

    public List<Cdrdta> getDetail(String facno, Object o) throws Exception {
        return cdrhadBean.getDetail(facno, o);
    }

}
