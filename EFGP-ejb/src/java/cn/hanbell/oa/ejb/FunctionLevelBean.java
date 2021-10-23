/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.FunctionLevel;
import cn.hanbell.oa.entity.Functions;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class FunctionLevelBean extends SuperEJBForEFGP<FunctionLevel> {
    
    public FunctionLevelBean() {
        super(FunctionLevel.class);
    }
    
        public List<FunctionLevel> findByFunctionLevelName(String functionlevelname) {
        try {
            StringBuffer sql=new StringBuffer();
            sql.append("SELECT * FROM FunctionLevel f WHERE f.functionLevelName = N'");
            sql.append(functionlevelname);
            sql.append("' and f.objectVersion=(select max(fl.objectVersion) from FunctionLevel fl)");
            Query query = getEntityManager().createNativeQuery(sql.toString(),FunctionLevel.class);
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
