/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Invwhclk;
import cn.hanbell.erp.entity.Misdept;
import cn.hanbell.erp.entity.Secgprg;
import cn.hanbell.erp.entity.SecgprgPK;
import cn.hanbell.erp.entity.Secgsys;
import cn.hanbell.erp.entity.Secmemb;
import cn.hanbell.erp.entity.Secuser;
import cn.hanbell.erp.entity.Secusys;
import cn.hanbell.oa.ejb.OrganizationUnitBean;
import cn.hanbell.oa.ejb.SHBERPMIS226DetailBean;
import cn.hanbell.oa.ejb.SHBERPMIS226Bean;
import cn.hanbell.oa.ejb.SHBERPMIS226InvwhclkDetailBean;
import cn.hanbell.oa.ejb.UsersBean;
import cn.hanbell.oa.entity.OrganizationUnit;
import cn.hanbell.oa.entity.SHBERPMIS226Detail;
import cn.hanbell.oa.entity.SHBERPMIS226;
import cn.hanbell.oa.entity.SHBERPMIS226InvwhclkDetail;
import cn.hanbell.oa.entity.Users;
import com.lightshell.comm.BaseLib;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1587
 */
@Stateless
@LocalBean
public class SecgprgBean extends SuperEJBForERP<Secgprg> {

    @EJB
    private UsersBean usersBean;
    @EJB
    private OrganizationUnitBean organizationUnitBean;
    @EJB
    private SHBERPMIS226Bean shberpmis226Bean;
    @EJB
    private SHBERPMIS226DetailBean shberpmis226detailBean;
    @EJB
    private SHBERPMIS226InvwhclkDetailBean shberpmis226invwhclkdetailBean;

    @EJB
    private SecuprgBean secuprgBean;
    @EJB
    private SecgsysBean secgsysBean;
    @EJB
    private SecusysBean secusysBean;
    @EJB
    private SecuserBean secuserBean;
    @EJB
    private SecmembBean secmembBean;
    @EJB
    private MisdeptBean misdeptBean;
    @EJB
    private InvwhclkBean invwhclkBean;

    public SecgprgBean() {
        super(Secgprg.class);
    }

