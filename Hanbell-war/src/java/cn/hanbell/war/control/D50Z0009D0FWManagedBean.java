///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package cn.hanbell.war.control;
//
//import cn.hanbell.crm.ejb.REPTDBean;
//import cn.hanbell.crm.ejb.SERBQBean;
//import cn.hanbell.crm.entity.REPTD;
//import cn.hanbell.crm.entity.SERBQ;
//import cn.hanbell.erp.ejb.InvmasBean;
//import cn.hanbell.erp.entity.Invmas;
//import cn.hanbell.war.web.SuperQueryBean;
//import com.lightshell.comm.BaseLib;
//import com.lightshell.comm.SuperSingleManagedBean;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.LinkedHashMap;
//import java.util.List;
//import javax.ejb.EJB;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//import javax.faces.context.FacesContext;
//
///**
// *
// * @author C2082
// */
//@ManagedBean(
//        name = "d50Z0009D0FWManagedBean"
//)
//@ViewScoped
////服务CRM成本部分抛转至OA服务集团工作支援单中
//public class D50Z0009D0FWManagedBean extends SuperSingleManagedBean<SERBQ> {
//
//    @EJB
//    private SERBQBean serbqBean;
//    @EJB
//    private REPTDBean reptdBean;
//    @EJB
//    private InvmasBean invmasBean;
//    @EJB
//    protected cn.hanbell.oa.ejb.WorkFlowBean workFlowBean;
//
//    private String queryId;
//    private String queryType;
//    private List<Object[]> list;
//    private List<Object[]> selectData;
//
//    public D50Z0009D0FWManagedBean() {
//        super(SERBQ.class);
//    }
//
//    @Override
//    public void init() {
//        try {
//            list = new ArrayList<Object[]>();
//            queryDateEnd = new Date();
//            queryDateBegin = new Date();
//            list = serbqBean.getD50Z0009D0FW(this.queryId, this.queryType, BaseLib.formatDate("YYYYMMdd", queryDateBegin), BaseLib.formatDate("YYYYMMdd", queryDateEnd));
//            addCostSalary();//添加成本栏位
//        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", e.getMessage()));
//        }
//    }
//
//    @Override
//    public void query() {
//        try {
//            list = serbqBean.getD50Z0009D0FW(this.queryId, this.queryType, BaseLib.formatDate("YYYYMMdd", queryDateBegin), BaseLib.formatDate("YYYYMMdd", queryDateEnd));
//            addCostSalary();//添加成本栏位
//        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", e.getMessage()));
//        }
//    }
//
//    public void update() {
//        try {
//             workFlowBean.initUserInfo("C2082");
//             LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();//明细表
//             
//        } catch (Exception e) {
//            
//        }
//    }
//
//    @Override
//    public void reset() {
//        this.setSuperEJB(this.serbqBean);
//        this.queryDateBegin = new Date();
//        this.queryDateEnd = new Date();
//        list.removeAll(list);
//        query();
//    }
//
//    public void addCostSalary() throws Exception {
//        for (Object[] o : list) {
//            List<REPTD> reptdList = reptdBean.findByBQ001((String) o[0]);
//            StringBuffer sb = new StringBuffer();
//            BigDecimal sum = BigDecimal.ZERO;
//            for (REPTD reptd : reptdList) {
//                Invmas m = invmasBean.findByItnbr(reptd.getTd004());
//                if (m == null) {
//                    throw new Exception(reptd.getTd004() + "维修单下无品号。");
//                }
//                if (m.getCost() == null) {
//                    m.setCost(BigDecimal.ZERO);
//                }
//                sum = sum.add(m.getCost());
//            }
//            o[3] = sum.doubleValue();
//        }
//
//    }
//
//    public String getQueryId() {
//        return queryId;
//    }
//
//    public void setQueryId(String queryId) {
//        this.queryId = queryId;
//    }
//
//    public String getQueryType() {
//        return queryType;
//    }
//
//    public void setQueryType(String queryType) {
//        this.queryType = queryType;
//    }
//
//    public List<Object[]> getList() {
//        return list;
//    }
//
//    public void setList(List<Object[]> list) {
//        this.list = list;
//    }
//
//    public List<Object[]> getSelectData() {
//        return selectData;
//    }
//
//    public void setSelectData(List<Object[]> selectData) {
//        this.selectData = selectData;
//    }
//
//}
