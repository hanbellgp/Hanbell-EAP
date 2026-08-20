/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Accrno;
import cn.hanbell.util.BaseLib;
import java.util.Date;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class AccrnoBean extends SuperEJBForERP<Accrno> {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public AccrnoBean() {
        super(Accrno.class);
    }

    public Accrno findMaxByPK(String facno, Date date) {
        Query query = getEntityManager().createNamedQuery("Accrno.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("finvdate", date);
        try {
            return (Accrno) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public String getFormId(String facno, Date date, Boolean flag) throws Exception {
        // 最多重试 5 次，应对并发号码重复
        int retryMax = 5;
        for (int retry = 0; retry < retryMax; retry++) {
            String newid;
            int maxid;
            Accrno accrno = findMaxByPK(facno, date);
            if (accrno != null) {
                int oldFinvno = accrno.getFinvno();
                maxid = oldFinvno + 1;
                newid = facno + BaseLib.formatDate("yyyyMMdd", date).substring(3) + String.format("%05d", maxid);
                if (flag) {
                    //原子更新，只在旧号没变时才更新
                    int rows = this.getEntityManager().createNativeQuery("UPDATE accrno SET finvno = ? WHERE facno = ? AND finvdate = ? AND finvno = ?")
                            .setParameter(1, maxid)
                            .setParameter(2, facno)
                            .setParameter(3, date)
                            .setParameter(4, oldFinvno)
                            .executeUpdate();

                    // 更新失败 = 并发冲突，重试
                    if (rows == 0) {
                        continue;
                    }
                    // 更新成功，返回单号
                    return newid;
                } else {
                    return newid;
                }
            } else {
                newid = facno + BaseLib.formatDate("yyyyMMdd", date).substring(3) + String.format("%05d", 1);
                if (flag) {
                    try {
                        Accrno e = new Accrno(facno, date);
                        e.setFinvno(1);
                        this.persist(e);
                        //this.getEntityManager().flush();
                        return newid;
                    } catch (Exception e) {
                        continue;
                    }

                } else {
                    return newid;
                }
            }

        }
        // 超出最大重试次数
        throw new RuntimeException("生成单号重试" + retryMax + "次失败，请稍后重试");
    }

}
