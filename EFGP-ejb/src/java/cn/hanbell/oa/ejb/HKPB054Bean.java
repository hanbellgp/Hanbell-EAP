/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKPB054;
import cn.hanbell.oa.entity.HKPB054Detail;
import cn.hanbell.oa.entity.HKPB054DetailB;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author C1749
 */
@Stateless
@LocalBean
public class HKPB054Bean extends SuperEJBForEFGP<HKPB054> {
    
    @EJB
    private HKPB054DetailBean hkpbdbDetailBean;
    @EJB
    private HKPB054DetailBBean hkpb054DetailBBean;
    
    private List<HKPB054Detail> hkpb054DetalList;
    
    private List<HKPB054DetailB> hkpb054DetailBList;

    public HKPB054Bean() {
        super(HKPB054.class);
    }

    public List<HKPB054Detail> getHkpb054DetalList() {
        return hkpb054DetalList;
    }

    public void setHkpb054DetalList(Object value) {
        hkpb054DetalList = hkpbdbDetailBean.findByFSN(value.toString());
        if (hkpb054DetalList == null) {
            hkpb054DetalList = new ArrayList<>();
        }
    }

    public List<HKPB054DetailB> getHkpb054DetailBList() {
        return hkpb054DetailBList;
    }

    public void setHkpb054DetailBList(Object value) {
        hkpb054DetailBList = hkpb054DetailBBean.findByFSN(value.toString());
        if (hkpb054DetailBList == null) {
            hkpb054DetailBList = new ArrayList<>();
        }
    }


}
