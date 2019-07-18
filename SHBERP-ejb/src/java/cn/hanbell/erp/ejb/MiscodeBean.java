/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Miscode;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class MiscodeBean extends SuperEJBForERP<Miscode> {

    public MiscodeBean() {
        super(Miscode.class);
    }

    public Miscode findByCdesc(String cdesc) {
        Query q = this.getEntityManager().createNamedQuery("Miscode.findByCdesc");
        q.setParameter("cdesc", cdesc);
        try {
            Object o = q.getSingleResult();
            return (Miscode) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public Miscode findByCkindAndCdesc(String ckind, String cdesc) {
        Query q = this.getEntityManager().createNamedQuery("Miscode.findByCkindAndCdesc");
        q.setParameter("ckind", ckind);
        q.setParameter("cdesc", cdesc);
        try {
            Object o = q.getSingleResult();
            return (Miscode) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public Miscode findByPK(String ckind, String code) {
        Query q = this.getEntityManager().createNamedQuery("Miscode.findByPK");
        q.setParameter("ckind", ckind);
        q.setParameter("code", code);
        try {
            Object o = q.getSingleResult();
            return (Miscode) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public String getFormId(String ckind, String code, int len) {
        String maxid, newid;
        int id;
        if (code != null && len > 0) {
            String d = "";
            int c = code.length();
            int f = d.length();
            Query query = getEntityManager().createNativeQuery("select max(code) from miscode where ckind='" + ckind + "' and substring(code," + 1 + "," + (c + f) + ")='" + (code + d) + "'");
            if (query.getSingleResult() != null) {
                maxid = query.getSingleResult().toString();
                int m = maxid.length();
                id = Integer.parseInt(maxid.substring(m - len, m)) + 1;
                newid = code + d + String.format("%0" + len + "d", id);
            } else {
                newid = code + d + String.format("%0" + len + "d", 1);
            }
            return newid;
        } else {
            return "";
        }
    }

    public int persistIfNotExist(String ckind, String code, String cdesc, Character mascreyn) {
        //生成miscode资料
        Miscode c;
        c = findByPK(ckind, code);
        if (c == null) {
            c = new Miscode(ckind, code);
            c.setCdesc(cdesc);
            c.setStatus('Y');
            c.setMascreyn(mascreyn);
            c.setCusds(cdesc);
            try {
                persist(c);
                return 1;
            } catch (Exception ex) {
                return -1;
            }
        }
        return 0;
    }
    
    public List<Miscode> findByCkind(String ckind ,Character status ){
       Query q = this.getEntityManager().createNamedQuery("Miscode.findByCkindAndStatus");
        q.setParameter("ckind", ckind);
        q.setParameter("status", status);
        try {             
            return q.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

}
