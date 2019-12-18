/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.Demands;
import cn.hanbell.eap.entity.Department;
import cn.hanbell.eap.entity.SystemUser;
import cn.hanbell.oa.ejb.HKXQB001Bean;
import cn.hanbell.oa.entity.HKXQB001;
import cn.hanbell.util.BaseLib;
import java.text.ParseException;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C1749
 */
@Stateless
@LocalBean
public class DemandsBean extends SuperEJBForEAP<Demands> {

    @EJB
    private HKXQB001Bean hkxqb001Bean;

    @EJB
    private SystemUserBean systemUserBean;

    @EJB
    private DepartmentBean departmentBean;

    public DemandsBean() {
        super(Demands.class);
    }

    public boolean initByOAHKXQB001(String psn) {
        HKXQB001 b = hkxqb001Bean.findByPSN(psn);
        if (b == null) {
            throw new NullPointerException();
        }
        try {
            String SerialNumber = b.getSerialNumber();//表单单号
            String xqjs = b.getXqjs();//需求简称
            Date date1 = b.getCreatedate();//创建日期
            String ssxt = b.getSsxt();//所属系统
            String ssmk = b.getSsmk();//所属模块
            String cxmc = b.getCxmc();//程序名称
            String appuser = b.getApplyuser();
            String user1 = b.getUser1();//需求人
            String user2 = b.getUser2();//负责人
            String dept1 = b.getDept1();//需求部门
            Date date2 = b.getTime1();//需求日期
            String xqnr = b.getXqnr();//需求内容
            //抛转EAP的Demands
            Demands d = new Demands();
            SystemUser s;
            Department t;
            Date date;
            Date formDate;
            date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
            formDate = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
            //单号
            String formid;
            formid = this.getFormId(date, "PL", "yyMM", 3, "formid");
            d.setFormid(formid);
            d.setOid(SerialNumber);//OA表单单号
            d.setDemandContent(xqjs);
            d.setDemandsResume(xqnr);
            d.setSystemName(ssxt);
            d.setModulName(ssmk);
            d.setProcedureName(cxmc);
            d.setDemandDate(date2);
            d.setStatus("未完成");
            if (user1 != null && !"".equals(user1)) {
                d.setDemandNameID(user1);//需求人
                s = systemUserBean.findByUserId(user1);
                d.setDemandName(s.getUsername());
            }
            if (appuser != null && !"".equals(appuser)) {
                d.setWriterID(appuser);//创建需求人
                s = systemUserBean.findByUserId(appuser);
                d.setWriterName(s.getUsername());
            }
            d.setFormdate(formDate);//表单日期为SQL的日期
            d.setWriteDate(date1);//创建时间
            if (dept1 != null && !"".equals(dept1)) {
                d.setDemandDeptno(dept1);//需求部门
                t = departmentBean.findByDeptno(dept1);
                d.setDemandDeptName(t.getDept());
            }
            if (user2 != null && !"".equals(user2)) {
                /*负责人*/
                d.setDirectorID(user2);
                s = systemUserBean.findByUserId(user2);
                d.setDirectorName(s.getUsername());
                /*责任部门*/
                String directorDeptId = s.getDeptno();
                d.setDirectorDeptID(directorDeptId);
                t = departmentBean.findByDeptno(directorDeptId);
                d.setDirectorDeptName(t.getDept());
            } else {
                d.setDirectorID("");
                d.setDirectorName("");
                d.setDirectorDeptID("");
                d.setDirectorDeptName("");
            }
            persist(d);
            return true;
        } catch (ParseException | NullPointerException | NumberFormatException ex) {
            log4j.error("initByOAHKXQB001", ex.toString());
            return false;
        }
    }

}
