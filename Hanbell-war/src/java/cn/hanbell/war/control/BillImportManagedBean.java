/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.control;

import cn.hanbell.eap.entity.Armbill;
import cn.hanbell.eap.entity.ArmbillDetail;
import cn.hanbell.erp.ejb.ArmbilBean;
import cn.hanbell.erp.entity.Armbil;
import cn.hanbell.erp.entity.Cdrcus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author C0160
 */
@ManagedBean(name = "billImportManagedBean")
@SessionScoped
public class BillImportManagedBean extends BillPrintManagedBean {

    @EJB
    private ArmbilBean armbilBean;

    private List<Armbil> armbilList;
    private List<Armbil> armbilSelected;
    private HashMap<String, Object> filters;

    public BillImportManagedBean() {
    }

    @Override
    public void handleDialogReturnWhenNew(SelectEvent event) {
        if (event.getObject() != null) {
            Cdrcus c = (Cdrcus) event.getObject();
            this.queryFormId = c.getCusno();
            this.queryName = c.getCusds();
        }
    }

    @Override
    public void init() {
        armbilList = new ArrayList<>();
        armbilSelected = new ArrayList<>();
        filters = new HashMap<>();
        super.init();
    }

    @Override
    public void query() {
        armbilList.clear();
        filters.clear();
        filters.put("cusno", queryFormId);
        filters.put("bildatBegin", queryDateBegin);
        filters.put("bildatEnd", queryDateEnd);
        filters.put("bilstat", '3');
        armbilBean.setCompany(this.userManagedBean.getCompany());
        armbilList = armbilBean.findByFilters(filters);
    }

    @Override
    public void verify() {
        if (armbilSelected == null || armbilSelected.isEmpty()) {
            showWarnMsg("Warn", "没有选择任何发票");
            return;
        }
        String formid;
        int seq = 0;
        ArmbillDetail bd;
        List<ArmbillDetail> armbillDetails = new ArrayList<>();

        Armbil a = armbilSelected.get(0);
        Armbill b = new Armbill();
        b.setCompany(a.getArmbilPK().getFacno());
        b.setFormdate(getDate());
        b.setCustomerno(a.getCusno());
        b.setCustomer(a.getCdrcus().getCusds());
        b.setDeptno(a.getDepno());
        b.setUserno(a.getMancode());
        b.setStatus("N");
        b.setCreator(this.userManagedBean.getCurrentUser().getUsername());
        b.setCredate(getDate());

        for (Armbil e : armbilSelected) {
            seq++;
            bd = new ArmbillDetail();
            bd.setSeq(seq);
            bd.setBillno(e.getArmbilPK().getBilno());
            bd.setBilldate(e.getBildat());
            bd.setExtaxes(e.getBilamt());
            bd.setTaxes(e.getBiltax());
            bd.setAmts(e.getBilamt().add(e.getBiltax()));
            armbillDetails.add(bd);
        }
        try {
            formid = armbillBean.initArmbill(b, armbillDetails);
            if (formid != null) {
                this.armbilSelected.clear();
                this.armbilList.clear();
                showInfoMsg("Info", "成功生成发票回执单" + formid);
            } else {
                showErrorMsg("Error", "产生发票回执资料失败");
            }
        } catch (Exception ex) {
            showErrorMsg("Error", ex.getMessage());
        }
    }

    /**
     * @return the armbilList
     */
    public List<Armbil> getArmbilList() {
        return armbilList;
    }

    /**
     * @return the armbilSelected
     */
    public List<Armbil> getArmbilSelected() {
        return armbilSelected;
    }

    /**
     * @param armbilSelected the armbilSelected to set
     */
    public void setArmbilSelected(List<Armbil> armbilSelected) {
        this.armbilSelected = armbilSelected;
    }

}
