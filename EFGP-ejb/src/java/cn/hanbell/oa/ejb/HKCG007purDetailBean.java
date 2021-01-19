/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKCG007purDetail;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class HKCG007purDetailBean extends SuperEJBForEFGP<HKCG007purDetail> {

    public HKCG007purDetailBean() {
        super(HKCG007purDetail.class);
    }

    public List<HKCG007purDetail> findByFSN(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuffer where = new StringBuffer();
        for (String s : list) {
            where = where.append("'").append(s).append("'").append(",");
        }
        try {
            StringBuffer sql = new StringBuffer("SELECT * FROM HK_CG007_purDetail where formSerialNumber in (");
            sql.append(where.subSequence(0, where.length()-1)).append(")");
            Query query = getEntityManager().createNativeQuery(sql.toString(), HKCG007purDetail.class);
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
