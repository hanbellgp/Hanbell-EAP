/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.entity.BudgetCenterAccDetail;
import java.util.List;

/**
 *
 * @author C0160
 */
public class BudgetAccnoResponseResult {

    private Integer size;
    private List<BudgetCenterAccDetail> result;

    public BudgetAccnoResponseResult() {

    }

    /**
     * @return the size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * @return the result
     */
    public List<BudgetCenterAccDetail> getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(List<BudgetCenterAccDetail> result) {
        this.result = result;
    }

}
