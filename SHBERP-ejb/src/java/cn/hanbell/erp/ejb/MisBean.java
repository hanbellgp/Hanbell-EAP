/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Mis;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class MisBean extends SuperEJBForERP<Mis> {

    public MisBean() {
        super(Mis.class);
    }

    public BigDecimal setdecbymis(BigDecimal decin, int decvalue, int coinsumptn) {
        BigDecimal ldc_dec;
        switch (coinsumptn) {
            case 1:
                ldc_dec = decin.setScale(decvalue, BigDecimal.ROUND_HALF_UP);
                break;
            case 3:
                if (0 == decin.setScale(decvalue, RoundingMode.DOWN).compareTo(decin)) {
                    ldc_dec = decin;
                } else {
                    ldc_dec = decin.multiply(BigDecimal.valueOf(Math.pow(10, decvalue))).setScale(0, RoundingMode.DOWN).add(BigDecimal.ONE);
                    ldc_dec = ldc_dec.divide(BigDecimal.valueOf(Math.pow(10, decvalue)));
                }
                break;
            default:
                ldc_dec = BigDecimal.ZERO;
        }
        return ldc_dec;
    }

}
