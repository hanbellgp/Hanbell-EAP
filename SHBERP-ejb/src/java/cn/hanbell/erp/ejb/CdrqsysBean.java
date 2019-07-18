/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrqsys;
import cn.hanbell.erp.entity.Cdrserno;
import cn.hanbell.erp.entity.CdrsernoPK;
import cn.hanbell.util.BaseLib;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class CdrqsysBean extends SuperEJBForERP<Cdrqsys> {

    @EJB
    private CdrsernoBean cdrsernoBean;
    
    public CdrqsysBean() {
        super(Cdrqsys.class);
    }
    
    public Cdrqsys getByFacno(String facno) {
        Query query = this.getEntityManager().createNamedQuery("Cdrqsys.findByFacno");
        query.setParameter("facno", facno);
        try {
            return (Cdrqsys) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    public String getSerialno(String facno, Date quodate, Character decode, boolean b, String curprgcode) {
        int li_ordno;
        int li_max = 0;
        String ls_serial = "";
        String ls_trno;
        String ls_maxno;
        String ls_nofmt = "";
        String autochar = "";
        String ls_autochar;
        Character ls_difcode = '1';   // 初始化值
        Character autono;
        //设置数据库链接
        setCompany(facno);
        Cdrqsys cqsys = this.getByFacno(facno);
        switch (curprgcode) {
            case "CDR220":
            case "CDR225":
                autono = cqsys.getAutono();
                autochar = cqsys.getAutochar().toString();
                ls_nofmt = cqsys.getNofmt();
                if (autono == 'N') {
                    return null;
                }
                ls_difcode = '1';
        }
        
        li_ordno = Integer.parseInt(ls_nofmt.substring(5));
        ls_trno = getStaticno(facno, autochar, quodate, decode, ls_nofmt);
        li_max = getMaxno(facno, ls_trno, ls_difcode);
        if (li_max == 0) {
            String a = "00000000001";
            ls_serial = ls_trno + a.substring(a.length() - li_ordno);
            if (b) {
                Cdrserno cdrserno = new Cdrserno();
                CdrsernoPK cdrsernoPK = new CdrsernoPK();
                cdrsernoPK.setFacno(facno);
                cdrsernoPK.setDifcode(ls_difcode);
                cdrsernoPK.setKeyformat(ls_trno);
                cdrserno.setMaxserno((short) 1);
                cdrserno.setCdrsernoPK(cdrsernoPK);
                cdrsernoBean.setCompany(facno);
                cdrsernoBean.persist(cdrserno);
            }
        } else {
            li_max = li_max + 1;
            String a = "000000000" + li_max;
            ls_serial = ls_trno + a.substring(a.length() - li_ordno);
            if (b) {
                cdrsernoBean.setCompany(facno);
                Cdrserno cdrserno = cdrsernoBean.findByPK(facno, ls_difcode, ls_trno);
                cdrserno.setMaxserno((short) li_max);
                cdrsernoBean.update(cdrserno);  
            }
        }    
        return ls_serial;
    }
    
    private String getStaticno(String facno, String autochar, Date quoDate, Character decode, String ls_nofmt) {
        int li_month = 0;
        String ls_no;
        String ls_ch = "";
        String ls_curno;
        if (autochar == null || "0".equals(autochar)) {
            autochar = "";
        }
        ls_no = autochar;
        for (int i = 0; i <= 4; i++) {
            ls_curno = ls_nofmt.substring(i, i + 1);
            switch (ls_curno) {
                case "1":
                    ls_no += facno;
                    break;
                case "2":
                    ls_no += BaseLib.formatDate("yyyy", quoDate);
                    break;
                case "3":
                    ls_no += BaseLib.formatDate("yy", quoDate);
                    break;
                case "4":
                    ls_no += BaseLib.formatDate("MM", quoDate);
                    break;
                case "5":
                    li_month = Integer.parseInt(BaseLib.formatDate("MM", quoDate), 10);
                    if (li_month < 10) {
                        ls_ch = String.valueOf(li_month);
                    }
                    if (li_month == 10) {
                        ls_ch = "A";
                    }
                    if (li_month == 11) {
                        ls_ch = "B";
                    }
                    if (li_month == 12) {
                        ls_ch = "C";
                    }
                    ls_no += ls_ch;
                    break;
                case "6":
                    ls_no += BaseLib.formatDate("dd", quoDate);
                    break;
                case "7":
                    ls_no += decode;
                    break;
                default:
                    break;
            }
        }
        return ls_no;
    }
    
    private int getMaxno(String facno, String serno, Character difcode) {
        int li_maxno;
        cdrsernoBean.setCompany(facno);
        Cdrserno cdrserno = cdrsernoBean.findByPK(facno, difcode, serno);    
        try {
            li_maxno = cdrserno.getMaxserno();
        } catch (Exception ex) {
            li_maxno = 0;
        }
        return li_maxno;
    }
    
}
