/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@Entity
@Table(name = "HZ_CW030")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZCW030.findAll", query = "SELECT h FROM HZCW030 h"),
    @NamedQuery(name = "HZCW030.findByOid", query = "SELECT h FROM HZCW030 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZCW030.findByZbxzcmc", query = "SELECT h FROM HZCW030 h WHERE h.zbxzcmc = :zbxzcmc"),
    @NamedQuery(name = "HZCW030.findByZbxzc", query = "SELECT h FROM HZCW030 h WHERE h.zbxzc = :zbxzc"),
    @NamedQuery(name = "HZCW030.findByHdnFy", query = "SELECT h FROM HZCW030 h WHERE h.hdnFy = :hdnFy"),
    @NamedQuery(name = "HZCW030.findByDcbm1", query = "SELECT h FROM HZCW030 h WHERE h.dcbm1 = :dcbm1"),
    @NamedQuery(name = "HZCW030.findByFy", query = "SELECT h FROM HZCW030 h WHERE h.fy = :fy"),
    @NamedQuery(name = "HZCW030.findByDcbm2", query = "SELECT h FROM HZCW030 h WHERE h.dcbm2 = :dcbm2"),
    @NamedQuery(name = "HZCW030.findByHdnZbxzc", query = "SELECT h FROM HZCW030 h WHERE h.hdnZbxzc = :hdnZbxzc"),
    @NamedQuery(name = "HZCW030.findByFacno", query = "SELECT h FROM HZCW030 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HZCW030.findByHdnDbbm", query = "SELECT h FROM HZCW030 h WHERE h.hdnDbbm = :hdnDbbm"),
    @NamedQuery(name = "HZCW030.findBySerialNumber", query = "SELECT h FROM HZCW030 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HZCW030.findByHdnEmply", query = "SELECT h FROM HZCW030 h WHERE h.hdnEmply = :hdnEmply"),
    @NamedQuery(name = "HZCW030.findByHdnDbfy", query = "SELECT h FROM HZCW030 h WHERE h.hdnDbfy = :hdnDbfy"),
    @NamedQuery(name = "HZCW030.findByDbje2", query = "SELECT h FROM HZCW030 h WHERE h.dbje2 = :dbje2"),
    @NamedQuery(name = "HZCW030.findByEmply", query = "SELECT h FROM HZCW030 h WHERE h.emply = :emply"),
    @NamedQuery(name = "HZCW030.findByDbje1", query = "SELECT h FROM HZCW030 h WHERE h.dbje1 = :dbje1"),
    @NamedQuery(name = "HZCW030.findBySqrq", query = "SELECT h FROM HZCW030 h WHERE h.sqrq = :sqrq"),
    @NamedQuery(name = "HZCW030.findByFykm2", query = "SELECT h FROM HZCW030 h WHERE h.fykm2 = :fykm2"),
    @NamedQuery(name = "HZCW030.findByFykm1", query = "SELECT h FROM HZCW030 h WHERE h.fykm1 = :fykm1"),
    @NamedQuery(name = "HZCW030.findByDept", query = "SELECT h FROM HZCW030 h WHERE h.dept = :dept"),
    @NamedQuery(name = "HZCW030.findByPSN", query = "SELECT h FROM HZCW030 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HZCW030.findByZj", query = "SELECT h FROM HZCW030 h WHERE h.zj = :zj"),
    @NamedQuery(name = "HZCW030.findByQt", query = "SELECT h FROM HZCW030 h WHERE h.qt = :qt"),
    @NamedQuery(name = "HZCW030.findByZjje", query = "SELECT h FROM HZCW030 h WHERE h.zjje = :zjje"),
    @NamedQuery(name = "HZCW030.findByDrbm2", query = "SELECT h FROM HZCW030 h WHERE h.drbm2 = :drbm2"),
    @NamedQuery(name = "HZCW030.findByDrbm1", query = "SELECT h FROM HZCW030 h WHERE h.drbm1 = :drbm1"),
    @NamedQuery(name = "HZCW030.findByYszrzx1", query = "SELECT h FROM HZCW030 h WHERE h.yszrzx1 = :yszrzx1"),
    @NamedQuery(name = "HZCW030.findByDbfy", query = "SELECT h FROM HZCW030 h WHERE h.dbfy = :dbfy"),
    @NamedQuery(name = "HZCW030.findByXmxz", query = "SELECT h FROM HZCW030 h WHERE h.xmxz = :xmxz"),
    @NamedQuery(name = "HZCW030.findByYszrzx2", query = "SELECT h FROM HZCW030 h WHERE h.yszrzx2 = :yszrzx2"),
    @NamedQuery(name = "HZCW030.findByHdnQt", query = "SELECT h FROM HZCW030 h WHERE h.hdnQt = :hdnQt"),
    @NamedQuery(name = "HZCW030.findByFyxmmc", query = "SELECT h FROM HZCW030 h WHERE h.fyxmmc = :fyxmmc"),
    @NamedQuery(name = "HZCW030.findByQttxt", query = "SELECT h FROM HZCW030 h WHERE h.qttxt = :qttxt"),
    @NamedQuery(name = "HZCW030.findByHdnZj", query = "SELECT h FROM HZCW030 h WHERE h.hdnZj = :hdnZj"),
    @NamedQuery(name = "HZCW030.findByBmzgyj", query = "SELECT h FROM HZCW030 h WHERE h.bmzgyj = :bmzgyj"),
    @NamedQuery(name = "HZCW030.findByDrkm1", query = "SELECT h FROM HZCW030 h WHERE h.drkm1 = :drkm1"),
    @NamedQuery(name = "HZCW030.findByCwyj", query = "SELECT h FROM HZCW030 h WHERE h.cwyj = :cwyj"),
    @NamedQuery(name = "HZCW030.findByDrkm2", query = "SELECT h FROM HZCW030 h WHERE h.drkm2 = :drkm2"),
    @NamedQuery(name = "HZCW030.findByDckm1", query = "SELECT h FROM HZCW030 h WHERE h.dckm1 = :dckm1"),
    @NamedQuery(name = "HZCW030.findByDckm2", query = "SELECT h FROM HZCW030 h WHERE h.dckm2 = :dckm2"),
    @NamedQuery(name = "HZCW030.findByDbbm", query = "SELECT h FROM HZCW030 h WHERE h.dbbm = :dbbm"),
    @NamedQuery(name = "HZCW030.findByXzlb", query = "SELECT h FROM HZCW030 h WHERE h.xzlb = :xzlb"),
    @NamedQuery(name = "HZCW030.findBySqly", query = "SELECT h FROM HZCW030 h WHERE h.sqly = :sqly"),
    @NamedQuery(name = "HZCW030.findByZjlyj", query = "SELECT h FROM HZCW030 h WHERE h.zjlyj = :zjlyj"),
    @NamedQuery(name = "HZCW030.findByFormSerialNumber", query = "SELECT h FROM HZCW030 h WHERE h.formSerialNumber = :formSerialNumber"),
    @NamedQuery(name = "HZCW030.findByCenterid", query = "SELECT h FROM HZCW030 h WHERE h.centerid = :centerid"),
    @NamedQuery(name = "HZCW030.findByBudgetAccname1", query = "SELECT h FROM HZCW030 h WHERE h.budgetAccname1 = :budgetAccname1"),
    @NamedQuery(name = "HZCW030.findByBudgetAccname2", query = "SELECT h FROM HZCW030 h WHERE h.budgetAccname2 = :budgetAccname2"),
    @NamedQuery(name = "HZCW030.findByProjectType", query = "SELECT h FROM HZCW030 h WHERE h.projectType = :projectType"),
    @NamedQuery(name = "HZCW030.findByTZtotalAmount", query = "SELECT h FROM HZCW030 h WHERE h.tZtotalAmount = :tZtotalAmount"),
    @NamedQuery(name = "HZCW030.findByProject", query = "SELECT h FROM HZCW030 h WHERE h.project = :project"),
    @NamedQuery(name = "HZCW030.findByTransferDate", query = "SELECT h FROM HZCW030 h WHERE h.transferDate = :transferDate"),
    @NamedQuery(name = "HZCW030.findByNeedUser", query = "SELECT h FROM HZCW030 h WHERE h.needUser = :needUser"),
    @NamedQuery(name = "HZCW030.findByRecallcenterid", query = "SELECT h FROM HZCW030 h WHERE h.recallcenterid = :recallcenterid"),
    @NamedQuery(name = "HZCW030.findByDBcenterName", query = "SELECT h FROM HZCW030 h WHERE h.dBcenterName = :dBcenterName"),
    @NamedQuery(name = "HZCW030.findByRecallamount", query = "SELECT h FROM HZCW030 h WHERE h.recallamount = :recallamount"),
    @NamedQuery(name = "HZCW030.findByTransfercenterid", query = "SELECT h FROM HZCW030 h WHERE h.transfercenterid = :transfercenterid"),
    @NamedQuery(name = "HZCW030.findByRecallbudgetAcc", query = "SELECT h FROM HZCW030 h WHERE h.recallbudgetAcc = :recallbudgetAcc"),
    @NamedQuery(name = "HZCW030.findByResearchno", query = "SELECT h FROM HZCW030 h WHERE h.researchno = :researchno"),
    @NamedQuery(name = "HZCW030.findByRemark1", query = "SELECT h FROM HZCW030 h WHERE h.remark1 = :remark1"),
    @NamedQuery(name = "HZCW030.findByRecallDate", query = "SELECT h FROM HZCW030 h WHERE h.recallDate = :recallDate"),
    @NamedQuery(name = "HZCW030.findByCenterName", query = "SELECT h FROM HZCW030 h WHERE h.centerName = :centerName"),
    @NamedQuery(name = "HZCW030.findByRemark2", query = "SELECT h FROM HZCW030 h WHERE h.remark2 = :remark2"),
    @NamedQuery(name = "HZCW030.findByRecallbudgetAccname", query = "SELECT h FROM HZCW030 h WHERE h.recallbudgetAccname = :recallbudgetAccname"),
    @NamedQuery(name = "HZCW030.findByTransferamount", query = "SELECT h FROM HZCW030 h WHERE h.transferamount = :transferamount"),
    @NamedQuery(name = "HZCW030.findByRemark", query = "SELECT h FROM HZCW030 h WHERE h.remark = :remark"),
    @NamedQuery(name = "HZCW030.findByRecallcenterName", query = "SELECT h FROM HZCW030 h WHERE h.recallcenterName = :recallcenterName"),
    @NamedQuery(name = "HZCW030.findByTransferbudgetAccname", query = "SELECT h FROM HZCW030 h WHERE h.transferbudgetAccname = :transferbudgetAccname"),
    @NamedQuery(name = "HZCW030.findByAmount2", query = "SELECT h FROM HZCW030 h WHERE h.amount2 = :amount2"),
    @NamedQuery(name = "HZCW030.findByAmount1", query = "SELECT h FROM HZCW030 h WHERE h.amount1 = :amount1"),
    @NamedQuery(name = "HZCW030.findByDBtotalAmount", query = "SELECT h FROM HZCW030 h WHERE h.dBtotalAmount = :dBtotalAmount"),
    @NamedQuery(name = "HZCW030.findByBudgetDate2", query = "SELECT h FROM HZCW030 h WHERE h.budgetDate2 = :budgetDate2"),
    @NamedQuery(name = "HZCW030.findByBudgetDate1", query = "SELECT h FROM HZCW030 h WHERE h.budgetDate1 = :budgetDate1"),
    @NamedQuery(name = "HZCW030.findByBudgetAcc2", query = "SELECT h FROM HZCW030 h WHERE h.budgetAcc2 = :budgetAcc2"),
    @NamedQuery(name = "HZCW030.findByBudgetAcc1", query = "SELECT h FROM HZCW030 h WHERE h.budgetAcc1 = :budgetAcc1"),
    @NamedQuery(name = "HZCW030.findByRecallresearchno", query = "SELECT h FROM HZCW030 h WHERE h.recallresearchno = :recallresearchno"),
    @NamedQuery(name = "HZCW030.findByTransfercenterName", query = "SELECT h FROM HZCW030 h WHERE h.transfercenterName = :transfercenterName"),
    @NamedQuery(name = "HZCW030.findByTransferResearchno", query = "SELECT h FROM HZCW030 h WHERE h.transferResearchno = :transferResearchno"),
    @NamedQuery(name = "HZCW030.findByTZcenterid", query = "SELECT h FROM HZCW030 h WHERE h.tZcenterid = :tZcenterid"),
    @NamedQuery(name = "HZCW030.findByAllamount", query = "SELECT h FROM HZCW030 h WHERE h.allamount = :allamount"),
    @NamedQuery(name = "HZCW030.findByTransferbudgetAcc", query = "SELECT h FROM HZCW030 h WHERE h.transferbudgetAcc = :transferbudgetAcc"),
    @NamedQuery(name = "HZCW030.findByTZcenterName", query = "SELECT h FROM HZCW030 h WHERE h.tZcenterName = :tZcenterName"),
    @NamedQuery(name = "HZCW030.findByDBcenterid", query = "SELECT h FROM HZCW030 h WHERE h.dBcenterid = :dBcenterid"),
    @NamedQuery(name = "HZCW030.findByApplyDate", query = "SELECT h FROM HZCW030 h WHERE h.applyDate = :applyDate"),
    @NamedQuery(name = "HZCW030.findByTransferbudgetAcc2", query = "SELECT h FROM HZCW030 h WHERE h.transferbudgetAcc2 = :transferbudgetAcc2"),
    @NamedQuery(name = "HZCW030.findByRecallamount2", query = "SELECT h FROM HZCW030 h WHERE h.recallamount2 = :recallamount2"),
    @NamedQuery(name = "HZCW030.findByRecallcenterid2", query = "SELECT h FROM HZCW030 h WHERE h.recallcenterid2 = :recallcenterid2"),
    @NamedQuery(name = "HZCW030.findByTransfercenterid2", query = "SELECT h FROM HZCW030 h WHERE h.transfercenterid2 = :transfercenterid2"),
    @NamedQuery(name = "HZCW030.findByRecallbudgetAcc2", query = "SELECT h FROM HZCW030 h WHERE h.recallbudgetAcc2 = :recallbudgetAcc2"),
    @NamedQuery(name = "HZCW030.findByTransfercenterName2", query = "SELECT h FROM HZCW030 h WHERE h.transfercenterName2 = :transfercenterName2"),
    @NamedQuery(name = "HZCW030.findByNeedUser2", query = "SELECT h FROM HZCW030 h WHERE h.needUser2 = :needUser2"),
    @NamedQuery(name = "HZCW030.findByTrfbudgetAccname2", query = "SELECT h FROM HZCW030 h WHERE h.trfbudgetAccname2 = :trfbudgetAccname2"),
    @NamedQuery(name = "HZCW030.findByRecallbudgetAccname2", query = "SELECT h FROM HZCW030 h WHERE h.recallbudgetAccname2 = :recallbudgetAccname2"),
    @NamedQuery(name = "HZCW030.findByTransferamount2", query = "SELECT h FROM HZCW030 h WHERE h.transferamount2 = :transferamount2"),
    @NamedQuery(name = "HZCW030.findByRecallcenterName2", query = "SELECT h FROM HZCW030 h WHERE h.recallcenterName2 = :recallcenterName2"),
    @NamedQuery(name = "HZCW030.findByNeedUser3", query = "SELECT h FROM HZCW030 h WHERE h.needUser3 = :needUser3"),
    @NamedQuery(name = "HZCW030.findByHdnmanager", query = "SELECT h FROM HZCW030 h WHERE h.hdnmanager = :hdnmanager"),
    @NamedQuery(name = "HZCW030.findByBudgetDept", query = "SELECT h FROM HZCW030 h WHERE h.budgetDept = :budgetDept")})
