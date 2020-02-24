/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.hrm.ejb;

import cn.hanbell.hrm.comm.SuperEJBForHRM;
import cn.hanbell.hrm.entity.CodeInfo;
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
public class CodeInfoBean extends SuperEJBForHRM<CodeInfo> {

    public CodeInfoBean() {
        super(CodeInfo.class);
    }

    public List<CodeInfo> findByDecisionLevel() {
        Query query = this.getEntityManager().createNamedQuery("CodeInfo.findByKindCode");
        query.setParameter("kindCode", "DecisionLevel");
        return query.getResultList();
    }

}
