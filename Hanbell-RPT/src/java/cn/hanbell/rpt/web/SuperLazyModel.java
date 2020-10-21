/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.web;

import com.lightshell.comm.SuperEJB;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author C0160
 * @param <T>
 */
public abstract class SuperLazyModel<T> extends LazyDataModel<T> {

    protected SuperEJB superEJB;
    protected List<T> dataList;
    protected Map<String, Object> filterFields;
    protected Map<String, String> sortFields;

    public SuperLazyModel() {
        this.filterFields = new HashMap<>();
        this.sortFields = new LinkedHashMap<>();
    }

    @Override
    public void setRowIndex(int rowIndex) {
        /*
         * The following is in ancestor (LazyDataModel):
         * this.rowIndex = rowIndex == -1 ? rowIndex : (rowIndex % pageSize);
         */
        if (rowIndex == -1 || getPageSize() == 0) {
            super.setRowIndex(-1);
        } else {
            super.setRowIndex(rowIndex % getPageSize());
        }
    }

    @Override
    public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        setDataList(superEJB.findByFilters(this.filterFields, first, pageSize, this.sortFields));
        setRowCount(superEJB.getRowCount(this.filterFields));
        return this.dataList;
    }

    /**
     * @return the dataList
     */
    public List<T> getDataList() {
        return dataList;
    }

    /**
     * @param dataList the dataList to set
     */
    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    /**
     * @return the filterFields
     */
    public Map<String, Object> getFilterFields() {
        return filterFields;
    }

    /**
     * @return the sortFields
     */
    public Map<String, String> getSortFields() {
        return sortFields;
    }

}
