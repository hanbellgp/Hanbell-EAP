/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrbrdta;
import cn.hanbell.erp.entity.CdrbrdtaPK;
import cn.hanbell.erp.entity.Cdrbrhad;
import cn.hanbell.erp.entity.CdrbrhadPK;
import cn.hanbell.erp.entity.Invbal;
import cn.hanbell.erp.entity.Invbat;
import cn.hanbell.erp.entity.Invmas;
import cn.hanbell.oa.ejb.HKFW006Bean;
import cn.hanbell.oa.ejb.HKFW006Cdrn30Bean;
import cn.hanbell.oa.ejb.HKFW006Cdrn30DetailBean;
import cn.hanbell.oa.entity.HKFW006;
import cn.hanbell.oa.entity.HKFW006Cdrn30;
import cn.hanbell.oa.entity.HKFW006Cdrn30Detail;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class CdrbrhadBean extends SuperEJBForERP<Cdrbrhad> {

    @EJB
    private CdrobdouBean cdrobdouBean;
    @EJB
    private CdrlnhadBean cdrlnhadBean;
    @EJB
    private CdrbrhadBean cdrbrhadBean;
    @EJB
    private CdrbrdtaBean cdrbrdtaBean;
    @EJB
    private HKFW006Cdrn30Bean hkfw006Cdrn30Bean;
    @EJB
    private HKFW006Cdrn30DetailBean hkfw006Cdrn30DetailBean;
    @EJB
    private HKFW006Bean hkfw006Bean;
    @EJB
    private InvbalBean invbalBean;
    @EJB
    private InvbatBean invbatBean;
    @EJB
    private InvmasBean invmasBean;

    public CdrbrhadBean() {
        super(Cdrbrhad.class);
    }

    public Cdrbrhad findByPK(String facno, String brtrno) {
        Query q = this.getEntityManager().createNamedQuery("Cdrbrhad.findByPK");
        q.setParameter("facno", facno);
        q.setParameter("brtrno", brtrno);
        try {
            Object o = q.getSingleResult();
            return (Cdrbrhad) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public Boolean initByOAHKFW006(String psn) {
        try {
            HKFW006Cdrn30 h = hkfw006Cdrn30Bean.findByPSN(psn);
            if (h == null) {
                throw new NullPointerException();
            }
            List<HKFW006Cdrn30Detail> details = hkfw006Cdrn30DetailBean.findByFSN(h.getFormSerialNumber());
            if (details == null || details.size() <= 0) {
                throw new NullPointerException();
            }
            Date date;
            String facno = h.getFacno();
            String prono = h.getProno();
            List<Invbal> invbalList = new ArrayList();
            List<Invbat> invbatList = new ArrayList();
            Invbal invbal;
            Invbat invbat;
            invmasBean.setCompany(facno);
            invbalBean.setCompany(facno);
            invbatBean.setCompany(facno);
            String cdrobty = h.getCdrobty();
            date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
            String brtrno = cdrobdouBean.getSerno(cdrobty, facno, date, "");
            Cdrbrhad cdrbrhad = new Cdrbrhad();
            CdrbrhadPK pk = new CdrbrhadPK();
            pk.setFacno(facno);
            pk.setBrtrno(brtrno);
            cdrbrhad.setCdrbrhadPK(pk);
            cdrbrhad.setCdrobtype(cdrobty);
            cdrbrhad.setCusno(h.getCusno());
            cdrbrhad.setBrdate(date);
            cdrbrhad.setDepno(h.getDepno());
            cdrbrhad.setHmark01(h.getHmark01());
            cdrbrhad.setUserno(h.getUserno());
            cdrbrhad.setStatus('N');
            cdrbrhad.setLnwareh("JCZC");
            cdrbrhad.setPrtcnt((short) 1);
            cdrbrhad.setObjtype(h.getObjtype());
            String srcno = h.getProcessSerialNumber().substring(4);
            cdrbrhad.setHmark03(srcno);
            cdrbrhad.setProno(h.getProno());
            cdrbrhad.setIndate(BaseLib.getDate("yyyy/MM/dd", h.getIndate()));
            cdrbrhad.setHmark02(h.getHmark02());
            this.setCompany(facno);
            persist(cdrbrhad);

            //  表身循环
            for (int i = 0; i < details.size(); i++) {
                HKFW006Cdrn30Detail detail = details.get(i);
                Cdrbrdta cdrbrdta = new Cdrbrdta();
                CdrbrdtaPK cdrbrdtaPK = new CdrbrdtaPK();
                cdrbrdtaPK.setBrtrno(brtrno);
                cdrbrdtaPK.setFacno(facno);
                cdrbrdtaPK.setTrseq((short) (i + 1));
                cdrbrdta.setCdrbrdtaPK(cdrbrdtaPK);
                cdrbrdta.setLntrno(detail.getBrowno());
                cdrbrdta.setLntrseq(Short.parseShort(detail.getTrseq()));
                cdrbrdta.setItnbr(detail.getItnbr());
                cdrbrdta.setWareh(detail.getWareh());
                cdrbrdta.setVarnr(detail.getVarnr());
                cdrbrdta.setFixnr(detail.getFixnr());
                cdrbrdta.setBrpqy1(BigDecimal.valueOf(Double.parseDouble(detail.getBrpqy1())));
                cdrbrdta.setBrpqy2(BigDecimal.ZERO);
                cdrbrdta.setBrdate(cdrbrhad.getBrdate());
                cdrbrdta.setPyhbrdate(BaseLib.getDate("yyyy/MM/dd", detail.getPrebkdate()));
                cdrbrdta.setProno(h.getProno());
                cdrbrdta.setAsrsSta(0);
                cdrbrdta.setDmark1(detail.getDmark1());
                cdrbrdta.setDmark2(detail.getDmark2());
                Invmas m = invmasBean.findByItnbr(cdrbrdta.getItnbr());
                if (m == null) {
                    throw new RuntimeException(cdrbrdta.getItnbr() + "ERP中不存在");
                }
                 //按ERP逻辑重新设置批号
                switch (m.getInvcls().getNrcode()) {
                    case '0':
                        cdrbrdta.setFixnr("");
                        cdrbrdta.setVarnr("");
                        cdrbrdta.setDmark1("");
                        cdrbrdta.setDmark2("");
                        break;
                    case '1':
                        cdrbrdta.setVarnr("");
                        cdrbrdta.setDmark2("");
                        break;
                    case '2':
                        cdrbrdta.setFixnr("");
                        cdrbrdta.setDmark1("");
                        break;
                    default:
                        break;
                }
                
                cdrbrdtaBean.setCompany(facno);
                cdrbrdtaBean.persist(cdrbrdta);

                //更新ERP invbat/invbal   
                invbal = new Invbal(facno, prono, cdrbrdta.getItnbr(), "JCZC");
                invbal.setItcls(m.getItcls());
                invbal.setItclscode(m.getItclscode());
                invbal.setPreqy1(cdrbrdta.getBrpqy1());
                //加入库存更新列表
                invbalList.add(invbal);
                //批号可利用量检查
                if (m.getInvcls().getNrcode() != '0') {
                    invbat = new Invbat(facno, prono, cdrbrdta.getItnbr(), "JCZC", cdrbrdta.getFixnr(), cdrbrdta.getVarnr());
                    invbat.setItcls(m.getItcls());
                    invbat.setItclscode(m.getItclscode());
                    invbat.setPreqy1(cdrbrdta.getBrpqy1());
                    //加入库存更新列表
                    invbatList.add(invbat);

                }
            }

            //更新ERP库存数量 //入库增加库存
            invbalBean.add(invbalList);
            invbatBean.add(invbatList);

            //反写OA归还单号
            h.setPzno(brtrno);
            this.getEntityManager().flush();
            hkfw006Cdrn30Bean.update(h);
            HKFW006 fw006 = hkfw006Bean.findByPSN(psn);
            fw006.setPzno(brtrno);
            hkfw006Bean.update(fw006);

            return true;
        } catch (NullPointerException | ParseException ex) {
            Logger.getLogger(CdrbrhadBean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
