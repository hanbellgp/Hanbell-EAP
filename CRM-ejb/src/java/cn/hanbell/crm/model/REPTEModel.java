/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.model;

import cn.hanbell.crm.entity.REPTEPK;
import cn.hanbell.util.BaseLib;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author C2082
 */
//自定义实体类，与REPTE表多了一个公司简称和服务人员名字
public class REPTEModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String serviceStaff;//服务人员名字

    private String customerAbbreviation;//客户简称

    private BigDecimal roadTime;//路程总时
    
    private REPTEPK rEPTEPK;
    
    private String roadStartDate;

    private String arrivalDate;

    private String leaveDate;

    private String roadEndDate;

    private String company;

    private String creator;

    private String usrGroup;

    private String createDate;

    private String modifier;

    private String modiDate;

    private Short flag;

    private String te001;

    private String te002;

    private String te003;

    private String te004;

    private String te005;

    private String te006;

    private String te007;

    private String te008;

    private String te009;

    private BigDecimal te010;

    private String te011;

    private BigDecimal te012;

    private BigDecimal te013;

    private String te014;

    private String te015;

    private String te016;

    private String customer;

    private String product;

    private String region;

    private String dealer;

    private String te017;

    private String te018;

    private String te019;

    private String te020;

    private String te021;

    private String te022;

    private String te023;

    private String repte01;

    private String repte02;

    private String repte03;

    private String repte04;

    private String repte05;

    private String repte06;

    private String repte07;

    private String repte08;

    private String repte09;

    private String repte10;

    private String repte11;

    private String repte12;

    private String repte13;

    private String repte14;

    private String repte15;

    private String repte16;

    private String repte17;

    private String repte18;

    private String repte19;

    private String repte20;

    private BigDecimal te500;

    private BigDecimal te501;

    private String te502;

    private String te503;

    private String te504;

    private String te505;

    private String te024;

    private String te506;

    private String te507;

    private String te508;

    private String te509;

    public String getServiceStaff() {
        return serviceStaff;
    }

    public void setServiceStaff(String serviceStaff) {
        this.serviceStaff = serviceStaff;
    }

    public String getCustomerAbbreviation() {
        return customerAbbreviation;
    }

    public void setCustomerAbbreviation(String customerAbbreviation) {
        this.customerAbbreviation = customerAbbreviation;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUsrGroup() {
        return usrGroup;
    }

    public void setUsrGroup(String usrGroup) {
        this.usrGroup = usrGroup;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModiDate() {
        return modiDate;
    }

    public void setModiDate(String modiDate) {
        this.modiDate = modiDate;
    }

    public Short getFlag() {
        return flag;
    }

    public void setFlag(Short flag) {
        this.flag = flag;
    }

    public String getTe001() {
        return te001;
    }

    public void setTe001(String te001) {
        this.te001 = te001;
    }

    public String getTe002() {
        return te002;
    }

    public void setTe002(String te002) {
        this.te002 = te002;
    }

    public String getTe003() {
        return te003;
    }

    public void setTe003(String te003) {
        this.te003 = te003;
    }

    public String getTe004() {
        return te004;
    }

    public void setTe004(String te004) {
        this.te004 = te004;
    }

    public String getTe005() {
        return te005;
    }

    public void setTe005(String te005) {
        this.te005 = te005;
    }

    public String getTe006() {
        return te006;
    }

    public void setTe006(String te006) {
        this.te006 = te006;
    }

    public String getTe007() {
        return te007;
    }

    public void setTe007(String te007) {
        this.te007 = te007;
    }

    public String getTe008() {
        return te008;
    }

    public void setTe008(String te008) {
        this.te008 = te008;
    }

    public String getTe009() {
        return te009;
    }

    public void setTe009(String te009) {
        this.te009 = te009;
    }

    public BigDecimal getTe010() {
        return te010;
    }

    public void setTe010(BigDecimal te010) {
        this.te010 = te010;
    }

    public String getTe011() {
        return te011;
    }

    public void setTe011(String te011) {
        this.te011 = te011;
    }

    public BigDecimal getTe012() {
        return te012;
    }

    public void setTe012(BigDecimal te012) {
        this.te012 = te012;
    }

    public BigDecimal getTe013() {
        return te013;
    }

    public void setTe013(BigDecimal te013) {
        this.te013 = te013;
    }

    public String getTe014() {
        return te014;
    }

    public void setTe014(String te014) {
        this.te014 = te014;
    }

    public String getTe015() {
        return te015;
    }

    public void setTe015(String te015) {
        this.te015 = te015;
    }

    public String getTe016() {
        return te016;
    }

    public void setTe016(String te016) {
        this.te016 = te016;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getTe017() {
        return te017;
    }

    public void setTe017(String te017) {
        this.te017 = te017;
    }

    public String getTe018() {
        return te018;
    }

    public void setTe018(String te018) {
        this.te018 = te018;
    }

    public String getTe019() {
        return te019;
    }

    public void setTe019(String te019) {
        this.te019 = te019;
    }

    public String getTe020() {
        return te020;
    }

    public void setTe020(String te020) {
        this.te020 = te020;
    }

    public String getTe021() {
        return te021;
    }

    public void setTe021(String te021) {
        this.te021 = te021;
    }

    public String getTe022() {
        return te022;
    }

    public void setTe022(String te022) {
        this.te022 = te022;
    }

    public String getTe023() {
        return te023;
    }

    public void setTe023(String te023) {
        this.te023 = te023;
    }

    public String getRepte01() {
        return repte01;
    }

    public void setRepte01(String repte01) {
        this.repte01 = repte01;
    }

    public String getRepte02() {
        return repte02;
    }

    public void setRepte02(String repte02) {
        this.repte02 = repte02;
    }

    public String getRepte03() {
        return repte03;
    }

    public void setRepte03(String repte03) {
        this.repte03 = repte03;
    }

    public String getRepte04() {
        return repte04;
    }

    public void setRepte04(String repte04) {
        this.repte04 = repte04;
    }

    public String getRepte05() {
        return repte05;
    }

    public void setRepte05(String repte05) {
        this.repte05 = repte05;
    }

    public String getRepte06() {
        return repte06;
    }

    public void setRepte06(String repte06) {
        this.repte06 = repte06;
    }

    public String getRepte07() {
        return repte07;
    }

    public void setRepte07(String repte07) {
        this.repte07 = repte07;
    }

    public String getRepte08() {
        return repte08;
    }

    public void setRepte08(String repte08) {
        this.repte08 = repte08;
    }

    public String getRepte09() {
        return repte09;
    }

    public void setRepte09(String repte09) {
        this.repte09 = repte09;
    }

    public String getRepte10() {
        return repte10;
    }

    public void setRepte10(String repte10) {
        this.repte10 = repte10;
    }

    public String getRepte11() {
        return repte11;
    }

    public void setRepte11(String repte11) {
        this.repte11 = repte11;
    }

    public String getRepte12() {
        return repte12;
    }

    public void setRepte12(String repte12) {
        this.repte12 = repte12;
    }

    public String getRepte13() {
        return repte13;
    }

    public void setRepte13(String repte13) {
        this.repte13 = repte13;
    }

    public String getRepte14() {
        return repte14;
    }

    public void setRepte14(String repte14) {
        this.repte14 = repte14;
    }

    public String getRepte15() {
        return repte15;
    }

    public void setRepte15(String repte15) {
        this.repte15 = repte15;
    }

    public String getRepte16() {
        return repte16;
    }

    public void setRepte16(String repte16) {
        this.repte16 = repte16;
    }

    public String getRepte17() {
        return repte17;
    }

    public void setRepte17(String repte17) {
        this.repte17 = repte17;
    }

    public String getRepte18() {
        return repte18;
    }

    public void setRepte18(String repte18) {
        this.repte18 = repte18;
    }

    public String getRepte19() {
        return repte19;
    }

    public void setRepte19(String repte19) {
        this.repte19 = repte19;
    }

    public String getRepte20() {
        return repte20;
    }

    public void setRepte20(String repte20) {
        this.repte20 = repte20;
    }

    public BigDecimal getTe500() {
        return te500;
    }

    public void setTe500(BigDecimal te500) {
        this.te500 = te500;
    }

    public BigDecimal getTe501() {
        return te501;
    }

    public void setTe501(BigDecimal te501) {
        this.te501 = te501;
    }

    public String getTe502() {
        return te502;
    }

    public void setTe502(String te502) {
        this.te502 = te502;
    }

    public String getTe503() {
        return te503;
    }

    public void setTe503(String te503) {
        this.te503 = te503;
    }

    public String getTe504() {
        return te504;
    }

    public void setTe504(String te504) {
        this.te504 = te504;
    }

    public String getTe505() {
        return te505;
    }

    public void setTe505(String te505) {
        this.te505 = te505;
    }

    public String getTe024() {
        return te024;
    }

    public void setTe024(String te024) {
        this.te024 = te024;
    }

    public String getTe506() {
        return te506;
    }

    public void setTe506(String te506) {
        this.te506 = te506;
    }

    public String getTe507() {
        return te507;
    }

    public void setTe507(String te507) {
        this.te507 = te507;
    }

    public String getTe508() {
        return te508;
    }

    public void setTe508(String te508) {
        this.te508 = te508;
    }

    public String getTe509() {
        return te509;
    }

    public void setTe509(String te509) {
        this.te509 = te509;
    }

    public String getRoadStartDate() {
//        StringBuffer date=new StringBuffer(this.te502);
//        date.append(" ");
//        date.append(this.te504);
//        return BaseLib.formatString("yyyyMMdd HHmm", date.toString());       
        return roadStartDate;
    }

    public void setRoadStartDate(String roadStartDate) {
        this.roadStartDate = roadStartDate;
    }

    public String getArrivalDate() {
//         StringBuffer date=new StringBuffer(this.te007);
//        date.append(" ");
//        date.append(this.te017);
//        return BaseLib.formatString("yyyyMMdd HHmm", date.toString()); 
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public REPTEPK getrEPTEPK() {
        return rEPTEPK;
    }

    public void setrEPTEPK(REPTEPK rEPTEPK) {
        this.rEPTEPK = rEPTEPK;
    }

    public BigDecimal getRoadTime() {
        return roadTime;
    }

    public void setRoadTime(BigDecimal roadTime) {
        this.roadTime = roadTime;
    }

    public String getLeaveDate() {

        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getRoadEndDate() {

        return roadEndDate;
    }

    public void setRoadEndDate(String roadEndDate) {
        this.roadEndDate = roadEndDate;
    }

}
