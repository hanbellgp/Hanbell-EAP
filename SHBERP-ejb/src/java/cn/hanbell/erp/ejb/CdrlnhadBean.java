/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrcus;
import cn.hanbell.erp.entity.Cdrlndta;
import cn.hanbell.erp.entity.CdrlndtaPK;
import cn.hanbell.erp.entity.Cdrlnhad;
import cn.hanbell.erp.entity.Invdou;
import cn.hanbell.erp.entity.Invmas;
import cn.hanbell.oa.ejb.HKJH007Bean;
import cn.hanbell.oa.ejb.WARMI05Bean;
import cn.hanbell.oa.entity.HKJH007;
import cn.hanbell.oa.entity.HKJH007Detail;
import cn.hanbell.oa.entity.WARMI05;
import cn.hanbell.oa.entity.WARMI05Detail;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class CdrlnhadBean extends SuperEJBForERP<Cdrlnhad> {

    @EJB
    private HKJH007Bean hkjh007Bean;
    @EJB
    private WARMI05Bean warmi05Bean;

    @EJB
    private CdrcusBean cdrcusBean;
    @EJB
    private CdrobdouBean cdrobdouBean;
    @EJB
    private CdrlndtaBean cdrlndtaBean;
    @EJB
    private InvdouBean invdouBean;
    @EJB
    private InvmasBean invmasBean;

    public CdrlnhadBean() {
        super(Cdrlnhad.class);
    }

    public Cdrlnhad findByPK(String facno, String trno) {
        Query q = this.getEntityManager().createNamedQuery("Cdrlnhad.findByPK");
        q.setParameter("facno", facno);
        q.setParameter("trno", trno);
        try {
            Object o = q.getSingleResult();
            return (Cdrlnhad) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public String initByOAHKJH007(String psn) {
        HKJH007 e = hkjh007Bean.findByPSN(psn);
        if (e == null) {
            throw new NullPointerException(psn + "没有表单实例");
        }
        if (e.getBorrowNumber() != null && !"".equals(e.getBorrowNumber())) {
            return e.getBorrowNumber();
        }
        List<HKJH007Detail> hkjh007DetailList = hkjh007Bean.getDetailList(e.getFormSerialNumber());
        if (hkjh007DetailList == null || hkjh007DetailList.isEmpty()) {
            throw new NullPointerException(psn + "没有明细内容");
        }
        String facno = e.getSupplier();
        String prono = "1";
        String trno = "";
        String trtype = "AOG";
        Date trdate = BaseLib.getDate();
        short trseq = 0;
        //获取ERP库存交易类别
        invdouBean.setCompany(facno);
        Invdou invdou = invdouBean.findByTrtype(trtype);
        if (invdou == null) {
            throw new NullPointerException("单据类别错误，ERP需要AOG");
        }
        cdrcusBean.setCompany(facno);
        Cdrcus cdrcus = cdrcusBean.findByCusno(e.getDemander());
        if (cdrcus == null) {
            throw new NullPointerException(e.getDemander() + "ERP中不存在");
        }
        //ERP借出明细
        List<Cdrlndta> addedDetail = new ArrayList();

        invmasBean.setCompany(facno);
        this.setCompany(facno);
        try {
            for (HKJH007Detail d : hkjh007DetailList) {
                trseq++;
                Cdrlndta cdrlndta = new Cdrlndta();
                CdrlndtaPK cdrlndtaPK = new CdrlndtaPK();
                cdrlndtaPK.setFacno(facno);
                //cdrlndtaPK.setTrno();
                cdrlndtaPK.setTrseq(trseq);
                cdrlndta.setCdrlndtaPK(cdrlndtaPK);
                //获取品号资料
                Invmas m = invmasBean.findByItnbr(d.getItnbr());
                if (m == null) {
                    throw new RuntimeException(d.getItnbr() + "ERP中不存在");
                }
                cdrlndta.setItnbr(d.getItnbr());
                cdrlndta.setTrnqy1(BigDecimal.valueOf(Double.parseDouble(d.getQty())));
                cdrlndta.setTrnqy2(BigDecimal.ZERO);
                cdrlndta.setWareh(d.getWareh());
                cdrlndta.setFixnr(d.getOutfixnr());
                cdrlndta.setVarnr(d.getOutvarnr());
                cdrlndta.setTrdate(trdate);
                cdrlndta.setPrebkdate(BaseLib.getDate("yyyy/MM/dd", d.getReturnDate()));
                cdrlndta.setRetqy1(BigDecimal.ZERO);
                cdrlndta.setRetqy2(BigDecimal.ZERO);
                cdrlndta.setSaleqy1(BigDecimal.ZERO);
                cdrlndta.setSaleqy2(BigDecimal.ZERO);
                cdrlndta.setStatus('N');
                cdrlndta.setProno(prono);
                cdrlndta.setArmqy(cdrlndta.getTrnqy1());
                cdrlndta.setUnpris(BigDecimal.ZERO);
                cdrlndta.setShpamts(BigDecimal.ZERO);
                cdrlndta.setBfixnr(d.getInfixnr());
                cdrlndta.setBvarnr(d.getInvarnr());
                cdrlndta.setAsrsQty(BigDecimal.ZERO);
                cdrlndta.setAsrsSta(0);
                //按ERP逻辑重新设置批号
                switch (m.getInvcls().getNrcode()) {
                    case '0':
                        cdrlndta.setFixnr("");
                        cdrlndta.setVarnr("");
                        cdrlndta.setBfixnr("");
                        cdrlndta.setBvarnr("");
                        break;
                    case '1':
                        cdrlndta.setVarnr("");
                        cdrlndta.setBvarnr("");
                        break;
                    case '2':
                        cdrlndta.setFixnr("");
                        cdrlndta.setBfixnr("");
                        break;
                    default:
                        break;
                }
                addedDetail.add(cdrlndta);
            }
            cdrobdouBean.setCompany(facno);
            trno = cdrobdouBean.getSerno(trtype, facno, trdate, "");
            Cdrlnhad cdrlnhad = new Cdrlnhad(facno, trno);
            cdrlnhad.setCdrobtype(trtype);
            cdrlnhad.setTrdate(trdate);
            cdrlnhad.setObjtype("CA");
            cdrlnhad.setDepno(e.getSupplydept());
            cdrlnhad.setCusno(e.getDemander());
            cdrlnhad.setMancode(e.getSupplyuser());
            cdrlnhad.setResno(e.getBorrowreason());
            cdrlnhad.setUserno(e.getSupplyuser());
            cdrlnhad.setIndate(trdate);
            cdrlnhad.setStatus('N');
            cdrlnhad.setPrtcnt((short) 0);
            cdrlnhad.setLnwareh("JCZC");
            cdrlnhad.setProno(prono);
            cdrlnhad.setShptrseq(cdrcus.getShptrseq());
            cdrlnhad.setTax(cdrcus.getTax());
            cdrlnhad.setTaxrate(BigDecimal.ZERO);
            cdrlnhad.setCoin("RMB");
            cdrlnhad.setRatio(BigDecimal.ONE);
            cdrlnhad.setShpamts(BigDecimal.ZERO);
            cdrlnhad.setTaxamts(BigDecimal.ZERO);
            cdrlnhad.setTotamts(BigDecimal.ZERO);
            cdrlnhad.setHeadperson(e.getSupplyuser());
            cdrlnhad.setHmark01(e.getContractNumber());
            cdrlnhad.setHmark02(e.getCustomer() + e.getCustomerName());
            cdrlnhad.setKfno(e.getCustserviceno());
            cdrlnhad.setAsrsstatus("A");
            //更新数据库
            this.persist(cdrlnhad);
            this.getEntityManager().flush();
            cdrlndtaBean.setCompany(facno);
            for (Cdrlndta d : addedDetail) {
                d.getCdrlndtaPK().setTrno(trno);
                cdrlndtaBean.persist(d);
            }
            //回写OA记录ERP单号
            e.setBorrowNumber(trno);
            hkjh007Bean.update(e);

            return trno;
        } catch (Exception ex) {
            log4j.error(ex);
            return "";
        }

    }

    public Boolean initByOAWARI05(String psn) {

        WARMI05 e = warmi05Bean.findByPSN(psn);
        if (e == null) {
            throw new NullPointerException();
        }
        if (e.getTa028() != null && !"".equals(e.getTa028())) {
            return true;
        }

        warmi05Bean.setDetail(e.getFormSerialNumber());
        if (warmi05Bean.getDetailList().isEmpty()) {
            throw new NullPointerException();
        }
        String trtype = null;
        if (e.getTa001().equals("JCDF") || e.getTa001().equals("JCDX")) {
            trtype = "AOG";
        }
        if (trtype == null) {
            throw new NullPointerException("单据类别错误，OA需要JCDF或JCDX");
        }
        String facno = e.getTa014();
        String prono = "1";
        String trno = "";
        Date trdate = BaseLib.getDate();
        short trseq = 0;
        //获取ERP库存交易类别
        invdouBean.setCompany(facno);
        Invdou invdou = invdouBean.findByTrtype(trtype);
        if (invdou == null) {
            throw new NullPointerException("单据类别错误，ERP需要AOG");
        }

        List<Cdrlndta> addedDetail = new ArrayList();
        //EclipseLink无法完成外键关联同时更新
        //HashMap<SuperEJBForERP, List<?>> detailAdded = new HashMap<>();
        //detailAdded.put(cdrlndtaBean, addedDetail);
        this.setCompany(facno);
        try {
            for (WARMI05Detail d : warmi05Bean.getDetailList()) {
                trseq++;
                Cdrlndta cdrlndta = new Cdrlndta();
                CdrlndtaPK cdrlndtaPK = new CdrlndtaPK();
                cdrlndtaPK.setFacno(facno);
                //cdrlndtaPK.setTrno();
                cdrlndtaPK.setTrseq(trseq);
                cdrlndta.setCdrlndtaPK(cdrlndtaPK);
                //获取品号资料
                invmasBean.setCompany(facno);
                Invmas m = invmasBean.findByItnbr(d.getTb004());
                if (m == null) {
                    throw new RuntimeException(d.getTb004() + "ERP中不存在");
                }
                cdrlndta.setItnbr(d.getTb004());
                if (d.getTb009() == null || "".equals(d.getTb009())) {
                    cdrlndta.setTrnqy1(BigDecimal.valueOf(Double.parseDouble(d.getTb007())));
                } else {
                    cdrlndta.setTrnqy1(BigDecimal.valueOf(Double.parseDouble(d.getTb009())));
                }
                cdrlndta.setTrnqy2(BigDecimal.ZERO);
                cdrlndta.setWareh(d.getTb010());
                cdrlndta.setFixnr(d.getTb011());
                cdrlndta.setVarnr(d.getTb019());
                cdrlndta.setTrdate(trdate);
                cdrlndta.setPrebkdate(trdate);
                cdrlndta.setRetqy1(BigDecimal.ZERO);
                cdrlndta.setRetqy2(BigDecimal.ZERO);
                cdrlndta.setSaleqy1(BigDecimal.ZERO);
                cdrlndta.setSaleqy2(BigDecimal.ZERO);
                cdrlndta.setStatus('N');
                cdrlndta.setProno(prono);
                cdrlndta.setArmqy(cdrlndta.getTrnqy1());
                cdrlndta.setUnpris(BigDecimal.ZERO);
                cdrlndta.setShpamts(BigDecimal.ZERO);
                cdrlndta.setBfixnr(cdrlndta.getFixnr());
                cdrlndta.setBvarnr(e.getTa036());
                cdrlndta.setAsrsQty(BigDecimal.ZERO);
                cdrlndta.setAsrsSta(0);
                //按ERP逻辑重新设置批号
                switch (m.getInvcls().getNrcode()) {
                    case '0':
                        cdrlndta.setFixnr("");
                        cdrlndta.setVarnr("");
                        cdrlndta.setBfixnr("");
                        cdrlndta.setBvarnr("");
                        break;
                    case '1':
                        cdrlndta.setVarnr("");
                        cdrlndta.setBvarnr("");
                        break;
                    case '2':
                        cdrlndta.setFixnr("");
                        cdrlndta.setBfixnr("");
                        break;
                    default:
                        break;
                }
                addedDetail.add(cdrlndta);
            }
            cdrobdouBean.setCompany(facno);
            trno = cdrobdouBean.getSerno(trtype, facno, trdate, "");
            Cdrlnhad cdrlnhad = new Cdrlnhad(facno, trno);
            cdrlnhad.setCdrobtype(trtype);
            cdrlnhad.setTrdate(trdate);
            cdrlnhad.setObjtype("CA");
            cdrlnhad.setDepno(e.getTa004());
            cdrlnhad.setCusno(e.getTa032());
            cdrlnhad.setMancode(e.getTa012());
            cdrlnhad.setResno(e.getTa043());
            cdrlnhad.setUserno(e.getTa012());
            cdrlnhad.setIndate(trdate);
            cdrlnhad.setStatus('N');
            cdrlnhad.setPrtcnt((short) 0);
            cdrlnhad.setLnwareh("JCZC");
            cdrlnhad.setProno(prono);
            cdrlnhad.setShptrseq((short) 1);
            cdrlnhad.setTax('4');
            cdrlnhad.setTaxrate(BigDecimal.ZERO);
            cdrlnhad.setCoin("RMB");
            cdrlnhad.setRatio(BigDecimal.ONE);
            cdrlnhad.setShpamts(BigDecimal.ZERO);
            cdrlnhad.setTaxamts(BigDecimal.ZERO);
            cdrlnhad.setTotamts(BigDecimal.ZERO);
            cdrlnhad.setHeadperson(e.getTa012());
            cdrlnhad.setKfno(e.getTa039());
            cdrlnhad.setFwno(e.getTa040() + e.getTa041());
            cdrlnhad.setBugdsc(e.getTa037());
            cdrlnhad.setAsrsstatus("A");

            this.persist(cdrlnhad);
            this.getEntityManager().flush();
            cdrlndtaBean.setCompany(facno);
            for (Cdrlndta d : addedDetail) {
                d.getCdrlndtaPK().setTrno(trno);
                cdrlndtaBean.persist(d);
            }
            //this.persist(cdrlnhad, detailAdded);
            //回写OA记录ERP单号
            e.setTa028(trno);
            warmi05Bean.update(e);

            return true;
        } catch (Exception ex) {
            log4j.error(ex);
            return false;
        }

    }

    /**
     *
     * @param kfno
     * @return CDRN20借出归还单运费
     */
    public List getCustomerComplaintExpense(String kfno) {
        StringBuilder sb = new StringBuilder();
        sb.append(" select 'tansportexpense' as type ,N'ERP借出归还单' as  sources,kfno,fwno,mancode AS userno,e.cdesc as userna, ");
        sb.append(" h.depno,m.depname AS deptna,CONVERT(varchar(100), trdate, 112) as occurdate,(CASE cdrobtype WHEN 'AOF' THEN '不良借出单' WHEN 'AOG' THEN '借出单'");
        sb.append(" WHEN 'AOT' THEN '拖工借出单'END ) as expensetype ,(SELECT miscode.cdesc FROM miscode WHERE miscode.ckind='IL' and miscode.code=h.resno ) as custom1, ");
        sb.append(" h.cusno as custom2, s.cusna as custom3,h.trno as sourcesno,isnull(c.freight,0) AS expense ,bugdsc as remark1 ");
        sb.append(" from cdrlnhad h LEFT JOIN cdrfre c on c.shpno = h.trno and c.facno = h.facno LEFT JOIN miscode e ON  e.code=h.mancode LEFT JOIN cdrcus s on s.cusno=h.cusno ");
        sb.append(" LEFT JOIN misdept m on m.depno=h.depno where  h.status ='Y' and ckind ='9E' AND h.kfno='${kfno}' ");
        try {
            String sql = sb.toString().replace("${kfno}", kfno);
            setCompany("C");
            Query query = getEntityManager().createNativeQuery(sql);
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     *
     * @param fwno
     * @return CDRN20借出归还单运费
     */
    public BigDecimal getERPTrafficAmt(String fwno) {
        StringBuilder sb = new StringBuilder();
        BigDecimal amt;
        sb.append(" select isnull(sum(c.freight),0) as amt from cdrlnhad h LEFT JOIN cdrfre c on c.shpno = h.trno and c.facno = h.facno ");
        sb.append(" where  h.status ='Y' AND h.fwno='${fwno}' ");
        try {
            String sql = sb.toString().replace("${fwno}", fwno);
            setCompany("C");
            Query query = getEntityManager().createNativeQuery(sql);
            Object o = query.getSingleResult();
            amt = BigDecimal.valueOf(Double.valueOf(o.toString()));
            return amt;
        } catch (NumberFormatException e) {
            return BigDecimal.ZERO;
        }
    }

}
