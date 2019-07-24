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
import cn.hanbell.eap.ejb.CustomerComplaintCostBean;
import cn.hanbell.eap.ejb.CustomerComplaintDetailBean;
import cn.hanbell.eap.ejb.MailNotificationBean;
import cn.hanbell.eap.entity.CustomerComplaint;
import cn.hanbell.eap.entity.CustomerComplaintCost;
import cn.hanbell.eap.entity.CustomerComplaintDetail;
import cn.hanbell.erp.ejb.CdrlnhadBean;
import cn.hanbell.erp.ejb.InvhadBean;
import cn.hanbell.oa.ejb.HKFW005Bean;
import cn.hanbell.oa.ejb.HKFW006Bean;
import cn.hanbell.oa.ejb.SERI12Bean;
import cn.hanbell.oa.entity.HKFW005;
import cn.hanbell.oa.entity.HKFW006;
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
    private CustomerComplaintDetailBean customerComplaintDetailBean;
    @EJB
    private CustomerComplaintCostBean customerComplaintCostBean;
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
        BigDecimal clvcost, yscost, clcost;
        //差旅
        List<CustomerComplaintCost> clvList;
        //运费
        List<CustomerComplaintCost> ysList;
        //材料
        List<CustomerComplaintDetail> clList;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            for (SERI12 seri12 : list) {
                clvcost = BigDecimal.ZERO;
                yscost = BigDecimal.ZERO;
                clcost = BigDecimal.ZERO;
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
                ysList = new ArrayList<>();
                CustomerComplaintCost cost;
                List<HKFW005> hkfw005s = hkfw005Bean.getCustomerComplaintCost(kfno);
                if (hkfw005s != null && !hkfw005s.isEmpty()) {
                    for (HKFW005 hkfw005 : hkfw005s) {
                        cost = new CustomerComplaintCost();
                        cost.setKfno(hkfw005.getKfno());
                        cost.setFwno(hkfw005.getFwno() == null ? "null" : hkfw005.getFwno());
                        cost.setCostno(hkfw005.getSerialNumber());
                        cost.setType("HK_FW005_工作支援单运费和快递费");
                        cost.setCost(hkfw005.getTotal() == null ? BigDecimal.ZERO : BigDecimal.valueOf(hkfw005.getTotal()));
                        ysList.add(cost);
                    }
                }
                List<HKFW006> hkfw006s = hkfw006Bean.getCustomerComplaintCost(kfno);
                if (hkfw006s != null && !hkfw006s.isEmpty()) {
                    for (HKFW006 hkfw006 : hkfw006s) {
                        cost = new CustomerComplaintCost();
                        cost.setKfno(hkfw006.getKfno());
                        cost.setFwno(hkfw006.getFwno() == null ? "null" : hkfw006.getFwno());
                        cost.setCostno(hkfw006.getFormSerialNumber());
                        cost.setType("HK_FW006_退货通知单吊装费和运费");
                        cost.setCost(hkfw006.getYf() == null ? BigDecimal.ZERO : BigDecimal.valueOf(hkfw006.getYf()));
                        ysList.add(cost);
                    }
                }
                List cdrlnhadcost = cdrlnhadBean.getCustomerComplaintCost(kfno);
                if (cdrlnhadcost != null && !cdrlnhadcost.isEmpty()) {
                    for (int i = 0; i < cdrlnhadcost.size(); i++) {
                        Object[] row = (Object[]) cdrlnhadcost.get(i);
                        cost = new CustomerComplaintCost();
                        cost.setKfno(row[0].toString());
                        cost.setFwno(row[1] == null ? "null" : row[1].toString());
                        cost.setCostno(row[2] == null ? "null" : row[2].toString());
                        cost.setType("CDRN20_借出单据运费");
                        cost.setCost(row[3] == null ? BigDecimal.ZERO : BigDecimal.valueOf(Double.parseDouble(row[3].toString())));
                        ysList.add(cost);
                    }
                }
                //二、差旅费
                clvList = new ArrayList<>();
                List reptcost = reptcBean.getCustomerComplaintCost(kfno);
                if (reptcost != null && !reptcost.isEmpty()) {
                    for (int i = 0; i < reptcost.size(); i++) {
                        Object[] row = (Object[]) reptcost.get(i);
                        cost = new CustomerComplaintCost();
                        cost.setKfno(row[0].toString());
                        cost.setFwno(row[1] == null ? "null" : row[1].toString());
                        cost.setCostno("null");
                        cost.setType("REPLC_差旅费");
                        cost.setCost(row[2] == null ? BigDecimal.ZERO : BigDecimal.valueOf(Double.parseDouble(row[2].toString())));
                        clvList.add(cost);
                    }
                }
                //三、材料费
                clList = new ArrayList<>();
                CustomerComplaintDetail cpd;
                List invhadhs = invhadBean.getCustomerComplaintDetailh(kfno);
                if (invhadhs != null && !invhadhs.isEmpty()) {
                    for (int i = 0; i < invhadhs.size(); i++) {
                        Object[] row = (Object[]) invhadhs.get(i);
                        cpd = new CustomerComplaintDetail();
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
                        clList.add(cpd);
                    }
                }
                List invhads = invhadBean.getCustomerComplaintDetail(kfno);
                if (invhads != null && !invhads.isEmpty()) {
                    for (int i = 0; i < invhads.size(); i++) {
                        Object[] row = (Object[]) invhads.get(i);
                        cpd = new CustomerComplaintDetail();
                        cpd.setKfno(row[0].toString());
                        cpd.setFwno(row[1] == null ? "null" : row[1].toString());
                        cpd.setTrtype(row[2] == null ? "null" : row[2].toString());
                        cpd.setTypedsc(row[3] == null ? "null" : row[3].toString());
                        cpd.setTrno(row[4] == null ? "null" : row[4].toString());
                        cpd.setTrdate(BaseLib.getDate("yyyy/MM/dd", row[5].toString()));
                        cpd.setTrseq(row[6] == null ? 0 : Integer.parseInt(row[6].toString()));
                        cpd.setItnbr(row[7] == null ? "null" : row[7].toString());
                        cpd.setItdsc(row[8] == null ? "null" : row[8].toString());
                        cpd.setTrnqy1(row[9] == null ? BigDecimal.ZERO : BigDecimal.valueOf(Double.parseDouble(row[9].toString())));
                        cpd.setUnmsr1(row[10] == null ? "null" : row[10].toString());
                        cpd.setTramt(row[11] == null ? BigDecimal.ZERO : BigDecimal.valueOf(Double.parseDouble(row[11].toString())));
                        clList.add(cpd);
                    }
                }
                //资料更新
                List<CustomerComplaintCost> costs = customerComplaintCostBean.findKfno(kfno);
                if (costs != null && !costs.isEmpty()) {
                    customerComplaintCostBean.delete(costs);
                }
                List<CustomerComplaintDetail> details = customerComplaintDetailBean.findKfno(kfno);
                if (details != null && !details.isEmpty()) {
                    customerComplaintDetailBean.delete(details);
                }
                if (!clvList.isEmpty()) {
                    for (CustomerComplaintCost complaintCost : clvList) {
                        clvcost = clvcost.add(complaintCost.getCost());
                        customerComplaintCostBean.persist(complaintCost);
                    }
                }
                if (!ysList.isEmpty()) {
                    for (CustomerComplaintCost complaintCost : ysList) {
                        yscost = yscost.add(complaintCost.getCost());
                        customerComplaintCostBean.persist(complaintCost);
                    }
                }
                if (!clList.isEmpty()) {
                    for (CustomerComplaintDetail complaintDetail : clList) {
                        //IAF为服务领料 领料加项 IAG为服务退料 退料减项
                        if (complaintDetail.getTrtype().equals("IAF")) {
                            clcost = clcost.add(complaintDetail.getTramt());
                        } else {
                            clcost = clcost.subtract(complaintDetail.getTramt());
                        }
                        customerComplaintDetailBean.persist(complaintDetail);
                    }
                }
                CustomerComplaint plaint = customerComplaintBean.findKfno(kfno);
                if (plaint != null) {
                    customerComplaintBean.delete(plaint);
                }
                cp.setClcost(clcost);
                cp.setClvcost(clvcost);
                cp.setYscost(yscost);
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
