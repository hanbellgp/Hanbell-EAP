/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKGC001;
import cn.hanbell.oa.entity.HKGC001Detail;
import cn.hanbell.oa.entity.HSYJG002;
import cn.hanbell.oa.entity.HSYJG002Detail;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class HSYJG002Bean extends SuperEJBForEFGP<HSYJG002> {

    @EJB
    private HSYJG002DetailBean hsyjg002DetailBean;

    private List<HSYJG002Detail> detailList;

    public HSYJG002Bean() {
        super(HSYJG002.class);
    }
    
    public List<HSYJG002Detail> getDetailList() {
        return detailList;
    }

    @Override
    public void setDetail(Object value) {
        detailList = hsyjg002DetailBean.findByFSN(value.toString());
        if (detailList == null) {
            detailList = new ArrayList<>();
        }
    }

}
