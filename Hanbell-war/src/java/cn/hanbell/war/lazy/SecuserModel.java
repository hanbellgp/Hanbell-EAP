/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.lazy;

import cn.hanbell.erp.entity.Secuser;
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
 */
public class SecuserModel extends LazyDataModel<Secuser> {

    private SuperEJB superEJB;
    private List<Secuser> dataList;
    private Map<String, Object> filterFields;
    private Map<String, String> sortFields;

    public SecuserModel(SuperEJB superEJB) {
        this.superEJB = superEJB;
        this.filterFields = new HashMap<>();
        this.sortFields = new LinkedHashMap<>();
    }

    public void setRowIndex(int rowIndex) {
        if (rowIndex == -1 || getPageSize() == 0) {
            super.setRowIndex(-1);
        } else {
            super.setRowIndex(rowIndex % getPageSize());
        }
    }

    public Secuser getRowData(String rowKey) {
        for (Secuser e : dataList) {
            if (e.getUserno().equals(rowKey)) {
                return e;
            }
        }
        return null;
    }

    public Object getRowKey(Secuser t) {
        return t.getUserno();
    }

    public List<Secuser> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        setDataList(superEJB.findByFilters(this.filterFields, first, pageSize, this.sortFields));
        setRowCount(superEJB.getRowCount(this.filterFields));
        return this.dataList;
    }

    /**
     * @return the dataList
     */
    public List<Secuser> getDataList() {
        return dataList;
    }

    /**
     * @param dataList the dataList to set
     */
    public void setDataList(List<Secuser> dataList) {
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
