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
    private PursernoBean pursernoBean;

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

    public String getNewPrno(String facno, String prono, Date date, Boolean flag) throws Exception {
        String newid;
        String prformat;
        int max;
        this.setCompany(facno);
        Pursys p = this.findByPK(facno, prono);
        if (p == null) {
            throw new NullPointerException();
        }
        // 永远为国内采购
        String decode = "1";
        // 请购单自动编号为Y
        if (p.getPrautoyn() == 'Y') {
            // 检查自动编号是否包含部门别
            if (p.getPrnofmt() != null && p.getPrnofmt().indexOf('9') >= 0) {
                throw new RuntimeException("含部门别自动编号生成,程式未完成");
            } else {
                // 读取单据编号使用的流水号位数
                String ordno = p.getPrnofmt().substring(p.getPrnofmt().length() - 1);
                // 传回单据自动编号时的所组成的编号
                prformat = getStaticno(facno, prono, p.getPrautochar().toString(), date, decode, p.getPrnofmt());
                // 得到最大编号
                Purserno ps = pursernoBean.findByPK(facno, prono, '0', prformat);
                if (ps == null) {
                    max = 1;
                    if (flag) {
                        Purserno purserno = new Purserno(facno, prono, '0', prformat);
                        purserno.setMaxserno((short) max);
                        pursernoBean.persist(purserno);
                        pursernoBean.getEntityManager().flush();
                    }
                } else {
                    max = ps.getMaxserno() + 1;
                    if (flag) {
                        ps.setMaxserno((short) max);
                        pursernoBean.update(ps);
                        pursernoBean.getEntityManager().flush();
                    }
                }
                String tmp = "000000000000" + max;
                newid = prformat + tmp.substring(tmp.length() - Integer.parseInt(ordno));
            }
            return newid;
        } else {
            throw new RuntimeException("请购单自动编号状态为 N 不可继续");
        }
    }

    public String getNewPono(String facno, String prono, Date date, String decode, Boolean flag) throws Exception {
        String newid;
        String poformat;
        int max;
        this.setCompany(facno);
        Pursys p = this.findByPK(facno, prono);
        if (p == null) {
            throw new NullPointerException();
        }
        // 采购单自动编号为Y
        if (p.getPoautoyn() == 'Y') {
            // 读取单据编号使用的流水号位数
            String len = p.getPonofmt().substring(p.getPonofmt().length() - 1);
            poformat = getStaticno(facno, prono, p.getPoautochar().toString(), date, decode, p.getPonofmt());
            // 得到最大编号
            Purserno ps = pursernoBean.findByPK(facno, prono, '1', poformat);
            if (ps == null) {
                max = 1;
                if (flag) {
                    Purserno purserno = new Purserno(facno, prono, '1', poformat);
                    purserno.setMaxserno((short) max);
                    pursernoBean.persist(purserno);
                    pursernoBean.getEntityManager().flush();
                }
            } else {
                max = ps.getMaxserno() + 1;
                if (flag) {
                    ps.setMaxserno((short) max);
                    pursernoBean.update(ps);
                    pursernoBean.getEntityManager().flush();
                }
            }
            String tmp = "000000000000" + max;
            newid = poformat + tmp.substring(tmp.length() - Integer.parseInt(len));
            return newid;
        } else {
            throw new RuntimeException("采购单自动编号状态为 N 不可继续");
        }
    }

    private String getStaticno(String facno, String prono, String autochar, Date date, String decode, String nofmt) {
        // 传回单据自动编号时的所组成的编号
        StringBuilder sb = new StringBuilder();
        if (autochar != null && !"0".equals(autochar)) {
            sb.append(autochar);
        }
        for (int i = 0; i < 5; i++) {
            String f = nofmt.substring(i, i + 1);
            switch (f) {
                case "1":
                    sb.append(facno);
                    continue;
                case "8":
                    sb.append(prono);
                    continue;
                case "2":
                    sb.append(BaseLib.formatDate("yyyy", date));
                    continue;
                case "3":
                    sb.append(BaseLib.formatDate("yy", date));
                    continue;
                case "4":
                    sb.append(BaseLib.formatDate("MM", date));
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
                    sb.append(month);
                    continue;
                case "6":
                    sb.append(BaseLib.formatDate("yyyyMM", date));
                    continue;
                case "7":
                    sb.append(decode.trim());
                    break;
                default:
                    break;
            }
        }
        return sb.toString();
    }

    @Override
    public void setCompany(String company) {
        super.setCompany(company);
        pursernoBean.setCompany(company);
    }

}
