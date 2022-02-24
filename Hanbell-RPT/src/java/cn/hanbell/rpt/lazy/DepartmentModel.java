/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.lazy;

import cn.hanbell.eap.entity.Department;
import cn.hanbell.rpt.web.SuperLazyModel;
import com.lightshell.comm.SuperEJB;

/**
 *
 * @author C0160
 */
public class DepartmentModel extends SuperLazyModel<Department> {

    public DepartmentModel(SuperEJB superEJB) {
        this.superEJB = superEJB;
    }

}
