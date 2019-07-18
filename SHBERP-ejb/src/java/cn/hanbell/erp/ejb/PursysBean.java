/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Purserno;
import cn.hanbell.erp.entity.Pursys;
import cn.hanbell.util.BaseLib;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class PursysBean extends SuperEJBForERP<Pursys> {

    @EJB
    PursernoBean pursernoBean;

    public PursysBean() {
        super(Pursys.class);
    }

    public Pursys findByPK(String facno, String prono) {
        Query query = getEntityManager().createNamedQuery("Pursys.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("prono", prono);
        try {
            return (Pursys) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public String getFormId(String facno, String prono, Date date, Boolean flag) throws Exception {
        String newid;
        String prno;
        int maxSeq;
        this.setCompany(facno);
        Pursys p = this.findByPK(facno, prono);
        if (p == null) {
            throw new NullPointerException();
        }
        //永远为国内采购
        String decode = "1";
        //请购单自动编号为Y
        if (p.getPrautoyn() == 'Y') {
            //检查自动编号是否包含部门别
            if (p.getPrnofmt() != null && p.getPrnofmt().indexOf('9') >= 0) {
                throw new Exception("含部门别自动编号生成,程式未完成");
            } else {
                // 读取单据编号使用的流水号位数
                String ordno = p.getPrnofmt().substring(p.getPrnofmt().length() - 1);

                //传回单据自动编号时的所组成的编号
                StringBuilder sbSn = new StringBuilder();
                if (p.getPrautochar() != null) {
                    sbSn.append(p.getPrautochar());
                }

                for (int i = 0; i < 5; i++) {
                    String tmpCh = p.getPrnofmt().substring(i, i + 1);
                    switch (tmpCh) {
                        case "1":
                            sbSn.append(facno);
                            continue;
                        case "8":
                            sbSn.append(prono);
                            continue;
                        case "2":
                            sbSn.append(BaseLib.formatDate("yyyy", date));
                            continue;
                        case "3":
                            sbSn.append(BaseLib.formatDate("yy", date));
                            continue;
                        case "4":
                            sbSn.append(BaseLib.formatDate("MM", date));
                            continue;
                        case "5":
                            String month = BaseLib.formatDate("MM", date);
                            if ("10".equals(month)) {
                                month = "A";
                            } else if ("11".equals(month)) {
                                month = "B";
                            } else if ("12".equals(month)) {
                                month = "C";
                            }
                            sbSn.append(month);

                            continue;
                        case "6":
                            sbSn.append(BaseLib.formatDate("yyyyMM", date));
                            continue;
                        case "7":
                            sbSn.append(decode.trim());
                            continue;
                        default:
                            break;
                    }
                }
                prno = sbSn.toString();
                System.out.println(prno);

                //得到最大编号
                pursernoBean.setCompany(facno);
                Purserno ps = pursernoBean.findByPK(facno, prono, '0', prno);
                if (ps == null) {
                    maxSeq = 1;
                    if (flag) {
                        Purserno purserno = new Purserno(facno, prono, '0', prno);
                        purserno.setMaxserno((short) maxSeq);
                        pursernoBean.persist(purserno);
                        pursernoBean.getEntityManager().flush();
                    }

                } else {

                    maxSeq = ps.getMaxserno() + 1;
                    if (flag) {
                        ps.setMaxserno((short) maxSeq);
                        pursernoBean.update(ps);
                        pursernoBean.getEntityManager().flush();
                    }
                }

                String tmp = "000000000000" + maxSeq;
                newid = prno + tmp.substring(tmp.length() - Integer.parseInt(ordno));

            }

            return newid;

        } else {
            throw new Exception("请购单自动编号状态为 N 的程式未完成");
        }
    }

}
