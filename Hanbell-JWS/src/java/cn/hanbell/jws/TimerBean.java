/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package cn.hanbell.jws;

import cn.hanbell.crm.ejb.CMSMEBean;
import cn.hanbell.crm.ejb.CMSMVBean;
import cn.hanbell.crm.ejb.DDGABean;
import cn.hanbell.crm.ejb.DDGCBean;
import cn.hanbell.crm.ejb.REPPABean;
import cn.hanbell.crm.ejb.SyncCRMBean;
import cn.hanbell.crm.entity.CMSME;
import cn.hanbell.crm.entity.CMSMV;
import cn.hanbell.crm.entity.DDGA;
import cn.hanbell.crm.entity.DDGB;
import cn.hanbell.crm.entity.DDGC;
import cn.hanbell.crm.entity.DDGD;
import cn.hanbell.crm.entity.REPPA;
import cn.hanbell.crm.entity.REPPB;
import cn.hanbell.crmsys.ejb.DSCMABean;
import cn.hanbell.crmsys.entity.DSCMA;
import cn.hanbell.eam.ejb.AssetAcceptanceBean;
import cn.hanbell.eam.ejb.AssetDistributeBean;
import cn.hanbell.eam.ejb.AssetItemBean;
import cn.hanbell.eam.ejb.WarehouseBean;
import cn.hanbell.eam.entity.AssetAcceptance;
import cn.hanbell.eam.entity.AssetAcceptanceDetail;
import cn.hanbell.eam.entity.AssetDistribute;
import cn.hanbell.eam.entity.AssetDistributeDetail;
import cn.hanbell.eam.entity.AssetItem;
import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.ApmaphBean;
import cn.hanbell.erp.ejb.ApmtbilBean;
import cn.hanbell.erp.ejb.BomasryBean;
import cn.hanbell.erp.ejb.BomsubBean;
import cn.hanbell.erp.ejb.CdrcitnbrBean;
import cn.hanbell.erp.ejb.CdrcusBean;
import cn.hanbell.erp.ejb.CdrcusmanBean;
import cn.hanbell.erp.ejb.CdrcusrelBean;
import cn.hanbell.erp.ejb.CdrdmasBean;
import cn.hanbell.erp.ejb.CdrhmasBean;
import cn.hanbell.erp.ejb.CdrhpopsfkBean;
import cn.hanbell.erp.ejb.CdrpaydscBean;
import cn.hanbell.erp.ejb.CdrqasryBean;
import cn.hanbell.erp.ejb.CdrqbomsubBean;
import cn.hanbell.erp.ejb.CdrqhadBean;
import cn.hanbell.erp.ejb.CdrqhdscBean;
import cn.hanbell.erp.ejb.CdrqsysBean;
import cn.hanbell.erp.ejb.CdrsfkpartBean;
import cn.hanbell.erp.ejb.CdrsfksortsBean;
import cn.hanbell.erp.ejb.CdrsfkspecBean;
import cn.hanbell.erp.ejb.CdrsysBean;
import cn.hanbell.erp.ejb.InvbalBean;
import cn.hanbell.erp.ejb.InvwhsafeBean;
import cn.hanbell.erp.ejb.InvhadBean;
import cn.hanbell.erp.ejb.InvmasBean;
import cn.hanbell.erp.ejb.MiscodeBean;
import cn.hanbell.erp.ejb.MisdeptBean;
import cn.hanbell.erp.ejb.PurachBean;
import cn.hanbell.erp.ejb.PurhadBean;
import cn.hanbell.erp.ejb.PurhaskBean;
import cn.hanbell.erp.ejb.PurvdrBean;
import cn.hanbell.erp.ejb.PurvdrrelBean;
import cn.hanbell.erp.ejb.SecmembBean;
import cn.hanbell.erp.ejb.SecuserBean;
import cn.hanbell.erp.ejb.InvclsBean;
import cn.hanbell.erp.ejb.MisrateBean;
import cn.hanbell.erp.ejb.PurdlvschBean;
import cn.hanbell.erp.ejb.PurdtaBean;
import cn.hanbell.erp.ejb.PursysBean;
import cn.hanbell.erp.ejb.PurvdrBuyerBean;
import cn.hanbell.erp.entity.Apmapd;
import cn.hanbell.erp.entity.Apmaph;
import cn.hanbell.erp.entity.Apmtbil;
import cn.hanbell.erp.entity.Bomsub;
import cn.hanbell.erp.entity.Cdrcitnbr;
import cn.hanbell.erp.entity.Cdrcus;
import cn.hanbell.erp.entity.Cdrcusman;
import cn.hanbell.erp.entity.Cdrcusrel;
import cn.hanbell.erp.entity.Cdrdmas;
import cn.hanbell.erp.entity.Cdrdpopsfk;
import cn.hanbell.erp.entity.CdrdpopsfkPK;
import cn.hanbell.erp.entity.Cdrhmas;
import cn.hanbell.erp.entity.Cdrhpopsfk;
import cn.hanbell.erp.entity.CdrhpopsfkPK;
import cn.hanbell.erp.entity.Cdrpaydsc;
import cn.hanbell.erp.entity.Cdrqasry;
import cn.hanbell.erp.entity.CdrqasryPK;
import cn.hanbell.erp.entity.Cdrqbomsub;
import cn.hanbell.erp.entity.CdrqbomsubPK;
import cn.hanbell.erp.entity.Cdrqdta;
import cn.hanbell.erp.entity.CdrqdtaPK;
import cn.hanbell.erp.entity.Cdrqhad;
import cn.hanbell.erp.entity.CdrqhadPK;
import cn.hanbell.erp.entity.Cdrqhdsc;
import cn.hanbell.erp.entity.CdrqhdscPK;
import cn.hanbell.erp.entity.Cdrsfkpart;
import cn.hanbell.erp.entity.Cdrsfksorts;
import cn.hanbell.erp.entity.Cdrsfkspec;
import cn.hanbell.erp.entity.Invbal;
import cn.hanbell.erp.entity.Invdta;
import cn.hanbell.erp.entity.Invhad;
import cn.hanbell.erp.entity.Invmas;
import cn.hanbell.erp.entity.Invwhsafe;
import cn.hanbell.erp.entity.InvwhsafePK;
import cn.hanbell.erp.entity.Miscode;
import cn.hanbell.erp.entity.Misdept;
import cn.hanbell.erp.entity.Misrate;
import cn.hanbell.erp.entity.Puracd;
import cn.hanbell.erp.entity.Purach;
import cn.hanbell.erp.entity.Purdlvsch;
import cn.hanbell.erp.entity.PurdlvschPK;
import cn.hanbell.erp.entity.Purdta;
import cn.hanbell.erp.entity.PurdtaPK;
import cn.hanbell.erp.entity.Purhad;
import cn.hanbell.erp.entity.PurhadPK;
import cn.hanbell.erp.entity.Purhask;
import cn.hanbell.erp.entity.Purvdr;
import cn.hanbell.erp.entity.PurvdrBuyer;
import cn.hanbell.erp.entity.Purvdrrel;
import cn.hanbell.erp.entity.Secmemb;
import cn.hanbell.erp.entity.Secuser;
import cn.hanbell.exch.ejb.ExchangeSHBBean;
import cn.hanbell.oa.ejb.HKCW002Bean;
import cn.hanbell.oa.ejb.WorkFlowBean;
import cn.hanbell.oa.entity.HKCW002;
import cn.hanbell.oa.entity.HKCW002Detail;
import cn.hanbell.oa.model.HKYX009DetailModel;
import cn.hanbell.oa.model.HKYX009Model;
import cn.hanbell.oa.model.HZJS034DetailModel;
import cn.hanbell.oa.model.HZJS034Model;
import cn.hanbell.oa.model.SHBERPAPM811DetailModel;
import cn.hanbell.oa.model.SHBERPAPM811Model;
import cn.hanbell.oa.model.SHBERPINV325DetailModel;
import cn.hanbell.oa.model.SHBERPINV325Model;
import cn.hanbell.plm.ejb.PLMItnbrMasterTempBean;
import cn.hanbell.plm.entity.PLMItnbrDetailTemp;
import cn.hanbell.plm.entity.PLMItnbrMasterTemp;
import com.lightshell.comm.BaseLib;
import com.lightshell.comm.SuperEJB;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TimerService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * TimerBean is a singleton session bean that creates a timer and prints out a
 * message when a programmaticTimeout occurs.
 */
@Singleton
@Startup
public class TimerBean {

    private final Logger log4j = LogManager.getLogger("cn.hanbell.eap");

    // EJBForCRM
    @EJB
    private DSCMABean dscmaBean;
    @EJB
    private CMSMEBean cmsmeBean;
    @EJB
    private CMSMVBean cmsmvBean;
    @EJB
    private REPPABean reppaBean;
    @EJB
    private DDGABean ddgaBean;
    @EJB
    private DDGCBean ddgcBean;
    @EJB
    private SyncCRMBean syncCRMBean;

    // EJBForEAM
    @EJB
    private AssetAcceptanceBean assetAcceptanceBean;
    @EJB
    private AssetItemBean assetItemBean;
    @EJB
    private AssetDistributeBean assetDistributeBean;
    @EJB
    private WarehouseBean warehouseBean;

    // EJBForEAP
    @EJB
    private cn.hanbell.eap.ejb.DepartmentBean eapDepartmentBean;
    @EJB
    private cn.hanbell.eap.ejb.MailNotificationBean eapMailBean;
    @EJB
    private cn.hanbell.eap.ejb.SystemUserBean eapSystemUserBean;

    // EJBForEFGP
    @EJB
    private HKCW002Bean hkcw002Bean;
    @EJB
    private WorkFlowBean workFlowBean;

    // EJBForERP
    @EJB
    private ApmaphBean apmaphBean;
    @EJB
    private ApmtbilBean apmtbilBean;
    @EJB
    private BomasryBean bomasryBean;
    @EJB
    private BomsubBean bomsubBean;
    @EJB
    private CdrcitnbrBean cdrcitnbrBean;
    @EJB
    private CdrcusBean cdrcusBean;
    @EJB
    private CdrcusmanBean cdrcusmanBean;
    @EJB
    private CdrcusrelBean cdrcusrelBean;
    @EJB
    private CdrpaydscBean cdrpaydscBean;
    @EJB
    private CdrqbomsubBean cdrqbomsubBean;
    @EJB
    private CdrqhadBean cdrqhadBean;
    @EJB
    private CdrqhdscBean cdrqhdscBean;
    @EJB
    private CdrqsysBean cdrqsysBean;
    @EJB
    private CdrsysBean cdrsysBean;
    @EJB
    private CdrhpopsfkBean cdrhpopsfkBean;
    @EJB
    private CdrsfkpartBean cdrsfkpartBean;
    @EJB
    private CdrsfksortsBean cdrsfksortsBean;
    @EJB
    private CdrsfkspecBean cdrsfkspecBean;
    @EJB
    private CdrqasryBean cdrqasryBean;
    @EJB
    private CdrdmasBean cdrdmasBean;
    @EJB
    private CdrhmasBean cdrhmasBean;
    @EJB
    private InvbalBean invbalBean;
    @EJB
    private InvclsBean invclsBean;
    @EJB
    private InvhadBean invhadBean;
    @EJB
    private InvmasBean invmasBean;
    @EJB
    private InvwhsafeBean invwhsafeBean;
    @EJB
    private MiscodeBean miscodeBean;
    @EJB
    private MisdeptBean misdeptBean;
    @EJB
    private MisrateBean misrateBean;
    @EJB
    private PurachBean purachBean;
    @EJB
    private PurdlvschBean purdlvschBean;
    @EJB
    private PurdtaBean purdtaBean;
    @EJB
    private PurhadBean purhadBean;
    @EJB
    private PurhaskBean purhaskBean;
    @EJB
    private PurvdrBean purvdrBean;
    @EJB
    private PurvdrBuyerBean purvdrBuyerBean;
    @EJB
    private PurvdrrelBean purvdrrelBean;
    @EJB
    private PursysBean pursysBean;
    @EJB
    private SecuserBean secuserBean;
    @EJB
    private SecmembBean secmembBean;

    @EJB
    private ExchangeSHBBean exchangeSHBBean;
    @EJB
    private tw.hanbell.exch.ejb.PurhadBean exchPurhadBean;

    // EJBForHRM
    @EJB
    private cn.hanbell.hrm.ejb.DepartmentBean hrmDepartmentBean;
    @EJB
    private cn.hanbell.hrm.ejb.EmployeeBean hrmEmployeeBean;

    // EJBForMES
    @EJB
    private cn.hanbell.mes.ejb.MDepartmentBean mesDepartmentBean;
    @EJB
    private cn.hanbell.mes.ejb.MUserBean mesUserBean;

    // EJBForPLM
    @EJB
    private PLMItnbrMasterTempBean plmItnbrMasterTempBean;

    @Resource
    TimerService timerService;

    public TimerBean() {

    }

