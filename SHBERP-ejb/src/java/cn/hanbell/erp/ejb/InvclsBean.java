/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Invcls;
import cn.hanbell.oa.ejb.HKJS007Bean;
import cn.hanbell.oa.entity.HKJS007;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

@Stateless
@LocalBean
public class InvclsBean extends SuperEJBForERP<Invcls> {

    @EJB
    private HKJS007Bean hkjs007Bean;
    @EJB
    private SyncGZBean syncGZBean;
    @EJB
    private SyncJNBean syncJNBean;
    @EJB
    private SyncNJBean syncNJBean;
    @EJB
    private SyncCQBean syncCQBean;
    @EJB
    private SyncComerBean syncComerBean;
    @EJB
    private SyncHKBean syncHKBean;

    public InvclsBean() {
        super(Invcls.class);
    }

    // 品号大件申请单
    public Boolean createByOAHKJS007(String psn) {

        HKJS007 h = hkjs007Bean.findByPSN(psn);
        if (h == null) {
            throw new NullPointerException(psn + "不存在");
        }
        String facno = h.getFacno();
        this.setCompany(facno);
        try {
            Invcls invcls = new Invcls();

            invcls.setClsdsc(h.getClsdsc());// 品号大类说明
            invcls.setItnbrcode(h.getItnbrcode().charAt(0));// 设置品号组成方式itnbrcode
            invcls.setGrdescyn(h.getGrdescyn().charAt(0));// 设置是否由属性项目流水号组成品名
            invcls.setGrdescitem(Short.parseShort(h.getGrdescitem()));// 设置属性项目流水号
            invcls.setGrdesc1(h.getGrdesc1());// 属性项目1
            invcls.setGrdesc2(h.getGrdesc2());// 属性项目2
            invcls.setGrdesc3(h.getGrdesc3());// 属性项目3
            invcls.setGrdesc4(h.getGrdesc4());// 属性项目4
            invcls.setGrdesc5(h.getGrdesc5());// 属性项目5
            invcls.setGrdesc6(h.getGrdesc6());// 属性项目6

            String[] gcheck = {h.getComputeGcheck1(), h.getComputeGcheck2(), h.getComputeGcheck3(), h.getComputeGcheck4(),
                h.getComputeGcheck5(), h.getComputeGcheck6(), "N", "N", "N", "N", "N", "N"};
            for (int n = 1; n < gcheck.length; n++) {
                if (gcheck[n].equals("0")) {
                    gcheck[n] = "N";
                }
            }
            String[] gitnbr = {h.getComputeGitnbr1(), h.getComputeGitnbr2(), h.getComputeGitnbr3(), h.getComputeGitnbr4(),
                h.getComputeGitnbr5(), h.getComputeGitnbr6(), "N", "N", "N", "N", "N", "N"};
            for (int i = 0; i < gitnbr.length; i++) {
                if (gitnbr[i].equals("0")) {
                    gitnbr[i] = "N";
                }
            }
            String[] gitdsc = {h.getComGitdsc1(), h.getComGitdsc2(), h.getComGitdsc3(), h.getComGitdsc4(), h.getComGitdsc5(),
                h.getComGitdsc6(), "N", "N", "N", "N", "N", "N"};
            for (int j = 0; j < gitdsc.length; j++) {
                if (gitdsc[j].equals("0")) {
                    gitdsc[j] = "N";
                }
            }
            String[] gspdsc = {h.getComGspdsc1(), h.getComGspdsc2(), h.getComGspdsc3(), h.getComGspdsc4(), h.getComGspdsc5(),
                h.getComGspdsc6(), "N", "N", "N", "N", "N", "N"};
            for (int k = 0; k < gspdsc.length; k++) {
                if (gspdsc[k].equals("0")) {
                    gspdsc[k] = "N";
                }
            }
            String[] gmodel = {h.getComGmodel1(), h.getComGmodel2(), h.getComGmodel4(), h.getComGmodel4(), h.getComGmodel5(),
                h.getComGmodel6(), "N", "N", "N", "N", "N", "N"};
            for (int m = 0; m < gmodel.length; m++) {
                if (gmodel[m].equals("0")) {
                    gmodel[m] = "N";
                }
            }

            invcls.setGcheck(getValue(gcheck));// 设置检查码
            invcls.setGitnbr(getValue(gitnbr));// 设置组成品号
            invcls.setGitdsc(getValue(gitdsc));// 设置组成品名
            invcls.setGspdsc(getValue(gspdsc));// 设置组成规格
            invcls.setGmodel(getValue(gmodel));// 设置组成型号 这个状态会报错，数据库只有一个，表单有六个
            invcls.setItcls(h.getItcls());// 设置品号大类
            invcls.setCdrbomsubyn(h.getCdrbomsubyn().charAt(0));// 是否执行订单规格管理
            invcls.setCertyn(h.getCertyn().charAt(0)); // 设置认证过才能进行采购
            invcls.setNrcode(h.getNrcode().charAt(0)); // 设置批号管理方式
            invcls.setFixdsc(h.getFixdsc()); // 设置固定批号说明
            invcls.setFixdscf(h.getFixdscf());// 固定批号说明类别说明
            invcls.setVardsc(h.getVardsc()); // 设置变动批号说明
            invcls.setMakeyn(h.getMakeyn().charAt(0)); // 设置自动生成制作码
            invcls.setModelyn(h.getModelyn().charAt(0)); // 设置自动产生型号
            invcls.setMakeCode(h.getMakecode()); // 设置产品别代码

            if (h.getMakelen() == null && " ".equals(h.getMakelen())) {
                invcls.setMakelen(null); // 设置流水长度
            } else {
                invcls.setMakelen(Integer.parseInt(h.getMakelen())); // 设置流水长度
            }
            invcls.setItclscode(h.getItclscode().charAt(0)); // itclscode设置品号归类
            invcls.setGpitdscyn("Y".charAt(0));
            invcls.setGpspdscyn("Y".charAt(0));
            invcls.setStatus("Y");
            invcls.setJityn(h.getJityn().charAt(0));
            invcls.setMainteyn("N".charAt(0));
            invcls.setModelno("1".charAt(0));
            invcls.setModeldsc("1".charAt(0));
            invcls.setUserno(h.getApplyuser());
            invcls.setIndate(h.getApplydata());// 时间

            setCompany(h.getFacno());
            persist(invcls, null);
            getEntityManager().flush();

            if (h.getFacno().equals("C")) {
                // 广州
                syncGZBean.persist(invcls, null);
                syncGZBean.getEntityManager().flush();
                // 济南
                syncJNBean.persist(invcls, null);
                syncJNBean.getEntityManager().flush();
                // 南京
                syncNJBean.persist(invcls, null);
                syncNJBean.getEntityManager().flush();
                // 重庆
                syncCQBean.persist(invcls, null);
                syncCQBean.getEntityManager().flush();
                // 柯茂
                syncComerBean.persist(invcls, null);
                syncComerBean.getEntityManager().flush();
                // 香港
                syncHKBean.persist(invcls, null);
                syncHKBean.getEntityManager().flush();

            }
            return true;
        } catch (Exception ex) {
            Logger.getLogger(InvmasBean.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("程序发生异常!错误指示：" + ex);
        }
    }

    public Invcls findByItcls(String itcls) {
        Query query = getEntityManager().createNamedQuery("Invcls.findByItcls");
        query.setParameter("itcls", itcls);
        try {
            return (Invcls) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public String findPurtrtypeByItclscode(String value) {
        Query query = getEntityManager().createNativeQuery(
                "select purtrtype from purdou p ,invdou v where p.trtype = v.trtype and p.itclscode = ?1 and v.iocode='1'");
        query.setParameter(1, value);
        try {
            return query.getSingleResult().toString();
        } catch (Exception ex) {
            return "";
        }
    }

    private String getValue(String[] arr) {
        String str = "";
        for (String s : arr) {
            str += s;
        }
        return str;
    }

    public void persistIfNotExist(Invcls invcls) {
        Invcls i = this.findByItcls(invcls.getItcls());
        if (i == null) {
            this.persist(invcls);
        }
    }

}
