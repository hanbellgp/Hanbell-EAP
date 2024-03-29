/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;


import cn.hanbell.eap.ejb.DepartmentBean;
import cn.hanbell.eap.entity.Department;
import cn.hanbell.rpt.lazy.DepartmentModel;
import cn.hanbell.rpt.web.SuperQueryBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author C0160
 */
@ManagedBean(name = "departmentQueryBean")
@ViewScoped
public class DepartmentQueryBean extends SuperQueryBean<Department> {

    private String queryFormId;
    private String queryName;
    @EJB
    private DepartmentBean departmentBean;

    public DepartmentQueryBean() {
        super(Department.class);
    }

    @Override
    public void init() {
        superEJB = departmentBean;
        model = new DepartmentModel(departmentBean);
        model.getSortFields().put("deptno", "ASC");
        super.init();
    }

    @Override
    public void query() {
        if (this.model != null) {
            this.model.getFilterFields().clear();
            if (this.queryFormId != null && !"".equals(this.queryFormId)) {
                this.model.getFilterFields().put("deptno", this.queryFormId);
            }
            if (this.queryName != null && !"".equals(this.queryName)) {
                this.model.getFilterFields().put("dept", this.queryName);
            }
        }
    }

    public String getQueryFormId() {
        return queryFormId;
    }

    public void setQueryFormId(String queryFormId) {
        this.queryFormId = queryFormId;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

}
