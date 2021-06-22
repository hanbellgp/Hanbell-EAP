/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.ProcessCheck;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class ProcessCheckBean extends SuperEJBForEFGP<ProcessCheck> {

    public ProcessCheckBean() {
        super(ProcessCheck.class);
    }

    public List<ProcessCheck> findByPSN(String serialNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append("Select ProcessInstance.serialNumber, WorkItem.currentState, Users.id ,Users.userName,WorkItem.workItemName,");
        sb.append("dbo.WorkItem.createdTime, WorkItem.completedTime ,WorkItem.executiveComment from ProcessInstance ");
        sb.append("inner join WorkItem on WorkItem.contextOID=ProcessInstance.contextOID ");
        sb.append("inner join Users on Users.OID =  WorkItem.performerOID ");
        sb.append("inner join ProcessContext on ProcessContext.OID= ProcessInstance.contextOID ");
        sb.append("inner join ProcessPackage_ProcessDef on ProcessPackage_ProcessDef.ProcessPackageOID =ProcessContext.processPackageOID ");
        sb.append("inner join ActivityDefinition on ProcessPackage_ProcessDef.ProcessDefinitionOID = ActivityDefinition.containerOID ");
        sb.append("inner join ParticipantActivityInstance on ParticipantActivityInstance.contextOID=ProcessInstance.contextOID and WorkItem.containerOID=ParticipantActivityInstance.OID and ParticipantActivityInstance.definitionId=ActivityDefinition.id ");
        sb.append("left join ReassignWorkItemAuditData on ReassignWorkItemAuditData.sourceOID = WorkItem.OID ");
        sb.append("Where ProcessInstance.serialNumber = '").append(serialNumber).append("'");
        sb.append(" UNION ALL Select ProcessInstance.serialNumber, WorkItem.currentState, Users.id , Users.userName,WorkItem.workItemName,");
        sb.append("dbo.WorkItem.createdTime, WorkItem.completedTime ,WorkItem.executiveComment from ProcessInstance ");
        sb.append("inner join WorkItem on WorkItem.contextOID=ProcessInstance.contextOID ");
        sb.append("inner join Users on Users.OID =  WorkItem.performerOID ");
        sb.append("inner join ProcessContext on ProcessContext.OID= ProcessInstance.contextOID ");
        sb.append("inner join ProcessPackage_ProcessDef on ProcessPackage_ProcessDef.ProcessPackageOID =ProcessContext.processPackageOID ");
        sb.append("inner join ActivitySetDefinition on ProcessPackage_ProcessDef.ProcessDefinitionOID = ActivitySetDefinition.containerOID ");
        sb.append("inner join ActivityDefinition on ActivitySetDefinition.OID = ActivityDefinition.containerOID ");
        sb.append("inner join ParticipantActivityInstance on ParticipantActivityInstance.contextOID=ProcessInstance.contextOID and WorkItem.containerOID=ParticipantActivityInstance.OID and ParticipantActivityInstance.definitionId = ActivityDefinition.id ");
        sb.append("left join ReassignWorkItemAuditData on ReassignWorkItemAuditData.sourceOID = WorkItem.OID ");
        sb.append("Where ProcessInstance.serialNumber = '").append(serialNumber).append("' order by completedTime");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        List result = query.getResultList();
        List<ProcessCheck> dataList = new ArrayList<>();
        if (!result.isEmpty() && null != result) {
            ProcessCheck newEntity;
            for (int i = 0; i < result.size(); i++) {
                Object[] row = (Object[]) result.get(i);
                newEntity = new ProcessCheck(row[0].toString(), row[2].toString(), row[3].toString(), row[4].toString(), row[5].toString(), row[6].toString(), Integer.parseInt(row[1].toString()));
                newEntity.setExecutiveComment(row[7].toString());
                dataList.add(newEntity);
            }
        }
        return dataList;

    }
}
