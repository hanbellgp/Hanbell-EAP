/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.PORMY;
import cn.hanbell.crm.entity.PORMYPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

@Stateless
@LocalBean
public class PORMYBean extends SuperEJBForCRM<PORMY> {

    public PORMYBean() {
        super(PORMY.class);
    }

    public PORMY findByMY002(String crmno) {
        PORMYPK pk = new PORMYPK();
        pk.setMy001("A1");
        pk.setMy002(crmno);
        Query query = getEntityManager().createNamedQuery("PORMY.findByPK");
        query.setParameter("pormyPK", pk);
        try {
            Object o = query.getSingleResult();
            return (PORMY) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public String getSerialNumber(String my003) {
        String ls_no = "";
        String serial = "000";
        String sql = "SELECT * FROM PORMY WHERE MY002 LIKE '" + my003 + "%' ORDER BY MY002 DESC ";
        Query query = getEntityManager().createNativeQuery(sql);
        List result = query.getResultList();
        int m = 0;
        if (null != result && !result.isEmpty()) {
            m = result.size();
            m = m + 1;
        } else {
            m = 1;
        }
        serial = serial + m;
        serial = serial.substring(String.valueOf(m).length());
        ls_no = my003 + serial;
        return ls_no;
    }

}
