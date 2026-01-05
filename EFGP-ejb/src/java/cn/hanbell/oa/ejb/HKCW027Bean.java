/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKCW027;
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
public class HKCW027Bean extends SuperEJBForEFGP<HKCW027> {

    public HKCW027Bean() {
        super(HKCW027.class);
    }
//根据fromid查是否有OA单子
    public List<HKCW027> getOaFormid(String formid) {
        Query query = getEntityManager().createNativeQuery("Select * from HK_CW027 where formid='" + formid + "'");
        List<HKCW027> lenList = query.getResultList();
        return lenList;
    }
}
