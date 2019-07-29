/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrdpopsfk;
import cn.hanbell.erp.entity.Cdrhpopsfk;
import cn.hanbell.erp.entity.Cdrsfkrno;
import cn.hanbell.erp.entity.CdrsfkrnoPK;
import cn.hanbell.util.BaseLib;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class CdrhpopsfkBean extends SuperEJBForERP<Cdrhpopsfk> {

    @EJB
    private CdrsfkrnoBean cdrsfkrnoBean;
    @EJB
    private CdrdpopsfkBean cdrdpopsfkBean;
    private List<Cdrdpopsfk> detaiList;

    public CdrhpopsfkBean() {
        super(Cdrhpopsfk.class);
    }

    public void persistDetailList(String facno, List<Cdrdpopsfk> detaiList) {
        if (detaiList.size() > 0) {
            for (Cdrdpopsfk sfkd : detaiList) {
                cdrdpopsfkBean.setCompany(facno);
                cdrdpopsfkBean.persist(sfkd);
            }

        }
    }

    public String gettrno(String ls_facno, Date ld_trdate, String crtprg, boolean b) {
        String ls_keyformat;
        String ls_trnotype;
        String ls_no;
        int ll_max = 0;
        switch (crtprg) {
            case "CDR220":
                ls_trnotype = "A";
                break;
            case "CDR310":
                ls_trnotype = "B";
                break;
            case "MAN330":
                ls_trnotype = "C";
                break;
            default:
                ls_trnotype = "";
        }

        ls_keyformat = "F" + ls_trnotype;
        ls_keyformat += BaseLib.formatDate("yy", ld_trdate);
        ls_keyformat += BaseLib.formatDate("MM", ld_trdate);
        cdrsfkrnoBean.setCompany(ls_facno);
        ll_max = cdrsfkrnoBean.getMaxno(ls_facno, ls_trnotype, ls_keyformat);
        String a = "0000000000";
        if (ll_max == 0) {
            a = a + "1";
            ls_no = ls_facno + ls_keyformat + a.substring(a.length() - 5);
            if (b) {
                Cdrsfkrno sfkno = new Cdrsfkrno();
                CdrsfkrnoPK sfknopk = new CdrsfkrnoPK();
                sfknopk.setFacno(ls_facno);
                sfknopk.setKeyformat(ls_keyformat);
                sfknopk.setTrtype(ls_trnotype);
                sfkno.setCdrsfkrnoPK(sfknopk);
                sfkno.setMaxseq((short) 1);
                cdrsfkrnoBean.persist(sfkno);
                cdrsfkrnoBean.getEntityManager().flush();
            }

        } else {
            ll_max += 1;
            a = a + ll_max;
            ls_no = ls_facno + ls_keyformat + a.substring(a.length() - 5);
            if (b) {
                Cdrsfkrno sfkno = cdrsfkrnoBean.findByPK(ls_facno, ls_trnotype, ls_keyformat);
                sfkno.setMaxseq((short) ll_max);
                cdrsfkrnoBean.update(sfkno);
                cdrsfkrnoBean.getEntityManager().flush();
            }
        }
        return ls_no;
    }

    public List<Cdrdpopsfk> getDetaiList() {
        return detaiList;
    }

    public void setDetaiList(List<Cdrdpopsfk> detaiList) {
        this.detaiList = detaiList;
    }

}
