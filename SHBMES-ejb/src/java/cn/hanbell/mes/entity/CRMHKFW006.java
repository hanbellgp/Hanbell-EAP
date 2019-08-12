/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.mes.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "CRM_HK_FW006")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CRMHKFW006.findAll", query = "SELECT c FROM CRMHKFW006 c"),
    @NamedQuery(name = "CRMHKFW006.findBySysid", query = "SELECT c FROM CRMHKFW006 c WHERE c.sysid = :sysid"),
    @NamedQuery(name = "CRMHKFW006.findByCrmno", query = "SELECT c FROM CRMHKFW006 c WHERE c.crmno = :crmno"),
    @NamedQuery(name = "CRMHKFW006.findByProductcompid", query = "SELECT c FROM CRMHKFW006 c WHERE c.productcompid = :productcompid"),
    @NamedQuery(name = "CRMHKFW006.findByProductorderid", query = "SELECT c FROM CRMHKFW006 c WHERE c.productorderid = :productorderid"),
    @NamedQuery(name = "CRMHKFW006.findByCrmtype", query = "SELECT c FROM CRMHKFW006 c WHERE c.crmtype = :crmtype"),
    @NamedQuery(name = "CRMHKFW006.findByBrands", query = "SELECT c FROM CRMHKFW006 c WHERE c.brands = :brands"),
    @NamedQuery(name = "CRMHKFW006.findByMtype", query = "SELECT c FROM CRMHKFW006 c WHERE c.mtype = :mtype"),
    @NamedQuery(name = "CRMHKFW006.findByStepid", query = "SELECT c FROM CRMHKFW006 c WHERE c.stepid = :stepid"),
    @NamedQuery(name = "CRMHKFW006.findByStepseq", query = "SELECT c FROM CRMHKFW006 c WHERE c.stepseq = :stepseq"),
    @NamedQuery(name = "CRMHKFW006.findByRuleid", query = "SELECT c FROM CRMHKFW006 c WHERE c.ruleid = :ruleid"),
    @NamedQuery(name = "CRMHKFW006.findByEqpid", query = "SELECT c FROM CRMHKFW006 c WHERE c.eqpid = :eqpid"),
    @NamedQuery(name = "CRMHKFW006.findByProcessstatus", query = "SELECT c FROM CRMHKFW006 c WHERE c.processstatus = :processstatus"),
    @NamedQuery(name = "CRMHKFW006.findByGzreason", query = "SELECT c FROM CRMHKFW006 c WHERE c.gzreason = :gzreason"),
    @NamedQuery(name = "CRMHKFW006.findByYyjb", query = "SELECT c FROM CRMHKFW006 c WHERE c.yyjb = :yyjb"),
    @NamedQuery(name = "CRMHKFW006.findByTitdsc", query = "SELECT c FROM CRMHKFW006 c WHERE c.titdsc = :titdsc"),
    @NamedQuery(name = "CRMHKFW006.findByTklx", query = "SELECT c FROM CRMHKFW006 c WHERE c.tklx = :tklx"),
    @NamedQuery(name = "CRMHKFW006.findByHditcls", query = "SELECT c FROM CRMHKFW006 c WHERE c.hditcls = :hditcls"),
    @NamedQuery(name = "CRMHKFW006.findByCreatedate", query = "SELECT c FROM CRMHKFW006 c WHERE c.createdate = :createdate"),
    @NamedQuery(name = "CRMHKFW006.findByCdrno", query = "SELECT c FROM CRMHKFW006 c WHERE c.cdrno = :cdrno"),
    @NamedQuery(name = "CRMHKFW006.findByLitdsc", query = "SELECT c FROM CRMHKFW006 c WHERE c.litdsc = :litdsc"),
    @NamedQuery(name = "CRMHKFW006.findBySerialNumber", query = "SELECT c FROM CRMHKFW006 c WHERE c.serialNumber = :serialNumber"),
    @NamedQuery(name = "CRMHKFW006.findByMachineoil", query = "SELECT c FROM CRMHKFW006 c WHERE c.machineoil = :machineoil"),
    @NamedQuery(name = "CRMHKFW006.findByFwno", query = "SELECT c FROM CRMHKFW006 c WHERE c.fwno = :fwno"),
    @NamedQuery(name = "CRMHKFW006.findByCusno", query = "SELECT c FROM CRMHKFW006 c WHERE c.cusno = :cusno"),
    @NamedQuery(name = "CRMHKFW006.findByDhno", query = "SELECT c FROM CRMHKFW006 c WHERE c.dhno = :dhno"),
    @NamedQuery(name = "CRMHKFW006.findByPzno", query = "SELECT c FROM CRMHKFW006 c WHERE c.pzno = :pzno"),
    @NamedQuery(name = "CRMHKFW006.findByZbpzno", query = "SELECT c FROM CRMHKFW006 c WHERE c.zbpzno = :zbpzno"),
    @NamedQuery(name = "CRMHKFW006.findByHdljxx", query = "SELECT c FROM CRMHKFW006 c WHERE c.hdljxx = :hdljxx"),
    @NamedQuery(name = "CRMHKFW006.findByHdTD003", query = "SELECT c FROM CRMHKFW006 c WHERE c.hdTD003 = :hdTD003"),
    @NamedQuery(name = "CRMHKFW006.findByHdreturntype", query = "SELECT c FROM CRMHKFW006 c WHERE c.hdreturntype = :hdreturntype"),
    @NamedQuery(name = "CRMHKFW006.findByRecitdsc", query = "SELECT c FROM CRMHKFW006 c WHERE c.recitdsc = :recitdsc"),
    @NamedQuery(name = "CRMHKFW006.findByRettype", query = "SELECT c FROM CRMHKFW006 c WHERE c.rettype = :rettype"),
    @NamedQuery(name = "CRMHKFW006.findByQty", query = "SELECT c FROM CRMHKFW006 c WHERE c.qty = :qty"),
    @NamedQuery(name = "CRMHKFW006.findByMark", query = "SELECT c FROM CRMHKFW006 c WHERE c.mark = :mark"),
    @NamedQuery(name = "CRMHKFW006.findByShpno", query = "SELECT c FROM CRMHKFW006 c WHERE c.shpno = :shpno"),
    @NamedQuery(name = "CRMHKFW006.findByKfno", query = "SELECT c FROM CRMHKFW006 c WHERE c.kfno = :kfno"),
    @NamedQuery(name = "CRMHKFW006.findByMachineoilhalf", query = "SELECT c FROM CRMHKFW006 c WHERE c.machineoilhalf = :machineoilhalf"),
    @NamedQuery(name = "CRMHKFW006.findByHdfacno", query = "SELECT c FROM CRMHKFW006 c WHERE c.hdfacno = :hdfacno"),
    @NamedQuery(name = "CRMHKFW006.findByCptype", query = "SELECT c FROM CRMHKFW006 c WHERE c.cptype = :cptype"),
    @NamedQuery(name = "CRMHKFW006.findBySfzb", query = "SELECT c FROM CRMHKFW006 c WHERE c.sfzb = :sfzb"),
    @NamedQuery(name = "CRMHKFW006.findByYymark", query = "SELECT c FROM CRMHKFW006 c WHERE c.yymark = :yymark"),
    @NamedQuery(name = "CRMHKFW006.findByPstyle", query = "SELECT c FROM CRMHKFW006 c WHERE c.pstyle = :pstyle"),
    @NamedQuery(name = "CRMHKFW006.findByRecitnbr", query = "SELECT c FROM CRMHKFW006 c WHERE c.recitnbr = :recitnbr"),
    @NamedQuery(name = "CRMHKFW006.findByHdTC001", query = "SELECT c FROM CRMHKFW006 c WHERE c.hdTC001 = :hdTC001"),
    @NamedQuery(name = "CRMHKFW006.findByZjshpno", query = "SELECT c FROM CRMHKFW006 c WHERE c.zjshpno = :zjshpno"),
    @NamedQuery(name = "CRMHKFW006.findByTitnbr", query = "SELECT c FROM CRMHKFW006 c WHERE c.titnbr = :titnbr"),
    @NamedQuery(name = "CRMHKFW006.findByLcreateno", query = "SELECT c FROM CRMHKFW006 c WHERE c.lcreateno = :lcreateno"),
    @NamedQuery(name = "CRMHKFW006.findByRetqty", query = "SELECT c FROM CRMHKFW006 c WHERE c.retqty = :retqty"),
    @NamedQuery(name = "CRMHKFW006.findByOid", query = "SELECT c FROM CRMHKFW006 c WHERE c.oid = :oid"),
    @NamedQuery(name = "CRMHKFW006.findByHdyyjb", query = "SELECT c FROM CRMHKFW006 c WHERE c.hdyyjb = :hdyyjb"),
    @NamedQuery(name = "CRMHKFW006.findByApplydept", query = "SELECT c FROM CRMHKFW006 c WHERE c.applydept = :applydept"),
    @NamedQuery(name = "CRMHKFW006.findByFacno", query = "SELECT c FROM CRMHKFW006 c WHERE c.facno = :facno"),
    @NamedQuery(name = "CRMHKFW006.findByRetitdsc", query = "SELECT c FROM CRMHKFW006 c WHERE c.retitdsc = :retitdsc"),
    @NamedQuery(name = "CRMHKFW006.findByFgspzno", query = "SELECT c FROM CRMHKFW006 c WHERE c.fgspzno = :fgspzno"),
    @NamedQuery(name = "CRMHKFW006.findByTcreateno", query = "SELECT c FROM CRMHKFW006 c WHERE c.tcreateno = :tcreateno"),
    @NamedQuery(name = "CRMHKFW006.findByApplyuser", query = "SELECT c FROM CRMHKFW006 c WHERE c.applyuser = :applyuser"),
    @NamedQuery(name = "CRMHKFW006.findByRstyle", query = "SELECT c FROM CRMHKFW006 c WHERE c.rstyle = :rstyle"),
    @NamedQuery(name = "CRMHKFW006.findByRetitnbr", query = "SELECT c FROM CRMHKFW006 c WHERE c.retitnbr = :retitnbr"),
    @NamedQuery(name = "CRMHKFW006.findByPSN", query = "SELECT c FROM CRMHKFW006 c WHERE c.processSerialNumber = :psn"),
    @NamedQuery(name = "CRMHKFW006.findByYf", query = "SELECT c FROM CRMHKFW006 c WHERE c.yf = :yf"),
    @NamedQuery(name = "CRMHKFW006.findByCusna", query = "SELECT c FROM CRMHKFW006 c WHERE c.cusna = :cusna"),
    @NamedQuery(name = "CRMHKFW006.findByBhmk", query = "SELECT c FROM CRMHKFW006 c WHERE c.bhmk = :bhmk"),
    @NamedQuery(name = "CRMHKFW006.findByHdcptype", query = "SELECT c FROM CRMHKFW006 c WHERE c.hdcptype = :hdcptype"),
    @NamedQuery(name = "CRMHKFW006.findBySupportdept", query = "SELECT c FROM CRMHKFW006 c WHERE c.supportdept = :supportdept"),
    @NamedQuery(name = "CRMHKFW006.findByDzf", query = "SELECT c FROM CRMHKFW006 c WHERE c.dzf = :dzf"),
    @NamedQuery(name = "CRMHKFW006.findByReturntype", query = "SELECT c FROM CRMHKFW006 c WHERE c.returntype = :returntype"),
    @NamedQuery(name = "CRMHKFW006.findByRecqty", query = "SELECT c FROM CRMHKFW006 c WHERE c.recqty = :recqty"),
    @NamedQuery(name = "CRMHKFW006.findByUnit", query = "SELECT c FROM CRMHKFW006 c WHERE c.unit = :unit"),
    @NamedQuery(name = "CRMHKFW006.findByKssjt", query = "SELECT c FROM CRMHKFW006 c WHERE c.kssjt = :kssjt"),
    @NamedQuery(name = "CRMHKFW006.findByAstyle", query = "SELECT c FROM CRMHKFW006 c WHERE c.astyle = :astyle"),
    @NamedQuery(name = "CRMHKFW006.findBySupportuser", query = "SELECT c FROM CRMHKFW006 c WHERE c.supportuser = :supportuser"),
    @NamedQuery(name = "CRMHKFW006.findByFrozenoil", query = "SELECT c FROM CRMHKFW006 c WHERE c.frozenoil = :frozenoil"),
    @NamedQuery(name = "CRMHKFW006.findByReturndate", query = "SELECT c FROM CRMHKFW006 c WHERE c.returndate = :returndate"),
    @NamedQuery(name = "CRMHKFW006.findByCctype", query = "SELECT c FROM CRMHKFW006 c WHERE c.cctype = :cctype"),
    @NamedQuery(name = "CRMHKFW006.findByLitnbr", query = "SELECT c FROM CRMHKFW006 c WHERE c.litnbr = :litnbr"),
    @NamedQuery(name = "CRMHKFW006.findByFormSerialNumber", query = "SELECT c FROM CRMHKFW006 c WHERE c.formSerialNumber = :formSerialNumber"),
    @NamedQuery(name = "CRMHKFW006.findByIsdelete", query = "SELECT c FROM CRMHKFW006 c WHERE c.isdelete = :isdelete"),
    @NamedQuery(name = "CRMHKFW006.findByModifyuserid", query = "SELECT c FROM CRMHKFW006 c WHERE c.modifyuserid = :modifyuserid"),
    @NamedQuery(name = "CRMHKFW006.findByModifyuser", query = "SELECT c FROM CRMHKFW006 c WHERE c.modifyuser = :modifyuser"),
    @NamedQuery(name = "CRMHKFW006.findByModifytime", query = "SELECT c FROM CRMHKFW006 c WHERE c.modifytime = :modifytime"),
    @NamedQuery(name = "CRMHKFW006.findByCustomrequest", query = "SELECT c FROM CRMHKFW006 c WHERE c.customrequest = :customrequest"),
    @NamedQuery(name = "CRMHKFW006.findByDisassemblememo", query = "SELECT c FROM CRMHKFW006 c WHERE c.disassemblememo = :disassemblememo"),
    @NamedQuery(name = "CRMHKFW006.findByResponsibility", query = "SELECT c FROM CRMHKFW006 c WHERE c.responsibility = :responsibility"),
    @NamedQuery(name = "CRMHKFW006.findByIscheckerpbom", query = "SELECT c FROM CRMHKFW006 c WHERE c.ischeckerpbom = :ischeckerpbom"),
    @NamedQuery(name = "CRMHKFW006.findByNewProductcompid", query = "SELECT c FROM CRMHKFW006 c WHERE c.newProductcompid = :newProductcompid"),
    @NamedQuery(name = "CRMHKFW006.findByOil", query = "SELECT c FROM CRMHKFW006 c WHERE c.oil = :oil"),
    @NamedQuery(name = "CRMHKFW006.findByOilqty", query = "SELECT c FROM CRMHKFW006 c WHERE c.oilqty = :oilqty"),
    @NamedQuery(name = "CRMHKFW006.findByFwInside", query = "SELECT c FROM CRMHKFW006 c WHERE c.fwInside = :fwInside")})
