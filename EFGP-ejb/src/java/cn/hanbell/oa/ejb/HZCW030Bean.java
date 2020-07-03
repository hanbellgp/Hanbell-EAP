/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HZCW030;
import cn.hanbell.oa.entity.HZCW030Detail1;
import cn.hanbell.oa.entity.HZCW030Detail2;
import cn.hanbell.oa.entity.HZCW030Detail3;
import cn.hanbell.oa.entity.HZCW030Detail4;
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
public class HZCW030Bean extends SuperEJBForEFGP<HZCW030> {

    @EJB
    private HZCW030Detail1Bean hzcw030Datail1Bean;
    @EJB
    private HZCW030Detail2Bean hzcw030Datail2Bean;
    @EJB
    private HZCW030Detail3Bean hzcw030Datail3Bean;
    @EJB
    private HZCW030Detail4Bean hzcw030Datail4Bean;

    public HZCW030Bean() {
      
        super(HZCW030.class);
    }

    @Override
    public HZCW030 findById(Object value) {
        return super.findByPSN(value);
    }

    /**
     * 费用预算追加明细清单
     * @param value
     * @return 
     */
    public List<HZCW030Detail1> getDetailList1(Object value) {
        return hzcw030Datail1Bean.findByFSN(value);
    }

    /**
     * 费用预算追加明细之（通讯费/差率费/交际应酬费）
     * @param value
     * @return 
     */
    public List<HZCW030Detail2> getDetailList2(Object value) {
        return hzcw030Datail2Bean.findByFSN(value);
    }

     /**
     * 费用预算调拨明细清单
     * @param value
     * @return 
     */
    public List<HZCW030Detail3> getDetailList3(Object value) {
        return hzcw030Datail3Bean.findByFSN(value);
    }

    /**
     * 费用预算调拨明细之（通讯费/差率费/交际应酬费）
     * @param value
     * @return 
     */
    public List<HZCW030Detail4> getDetailList4(Object value) {
        return hzcw030Datail4Bean.findByFSN(value);
    }
}
