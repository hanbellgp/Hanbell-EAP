/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.edw.ejb;

import cn.hanbell.edw.comm.SuperEJBForEDW;
import cn.hanbell.edw.entity.EhsSecure;
import cn.hanbell.edw.entity.RdpmSubjectUserReports;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C2079
 */
@Stateless
@LocalBean
public class RdpmSubjectUserReportsBean extends SuperEJBForEDW<RdpmSubjectUserReports> {

    public RdpmSubjectUserReportsBean() {
        super(RdpmSubjectUserReports.class);
    }

    public List<RdpmSubjectUserReports> getRdpmSubjectUserReportsList(String userNo, String rDate) {
        String sqlStr = "SELECT * FROM RdpmSubjectUserReports a WHERE a.subjectUserNo = '" + userNo + "' AND CAST(SubjectWorkDateTime AS DATE)= '" + rDate + "' order by  SubjectNo desc";

        try {
            Query query = getEntityManager().createNativeQuery(sqlStr, RdpmSubjectUserReports.class);
            List<RdpmSubjectUserReports> results = query.getResultList();
            return results;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Object[]> getInitRdpmSubjectUserReportsList(String userNo,String rDate) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT A.SubJectNo,A.SubjectName,B.UType,B.SubjectUserNo,B.SubjectUserName,A.SubjectSeq,A.SubjectSeqName FROM RdpmSubjects A  LEFT JOIN   RdpmSubjectUser B   ON  A.SubJectNo=B.SubjectNo    And  A.SubjectSeq=B.SubjectSeq");
        sb.append(" where  B.SubjectUserNo='").append(userNo).append("'  and UType='研发人员'  and  SubjectEndTime >='"+rDate+"'  AND SubjectStartTime<='"+rDate+"'  order by  A.SubjectNo desc");
        //生成SQL
        Query query = getEntityManager().createNativeQuery(sb.toString());

        List<Object[]> results = query.getResultList();
        return results;

    }
    
    //获取除研发人员的其他间接人员
      public List<Object[]> getRdpmSubjectUserList(String subjectNo) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT SubjectUserNo,SubjectUserName,UType FROM RdpmSubjectUser  WHERE  SubjectNo='"+subjectNo+"'  AND UType!='研发人员'");
        //生成SQL
        Query query = getEntityManager().createNativeQuery(sb.toString());

        List<Object[]> results = query.getResultList();
        return results;

    }

}
