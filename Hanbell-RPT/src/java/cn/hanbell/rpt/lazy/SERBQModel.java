/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.lazy;

import cn.hanbell.crm.entity.SERBQ;
import cn.hanbell.rpt.web.SuperLazyModel;
import com.lightshell.comm.SuperEJB;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author C2082
 */
public class SERBQModel extends SuperLazyModel<SERBQ> {

    private List<SERBQ> selectData = new ArrayList<>();

    public SERBQ getRowData(String rowKey) {
        if (this.dataList != null) {
            Iterator var2 = this.dataList.iterator();
            while (var2.hasNext()) {
                SERBQ serbq = (SERBQ) var2.next();
                if (rowKey.equals(String.valueOf(serbq.getBq001()))) {
                    selectData.add(serbq);
                    return serbq;
                }
            }
        }
        return null;
    }

    public Object getRowKey(SERBQ object) {
        return super.getRowKey(object);
    }

    public List<SERBQ> getSelectData() {
        return selectData;
    }

    public void setSelectData(List<SERBQ> selectData) {
        this.selectData = selectData;
    }

    public SERBQModel(SuperEJB superEJB) {
        this.superEJB = superEJB;
    }
}
