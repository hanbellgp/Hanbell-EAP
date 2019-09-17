/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.CustomerComplaint;
import cn.hanbell.eap.entity.CustomerComplaintMaterial;
import com.lightshell.comm.BaseLib;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1879
 */
@Stateless
@LocalBean
public class CustomerComplaintBean extends SuperEJBForEAP<CustomerComplaint> {

    @EJB
    protected CustomerComplaintMaterialBean customerComplaintMaterialBean;

    protected String css = "<style type='text/css'>body{font-size:14px;}div.content{margin:auto;text-align:center;}div.tbl{margin-bottom:20px;}table{margin:auto;border-spacing:0px;border:1px solid #A2C0DA;}th,td{padding:5px;border-collapse:collapse;}th{background:#B0D0FC;border:1px solid #000000;text-align:center;font-weight:bold;}td{background:#D3E5FD;border:1px solid #000000;}.title{font-size:14px;font-weight:bold;}.foot{font-size:14px;color:Red;}.divFoot{text-align:right;height:20px;width:100%;}div.tableTitle{float:left;font-size:14px;font-weight:bold;text-align:left;}</style>";

    public CustomerComplaintBean() {
        super(CustomerComplaint.class);
    }

    public Date getDateBegin(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 00);
        c.set(Calendar.MINUTE, 00);
        c.set(Calendar.SECOND, 00);
        return c.getTime();
    }

    public Date getDateEnd(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }

    public List<CustomerComplaint> findOverdate(Date date) {
        Query query = getEntityManager().createNamedQuery("CustomerComplaint.findOverdate");
        query.setParameter("begin", getDateBegin(date));
        query.setParameter("end", getDateEnd(date));
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public CustomerComplaint findKfno(String kfno) {
        Query query = getEntityManager().createNamedQuery("CustomerComplaint.findKfno");
        query.setParameter("kfno", kfno);
        try {
            return (CustomerComplaint) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public String getMail(String mailSubject, String kfno) {
        return getMailHead(mailSubject) + getMailBody(kfno);
    }

    protected String getMailHead(String mailSubject) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>Hanbell</title>");
        sb.append(css);
        sb.append("</head><body><div style=\"margin: auto;text-align: center;\">");
        sb.append("<div style=\"width:100%\" class=\"title\">");
        sb.append("<div style=\"text-align:center;width:100%\">上海汉钟精机股份有限公司</div>");
        sb.append("<div style=\"text-align:center;width:100%; color:Red;\">日期:").append(BaseLib.formatDate("yyyy-MM-dd", new Date())).append("</div>");
        sb.append("<div style=\"text-align:center;width:100%\">").append(mailSubject).append("</div>");
        sb.append("</div>");
        return sb.toString();
    }

    protected String getMailBody(String kfno) {
        if ("".equals(kfno)) {
            throw new NullPointerException("客诉单抛转无效");
        }
        CustomerComplaint plaint = findKfno(kfno);
        if (plaint == null) {
            throw new NullPointerException(String.format("客诉单%s:数据详情抛转失败", plaint.getKfno()));
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"tableTitle\">费用单位：元</div>");
        sb.append(getHtmlTable(plaint));
        return sb.toString();
    }

    protected String getHtmlTable(CustomerComplaint plaint) {
        List<CustomerComplaintMaterial> plaintDetailList = customerComplaintMaterialBean.findKfno(plaint.getKfno());
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("<div class=\"tbl\"><table width=\"100%\" style=\"text-align:center\">");
            sb.append("<tr><th width=\"4%\">产品别</th><th width=\"7%\">客诉单号</th><th width=\"6%\">客户名称</th><th width=\"7%\">制造号码</th><th width=\"18%\">不良原因</th>");
            sb.append("<th width=\"6%\">责任单位</th><th width=\"6%\">责任判定</th><th width=\"4%\">责任判断比率</th><th width=\"5%\">材料费</th><th width=\"5%\">人工费</th><th width=\"5%\">运输费(含空运、吊装费)</th>");
            sb.append("<th width=\"5%\">差旅费</th><th width=\"5%\">不良导致索赔款</th><th width=\"5%\">其他</th><th width=\"5%\">费用合计</th><th width=\"7%\">结案时间</th></tr>");
            sb.append("<tr><td>").append(plaint.getNcodeDC()).append("</td>");
            sb.append("<td>").append(plaint.getKfno()).append("</td>");
            sb.append("<td>").append(plaint.getCusna()).append("</td>");
            sb.append("<td>").append(plaint.getVarnr()).append("</td>");
            sb.append("<td>").append(plaint.getBadwhy()).append("</td>");
            sb.append("<td>").append("".equals(plaint.getDutydeptna().trim()) || "null".equals(plaint.getDutydeptna()) ? plaint.getDutydeptno() : plaint.getDutydeptna()).append("</td>");
            sb.append("<td>").append(plaint.getRemark1()).append("</td>");
            sb.append("<td>").append(plaint.getDutyrate()).append("</td>");
            sb.append("<td>").append(plaint.getMaterialcost().toString()).append("</td>");
            sb.append("<td>").append(plaint.getLabourcost().toString()).append("</td>");
            sb.append("<td>").append(plaint.getTansportexpense().toString()).append("</td>");
            sb.append("<td>").append(plaint.getTravelexpense().toString()).append("</td>");
            sb.append("<td>").append(plaint.getClaimamount().toString()).append("</td>");
            sb.append("<td>").append(plaint.getOthercost().toString()).append("</td>");
            sb.append("<td>").append(plaint.getTotalamount().toString()).append("</td>");
            sb.append("<td>").append(BaseLib.formatDate("yyyy/MM/dd HH:mm", plaint.getOverdate())).append("</td>");
            sb.append("</tr></table></div>");
            sb.append("<div style=\"text-align:center;width:100%\" class=\"title\">服务领退材料明细</div>");
            sb.append("<div class=\"tbl\"><table style=\"text-align:center\" width=\"100%\">");
            sb.append("<tr><th>客诉单号</th><th>服务单号</th><th>类型</th><th>领退料单号</th><th>品号</th><th>品名</th><th>数量</th><th>单位</th><th>金额</th></tr>");
            if (plaintDetailList != null && !plaintDetailList.isEmpty()) {
                for (CustomerComplaintMaterial cpd : plaintDetailList) {
                    sb.append(getHtmlTableRow(cpd));
                }
            } else {
                sb.append("<tr><td colspan=\"9\">No records found.</td></tr>");
            }
            sb.append("</table></div>");
        } catch (Exception e) {
        }

        return sb.toString();
    }

    protected String getHtmlTableRow(CustomerComplaintMaterial cpd) {
        //获取需要取值栏位
        StringBuilder sb = new StringBuilder();
        sb.append("<tr><td>").append(cpd.getKfno()).append("</td>");
        sb.append("<td>").append(cpd.getFwno()).append("</td>");
        sb.append("<td>").append(cpd.getTypedsc()).append("</td>");
        sb.append("<td>").append(cpd.getTrno()).append("</td>");
        sb.append("<td>").append(cpd.getItnbr()).append("</td>");
        sb.append("<td>").append(cpd.getItdsc()).append("</td>");
        sb.append("<td>").append(cpd.getTrnqy1().toString()).append("</td>");
        sb.append("<td>").append(cpd.getUnmsr1()).append("</td>");
        sb.append("<td>").append(cpd.getTramt().toString()).append("</td></tr>");
        return sb.toString();
    }
}
