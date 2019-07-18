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
