/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrbrhad;
import cn.hanbell.erp.entity.Cdrlnhad;
import cn.hanbell.erp.entity.Cdrobdou;
import cn.hanbell.util.BaseLib;
import java.util.Date;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class CdrobdouBean extends SuperEJBForERP<Cdrobdou> {

    public CdrobdouBean() {
        super(Cdrobdou.class);
    }

    public Cdrobdou findByCdrobtype(String cdrobtype) {
        Query query = this.getEntityManager().createNamedQuery("Cdrobdou.findByCdrobtype");
        query.setParameter("cdrobtype", cdrobtype);
        try {
            Object o = query.getSingleResult();
            return (Cdrobdou) o;
        } catch (Exception ex) {
            return null;
        }

    }

    private int getMaxno(String facno, String format, String iocode, int serlen) {

        String ls_trno;
        String ls_format;
        String ls_lntrno;
        String ls_brtrno = "";
        int li_maxno;
        ls_format = format + "%";

        //借出归还可共用同一单据类别,2个档案都要找
        Query q1 = getEntityManager().createNativeQuery("SELECT MAX(trno) FROM cdrlnhad WHERE facno = ?1 and trno LIKE ?2 ");
        q1.setParameter(1, facno);
        q1.setParameter(2, ls_format);
        try {
            ls_lntrno = q1.getSingleResult().toString();
        } catch (Exception ex) {
            ls_lntrno = "";
        }

        Query q2 = getEntityManager().createNativeQuery("SELECT MAX(brtrno) FROM cdrbrhad WHERE facno = ?1 and brtrno LIKE ?2 ");
        q2.setParameter(1, facno);
        q2.setParameter(2, ls_format);
        try {
            ls_brtrno = q2.getSingleResult().toString();
        } catch (Exception ex) {
            ls_brtrno = "";
        }

        if (ls_lntrno.compareTo(ls_brtrno) > 0) {
            ls_trno = ls_lntrno;
        } else {
            ls_trno = ls_brtrno;
        }
        if ("".equals(ls_trno)) {
            return 0;
        }
        li_maxno = Integer.valueOf(ls_trno.substring(format.length()));

        return li_maxno;

    }

    public String getSerno(String cdrobtype, String facno, Date trdate, String iocode) {
        int li_ordno;
        int li_max = 0;
        String ls_serial = "";
        String ls_trno;
        String ls_maxno;
        String ls_nofmt;
        Character ls_autoyn;
        String ls_autochar;
        //设置数据库链接
        setCompany(facno);
        Cdrobdou cdrobdou = findByCdrobtype(cdrobtype);
        if (cdrobdou != null) {
            ls_autoyn = cdrobdou.getZautoyn();
            ls_autochar = cdrobdou.getZautochar().toString();
            ls_nofmt = cdrobdou.getZnofmt();
            li_ordno = Integer.parseInt(ls_nofmt.substring(5, 6));
            ls_trno = getStaticno(facno, cdrobtype, trdate, ls_nofmt, ls_autochar);
            li_max = getMaxno(facno, ls_trno, iocode, li_ordno);
            if (li_max == 0) {
                String a = "00000000001";
                ls_serial = ls_trno + a.substring(a.length() - li_ordno);
            } else {
                li_max += 1;
                String a = "000000000" + li_max;
                ls_serial = ls_trno + a.substring(a.length() - li_ordno);
            }
        }
        return ls_serial;
    }

    private String getStaticno(String facno, String codrobtype, Date trdate, String nofmt, String autochar) {
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
                    ls_no += codrobtype;
                    break;
                case "3":
                    ls_no += BaseLib.formatDate("yyyy", trdate);
                    break;
                case "4":
                    ls_no += BaseLib.formatDate("yy", trdate);
                    break;
                case "5":
                    ls_no += BaseLib.formatDate("MM", trdate);
                    break;
                case "6":
                    li_month = Integer.parseInt(BaseLib.formatDate("MM", trdate), 10);
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
                case "7":
                    ls_no += BaseLib.formatDate("dd", trdate);
                    break;
                default:
                    break;
            }
        }
        return ls_no;
    }

}
