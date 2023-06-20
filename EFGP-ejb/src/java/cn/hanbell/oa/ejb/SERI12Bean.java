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
import cn.hanbell.oa.entity.SERI12;
import cn.hanbell.oa.entity.SERI12grid1SERI12;
import cn.hanbell.oa.entity.SERI12grid2SERI12;
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
public class SERI12Bean extends SuperEJBForEFGP<SERI12> {
    
    @EJB
    private SERBQBean serbqBean;
    @EJB
    private SERBRBean serbrBean;
    @EJB
    private SERI12grid1SERI12Bean seri12grid1seri12Bean;
    @EJB
    private SERI12grid2SERI12Bean seri12grid2SERI12Bean;
    
    public SERI12Bean() {
        super(SERI12.class);
    }
    
    public boolean updateSerbq(String psn) {
        SERI12 h = findByPSN(psn);
        if (h == null) {
            throw new NullPointerException();
        }
        String BQ001;
        // String BQ129; //客诉类别不回写CRM
        String BQ130;
        String BQ131;
        String BQ132;
        String BQ133;
        String BQ134;
        String BQ035;
        // 反写CRM结案人员和时间
        String BQ037;
        String BQ038;
        // List<Seri12> seri12 = findByFSN(h.getFormSerialNumber());
        BQ001 = h.getBq001();
        BQ035 = h.getBq035();
        // BQ129 = h.getBq129();

        // if (null != BQ129) {
        // switch (BQ129) {
        // case "客户投诉":
        // BQ129 = "1";
        // break;
        // case "赠送":
        // BQ129 = "2";
        // break;
        // case "技术支持":
        // BQ129 = "3";
        // break;
        // case "统包服务":
        // BQ129 = "4";
        // break;
        // case "例行巡检":
        // BQ129 = "5";
        // break;
        // case "客户财产维修":
        // BQ129 = "6";
        // break;
        // case "收费服务":
        // BQ129 = "7";
        // break;
        // case "新机调试":
        // BQ129 = "8";
        // break;
        // default:
        // return false;
        // }
        // }
        BQ130 = h.getBq130();
        BQ131 = h.getBq131();
        if (null != BQ131) {
            switch (BQ131) {
                case "汉钟原因免费":
                    BQ131 = "HZMF";
                    break;
                case "汉钟原因收费":
                    BQ131 = "HZSF";
                    break;
                case "客户原因免费":
                    BQ131 = "KHMF";
                    break;
                case "客户原因收费":
                    BQ131 = "KHSF";
                    break;
                case "柯茂客户原因免费":
                    BQ131 = "KMKHMF";
                    break;
                case "柯茂客户原因收费":
                    BQ131 = "KMKHSF";
                    break;
                case "柯茂原因免费":
                    BQ131 = "KMMF";
                    break;
                case "柯茂原因收费":
                    BQ131 = "KMSF";
                    break;
                case "其它":
                    BQ131 = "ZRQT";
                    break;
                default:
                    break;
            }
        }
        BQ132 = h.getBq132();
        BQ133 = h.getBq133();
        BQ134 = h.getBq134();
        if (null != BQ134) {
            switch (BQ134) {
                case "有效客诉":
                    BQ134 = "YX";
                    break;
                case "无效客诉":
                    BQ134 = "WX";
                    break;
                case "其他":
                    BQ134 = "QT";
                    break;
                default:
                    break;
            }
        }
        BQ037 = h.getBq037();
        BQ038 = h.getBq038();
        SERBQ BQ;
        BQ = serbqBean.findByBq001(BQ001);
        if (BQ == null) {
            throw new NullPointerException();
        }
        // BQ.setBq001(BQ001);
        BQ.setBq035(BQ035);
        // BQ.setBq500(BQ129);
        BQ.setBq501(BQ130);
        BQ.setBq502(BQ131);
        BQ.setBq503(BQ132);
        BQ.setBq504(BQ133);
        BQ.setBq505(BQ134);
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
        
        List<SERI12grid1SERI12> detail1 = seri12grid1seri12Bean.findByFSN(h.getFormSerialNumber());
        for (int i = 1; (i - 1) < detail1.size(); i++) {
            SERBR BR;
            String a = "0001";
            if (i < 10) {
                a = "000" + i;
            } else {
                a = "00" + i;
            }
            BR = serbrBean.findByPK(BQ001, a);
            BR.setBr007(BQ035);
            serbrBean.update(BR);
        }
        return true;
    }
    
    public Boolean updateSERBQ(String psn) {
        SERI12 h = findByPSN(psn);
        if (h == null) {
            throw new NullPointerException();
        }
        String facno;
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
        BQ035 = h.getBq035();
        // BQ500 = h.getBq500();

        // if (null != BQ500) {
        // switch (BQ500) {
        // case "客户投诉":
        // BQ500 = "1";
        // break;
        // case "赠送":
        // BQ500 = "2";
        // break;
        // case "技术支持":
        // BQ500 = "3";
        // break;
        // case "统包服务":
        // BQ500 = "4";
        // break;
        // case "例行巡检":
        // BQ500 = "5";
        // break;
        // case "客户财产维修":
        // BQ500 = "6";
        // break;
        // case "收费服务":
        // BQ500 = "7";
        // break;
        // case "新机调试":
        // BQ500 = "8";
        // break;
        // default:
        // return false;
        // }
        // }
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
        //CRM 未填写公司别信息，暂时只通过单号识别
        if (BQ001.startsWith("YZKF")) {
            facno = "F";
            
        } else {
            facno = "C";
        }
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
        
        List<SERI12grid1SERI12> detail1 = seri12grid1seri12Bean.findByFSN(h.getFormSerialNumber());
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
    
    public List<SERI12grid2SERI12> getDeviceList(String fsn) {
        try {
            return seri12grid2SERI12Bean.findByFSN(fsn);
        } catch (Exception ex) {
            return null;
        }
    }
    
    public SERI12 findByBq001(String kfno) {
        Query query = getEntityManager().createNamedQuery("SERI12.findByBq001");
        query.setParameter("bq001", kfno);
        try {
            return (SERI12) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
    
    public List<SERI12> findByBq037(String begin, String end) {
        Query query = getEntityManager().createNamedQuery("SERI12.findByBq037");
        query.setParameter("begin", begin);
        query.setParameter("end", end);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }
    
    public SERI12 findByPSNAndBQ110(String psn) {
        Query query = getEntityManager().createNamedQuery("SERI12.findByPSNAndBQ110");
        query.setParameter("psn", psn);
        try {
            return (SERI12) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
    
}
