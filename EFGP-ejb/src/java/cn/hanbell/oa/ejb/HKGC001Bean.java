/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKGC001;
import cn.hanbell.oa.entity.HKGC001Detail;
import cn.hanbell.oa.model.HKGC001DetailModel;
import com.lightshell.comm.BaseLib;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class HKGC001Bean extends SuperEJBForEFGP<HKGC001> {

    @EJB
    private HKGC001DetailBean hkgc001DetailBean;

    private List<HKGC001Detail> detailList;

    public HKGC001Bean() {
        super(HKGC001.class);
    }

    /**
     * @return the detailList
     */
    public List<HKGC001Detail> getDetailList() {
        return detailList;
    }

    @Override
    public void setDetail(Object value) {
        detailList = hkgc001DetailBean.findByFSN(value.toString());
        if (detailList == null) {
            detailList = new ArrayList<>();
        }
    }

    public void setDetail(String fsn, String purflag) {
        detailList = hkgc001DetailBean.findByFSNAndPurchase(fsn, purflag);
        if (detailList == null) {
            detailList = new ArrayList<>();
        }
    }

    /**
     * 根据申请时间查找数据明细
     *
     * @param start
     * @param end
     * @return
     */
    public List<HKGC001DetailModel> getDetailByAppleDate(Date start, Date end) {
        StringBuffer sql = null;
        if (start != null && end != null) {
            sql = new StringBuffer("SELECT SerialNumber,applyDate FROM HK_GC001 WHERE applyDate>='");
            sql.append(BaseLib.formatDate("yyyy-MM-dd", start)).append("'and applyDate<='").append(BaseLib.formatDate("yyyy-MM-dd", end)).append("'");
        } else {
            sql = new StringBuffer("SELECT SerialNumber,applyDate FROM HK_GC001 ");
        }
        Query query = getEntityManager().createNativeQuery(sql.toString());
        try {
            List<Object[]> list = query.getResultList();
            List<HKGC001DetailModel> modeldetails = new ArrayList<HKGC001DetailModel>();
            Query q = null;

            for (Object[] str : list) {
                q = getEntityManager().createNamedQuery("HKGC001Detail.findByFSN");
                q.setParameter("fsn", str[0]);
                List<HKGC001Detail> details = q.getResultList();
                for (HKGC001Detail d : details) {
                    HKGC001DetailModel model = new HKGC001DetailModel();
                    BeanUtils.copyProperties(model, d);
                    model.setApplydate((Date) str[1]);
                    modeldetails.add(model);
                }
            }
            return modeldetails;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
