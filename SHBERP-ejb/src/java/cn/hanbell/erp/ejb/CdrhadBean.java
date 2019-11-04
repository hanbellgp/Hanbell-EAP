/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrdta;
import cn.hanbell.erp.entity.Cdrhad;
import cn.hanbell.erp.entity.Cdrlot;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class CdrhadBean extends SuperEJBForERP<Cdrhad> {

    @EJB
    private CdrdtaBean cdrdtaBean;
    @EJB
    private CdrlotBean cdrlotBean;

    private List<Cdrdta> detailList;

    public CdrhadBean() {
        super(Cdrhad.class);
    }

    @Override
    public Cdrhad findById(Object value) {
        Query query = getEntityManager().createNamedQuery("Cdrhad.findByShpno");
        query.setParameter("shpno", value);
        try {
            Object o = query.getSingleResult();
            return (Cdrhad) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<String[]> queryShpdateList(String facno, String[] itnbrs) {
        List<String[]> shpdateList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < itnbrs.length; i++) {
            String itnbr = itnbrs[i].trim();
            String[] arr = new String[2];
            arr[0] = itnbr;
            if (!"".equals(itnbr)) {
                sb.setLength(0);
                sb.append(" SELECT top 1 convert(varchar(10),shpdate,111) FROM cdrhadh h,cdrdtah d where h.shpno=d.shpno and d.facno= '${facno}' and d.itnbr =  '${itnbr}' ORDER BY shpdate ASC ");
                String sql1 = sb.toString().replace("${itnbr}", itnbr).replace("${facno}", facno);
                sb.setLength(0);
                sb.append(" SELECT top 1 convert(varchar(10),shpdate,111)  FROM cdrhad h,cdrdta d   where h.shpno=d.shpno and d.facno= '${facno}' and d.itnbr =  '${itnbr}'  ORDER BY shpdate ASC ");
                String sql2 = sb.toString().replace("${itnbr}", itnbr).replace("${facno}", facno);
                try {
                    setCompany(facno);
                    Query query1 = getEntityManager().createNativeQuery(sql1);
                    List result;
                    //第一次查询销售历史表数据，如无记录则查询现销售表数据赋值
                    result = query1.getResultList();
                    if (result != null && !result.isEmpty()) {
                        arr[1] = result.get(0).toString();
                    } else {
                        Query query2 = getEntityManager().createNativeQuery(sql2);
                        result  =query2.getResultList();
                        if (result != null && !result.isEmpty()) {
                            arr[1] = result.get(0).toString();
                        } else {
                            arr[1] = "null";
                        }
                    }
                } catch (Exception e) {
                    arr[1] = e.toString();
                }
                shpdateList.add(arr);
            }
        }
        return shpdateList;
    }

    public List<Cdrlot> findCdrlotList(String facno, String shpno) {
        cdrlotBean.setCompany(facno);
        return cdrlotBean.findByFacnoAndShpno(facno, shpno);
    }

    @Override
    public void setDetail(Object value) {
        detailList = cdrdtaBean.findByShpno(value.toString());
    }

    public List<Cdrdta> getDetail(String facno, Object o) {
        cdrdtaBean.setCompany(facno);
        return cdrdtaBean.findByShpno(o.toString());
    }

    /**
     * @return the detailList
     */
    public List<Cdrdta> getDetailList() {
        return detailList;
    }

}