public class CRMHKFW006 implements Serializable {

    @Column(name = "qty")
    private Integer qty;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "yf")
    private Double yf;
    @Column(name = "dzf")
    private Double dzf;

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 480)
    @Column(name = "CRMNO")
    private String crmno;

    @Size(max = 2000)
    @Column(name = "OASUBJECT")
    private String oasubject;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 320)
    @Column(name = "SYSID")
    private String sysid;

    @Basic(optional = false)
    @Column(name = "PRODUCTCOMPID")
    private String productcompid;
    @Basic(optional = false)
    @Column(name = "PRODUCTORDERID")
    private String productorderid;
    @Basic(optional = false)
    @Column(name = "CRMTYPE")
    private String crmtype;
    @Basic(optional = false)
    @Column(name = "BRANDS")
    private String brands;
    @Basic(optional = false)
    @Column(name = "MTYPE")
    private String mtype;
    @Size(max = 30)
    @Column(name = "STEPID")
    private String stepid;
    @Size(max = 10)
    @Column(name = "STEPSEQ")
    private String stepseq;
    @Size(max = 30)
    @Column(name = "RULEID")
    private String ruleid;
    @Size(max = 30)
    @Column(name = "EQPID")
    private String eqpid;
    @Size(max = 10)
    @Column(name = "PROCESSSTATUS")
    private String processstatus;
    @Basic(optional = false)
    @Column(name = "gzreason")
    private String gzreason;
    @Basic(optional = false)
    @Column(name = "yyjb")
    private String yyjb;
    @Basic(optional = false)
    @Column(name = "titdsc")
    private String titdsc;
    @Basic(optional = false)
    @Column(name = "tklx")
    private String tklx;
    @Basic(optional = false)
    @Column(name = "hditcls")
    private String hditcls;
    @Basic(optional = false)
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Basic(optional = false)
    @Column(name = "cdrno")
    private String cdrno;
    @Basic(optional = false)
    @Column(name = "litdsc")
    private String litdsc;
    @Basic(optional = false)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Basic(optional = false)
    @Column(name = "machineoil")
    private String machineoil;
    @Basic(optional = false)
    @Column(name = "fwno")
    private String fwno;
    @Basic(optional = false)
    @Column(name = "cusno")
    private String cusno;
    @Basic(optional = false)
    @Column(name = "dhno")
    private String dhno;
    @Basic(optional = false)
    @Column(name = "pzno")
    private String pzno;
    @Basic(optional = false)
    @Column(name = "zbpzno")
    private String zbpzno;
    @Basic(optional = false)
    @Column(name = "hdljxx")
    private String hdljxx;
    @Basic(optional = false)
    @Column(name = "hdTD003")
    private String hdTD003;
    @Basic(optional = false)
    @Column(name = "hdreturntype")
    private String hdreturntype;
    @Basic(optional = false)
    @Column(name = "recitdsc")
    private String recitdsc;
    @Basic(optional = false)
    @Column(name = "rettype")
    private String rettype;
    @Basic(optional = false)
    @Column(name = "mark")
    private String mark;
    @Basic(optional = false)
    @Column(name = "shpno")
    private String shpno;
    @Basic(optional = false)
    @Column(name = "kfno")
    private String kfno;
    @Basic(optional = false)
    @Column(name = "machineoilhalf")
    private String machineoilhalf;
    @Basic(optional = false)
    @Column(name = "hdfacno")
    private String hdfacno;
    @Basic(optional = false)
    @Column(name = "cptype")
    private String cptype;
    @Basic(optional = false)
    @Column(name = "sfzb")
    private String sfzb;
    @Basic(optional = false)
    @Column(name = "yymark")
    private String yymark;
    @Basic(optional = false)
    @Column(name = "pstyle")
    private String pstyle;
    @Basic(optional = false)
    @Column(name = "recitnbr")
    private String recitnbr;
    @Basic(optional = false)
    @Column(name = "hdTC001")
    private String hdTC001;
    @Basic(optional = false)
    @Column(name = "zjshpno")
    private String zjshpno;
    @Basic(optional = false)
    @Column(name = "titnbr")
    private String titnbr;
    @Basic(optional = false)
    @Column(name = "lcreateno")
    private String lcreateno;
    @Basic(optional = false)
    @Column(name = "retqty")
    private String retqty;
    @Basic(optional = false)
    @Column(name = "OID")
    private String oid;
    @Basic(optional = false)
    @Column(name = "hdyyjb")
    private String hdyyjb;
    @Basic(optional = false)
    @Column(name = "applydept")
    private String applydept;
    @Basic(optional = false)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @Column(name = "retitdsc")
    private String retitdsc;
    @Basic(optional = false)
    @Column(name = "fgspzno")
    private String fgspzno;
    @Basic(optional = false)
    @Column(name = "tcreateno")
    private String tcreateno;
    @Basic(optional = false)
    @Column(name = "applyuser")
    private String applyuser;
    @Basic(optional = false)
    @Column(name = "rstyle")
    private String rstyle;
    @Basic(optional = false)
    @Column(name = "retitnbr")
    private String retitnbr;
    @Basic(optional = false)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Basic(optional = false)
    @Column(name = "cusna")
    private String cusna;
    @Basic(optional = false)
    @Column(name = "bhmk")
    private String bhmk;
    @Basic(optional = false)
    @Column(name = "hdcptype")
    private String hdcptype;
    @Basic(optional = false)
    @Column(name = "supportdept")
    private String supportdept;
    @Basic(optional = false)
    @Column(name = "returntype")
    private String returntype;
    @Basic(optional = false)
    @Column(name = "recqty")
    private String recqty;
    @Basic(optional = false)
    @Column(name = "unit")
    private String unit;
    @Basic(optional = false)
    @Column(name = "kssjt")
    private String kssjt;
    @Basic(optional = false)
    @Column(name = "astyle")
    private String astyle;
    @Basic(optional = false)
    @Column(name = "supportuser")
    private String supportuser;
    @Basic(optional = false)
    @Column(name = "frozenoil")
    private String frozenoil;
    @Basic(optional = false)
    @Column(name = "returndate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returndate;
    @Basic(optional = false)
    @Column(name = "cctype")
    private String cctype;
    @Basic(optional = false)
    @Column(name = "litnbr")
    private String litnbr;
    @Basic(optional = false)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Basic(optional = false)
    @Column(name = "ISDELETE")
    private String isdelete;
    @Size(max = 20)
    @Column(name = "MODIFYUSERID")
    private String modifyuserid;
    @Size(max = 20)
    @Column(name = "MODIFYUSER")
    private String modifyuser;
    @Size(max = 20)
    @Column(name = "MODIFYTIME")
    private String modifytime;
    @Basic(optional = false)
    @Column(name = "CUSTOMREQUEST")
    private String customrequest;
    @Size(max = 200)
    @Column(name = "DISASSEMBLEMEMO")
    private String disassemblememo;
    @Size(max = 30)
    @Column(name = "RESPONSIBILITY")
    private String responsibility;
    @Size(max = 2)
    @Column(name = "ISCHECKERPBOM")
    private String ischeckerpbom;
    @Size(max = 510)
    @Column(name = "NEW_PRODUCTCOMPID")
    private String newProductcompid;
    @Size(max = 30)
    @Column(name = "OIL")
    private String oil;
    @Size(max = 10)
    @Column(name = "OILQTY")
    private String oilqty;
    @Size(max = 20)
    @Column(name = "FW_INSIDE")
    private String fwInside;

    public CRMHKFW006() {
    }

    public CRMHKFW006(String crmno) {
        this.crmno = crmno;
    }

    public CRMHKFW006(String crmno, String sysid, String productcompid, String productorderid, String crmtype, String brands, String mtype, String gzreason, String yyjb, String titdsc, String tklx, String hditcls, Date createdate, String cdrno, String litdsc, String serialNumber, String machineoil, String fwno, String cusno, String dhno, String pzno, String zbpzno, String hdljxx, String hdTD003, String hdreturntype, String recitdsc, String rettype, int qty, String mark, String shpno, String kfno, String machineoilhalf, String hdfacno, String cptype, String sfzb, String yymark, String pstyle, String recitnbr, String hdTC001, String zjshpno, String titnbr, String lcreateno, String retqty, String oid, String hdyyjb, String applydept, String facno, String retitdsc, String fgspzno, String tcreateno, String applyuser, String rstyle, String retitnbr, String processSerialNumber, double yf, String cusna, String bhmk, String hdcptype, String supportdept, double dzf, String returntype, String recqty, String unit, String kssjt, String astyle, String supportuser, String frozenoil, Date returndate, String cctype, String litnbr, String formSerialNumber, String isdelete, String customrequest) {
        this.crmno = crmno;
        this.sysid = sysid;
        this.productcompid = productcompid;
        this.productorderid = productorderid;
        this.crmtype = crmtype;
        this.brands = brands;
        this.mtype = mtype;
        this.gzreason = gzreason;
        this.yyjb = yyjb;
        this.titdsc = titdsc;
        this.tklx = tklx;
        this.hditcls = hditcls;
        this.createdate = createdate;
        this.cdrno = cdrno;
        this.litdsc = litdsc;
        this.serialNumber = serialNumber;
        this.machineoil = machineoil;
        this.fwno = fwno;
        this.cusno = cusno;
        this.dhno = dhno;
        this.pzno = pzno;
        this.zbpzno = zbpzno;
        this.hdljxx = hdljxx;
        this.hdTD003 = hdTD003;
        this.hdreturntype = hdreturntype;
        this.recitdsc = recitdsc;
        this.rettype = rettype;
        this.qty = qty;
        this.mark = mark;
        this.shpno = shpno;
        this.kfno = kfno;
        this.machineoilhalf = machineoilhalf;
        this.hdfacno = hdfacno;
        this.cptype = cptype;
        this.sfzb = sfzb;
        this.yymark = yymark;
        this.pstyle = pstyle;
        this.recitnbr = recitnbr;
        this.hdTC001 = hdTC001;
        this.zjshpno = zjshpno;
        this.titnbr = titnbr;
        this.lcreateno = lcreateno;
        this.retqty = retqty;
        this.oid = oid;
        this.hdyyjb = hdyyjb;
        this.applydept = applydept;
        this.facno = facno;
        this.retitdsc = retitdsc;
        this.fgspzno = fgspzno;
        this.tcreateno = tcreateno;
        this.applyuser = applyuser;
        this.rstyle = rstyle;
        this.retitnbr = retitnbr;
        this.processSerialNumber = processSerialNumber;
        this.yf = yf;
        this.cusna = cusna;
        this.bhmk = bhmk;
        this.hdcptype = hdcptype;
        this.supportdept = supportdept;
        this.dzf = dzf;
        this.returntype = returntype;
        this.recqty = recqty;
        this.unit = unit;
        this.kssjt = kssjt;
        this.astyle = astyle;
        this.supportuser = supportuser;
        this.frozenoil = frozenoil;
        this.returndate = returndate;
        this.cctype = cctype;
        this.litnbr = litnbr;
        this.formSerialNumber = formSerialNumber;
        this.isdelete = isdelete;
        this.customrequest = customrequest;
    }

    public String getSysid() {
        return sysid;
    }

    public void setSysid(String sysid) {
        this.sysid = sysid;
    }

    public String getCrmno() {
        return crmno;
    }

    public void setCrmno(String crmno) {
        this.crmno = crmno;
    }

    public String getProductcompid() {
        return productcompid;
    }

    public void setProductcompid(String productcompid) {
        this.productcompid = productcompid;
    }

    public String getProductorderid() {
        return productorderid;
    }

    public void setProductorderid(String productorderid) {
        this.productorderid = productorderid;
    }

    public String getCrmtype() {
        return crmtype;
    }

    public void setCrmtype(String crmtype) {
        this.crmtype = crmtype;
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public String getStepid() {
        return stepid;
    }

    public void setStepid(String stepid) {
        this.stepid = stepid;
    }

    public String getStepseq() {
        return stepseq;
    }

    public void setStepseq(String stepseq) {
        this.stepseq = stepseq;
    }

    public String getRuleid() {
        return ruleid;
    }

    public void setRuleid(String ruleid) {
        this.ruleid = ruleid;
    }

    public String getEqpid() {
        return eqpid;
    }

    public void setEqpid(String eqpid) {
        this.eqpid = eqpid;
    }

    public String getProcessstatus() {
        return processstatus;
    }

    public void setProcessstatus(String processstatus) {
        this.processstatus = processstatus;
    }

    public String getGzreason() {
        return gzreason;
    }

    public void setGzreason(String gzreason) {
        this.gzreason = gzreason;
    }

    public String getYyjb() {
        return yyjb;
    }

    public void setYyjb(String yyjb) {
        this.yyjb = yyjb;
    }

    public String getTitdsc() {
        return titdsc;
    }

    public void setTitdsc(String titdsc) {
        this.titdsc = titdsc;
    }

    public String getTklx() {
        return tklx;
    }

    public void setTklx(String tklx) {
        this.tklx = tklx;
    }

    public String getHditcls() {
        return hditcls;
    }

    public void setHditcls(String hditcls) {
        this.hditcls = hditcls;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getCdrno() {
        return cdrno;
    }

    public void setCdrno(String cdrno) {
        this.cdrno = cdrno;
    }

    public String getLitdsc() {
        return litdsc;
    }

    public void setLitdsc(String litdsc) {
        this.litdsc = litdsc;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMachineoil() {
        return machineoil;
    }

    public void setMachineoil(String machineoil) {
        this.machineoil = machineoil;
    }

    public String getFwno() {
        return fwno;
    }

    public void setFwno(String fwno) {
        this.fwno = fwno;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getDhno() {
        return dhno;
    }

    public void setDhno(String dhno) {
        this.dhno = dhno;
    }

    public String getPzno() {
        return pzno;
    }

    public void setPzno(String pzno) {
        this.pzno = pzno;
    }

    public String getZbpzno() {
        return zbpzno;
    }

    public void setZbpzno(String zbpzno) {
        this.zbpzno = zbpzno;
    }

    public String getHdljxx() {
        return hdljxx;
    }

    public void setHdljxx(String hdljxx) {
        this.hdljxx = hdljxx;
    }

    public String getHdTD003() {
        return hdTD003;
    }

    public void setHdTD003(String hdTD003) {
        this.hdTD003 = hdTD003;
    }

    public String getHdreturntype() {
        return hdreturntype;
    }

    public void setHdreturntype(String hdreturntype) {
        this.hdreturntype = hdreturntype;
    }

    public String getRecitdsc() {
        return recitdsc;
    }

    public void setRecitdsc(String recitdsc) {
        this.recitdsc = recitdsc;
    }

    public String getRettype() {
        return rettype;
    }

    public void setRettype(String rettype) {
        this.rettype = rettype;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getShpno() {
        return shpno;
    }

    public void setShpno(String shpno) {
        this.shpno = shpno;
    }

    public String getKfno() {
        return kfno;
    }

    public void setKfno(String kfno) {
        this.kfno = kfno;
    }

    public String getMachineoilhalf() {
        return machineoilhalf;
    }

    public void setMachineoilhalf(String machineoilhalf) {
        this.machineoilhalf = machineoilhalf;
    }

    public String getHdfacno() {
        return hdfacno;
    }

    public void setHdfacno(String hdfacno) {
        this.hdfacno = hdfacno;
    }

    public String getCptype() {
        return cptype;
    }

    public void setCptype(String cptype) {
        this.cptype = cptype;
    }

    public String getSfzb() {
        return sfzb;
    }

    public void setSfzb(String sfzb) {
        this.sfzb = sfzb;
    }

    public String getYymark() {
        return yymark;
    }

    public void setYymark(String yymark) {
        this.yymark = yymark;
    }

    public String getPstyle() {
        return pstyle;
    }

    public void setPstyle(String pstyle) {
        this.pstyle = pstyle;
    }

    public String getRecitnbr() {
        return recitnbr;
    }

    public void setRecitnbr(String recitnbr) {
        this.recitnbr = recitnbr;
    }

    public String getHdTC001() {
        return hdTC001;
    }

    public void setHdTC001(String hdTC001) {
        this.hdTC001 = hdTC001;
    }

    public String getZjshpno() {
        return zjshpno;
    }

    public void setZjshpno(String zjshpno) {
        this.zjshpno = zjshpno;
    }

    public String getTitnbr() {
        return titnbr;
    }

    public void setTitnbr(String titnbr) {
        this.titnbr = titnbr;
    }

    public String getLcreateno() {
        return lcreateno;
    }

    public void setLcreateno(String lcreateno) {
        this.lcreateno = lcreateno;
    }

    public String getRetqty() {
        return retqty;
    }

    public void setRetqty(String retqty) {
        this.retqty = retqty;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getHdyyjb() {
        return hdyyjb;
    }

    public void setHdyyjb(String hdyyjb) {
        this.hdyyjb = hdyyjb;
    }

    public String getApplydept() {
        return applydept;
    }

    public void setApplydept(String applydept) {
        this.applydept = applydept;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getRetitdsc() {
        return retitdsc;
    }

    public void setRetitdsc(String retitdsc) {
        this.retitdsc = retitdsc;
    }

    public String getFgspzno() {
        return fgspzno;
    }

    public void setFgspzno(String fgspzno) {
        this.fgspzno = fgspzno;
    }

    public String getTcreateno() {
        return tcreateno;
    }

    public void setTcreateno(String tcreateno) {
        this.tcreateno = tcreateno;
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getRstyle() {
        return rstyle;
    }

    public void setRstyle(String rstyle) {
        this.rstyle = rstyle;
    }

    public String getRetitnbr() {
        return retitnbr;
    }

    public void setRetitnbr(String retitnbr) {
        this.retitnbr = retitnbr;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
    }

    public String getBhmk() {
        return bhmk;
    }

    public void setBhmk(String bhmk) {
        this.bhmk = bhmk;
    }

    public String getHdcptype() {
        return hdcptype;
    }

    public void setHdcptype(String hdcptype) {
        this.hdcptype = hdcptype;
    }

    public String getSupportdept() {
        return supportdept;
    }

    public void setSupportdept(String supportdept) {
        this.supportdept = supportdept;
    }

    public String getReturntype() {
        return returntype;
    }

    public void setReturntype(String returntype) {
        this.returntype = returntype;
    }

    public String getRecqty() {
        return recqty;
    }

    public void setRecqty(String recqty) {
        this.recqty = recqty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getKssjt() {
        return kssjt;
    }

    public void setKssjt(String kssjt) {
        this.kssjt = kssjt;
    }

    public String getAstyle() {
        return astyle;
    }

    public void setAstyle(String astyle) {
        this.astyle = astyle;
    }

    public String getSupportuser() {
        return supportuser;
    }

    public void setSupportuser(String supportuser) {
        this.supportuser = supportuser;
    }

    public String getFrozenoil() {
        return frozenoil;
    }

    public void setFrozenoil(String frozenoil) {
        this.frozenoil = frozenoil;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public String getCctype() {
        return cctype;
    }

    public void setCctype(String cctype) {
        this.cctype = cctype;
    }

    public String getLitnbr() {
        return litnbr;
    }

    public void setLitnbr(String litnbr) {
        this.litnbr = litnbr;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    public String getModifyuserid() {
        return modifyuserid;
    }

    public void setModifyuserid(String modifyuserid) {
        this.modifyuserid = modifyuserid;
    }

    public String getModifyuser() {
        return modifyuser;
    }

    public void setModifyuser(String modifyuser) {
        this.modifyuser = modifyuser;
    }

    public String getModifytime() {
        return modifytime;
    }

    public void setModifytime(String modifytime) {
        this.modifytime = modifytime;
    }

    public String getCustomrequest() {
        return customrequest;
    }

    public void setCustomrequest(String customrequest) {
        this.customrequest = customrequest;
    }

    public String getDisassemblememo() {
        return disassemblememo;
    }

    public void setDisassemblememo(String disassemblememo) {
        this.disassemblememo = disassemblememo;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public String getIscheckerpbom() {
        return ischeckerpbom;
    }

    public void setIscheckerpbom(String ischeckerpbom) {
        this.ischeckerpbom = ischeckerpbom;
    }

    public String getNewProductcompid() {
        return newProductcompid;
    }

    public void setNewProductcompid(String newProductcompid) {
        this.newProductcompid = newProductcompid;
    }

    public String getOil() {
        return oil;
    }

    public void setOil(String oil) {
        this.oil = oil;
    }

    public String getOilqty() {
        return oilqty;
    }

    public void setOilqty(String oilqty) {
        this.oilqty = oilqty;
    }

    public String getFwInside() {
        return fwInside;
    }

    public void setFwInside(String fwInside) {
        this.fwInside = fwInside;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (crmno != null ? crmno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CRMHKFW006)) {
            return false;
        }
        CRMHKFW006 other = (CRMHKFW006) object;
        if ((this.crmno == null && other.crmno != null) || (this.crmno != null && !this.crmno.equals(other.crmno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.mes.entity.CRMHKFW006[ crmno=" + crmno + " ]";
    }

    public String getOasubject() {
        return oasubject;
    }

    public void setOasubject(String oasubject) {
        this.oasubject = oasubject;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getYf() {
        return yf;
    }

    public void setYf(Double yf) {
        this.yf = yf;
    }

    public Double getDzf() {
        return dzf;
    }

    public void setDzf(Double dzf) {
        this.dzf = dzf;
    }

}
