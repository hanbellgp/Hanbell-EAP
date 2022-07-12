/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKGL066;
import cn.hanbell.oa.entity.HKGL076;
import cn.hanbell.oa.entity.HKGL076DetailQ1;
import cn.hanbell.oa.entity.HKGL076DetailQ2;
import cn.hanbell.oa.entity.HKGL076DetailQ3;
import cn.hanbell.oa.entity.HKGL076DetailQ4;
import cn.hanbell.oa.entity.Users;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class HKGl076Bean extends SuperEJBForEFGP<HKGL076> {

    @EJB
    HKGL076DetailQ1Bean hkgl076DetailQ1Bean;
    @EJB
    HKGL076DetailQ2Bean hkgl076DetailQ2Bean;
    @EJB
    HKGL076DetailQ3Bean hkgl076DetailQ3Bean;
    @EJB
    HKGL076DetailQ4Bean hkgl076DetailQ4Bean;

    public HKGl076Bean() {
        super(HKGL076.class);
    }

    public List<HKGL076DetailQ1> getQ1Detail(String fsn) {
        return hkgl076DetailQ1Bean.findByFSN(fsn);
    }

    public List<HKGL076DetailQ2> getQ2Detail(String fsn) {
        return hkgl076DetailQ2Bean.findByFSN(fsn);
    }

    public List<HKGL076DetailQ3> getQ3Detail(String fsn) {
        return hkgl076DetailQ3Bean.findByFSN(fsn);
    }

    public List<HKGL076DetailQ4> getQ4Detail(String fsn) {
        return hkgl076DetailQ4Bean.findByFSN(fsn);
    }
}
