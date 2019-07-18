/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Invdou;
import cn.hanbell.erp.entity.Invserno;
import cn.hanbell.erp.entity.InvsernoPK;
import cn.hanbell.util.BaseLib;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class InvsernoBean extends SuperEJBForERP<Invserno> {

    @EJB
    private InvdouBean invdouBean;

    public InvsernoBean() {
        super(Invserno.class);
    }

    public Invserno findByPK(String facno, String trtype, String keyformat) {
        Query q = this.getEntityManager().createNamedQuery("Invserno.findByPK");
        q.setParameter("facno", facno);
        q.setParameter("trtype", trtype);
        q.setParameter("keyformat", keyformat);
        try {
            Object o = q.getSingleResult();
            return (Invserno) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public String getTrno(String facno, String depno, String trtype, Date trdate, boolean updateflag) {
        String ls_autochar;
        Character ls_autono;
        String ls_nofmt;
        String ls_trno;
        String ls_depcode = "";
        String ls_serial = "";
        int ll_max;
        int li_ordno;
        invdouBean.setCompany(facno);
        Invdou invdou = invdouBean.findByTrtype(trtype);
        if (invdou != null) {

            ls_autochar = invdou.getAutochar().toString();
            ls_autono = invdou.getAutoyn();
            ls_nofmt = invdou.getNofmt();
            li_ordno = Integer.parseInt(ls_nofmt.substring(5));//流水号
            ls_trno = this.getStaticno(facno, ls_depcode, trtype, trdate, ls_nofmt, ls_autochar);
            ll_max = this.getMaxtrno(facno, trtype, ls_trno);
            if (ll_max == 0) {
                String a = "00000000001";
                ls_serial = ls_trno + a.substring(a.length() - li_ordno);       //右边取li_ordno位
                if (updateflag) {
                    try {
                        Invserno invser = new Invserno();
                        InvsernoPK invserPK = new InvsernoPK();
                        invserPK.setFacno(facno);
                        invserPK.setTrtype(trtype);
                        invserPK.setKeyformat(ls_trno);
                        invser.setInvsernoPK(invserPK);
                        invser.setMaxserno((short) 1);
                        this.setCompany(facno);
                        this.persist(invser);
                    } catch (Exception ex) {
                        return "";
                    }
                }
            } else {
                ll_max += 1;
                String a = "0000000000" + ll_max;//
                ls_serial = ls_trno + a.substring(a.length() - li_ordno);//右边取li_ordno位
                if (updateflag) {
                    try {
                        this.setCompany(facno);
                        Invserno invser = this.findByPK(facno, trtype, ls_trno);
                        invser.setMaxserno((short) ll_max);
                        this.update(invser);
                    } catch (Exception ex) {
                        return "";
                    }
                }
            }

        }
        return ls_serial;
    }

    private String getStaticno(String facno, String depcode, String trtype, Date trdate, String ls_nofmt, String autochar) {
        String ls_no;
        String ls_str = "";
        String ls_ch;
        int li_i = 0;
        int li_ordno = 0;
        int li_month = 0;
        if (autochar == null || "0".equals(autochar)) {
            autochar = "";
        }
        ls_no = autochar.trim();
        for (int i = 0; i < 5; i++) {
            ls_ch = ls_nofmt.substring(i, i + 1);
            switch (ls_ch) {
                case "1":
                    ls_no += facno;
                    break;
                case "2":
                    ls_no += trtype;
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
                    if (li_month == 10) {
                        ls_str = "A";
                    }
                    if (li_month == 11) {
                        ls_str = "B";
                    }
                    if (li_month == 12) {
                        ls_str = "C";
                    }
                    if (li_month < 10) {
                        ls_str = BaseLib.formatDate("M", trdate);
                    }
                    ls_no += ls_str;
                    break;
                case "7":
                    ls_no += BaseLib.formatDate("dd", trdate);
                    break;
                case "9":
                    ls_no += depcode.trim();
                    break;
                default:
                    break;
            }
        }
        return ls_no;
    }

    private int getMaxtrno(String facno, String trtype, String ls_trno) {
        int retvalue = 0;
        this.setCompany(facno);
        Invserno invserno = this.findByPK(facno, trtype, ls_trno);
        if (invserno != null) {
            retvalue = invserno.getMaxserno();
        }
        return retvalue;
    }

}
