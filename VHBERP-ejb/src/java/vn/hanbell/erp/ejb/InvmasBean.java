/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.ejb;

import vn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.oa.ejb.VHTK001Bean;
import cn.hanbell.oa.entity.VHTK001;
import cn.hanbell.oa.entity.VHTK001Detail;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;
import vn.hanbell.erp.entity.Invmas;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class InvmasBean extends SuperEJBForERP<Invmas> {

    @EJB
    private VHTK001Bean vhtk001Bean;

    public InvmasBean() {
        super(Invmas.class);
    }

    public Invmas findByItnbr(String itnbr) {
        Query query = getEntityManager().createNamedQuery("Invmas.findByItnbr");
        query.setParameter("itnbr", itnbr);
        try {
            return (Invmas) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public Boolean initByOAVHTK001(String psn) {

        VHTK001 h = vhtk001Bean.findByPSN(psn);
        if (h == null) {
            throw new NullPointerException();
        }
        this.setCompany(h.getFacno());
        List<VHTK001Detail> details = vhtk001Bean.getDetailList(h.getFormSerialNumber());
        try {
            //表身循环
            for (int i = 0; i < details.size(); i++) {
                VHTK001Detail detail = details.get(i);
                if (null == this.findByItnbr(detail.getItnbr())) {
                    Invmas m = new Invmas();
                    m.setItnbr(detail.getItnbr());                                  //设置件号
                    m.setItcls(detail.getItcls());                                  //设置品号大类
                    m.setItclscode(detail.getItclscode().charAt(0));                //设置品号归类
                    m.setItdsc(detail.getItdsc());                                  //设置中文品名
                    m.setSpdsc(detail.getSpdsc());                                  //设置中文规格
                    m.setEitdsc(detail.getEitdsc());                                //设置英文品名
                    m.setEspdsc(detail.getEspdsc());                                //设置英文规格
                    m.setUnmsr1(detail.getUnmsr1());                                //设置单位一
                    m.setUnmsr2(detail.getUnmsr2());                                //设置单位二
                    m.setUnmsr1e(detail.getUnmsr1e());                              //设置数量单位一（英文）
                    m.setFvco('F');                                                 //设置固定变动区分码
                    if ("".equals(detail.getUnmsr2()) || "N".equals(detail.getIsDUnit())) {
                        m.setJudco("11111");                                        //设置数量单位控制码
                    } else {
                        m.setJudco("41111");
                        m.setRate2(BigDecimal.valueOf(Double.parseDouble(detail.getRate2())));       //设置换算率
                    }
                    m.setPocode(' ');
                    m.setMorpcode(detail.getMorpcode().charAt(0));                  //设置自制采购码
                    m.setGroup1(detail.getGroup1());                                //设置分类码（一）
                    m.setGroup2(detail.getGroup2());                                //设置分类码（二）
                    m.setGroup3(detail.getGroup3());
                    m.setGroup4(detail.getGroup4());
                    m.setGroup5(detail.getGroup5());
                    m.setGroup6(detail.getGroup6());
                    m.setGroup7(detail.getGroup7());
                    m.setGroup8(detail.getGroup8());
                    m.setGroup9(detail.getGroup9());
                    m.setGroup10(detail.getGroup10());
                    m.setGroup11(detail.getGroup11());
                    m.setGroup12(detail.getGroup12());
                    m.setDirrvyn('N');                                              //设置是否为直接验收
                    m.setIoyn('N');                                                 //是否验收即出库
                    m.setPurtrtype(detail.getPurtrtype());                          //设置验收类别
                    m.setLowlevel((short) 0);
                    m.setExclcode('0');
                    m.setUserno(h.getEmpl());                                       //设置申请人
                    m.setIndate(BaseLib.getDate());
                    m.setLowlevelcst((short) 0);                                    //设置低阶码
                    m.setJityn(detail.getJityn().charAt(0));                        //即时到货管制
                    m.setGenre1(detail.getHdgenre1());                              //设置产品别
                    //更新到数据库
                    persist(m);
                }
            }
            return true;
        } catch (Exception ex) {
            log4j.error(ex);
            throw new RuntimeException(ex);
        }

    }

}
