/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.BookingDetail;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Named;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
@Named
public class BookingDetailBean extends SuperEJBForEAP<BookingDetail> {

    public BookingDetailBean() {
        super(BookingDetail.class);
    }

}