public class HZCW030 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "zbxzcmc")
    private String zbxzcmc;
    @Size(max = 255)
    @Column(name = "zbxzc")
    private String zbxzc;
    @Size(max = 255)
    @Column(name = "hdn_fy")
    private String hdnFy;
    @Size(max = 255)
    @Column(name = "dcbm1")
    private String dcbm1;
    @Size(max = 255)
    @Column(name = "fy")
    private String fy;
    @Size(max = 255)
    @Column(name = "dcbm2")
    private String dcbm2;
    @Size(max = 255)
    @Column(name = "hdn_zbxzc")
    private String hdnZbxzc;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "hdn_dbbm")
    private String hdnDbbm;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "hdn_emply")
    private String hdnEmply;
    @Size(max = 255)
    @Column(name = "hdn_dbfy")
    private String hdnDbfy;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "dbje2")
    private Double dbje2;
    @Size(max = 255)
    @Column(name = "emply")
    private String emply;
    @Column(name = "dbje1")
    private Double dbje1;
    @Column(name = "sqrq")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sqrq;
    @Size(max = 255)
    @Column(name = "fykm2")
    private String fykm2;
    @Size(max = 255)
    @Column(name = "fykm1")
    private String fykm1;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "zj")
    private String zj;
    @Size(max = 255)
    @Column(name = "qt")
    private String qt;
    @Column(name = "zjje")
    private Double zjje;
    @Size(max = 255)
    @Column(name = "drbm2")
    private String drbm2;
    @Size(max = 255)
    @Column(name = "drbm1")
    private String drbm1;
    @Size(max = 255)
    @Column(name = "yszrzx1")
    private String yszrzx1;
    @Size(max = 255)
    @Column(name = "dbfy")
    private String dbfy;
    @Size(max = 255)
    @Column(name = "xmxz")
    private String xmxz;
    @Size(max = 255)
    @Column(name = "yszrzx2")
    private String yszrzx2;
    @Size(max = 255)
    @Column(name = "hdn_qt")
    private String hdnQt;
    @Size(max = 255)
    @Column(name = "fyxmmc")
    private String fyxmmc;
    @Size(max = 255)
    @Column(name = "qttxt")
    private String qttxt;
    @Size(max = 255)
    @Column(name = "hdn_zj")
    private String hdnZj;
    @Size(max = 255)
    @Column(name = "bmzgyj")
    private String bmzgyj;
    @Size(max = 255)
    @Column(name = "drkm1")
    private String drkm1;
    @Size(max = 255)
    @Column(name = "cwyj")
    private String cwyj;
    @Size(max = 255)
    @Column(name = "drkm2")
    private String drkm2;
    @Size(max = 255)
    @Column(name = "dckm1")
    private String dckm1;
    @Size(max = 255)
    @Column(name = "dckm2")
    private String dckm2;
    @Size(max = 255)
    @Column(name = "dbbm")
    private String dbbm;
    @Size(max = 255)
    @Column(name = "xzlb")
    private String xzlb;
    @Size(max = 255)
    @Column(name = "sqly")
    private String sqly;
    @Size(max = 255)
    @Column(name = "zjlyj")
    private String zjlyj;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "centerid")
    private String centerid;
    @Size(max = 255)
    @Column(name = "budgetAccname1")
    private String budgetAccname1;
    @Size(max = 255)
    @Column(name = "budgetAccname2")
    private String budgetAccname2;
    @Size(max = 255)
    @Column(name = "projectType")
    private String projectType;
    @Column(name = "TZtotalAmount")
    private Double tZtotalAmount;
    @Size(max = 255)
    @Column(name = "project")
    private String project;
    @Column(name = "transferDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transferDate;
    @Size(max = 255)
    @Column(name = "needUser")
    private String needUser;
    @Size(max = 255)
    @Column(name = "recallcenterid")
    private String recallcenterid;
    @Size(max = 255)
    @Column(name = "DBcenterName")
    private String dBcenterName;
    @Column(name = "recallamount")
    private Double recallamount;
    @Size(max = 255)
    @Column(name = "transfercenterid")
    private String transfercenterid;
    @Size(max = 255)
    @Column(name = "recallbudgetAcc")
    private String recallbudgetAcc;
    @Size(max = 255)
    @Column(name = "researchno")
    private String researchno;
    @Size(max = 255)
    @Column(name = "remark1")
    private String remark1;
    @Column(name = "recallDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recallDate;
    @Size(max = 255)
    @Column(name = "centerName")
    private String centerName;
    @Size(max = 255)
    @Column(name = "remark2")
    private String remark2;
    @Size(max = 255)
    @Column(name = "recallbudgetAccname")
    private String recallbudgetAccname;
    @Column(name = "transferamount")
    private Double transferamount;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "recallcenterName")
    private String recallcenterName;
    @Size(max = 255)
    @Column(name = "transferbudgetAccname")
    private String transferbudgetAccname;
    @Column(name = "amount2")
    private Double amount2;
    @Column(name = "amount1")
    private Double amount1;
    @Column(name = "DBtotalAmount")
    private Double dBtotalAmount;
    @Column(name = "budgetDate2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date budgetDate2;
    @Column(name = "budgetDate1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date budgetDate1;
    @Size(max = 255)
    @Column(name = "budgetAcc2")
    private String budgetAcc2;
    @Size(max = 255)
    @Column(name = "budgetAcc1")
    private String budgetAcc1;
    @Size(max = 255)
    @Column(name = "recallresearchno")
    private String recallresearchno;
    @Size(max = 255)
    @Column(name = "transfercenterName")
    private String transfercenterName;
    @Size(max = 255)
    @Column(name = "transferResearchno")
    private String transferResearchno;
    @Size(max = 255)
    @Column(name = "TZcenterid")
    private String tZcenterid;
    @Column(name = "allamount")
    private Double allamount;
    @Size(max = 255)
    @Column(name = "transferbudgetAcc")
    private String transferbudgetAcc;
    @Size(max = 255)
    @Column(name = "TZcenterName")
    private String tZcenterName;
    @Size(max = 255)
    @Column(name = "DBcenterid")
    private String dBcenterid;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 255)
    @Column(name = "transferbudgetAcc2")
    private String transferbudgetAcc2;
    @Column(name = "recallamount2")
    private Double recallamount2;
    @Size(max = 255)
    @Column(name = "recallcenterid2")
    private String recallcenterid2;
    @Size(max = 255)
    @Column(name = "transfercenterid2")
    private String transfercenterid2;
    @Size(max = 255)
    @Column(name = "recallbudgetAcc2")
    private String recallbudgetAcc2;
    @Size(max = 255)
    @Column(name = "transfercenterName2")
    private String transfercenterName2;
    @Size(max = 255)
    @Column(name = "needUser2")
    private String needUser2;
    @Size(max = 255)
    @Column(name = "trfbudgetAccname2")
    private String trfbudgetAccname2;
    @Size(max = 255)
    @Column(name = "recallbudgetAccname2")
    private String recallbudgetAccname2;
    @Column(name = "transferamount2")
    private Double transferamount2;
    @Size(max = 255)
    @Column(name = "recallcenterName2")
    private String recallcenterName2;
    @Size(max = 255)
    @Column(name = "needUser3")
    private String needUser3;
    @Size(max = 255)
    @Column(name = "hdnmanager")
    private String hdnmanager;
    @Size(max = 255)
    @Column(name = "budgetDept")
    private String budgetDept;

     //申请人员
    @JoinColumn(name = "emply", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = true)
    private Users user;
    //申请部门
    @JoinColumn(name = "dept", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = true)
    private OrganizationUnit organizationUnit;
     //流程号
    @JoinColumn(name = "processSerialNumber", referencedColumnName = "serialNumber", insertable = false, updatable = false)
    @OneToOne(optional = true)
    private ProcessInstance processInstance;
    
    
    public HZCW030() {
    }

    public HZCW030(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getZbxzcmc() {
        return zbxzcmc;
    }

    public void setZbxzcmc(String zbxzcmc) {
        this.zbxzcmc = zbxzcmc;
    }

    public String getZbxzc() {
        return zbxzc;
    }

    public void setZbxzc(String zbxzc) {
        this.zbxzc = zbxzc;
    }

    public String getHdnFy() {
        return hdnFy;
    }

    public void setHdnFy(String hdnFy) {
        this.hdnFy = hdnFy;
    }

    public String getDcbm1() {
        return dcbm1;
    }

    public void setDcbm1(String dcbm1) {
        this.dcbm1 = dcbm1;
    }

    public String getFy() {
        return fy;
    }

    public void setFy(String fy) {
        this.fy = fy;
    }

    public String getDcbm2() {
        return dcbm2;
    }

    public void setDcbm2(String dcbm2) {
        this.dcbm2 = dcbm2;
    }

    public String getHdnZbxzc() {
        return hdnZbxzc;
    }

    public void setHdnZbxzc(String hdnZbxzc) {
        this.hdnZbxzc = hdnZbxzc;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getHdnDbbm() {
        return hdnDbbm;
    }

    public void setHdnDbbm(String hdnDbbm) {
        this.hdnDbbm = hdnDbbm;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getHdnEmply() {
        return hdnEmply;
    }

    public void setHdnEmply(String hdnEmply) {
        this.hdnEmply = hdnEmply;
    }

    public String getHdnDbfy() {
        return hdnDbfy;
    }

    public void setHdnDbfy(String hdnDbfy) {
        this.hdnDbfy = hdnDbfy;
    }

    public Double getDbje2() {
        return dbje2;
    }

    public void setDbje2(Double dbje2) {
        this.dbje2 = dbje2;
    }

    public String getEmply() {
        return emply;
    }

    public void setEmply(String emply) {
        this.emply = emply;
    }

    public Double getDbje1() {
        return dbje1;
    }

    public void setDbje1(Double dbje1) {
        this.dbje1 = dbje1;
    }

    public Date getSqrq() {
        return sqrq;
    }

    public void setSqrq(Date sqrq) {
        this.sqrq = sqrq;
    }

    public String getFykm2() {
        return fykm2;
    }

    public void setFykm2(String fykm2) {
        this.fykm2 = fykm2;
    }

    public String getFykm1() {
        return fykm1;
    }

    public void setFykm1(String fykm1) {
        this.fykm1 = fykm1;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getZj() {
        return zj;
    }

    public void setZj(String zj) {
        this.zj = zj;
    }

    public String getQt() {
        return qt;
    }

    public void setQt(String qt) {
        this.qt = qt;
    }

    public Double getZjje() {
        return zjje;
    }

    public void setZjje(Double zjje) {
        this.zjje = zjje;
    }

    public String getDrbm2() {
        return drbm2;
    }

    public void setDrbm2(String drbm2) {
        this.drbm2 = drbm2;
    }

    public String getDrbm1() {
        return drbm1;
    }

    public void setDrbm1(String drbm1) {
        this.drbm1 = drbm1;
    }

    public String getYszrzx1() {
        return yszrzx1;
    }

    public void setYszrzx1(String yszrzx1) {
        this.yszrzx1 = yszrzx1;
    }

    public String getDbfy() {
        return dbfy;
    }

    public void setDbfy(String dbfy) {
        this.dbfy = dbfy;
    }

    public String getXmxz() {
        return xmxz;
    }

    public void setXmxz(String xmxz) {
        this.xmxz = xmxz;
    }

    public String getYszrzx2() {
        return yszrzx2;
    }

    public void setYszrzx2(String yszrzx2) {
        this.yszrzx2 = yszrzx2;
    }

    public String getHdnQt() {
        return hdnQt;
    }

    public void setHdnQt(String hdnQt) {
        this.hdnQt = hdnQt;
    }

    public String getFyxmmc() {
        return fyxmmc;
    }

    public void setFyxmmc(String fyxmmc) {
        this.fyxmmc = fyxmmc;
    }

    public String getQttxt() {
        return qttxt;
    }

    public void setQttxt(String qttxt) {
        this.qttxt = qttxt;
    }

    public String getHdnZj() {
        return hdnZj;
    }

    public void setHdnZj(String hdnZj) {
        this.hdnZj = hdnZj;
    }

    public String getBmzgyj() {
        return bmzgyj;
    }

    public void setBmzgyj(String bmzgyj) {
        this.bmzgyj = bmzgyj;
    }

    public String getDrkm1() {
        return drkm1;
    }

    public void setDrkm1(String drkm1) {
        this.drkm1 = drkm1;
    }

    public String getCwyj() {
        return cwyj;
    }

    public void setCwyj(String cwyj) {
        this.cwyj = cwyj;
    }

    public String getDrkm2() {
        return drkm2;
    }

    public void setDrkm2(String drkm2) {
        this.drkm2 = drkm2;
    }

    public String getDckm1() {
        return dckm1;
    }

    public void setDckm1(String dckm1) {
        this.dckm1 = dckm1;
    }

    public String getDckm2() {
        return dckm2;
    }

    public void setDckm2(String dckm2) {
        this.dckm2 = dckm2;
    }

    public String getDbbm() {
        return dbbm;
    }

    public void setDbbm(String dbbm) {
        this.dbbm = dbbm;
    }

    public String getXzlb() {
        return xzlb;
    }

    public void setXzlb(String xzlb) {
        this.xzlb = xzlb;
    }

    public String getSqly() {
        return sqly;
    }

    public void setSqly(String sqly) {
        this.sqly = sqly;
    }

    public String getZjlyj() {
        return zjlyj;
    }

    public void setZjlyj(String zjlyj) {
        this.zjlyj = zjlyj;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public String getBudgetAccname1() {
        return budgetAccname1;
    }

    public void setBudgetAccname1(String budgetAccname1) {
        this.budgetAccname1 = budgetAccname1;
    }

    public String getBudgetAccname2() {
        return budgetAccname2;
    }

    public void setBudgetAccname2(String budgetAccname2) {
        this.budgetAccname2 = budgetAccname2;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public Double getTZtotalAmount() {
        return tZtotalAmount;
    }

    public void setTZtotalAmount(Double tZtotalAmount) {
        this.tZtotalAmount = tZtotalAmount;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public String getNeedUser() {
        return needUser;
    }

    public void setNeedUser(String needUser) {
        this.needUser = needUser;
    }

    public String getRecallcenterid() {
        return recallcenterid;
    }

    public void setRecallcenterid(String recallcenterid) {
        this.recallcenterid = recallcenterid;
    }

    public String getDBcenterName() {
        return dBcenterName;
    }

    public void setDBcenterName(String dBcenterName) {
        this.dBcenterName = dBcenterName;
    }

    public Double getRecallamount() {
        return recallamount;
    }

    public void setRecallamount(Double recallamount) {
        this.recallamount = recallamount;
    }

    public String getTransfercenterid() {
        return transfercenterid;
    }

    public void setTransfercenterid(String transfercenterid) {
        this.transfercenterid = transfercenterid;
    }

    public String getRecallbudgetAcc() {
        return recallbudgetAcc;
    }

    public void setRecallbudgetAcc(String recallbudgetAcc) {
        this.recallbudgetAcc = recallbudgetAcc;
    }

    public String getResearchno() {
        return researchno;
    }

    public void setResearchno(String researchno) {
        this.researchno = researchno;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public Date getRecallDate() {
        return recallDate;
    }

    public void setRecallDate(Date recallDate) {
        this.recallDate = recallDate;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRecallbudgetAccname() {
        return recallbudgetAccname;
    }

    public void setRecallbudgetAccname(String recallbudgetAccname) {
        this.recallbudgetAccname = recallbudgetAccname;
    }

    public Double getTransferamount() {
        return transferamount;
    }

    public void setTransferamount(Double transferamount) {
        this.transferamount = transferamount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRecallcenterName() {
        return recallcenterName;
    }

    public void setRecallcenterName(String recallcenterName) {
        this.recallcenterName = recallcenterName;
    }

    public String getTransferbudgetAccname() {
        return transferbudgetAccname;
    }

    public void setTransferbudgetAccname(String transferbudgetAccname) {
        this.transferbudgetAccname = transferbudgetAccname;
    }

    public Double getAmount2() {
        return amount2;
    }

    public void setAmount2(Double amount2) {
        this.amount2 = amount2;
    }

    public Double getAmount1() {
        return amount1;
    }

    public void setAmount1(Double amount1) {
        this.amount1 = amount1;
    }

    public Double getDBtotalAmount() {
        return dBtotalAmount;
    }

    public void setDBtotalAmount(Double dBtotalAmount) {
        this.dBtotalAmount = dBtotalAmount;
    }

    public Date getBudgetDate2() {
        return budgetDate2;
    }

    public void setBudgetDate2(Date budgetDate2) {
        this.budgetDate2 = budgetDate2;
    }

    public Date getBudgetDate1() {
        return budgetDate1;
    }

    public void setBudgetDate1(Date budgetDate1) {
        this.budgetDate1 = budgetDate1;
    }

    public String getBudgetAcc2() {
        return budgetAcc2;
    }

    public void setBudgetAcc2(String budgetAcc2) {
        this.budgetAcc2 = budgetAcc2;
    }

    public String getBudgetAcc1() {
        return budgetAcc1;
    }

    public void setBudgetAcc1(String budgetAcc1) {
        this.budgetAcc1 = budgetAcc1;
    }

    public String getRecallresearchno() {
        return recallresearchno;
    }

    public void setRecallresearchno(String recallresearchno) {
        this.recallresearchno = recallresearchno;
    }

    public String getTransfercenterName() {
        return transfercenterName;
    }

    public void setTransfercenterName(String transfercenterName) {
        this.transfercenterName = transfercenterName;
    }

    public String getTransferResearchno() {
        return transferResearchno;
    }

    public void setTransferResearchno(String transferResearchno) {
        this.transferResearchno = transferResearchno;
    }

    public String getTZcenterid() {
        return tZcenterid;
    }

    public void setTZcenterid(String tZcenterid) {
        this.tZcenterid = tZcenterid;
    }

    public Double getAllamount() {
        return allamount;
    }

    public void setAllamount(Double allamount) {
        this.allamount = allamount;
    }

    public String getTransferbudgetAcc() {
        return transferbudgetAcc;
    }

    public void setTransferbudgetAcc(String transferbudgetAcc) {
        this.transferbudgetAcc = transferbudgetAcc;
    }

    public String getTZcenterName() {
        return tZcenterName;
    }

    public void setTZcenterName(String tZcenterName) {
        this.tZcenterName = tZcenterName;
    }

    public String getDBcenterid() {
        return dBcenterid;
    }

    public void setDBcenterid(String dBcenterid) {
        this.dBcenterid = dBcenterid;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getTransferbudgetAcc2() {
        return transferbudgetAcc2;
    }

    public void setTransferbudgetAcc2(String transferbudgetAcc2) {
        this.transferbudgetAcc2 = transferbudgetAcc2;
    }

    public Double getRecallamount2() {
        return recallamount2;
    }

    public void setRecallamount2(Double recallamount2) {
        this.recallamount2 = recallamount2;
    }

    public String getRecallcenterid2() {
        return recallcenterid2;
    }

    public void setRecallcenterid2(String recallcenterid2) {
        this.recallcenterid2 = recallcenterid2;
    }

    public String getTransfercenterid2() {
        return transfercenterid2;
    }

    public void setTransfercenterid2(String transfercenterid2) {
        this.transfercenterid2 = transfercenterid2;
    }

    public String getRecallbudgetAcc2() {
        return recallbudgetAcc2;
    }

    public void setRecallbudgetAcc2(String recallbudgetAcc2) {
        this.recallbudgetAcc2 = recallbudgetAcc2;
    }

    public String getTransfercenterName2() {
        return transfercenterName2;
    }

    public void setTransfercenterName2(String transfercenterName2) {
        this.transfercenterName2 = transfercenterName2;
    }

    public String getNeedUser2() {
        return needUser2;
    }

    public void setNeedUser2(String needUser2) {
        this.needUser2 = needUser2;
    }

    public String getTrfbudgetAccname2() {
        return trfbudgetAccname2;
    }

    public void setTrfbudgetAccname2(String trfbudgetAccname2) {
        this.trfbudgetAccname2 = trfbudgetAccname2;
    }

    public String getRecallbudgetAccname2() {
        return recallbudgetAccname2;
    }

    public void setRecallbudgetAccname2(String recallbudgetAccname2) {
        this.recallbudgetAccname2 = recallbudgetAccname2;
    }

    public Double getTransferamount2() {
        return transferamount2;
    }

    public void setTransferamount2(Double transferamount2) {
        this.transferamount2 = transferamount2;
    }

    public String getRecallcenterName2() {
        return recallcenterName2;
    }

    public void setRecallcenterName2(String recallcenterName2) {
        this.recallcenterName2 = recallcenterName2;
    }

    public String getNeedUser3() {
        return needUser3;
    }

    public void setNeedUser3(String needUser3) {
        this.needUser3 = needUser3;
    }

    public String getHdnmanager() {
        return hdnmanager;
    }

    public void setHdnmanager(String hdnmanager) {
        this.hdnmanager = hdnmanager;
    }

    public String getBudgetDept() {
        new Date();
        return budgetDept;
    }

    public void setBudgetDept(String budgetDept) {
        this.budgetDept = budgetDept;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public OrganizationUnit getOrganizationUnit() {
        return organizationUnit;
    }

    public void setOrganizationUnit(OrganizationUnit organizationUnit) {
        this.organizationUnit = organizationUnit;
    }

    public ProcessInstance getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HZCW030)) {
            return false;
        }
        HZCW030 other = (HZCW030) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZCW030[ oid=" + oid + " ]";
    }
    
}