    @Schedule(minute = "23", hour = "7,23", persistent = false)
    public void syncOrganizationByHRM() {
        try {
            // 同步部门
            log4j.info("syncOrganizationByHRM开始");
            List<cn.hanbell.hrm.entity.Department> departmentList = hrmDepartmentBean.findAll();
            if (departmentList != null && !departmentList.isEmpty()) {
                departmentList.forEach((hd) -> {
                    // EAP
                    cn.hanbell.eap.entity.Department ep = null;
                    cn.hanbell.hrm.entity.Department hp = hrmDepartmentBean.findByDepartmentId(hd.getParentId());
                    if (hp != null) {
                        ep = eapDepartmentBean.findByDeptno(hp.getCode());
                    }
                    cn.hanbell.eap.entity.Department ed = eapDepartmentBean.findByDeptno(hd.getCode());
                    if (ed == null) {
                        ed = new cn.hanbell.eap.entity.Department();
                        ed.setCompany(workFlowBean.getCompanyByDeptId(hd.getCode()));
                        ed.setDeptno(hd.getCode());
                        ed.setDept(hd.getName());
                        if (ep != null) {
                            ed.setParentDept(ep);
                        }
                        if (hd.getFlag()) {
                            ed.setStatus("N");
                        } else {
                            ed.setStatus("X");
                        }
                        ed.setCreatorToSystem();
                        ed.setCredateToNow();
                        eapDepartmentBean.persist(ed);
                    } else {
                        if (!ed.getDept().equals(hd.getName()) || !Objects.equals(ed.getParentDept(), ep) || (ed.getOptdate() != null && ed.getOptdate().before(hd.getLastModifiedDate()))) {
                            ed.setDept(hd.getName());
                            if (ep != null) {
                                ed.setParentDept(ep);
                            }
                            if (!hd.getFlag()) {
                                ed.setStatus("X");
                            } else {
                                ed.setStatus("N");
                            }
                            ed.setOptuserToSystem();
                            ed.setOptdate(hd.getLastModifiedDate());
                            eapDepartmentBean.update(ed);
                        }
                    }
                    String d = hd.getCode().substring(0, 1);
                    // CRM
                    if (d.equals("1") || d.equals("5")) {
                        CMSME cd = cmsmeBean.findById(hd.getCode());
                        if (cd == null) {
                            cd = new CMSME();
                            cd.setMe001(hd.getCode());
                            cd.setMe002(hd.getName());
                            cd.setFlag((short) 1);
                            cd.setCreator("CRMDS");
                            cd.setUsrGroup("0000");
                            cd.setCreateDate(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
                            cmsmeBean.persist(cd);
                        } else {
                            if (!cd.getMe002().equals(hd.getName())) {
                                cd.setMe002(hd.getName());
                                cd.setModifier("CRMDS");
                                cd.setModiDate(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
                                cmsmeBean.update(cd);
                            }
                        }
                    }
                    // MES
                    if (d.equals("1")) {
                        cn.hanbell.mes.entity.MDepartment md = mesDepartmentBean.findByDepartmentid(hd.getCode());
                        if (md == null) {
                            md = new cn.hanbell.mes.entity.MDepartment();
                            md.setSysid(BaseLib.formatDate("yyyyMMddHHmmss", BaseLib.getDate()));
                            md.setDepartmentid(hd.getCode());
                            md.setDepartmentname(hd.getName());
                            if (hp != null) {
                                md.setPdepartmentid(hp.getCode());
                            }
                            md.setSequences(hd.getCode());
                            md.setModifyuser("HRM");
                            md.setModifytime(BaseLib.formatDate("yyyy/MM/dd HH:mm:ss", hd.getLastModifiedDate()));
                            mesDepartmentBean.persist(md);
                        } else {
                            boolean flag = false;
                            if (!md.getDepartmentname().equals(hd.getName())) {
                                md.setDepartmentname(hd.getName());
                                flag = true;
                            }
                            if (hp != null && !hp.getCode().equals(md.getPdepartmentid())) {
                                md.setPdepartmentid(hp.getCode());
                                flag = true;
                            }
                            if (flag) {
                                md.setModifyuser("HRM");
                                md.setModifytime(BaseLib.formatDate("yyyy/MM/dd HH:mm:ss", hd.getLastModifiedDate()));
                                mesDepartmentBean.update(md);
                            }
                        }
                    }
                });
            }
            log4j.info("syncOrganizationByHRM,同步EAP/CRM/MES部门资料结束");
            // 同步人员
            List<cn.hanbell.hrm.entity.Employee> employeeList = hrmEmployeeBean.findByLastModifiedDate(BaseLib.getDate("yyyy-MM-dd", BaseLib.formatDate("yyyy-MM-dd", BaseLib.getDate())));

            if (employeeList != null && !employeeList.isEmpty()) {
                employeeList.forEach((e) -> {
                    boolean flag = false;
                    cn.hanbell.hrm.entity.Employee manager = hrmEmployeeBean.findByEmployeeId(e.getDirectorId());
                    String company = e.getCode().substring(0, 1);
                    if ("C".equals(company) || "K".equals(company) || "E".equals(company) || "H".equals(company) || "Y".equals(company) || "Q".equals(company)) {
                        // EAP
                        cn.hanbell.eap.entity.SystemUser eu = eapSystemUserBean.findByUserId(e.getCode());
                        if (eu == null) {
                            eu = new cn.hanbell.eap.entity.SystemUser();
                            eu.setUserid(e.getCode());
                            eu.setUsername(e.getCnName());
                            eu.setJobCode(e.getJob().getCode());
                            eu.setJob(e.getJob().getName());
                            eu.setPositionCode(e.getPosition().getCode());
                            eu.setPosition(e.getPosition().getName());
                            eu.setLevelId(e.getLevelId());
                            eu.setDecisionLevel(e.getDecisionlevelInfo().getInfoCode());
                            eu.setDeptno(e.getDepartment().getCode());
                            if (manager != null) {
                                eu.setManagerId(manager.getCode());
                            }
                            eu.setPhone(e.getMobilePhone());
                            eu.setEmail(e.getEmail());
                            eu.setCreatorToSystem();
                            eu.setCredateToNow();
                            eu.setOptdate(eu.getCredate());
                            eapSystemUserBean.persist(eu);
                        } else {
                            if (eu.getOptdate() != null && eu.getOptdate().before(e.getLastModifiedDate())) {
                                eu.setUsername(e.getCnName());
                                eu.setJobCode(e.getJob().getCode());
                                eu.setJob(e.getJob().getName());
                                eu.setPositionCode(e.getPosition().getCode());
                                eu.setPosition(e.getPosition().getName());
                                eu.setLevelId(e.getLevelId());
                                eu.setDecisionLevel(e.getDecisionlevelInfo().getInfoCode());
                                eu.setDeptno(e.getDepartment().getCode());
                                if (manager != null) {
                                    eu.setManagerId(manager.getCode());
                                }
                                eu.setPhone(e.getMobilePhone());
                                eu.setEmail(e.getEmail());
                                eu.setOptuserToSystem();
                                eu.setOptdate(e.getLastModifiedDate());
                                flag = true;
                            }
                            if (!eu.getStatus().equals("X") && e.getLastModifiedDate().compareTo(e.getLastWorkDate()) != -1) {
                                eu.setStatus("X");
                                eu.setOptuserToSystem();
                                eu.setOptdate(e.getLastModifiedDate());
                                flag = true;
                            }
                            if (flag) {
                                eapSystemUserBean.update(eu);
                            }
                        }
                        // ERP
                        miscodeBean.setCompany(company);
                        misdeptBean.setCompany(company);
                        secmembBean.setCompany(company);
                        secuserBean.setCompany(company);
                        Secuser erpuser = secuserBean.findByUserno(e.getCode());
                        Misdept erpdept = misdeptBean.findByDepno(e.getDepartment().getCode());
                        if (erpdept == null) {
                            // 增加部门
                            erpdept = new Misdept(company, e.getDepartment().getCode());
                            erpdept.setDepname(e.getDepartment().getName());
                            erpdept.setUplevel("/");
                            erpdept.setChildren(0);
                            misdeptBean.persist(erpdept);
                            // 加入miscode类别GE中
                            miscodeBean.persistIfNotExist("GE", erpdept.getMisdeptPK().getDepno(), erpdept.getDepname(), 'N');
                        }
                        if (erpuser != null) {
                            Secmemb secmemb = secmembBean.findByPK(company, e.getDepartment().getCode(), e.getCode());
                            if (secmemb == null) {
                                // 人员加入部门
                                secmemb = new Secmemb(company, e.getDepartment().getCode(), e.getCode());
                                secmemb.setSupvisor('N');
                                secmemb.setAuth('N');
                                secmembBean.persist(secmemb);
                            }
                            erpuser.setPdepno(e.getDepartment().getCode());
                            secuserBean.update(erpuser);
                        }
                    }
                    if ("C".equals(company) || "K".equals(company)) {
                        // CRM
                        DSCMA cu = dscmaBean.findById(e.getCode());
                        CMSMV cuDept = cmsmvBean.findById(e.getCode());
                        if (cu == null) {
                            cu = new DSCMA();
                            cu.setMa001(e.getCode());
                            cu.setMa002(e.getCnName());
                            cu.setFlag((short) 1);
                            cu.setCreator("CRMDS");
                            cu.setUsrGroup("0000");
                            cu.setCreateDate(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
                            dscmaBean.persist(cu);
                        }
                        if (cuDept == null) {
                            cuDept = new CMSMV();
                            cuDept.setMv001(e.getCode());
                            cuDept.setMv002(e.getCnName());
                            cuDept.setMv004(e.getDepartment().getCode());
                            cuDept.setFlag((short) 1);
                            cuDept.setCreator("CRMDS");
                            cuDept.setUsrGroup("0000");
                            cuDept.setCreateDate(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
                            cmsmvBean.persist(cuDept);
                        } else {
                            if (!cuDept.getMv004().equals(e.getDepartment().getCode())) {
                                cuDept.setMv004(e.getDepartment().getCode());
                                cuDept.setModifier("CRMDS");
                                cuDept.setModiDate(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
                                cmsmvBean.update(cuDept);
                            }
                        }
                    }
                    if ("C".equals(company)) {
                        // MES
                        cn.hanbell.mes.entity.MUser mu = mesUserBean.findByUserid(e.getCode());
                        if (mu == null) {
                            mu = new cn.hanbell.mes.entity.MUser();
                            mu.setUserid(e.getCode());
                            mu.setUsername(e.getCnName());
                            mu.setPassword("");
                            mu.setStatus("Y");
                            mu.setDepartmentid(e.getDepartment().getCode());
                            mu.setEmail(e.getEmail());
                            mu.setModifyuser("HRM");
                            mu.setModifytime(BaseLib.formatDate("yyyy/MM/dd HH:mm:ss", e.getLastModifiedDate()));
                            mesUserBean.persist(mu);
                        } else {
                            flag = false;
                            if (!mu.getDepartmentid().equals(e.getDepartment().getCode())) {
                                mu.setDepartmentid(e.getDepartment().getCode());
                                mu.setEmail(e.getEmail());
                                mu.setModifyuser("HRM");
                                mu.setModifytime(BaseLib.formatDate("yyyy/MM/dd HH:mm:ss", e.getLastModifiedDate()));
                                flag = true;
                            }
                            if (e.getLastModifiedDate().compareTo(e.getLastWorkDate()) != -1) {
                                mu.setStatus("N");
                                mu.setModifyuser("HRM");
                                mu.setModifytime(BaseLib.formatDate("yyyy/MM/dd HH:mm:ss", e.getLastModifiedDate()));
                                flag = true;
                            }
                            if (flag) {
                                mesUserBean.update(mu);
                            }
                        }
                    }
                });
                log4j.info("syncOrganizationByHRM,同步EAP/ERP/CRM/MES员工资料结束");
            }
            log4j.info("syncOrganizationByHRM结束");
        } catch (Exception ex) {
            log4j.error("syncOrganizationByHRM出现异常", ex);
        }
    }

    @Schedule(minute = "*/30", hour = "8-20", persistent = false)
    public void createEAMAssetAcceptanceByERPPUR530() {
        // 将ERP资产验收同步到EAM资产入库
        List<HKCW002Detail> hkcw002Details;
        List<HKCW002> hkcw002List = hkcw002Bean.findNotAcceptance();
        if (hkcw002List != null && !hkcw002List.isEmpty()) {
            String[] acceptno;
            boolean flag;
            // 用于更新资产明细
            List<HKCW002Detail> editedHKCW002Detail = new ArrayList<>();
            HashMap<SuperEJB, List<?>> hkcw002DetailEdited = new HashMap<>();
            hkcw002DetailEdited.put(hkcw002Bean, editedHKCW002Detail);

            for (HKCW002 e : hkcw002List) {
                purhaskBean.setCompany(e.getFacno());
                purachBean.setCompany(e.getFacno());
                // HKCG007抛转PUR210时截取了流程序号,省略了PKG_
                Purhask prh = purhaskBean.findBySrcno(e.getHkcg007().substring(4));
                if (prh != null) {

                    try {
                        flag = true;
                        int i;
                        BigDecimal qty;
                        // EAM相关对象
                        AssetItem ai;
                        List<AssetAcceptanceDetail> addedDetail = new ArrayList();
                        // ERP相关对象
                        Purach purach;
                        List<Puracd> puracdList;
                        // EFGP相关对象
                        hkcw002Bean.setDetail(e.getFormSerialNumber());
                        hkcw002Details = hkcw002Bean.getDetailList();

                        if (hkcw002Details != null && !hkcw002Details.isEmpty()) {
                            for (HKCW002Detail d : hkcw002Details) {
                                if (d.getPurqty() == null || "".equals(d.getPurqty())) {
                                    continue;
                                }
                                if (d.getRelqty() != null && !"".equals(d.getRelqty())) {
                                    qty = BigDecimal.valueOf(Double.parseDouble(d.getRelqty()));
                                    if (qty.compareTo(BigDecimal.valueOf(Double.parseDouble(d.getPurqty()))) >= 0) {
                                        continue;
                                    }
                                }
                                // 得到验收单号数组
                                acceptno = purachBean.findByPrnoAndItnbr(prh.getPurhaskPK().getPrno(), d.getItemno());
                                if (acceptno != null) {
                                    qty = BigDecimal.ZERO;
                                    for (String n : acceptno) {
                                        purach = purachBean.findByAcceptno(n);
                                        puracdList = purachBean.findByAcceptnoAndItnbr(n, d.getItemno());
                                        // 删除与此笔申请明细无关的同品号验收明细，解决同品号不同采购单合并验收问题
                                        if (puracdList != null && !puracdList.isEmpty() && puracdList.size() > 1) {
                                            for (int x = 0; x < puracdList.size(); x++) {
                                                Puracd acd = puracdList.get(x);
                                                if (!purachBean.isRelationAcceptance(prh.getPurhaskPK().getPrno(), acd.getPono(),
                                                        acd.getPonotrseq())) {
                                                    puracdList.remove(acd);
                                                    x--;
                                                }
                                            }
                                        }
                                        if (puracdList != null && !puracdList.isEmpty()) {
                                            // ERP每一笔验收产生一笔EAM资产入库
                                            i = 0;
                                            addedDetail.clear();// 清空之前列表
                                            // 计算累计验收数量
                                            for (Puracd acd : puracdList) {
                                                if (acd.getOkqy1().compareTo(BigDecimal.valueOf(Double.parseDouble(d.getPurqty()))) >= 0) {
                                                    // 多笔请购合并采购验收，验收数量大于申请数量，按申请数量入库
                                                    qty = qty.add(BigDecimal.valueOf(Double.parseDouble(d.getPurqty())));
                                                } else {
                                                    qty = qty.add(acd.getOkqy1());
                                                }
                                            }
                                            for (Puracd acd : puracdList) {
                                                ai = assetItemBean.findByItemno(acd.getItnbr());
                                                if (ai == null) {
                                                    log4j.error("执行createEAMAssetAcceptanceByERPPUR530时异常,找不到件号" + acd.getItnbr() + ",流程序号" + e.getProcessSerialNumber());
                                                    continue;
                                                }
                                                // 判断验收记录，处理多次验收逻辑
                                                if (d.getRelno() == null) {
                                                    d.setRelno("");
                                                }
                                                if (d.getRelno().compareTo(n) < 0) {
                                                    // 新的验收记录，产生EAM入库
                                                    i++;
                                                    AssetAcceptanceDetail aad = new AssetAcceptanceDetail();
                                                    // aad.setPid("");
                                                    aad.setSeq(i);
                                                    aad.setAcceptdate(acd.getAcceptdate());
                                                    aad.setAcceptDeptno(acd.getDepno());
                                                    aad.setAcceptUserno(acd.getUserno());
                                                    aad.setAssetItem(ai);
                                                    // aad.setQty(acd.getAccqy1());
                                                    if (acd.getAccqy1().compareTo(BigDecimal.valueOf(Double.parseDouble(d.getPurqty()))) >= 0) {
                                                        // 多笔请购合并采购验收，验收数量大于申请数量，按申请数量入库
                                                        aad.setQty(BigDecimal.valueOf(Double.parseDouble(d.getPurqty())));
                                                    } else {
                                                        aad.setQty(acd.getAccqy1());
                                                    }
                                                    aad.setUnit(ai.getUnit());
                                                    aad.setQcpass(false);
                                                    // aad.setQcqty(acd.getOkqy1());
                                                    if (acd.getOkqy1().compareTo(BigDecimal.valueOf(Double.parseDouble(d.getPurqty()))) >= 0) {
                                                        // 多笔请购合并采购验收，验收数量大于申请数量，按申请数量入库
                                                        aad.setQcqty(BigDecimal.valueOf(Double.parseDouble(d.getPurqty())));
                                                    } else {
                                                        aad.setQcqty(acd.getOkqy1());
                                                    }
                                                    aad.setAddqty(BigDecimal.ZERO);
                                                    aad.setWarehouse(ai.getCategory().getWarehouse());
                                                    aad.setCurrency(acd.getCoin());
                                                    aad.setExchange(acd.getRatio());
                                                    aad.setTaxrate(acd.getTaxrate());
                                                    aad.setPrice(acd.getUnpris());
                                                    aad.setAmts(acd.getTramts());
                                                    aad.setExtax(acd.getTotamts().subtract(acd.getTaxamts()));
                                                    aad.setTaxes(acd.getTaxamts());
                                                    aad.setSrcapi("ERP");
                                                    aad.setSrcformid(n);
                                                    aad.setSrcseq(Integer.valueOf(acd.getPuracdPK().getTrseq()));
                                                    aad.setStatus("40");

                                                    addedDetail.add(aad);

                                                    // 更新资产申请明细关联单号
                                                    d.setRelno(n);
                                                    d.setRelseq(String.valueOf(acd.getPuracdPK().getTrseq()));
                                                    d.setRelqty(String.valueOf(qty));

                                                    editedHKCW002Detail.add(d);
                                                }
                                            }
                                            if (addedDetail.size() > 0) {
                                                AssetAcceptance aa = new AssetAcceptance();
                                                aa.setCompany(purach.getPurachPK().getFacno());
                                                aa.setFormid("");
                                                aa.setFormdate(purach.getAcceptdate());
                                                aa.setVendorno(purach.getVdrno());
                                                aa.setDeptno(purach.getDepno());
                                                aa.setRemark(e.getProcessSerialNumber() + "_" + purach.getPurachPK().getAcceptno());
                                                aa.setStatus("N");
                                                // 产生EAM资产入库
                                                assetAcceptanceBean.initAssetAcceptance(aa, addedDetail);
                                            }
                                        }
                                    }
                                }
                            }
                            if (editedHKCW002Detail.size() > 0) {
                                // 判断整张资产申请是否全部验收
                                for (HKCW002Detail d : hkcw002Details) {
                                    if (d.getPurqty() == null || "".equals(d.getPurqty())) {
                                        continue;
                                    }
                                    if (d.getRelqty() != null && !"".equals(d.getRelqty())) {
                                        qty = BigDecimal.valueOf(Double.parseDouble(d.getRelqty()));
                                        if (qty.compareTo(BigDecimal.valueOf(Double.parseDouble(d.getPurqty()))) < 0) {
                                            flag = false;
                                        }
                                    } else {
                                        flag = false;
                                    }
                                }
                                if (flag) {
                                    // 全部验收完成
                                    acceptno = purachBean.findByPrno(prh.getPurhaskPK().getPrno());
                                    e.setRelformid(Arrays.toString(acceptno));
                                }
                                hkcw002Bean.update(e, null, hkcw002DetailEdited, null);
                            }
                        }
                    } catch (NumberFormatException ex) {
                        log4j.error("执行createEAMAssetAcceptanceByERPPUR530时异常", ex);
                    }

                }
            }
        }
        log4j.info("createEAMAssetAcceptanceByERPPUR530轮询");
    }

    @Schedule(minute = "*/10", hour = "8-20", persistent = false)
    public void createERPINV310ByEAMAssetDistribute() {
        // 将EAM资产领用同步到ERP INV310手工领料
        List<AssetDistribute> adList = assetDistributeBean.findNeedThrow();// 已确认的领用

        if (adList != null && !adList.isEmpty()) {
            short trseq;
            String trtype = "IAB";
            String facno;
            String prono = "1";
            String trno;
            String wareh;
            Date trdate;
            Date indate;
            List<AssetDistributeDetail> addList;
            List<Invdta> addedDetail = new ArrayList();

            // 用于更新资产明细
            for (AssetDistribute e : adList) {
                if (e.getRelformid() != null && !"".equals(e.getRelformid())) {
                    continue;
                }
                facno = e.getCompany();
                trdate = e.getFormdate();
                indate = BaseLib.getDate();
                trno = "";
                trseq = 0;
                assetDistributeBean.setDetail(e.getFormid());
                addList = assetDistributeBean.getDetailList();
                if (addList != null && !addList.isEmpty()) {
                    addedDetail.clear();
                    try {
                        // 跨月单据使用当前日期
                        if (trdate.getMonth() < indate.getMonth()) {
                            trdate = BaseLib.getDate("yyyy-MM-dd", BaseLib.formatDate("yyyy-MM-dd", indate));
                        }
                        for (AssetDistributeDetail d : addList) {
                            trseq++;
                            wareh = warehouseBean.findERPWarehouse(facno, d.getWarehouse().getId());
                            Invdta invdta = new Invdta(d.getAssetItem().getItemno(), facno, prono, trno, trseq);
                            invdta.setTrtype(trtype);
                            // 获取品号资料
                            invmasBean.setCompany(facno);
                            Invmas m = invmasBean.findByItnbr(d.getAssetItem().getItemno());
                            if (m == null) {
                                log4j.error("EAM" + e.getFormid() + "中的品号" + d.getAssetItem().getItemno() + "ERP中不存在");
                                throw new RuntimeException("EAM" + e.getFormid() + "中的品号" + d.getAssetItem().getItemno() + "ERP中不存在");
                            }
                            invdta.setItcls(m.getItcls());
                            invdta.setItclscode(m.getItclscode());
                            invdta.setTrnqy1(d.getQty());
                            invdta.setTrnqy2(BigDecimal.ZERO);
                            invdta.setTrnqy3(BigDecimal.ZERO);
                            invdta.setUnmsr1(m.getUnmsr1());
                            invdta.setWareh(wareh);
                            invdta.setFixnr("");
                            invdta.setVarnr("");
                            invdta.setIocode('0');
                            // 加入库存出入新增列表
                            addedDetail.add(invdta);
                        }
                        // INV310表头资料
                        Invhad invhad = new Invhad(facno, prono, trno);
                        invhad.setTrtype(trtype);
                        invhad.setTrdate(trdate);
                        invhad.setDepno(e.getDeptno());
                        invhad.setIocode('0');
                        invhad.setResno("K15");
                        invhad.setHmark1(null);
                        invhad.setHmark2("0008");
                        invhad.setSourceno(e.getFormid());
                        invhad.setStatus('N');
                        invhad.setUserno(e.getCfmuser());
                        invhad.setIndate(indate);
                        // 获取编号
                        trno = invhadBean.initINV310(invhad, addedDetail, true);
                        if (trno != null && !"".equals(trno)) {
                            e.setRelformid(trno);
                            e.setStatus("T");
                            assetDistributeBean.update(e);
                        }
                    } catch (RuntimeException | ParseException ex) {
                        log4j.error("createERPINV310ByEAMAssetDistribute时异常", ex);
                    }
                }
            }
        }
        log4j.info("createERPINV310ByEAMAssetDistribute轮询");
    }

    @Schedule(minute = "*/5", hour = "7-23", persistent = false)
    public void createOAHZJS034ByPLM() {
        String formInstance = "";
        try {
            HZJS034Model m;
            HZJS034DetailModel d;
            List<HZJS034DetailModel> detailList = new ArrayList<>();
            LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
            details.put("Detail", detailList);

            List<PLMItnbrDetailTemp> plmDetailList;
            List<PLMItnbrMasterTemp> plmMasterList = plmItnbrMasterTempBean.findNeedThrow();
            if (plmMasterList != null && !plmMasterList.isEmpty()) {
                boolean fromTHB;
                int i, j;
                String k;
                for (PLMItnbrMasterTemp pm : plmMasterList) {
                    fromTHB = pm.getProno().equals("A") || pm.getProno().equals("B");
                    plmDetailList = plmItnbrMasterTempBean.findNeedThrowDetail(pm.getItemNumber());
                    if (plmDetailList != null && !plmDetailList.isEmpty()) {
                        detailList.clear();// 清除前面的资料
                        i = 0;
                        for (PLMItnbrDetailTemp pd : plmDetailList) {
                            i++;
                            d = new HZJS034DetailModel();
                            d.setSeq(String.valueOf(i));
                            d.setItcls("");
                            d.setClsdsc("");
                            j = pd.getCItnbr().indexOf("-");
                            k = pd.getCItnbr().substring(0, 1);
                            if (j == 4 && (k.equals("1") || k.equals("2") || k.equals("3"))) {
                                // 1,2,3字头前面是4码，加入中间3字码
                                d.setItnbr(pd.getCItnbr().substring(0, 2) + "3" + pd.getCItnbr().substring(2));
                            } else {
                                d.setItnbr(pd.getCItnbr());
                            }
                            d.setItdsc(pd.getCItdsc());
                            d.setSpdsc(pd.getCSpdsc());
                            d.setEitdsc(pd.getCEitdsc());
                            d.setEspdsc(pd.getCEspdsc());
                            d.setKind("1");
                            d.setMorpcode("P");
                            d.setUnmsr1(pd.getUnmsr());
                            d.setUnmsr1e(pd.getUnmsre());
                            d.setUnmsr2("");
                            d.setIsDUnit("N");
                            d.setYt("");
                            d.setRemark("");
                            detailList.add(d);
                        }
                        if (fromTHB) {
                            workFlowBean.initUserInfo("C1526");// THB申请的品号转入SHB暂时由唐倩处理
                        } else {
                            workFlowBean.initUserInfo(pm.getApplicant());
                        }
                        m = new HZJS034Model();
                        if (fromTHB) {
                            m.setFacno("C");// THB申请的品号转入SHB
                        } else {
                            m.setFacno(pm.getProno());
                        }
                        m.setEmpl(workFlowBean.getCurrentUser().getId());
                        m.setDept(workFlowBean.getUserFunction().getOrganizationUnit().getId());
                        m.setIndate(BaseLib.getDate());
                        m.setPLMNO(pm.getItemNumber());
                        formInstance = workFlowBean.buildXmlForEFGP("HZ_JS034", m, details);
                        String subject = "PLM件号申请_" + pm.getItemNumber();
                        if (fromTHB) {
                            subject += "_THB";
                        }
                        String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, "HZ_JS034",
                                formInstance, subject);
                        String[] rm = msg.split("\\$");
                        if (rm != null) {
                            log4j.info(Arrays.toString(rm));
                        }
                        if (rm != null && rm.length == 2 && rm[0].equals("200")) {
                            // 更新PLM状态
                            pm.setCTriggerYn('Y');
                            plmItnbrMasterTempBean.update(pm);
                            plmItnbrMasterTempBean.getEntityManager().flush();
                        }
                    }
                }
            }
        } catch (Exception ex) {
            log4j.error("PLM件号抛转轮询时异常", ex);
        }
        log4j.info("PLM件号抛转轮询");
    }

    //@Schedule(minute = "0", hour = "15", persistent = false)
    public void createOASHBERPINV325ByERPWSQ() {
        SHBERPINV325Model s;
        SHBERPINV325DetailModel dm;
        List<SHBERPINV325DetailModel> detailList = new ArrayList<>();
        LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
        details.put("Detail", detailList);
        try {
            invwhsafeBean.setCompany("C");
            invbalBean.setCompany("C");
            List<Invwhsafe> list = invwhsafeBean.findAll();
            int c;
            int i = 0;
            double low;
            double high;
            double take;
            double onhand1;
            String itnbr;
            String wareh;
            String itdsc;
            for (Invwhsafe iw : list) {
                InvwhsafePK PK = iw.getInvwhsafePK();
                low = iw.getLowest().doubleValue();
                high = iw.getHighest().doubleValue();
                take = iw.getMintake().doubleValue();
                itnbr = PK.getItnbr();
                wareh = PK.getWareh();
                itdsc = iw.getItdsc();
                Invbal IB = invbalBean.findByItnbrAndWareh(itnbr, wareh);
                BigDecimal Onhand1 = IB.getOnhand1();
                onhand1 = Onhand1.doubleValue();
                if (onhand1 < low) {
                    c = (int) ((high - onhand1) / take);
                } else {
                    continue;
                }
                i++;
                dm = new SHBERPINV325DetailModel();
                dm.setSeq(String.valueOf(i));
                dm.setItnbr(itnbr);
                dm.setItdsc(itdsc);
                dm.setCountnum(c + "");
                dm.setSumnum((take * c) + "");
                dm.setDfromwareh("ASRS01");
                dm.setDtowareh("ZP01");
                dm.setDtowarehsum(onhand1 + "");
                dm.setBz("");
                detailList.add(dm);
            }
            workFlowBean.initUserInfo("C0385");
            s = new SHBERPINV325Model();
            s.setFacno("C");
            s.setCreatedate(BaseLib.getDate());
            s.setApplyUser("C0385");
            s.setApplyDept("1F220");
            s.setProno("1");
            s.setResno("T01");
            s.setResna("移仓调拨");
            s.setTrtype("IAC");
            s.setFromwareh("ASRS01");
            s.setFromwarehName("自动原物料仓");
            s.setTowareh("ZP01");
            s.setTowarehName("装配一倒扣仓");
            s.setBz("");
            s.setDfromwareh("");
            s.setDtowareh("");
            s.setDfromwarehName("");
            s.setDtowarehName("");
            s.setDtowarehsum("");
            s.setItdsc("");
            s.setItnbr("");
            s.setRelformid("");
            if (detailList.size() > 0) {
                String formInstance = workFlowBean.buildXmlForEFGP("SHB_ERP_INV325", s, details);
                String subject = "生产制程领料" + BaseLib.formatDate("yyyyMMdd", s.getCreatedate());
                String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, "PKG_SHB_ERP_INV325",
                        formInstance, subject);
            }
        } catch (Exception ex) {
            log4j.info("发起生产制程领料时异常", ex);
        }
        log4j.info("发起生产制程领料轮询");
    }

    @Schedule(minute = "*/7", hour = "7-23", persistent = false)
    public void createBPMProcessByERPTransaction() {
        log4j.info("ERP-CDR220报价审批抛转EFGP签核轮询开始");
        createOAHKYX009ByERPCDR220("C");
        createOAHKYX009ByERPCDR220("G");
        createOAHKYX009ByERPCDR220("J");
        createOAHKYX009ByERPCDR220("N");
        createOAHKYX009ByERPCDR220("C4");
        createOAHKYX009ByERPCDR220("K");
        createOAHKYX009ByERPCDR220("L");
        log4j.info("ERP-CDR220报价审批抛转EFGP签核轮询结束");
        log4j.info("ERP-APM811进货请款抛转EFGP签核轮询开始");
        createOASHBERPAPM811ByERPAPM811("C");
        createOASHBERPAPM811ByERPAPM811("K");
        createOASHBERPAPM811ByERPAPM811("H");
        //createOASHBERPAPM811ByERPAPM811("Y");
        log4j.info("ERP-APM811进货请款抛转EFGP签核轮询结束");
    }

    private void createOAHKYX009ByERPCDR220(String company) {
        HKYX009Model hm;
        HKYX009DetailModel dm;
        List<HKYX009DetailModel> detailList = new ArrayList<>();
        LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
        details.put("Detail", detailList);
        try {
            cdrqhadBean.setCompany(company);
            List<Cdrqhad> cdrqhadList = cdrqhadBean.findNeedThrow();
            List<Cdrqdta> cdrqdtaList;
            String facno;
            String quono;
            int i;
            if (cdrqhadList != null && !cdrqhadList.isEmpty()) {
                for (Cdrqhad h : cdrqhadList) {
                    facno = h.getCdrqhadPK().getFacno();
                    quono = h.getCdrqhadPK().getQuono();
                    cdrqdtaList = cdrqhadBean.findNeedThrowDetail(facno, quono);
                    cdrcusBean.setCompany(facno);
                    invmasBean.setCompany(facno);
                    miscodeBean.setCompany(facno);
                    secuserBean.setCompany(facno);
                    if (cdrqdtaList != null && !cdrqdtaList.isEmpty()) {
                        detailList.clear();// 清除前面的资料
                        i = 0;
                        for (Cdrqdta d : cdrqdtaList) {
                            i++;
                            dm = new HKYX009DetailModel();
                            dm.setSeq(String.valueOf(i));
                            dm.setTrseq(String.valueOf(d.getCdrqdtaPK().getTrseq()));
                            dm.setItnbr(d.getItnbr());
                            dm.setItnbrcus(d.getItnbrcus());
                            Invmas invmas = invmasBean.findByItnbr(d.getItnbr());
                            dm.setItdsc(filterString(invmas.getItdsc()));
                            dm.setSpdsc(filterString(invmas.getSpdsc()));
                            dm.setQuaqy1(d.getQuaqy1().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                            dm.setUnpris(d.getUnpris().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                            dm.setLastunpri(d.getListunpri().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                            if (d.getHisorders() != null) {
                                dm.setOrderqty(d.getHisorders().toString());
                            } else {
                                dm.setOrderqty("0");
                            }
                            dm.setTramts(d.getTramts().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                            if (d.getCdrdate() != null) {
                                dm.setCdrdate(BaseLib.formatDate("yyyy/MM/dd", d.getCdrdate()));
                            } else {
                                dm.setCdrdate(BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
                            }
                            if (null == d.getQxb()) {
                                dm.setPeratio("");
                            } else {
                                dm.setPeratio(d.getQxb());
                            }
                            dm.setRefmodel("");
                            dm.setRefratio("");
                            if (d.getDiffprice() != null) {
                                dm.setDiffitting(d.getDiffprice().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                            } else {
                                dm.setDiffitting("0");
                            }
                            detailList.add(dm);
                        }
                        workFlowBean.initUserInfo(h.getUserno());
                        hm = new HKYX009Model();
                        hm.setFacno(facno);
                        hm.setQuono(quono);
                        hm.setQuodate(h.getQuodate());
                        hm.setCfmdate(h.getCfmdate());
                        hm.setIsspecial(h.getIsspecial());
                        hm.setPricingtype(h.getPricingtype());
                        hm.setQuotype(h.getQuotype().toString());
                        Miscode miscode = miscodeBean.findByPK("1C", h.getPricingtype());
                        hm.setPricingtypedsc(miscode.getCdesc());
                        hm.setCoin(h.getCoin());
                        hm.setRatio(h.getRatio().doubleValue());
                        hm.setLevelp(h.getLevelp());
                        hm.setCusno(h.getCusno());
                        Cdrcus cdrcus = cdrcusBean.findByCusno(h.getCusno());
                        hm.setCusna(cdrcus.getCusna());
                        hm.setMancode(h.getMancode());

                        Secuser secuser = secuserBean.findByUserno(h.getMancode());
                        hm.setMancodesc(secuser.getUsername());
                        // hm.setDepno(workFlowBean.getCurrentUser().getDeptno());
                        hm.setDepno(h.getDepno()); // 报价部门
                        hm.setCfmuser(h.getCfmuserno());
                        // 设置审批原因
                        hm.setApprresno(miscodeBean.findByPK("1O", h.getApprresno()).getCdesc());
                        //加入付款条件叙述
                        hm.setPaycodedsc(h.getPaycodedsc());
                        // 构建表单实例
                        String formInstance = workFlowBean.buildXmlForEFGP("HK_YX009", hm, details);
                        String subject = "客户:" + hm.getCusna() + "申请原因： " + hm.getApprresno() + ".  业务员:" + hm.getMancode() + hm.getMancodesc();
                        String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, "PKG_HK_YX009",
                                formInstance, subject);
                        String[] rm = msg.split("\\$");
                        if (rm != null) {
                            log4j.info(h.getCdrqhadPK().getQuono());
                            log4j.info(Arrays.toString(rm));
                        }
                        if (rm != null && rm.length == 2 && rm[0].equals("200")) {
                            // 更新ERP CDR220状态
                            h.setHquosta('O');
                            cdrqhadBean.setCompany(facno);
                            cdrqhadBean.update(h);
                            cdrqhadBean.getEntityManager().flush();
                        }
                    }
                }
            }
        } catch (Exception ex) {
            log4j.error(ex);
        }
    }

    private void createOASHBERPAPM811ByERPAPM811(String company) {
        SHBERPAPM811Model hm;
        SHBERPAPM811DetailModel dm;
        List<SHBERPAPM811DetailModel> detailList = new ArrayList<>();
        LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
        details.put("Detail", detailList);
        try {
            apmaphBean.setCompany(company);
            purvdrBean.setCompany(company);
            apmtbilBean.setCompany(company);
            List<Apmaph> apmaphList = apmaphBean.findNeedThrow();
            List<Apmapd> apmapdList;
            List<String> bilnoList;
            int i;
            double sumqty;
            double expamtfs;
            double ratio;
            double sumapamtfs;
            BigDecimal sumtaxfs;
            BigDecimal sumtax;
            double sumbilnum8fs;
            double sumbilnum8;
            if (apmaphList != null && !apmaphList.isEmpty()) {
                for (Apmaph h : apmaphList) {
                    apmapdList = apmaphBean.findNeedThrowDetail(h.getApmaphPK().getFacno(), h.getApmaphPK().getApno(),
                            h.getApmaphPK().getAptyp());
                    if (apmapdList != null && !apmapdList.isEmpty()) {
                        detailList.clear();// 清除前面的资料
                        i = 0;
                        sumqty = 0.00;
                        expamtfs = 0.00;
                        ratio = 1;
                        sumapamtfs = 0.00;
                        sumtaxfs = BigDecimal.ZERO;
                        sumtax = BigDecimal.ZERO;
                        sumbilnum8fs = 0.00;
                        sumbilnum8 = 0.00;
                        bilnoList = new ArrayList<>();
                        for (Apmapd d : apmapdList) {
                            i++;
                            dm = new SHBERPAPM811DetailModel();
                            dm.setSeq(String.valueOf(i));
                            dm.setTrapyh(d.getTrapyh());
                            dm.setAcpno(d.getAcpno());
                            dm.setSponr(d.getSponr());
                            dm.setItnbr(d.getItnbr());
                            dm.setItdsc(filterString(d.getItdsc()));
                            dm.setPric(d.getPric().toString());
                            dm.setPayqty(d.getPayqty().toString());
                            sumqty += d.getPayqty().doubleValue();
                            dm.setCoin(d.getCoin());
                            dm.setRatio(d.getRatio().toString());
                            ratio = d.getRatio().doubleValue();
                            dm.setOgdkid(d.getOgdkid());
                            dm.setBilno(d.getBilno());
                            dm.setAcpamtfs(d.getAcpamtfs().toString());
                            if (dm.getTrapyh().equals("2")) {
                                expamtfs += d.getAcpamtfs().doubleValue();
                            }
                            dm.setIvopsfs(d.getIvopsfs().toString());
                            dm.setIvomsfs(d.getIvoms().toString());
                            dm.setPreamtfs(d.getPreamtfs().toString());
                            dm.setTemamtfs(d.getTemamtfs().toString());
                            dm.setLosamtfs(d.getLosamtfs().toString());
                            dm.setComApamtfs((d.getAcpamtfs().subtract(d.getPreamtfs()).subtract(d.getTemamtfs()).add(d.getIvopsfs())
                                    .subtract(d.getIvomsfs()).subtract(d.getLosamtfs())).toString());
                            sumapamtfs += (d.getAcpamtfs().subtract(d.getPreamtfs()).subtract(d.getTemamtfs()).add(d.getIvopsfs())
                                    .subtract(d.getIvomsfs()).subtract(d.getLosamtfs())).doubleValue();
                            if (d.getDmark() == null || d.getDmark().isEmpty() || d.getDmark().length() == 0
                                    || d.getDmark().equals("null")) {
                                dm.setDmark("");
                            } else {
                                dm.setDmark(d.getDmark());
                            }
                            if (d.getApdsc() == null || d.getApdsc().isEmpty() || d.getApdsc().length() == 0
                                    || d.getApdsc().equals("null")) {
                                dm.setApdsc("");
                            } else {
                                dm.setApdsc(d.getApdsc());
                            }
                            detailList.add(dm);
                            // 计算海关代徵,税额
                            if (!bilnoList.contains(d.getBilno())) {
                                bilnoList.add(d.getBilno());
                                Apmtbil apmtbil = apmtbilBean.findByPK(company, d.getBilno());
                                if (null != apmtbil) {
                                    sumtaxfs = sumtaxfs.add(apmtbil.getBiltaxfs());
                                    sumtax = sumtax.add(apmtbil.getBiltax());
                                    if ('8' == apmtbil.getBilnum()) {
                                        sumbilnum8 += apmtbil.getBiltax().doubleValue();
                                        sumbilnum8fs += apmtbil.getBiltaxfs().doubleValue();
                                    }
                                }
                            }
                        }
                        workFlowBean.initUserInfo(h.getCfmusrno());
                        hm = new SHBERPAPM811Model();
                        hm.setFacno(h.getApmaphPK().getFacno());
                        hm.setAppdate(h.getApdate());
                        hm.setAppuser(h.getApusrno());
                        hm.setAppdept(h.getDepno());
                        hm.setAptyp(h.getApmaphPK().getAptyp());
                        hm.setVdrno(h.getVdrno());
                        hm.setVdrna(h.getVdrna());
                        Purvdr purvdr = purvdrBean.findByVdrno(h.getVdrno());
                        if (null != purvdr) {
                            hm.setTickdays(purvdr.getTickdays().toString());
                        } else {
                            hm.setTickdays("0");
                        }

                        hm.setPyhyn(h.getPyhyn());
                        hm.setApno(h.getApmaphPK().getApno());
                        hm.setPaytn(h.getPaytn());
                        hm.setPaydate(BaseLib.formatDate("yyyy/MM/dd", h.getPayda()));
                        // 票据到期日 n_pur_apmlib --> uf_getpurdate
                        hm.setTerdate(BaseLib.formatDate("yyyy/MM/dd", h.getTerda()));
                        hm.setApsta(h.getApsta());
                        hm.setIndate(h.getIndate());
                        hm.setInuser(h.getUserno());
                        hm.setIsretmoney(h.getIsretmoney().toString());
                        if (null == h.getHmark()) {
                            hm.setHmark("");
                        } else {
                            hm.setHmark(h.getHmark());
                        }
                        // 表单下方合计栏位(取2位小数)
                        hm.setSum_apamtfs((double) Math.round(sumapamtfs * 100) / 100);
                        hm.setSum_apamt((double) Math.round(ratio * sumapamtfs * 100) / 100);
                        hm.setSum_bilnum8fs((double) Math.round(sumbilnum8fs * 100) / 100);
                        hm.setSum_bilnum8((double) Math.round(sumbilnum8 * 100) / 100);
                        hm.setSum_taxfs(sumtaxfs.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
                        hm.setSum_tax(sumtax.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

                        hm.setTotalfs(hm.getSum_apamtfs() + hm.getSum_taxfs() - hm.getSum_bilnum8fs());
                        hm.setTotalfs((double) Math.round(hm.getTotalfs() * 100) / 100);
                        hm.setTotal((double) Math.round(ratio * hm.getTotalfs() * 100) / 100);
                        hm.setExpamtfs((double) Math.round(expamtfs * 100) / 100);
                        hm.setExpamt((double) Math.round(expamtfs * ratio * 100) / 100);
                        hm.setCompute_1(sumqty);

                        // 构建表单实例
                        String formInstance = workFlowBean.buildXmlForEFGP("SHB_ERP_APM811", hm, details);
                        String subject = "进货请款申请单：" + hm.getApno() + ",厂商：" + hm.getVdrna() + ",请款天数（" + hm.getTickdays() + "),"
                                + "请款金额：" + hm.getTotal();
                        String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, "PKG_SHB_ERP_APM811",
                                formInstance, subject);
                        String[] rm = msg.split("\\$");
                        if (rm != null) {
                            log4j.info(Arrays.toString(rm));
                        }
                        if (rm != null && rm.length == 2 && rm[0].equals("200")) {
                            // 更新ERP APM811状态
                            h.setApsta("25");
                            apmaphBean.update(h);
                            apmaphBean.getEntityManager().flush();
                        }
                    }
                }
            }
        } catch (Exception ex) {
            log4j.error(ex);
        }
    }

    // @Schedule(minute = "*/1", hour = "*", persistent = false)
    public void createERPCDR225ByCRMREPPA() {
        String pa001 = "";
        String pa002 = "";
        String facno;
        String pricelevel;
        String ls_levelp;
        String ls_levelpo;
        Character wi_s_cdrbomsubyn;
        Character wi_s_acesoryyn;
        Character ls_cdrbomsubyn;
        Character ls_cdrothsfk;
        String li_cdrbomsubitem;
        Object[] prpl;
        int li_ulevelp;
        BigDecimal ldc_stdprice;
        BigDecimal ldc_levelpri;
        String ls_itnbr;
        String ls_itemdesc;
        String pricingtype;
        Character decode;
        List<REPPB> reppbList = null;

        List<REPPA> reppaList = reppaBean.findNeedThrow();
        if (reppaList != null && !reppaList.isEmpty()) {
            for (REPPA ra : reppaList) {
                pa001 = ra.getREPPAPK().getPa001(); // CRM单别
                pa002 = ra.getREPPAPK().getPa002(); // CRM估价单单号
                reppbList = reppaBean.getDetailList(pa001, pa002);
                // 记录抛转次数，超过3次不轮询
                if (ra.getPa518() == null || "".equals(ra.getPa518())) {
                    ra.setPa518("1");
                } else {
                    int i = Integer.valueOf(ra.getPa518()) + 1;
                    ra.setPa518(String.valueOf(i));
                }
                syncCRMBean.syncUpdate(ra, null);
            }
        }

        try {
            if (reppaList != null && !reppaList.isEmpty()) {
                for (REPPA ra : reppaList) {
                    List<Cdrqdta> addedDetail = new ArrayList();
                    facno = ra.getPa500();
                    if (facno.equals("")) {
                        continue;
                    }
                    Date quodate = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
                    pricingtype = ra.getPa509(); // 报价类别
                    if (ra.getPa508().equals("")) {
                        decode = '1';
                    } else {
                        decode = ra.getPa508().charAt(0); // 国内外码
                    }
                    cdrsysBean.setCompany(facno);
                    cdrqsysBean.setCompany(facno);
                    cdrcusBean.setCompany(facno);
                    miscodeBean.setCompany(facno);
                    cdrpaydscBean.setCompany(facno);
                    cdrcusmanBean.setCompany(facno);
                    cdrqhadBean.setCompany(facno);
                    if (reppbList != null && !reppbList.isEmpty()) {
                        // 表头资料
                        Cdrqhad qh = new Cdrqhad();
                        CdrqhadPK qhpk = new CdrqhadPK();
                        qhpk.setFacno(facno);
                        String lsquono = cdrqsysBean.getSerialno(facno, quodate, decode, false, "CDR225");
                        wi_s_cdrbomsubyn = cdrsysBean.getByFacno(facno).getCdrbomsubyn();
                        wi_s_acesoryyn = cdrsysBean.getByFacno(facno).getAcesoryyn();
                        qh.setCusno(ra.getPa510());
                        Cdrcus cs = cdrcusBean.findByCusno(qh.getCusno());
                        if (cs == null) {
                            throw new NullPointerException("找不到对应的客户资料！");
                        }
                        qh.setDepno(ra.getPa507());
                        qh.setQuodate(quodate);
                        String pa029 = ra.getPa029().substring(0, 4) + "/" + ra.getPa029().substring(4, 6) + "/"
                                + ra.getPa029().substring(6);
                        String pa030 = ra.getPa030().substring(0, 4) + "/" + ra.getPa030().substring(4, 6) + "/"
                                + ra.getPa030().substring(6);
                        qh.setFromdate(BaseLib.getDate("yyyy/MM/dd", pa029));
                        qh.setEeffdate(BaseLib.getDate("yyyy/MM/dd", pa030));
                        long tt = qh.getEeffdate().getTime() - qh.getFromdate().getTime();
                        long tdays = (tt / 1000 / 60 / 60 / 24);
                        qh.setEffdays((short) tdays); // 有效天数
                        qh.setDecode(decode); // 国内国外
                        if (ra.getPa517() == null || "".equals(ra.getPa517())) {
                            qh.setShptrseq((short) 1);
                        } else {
                            qh.setShptrseq(Short.valueOf(ra.getPa517())); // 指配客户代号
                        }
                        qh.setIvotrseq(cs.getIvotrseq()); // 发票客户代号
                        qh.setIsspecial(ra.getPa515()); // 是否特殊报价
                        if (pa001.trim().equals("DD")) {
                            qh.setQuotype('1');
                            qh.setHquosta('N');
                        } else {
                            qh.setQuotype('2'); // 单对单/合约报价
                            if ("Y".equals(qh.getIsspecial())) {
                                qh.setHquosta('R');
                            } else {
                                qh.setHquosta('Y');
                            }
                        }

                        qh.setTax(ra.getPa036().charAt(0)); // 税别
                        qh.setTaxrate(ra.getPa028());
                        qh.setCoin(ra.getPa010());
                        qh.setRatio(ra.getPa018());
                        qh.setSndcode(cs.getSndcode()); // 交货条件
                        qh.setPaycode(ra.getPa012()); // 付款条件
                        qh.setTermcode(cs.getTermcode()); // 交易条件
                        if (qh.getDecode().equals('1')) {
                            Miscode mis1 = miscodeBean.findByPK("GD", qh.getSndcode());
                            if (mis1 != null) {
                                qh.setSndcodedsc(mis1.getCdesc()); // 交货条件叙述
                            }
                            Miscode mis2 = miscodeBean.findByPK("GH", qh.getTermcode());
                            if (mis2 != null) {
                                qh.setTermcodedsc(mis2.getCdesc()); // 交易条件叙述
                            }

                        } else {
                            Cdrpaydsc cdrpaydsc = cdrpaydscBean.findByPK('3', qh.getSndcode());
                            if (cdrpaydsc != null) {
                                qh.setSndcodedsc(cdrpaydsc.getAllcodedsc());
                            }
                            Cdrpaydsc cdrpaydsc2 = cdrpaydscBean.findByPK('2', qh.getTermcode());
                            if (cdrpaydsc2 != null) {
                                qh.setTermcodedsc(cdrpaydsc2.getAllcodedsc());
                            }
                        }
                        qh.setPaycodedsc(cs.getSkfs()); // 付款条件叙述
                        qh.setPaysepcode(cs.getPaysepcode()); // 付款内容区分
                        qh.setSeldate1(cs.getSeldate1()); // 付款截止日（每月几号）
                        qh.setSeldate2(cs.getSeldate2());
                        qh.setSeldate3(cs.getSeldate3());
                        qh.setSeldate4(cs.getSeldate4());
                        qh.setHandays1(cs.getHandays1()); // 整账所需天数
                        qh.setHandays2(cs.getHandays2());
                        qh.setHandays3(cs.getHandays3());
                        qh.setHandays4(cs.getHandays4());
                        qh.setTickdays(cs.getTickdays());
                        qh.setSacode(cs.getSacode());
                        qh.setAreacode(cs.getAreacode());
                        qh.setCuycode(cs.getCuycode());
                        // 业务员取CRM
                        if (ra.getPa005() != null) {
                            qh.setMancode(ra.getPa005());
                        } else {
                            Cdrcusman cusman = cdrcusmanBean.findByPK(facno, qh.getCusno());
                            if (cusman != null) {
                                qh.setMancode(cusman.getMan());
                            } else {
                                log4j.error("CRM估计单抛转轮询时异常,找不到对应的业务员~!");
                                continue;
                            }
                        }
                        qh.setTramts(ra.getPa020());
                        qh.setTaxamts(ra.getPa021());
                        qh.setTotamts(ra.getPa019());
                        // qh.setHmark1(""); 表头备注一
                        // qh.setHmark2("");
                        // qh.setHmark3("");
                        qh.setHmark4(pa001 + pa002); // 记录CRM来源单号
                        qh.setPrtcnt((short) 0);
                        qh.setPiprtcnt((short) 0);
                        qh.setBcdrno(""); // 抛转订单编号
                        qh.setIndate(BaseLib.getDate());
                        qh.setUserno(ra.getPa005());
                        qh.setCfmuserno(ra.getPa025());
                        String pa024 = ra.getPa024().substring(0, 4) + "/" + ra.getPa024().substring(4, 6) + "/"
                                + ra.getPa024().substring(6);
                        qh.setCfmdate(BaseLib.getDate("yyyy/MM/dd", pa024));
                        // qh.setTrnuserno(""); //抛转订单人员
                        // qh.setTrndate(""); //抛转订单日期
                        qh.setPino("N"); // 列印PI否
                        qh.setCopyquono(""); // 原报价单号（copy前）
                        qh.setSelpricode('1');
                        qh.setContactman(cs.getContactman());
                        qh.setPricingtype(pricingtype);
                        if (ra.getPa515() == null || "".equals(ra.getPa515())) {
                            throw new NullPointerException("是否特殊报价资料错误！");
                        }
                        // qh.setSpcode();
                        pricelevel = cdrqhadBean.getUserPricelevel(pricingtype, qh.getMancode());
                        li_ulevelp = Integer.parseInt(pricelevel.substring(6)); // "price09"截取数字
                        ls_levelpo = qh.getLevelp();

                        // 表身资料
                        int trseq = 0;
                        List<REPPB> reppbasry = new ArrayList<>(); // 接收赠品
                        for (REPPB rb : reppbList) {
                            // 去除赠品，取赠品数量等于0
                            if (rb.getPb010().compareTo(BigDecimal.ZERO) == 0) {
                                trseq++;
                                String itnbr = rb.getPb004();
                                Cdrqdta qd = new Cdrqdta();
                                CdrqdtaPK qdpk = new CdrqdtaPK();
                                qdpk.setFacno("C");
                                qdpk.setQuono(lsquono);
                                qdpk.setTrseq((short) trseq);
                                qd.setCdrqdtaPK(qdpk);
                                qd.setItnbr(itnbr); // 品号
                                qd.setItnbrcus(""); // 客户品号(零件无)
                                qd.setProno("1"); // 默认第一生产地
                                qd.setShptrseq(qh.getShptrseq()); // 指配代号
                                qd.setQuaqy1(rb.getPb009());
                                qd.setQuaqy2(BigDecimal.ZERO);
                                qd.setArmqy(rb.getPb009()); // 应收数量
                                qd.setUnpris(rb.getPb011());
                                qd.setUnprisrccode('0'); // 单价来源
                                qd.setTramts(rb.getPb013());
                                qd.setCdrdate(BaseLib.getDate());
                                qd.setDmark1(rb.getPb517()); // 表身备注1(冷媒机型)
                                qd.setDmark2(""); // 表身备注2（齿数比）
                                qd.setDmark3("");
                                qd.setDmark4("");
                                // qd.setTrnstatus();
                                if (rb.getPb504() == null || rb.getPb504().equals("")) {
                                    qd.setListunpri(BigDecimal.ZERO);
                                } else {
                                    qd.setListunpri(BigDecimal.valueOf(Double.parseDouble(rb.getPb504()))); // 定价
                                }
                                qd.setDiscnt((rb.getPb012().multiply(BigDecimal.valueOf(100))).shortValue()); // 折扣数
                                // qd.setDiscnt(Short.valueOf(rb.getPb012().toString()));
                                qd.setDispri0(BigDecimal.ZERO);
                                qd.setDisqy1(BigDecimal.ZERO);
                                qd.setDispri1(BigDecimal.ZERO);
                                qd.setDisqy2(BigDecimal.ZERO);
                                qd.setDispri2(BigDecimal.ZERO);
                                qd.setDisqy3(BigDecimal.ZERO);
                                qd.setDispri3(BigDecimal.ZERO);
                                qd.setDisqy4(BigDecimal.ZERO);
                                qd.setDispri4(BigDecimal.ZERO);
                                qd.setDisqy5(BigDecimal.ZERO);
                                qd.setDispri5(BigDecimal.ZERO);
                                if (rb.getPb504() == null || rb.getPb505().equals("")) {
                                    qd.setListunpri(BigDecimal.ZERO);
                                } else {
                                    qd.setListunpri(BigDecimal.valueOf(Double.parseDouble(rb.getPb505()))); // 旧价
                                }
                                qd.setMorderqy(BigDecimal.ZERO); // 最小包装数量, 最小订购量
                                cdrqbomsubBean.setCompany(facno);
                                Cdrqbomsub cbomsub = cdrqbomsubBean.findByItnbrfAndCdrno(facno, qd.getItnbr(), qdpk.getQuono());
                                if (cbomsub == null) {
                                    qd.setSpcode('N');
                                    li_cdrbomsubitem = "0";
                                } else {
                                    qd.setSpcode('Y');
                                    li_cdrbomsubitem = "1";
                                }

                                BigDecimal ldc_salesprice = qd.getUnpris();
                                String itemno = qd.getDmark1();
                                if (ls_levelpo == null || ls_levelpo.equals("")) {
                                    ls_levelpo = "A" + li_ulevelp;
                                }
                                if ("".equals(itemno)) {
                                    prpl = cdrqhadBean.getByPricingPolicy(qd.getItnbr(), pricingtype, qh.getQuodate(), qh.getCoin());
                                } else {
                                    prpl = cdrqhadBean.getByPricingPolicy(qd.getItnbr(), pricingtype, qh.getQuodate(), qh.getCoin(),
                                            itemno);
                                }
                                if (prpl == null) {
                                    prpl = cdrqhadBean.getByPricingPolicy(qd.getItnbr(), pricingtype, qh.getQuodate(), "RMB");
                                    ldc_salesprice = qd.getUnpris().multiply(qh.getRatio());
                                }
                                if (prpl == null) {
                                    log4j.error(itnbr + " '未维护价格类别'" + pricingtype + "'对应的标准定价,请先维护!");
                                    // dw_detail.setitem(row,'dqxjkind','D') // C0583 2016.5.10 如果没有查找到价格,则记录
                                    qd.setDqxjkind('D');

                                } else {
                                    // 判断A9牌价
                                    BigDecimal ldc_a9unpri = BigDecimal.valueOf(Double.valueOf(prpl[10 + li_ulevelp].toString()));
                                    if (ldc_a9unpri == null || ldc_a9unpri.compareTo(BigDecimal.ZERO) == 0) {
                                        log4j.info("此件号" + itnbr + "还未维护A9牌价");
                                    }
                                    li_ulevelp = Integer.parseInt(pricelevel.substring(6)); // "price09"截取数字
                                    ldc_stdprice = BigDecimal.valueOf(Double.valueOf(prpl[10 + li_ulevelp].toString())); // prpl标准定价数组的顺序（数量）不能修改
                                    if (ldc_stdprice == null || ldc_stdprice.compareTo(BigDecimal.ZERO) < 1) {
                                        log4j.error("错误'" + itnbr + "'的 '" + itemno + "'机型未维护价格类别'" + pricingtype + "'对应的标准定价,请先维护!");
                                        // dw_detail.setitem(row,'dqxjkind','D') // C0583 2016.5.10 如果没有查找到价格,则记录
                                        qd.setDqxjkind('D');
                                    }
                                    ls_itnbr = prpl[0].toString();
                                    ls_itemdesc = prpl[2].toString();
                                    if (ls_itemdesc == null || "".equals(ls_itemdesc)) {
                                        invmasBean.setCompany(facno);
                                        Invmas m = invmasBean.findByItnbr(ls_itnbr);
                                        ls_itemdesc = m.getItdsc();
                                    }

                                    if (ldc_stdprice.compareTo(ldc_salesprice) > 0) {
                                        if (li_ulevelp > 1) {
                                            for (int i = 1; i <= li_ulevelp; i++) {
                                                ldc_levelpri = BigDecimal.valueOf(Double.valueOf(prpl[10 + i].toString())); // prpl标准定价数组的顺序（数量）不能修改
                                                if (ldc_levelpri == null || ldc_levelpri.compareTo(BigDecimal.ZERO) < 1) {
                                                    log4j.error("出错，第" + i + "笔件号'" + itnbr + "'当前售价不符合价格权限表管控范围,请走特殊报价或联系mis'");
                                                    // dw_detail.setitem(row,'dqxjkind','D') // C0583 2016.5.10 如果没有查找到价格,则记录
                                                    continue;
                                                }
                                                if (ldc_levelpri.compareTo(ldc_salesprice) < 1) {
                                                    if (li_ulevelp > i) {
                                                        ls_levelpo = "A" + i;
                                                        qh.setLevelp(ls_levelpo);
                                                        qd.setLevelp(ls_levelpo);
                                                        break;
                                                    }

                                                }

                                            }
                                        }

                                    }
                                }
                                // qd.setLevelp(facno);
                                // qd.setContunpri(BigDecimal.ZERO);
                                // qd.setNorm("");
                                // qd.setIslableprt(Character.MIN_VALUE);
                                // qd.setHisorders("");
                                // qd.setDiffprice(BigDecimal.ZERO);
                                // qd.setContractno("");
                                qd.setNcodeDA(rb.getPb513());
                                qd.setNcodeCD(rb.getPb514());
                                qd.setNcodeDC(rb.getPb515());
                                qd.setNcodeDD(rb.getPb516());
                                // qd.setQxb(facno);
                                // qd.setDeflevprice(BigDecimal.ZERO);
                                // qd.setCuslable("");
                                // CDR225确认--关于订单规格表判定

                                ls_cdrbomsubyn = 'N';
                                ls_cdrothsfk = 'N';
                                if ("J".equals(facno) || "N".equals(facno) || "G".equals(facno) || "C4".equals(facno)
                                        || "K".equals(facno)) {
                                    facno = "C";
                                }
                                Invmas invmas = invmasBean.findByItnbr(itnbr);
                                ls_cdrbomsubyn = invmas.getInvcls().getCdrbomsubyn();
                                if (ls_cdrbomsubyn == null) {
                                    ls_cdrbomsubyn = 'N';
                                }
                                // ==> C0583 2014.9.11 订单规格不管控，但仍需维护身份卡之品号大类
                                if (ls_cdrbomsubyn.equals('N')) {
                                    if (cdrqhadBean.findByItcls(facno, invmas.getItcls()) != null) {
                                        ls_cdrothsfk = 'Y';
                                    }
                                }
                                // 维护身份卡信息 cb_sfkn 可见 ==< DDGA
                                DDGA ddga = ddgaBean.findByREPPB(pa001, pa002, rb.getREPPBPK().getPb003());
                                if (ddga != null) {
                                    if (ls_cdrbomsubyn.equals('Y') || ls_cdrothsfk.equals('Y')) {
                                        cdrhpopsfkBean.setCompany(facno);
                                        Cdrhpopsfk sfkh = new Cdrhpopsfk();
                                        CdrhpopsfkPK sfkhPK = new CdrhpopsfkPK();
                                        if (ddga.getGa007() == null || "".equals(ddga.getGa007())) {
                                            sfkhPK.setFacno(facno);
                                        } else {
                                            sfkhPK.setFacno(ddga.getGa007());
                                        }
                                        String lsno = cdrhpopsfkBean.gettrno(facno, quodate, "CDR220", true);
                                        sfkhPK.setSfktrno(lsno);
                                        sfkh.setCdrhpopsfkPK(sfkhPK);
                                        sfkh.setCusno(ddga.getGa009());
                                        sfkh.setItnbr(itnbr);
                                        sfkh.setItnbrcus(ddga.getGa005());
                                        sfkh.setSpcode(ddga.getGa008().charAt(0));
                                        sfkh.setVersion(ddga.getGa011());
                                        sfkh.setQuono(lsquono);
                                        sfkh.setQtrseq(qdpk.getTrseq());
                                        sfkh.setCdrno("");
                                        // sfkh.setManno("");
                                        sfkh.setCdrno("");
                                        sfkh.setSpdesc(ddga.getGa010());
                                        sfkh.setCrtprg("CDR220");
                                        sfkh.setKeyindate(quodate);
                                        sfkh.setVarnr("");
                                        sfkh.setMatcode("");
                                        // 身份卡表身
                                        List<DDGB> ddgbList = ddgaBean.getDetailList(ddga.getDDGAPK().getGa004());
                                        List<Cdrdpopsfk> sfkdList = new ArrayList();
                                        if (ddgbList.size() > 0) {
                                            for (DDGB ddgb : ddgbList) {
                                                Cdrdpopsfk sfkd = new Cdrdpopsfk();
                                                CdrdpopsfkPK sfkdpk = new CdrdpopsfkPK();
                                                sfkdpk.setFacno(sfkh.getCdrhpopsfkPK().getFacno());
                                                sfkdpk.setParts(ddgb.getGb003());
                                                sfkdpk.setSfktrno(sfkhPK.getSfktrno());
                                                sfkdpk.setSorts(ddgb.getGb004());
                                                sfkd.setCdrdpopsfkPK(sfkdpk);
                                                Cdrsfkpart sfkpart = cdrsfkpartBean.findByPK(facno, ddgb.getGb003());
                                                if (sfkpart != null) {
                                                    sfkd.setPartdesc(sfkpart.getPartsdesc());
                                                    sfkd.setPapx(sfkpart.getPx());
                                                }
                                                Cdrsfksorts sfksort = cdrsfksortsBean.findByPK(facno, ddgb.getGb003(), ddgb.getGb004());
                                                if (sfksort != null) {
                                                    sfkd.setSortsdesc(sfksort.getSortsdesc());
                                                }
                                                sfkd.setSpecifit(ddgb.getGb005());
                                                Cdrsfkspec sfkspec = cdrsfkspecBean.findByPK(facno, ddgb.getGb003(), ddgb.getGb004(),
                                                        ddgb.getGb005());
                                                if (sfkspec != null) {
                                                    sfkd.setSpecifitesc(sfkspec.getSpecifitesc());
                                                }
                                                sfkdList.add(sfkd);
                                            }
                                        }
                                        cdrhpopsfkBean.persist(sfkh);
                                        cdrhpopsfkBean.persistDetailList(facno, sfkdList);
                                    }
                                }
                                // 订单规格表维护
                                if (wi_s_cdrbomsubyn.equals('Y')) {
                                    if (ls_cdrbomsubyn.equals('Y') && li_cdrbomsubitem == "0") {
                                        DDGC ddgc = ddgcBean.findByREPPB(pa001, pa002, rb.getREPPBPK().getPb003());
                                        if (ddgc != null) {
                                            cdrqbomsubBean.setCompany(facno);
                                            Cdrqbomsub cqbomsub = new Cdrqbomsub();
                                            CdrqbomsubPK cqbomsubpk = new CdrqbomsubPK();
                                            cqbomsubpk.setFacno(facno);
                                            cqbomsubpk.setCdrno(lsquono);
                                            cqbomsubpk.setTrseq(qdpk.getTrseq());
                                            cqbomsub.setCdrqbomsubPK(cqbomsubpk);
                                            cqbomsub.setItnbrf(ddgc.getGc006());
                                            cqbomsub.setSpcode(ddgc.getGc008().charAt(0));
                                            cqbomsub.setSpdesc(ddgc.getGc009());
                                            // cqbomsub.setSpdesc2(""); //规格说明2
                                            // 规格明细
                                            List<DDGD> ddgdList = ddgcBean.getDetailList(ddgc.getDDGCPK().getGc004());
                                            if (ddgdList.size() > 0) {
                                                for (int i = 0; i < ddgdList.size(); i++) {
                                                    Method setMethod1 = cqbomsub.getClass().getDeclaredMethod("set" + "Itdesc" + (i + 1),
                                                            String.class);
                                                    setMethod1.invoke(cqbomsub, ddgdList.get(i).getGd003());
                                                    Method setMethod2 = cqbomsub.getClass().getDeclaredMethod("set" + "Itnbr" + (i + 1),
                                                            String.class);
                                                    setMethod2.invoke(cqbomsub, ddgdList.get(i).getGd007());
                                                    Method setMethod3 = cqbomsub.getClass().getDeclaredMethod("set" + "Itscode" + (i + 1),
                                                            String.class);
                                                    String itscode = "";
                                                    if (ddgdList.get(i).getGd003().equals(ddgdList.get(i).getGd005())) {
                                                        itscode = "00"; // 标准
                                                    } else {
                                                        Bomsub bomsub = bomsubBean.findByPKItnbrs(ddgc.getGc006(), ddgdList.get(i).getGd007(),
                                                                ddgdList.get(i).getGd005());
                                                        if (null != bomsub) {
                                                            if (bomsub.getSeqnr() < 10) {
                                                                itscode = "0" + bomsub.getSeqnr();
                                                            } else {
                                                                itscode = String.valueOf(bomsub.getSeqnr());
                                                            }
                                                        } else {
                                                            log4j.error("订单规格表查询异常!");
                                                        }
                                                    }
                                                    setMethod3.invoke(cqbomsub, itscode);
                                                    // setMethod3.invoke(cqbomsub, ddgdList.get(i).getGd004());
                                                    Method setMethod4 = cqbomsub.getClass().getDeclaredMethod("set" + "Itsdesc" + (i + 1),
                                                            String.class);
                                                    setMethod4.invoke(cqbomsub, ddgdList.get(i).getGd004());
                                                    Method setMethod5 = cqbomsub.getClass().getDeclaredMethod("set" + "Itnbrs" + (i + 1),
                                                            String.class);
                                                    setMethod4.invoke(cqbomsub, ddgdList.get(i).getGd005());
                                                }

                                            }
                                            cdrqbomsubBean.persist(cqbomsub);
                                            // throw new RuntimeException("第" + qdpk.getTrseq() +
                                            // 笔订单规格表尚未维护不可确认!");
                                        }
                                    }
                                }
                                addedDetail.add(qd);
                            } else if (rb.getPb010().compareTo(BigDecimal.ZERO) > 0) {
                                reppbasry.add(rb);
                            }
                        }
                        // 维护订单配件
                        List<Cdrqasry> cqasryadd = new ArrayList();
                        if (wi_s_acesoryyn == 'Y') {
                            // 获取CRM表身明细中的赠品配件，根据品号分组
                            if (reppbasry.size() > 0) {
                                for (Cdrqdta qdadd : addedDetail) {
                                    int k = 0;
                                    for (int j = 0; j < reppbasry.size(); j++) {
                                        if (reppbasry.get(j).getPb519().equals(qdadd.getItnbr())) {
                                            k++;
                                            Cdrqasry cqasry = new Cdrqasry();
                                            CdrqasryPK cqasrypk = new CdrqasryPK();
                                            cqasrypk.setFacno(facno);
                                            cqasrypk.setQuono(lsquono);
                                            cqasrypk.setTrseq(qdadd.getCdrqdtaPK().getTrseq()); // 报价单身序号
                                            cqasrypk.setSeq((short) k); // 配件表身序号
                                            String ls_dmark = "";
                                            if (qdadd.getDmark1() == null || "".equals(qdadd.getDmark1())) {
                                                if (qdadd.getDmark2() == null || "".equals(qdadd.getDmark2())) {
                                                } else {
                                                    ls_dmark = qdadd.getDmark2();
                                                }
                                            } else {
                                                ls_dmark = qdadd.getDmark1();
                                            }
                                            if (bomasryBean.findByItnbrfAndCmccode(qdadd.getItnbr(), ls_dmark) == null) {
                                                ls_dmark = "9";
                                            }
                                            cqasrypk.setCmccode(ls_dmark);
                                            cqasry.setCdrqasryPK(cqasrypk);
                                            cqasry.setItnbr(reppbasry.get(j).getPb004());
                                            cqasry.setItnbrf(qdadd.getItnbr());
                                            cqasry.setProsscode("");
                                            cqasry.setStdqty(reppbasry.get(j).getPb010());
                                            cqasry.setStdpar((short) 1);
                                            cqasry.setBadrat(BigDecimal.ZERO);
                                            cqasryadd.add(cqasry);
                                            // cdrqasryBean.persist(cqasry);
                                        }
                                    }
                                }
                            }
                        }
                        // qh.setLevelp(facno);
                        // qh.setOacfuser("");
                        // qh.setCuspono();
                        qh.setApprresno(ra.getPa520()); // 审批原因
                        // qh.setWarranty(Short.MAX_VALUE);
                        // qh.setNewcusna(facno);

                        String quono = cdrqsysBean.getSerialno(facno, quodate, decode, true, "CDR225");
                        if (!quono.equals(lsquono)) {
                            throw new RuntimeException("报价单号产生错误，请确认");
                        }
                        qhpk.setQuono(quono); // 报价单号
                        qh.setCdrqhadPK(qhpk);

                        cdrqhadBean.setCompany(facno);
                        cdrqhadBean.persist(qh);
                        cdrqhadBean.persistDetailList(facno, addedDetail);
                        if (cqasryadd.size() > 0) {
                            for (Cdrqasry cqasry : cqasryadd) {
                                cdrqasryBean.persist(cqasry);
                            }
                        }
                        // 在报价单头显示备注
                        Cdrqhdsc cqdsc = new Cdrqhdsc();
                        CdrqhdscPK cqdscpk = new CdrqhdscPK();
                        cqdscpk.setFacno(facno);
                        cqdscpk.setQuono(quono);
                        cqdsc.setCdrqhdscPK(cqdscpk);
                        cqdsc.setMark1(pa001 + pa002);
                        cdrqhdscBean.setCompany(facno);
                        cdrqhdscBean.persist(cqdsc);
                        ra.setPa027("Y");
                        ra.setPa519(quono);
                        reppaBean.update(ra);

                        // 确认
                    }
                }
            }
        } catch (Exception ex) {
            log4j.error("CRM估计单抛转轮询时异常", ex);
            throw new RuntimeException("资料库查询发生错误！--" + ex);
        }
        log4j.info("CRM估计单抛转轮询");
    }

    @Schedule(minute = "*/11", hour = "7-23", persistent = false)
    public void syncInterCompanyTransactions() {
        log4j.info("ERP集团内部交易互转轮询开始");
        this.createERPCDR310ByERPPUR410("H", "HSH00003", "00", "C", "SZJ00065", "20190601");// SHB->汉声
        this.createERPCDR310ByERPPUR410("C", "SGD00088", "00", "G", "SSH00307", "20191223");// 广州->SHB
        this.createERPCDR310ByERPPUR410("C", "SSD00107", "00", "J", "SSH00307", "20191223");// 济南->SHB
        this.createERPCDR310ByERPPUR410("C", "SJS00254", "00", "N", "SSH00307", "20191223");// 南京->SHB
        this.createERPCDR310ByERPPUR410("C", "SCQ00146", "00", "C4", "SSH00307", "20191223");// 重庆->SHB
        this.createERPCDR310ByExchPUR415("C", "STW00003", "00", "A", "86005", "20200408");// THB->SHB
        this.createERPCDR310ByExchPUR415("C", "STW00003", "00", "A", "86005-1", "20200430");// THB->SHB Service
        this.createERPCDR310ByExchPUR415("K", "KTW00004", "00", "A", "86010 ", "20200408");// THB->Comer
        this.createERPCDR310ByExchPUR415("H", "HTW00001", "00", "A", "1139 ", "20200408");// THB->Hanson
        this.syncThirdPartyTradingByERPPUR410("H", "HSH00003", "HZJ00030", "C", "SZJ00065", "SZJ00101", "20190901", false);// 科恩特
        this.syncThirdPartyTradingByERPPUR410("H", "HSH00003", "HSH00247", "C", "SZJ00065", "SSH01164", "20190901", false);// 卓准
        this.syncThirdPartyTradingByERPPUR410("H", "HSH00003", "HHB00007", "C", "SZJ00065", "SHB00016", "20190901", false);// 恒工
        this.syncThirdPartyTradingByERPPUR410("H", "HSH00003", "HJS00129", "C", "SZJ00065", "SJS00291", "20200101", false);// 腾达
        //this.syncThirdPartyTradingByERPPUR410("H", "HSH00003", "HSH00087", "C", "SZJ00065", "SSH00229", "20190801", true);// 海光
        this.syncThirdPartyTradingByERPMAN275("H", "C", "20190901");// 催料
        this.syncERPPUR410ToExchange("C", "STW00007", "20200408");// SHB->Exch
        this.syncERPPUR410ToExchange("C", "STW00035", "20200408");// SHB->Exch
        this.syncERPPUR410ToExchange("C", "SXG00007", "20200408");// SHB->Exch
        this.syncERPPUR410ToExchange("K", "KTW00001", "20200408");// Comer->Exch
        log4j.info("ERP集团内部交易互转轮询结束");
    }

    private void createERPCDR310ByERPPUR410(String cc, String cusno, String pricingtype, String pc, String vdrno, String beginDate) {
        Date d;
        try {
            d = BaseLib.getDate("yyyyMMdd", beginDate);
        } catch (Exception ex) {
            d = BaseLib.getDate();
        }
        eapMailBean.clearReceivers();
        purvdrBean.setCompany(pc);
        purvdrrelBean.setCompany(pc);
        purhadBean.setCompany(pc);
        Purvdr purvdr = purvdrBean.findByVdrno(vdrno);
        if (purvdr == null) {
            return;
        }
        List<Purhad> purhadList = purhadBean.findNeedThrowByVdrno(vdrno, d);
        if (purhadList != null && !purhadList.isEmpty()) {
            StringBuilder msgBuilder = new StringBuilder();
            StringBuilder errorBuilder = new StringBuilder();
            String temp;
            Date indate;
            Date recdate;
            String cdrno = "";
            msgBuilder.append("<div>各位好</div>");
            try {
                indate = BaseLib.getDate();
                recdate = BaseLib.getDate("yyyy-MM-dd", BaseLib.formatDate("yyyy-MM-dd", indate));
                cdrsysBean.setCompany(cc);
                cdrcusBean.setCompany(cc);
                cdrcusmanBean.setCompany(cc);
                cdrhmasBean.setCompany(cc);
                cdrdmasBean.setCompany(cc);
                invmasBean.setCompany(cc);
                miscodeBean.setCompany(cc);
                secuserBean.setCompany(cc);
                Cdrcus cdrcus = cdrcusBean.findByCusno(cusno);
                if (cdrcus == null) {
                    temp = "createERPCDR310ByERPPUR410遇到错误：" + cc + "公司ERP中" + cusno + "客户不存在";
                    log4j.error(temp);
                    errorBuilder.append(temp);
                    throw new RuntimeException(cc + "公司ERP中" + cusno + "客户不存在");
                }
                Cdrcusman cdrcusman = cdrcusmanBean.findByPK(cc, cusno);
                if (cdrcusman == null) {
                    temp = "createERPCDR310ByERPPUR410遇到错误：" + cc + "公司ERP中客户对应业务员资料不存在";
                    log4j.error(temp);
                    errorBuilder.append(temp);
                    throw new RuntimeException(cc + "公司ERP中客户对应业务员资料不存在");
                }
                Secuser secuser = secuserBean.findByUserno(cdrcusman.getMan());
                if (secuser == null || secuser.getPdepno() == null || "".equals(secuser.getPdepno())) {
                    temp = "createERPCDR310ByERPPUR410遇到错误：" + cc + "公司ERP中业务员对应员工资料不存在或不完整";
                    log4j.error(temp);
                    errorBuilder.append(temp);
                    throw new RuntimeException(cc + "公司ERP中业务员对应员工资料不存在或不完整");
                }
                String pono = "", judco;
                BigDecimal tramts = BigDecimal.ZERO;
                BigDecimal taxamts = BigDecimal.ZERO;
                BigDecimal totamts = BigDecimal.ZERO;
                Cdrhmas ch;
                Cdrdmas cd;
                Invmas item;
                List<Cdrdmas> addedCdrdmas = new ArrayList<>();
                HashMap<SuperEJBForERP, List<?>> detailAdded = new LinkedHashMap<>();
                detailAdded.put(cdrdmasBean, addedCdrdmas);
                short seq;
                for (Purhad ph : purhadList) {
                    pono = ph.getPurhadPK().getPono();
                    seq = 0;
                    purhadBean.setDetail(ph.getPurhadPK().getPono());
                    List<Purdta> purdtaList = purhadBean.getDetailList();
                    if (purdtaList == null || purdtaList.isEmpty()) {
                        continue;
                    }
                    addedCdrdmas.clear();
                    for (Purdta pd : purdtaList) {
                        if (pd.getDposta().equals("20") || pd.getDposta().equals("30")) {
                            item = invmasBean.findByItnbr(pd.getItnbr());
                            if (item == null) {
                                errorBuilder.append("<div>createERPCDR310ByERPPUR410遇到错误：").append(cc).append("公司ERP中").append(pd.getItnbr()).append("品号不存在").append("</div>");
                                continue;
                            }
                            // judco = item.getJudco().substring(1, 1) + item.getJudco().substring(4);
                            // if (!judco.equals(pd.getJudco())) {
                            // errorBuilder.append("createERPCDR310ByERPPUR410遇到错误：").append(pd.getItnbr()).append("品号单位设置不一致").append("<br/>");
                            // continue;
                            // }
                            seq++;
                            cd = new Cdrdmas(cc, "", seq);
                            cd.setItnbr(pd.getItnbr());
                            cd.setItnbrcus("");
                            cd.setProno("1");
                            cd.setShptrseq(cdrcus.getShptrseq());
                            cd.setIvotrseq(cdrcus.getIvotrseq());
                            cd.setCdrqy1(pd.getPoqy1());// 需要处理单位换算问题
                            cd.setCdrqy2(pd.getPoqy2());
                            cd.setArmqy(pd.getApmqy());
                            cd.setUnpris(pd.getUnpris());
                            cd.setOutdate(pd.getAskdate());
                            cd.setCdrdate(pd.getAskdate());
                            cd.setTramts(pd.getTramts());
                            cd.setDrecsta("10");
                            cd.setUnprisrccode('1');
                            addedCdrdmas.add(cd);
                            // 计算合计金额
                            tramts = tramts.add(pd.getTramts());
                            totamts = totamts.add(pd.getTramts());
                        }
                    }
                    if (!addedCdrdmas.isEmpty()) {
                        // 设置邮件收件人
                        if (secuser.getEmail() != null && !"".equals(secuser.getEmail().trim())) {
                            eapMailBean.addTo(secuser.getEmail());
                        }
                        List<Purvdrrel> vdrrelList = purvdrrelBean.findByVdrno(vdrno);
                        if (vdrrelList != null && !vdrrelList.isEmpty()) {
                            for (Purvdrrel r : vdrrelList) {
                                if (r.getEmail() != null && !"".equals(r.getEmail().trim())) {
                                    eapMailBean.addTo(r.getEmail());
                                }
                            }
                        }
                    }
                    if (!addedCdrdmas.isEmpty()) {
                        ch = new Cdrhmas(cc, "");
                        ch.setCusno(cusno);
                        ch.setCdrcode('A');
                        ch.setDepno(secuser.getPdepno());
                        ch.setRecdate(recdate);
                        ch.setDecode(ph.getDecode());
                        ch.setShptrseq(cdrcus.getShptrseq());
                        ch.setIvotrseq(cdrcus.getIvotrseq());
                        ch.setPricingtype(pricingtype);
                        ch.setHrecsta('N');
                        ch.setTax(ph.getTax());
                        ch.setTaxrate(ph.getTaxrate());
                        ch.setCoin(ph.getCoin());
                        ch.setRatio(ph.getRatio());
                        ch.setSndcode(cdrcus.getSndcode());
                        ch.setPaycode(cdrcus.getPaycode());
                        ch.setTermcode(ph.getTermcode());
                        ch.setSndcodedsc(miscodeBean.findByPK("GD", cdrcus.getSndcode()).getCdesc());
                        ch.setPaycodedsc(ph.getPaycodedsc());
                        ch.setTermcodedsc(ph.getTermcodedsc());
                        // 客户基础资料代值
                        ch.setPaysepcode(cdrcus.getPaysepcode());
                        ch.setSeldate1(cdrcus.getSeldate1());
                        ch.setSeldate2(cdrcus.getSeldate2());
                        ch.setSeldate3(cdrcus.getSeldate3());
                        ch.setSeldate4(cdrcus.getSeldate4());
                        ch.setHandays1(cdrcus.getHandays1());
                        ch.setHandays2(cdrcus.getHandays2());
                        ch.setHandays3(cdrcus.getHandays3());
                        ch.setHandays4(cdrcus.getHandays4());
                        ch.setTickdays(cdrcus.getTickdays());
                        ch.setSacode(cdrcus.getSacode());
                        ch.setAreacode(cdrcus.getAreacode());
                        ch.setCuycode(cdrcus.getCuycode());
                        // 设置负责业务
                        ch.setMancode(cdrcusman.getMan());
                        // 计算表头金额税额
                        switch (ph.getTax()) {
                            case '1':
                                ch.setTramts(tramts);
                                ch.setTaxamts(tramts.multiply(ch.getTaxrate()));
                                ch.setTotamts(ch.getTramts().add(ch.getTaxamts()));
                                break;
                            case '4':
                                ch.setTotamts(totamts);
                                ch.setTramts(totamts.divide(ch.getTaxrate().add(BigDecimal.ONE), 2, RoundingMode.HALF_UP));
                                ch.setTaxamts(totamts.subtract(ch.getTramts()));
                                break;
                            default:
                                ch.setTramts(tramts);
                                ch.setTaxamts(BigDecimal.ZERO);
                                ch.setTotamts(tramts);
                        }
                        ch.setIndate(indate);
                        ch.setUserno(cdrcusman.getMan());
                        ch.setCuspono(ph.getPurhadPK().getPono());
                        // 设置订单编号
                        cdrno = cdrsysBean.getSerialNumber(cc, "", "A", recdate, ph.getDecode(), true, "CDR310");
                        ch.getCdrhmasPK().setCdrno(cdrno);
                        cdrhmasBean.persist(ch);
                        cdrhmasBean.getEntityManager().flush();
                        for (Cdrdmas e : addedCdrdmas) {
                            e.getCdrdmasPK().setCdrno(cdrno);
                            cdrdmasBean.persist(e);
                        }
                        ph.setFromcdrno(cdrno);
                        purhadBean.update(ph);
                        msgBuilder.append(String.format("<div>执行%s成功：%s公司采购单%s抛转成%s公司订单%s", "createERPCDR310ByERPPUR410", pc, pono, cc, cdrno)).append("</div>");
                        msgBuilder.append("<div>来源采购单").append(purdtaList.size()).append("笔明细").append("产生新订单").append(seq).append("笔明细").append("</div>");
                    } else {
                        msgBuilder.append(String.format("<div>执行%s成功：%s公司采购单%s，PASS", "createERPCDR310ByERPPUR410", pc, pono)).append("</div>");
                        ph.setFromcdrno("PASS");
                        purhadBean.update(ph);
                    }
                }
                log4j.info(msgBuilder.toString());
            } catch (RuntimeException | ParseException ex) {
                errorBuilder.append(ex.toString());
                log4j.error("createERPCDR310ByERPPUR410遇到错误", ex);
                throw new RuntimeException(errorBuilder.toString());
            } finally {
                if (!eapMailBean.getTo().isEmpty() || !eapMailBean.getCc().isEmpty()) {
                    eapMailBean.setMailSubject("ERP系统新订单" + cdrno);
                    msgBuilder.append("<div>").append(errorBuilder.toString()).append("</div>");
                    eapMailBean.setHTMLMailContent(msgBuilder.toString());
                    eapMailBean.notify(new cn.hanbell.eap.comm.MailNotify());
                }
            }
        }
    }

    private void createERPCDR310ByExchPUR415(String cc, String cusno, String pricingtype, String pc, String vdrno, String beginDate) {
        Date d;
        try {
            d = BaseLib.getDate("yyyyMMdd", beginDate);
        } catch (Exception ex) {
            d = BaseLib.getDate();
        }
        eapMailBean.clearReceivers();
        List<tw.hanbell.exch.entity.Purhad> exchPurhadList = exchPurhadBean.findNeedThrowByVdrno(vdrno, d);
        if (exchPurhadList != null && !exchPurhadList.isEmpty()) {
            StringBuilder msgBuilder = new StringBuilder();
            StringBuilder errorBuilder = new StringBuilder();
            String temp;
            Date indate;
            Date recdate;
            String cdrno = "";
            msgBuilder.append("<div>各位好</div>");
            try {
                indate = BaseLib.getDate();
                recdate = BaseLib.getDate("yyyy-MM-dd", BaseLib.formatDate("yyyy-MM-dd", indate));
                cdrsysBean.setCompany(cc);
                cdrcitnbrBean.setCompany(cc);
                cdrcusBean.setCompany(cc);
                cdrcusmanBean.setCompany(cc);
                cdrcusrelBean.setCompany(cc);
                cdrhmasBean.setCompany(cc);
                cdrdmasBean.setCompany(cc);
                invmasBean.setCompany(cc);
                miscodeBean.setCompany(cc);
                misrateBean.setCompany(cc);
                secuserBean.setCompany(cc);
                Cdrcus cdrcus = cdrcusBean.findByCusno(cusno);
                if (cdrcus == null) {
                    temp = "createERPCDR310ByExchPUR415遇到错误：" + cc + "公司ERP中" + cusno + "客户不存在";
                    log4j.error(temp);
                    errorBuilder.append(temp);
                    throw new RuntimeException(cc + "公司ERP中" + cusno + "客户不存在");
                }
                Cdrcusman cdrcusman = cdrcusmanBean.findByPK(cc, cusno);
                if (cdrcusman == null) {
                    temp = "createERPCDR310ByExchPUR415遇到错误：" + cc + "公司ERP中客户对应业务员资料不存在";
                    log4j.error(temp);
                    errorBuilder.append(temp);
                    throw new RuntimeException(cc + "公司ERP中客户对应业务员资料不存在");
                }
                Secuser secuser = secuserBean.findByUserno(cdrcusman.getMan());
                if (secuser == null || secuser.getPdepno() == null || "".equals(secuser.getPdepno())) {
                    temp = "createERPCDR310ByExchPUR415遇到错误：" + cc + "公司ERP中业务员对应员工资料不存在或不完整";
                    log4j.error(temp);
                    errorBuilder.append(temp);
                    throw new RuntimeException(cc + "公司ERP中业务员对应员工资料不存在或不完整");
                }
                int i, j;
                String k;
                String pono = "";
                BigDecimal tramts = BigDecimal.ZERO;
                BigDecimal taxamts = BigDecimal.ZERO;
                BigDecimal totamts = BigDecimal.ZERO;
                Cdrhmas ch;
                Cdrdmas cd;
                Cdrcitnbr citnbr;
                Invmas item;
                Secuser contacter = null;
                List<Cdrdmas> addedCdrdmas = new ArrayList<>();
                HashMap<SuperEJBForERP, List<?>> detailAdded = new LinkedHashMap<>();
                detailAdded.put(cdrdmasBean, addedCdrdmas);
                short seq;
                for (tw.hanbell.exch.entity.Purhad ph : exchPurhadList) {
                    pono = ph.getPurhadPK().getPono();
                    seq = 0;
                    List<tw.hanbell.exch.entity.Purdta> exchPurdtaList = exchPurhadBean.getDetailList(ph.getPurhadPK().getPono());
                    if (exchPurdtaList == null || exchPurdtaList.isEmpty()) {
                        continue;
                    }
                    addedCdrdmas.clear();
                    for (tw.hanbell.exch.entity.Purdta pd : exchPurdtaList) {
                        if (pd.getDposta().equals("20") || pd.getDposta().equals("30")) {
                            item = invmasBean.findByItnbr(pd.getItnbr());
                            if (item == null || Objects.equals("N", item.getNStopyn())) {
                                j = pd.getItnbr().indexOf("-");
                                k = pd.getItnbr().substring(0, 1);
                                if (j == 4 && (k.equals("1") || k.equals("2") || k.equals("3"))) {
                                    // 1,2,3字头前面是4码，加入中间3字码
                                    k = pd.getItnbr().substring(0, 2) + "3" + pd.getItnbr().substring(2);
                                    item = invmasBean.findByItnbr(k);
                                    if (item == null) {
                                        errorBuilder.append("<div>createERPCDR310ByExchPUR415遇到错误：").append(cc).append("公司ERP中").append(pd.getItnbr()).append("品号不存在").append("</div>");
                                    }
                                }
                            }
                            seq++;
                            cd = new Cdrdmas(cc, "", seq);
                            cd.setItnbr(item == null ? pd.getItnbr() : item.getItnbr());
                            // 处理客户品号
                            citnbr = cdrcitnbrBean.findByPK(cusno, cd.getItnbr(), null);
                            if (citnbr == null) {
                                cd.setItnbrcus("");
                            } else {
                                cd.setItnbrcus(citnbr.getCdrcitnbrPK().getItnbrcus());
                            }
                            cd.setProno("1");
                            cd.setShptrseq(cdrcus.getShptrseq());
                            cd.setIvotrseq(cdrcus.getIvotrseq());
                            cd.setCdrqy1(pd.getPoqy1());// 需要处理单位换算问题
                            cd.setCdrqy2(pd.getPoqy2());
                            cd.setArmqy(pd.getApmqy());
                            cd.setUnpris(pd.getUnpris());
                            cd.setOutdate(pd.getAskdate());
                            cd.setCdrdate(pd.getAskdate());
                            cd.setTramts(pd.getTramts());
                            cd.setDrecsta("10");
                            cd.setUnprisrccode('1');
                            addedCdrdmas.add(cd);
                            // 计算合计金额
                            tramts = tramts.add(pd.getTramts());
                            totamts = totamts.add(pd.getTramts());
                        }
                    }
                    if (!addedCdrdmas.isEmpty()) {
                        if (ph.getNContacter() != null && !"".equals(ph.getNContacter())) {
                            contacter = secuserBean.findByUserno(ph.getNContacter());
                        }
                        // 设置邮件收件人
                        if (contacter != null && contacter.getEmail() != null && !"".equals(contacter.getEmail().trim())) {
                            eapMailBean.addTo(contacter.getEmail());
                        } else {
                            if (secuser.getEmail() != null && !"".equals(secuser.getEmail().trim())) {
                                eapMailBean.addTo(secuser.getEmail());
                            }
                        }
                        List<Cdrcusrel> cusrelList = cdrcusrelBean.findByCusno(cusno);
                        if (cusrelList != null && !cusrelList.isEmpty()) {
                            for (Cdrcusrel r : cusrelList) {
                                if (r.getEmail() != null && !"".equals(r.getEmail().trim())) {
                                    eapMailBean.addTo(r.getEmail());
                                }
                            }
                        }
                    }
                    if (!addedCdrdmas.isEmpty()) {
                        ch = new Cdrhmas(cc, "");
                        ch.setCusno(cusno);
                        ch.setCdrcode('A');
                        ch.setDepno(contacter == null ? secuser.getPdepno() : contacter.getPdepno());
                        ch.setRecdate(recdate);
                        ch.setDecode(ph.getDecode().charAt(0));
                        ch.setShptrseq(cdrcus.getShptrseq());
                        ch.setIvotrseq(cdrcus.getIvotrseq());
                        ch.setPricingtype(pricingtype);
                        ch.setHrecsta('N');
                        ch.setTax(ph.getTax().charAt(0));
                        ch.setTaxrate(ph.getTaxrate());
                        ch.setCoin(ph.getCoin());
                        if (ch.getCoin().equals("RMB") || ch.getCoin().equals("CNY")) {
                            ch.setRatio(BigDecimal.ONE);
                        } else {
                            Misrate misrate = misrateBean.findByCoin(ch.getCoin());
                            ch.setRatio(misrate.getOrate());// 出口汇率
                        }
                        ch.setSndcode(cdrcus.getSndcode());
                        ch.setPaycode(cdrcus.getPaycode());
                        ch.setTermcode(ph.getTermcode());
                        ch.setSndcodedsc(miscodeBean.findByPK("GD", cdrcus.getSndcode()).getCdesc());
                        ch.setPaycodedsc(ph.getPaycodedsc());
                        ch.setTermcodedsc(ph.getTermcodedsc());
                        // 客户基础资料代值
                        ch.setPaysepcode(cdrcus.getPaysepcode());
                        ch.setSeldate1(cdrcus.getSeldate1());
                        ch.setSeldate2(cdrcus.getSeldate2());
                        ch.setSeldate3(cdrcus.getSeldate3());
                        ch.setSeldate4(cdrcus.getSeldate4());
                        ch.setHandays1(cdrcus.getHandays1());
                        ch.setHandays2(cdrcus.getHandays2());
                        ch.setHandays3(cdrcus.getHandays3());
                        ch.setHandays4(cdrcus.getHandays4());
                        ch.setTickdays(cdrcus.getTickdays());
                        ch.setSacode(cdrcus.getSacode());
                        ch.setAreacode(cdrcus.getAreacode());
                        ch.setCuycode(cdrcus.getCuycode());
                        // 设置负责业务
                        ch.setMancode(cdrcusman.getMan());
                        // 计算表头金额税额
                        switch (ch.getTax()) {
                            case '1':
                                ch.setTramts(tramts);
                                ch.setTaxamts(tramts.multiply(ch.getTaxrate()));
                                ch.setTotamts(ch.getTramts().add(ch.getTaxamts()));
                                break;
                            case '4':
                                ch.setTotamts(totamts);
                                ch.setTramts(totamts.divide(ch.getTaxrate().add(BigDecimal.ONE), 2, RoundingMode.HALF_UP));
                                ch.setTaxamts(totamts.subtract(ch.getTramts()));
                                break;
                            default:
                                ch.setTramts(tramts);
                                ch.setTaxamts(BigDecimal.ZERO);
                                ch.setTotamts(tramts);
                        }
                        ch.setIndate(indate);
                        ch.setUserno(contacter == null ? cdrcusman.getMan() : contacter.getUserno());
                        ch.setCuspono(ph.getPurhadPK().getPono());
                        // 设置订单编号
                        cdrno = cdrsysBean.getSerialNumber(cc, "", "A", recdate, ch.getDecode(), true, "CDR310");
                        ch.getCdrhmasPK().setCdrno(cdrno);
                        cdrhmasBean.persist(ch);
                        cdrhmasBean.getEntityManager().flush();
                        for (Cdrdmas e : addedCdrdmas) {
                            e.getCdrdmasPK().setCdrno(cdrno);
                            cdrdmasBean.persist(e);
                        }
                        ph.setFromcdrno(cdrno);
                        exchPurhadBean.update(ph);
                        msgBuilder.append(String.format("<div>执行%s成功：%s公司采购单%s抛转成%s公司订单%s", "createERPCDR310ByExchPUR415", pc, pono, cc, cdrno)).append("</div>");
                        msgBuilder.append("<div>来源采购单").append(exchPurdtaList.size()).append("笔明细").append("产生新订单").append(seq).append("笔明细").append("</div>");
                    } else {
                        msgBuilder.append(String.format("<div>执行%s成功：%s公司采购单%s，PASS", "createERPCDR310ByExchPUR415", pc, pono)).append("</div>");
                        ph.setFromcdrno("PASS");
                        exchPurhadBean.update(ph);
                    }
                }
                log4j.info(msgBuilder.toString());
            } catch (Exception ex) {
                errorBuilder.append(ex.toString());
                log4j.error("createERPCDR310ByExchPUR415遇到错误", ex);
                throw new RuntimeException(errorBuilder.toString());
            } finally {
                if (!eapMailBean.getTo().isEmpty() || !eapMailBean.getCc().isEmpty()) {
                    eapMailBean.setMailSubject("ERP系统新订单" + cdrno);
                    msgBuilder.append("<div>").append(errorBuilder.toString()).append("</div>");
                    eapMailBean.setHTMLMailContent(msgBuilder.toString());
                    eapMailBean.notify(new cn.hanbell.eap.comm.MailNotify());
                }
            }
        }
    }

    private void syncERPPUR410ToExchange(String pc, String vdrno, String beginDate) {
        Date d;
        try {
            d = BaseLib.getDate("yyyyMMdd", beginDate);
        } catch (Exception ex) {
            d = BaseLib.getDate();
        }
        purvdrBean.setCompany(pc);
        purvdrrelBean.setCompany(pc);
        purhadBean.setCompany(pc);
        Purvdr purvdr = purvdrBean.findByVdrno(vdrno);
        if (purvdr == null) {
            return;
        }
        List<Purhad> purhadList = purhadBean.findNeedThrowByVdrno(vdrno, d);
        if (purhadList != null && !purhadList.isEmpty()) {
            for (Purhad ph : purhadList) {
                try {
                    purhadBean.setDetail(ph.getPurhadPK().getPono());
                    List<Purdta> purdtaList = purhadBean.getDetailList();
                    if (purdtaList != null && !purdtaList.isEmpty()) {
                        for (int x = 0; x < purdtaList.size() && purdtaList.size() > 0; x++) {
                            Purdta pd = purdtaList.get(x);
                            if (!pd.getDposta().equals("20") && !pd.getDposta().equals("30")) {
                                purdtaList.remove(pd);
                                x--;
                            }
                        }
                        if (!purdtaList.isEmpty()) {
                            exchangeSHBBean.persist(ph, purdtaList);
                            exchangeSHBBean.getEntityManager().flush();
                            exchangeSHBBean.getEntityManager().clear();
                        }
                        ph.setFromcdrno(ph.getPurhadPK().getPono());
                        purhadBean.update(ph);
                    }
                    log4j.info("成功执行choneERPPUR410ToExchange");
                } catch (Exception ex) {
                    log4j.error("choneERPPUR410ToExchange遇到错误", ex);
                }
            }
        }
    }

    private void syncThirdPartyTradingByERPPUR410(String tofacno, String tocusno, String tovdrno, String facno,
            String thirdvdrno, String vdrno, String beginDate, boolean fullTrading) {
        Date d;
        try {
            d = BaseLib.getDate("yyyyMMdd", beginDate);
        } catch (Exception ex) {
            d = BaseLib.getDate();
        }
        String tobuyer;
        eapMailBean.clearReceivers();
        Purvdr purvdr, thirdvendor, tovendor;
        List<PurvdrBuyer> buyerList;
        // 来源公司交易对象检查
        purvdrBean.setCompany(facno);
        purvdrrelBean.setCompany(facno);
        purvdr = purvdrBean.findByVdrno(vdrno);
        if (purvdr == null) {
            return;
        }
        thirdvendor = purvdrBean.findByVdrno(thirdvdrno);
        if (thirdvendor == null) {
            return;
        }
        List<Purvdrrel> vdrrelList = purvdrrelBean.findByVdrno(thirdvdrno);
        purvdrBean.getEntityManager().clear();
        purvdrrelBean.getEntityManager().clear();
        // 目的公司厂商对象检查
        purvdrBean.setCompany(tofacno);
        purvdrBuyerBean.setCompany(tofacno);
        tovendor = purvdrBean.findByVdrno(tovdrno);
        if (tovendor == null) {
            log4j.error("syncThirdPartyTradingByERPPUR410遇到错误：" + tofacno + "公司ERP中" + tovdrno + "厂商不存在");
            return;
        }
        buyerList = purvdrBuyerBean.findByVdrno(tovdrno);
        if (buyerList == null || buyerList.isEmpty()) {
            log4j.error("syncThirdPartyTradingByERPPUR410遇到错误：" + tofacno + "公司ERP中" + tovdrno + "厂商对应负责采购不存在");
            return;
        } else {
            tobuyer = buyerList.get(0).getBuyer();
        }
        purvdrBean.getEntityManager().clear();
        purvdrBuyerBean.getEntityManager().clear();
        // 目的公司客户对象检查
        cdrcusBean.setCompany(tofacno);
        cdrcusmanBean.setCompany(tofacno);
        secuserBean.setCompany(tofacno);
        Cdrcus cdrcus = cdrcusBean.findByCusno(tocusno);
        if (cdrcus == null) {
            log4j.error("syncThirdPartyTradingByERPPUR410遇到错误：" + tofacno + "公司ERP中" + tocusno + "客户不存在");
            return;
        }
        Cdrcusman cdrcusman = cdrcusmanBean.findByPK(tofacno, tocusno);
        if (cdrcusman == null) {
            log4j.error("syncThirdPartyTradingByERPPUR410遇到错误：" + tofacno + "公司ERP中" + tocusno + "客户对应业务员资料不存在");
            return;
        }
        Secuser secuser = secuserBean.findByUserno(cdrcusman.getMan());
        if (secuser == null || secuser.getPdepno() == null || "".equals(secuser.getPdepno())) {
            log4j.error("syncThirdPartyTradingByERPPUR410遇到错误：" + tofacno + "公司ERP中" + tocusno + "客户对应业务员的员工资料不存在或不完整");
            return;
        }
        cdrcusBean.getEntityManager().clear();
        cdrcusmanBean.getEntityManager().clear();
        secuserBean.getEntityManager().clear();
        // 开始处理业务逻辑
        purvdrBean.setCompany(facno);
        purhadBean.setCompany(facno);
        // 需要处理的采购单
        List<Purhad> purhadList;
        if (fullTrading) {
            purhadList = purhadBean.findNeedThrowByVdrno(vdrno, d);
            purhadBean.getEntityManager().clear();
        } else {
            purhadList = purhadBean.findNeedThrowByVdrnoAndRelyn(vdrno, d, 'Y');
            purhadBean.getEntityManager().clear();
        }
        if (purhadList != null && !purhadList.isEmpty()) {
            StringBuilder msgBuilder = new StringBuilder();
            StringBuilder errorBuilder = new StringBuilder();
            msgBuilder.append("<div>各位好</div>");
            Date indate;
            Date recdate;
            String cdrno = "";
            String pono = "";
            try {
                // 先同步缺少的品号大类和品号
                for (Purhad ph : purhadList) {
                    purhadBean.setCompany(ph.getPurhadPK().getFacno());
                    purhadBean.setDetail(ph.getPurhadPK().getPono());
                    List<Purdta> purdtaList = purhadBean.getDetailList();
                    if (purdtaList != null && !purdtaList.isEmpty()) {
                        for (Purdta pd : purdtaList) {
                            invmasBean.setCompany(facno);
                            Invmas item = invmasBean.findByItnbr(pd.getItnbr());
                            invmasBean.getEntityManager().clear();
                            // 同步品号大类
                            invclsBean.setCompany(tofacno);
                            invclsBean.persistIfNotExist(item.getInvcls());
                            invclsBean.getEntityManager().flush();
                            // 同步品号
                            invmasBean.setCompany(tofacno);
                            invmasBean.persistIfNotExist(item);
                            invmasBean.getEntityManager().flush();
                        }
                    }
                }
                // Clone采购单
                String npono, tpono;
                Purhad nph, tph;
                Purdta npd, tpd;
                List<Purdta> npdList = new ArrayList<>();
                List<Purdta> tpdList = new ArrayList<>();
                BigDecimal tramts = BigDecimal.ZERO;
                BigDecimal taxamts = BigDecimal.ZERO;
                BigDecimal totamts = BigDecimal.ZERO;
                Cdrhmas ch;
                Cdrdmas cd;
                Invmas item;
                List<Cdrdmas> addedCdrdmas = new ArrayList<>();
                short seq;
                for (Purhad ph : purhadList) {
                    log4j.info("开始转换" + ph.getPurhadPK());
                    pono = ph.getPurhadPK().getPono();
                    purdtaBean.setCompany(facno);
                    List<Purdta> purdtaList = purdtaBean.findByPono(ph.getPurhadPK().getPono());
                    purdtaBean.getEntityManager().clear();
                    if (purdtaList == null && purdtaList.isEmpty()) {
                        continue;
                    }
                    npdList.clear();
                    tpdList.clear();
                    seq = 0;
                    addedCdrdmas.clear();
                    for (Purdta pd : purdtaList) {
                        npd = (Purdta) BeanUtils.cloneBean(pd);
                        tpd = (Purdta) BeanUtils.cloneBean(pd);
                        npdList.add(npd);
                        tpdList.add(tpd);
                        if (pd.getDposta().equals("20") || pd.getDposta().equals("30")) {
                            // 订单明细
                            seq++;
                            cd = new Cdrdmas(tofacno, "", seq);
                            cd.setItnbr(pd.getItnbr());
                            cd.setItnbrcus("");
                            cd.setProno("1");
                            cd.setShptrseq((short) 1);
                            cd.setIvotrseq((short) 1);
                            cd.setCdrqy1(pd.getPoqy1());// 需要处理单位换算问题
                            cd.setCdrqy2(pd.getPoqy2());
                            cd.setArmqy(pd.getApmqy());
                            cd.setUnpris(pd.getUnpris());
                            cd.setOutdate(pd.getAskdate());
                            cd.setCdrdate(pd.getAskdate());
                            cd.setTramts(pd.getTramts());
                            cd.setDrecsta("20");
                            cd.setUnprisrccode('1');
                            addedCdrdmas.add(cd);
                            // 计算合计金额
                            tramts = tramts.add(pd.getTramts());
                            totamts = totamts.add(pd.getTramts());
                        }
                    }
                    log4j.info("产生ThirdParty订单开始");
                    // 处理订单逻辑
                    indate = BaseLib.getDate();
                    recdate = BaseLib.getDate("yyyy-MM-dd", BaseLib.formatDate("yyyy-MM-dd", indate));
                    if (!addedCdrdmas.isEmpty()) {
                        // 设置邮件收件人
                        if (secuser.getEmail() != null && !"".equals(secuser.getEmail().trim())) {
                            eapMailBean.addTo(secuser.getEmail());
                        }
                        if (vdrrelList != null && !vdrrelList.isEmpty()) {
                            for (Purvdrrel r : vdrrelList) {
                                if (r.getEmail() != null && !"".equals(r.getEmail().trim())) {
                                    eapMailBean.addTo(r.getEmail());
                                }
                            }
                        }
                    }
                    if (!addedCdrdmas.isEmpty()) {
                        ch = new Cdrhmas(tofacno, "");
                        ch.setCusno(tocusno);
                        ch.setCdrcode('A');
                        ch.setDepno(secuser.getPdepno());
                        ch.setRecdate(recdate);
                        ch.setDecode(ph.getDecode());
                        ch.setShptrseq(cdrcus.getShptrseq());
                        ch.setIvotrseq(cdrcus.getIvotrseq());
                        ch.setHrecsta('Y');
                        ch.setTax(ph.getTax());
                        ch.setTaxrate(ph.getTaxrate());
                        ch.setCoin(ph.getCoin());
                        ch.setRatio(ph.getRatio());
                        ch.setSndcode(cdrcus.getSndcode());
                        ch.setPaycode(cdrcus.getPaycode());
                        ch.setTermcode(ph.getTermcode());
                        miscodeBean.setCompany(tofacno);
                        ch.setSndcodedsc(miscodeBean.findByPK("GD", cdrcus.getSndcode()).getCdesc());
                        ch.setPaycodedsc(ph.getPaycodedsc());
                        ch.setTermcodedsc(ph.getTermcodedsc());
                        // 客户基础资料代值
                        ch.setPaysepcode(cdrcus.getPaysepcode());
                        ch.setSeldate1(cdrcus.getSeldate1());
                        ch.setSeldate2(cdrcus.getSeldate2());
                        ch.setSeldate3(cdrcus.getSeldate3());
                        ch.setSeldate4(cdrcus.getSeldate4());
                        ch.setHandays1(cdrcus.getHandays1());
                        ch.setHandays2(cdrcus.getHandays2());
                        ch.setHandays3(cdrcus.getHandays3());
                        ch.setHandays4(cdrcus.getHandays4());
                        ch.setTickdays(cdrcus.getTickdays());
                        ch.setSacode(cdrcus.getSacode());
                        ch.setAreacode(cdrcus.getAreacode());
                        ch.setCuycode(cdrcus.getCuycode());
                        // 设置负责业务
                        ch.setMancode(cdrcusman.getMan());
                        // 计算表头金额税额
                        switch (ph.getTax()) {
                            case '1':
                                ch.setTramts(tramts);
                                ch.setTaxamts(tramts.multiply(ch.getTaxrate()));
                                ch.setTotamts(ch.getTramts().add(ch.getTaxamts()));
                                break;
                            case '4':
                                ch.setTotamts(totamts);
                                ch.setTramts(totamts.divide(ch.getTaxrate().add(BigDecimal.ONE), 2, RoundingMode.HALF_UP));
                                ch.setTaxamts(totamts.subtract(ch.getTramts()));
                                break;
                            default:
                                ch.setTramts(tramts);
                                ch.setTaxamts(BigDecimal.ZERO);
                                ch.setTotamts(tramts);
                        }
                        ch.setIndate(indate);
                        ch.setUserno(cdrcusman.getMan());
                        ch.setCfmdate(indate);
                        ch.setCfmuserno(cdrcusman.getMan());
                        ch.setCuspono(ph.getPurhadPK().getPono() + "-" + purvdr.getVdrna());
                        // 设置订单编号
                        cdrsysBean.setCompany(tofacno);
                        cdrhmasBean.setCompany(tofacno);
                        cdrdmasBean.setCompany(tofacno);
                        cdrno = cdrsysBean.getSerialNumber(tofacno, "", "A", recdate, ph.getDecode(), true, "CDR310");
                        ch.getCdrhmasPK().setCdrno(cdrno);
                        cdrhmasBean.persist(ch);
                        cdrhmasBean.getEntityManager().flush();
                        for (Cdrdmas e : addedCdrdmas) {
                            e.getCdrdmasPK().setCdrno(cdrno);
                            cdrdmasBean.persist(e);
                        }
                        cdrdmasBean.getEntityManager().flush();
                        log4j.info("产生ThirdParty订单结束-" + cdrno);
                        log4j.info("产生ThirdParty采购单开始");
                        nph = (Purhad) BeanUtils.cloneBean(ph);
                        nph.setPurvdr(null);
                        nph.setVdrno(thirdvdrno);
                        nph.setPosrc('3');
                        nph.setTrivdrno(vdrno);
                        nph.setFromcdrno(pono);
                        nph.setFromcusno(purvdr.getVdrna());
                        pursysBean.setCompany(facno);
                        purhadBean.setCompany(facno);
                        purdtaBean.setCompany(facno);
                        npono = pursysBean.getNewPono(facno, ph.getPurhadPK().getProno(), ph.getPodate(), ph.getDecode().toString(), true);
                        nph.setPurhadPK(new PurhadPK(facno, ph.getPurhadPK().getProno(), npono));
                        purhadBean.persist(nph);
                        purhadBean.getEntityManager().flush();
                        for (Purdta e : npdList) {
                            e.setPurdtaPK(new PurdtaPK(facno, e.getPurdtaPK().getProno(), npono, e.getPurdtaPK().getTrseq()));
                            purdtaBean.persist(e);
                        }
                        purdtaBean.getEntityManager().flush();
                        pursysBean.getEntityManager().flush();
                        log4j.info("产生ThirdParty采购单结束-" + npono);

                        log4j.info("产生ActualVendor采购单开始");
                        tph = (Purhad) BeanUtils.cloneBean(ph);
                        tph.setPurvdr(null);
                        tph.setVdrno(tovdrno);
                        tph.setBuyer(tobuyer);
                        tph.setPosrc('3');
                        tph.setTrivdrno(thirdvendor.getVdrno());
                        tph.setFromcdrno(npono);
                        tph.setFromcusno(thirdvendor.getVdrna());
                        tph.setIndate(indate);
                        tph.setUserno(tobuyer);
                        tph.setCfmdate(indate);
                        tph.setCfmuserno(tobuyer);
                        invmasBean.setCompany(tofacno);
                        pursysBean.setCompany(tofacno);
                        purhadBean.setCompany(tofacno);
                        purdtaBean.setCompany(tofacno);
                        tpono = pursysBean.getNewPono(tofacno, tph.getPurhadPK().getProno(), tph.getPodate(), tph.getDecode().toString(), true);
                        tph.setPurhadPK(new PurhadPK(tofacno, tph.getPurhadPK().getProno(), tpono));
                        purhadBean.persist(tph);
                        purhadBean.getEntityManager().flush();
                        for (Purdta e : tpdList) {
                            item = invmasBean.findByItnbr(e.getItnbr());
                            if (item == null) {
                                errorBuilder.append("<div>syncThirdPartyTradingByERPPUR410遇到错误：").append(tofacno).append("公司ERP中").append(e.getItnbr()).append("品号不存在").append("</div>");
                            } else {
                                e.setJudco(item.getJudco().substring(2, 4));
                            }
                            e.setPurdtaPK(new PurdtaPK(tofacno, e.getPurdtaPK().getProno(), tpono, e.getPurdtaPK().getTrseq()));
                            purdtaBean.persist(e);
                        }
                        purdtaBean.getEntityManager().flush();
                        pursysBean.getEntityManager().flush();
                        log4j.info("产生ActualVendor采购单结束-" + tpono);
                        // 原始采购单记录订单
                        msgBuilder.append(String.format("<div>执行%s成功：%s公司采购单%s抛转成%s公司订单%s和采购单%s", "syncThirdPartyTradingByERPPUR410", facno, pono, tofacno, cdrno, tpono)).append("</div>");
                        msgBuilder.append("<div>来源采购单").append(purdtaList.size()).append("笔明细").append("产生新订单").append(seq).append("笔明细").append("</div>");
                        // 回写单号
                        purhadBean.setCompany(facno);
                        purdtaBean.setCompany(facno);
                        ph.setFromcdrno(cdrno);
                        nph.setTocdrno(tpono);
                        purhadBean.update(ph);
                        purhadBean.update(nph);
                        for (Purdta pd : purdtaList) {
                            pd.setDposta("98");
                            purdtaBean.update(pd);
                        }
                        purhadBean.getEntityManager().flush();
                        purdtaBean.getEntityManager().flush();
                    } else {
                        purhadBean.setCompany(facno);
                        ph.setFromcdrno("PASS");
                        purhadBean.update(ph);
                        purhadBean.getEntityManager().flush();
                    }
                }
                log4j.info(msgBuilder.toString());
            } catch (Exception ex) {
                errorBuilder.append(ex.toString());
                log4j.error("syncThirdPartyTradingByERPPUR410遇到错误", ex);
                throw new RuntimeException(errorBuilder.toString());
            } finally {
                if (!eapMailBean.getTo().isEmpty() || !eapMailBean.getCc().isEmpty()) {
                    eapMailBean.setMailSubject("ERP系统新订单" + cdrno);
                    msgBuilder.append("<div>").append(errorBuilder.toString()).append("</div>");
                    eapMailBean.setHTMLMailContent(msgBuilder.toString());
                    eapMailBean.notify(new cn.hanbell.eap.comm.MailNotify());
                }
            }
        }
    }

    private void syncThirdPartyTradingByERPMAN275(String tofacno, String facno, String beginDate) {
        Date d;
        try {
            d = BaseLib.getDate("yyyyMMdd", beginDate);
        } catch (Exception ex) {
            d = BaseLib.getDate();
        }
        StringBuilder msgBuilder = new StringBuilder();
        StringBuilder errorBuilder = new StringBuilder();
        List<Purdta> editedPurdta = new ArrayList<>();
        List<Purdlvsch> purdlvschList;
        try {
            // 同步催料新增
            Purdta purdta, topurdta;
            purdlvschBean.setCompany(facno);
            purdlvschList = purdlvschBean.findNeedThrowByStatus(d);
            purdlvschBean.getEntityManager().clear();
            if (purdlvschList != null && !purdlvschList.isEmpty()) {
                purdlvschBean.setCompany(tofacno);
                for (Purdlvsch p : purdlvschList) {
                    Purdlvsch np = (Purdlvsch) BeanUtils.cloneBean(p);
                    np.setPurdlvschPK(new PurdlvschPK(tofacno, p.getPurdlvschPK().getProno(), p.getRefno(),
                            p.getPurdlvschPK().getTrseq(), p.getPurdlvschPK().getSchseq()));
                    np.setSyncsta("Y");
                    purdlvschBean.persist(np);
                    purdtaBean.setCompany(facno);
                    purdta = purdtaBean.findByPK(facno, p.getPurdlvschPK().getProno(), p.getPurdlvschPK().getPono(),
                            p.getPurdlvschPK().getTrseq());
                    if (purdta != null) {
                        purdtaBean.getEntityManager().clear();
                    }
                    purdtaBean.setCompany(tofacno);
                    topurdta = purdtaBean.findByPK(tofacno, p.getPurdlvschPK().getProno(), p.getRefno(),
                            p.getPurdlvschPK().getTrseq());
                    if (topurdta != null) {
                        purdtaBean.getEntityManager().clear();
                    }
                    if (purdta != null && topurdta != null && purdta.getItnbr().equals(topurdta.getItnbr())) {
                        topurdta.setCalldate(purdta.getCalldate());
                        topurdta.setCallqy1(purdta.getCallqy1());
                        topurdta.setCallqy2(purdta.getCallqy2());
                        editedPurdta.add(topurdta);
                        p.setSyncsta("Y");
                    }
                }
                purdlvschBean.getEntityManager().flush();
                if (!editedPurdta.isEmpty()) {
                    purdtaBean.setCompany(tofacno);
                    purdtaBean.update(editedPurdta);
                    purdtaBean.getEntityManager().flush();
                }
                if (!purdlvschList.isEmpty()) {
                    purdlvschBean.setCompany(facno);
                    purdlvschBean.update(purdlvschList);
                    purdlvschBean.getEntityManager().flush();
                }
                log4j.info("执行syncThirdPartyTradingByERPMAN275,同步催料新增成功");
            }
            // 同步催料作废
            editedPurdta.clear();
            purdlvschBean.setCompany(facno);
            purdlvschList = purdlvschBean.findNeedCancelByStatus(d);
            purdlvschBean.getEntityManager().clear();
            if (purdlvschList != null && !purdlvschList.isEmpty()) {
                purdlvschBean.setCompany(tofacno);
                for (Purdlvsch p : purdlvschList) {
                    Purdlvsch np = purdlvschBean.findByPK(tofacno, p.getPurdlvschPK().getProno(), p.getRefno(),
                            p.getPurdlvschPK().getTrseq(), p.getPurdlvschPK().getSchseq());
                    if (np != null) {
                        np.setSchsta(p.getSchsta());
                        purdlvschBean.update(np);
                    }
                    purdtaBean.setCompany(facno);
                    purdta = purdtaBean.findByPK(facno, p.getPurdlvschPK().getProno(), p.getPurdlvschPK().getPono(),
                            p.getPurdlvschPK().getTrseq());
                    if (purdta != null) {
                        purdtaBean.getEntityManager().clear();
                    }
                    purdtaBean.setCompany(tofacno);
                    topurdta = purdtaBean.findByPK(tofacno, p.getPurdlvschPK().getProno(), p.getRefno(),
                            p.getPurdlvschPK().getTrseq());
                    if (topurdta != null) {
                        purdtaBean.getEntityManager().clear();
                    }
                    if (purdta != null && topurdta != null && purdta.getItnbr().equals(topurdta.getItnbr())) {
                        topurdta.setCalldate(purdta.getCalldate());
                        topurdta.setCallqy1(purdta.getCallqy1());
                        topurdta.setCallqy2(purdta.getCallqy2());
                        editedPurdta.add(topurdta);
                        p.setSyncsta("0");
                    }
                }
                purdlvschBean.getEntityManager().flush();
                if (!editedPurdta.isEmpty()) {
                    purdtaBean.setCompany(tofacno);
                    purdtaBean.update(editedPurdta);
                    purdtaBean.getEntityManager().flush();
                }
                if (!purdlvschList.isEmpty()) {
                    purdlvschBean.setCompany(facno);
                    purdlvschBean.update(purdlvschList);
                    purdlvschBean.getEntityManager().flush();
                }
                log4j.info("执行syncThirdPartyTradingByERPMAN275,同步催料作废成功");
            }
        } catch (Exception ex) {
            log4j.error(ex);
        }
    }

    // 优化抛转时件号相关字符问题
    public String filterString(String s) {
        if (s != null && !s.trim().equals("")) {
            String returnStr = s;
            try {
                String regEx = "[\\s·`!！@#￥$%^……&*（()）\\+【\\[\\]】｛{}｝\\|、\\\\；;：:‘'“”\"，,《<。.》>、/？?]";
                Pattern p = Pattern.compile(regEx);
                Matcher m = p.matcher(returnStr);
                returnStr = m.replaceAll(" ");

            } catch (Exception ex) {
                log4j.error(ex);
            }
            return returnStr;
        }
        return s;
    }

}
