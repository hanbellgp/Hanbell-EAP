package cn.hanbell.crm.jrs;

import cn.hanbell.crm.app.SERBQApplication;
import cn.hanbell.crm.ejb.CRMGGBean;
import cn.hanbell.crm.ejb.REPTABean;
import cn.hanbell.crm.ejb.SERBQBean;
import cn.hanbell.crm.ejb.SERCABean;
import cn.hanbell.crm.entity.CRMGD;
import cn.hanbell.crm.entity.CRMGG;
import cn.hanbell.crm.entity.REPTA;
import cn.hanbell.crm.entity.REPTAPK;
import cn.hanbell.crm.entity.SERAC;
import cn.hanbell.crm.entity.SERBQ;
import cn.hanbell.crm.entity.SERCA;
import cn.hanbell.crm.entity.SERCAPK;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForCRM;
import cn.hanbell.oa.app.LeaveApplication;
import cn.hanbell.util.BaseLib;
import cn.hanbell.util.SuperEJB;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author C2082
 */
@Path("crm/serbq")
@javax.enterprise.context.RequestScoped
public class SERBQFacadeREST extends SuperRESTForCRM<SERBQ> {

    @EJB
    private SERBQBean serbqBean;

    @EJB
    private REPTABean repiaBean;

    @EJB
    private CRMGGBean crmggBean;

    @EJB
    private REPTABean reptaBean;
    
      @EJB
    private SERCABean sercaean;

