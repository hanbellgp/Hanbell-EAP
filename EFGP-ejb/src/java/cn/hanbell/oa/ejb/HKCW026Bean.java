/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKCW026;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2079
 */
@Stateless
@LocalBean
public class HKCW026Bean extends SuperEJBForEFGP<HKCW026> {

    public HKCW026Bean() {
        super(HKCW026.class);
    }
//根据fromid查是否有OA单子

    public List<HKCW026> getOaFormid(String formid) {
        String maxid;
        Query query = getEntityManager().createNativeQuery("Select * from HK_CW026 where formid='" + formid + "'");

        List<HKCW026> lenList = query.getResultList();

        return lenList;

    }
}
