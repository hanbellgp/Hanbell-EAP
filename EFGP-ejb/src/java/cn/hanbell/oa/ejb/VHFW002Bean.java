/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.crm.ejb.SERBQBean;
import cn.hanbell.crm.ejb.SERBRBean;
import cn.hanbell.crm.entity.SERBQ;
import cn.hanbell.crm.entity.SERBR;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.VHFW002;
import cn.hanbell.oa.entity.VHFW002Grid1SERI12;
import cn.hanbell.util.BaseLib;
import java.text.ParseException;
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
public class VHFW002Bean extends SuperEJBForEFGP<VHFW002> {

    @EJB
    private SERBQBean serbqBean;
    @EJB
    private SERBRBean serbrBean;
    @EJB
    private VHFW002Grid1SERI12Bean vhfw002grid1seri12Bean;


    public VHFW002Bean() {
        super(VHFW002.class);
    }

    public Boolean updateSERBQ(String psn) {
        VHFW002 h = findByPSN(psn);
        if (h == null) {
            throw new NullPointerException();
        }
        String facno = "V";  //越南CRM
        String BQ001;
        // String BQ500; //客诉类别不回写CRM20190422
        String BQ501;
        String BQ502;
        String BQ503;
        String BQ504;
        String BQ505;
        String BQ035;
        // 反写CRM结案人员和时间
        String BQ037;
        String BQ038;
        // List<Seri12> seri12 = findByFSN(h.getFormSerialNumber());
        BQ001 = h.getBq001();
        //BQ035 = h.getBq035();
        BQ035 = "Y";  // 改为已结案状态
        BQ501 = h.getBq501();
        BQ502 = h.getBq502();
        if (null != BQ502) {
            switch (BQ502) {
                case "汉钟原因免费":
                    BQ502 = "HZMF";
                    break;
                case "汉钟原因收费":
                    BQ502 = "HZSF";
                    break;
                case "客户原因免费":
                    BQ502 = "KHMF";
                    break;
                case "客户原因收费":
                    BQ502 = "KHSF";
                    break;
                case "柯茂客户原因免费":
                    BQ502 = "KMKHMF";
                    break;
                case "柯茂客户原因收费":
                    BQ502 = "KMKHSF";
                    break;
                case "柯茂原因免费":
                    BQ502 = "KMMF";
                    break;
                case "柯茂原因收费":
                    BQ502 = "KMSF";
                    break;
                case "其它":
                    BQ502 = "ZRQT";
                    break;
                default:
                    break;
            }
        }
        BQ503 = h.getBq503();
        BQ504 = h.getBq504();
        BQ505 = h.getBq505();
        if (null != BQ505) {
            switch (BQ505) {
                case "有效客诉":
                    BQ505 = "YX";
                    break;
                case "无效客诉":
                    BQ505 = "WX";
                    break;
                case "其他":
                    BQ505 = "QT";
                    break;
                default:
                    break;
            }
        }
        BQ037 = h.getBq037();
        BQ038 = h.getBq038();
        SERBQ BQ;
        serbqBean.setCompany(facno); 
        BQ = serbqBean.findByBq001(BQ001);
        if (BQ == null) {
            throw new NullPointerException();
        }
        // BQ.setBq001(BQ001);
        BQ.setBq035(BQ035);
        // BQ.setBq500(BQ500);
        BQ.setBq501(BQ501);
        BQ.setBq502(BQ502);
        BQ.setBq503(BQ503);
        BQ.setBq504(BQ504);
        BQ.setBq505(BQ505);
        BQ.setBq059("3");

        String aa;
        try {
            aa = BaseLib.formatDate("yyyyMMdd", BaseLib.getDate("yyyy/MM/dd", BQ037));
        } catch (ParseException ex) {
            aa = "";
        }
        BQ.setBq037(aa);
        BQ.setBq038(BQ038);

        serbqBean.update(BQ);

        List<VHFW002Grid1SERI12> detail1 = vhfw002grid1seri12Bean.findByFSN(h.getFormSerialNumber());
        for (int i = 1; (i - 1) < detail1.size(); i++) {
            SERBR BR;
            String a = "0001";
            if (i < 10) {
                a = "000" + i;
            } else {
                a = "00" + i;
            }
            serbrBean.setCompany(facno);
            BR = serbrBean.findByPK(BQ001, a);
            BR.setBr007(BQ035);
            serbrBean.update(BR);
        }
        return true;
    }

    public VHFW002 findByBq001(String kfno) {
        Query query = getEntityManager().createNamedQuery("VHFW002.findByBq001");
        query.setParameter("bq001", kfno);
        try {
            return (VHFW002) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<VHFW002> findByBq037(String begin, String end) {
        Query query = getEntityManager().createNamedQuery("VHFW002.findByBq037");
        query.setParameter("begin", begin);
        query.setParameter("end", end);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

}
