/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.crm.ejb.REPTCBean;
import cn.hanbell.crm.ejb.SERCABean;
import cn.hanbell.eap.comm.MailNotify;
import cn.hanbell.eap.ejb.CustomerComplaintBean;
import cn.hanbell.eap.ejb.CustomerComplaintExpenseBean;
import cn.hanbell.eap.ejb.CustomerComplaintMaterialBean;
import cn.hanbell.eap.ejb.MailNotificationBean;
import cn.hanbell.eap.entity.CustomerComplaint;
import cn.hanbell.eap.entity.CustomerComplaintExpense;
import cn.hanbell.eap.entity.CustomerComplaintMaterial;
import cn.hanbell.erp.ejb.CdrlnhadBean;
import cn.hanbell.erp.ejb.InvhadBean;
import cn.hanbell.oa.ejb.HKFW005Bean;
import cn.hanbell.oa.ejb.HKFW006Bean;
import cn.hanbell.oa.ejb.SERI12Bean;
import cn.hanbell.oa.entity.SERI12;
import com.lightshell.comm.BaseLib;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author C1879
 */
@ManagedBean(name = "customerComplaintSetManagedBean")
@javax.faces.bean.ViewScoped
public class CustomerComplaintSetManagedBean implements Serializable {

    @EJB
    private CustomerComplaintBean customerComplaintBean;
    @EJB
    private CustomerComplaintExpenseBean complaintExpenseBean;
    @EJB
    private CustomerComplaintMaterialBean complaintMaterialBean;
    @EJB
    private SERI12Bean seri12Bean;
    @EJB
    private SERCABean sercaBean;
    @EJB
    private HKFW005Bean hkfw005Bean;
    @EJB
    private HKFW006Bean hkfw006Bean;
    @EJB
    private CdrlnhadBean cdrlnhadBean;
    @EJB
    private REPTCBean reptcBean;
    @EJB
    private InvhadBean invhadBean;
    @EJB
    private MailNotificationBean mailBean;

    private Date begin;
    private Date end;
    private String selectKfno;
    private Boolean checked;
    private String number;

    public void reset() {
        begin = null;
        end = null;
        selectKfno = null;
        checked = true;
        number = null;
    }