    public SERBQFacadeREST() {
        super(SERBQ.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @POST
    @Path("wechat/createSERBQFromWechat")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage createSERBQFromWechat(SERBQApplication entity) {
        Date date;
        try {
            date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
            String bq001 = serbqBean.getBQ001ByDeptAndDate(entity.getDeptId(), date);
            SERBQ bq = new SERBQ();
            bq.setBq001(bq001 == null ? "" : bq001);
            bq.setBq002(entity.getCustomerCodeId() == null ? "" : entity.getCustomerCodeId());
            bq.setBq003(entity.getProductTypeId() == null ? "" : entity.getProductTypeId());
            bq.setBq005(entity.getEmergencyDrgree() == null ? "" : entity.getEmergencyDrgree());//紧急度
            bq.setBq007(entity.getCallerUnit() == null ? "" : entity.getCallerUnit());
            bq.setBq009(entity.getCallerPhone() == null ? "" : entity.getCallerPhone());//来电者，非来电单位
            String ti = BaseLib.formatDate("yyyy/MM/dd HH:mm:ss", BaseLib.getDate());
            bq.setBq008(ti.substring(11) == null ? "" : ti.substring(11));
            bq.setBq016(entity.getEmployeeId() == null ? "" : entity.getEmployeeId());
            bq.setBq017(entity.getDeptId() == null ? "" : entity.getDeptId());
            bq.setBq018(entity.getEmployeeId() == null ? "" : entity.getEmployeeId());
            bq.setBq019(entity.getEmployeeId() == null ? "" : entity.getEmployeeId());
            bq.setBq021(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
            bq.setBq022("N");
            bq.setBq023(entity.getProblemTypeId() == null ? "" : entity.getProblemTypeId());
            bq.setBq024(entity.getReason() == null ? "" : entity.getReason());
            bq.setBq027("");
            bq.setBq031("");
            bq.setBq034("");
            bq.setBq035("N");
            bq.setBq036("");
            bq.setBq042(new BigDecimal(0.00));
            bq.setBq043(new BigDecimal(0.00));
            bq.setBq044("N");
            bq.setBq047("2");
            bq.setBq049("");
            bq.setBq052("2");
            bq.setBq055(entity.getPhoneCountry() == null ? "" : entity.getPhoneCountry());//電話過嗎
            bq.setBq056(entity.getPhoneArea() == null ? "" : entity.getPhoneArea());//電話區碼
            bq.setBq058("");
            bq.setBq059("");
            bq.setBq060(entity.getPhoneCountry1() == null ? "" : entity.getPhoneCountry1());//行動電話國碼
            bq.setBq061(entity.getPhoneArea1() == null ? "" : entity.getPhoneArea1());//行動電話號碼
            bq.setBq064("");
            bq.setBq065("");
            bq.setBq068(BigDecimal.ZERO);
            bq.setBq088("RMB");
            bq.setBq089(BigDecimal.ZERO);
            bq.setBq090("N");
            bq.setBq092(BigDecimal.ZERO);
            bq.setBq093("N");
            bq.setBq094("S02");
            bq.setBq095("");
            bq.setBq096("1");
            bq.setBq107("N");
            bq.setBq116("N");
            bq.setBq121("N");
            bq.setBq122(BigDecimal.ZERO);
            bq.setBq123(BigDecimal.ZERO);
            bq.setBq124(BigDecimal.ZERO);
            bq.setBq125(BigDecimal.ZERO);
            bq.setBq126(BigDecimal.ZERO);
            bq.setBq127(BigDecimal.ZERO);
            bq.setBq128(BigDecimal.ZERO);
            bq.setBq197(entity.getProductId() == null ? "" : entity.getProductId());
            bq.setBq198(entity.getAreaId() == null ? "" : entity.getAreaId());
            bq.setBq199(entity.getDealer() == null ? "" : entity.getDealer());//經銷商 
            bq.setBq500(entity.getComplaintTypeId() == null ? "" : entity.getComplaintTypeId()); //客诉单类型
            bq.setBq506(entity.getIncidentProvinceId() == null ? "" : entity.getIncidentProvinceId()); //事发省
            bq.setBq507(entity.getIncidentCityId()== null ? "" : entity.getIncidentCityId());//事发市
            //客诉类型是否是其他，其他则不是客诉单
            if ("1".equals(bq.getBq500())) {
                bq.setBq110("Y");
            } else {
                bq.setBq110("N");
            }
            bq.setCompany("SHAHANBELL");
            bq.setCreator(entity.getEmployeeId() == null ? "" : entity.getEmployeeId());
            bq.setUsrGroup(entity.getDeptId() == null ? "" : entity.getDeptId());
            bq.setFlag((short) 1);
            bq.setCreateDate(BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()));
            serbqBean.persist(bq);
            //品号资料单身
            SERCA ca = new SERCA();
            SERCAPK capk = new SERCAPK();
            capk.setCa001(bq.getBq001());
            capk.setCa002("0001"); // 手机端发单明细只有1笔资料
            ca.setSERCAPK(capk);
            ca.setCa003(entity.getProductQuality());
            ca.setCa004(entity.getProduct_name());
            ca.setCa005(entity.getProductStandard());
            ca.setCa009(entity.getProductNumberId());//制造号码
            ca.setCa010(entity.getFormId()); // 叫修单单别
             String serl = repiaBean.getTA002ByTA001AndDate(entity.getFormId(), BaseLib.getDate());
            ca.setCa011(serl); // 叫修单单号（派工单号）
            ca.setCa012("");
            ca.setCa013(BigDecimal.ZERO);
            ca.setCa014("");
            ca.setCa015(entity.getProblemTypeName());
            ca.setCa019(entity.getEmergencyDrgree());
            ca.setCa021(entity.getProblemTypeId());
            ca.setCa500(entity.getProductTypeId());
            ca.setFlag((short) 0);
            sercaean.persist(ca);
            // 产生叫修单单头
            REPTA ta = new REPTA();
            REPTAPK tapk = new REPTAPK();
            ta.setCompany("SHAHANBELL");
            ta.setCreateDate(bq.getCreateDate());
            ta.setCreator(bq.getCreator());
            ta.setUsrGroup(bq.getUsrGroup());
            tapk.setTa001(entity.getFormId());
            tapk.setTa002(serl);
            ta.setREPTAPK(tapk);
            ta.setTa003(bq.getCreateDate());
            ta.setTa004(entity.getCustomerCodeId()); // 客户代号
            ta.setTa005(entity.getProductQuality()); // 产品品号
            ta.setTa006(entity.getProduct_name()); // 产品品名
            ta.setTa007(entity.getProductStandard()); // 产品规格
            // ta.setTa008(bq.getCreateDate()); //合约代号
            ta.setTa009(entity.getEmployeeId()); // 接单人员
            ta.setTa010(entity.getReason()); // 问题描述
            ta.setTa013(entity.getProductNumberId());//产品序号
            
            ta.setTa071(entity.getProblemTypeId()); // 问题代号
            ta.setTa062("RMB");
            ta.setTa063(BigDecimal.ONE);
            ta.setTa197(entity.getAreaId()); // 产品别
            ta.setTa198(entity.getProductId()); // 区域别
            ta.setTa020(entity.getCaller()); // 联络人
            ta.setTa054("2");//资料来源e-Service
            CRMGG gg = crmggBean.findByGG001(ta.getTa004());
            if (gg != null) {
                ta.setTa034(gg.getGg027()); // 传真
            }
            if (crmggBean.getDetaiList(ta.getTa004()) != null) {
                if (crmggBean.getDetaiList(ta.getTa004()).size() > 0) {
                    CRMGD gd = crmggBean.getDetaiList(ta.getTa004()).get(0);
                    ta.setTa020(gd.getGd005()); // 联络人
                    ta.setTa087(gd.getGd012()); // 移动电话
                    ta.setTa026(gd.getGd008()); // 地址
                    ta.setTa025(gd.getGd025() + gd.getGd007()); // 电话
                }
            }
            ta.setTa500(entity.getMachineTypeId());
            repiaBean.persist(ta);
            StringBuffer msg=new StringBuffer("客诉单号：");
            msg=msg.append(bq001).append(" \r\n派工单号："+serl);
            ResponseMessage responseMessage=new ResponseMessage("200",msg.toString());
            return responseMessage;
        } catch (Exception e) {
            System.out.println("ex=="+e);
             return null;
        }
    }
}
