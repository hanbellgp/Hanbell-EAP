/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.lazy;

import cn.hanbell.erp.entity.Invtrnh;
import cn.hanbell.oa.entity.HKCG007;
import cn.hanbell.rpt.web.SuperLazyModel;
import com.lightshell.comm.SuperEJB;
import java.util.Iterator;

/**
 *
 * @author C2082
 */
public class InvtrnhModel  extends SuperLazyModel<Invtrnh>{
    
    public InvtrnhModel(SuperEJB superEJB) {
        this.superEJB = superEJB;
    }
    
    public Invtrnh getRowData(String rowKey) {
        if (this.dataList != null) {
            Iterator var2 = this.dataList.iterator();

            while (var2.hasNext()) {
                Invtrnh entity = (Invtrnh) var2.next();
                if (entity.getItnbr().equals(rowKey)) {
                    return entity;
                }
            }
        }

        return null;
    }

    public Object getRowKey(Invtrnh object) {
        return super.getRowKey(object);
    }
}
