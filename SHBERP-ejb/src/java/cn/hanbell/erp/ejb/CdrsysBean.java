/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrserno;
import cn.hanbell.erp.entity.CdrsernoPK;
import cn.hanbell.erp.entity.Cdrsys;
import cn.hanbell.erp.entity.Cdrsysfmt;
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
public class CdrsysBean extends SuperEJBForERP<Cdrsys> {

    @EJB
    private CdrsernoBean cdrsernoBean;

    @EJB
    private CdrsysfmtBean cdrsysfmtBean;

    public CdrsysBean() {
        super(Cdrsys.class);
    }

    public Cdrsys getByFacno(String facno) {
        Query query = this.getEntityManager().createNamedQuery("Cdrsys.findByFacno");
        query.setParameter("facno", facno);
        try {
            return (Cdrsys) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public String getSerialNumber(String facno, String depno, String cdrcode, Date cdrdate, Character decode, Boolean flag, String curprgcode) {
        Character autono;
        String autochar = "";
        String nofmt = "";
        Character difcode = '2';

        int li_ordno;
        int li_max = 0;
        String ls_serial;
        String trno;
        String maxno;

        //设置数据库链接
        setCompany(facno);
        Cdrsysfmt sysfmt = cdrsysfmtBean.getByFacno(facno);
        switch (curprgcode) {
            case "CDR310":
                autono = sysfmt.getCautoyn();
                autochar = sysfmt.getCautochar().toString();
                nofmt = sysfmt.getCnofmt();
                if (autono == 'N') {
                    return null;
                }
                difcode = '2';
                break;
            default:
        }

        li_ordno = Integer.parseInt(nofmt.substring(5));
        trno = getStaticno(facno, depno, cdrcode, autochar, cdrdate, decode, nofmt);
        li_max = getMaxseq(facno, trno, difcode);
        if (li_max == 0) {
            String a = "00000000001";
            ls_serial = trno + a.substring(a.length() - li_ordno);
            if (flag) {
                Cdrserno cdrserno = new Cdrserno();
                CdrsernoPK cdrsernoPK = new CdrsernoPK();
                cdrsernoPK.setFacno(facno);
                cdrsernoPK.setDifcode(difcode);
                cdrsernoPK.setKeyformat(trno);
                cdrserno.setMaxserno((short) 1);
                cdrserno.setCdrsernoPK(cdrsernoPK);
                cdrsernoBean.persist(cdrserno);
            }
        } else {
            li_max = li_max + 1;
            String a = "000000000" + li_max;
            ls_serial = trno + a.substring(a.length() - li_ordno);
            if (flag) {
                Cdrserno cdrserno = cdrsernoBean.findByPK(facno, difcode, trno);
                cdrserno.setMaxserno((short) li_max);
                cdrsernoBean.update(cdrserno);
            }
        }
        return ls_serial;
    }

    private String getStaticno(String facno, String depno, String cdrcode, String autochar, Date date, Character decode, String nofmt) {
        int li_month = 0;
        String ls_no;
        String ls_ch = "";
        String ls_curno;
        if (autochar == null || "0".equals(autochar)) {
            autochar = "";
        }
        ls_no = autochar;
        for (int i = 0; i < 5; i++) {
            ls_curno = nofmt.substring(i, i + 1);
            switch (ls_curno) {
                case "1":
                    ls_no += facno;
                    break;
                case "2":
                    ls_no += BaseLib.formatDate("yyyy", date);
                    break;
                case "3":
                    ls_no += BaseLib.formatDate("yy", date);
                    break;
                case "4":
                    ls_no += BaseLib.formatDate("MM", date);
                    break;
                case "5":
                    li_month = Integer.parseInt(BaseLib.formatDate("MM", date), 10);
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
                    ls_no += BaseLib.formatDate("dd", date);
                    break;
                case "7":
                    ls_no += decode;
                    break;
                case "9":
                    ls_no += depno;
                    break;
                case "A":
                    ls_no += cdrcode;
                    break;
                default:
                    break;
            }
        }
        return ls_no;
    }

    private int getMaxseq(String facno, String serno, Character difcode) {
        int maxno;
        cdrsernoBean.setCompany(facno);
        try {
            Cdrserno cdrserno = cdrsernoBean.findByPK(facno, difcode, serno);
            maxno = cdrserno.getMaxserno();
        } catch (Exception ex) {
            maxno = 0;
        }
        return maxno;
    }

    @Override
    public void setCompany(String company) {
        super.setCompany(company);
        cdrsernoBean.setCompany(company);
        cdrsysfmtBean.setCompany(company);
    }

}
