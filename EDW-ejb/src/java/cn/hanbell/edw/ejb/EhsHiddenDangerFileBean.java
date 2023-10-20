/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.edw.ejb;

import cn.hanbell.edw.comm.SuperEJBForEDW;
import cn.hanbell.edw.entity.EhsHiddenDangerFile;
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
public class EhsHiddenDangerFileBean extends SuperEJBForEDW<EhsHiddenDangerFile> {

    public EhsHiddenDangerFileBean() {
        super(EhsHiddenDangerFile.class);
    }
    
    public List<EhsHiddenDangerFile> getPid(String  pid) {
          Query query = getEntityManager().createNamedQuery("EhsHiddenDangerFile.findByPid");
        query.setParameter("pid", pid);
        try {
            List results = query.getResultList();
            return results;
        } catch (Exception ex) {
            return null;
        }
    }


}