    public void sendMail() {
        if (number != null && selectKfno != null) {
            try {
                mailBean.getTo().clear();
                mailBean.getTo().add(getNumber().trim() + "@hanbell.com.cn");
                mailBean.setMailSubject("客诉结案抛转详细");
                mailBean.setMailContent(customerComplaintBean.getMail("客诉结案抛转详细", selectKfno));
                mailBean.notify(new MailNotify());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "info", "邮件派送成功"));
            } catch (Exception e) {
            }

        }
    }

    public void selectCreateCustomerComplaint() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        List<SERI12> list = new ArrayList<>();
        if (!checked) {
            if (begin != null || end != null) {
                list = seri12Bean.findByBq037(df.format(begin), df.format(end));
            }
        } else {
            SERI12 seri12 = seri12Bean.findByBq001(selectKfno);
            if (seri12 != null) {
                list.add(seri12);
            }
        }
        int count = createCustomerComplaintByEAP(list);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "info", "查询出数据共" + list.size() + "条，成功导入EAP数据库共计" + count + "条"));
    }

    public int createCustomerComplaintByEAP(List<SERI12> list) {
        int count = 0;
        BigDecimal travel, tansport, material;
        //差旅
        List<CustomerComplaintExpense> travelList;
        //运费
        List<CustomerComplaintExpense> tansportList;
        //材料
        List<CustomerComplaintMaterial> materialList;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            for (SERI12 seri12 : list) {
                travel = BigDecimal.ZERO;
                tansport = BigDecimal.ZERO;
                material = BigDecimal.ZERO;
                String kfno = seri12.getBq001();
                CustomerComplaint cp = new CustomerComplaint();
                String varnr = sercaBean.findCa009ByCa001(kfno) == null ? "" : sercaBean.findCa009ByCa001(kfno);
                cp.setKfno(seri12.getBq001());
                cp.setCusno(seri12.getBq002() == null ? "null" : seri12.getBq002());
                cp.setCusna(seri12.getBq002c() == null ? "null" : seri12.getBq002c());
                cp.setVarnr(varnr);
                cp.setNcodeDC(seri12.getBq197() == null ? "null" : seri12.getBq197());
                cp.setNcodeCD(seri12.getBq198() == null ? "null" : seri12.getBq198());
                cp.setNcodeDD(seri12.getBq003() == null ? "null" : seri12.getBq003());
                cp.setDutydeptno(seri12.getBq504() == null ? "null" : seri12.getBq504());
                cp.setDutydeptna(seri12.getBq504c() == null ? "null" : seri12.getBq504c());
                cp.setDutyrate(seri12.getPropotion() == null ? "null" : seri12.getPropotion());
                cp.setCredate(BaseLib.getDate("yyyy/MM/dd", seri12.getBq021()));
                cp.setOverdate(BaseLib.getDate("yyyy/MM/dd", seri12.getBq037()));
                cp.setBadwhy(seri12.getBq503() == null ? "null" : seri12.getBq503());
                //一、运输费
                tansportList = new ArrayList<>();
                CustomerComplaintExpense cce;
                List hkfw005s = hkfw005Bean.getTansportExpense(kfno);
                if (hkfw005s != null && !hkfw005s.isEmpty()) {
                    for (int i = 0; i < hkfw005s.size(); i++) {
                        Object[] row = (Object[]) hkfw005s.get(i);
                        cce = new CustomerComplaintExpense();
                        cce.setType(row[0].toString());
                        cce.setSources(row[1].toString());
                        cce.setKfno(row[2].toString());
                        cce.setFwno(row[3] == null ? "null" : row[3].toString());
                        cce.setUserno(row[4] == null ? "null" : row[4].toString());
                        cce.setUserna(row[5] == null ? "null" : row[5].toString());
                        cce.setDeptno(row[6] == null ? "null" : row[6].toString());
                        cce.setDeptna(row[7] == null ? "null" : row[7].toString());
                        cce.setOccurdate(row[8] == null ? "null" : row[8].toString());
                        cce.setExpensetype(row[9] == null ? "null" : row[9].toString());
                        cce.setCustom1(hkfw005Bean.getYsStyleName(row[10].toString()));
                        cce.setCustom2(row[11] == null ? "null" : row[11].toString());
                        cce.setCustom3(row[12] == null ? "null" : row[12].toString());
                        cce.setCustom4(row[13] == null ? "null" : row[13].toString());
                        cce.setExpense(BigDecimal.valueOf(Double.parseDouble(row[14].toString())));
                        cce.setRemark1(row[15] == null ? "null" : row[15].toString());
                        cce.setSourcesno(row[16] == null ? "null" : row[16].toString());
                        tansportList.add(cce);
                    }
                }
                List hkfw006s = hkfw006Bean.getTansportExpense(kfno);
                if (hkfw006s != null && !hkfw006s.isEmpty()) {
                    for (int i = 0; i < hkfw006s.size(); i++) {
                        Object[] row = (Object[]) hkfw006s.get(i);
                        cce = new CustomerComplaintExpense();
                        cce.setType(row[0].toString());
                        cce.setSources(row[1].toString());
                        cce.setKfno(row[2].toString());
                        cce.setFwno(row[3] == null ? "null" : row[3].toString());
                        cce.setUserno(row[4] == null ? "null" : row[4].toString());
                        cce.setUserna(row[5] == null ? "null" : row[5].toString());
                        cce.setDeptno(row[6] == null ? "null" : row[6].toString());
                        cce.setDeptna(row[7] == null ? "null" : row[7].toString());
                        cce.setOccurdate(row[8] == null ? "null" : row[8].toString());
                        cce.setExpensetype(row[9] == null ? "null" : row[9].toString());
                        cce.setCustom1(row[10] == null ? "null" : row[10].toString());
                        cce.setCustom2(row[11] == null ? "null" : row[11].toString());
                        cce.setCustom3(row[12] == null ? "null" : row[12].toString());
                        cce.setCustom4(row[13] == null ? "null" : row[13].toString());
                        cce.setExpense(BigDecimal.valueOf(Double.parseDouble(row[14].toString())));
                        cce.setRemark1(row[15] == null ? "null" : row[15].toString());
                        cce.setSourcesno(row[16] == null ? "null" : row[16].toString());
                        tansportList.add(cce);
                    }
                }
                List cdrlnhads = cdrlnhadBean.getCustomerComplaintExpense(kfno);
                if (cdrlnhads != null && !cdrlnhads.isEmpty()) {
                    for (int i = 0; i < cdrlnhads.size(); i++) {
                        Object[] row = (Object[]) cdrlnhads.get(i);
                        cce = new CustomerComplaintExpense();
                        cce.setType(row[0].toString());
                        cce.setSources(row[1].toString());
                        cce.setKfno(row[2].toString());
                        cce.setFwno(row[3] == null ? "null" : row[3].toString());
                        cce.setUserno(row[4] == null ? "null" : row[4].toString());
                        cce.setUserna(row[5] == null ? "null" : row[5].toString());
                        cce.setDeptno(row[6] == null ? "null" : row[6].toString());
                        cce.setDeptna(row[7] == null ? "null" : row[7].toString());
                        cce.setOccurdate(row[8] == null ? "null" : row[8].toString());
                        cce.setExpensetype(row[9] == null ? "null" : row[9].toString());
                        cce.setCustom1(row[10] == null ? "null" : row[11].toString());
                        cce.setCustom2(row[11] == null ? "null" : row[12].toString());
                        cce.setCustom3(row[12] == null ? "null" : row[12].toString());
                        cce.setCustom4(row[13] == null ? "null" : row[13].toString());
                        cce.setExpense(BigDecimal.valueOf(Double.parseDouble(row[14].toString())));
                        cce.setRemark1(row[15] == null ? "null" : row[15].toString());
                        tansportList.add(cce);
                    }
                }
                //二、差旅费
                travelList = new ArrayList<>();
                List repts = reptcBean.getCustomerComplaintExpense(kfno);
                if (repts != null && !repts.isEmpty()) {
                    for (int i = 0; i < repts.size(); i++) {
                        Object[] row = (Object[]) repts.get(i);
                        cce = new CustomerComplaintExpense();
                        cce.setType(row[0].toString());
                        cce.setSources(row[1].toString());
                        cce.setKfno(row[2].toString());
                        cce.setFwno(row[3] == null ? "null" : row[3].toString());
                        cce.setUserno(row[4] == null ? "null" : row[4].toString());
                        cce.setUserna(row[5] == null ? "null" : row[5].toString());
                        cce.setDeptno(row[6] == null ? "null" : row[6].toString());
                        cce.setDeptna(row[7] == null ? "null" : row[7].toString());
                        cce.setSerialno(row[8] == null ? "null" : row[8].toString());
                        cce.setOccurdate(row[9] == null ? "null" : row[9].toString());
                        cce.setExpensetype(row[10] == null ? "null" : row[10].toString());
                        cce.setCustom1(row[11] == null ? "null" : row[11].toString());
                        cce.setCustom2(row[12] == null ? "null" : row[12].toString());
                        cce.setExpense(BigDecimal.valueOf(Double.parseDouble(row[13].toString())));
                        cce.setRemark1(row[14] == null ? "null" : row[14].toString());
                        cce.setSourcesno(row[15] == null ? "null" : row[15].toString());
                        cce.setSourcesdate(row[16] == null ? "null" : row[16].toString());
                        tansportList.add(cce);
                    }
                }
                //三、材料费
                materialList = new ArrayList<>();
                CustomerComplaintMaterial cpd;
                List invhadhs = invhadBean.getCustomerComplaintMaterial(kfno);
                if (invhadhs != null && !invhadhs.isEmpty()) {
                    for (int i = 0; i < invhadhs.size(); i++) {
                        Object[] row = (Object[]) invhadhs.get(i);
                        cpd = new CustomerComplaintMaterial();
                        cpd.setKfno(row[0].toString());
                        cpd.setFwno(row[1] == null ? "null" : row[1].toString());
                        cpd.setTrtype(row[2] == null ? "null" : row[2].toString());
                        cpd.setTypedsc(row[3] == null ? "null" : row[3].toString());
                        cpd.setTrno(row[4] == null ? "null" : row[4].toString());
                        cpd.setTrdate(df.parse(row[5].toString()));
                        cpd.setTrseq(row[6] == null ? 0 : Integer.parseInt(row[6].toString()));
                        cpd.setItnbr(row[7] == null ? "null" : row[7].toString());
                        cpd.setItdsc(row[8] == null ? "null" : row[8].toString());
                        cpd.setTrnqy1(row[9] == null ? BigDecimal.ZERO : BigDecimal.valueOf(Double.parseDouble(row[9].toString())));
                        cpd.setUnmsr1(row[10] == null ? "null" : row[10].toString());
                        cpd.setTramt(row[11] == null ? BigDecimal.ZERO : BigDecimal.valueOf(Double.parseDouble(row[11].toString())));
                        materialList.add(cpd);
                    }
                }
                List invhads = invhadBean.getCustomerComplaintMaterial(kfno);
                if (invhads != null && !invhads.isEmpty()) {
                    for (int i = 0; i < invhads.size(); i++) {
                        Object[] row = (Object[]) invhads.get(i);
                        cpd = new CustomerComplaintMaterial();
                        cpd.setKfno(row[0].toString());
                        cpd.setFwno(row[1] == null ? "null" : row[1].toString());
                        cpd.setTrtype(row[2] == null ? "null" : row[2].toString());
                        cpd.setTypedsc(row[3] == null ? "null" : row[3].toString());
                        cpd.setTrno(row[4] == null ? "null" : row[4].toString());
                        cpd.setTrdate(df.parse(row[5].toString()));
                        cpd.setTrseq(row[6] == null ? 0 : Integer.parseInt(row[6].toString()));
                        cpd.setItnbr(row[7] == null ? "null" : row[7].toString());
                        cpd.setItdsc(row[8] == null ? "null" : row[8].toString());
                        cpd.setTrnqy1(row[9] == null ? BigDecimal.ZERO : BigDecimal.valueOf(Double.parseDouble(row[9].toString())));
                        cpd.setUnmsr1(row[10] == null ? "null" : row[10].toString());
                        cpd.setTramt(row[11] == null ? BigDecimal.ZERO : BigDecimal.valueOf(Double.parseDouble(row[11].toString())));
                        materialList.add(cpd);
                    }
                }
                //资料更新
//资料更新
                List<CustomerComplaintExpense> expenses = complaintExpenseBean.findKfno(kfno);
                if (expenses != null && !expenses.isEmpty()) {
                    complaintExpenseBean.delete(expenses);
                }
                List<CustomerComplaintMaterial> materials = complaintMaterialBean.findKfno(kfno);
                if (materials != null && !materials.isEmpty()) {
                    complaintMaterialBean.delete(materials);
                }
                if (!travelList.isEmpty()) {
                    for (CustomerComplaintExpense complaintExpense : travelList) {
                        travel = travel.add(complaintExpense.getExpense());
                        complaintExpenseBean.persist(complaintExpense);
                    }
                }
                if (!tansportList.isEmpty()) {
                    for (CustomerComplaintExpense complaintExpense : tansportList) {
                        tansport = tansport.add(complaintExpense.getExpense());
                        complaintExpenseBean.persist(complaintExpense);
                    }
                }
                if (!materialList.isEmpty()) {
                    for (CustomerComplaintMaterial complaintMaterial : materialList) {
                        //IAF为服务领料 领料加项 IAG为服务退料 退料减项
                        if (complaintMaterial.getTrtype().equals("IAF")) {
                            material = material.add(complaintMaterial.getTramt());
                        } else {
                            material = material.subtract(complaintMaterial.getTramt());
                        }
                        complaintMaterialBean.persist(complaintMaterial);
                    }
                }
                CustomerComplaint plaint = customerComplaintBean.findKfno(kfno);
                if (plaint != null) {
                    customerComplaintBean.delete(plaint);
                }
                cp.setMaterialcost(material);
                cp.setTravelexpense(travel);
                cp.setTansportexpense(tansport);
                customerComplaintBean.persist(cp);
                count++;
            }
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.toString()));
        }
        return count;
    }

    /**
     * @return the begin
     */
    public Date getBegin() {
        return begin;
    }

    /**
     * @param begin the begin to set
     */
    public void setBegin(Date begin) {
        this.begin = begin;
    }

    /**
     * @return the end
     */
    public Date getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(Date end) {
        this.end = end;
    }

    /**
     * @return the selectKfno
     */
    public String getSelectKfno() {
        return selectKfno;
    }

    /**
     * @param selectKfno the selectKfno to set
     */
    public void setSelectKfno(String selectKfno) {
        this.selectKfno = selectKfno;
    }

    /**
     * @return the checked
     */
    public Boolean getChecked() {
        return checked;
    }

    /**
     * @param checked the checked to set
     */
    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

}
