/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.edw.ejb;

import cn.hanbell.edw.comm.SuperEJBForEDW;
import cn.hanbell.edw.entity.SopSafemanagerStandard;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C2079
 */
@Stateless
@LocalBean
public class SopSafemanagerStandardBean extends SuperEJBForEDW<SopSafemanagerStandard> {

    public SopSafemanagerStandardBean() {
        super(SopSafemanagerStandard.class);
    }

    public List<SopSafemanagerStandard> getSopSafemanagerStandardList(String Company, String Post,String Factory) {
        String sqlStr = "SELECT * FROM SopSafemanagerStandard  where Company='"+Company+"'  and Post='"+Post+"' and Factory='"+Factory+"'   ORDER BY   CheckType";

        try {
            Query query = getEntityManager().createNativeQuery(sqlStr, SopSafemanagerStandard.class);
            List<SopSafemanagerStandard> results = query.getResultList();
            return results;
        } catch (Exception ex) {
            return null;
        }
    }

}
