/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.jrs;

import cn.hanbell.oa.entity.Functions;
import java.util.List;

/**
 *
 * @author C0160
 */
public class FunctionsResponseResult {

    private Integer size;
    private List<Functions> result;

    public FunctionsResponseResult() {

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
    public List<Functions> getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(List<Functions> result) {
        this.result = result;
    }

}
