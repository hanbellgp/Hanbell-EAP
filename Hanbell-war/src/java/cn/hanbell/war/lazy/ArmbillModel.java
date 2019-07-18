/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.lazy;

import cn.hanbell.eap.entity.Armbill;
import com.lightshell.comm.BaseLazyModel;
import com.lightshell.comm.SuperEJB;
import java.util.List;
import java.util.Map;
import org.primefaces.model.SortOrder;

/**
 *
 * @author C0160
 */
public class ArmbillModel extends BaseLazyModel<Armbill> {

    private final String company;

    public ArmbillModel(SuperEJB superEJB, String company) {
        this.superEJB = superEJB;
        this.company = company;
    }

    @Override
    public List<Armbill> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        filterFields.put("company =", this.company);
        return super.load(first, pageSize, sortField, sortOrder, filters);
    }

}