    public Boolean initSECGPRG(String psn) {

        SHBERPMIS226 h = shberpmis226Bean.findByPSN(psn);
        if (h == null) {
            throw new NullPointerException("找不到流程序号" + psn);
        }
        Secgprg gu;
        Secgprg gz;
        String gtype;
        String hdn_jb1;
        String hdn_jb2;
        String hdn_jb3;
        String hdn_jb4;
        String hdn_jb5;
        String hdn_jb6;
        String hdn_jb7;
        String hdn_jb8;
        String hdn_jb9;
        String hdn_jb10;
        String hdn_jb11;
        String hdn_jb12;
        String hdn_jb13;
        String hdn_other1;
        String hdn_other2;
        String hdn_other3;
        String hdn_other4;
        String hdn_other5;
        String hdn_other6;
        String hdn_other7;
        String hdn_other8;
        String hdn_other9;

        secuserBean.setCompany(h.getFacno());
        Secuser erpuser = secuserBean.findByUserno(h.getApplyuser());
        if (erpuser != null) {
            gtype = erpuser.getGtype();
        } else {
            gtype = h.getGtype() == null ? "U" : h.getGtype();
        }

        List<SHBERPMIS226Detail> details = shberpmis226detailBean.findByFSN(h.getFormSerialNumber());
        List<SHBERPMIS226InvwhclkDetail> invwhclkList = shberpmis226invwhclkdetailBean.findByFSN(h.getFormSerialNumber());
        this.setCompany(h.getFacno());
        try {
            String prgno, sysno, groupno;
            // 表身循环
            for (int i = 0; i < details.size(); i++) {

                SHBERPMIS226Detail detail = details.get(i);
                gu = new Secgprg();
                gz = new Secgprg();
                SecgprgPK gupk = new SecgprgPK();
                SecgprgPK gzpk = new SecgprgPK();
                prgno = detail.getJtcx();
                sysno = detail.getMk();
                groupno = h.getApplyuser();

                gupk.setPrgno(prgno);
                gupk.setSysno(sysno);
                gupk.setGroupno(groupno);
                gupk.setGtype("U");
                gu.setSecgprgPK(gupk);

                gzpk.setPrgno(prgno);
                gzpk.setSysno(sysno);
                gzpk.setGroupno(groupno);
                gzpk.setGtype("Z");
                gz.setSecgprgPK(gzpk);

                hdn_jb1 = detail.getHdnJb1();
                hdn_jb2 = detail.getHdnJb2();
                hdn_jb3 = detail.getHdnJb3();
                hdn_jb4 = detail.getHdnJb4();
                hdn_jb5 = detail.getHdnJb5();
                hdn_jb6 = detail.getHdnJb6();
                hdn_jb7 = detail.getHdnJb7();
                hdn_jb8 = detail.getHdnJb8();
                hdn_jb9 = detail.getHdnJb9();
                hdn_jb10 = detail.getHdnJb10();
                hdn_jb11 = detail.getHdnJb11();
                hdn_jb12 = detail.getHdnJb12();
                hdn_jb13 = detail.getHdnJb13();
                hdn_other1 = detail.getHdnOther1();
                hdn_other2 = detail.getHdnOther2();
                hdn_other3 = detail.getHdnOther3();
                hdn_other4 = detail.getHdnOther4();
                hdn_other5 = detail.getHdnOther5();
                hdn_other6 = detail.getHdnOther6();
                hdn_other7 = detail.getHdnOther7();
                hdn_other8 = detail.getHdnOther8();
                hdn_other9 = detail.getHdnOther9();

                Secgprg u = this.findByPK(prgno, sysno, groupno, "U");
                Secgprg z = this.findByPK(prgno, sysno, groupno, "Z");
                if ("".equals(hdn_jb1)) {
                    gu.setPadd('N');
                    gz.setPadd('N');
                } else {
                    gu.setPadd('Y');
                    gz.setPadd('Y');
                    if (u != null) {
                        u.setPadd('Y');
                    }
                    if (z != null) {
                        z.setPadd('Y');
                    }
                }
                if ("".equals(hdn_jb2)) {
                    gu.setPdelete('N');
                    gz.setPdelete('N');
                } else {
                    gu.setPdelete('Y');
                    gz.setPdelete('Y');
                    if (u != null) {
                        u.setPdelete('Y');
                    }
                    if (z != null) {
                        z.setPdelete('Y');
                    }
                }
                if ("".equals(hdn_jb3)) {
                    gu.setPmodify('N');
                    gz.setPmodify('N');
                } else {
                    gu.setPmodify('Y');
                    gz.setPmodify('Y');
                    if (u != null) {
                        u.setPmodify('Y');
                    }
                    if (z != null) {
                        z.setPmodify('Y');
                    }
                }
                if ("".equals(hdn_jb4)) {
                    gu.setPquery('N');
                    gz.setPquery('N');
                } else {
                    gu.setPquery('Y');
                    gz.setPquery('Y');
                    if (u != null) {
                        u.setPquery('Y');
                    }
                    if (z != null) {
                        z.setPquery('Y');
                    }
                }
                if ("".equals(hdn_jb5)) {
                    gu.setPcommit('N');
                    gz.setPcommit('N');
                } else {
                    gu.setPcommit('Y');
                    gz.setPcommit('Y');
                    if (u != null) {
                        u.setPcommit('Y');
                    }
                    if (z != null) {
                        z.setPcommit('Y');
                    }
                }
                if ("".equals(hdn_jb6)) {
                    gu.setPcancel('N');
                    gz.setPcancel('N');
                } else {
                    gu.setPcancel('Y');
                    gz.setPcancel('Y');
                    if (u != null) {
                        u.setPcancel('Y');
                    }
                    if (z != null) {
                        z.setPcancel('Y');
                    }
                }
                if ("".equals(hdn_jb7)) {
                    gu.setPprint('N');
                    gz.setPprint('N');
                } else {
                    gu.setPprint('Y');
                    gz.setPprint('Y');
                    if (u != null) {
                        u.setPprint('Y');
                    }
                    if (z != null) {
                        z.setPprint('Y');
                    }
                }
                if ("".equals(hdn_jb8)) {
                    gu.setRunsig('N');
                    gz.setRunsig('N');
                } else {
                    gu.setRunsig('Y');
                    gz.setRunsig('Y');
                    if (u != null) {
                        u.setRunsig('Y');
                    }
                    if (z != null) {
                        z.setRunsig('Y');
                    }
                }
                if ("".equals(hdn_jb9)) {
                    gu.setPrelation1('N');
                    gz.setPrelation1('N');
                } else {
                    gu.setPrelation1('Y');
                    gz.setPrelation1('Y');
                    if (u != null) {
                        u.setPrelation1('Y');
                    }
                    if (z != null) {
                        z.setPrelation1('Y');
                    }
                }
                if ("".equals(hdn_jb10)) {
                    gu.setPrelation2('N');
                    gz.setPrelation2('N');
                } else {
                    gu.setPrelation2('Y');
                    gz.setPrelation2('Y');
                    if (u != null) {
                        u.setPrelation2('Y');
                    }
                    if (z != null) {
                        z.setPrelation2('Y');
                    }
                }
                if ("".equals(hdn_jb11)) {
                    gu.setPrelation3('N');
                    gz.setPrelation3('N');
                } else {
                    gu.setPrelation3('Y');
                    gz.setPrelation3('Y');
                    if (u != null) {
                        u.setPrelation3('Y');
                    }
                    if (z != null) {
                        z.setPrelation3('Y');
                    }
                }
                if ("".equals(hdn_jb12)) {
                    gu.setPrelation4('N');
                    gz.setPrelation4('N');
                } else {
                    gu.setPrelation4('Y');
                    gz.setPrelation4('Y');
                    if (u != null) {
                        u.setPrelation4('Y');
                    }
                    if (z != null) {
                        z.setPrelation4('Y');
                    }
                }
                if ("".equals(hdn_jb13)) {
                    gu.setStepbystep('N');
                    gz.setStepbystep('N');
                } else {
                    gu.setStepbystep('Y');
                    gz.setStepbystep('Y');
                    if (u != null) {
                        u.setStepbystep('Y');
                    }
                    if (z != null) {
                        z.setStepbystep('Y');
                    }
                }
                if ("".equals(hdn_other1)) {
                    gu.setPother1('N');
                    gz.setPother1('N');
                } else {
                    gu.setPother1('Y');
                    gz.setPother1('Y');
                    if (u != null) {
                        u.setPother1('Y');
                    }
                    if (z != null) {
                        z.setPother1('Y');
                    }
                }
                if ("".equals(hdn_other2)) {
                    gu.setPother2('N');
                    gz.setPother2('N');
                } else {
                    gu.setPother2('Y');
                    gz.setPother2('Y');
                    if (u != null) {
                        u.setPother2('Y');
                    }
                    if (z != null) {
                        z.setPother2('Y');
                    }
                }
                if ("".equals(hdn_other3)) {
                    gu.setPother3('N');
                    gz.setPother3('N');
                } else {
                    gu.setPother3('Y');
                    gz.setPother3('Y');
                    if (u != null) {
                        u.setPother3('Y');
                    }
                    if (z != null) {
                        z.setPother3('Y');
                    }
                }
                if ("".equals(hdn_other4)) {
                    gu.setPother4('N');
                    gz.setPother4('N');
                } else {
                    gu.setPother4('Y');
                    gz.setPother4('Y');
                    if (u != null) {
                        u.setPother4('Y');
                    }
                    if (z != null) {
                        z.setPother4('Y');
                    }
                }
                if ("".equals(hdn_other5)) {
                    gu.setPother5('N');
                    gz.setPother5('N');
                } else {
                    gu.setPother5('Y');
                    gz.setPother5('Y');
                    if (u != null) {
                        u.setPother5('Y');
                    }
                    if (z != null) {
                        z.setPother5('Y');
                    }
                }
                if ("".equals(hdn_other6)) {
                    gu.setPother6('N');
                    gz.setPother6('N');
                } else {
                    gu.setPother6('Y');
                    gz.setPother6('Y');
                    if (u != null) {
                        u.setPother6('Y');
                    }
                    if (z != null) {
                        z.setPother6('Y');
                    }
                }
                if ("".equals(hdn_other7)) {
                    gu.setPother7('N');
                    gz.setPother7('N');
                } else {
                    gu.setPother7('Y');
                    gz.setPother7('Y');
                    if (u != null) {
                        u.setPother7('Y');
                    }
                    if (z != null) {
                        z.setPother7('Y');
                    }
                }
                if ("".equals(hdn_other8)) {
                    gu.setPother8('N');
                    gz.setPother8('N');
                } else {
                    gu.setPother8('Y');
                    gz.setPother8('Y');
                    if (u != null) {
                        u.setPother8('Y');
                    }
                    if (z != null) {
                        z.setPother8('Y');
                    }
                }
                if ("".equals(hdn_other9)) {
                    gu.setPother9('N');
                    gz.setPother9('N');
                } else {
                    gu.setPother9('Y');
                    gz.setPother9('Y');
                    if (u != null) {
                        u.setPother9('Y');
                    }
                    if (z != null) {
                        z.setPother9('Y');
                    }
                }

                if (erpuser == null) {
                    Users oauser = usersBean.findById(h.getApplyuser());
                    if (oauser != null) {
                        erpuser = new Secuser();
                        erpuser.setUserno(oauser.getId());
                        erpuser.setUsername(oauser.getUserName());
                        erpuser.setUtype('U');
                        erpuser.setUclass((short) 99);
                        erpuser.setEnabled('Y');
                        erpuser.setPwd("");
                        erpuser.setPfacno(h.getFacno());
                        erpuser.setPdepno(h.getDept());
                        erpuser.setPprono("1");
                        erpuser.setDuedate(BaseLib.getDate());
                        erpuser.setGtype(gtype);
                        erpuser.setStatuspass("0132");
                        // 预设空密码登录时修改
                        secuserBean.persist(erpuser);

                        // 加入miscode类别9E中
                        miscodeBean.setCompany(h.getFacno());
                        miscodeBean.persistIfNotExist("9E", erpuser.getUserno(), erpuser.getUsername(), 'N');
                        // 增加部门
                        misdeptBean.setCompany(h.getFacno());
                        Misdept dept = misdeptBean.findByDepno(h.getDept());
                        if (dept == null) {
                            OrganizationUnit ou = organizationUnitBean.findById(h.getDept());
                            dept = new Misdept(h.getFacno(), h.getDept());
                            dept.setDepname(ou.getOrganizationUnitName());
                            dept.setUplevel("/");
                            dept.setChildren(0);
                            misdeptBean.persist(dept);
                            // 加入miscode类别GE中
                            miscodeBean.persistIfNotExist("GE", dept.getMisdeptPK().getDepno(), dept.getDepname(), 'N');
                        }
                        // 人员加入部门
                        Secmemb m = new Secmemb(h.getFacno(), h.getDept(), h.getApplyuser());
                        m.setSupvisor('N');
                        m.setAuth('N');
                        secmembBean.setCompany(h.getFacno());
                        secmembBean.persist(m);
                    }
                } else {
                    secmembBean.setCompany(h.getFacno());
                    Secmemb m = secmembBean.findByPK(h.getFacno(), h.getDept(), h.getApplyuser());
                    if (m == null) {
                        // 增加部门
                        miscodeBean.setCompany(h.getFacno());
                        misdeptBean.setCompany(h.getFacno());
                        Misdept dept = misdeptBean.findByDepno(h.getDept());
                        if (dept == null) {
                            OrganizationUnit ou = organizationUnitBean.findById(h.getDept());
                            dept = new Misdept(h.getFacno(), h.getDept());
                            dept.setDepname(ou.getOrganizationUnitName());
                            dept.setUplevel("/");
                            dept.setChildren(0);
                            misdeptBean.persist(dept);
                            // 加入miscode类别GE中
                            miscodeBean.persistIfNotExist("GE", dept.getMisdeptPK().getDepno(), dept.getDepname(), 'N');
                        }
                        // 人员加入部门
                        m = new Secmemb(h.getFacno(), h.getDept(), h.getApplyuser());
                        m.setSupvisor('N');
                        m.setAuth('N');
                        secmembBean.persist(m);
                    }
                }

                secgsysBean.setCompany(h.getFacno());
                Secgsys gs = secgsysBean.findByPK(sysno, groupno, "U");
                if (gs == null) {
                    Secgsys secgsys = new Secgsys(sysno, groupno, "U");
                    secgsysBean.persist(secgsys);
                }
                secusysBean.setCompany(h.getFacno());
                Secusys us = secusysBean.findByPK(sysno, groupno);
                if (us == null) {
                    Secusys secusys = new Secusys(sysno, groupno);
                    secusysBean.persist(secusys);
                }

                if (u == null) {
                    persist(gu);
                } else {
                    update(u);
                }
                if (z == null) {
                    persist(gz);
                } else {
                    update(z);
                }

            }
            // 生成仓管员
            if (invwhclkList != null && !invwhclkList.isEmpty()) {
                invwhclkBean.setCompany(h.getFacno());
                char YN;
                for (SHBERPMIS226InvwhclkDetail oawhclk : invwhclkList) {
                    List<Invwhclk> erpwhList = invwhclkBean.findByWareh(oawhclk.getWarehouse1());
                    if (erpwhList == null || erpwhList.isEmpty()) {
                        YN = 'Y';
                    } else {
                        YN = 'N';
                    }
                    if (!invwhclkBean.isExist(h.getFacno(), "1", oawhclk.getWarehouse1(), oawhclk.getWclerkTxt())) {
                        Invwhclk erpwhclk = new Invwhclk(h.getFacno(), "1", oawhclk.getWarehouse1(), oawhclk.getWclerkTxt());
                        erpwhclk.setMainyn(YN);
                        erpwhclk.setIndate(BaseLib.getDate());
                        erpwhclk.setUserno("mis");
                        invwhclkBean.persist(erpwhclk);
                    }
                }
            }
            secuprgBean.setCompany(h.getFacno());
            return secuprgBean.initSECUPRG(psn);
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "SecgprgBean.initSECGPRG", psn), ex);
            return false;
        }

    }

    public Secgprg findByPK(String prgno, String sysno, String groupno, String gtype) {
        Query query = getEntityManager().createNamedQuery("Secgprg.findByPK");
        query.setParameter("prgno", prgno);
        query.setParameter("sysno", sysno);
        query.setParameter("groupno", groupno);
        query.setParameter("gtype", gtype);
        try {
            Object o = query.getSingleResult();
            return (Secgprg) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Secgprg> findByGroupno(String value) {
        Query query = getEntityManager().createNamedQuery("Secgprg.findByGroupno");
        query.setParameter("groupno", value);
        return query.getResultList();
    }

    public List<Secgprg> findByGroupnoAndGtype(String value, String t) {
        Query query = getEntityManager().createNamedQuery("Secgprg.findByGroupnoAndGtype");
        query.setParameter("groupno", value);
        query.setParameter("gtype", t);
        return query.getResultList();
    }

    public List<Secgprg> findByGroupnoGtypeAndSysno(String groupno, String gtype, String sysno) {
        Query query = getEntityManager().createNamedQuery("Secgprg.findByGroupnoGtypeAndSysno");
        query.setParameter("groupno", groupno);
        query.setParameter("gtype", gtype);
        query.setParameter("sysno", sysno);
        return query.getResultList();
    }

}
