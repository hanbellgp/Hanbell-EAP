/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.crm.ejb.REPTDBean;
import cn.hanbell.crm.ejb.SERBQBean;
import cn.hanbell.crm.entity.REPTD;
import cn.hanbell.crm.entity.SERBQ;
import cn.hanbell.eap.ejb.SystemUserBean;
import cn.hanbell.eap.entity.SystemUser;
import cn.hanbell.erp.ejb.InvmasBean;
import cn.hanbell.erp.entity.Invmas;
import cn.hanbell.oa.model.D50Z0009DOFWDetailModel;
import cn.hanbell.oa.model.D50Z0009DOFWModel;
import cn.hanbell.rpt.web.SuperQueryBean;
import com.lightshell.comm.BaseLib;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author C2082
 */
@ManagedBean(
        name = "d50Z0009D0FWManagedBean"
)
@ViewScoped
//服务CRM成本部分抛转至OA服务集团工作支援单中
public class D50Z0009D0FWManagedBean extends SuperQueryBean<SERBQ> {

    @EJB
    private SERBQBean serbqBean;
    @EJB
    private REPTDBean reptdBean;
    @EJB
    private InvmasBean invmasBean;
    @EJB
    protected cn.hanbell.oa.ejb.WorkFlowBean workFlowBean;
    @EJB
    private SystemUserBean systemUserBean;

    private String queryId;
    private String queryType;
    private List<Object[]> list;
    private List<Object[]> selectData;
    private String userid;
    private String password;
    private String supportfacno;
    private String supportUser;
    private String supportUsername;
    private String supporttype;
    private boolean isCreate;

    public D50Z0009D0FWManagedBean() {
        super(SERBQ.class);
    }

    @Override
    public void init() {
        try {
            list = new ArrayList<Object[]>();
            queryDateEnd = new Date();
            queryDateBegin = new Date();
            list = serbqBean.getD50Z0009D0FW(this.queryId, this.queryType, BaseLib.formatDate("YYYYMMdd", queryDateBegin), BaseLib.formatDate("YYYYMMdd", queryDateEnd));
            addCostSalary();//添加成本栏位
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", e.getMessage()));
        }
    }

    @Override
    public void query() {
        try {
            list = serbqBean.getD50Z0009D0FW(this.queryId, this.queryType, BaseLib.formatDate("YYYYMMdd", queryDateBegin), BaseLib.formatDate("YYYYMMdd", queryDateEnd));
            addCostSalary();//添加成本栏位
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", e.getMessage()));
        }
    }

    public void createD50Z0009D0() {
        try {
            for (Object[] o : selectData) {
                if ((String) o[4] != null && !"".equals((String) o[4])) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "勾选的数据已抛转，请重新选择"));
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error",  "勾选的数据已抛转，请重新选择"));
                    return;
                }
            }
            //先验证账号密码是否正确
            String pwd = BaseLib.securityMD5(this.password);
            SystemUser applyUser = systemUserBean.findByUserIdAndPwd(userid, pwd);
            SystemUser suppUser = systemUserBean.findByUserId(this.supportUser);
            if (applyUser == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "用户名或密码错误"));
                return;
            }
            workFlowBean.initUserInfo(userid);
            D50Z0009DOFWModel head = new D50Z0009DOFWModel();
            D50Z0009DOFWDetailModel d;
            List<D50Z0009DOFWDetailModel> detailList = new ArrayList<>();
            LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
            head.setApplyUser(applyUser.getUserid());
            head.setApplyDept(applyUser.getDeptno());
            head.setApplyfacno(applyUser.getDept().getCompany());
            List<SERBQ> serbqs = new ArrayList<SERBQ>();
            head.setSupportUser(suppUser.getUserid());
            head.setSupportDept(suppUser.getDeptno());
            head.setSupportfacno(suppUser.getDept().getCompany());
            int i = 0;
            for (Object[] o : selectData) {

                d = new D50Z0009DOFWDetailModel();
                d.setSeq(String.valueOf(i));
                d.setKsno((String) o[0]);
                d.setTravelAmount((BigDecimal) o[1]);
                d.setHours((BigDecimal) o[2]);
                d.setMaterialAmount((BigDecimal.valueOf((Double) o[3])));
                detailList.add(d);
                i++;
            }
            details.put("detail", detailList);
            String formInstance = workFlowBean.buildXmlForEFGP("D50_Z0009_D0_FW", head, details);
            String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, "D50_Z0009_D0_FW", formInstance, applyUser.getUsername() + "集团服务工作支援单");
            String[] rm = msg.split("\\$");
            if (rm.length == 2) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "info", "提交成功"));
                for (Object[] o : selectData) {
                    SERBQ b = serbqBean.findByBq001((String) o[0]);
                    b.setBq510((String) rm[1]);
                    serbqBean.update(b);
                }
                query();
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", msg));
                log4j.error("发起失败" + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", e.getMessage()));
        }
    }

    @Override
    public void reset() {
        this.setSuperEJB(this.serbqBean);
        this.queryDateBegin = new Date();
        this.queryDateEnd = new Date();
        list.removeAll(list);
        query();
    }

    public void addCostSalary() throws Exception {
        for (Object[] o : list) {
            List<REPTD> reptdList = reptdBean.findByBQ001((String) o[0]);
            StringBuffer sb = new StringBuffer();
            BigDecimal sum = BigDecimal.ZERO;
            for (REPTD reptd : reptdList) {
                Invmas m = invmasBean.findByItnbr(reptd.getTd004());
                if (m == null) {
                    throw new Exception(reptd.getTd004() + "维修单下无品号。");
                }
                if (m.getCost() == null) {
                    m.setCost(BigDecimal.ZERO);
                }
                sum = sum.add(m.getCost());
            }
            o[3] = sum.doubleValue();
        }

    }

    public void handleDialogReturnUserWhenDetailNew(SelectEvent event) {
        if (event.getObject() != null && newEntity != null) {
            Object o = event.getObject();
            SystemUser user = (SystemUser) o;
        }
    }

    public void handleDialogReturnWhenNew(SelectEvent event) {
        if (event.getObject() != null) {
            Object o = event.getObject();
            SystemUser user = (SystemUser) o;
            this.supportUser = user.getUserid();
            this.supportUsername = user.getUsername();
        }
    }

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public List<Object[]> getList() {
        return list;
    }

    public void setList(List<Object[]> list) {
        this.list = list;
    }

    public List<Object[]> getSelectData() {
        return selectData;
    }

    public void setSelectData(List<Object[]> selectData) {
        this.selectData = selectData;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSupportfacno() {
        return supportfacno;
    }

    public void setSupportfacno(String supportfacno) {
        this.supportfacno = supportfacno;
    }

    public String getSupportUser() {
        return supportUser;
    }

    public void setSupportUser(String supportUser) {
        this.supportUser = supportUser;
    }

    public String getSupportUsername() {
        return supportUsername;
    }

    public void setSupportUsername(String supportUsername) {
        this.supportUsername = supportUsername;
    }

    public String getSupporttype() {
        return supporttype;
    }

    public void setSupporttype(String supporttype) {
        this.supporttype = supporttype;
    }

    public boolean isIsCreate() {
        return isCreate;
    }

    public void setIsCreate(boolean isCreate) {
        this.isCreate = isCreate;
    }

}
