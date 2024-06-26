///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package cn.hanbell.rpt.query;
//
////import cn.hanbell.crm.ejb.CMSMVBean;
//import cn.hanbell.crm.entity.CMSMV;
//import cn.hanbell.rpt.lazy.CMSMVModel;
//import cn.hanbell.rpt.web.SuperQueryBean;
//import javax.ejb.EJB;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//
///**
// *
// * @author C0160
// */
//@ManagedBean(name = "cmsmvQueryBean")
//@ViewScoped
//public class CmsmvQueryBean extends SuperQueryBean<CMSMV> {
//
////    @EJB
////    private CMSMVBean cmsmvBean;
//    private String userId;
//    private String userName;
//
//    public CmsmvQueryBean() {
//        super(CMSMV.class);
//    }
//
//    @Override
//    public void init() {
//        this.superEJB = cmsmvBean;
//        setModel(new CMSMVModel(cmsmvBean));
//        super.init();
//    }
//
//    @Override
//    public void query() {
//        if (this.model != null) {
//            this.model.getFilterFields().clear();
//            if (this.userId != null && !"".equals(this.userId)) {
//                this.model.getFilterFields().put("mv001", this.userId);
//            }
//            if (this.userName != null && !"".equals(this.userName)) {
//                this.model.getFilterFields().put("mv002", this.userName);
//            }
//        }
//    }
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//}
