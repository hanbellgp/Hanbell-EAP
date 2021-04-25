/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HSYPB004;
import cn.hanbell.oa.entity.HSYPB004Detail;
import cn.hanbell.oa.entity.ProcessInstance;
import cn.hanbell.oa.entity.Users;
import cn.hanbell.util.BaseLib;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class HSYPB004Bean extends SuperEJBForEFGP<HSYPB004> {

    @EJB
    private HSYPB004DetailBean hsypb004DetailBean;

    public HSYPB004Bean() {
        super(HSYPB004.class);
    }

    public List<HSYPB004Detail> getDetailList(String fsn) {
        return hsypb004DetailBean.findByFSN(fsn);
    }

    public String getMailAddress(String userid) {
        Users user = usersBean.findUserByUserno(userid);
        return user.getMailAddress();
    }

    public String getMailContent(String psn) {
        ProcessInstance pi = processInstanceBean.findBySerialNumber(psn);
        Users user = usersBean.findByOID(pi.getRequesterOID());
        HSYPB004 master = this.findByPSN(psn);
        List<HSYPB004Detail> detail = getDetailList(master.getFormSerialNumber());

        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>Hanson</title>");
        sb.append("</head><body><div style=\"margin:auto;text-align:center;\">");
        sb.append("<table border=\"1px\" cellpadding=\"0\" cellspacing=\"0\" style=\"width:800px;margin-left:19.45px;margin-right:19.45px;\"> ");
        sb.append("<tr style=\"height:30px;\">");
        sb.append("<th style=\"border:solid #000000 1.0px;background:#B0D0FC\"> ");
        sb.append(pi.getSubject());
        sb.append("</th></tr>");
        sb.append("<tr style=\"min-height:400px;\">");
        sb.append("<td valign=\"top\" style=\"border:solid #000000 1.0px;background:white\"> ");
        sb.append("<div style=\"margin:20px 20px 20px 20px;font-size:14px;font-weight:600\">流程模型名称：").append(pi.getProcessInstanceName()).append("</div>");
        sb.append("<div style=\"margin:0px 20px 20px 20px;font-size:14px;font-weight:600\">流程发起时间：").append(BaseLib.formatDate("yyyy-MM-dd", pi.getCreatedTime())).append("</div>");
        sb.append("<div style=\"margin:0px 20px 20px 20px;font-size:14px;font-weight:600\">流程发起人员：").append(user.getUserName()).append("</div>");
        sb.append("<div style=\"margin:0px 20px 20px 20px;font-size:14px;font-weight:600\">文件申请用途：").append(master.getApplyRemark()).append("</div>");
        sb.append("<div style=\"margin:0px 20px 20px 20px;font-size:14px;font-weight:600\">新文件编号：").append(master.getNewNo()).append("</div>");
        sb.append("<div style=\"margin:0px 20px 20px 20px;font-size:14px;font-weight:600\">新文件名称：").append(master.getNewName()).append("</div>");
        sb.append("<div style=\"margin:0px 20px 20px 20px;font-size:14px;font-weight:600\">旧文件编号：").append(master.getOldNo()).append("</div>");
        sb.append("<div style=\"margin:0px 20px 20px 20px;font-size:14px;font-weight:600\">旧文件名称：").append(master.getOldName()).append("</div>");
        sb.append("<div style=\"margin:0px 20px 20px 20px;;font-size:14px;font-weight:600\">文管中心说明：").append(master.getRemarks()).append("</div>");
        if (detail != null && !detail.isEmpty()) {
            sb.append("<div style=\"margin:20px 20px 20px 20px;font-size:14px;font-weight:600\">文件申请明细：");
            sb.append("<table  border=\"1\" cellpadding=\"0\" cellspacing=\"0\">");
            sb.append("<tr>");
            sb.append("<th style=\"border:solid #000000 1.0px;background:#B0D0FC\">序号</th>");
            sb.append("<th style=\"border:solid #000000 1.0px;background:#B0D0FC\">新件号</th>");
            sb.append("<th style=\"border:solid #000000 1.0px;background:#B0D0FC\">新品名</th>");
            sb.append("<th style=\"border:solid #000000 1.0px;background:#B0D0FC\">旧件号</th>");
            sb.append("</tr>");
            for (HSYPB004Detail d : detail) {
                sb.append("<tr>");
                sb.append("<td width=\"50\" style=\"border:solid #000000 1.0px;\">").append(d.getSeq()).append("</td>");
                sb.append("<td width=\"200\" style=\"border:solid #000000 1.0px;\">").append(d.getNewItnbr()).append("</td>");
                sb.append("<td width=\"260\" style=\"border:solid #000000 1.0px;\">").append(d.getNewItdsc()).append("</td>");
                sb.append("<td width=\"200\" style=\"border:solid #000000 1.0px;\">").append(d.getOldItnbr()).append("</td>");
                sb.append("</tr>");
            }
            sb.append("</table>");
            sb.append("</div>");
        }
        sb.append("</td></tr></table>");
        sb.append("</div>");
        return sb.toString();
    }

}
