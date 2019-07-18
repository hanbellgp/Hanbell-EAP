/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.Sports;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class SportsBean extends SuperEJBForEAP<Sports> {

    public SportsBean() {
        super(Sports.class);
    }

    @Override
    public List<Sports> findByFilters(Map<String, Object> filters, int first, int pageSize, Map<String, String> orderBy) {
        return super.findByFilters(filters, first, pageSize, orderBy);
    }

}
