/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.plm.ejb;

import cn.hanbell.plm.comm.SuperEJBForPLM;
import cn.hanbell.plm.entity.PLMProject;
import com.lightshell.comm.BaseLib;
import java.util.Date;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class PLMProjectBean extends SuperEJBForPLM<PLMProject> {

    @PersistenceContext(unitName = "PLM-projPU")
    private EntityManager em;

    public PLMProjectBean() {
        super(PLMProject.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public PLMProject findByProjno(String projno) {
        Query query = getEntityManager().createNamedQuery("PLMProject.findByProjno");
        query.setParameter("projno", projno);
        try {
            Object o = query.getSingleResult();
            return (PLMProject) o;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public String getFormId(Date day, String code, String format, int len) {
        String maxid, newid;
        int id;
        if (day != null && code != null && len > 0) {
            String d = "";
            if (format != null && !format.equals("")) {
                d = BaseLib.formatDate(format, day);
            }
            int c = code.length();
            int f = d.length();
            Query query = getEntityManager().createNativeQuery("select max(projno) from  plm_project "
                    + " where substring(projno," + 1 + "," + (c + f) + ")='" + (code + d) + "'"
                    + " and len(projno)= " + (c + f + len));
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

}
