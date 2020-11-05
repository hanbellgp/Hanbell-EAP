/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.lazy;

import cn.hanbell.erp.entity.FreeServiceAmt;
import cn.hanbell.rpt.web.SuperLazyModel;
import com.lightshell.comm.SuperEJB;

/**
 *
 * @author C1749
 */
public class FreeServiceAmtModel extends SuperLazyModel<FreeServiceAmt> {

    public FreeServiceAmtModel(SuperEJB superEJB) {
        this.superEJB = superEJB;
    }

    @Override
    public FreeServiceAmt getRowData(String rowKey) {
        if (dataList != null) {
            for (FreeServiceAmt entity : dataList) {
                if (entity.getId().toString().equals(rowKey)) {
                    return entity;
                }
            }
        }
        return null;
    }

    @Override
    public Object getRowKey(FreeServiceAmt t) {
        return t.getId();
    }

}
