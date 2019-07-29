/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Apmrno;
import cn.hanbell.erp.entity.Apmsys;
import cn.hanbell.util.BaseLib;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class ApmsysBean extends SuperEJBForERP<Apmsys> {

    @EJB
    private ApmrnoBean apmrnoBean;

    public ApmsysBean() {
        super(Apmsys.class);
    }

    public String getFormId(String facno, String prgno, Date date, Boolean flag) throws Exception {
        String maxid, newid;
        String prg, code, format, header;
        Integer seqlen, id;
        Apmsys e = this.findById(facno);
        if (e == null) {
            throw new NullPointerException();
        }
        switch (prgno) {
            case "APM525":
                prg = "1";
                code = e.getAutnrfnt1();
                format = getFormCode(facno, date, e.getAutnrformat1().substring(0, 1)) + getFormCode(facno, date, e.getAutnrformat1().substring(1, 2))
                        + getFormCode(facno, date, e.getAutnrformat1().substring(2, 3)) + getFormCode(facno, date, e.getAutnrformat1().substring(3, 4))
                        + getFormCode(facno, date, e.getAutnrformat1().substring(4, 5));
                seqlen = Integer.parseInt(e.getAutnrformat1().substring(5));
                break;
            default:
                prg = "";
                code = "";
                format = "";
                seqlen = 0;
        }
        header = code + format;
        apmrnoBean.setCompany(facno);
        Apmrno n = apmrnoBean.findMaxByPK(facno, prg, header + "%");
        if (n != null) {
            maxid = n.getApmrnoPK().getMaxnumber();
            int m = maxid.length();
            id = Integer.parseInt(maxid.substring(m - seqlen, m));
            newid = header + String.format("%0" + seqlen + "d", id + 1);
        } else {
            newid = header + String.format("%0" + seqlen + "d", 1);
        }
        if (flag) {
            apmrnoBean.persist(new Apmrno(facno, prg, newid));
            if (n != null) {
                apmrnoBean.delete(n);
            }
        }
        return newid;

    }

    protected String getFormCode(String facno, Date date, String code) {

        String trno = "", dateString;
        Integer month;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        switch (code) {
            case "0":
                trno = "";
                break;
            case "1":
            case "A":
            case "B":
            case "C":
                trno = facno;
                break;
            case "2":
                dateString = BaseLib.formatDate("yyyy", date);
                trno = dateString.substring(2);
                break;
            case "D":
                trno = BaseLib.formatDate("yyyy", date);
                break;
            case "E":
                dateString = BaseLib.formatDate("yyyy", date);
                trno = dateString.substring(3);
                break;
            case "3":
                month = c.get(Calendar.MONTH) + 1;
                trno = String.format("%02d", month);
                break;
            case "F":
                month = c.get(Calendar.MONTH) + 1;
                switch (month) {
                    case 10:
                        trno = "A";
                        break;
                    case 11:
                        trno = "B";
                        break;
                    case 12:
                        trno = "C";
                        break;
                    default:
                        trno = month.toString();
                }
                break;
            case "4":
                dateString = BaseLib.formatDate("yyyyMMdd", date);
                trno = dateString.substring(6);
                break;
        }
        return trno;
    }

    public Apmsys findByFacno(String facno) {
        Query query = getEntityManager().createNamedQuery("Apmsys.findByFacno");
        query.setParameter("facno", facno);
        try {
            return (Apmsys) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }

    }
}
