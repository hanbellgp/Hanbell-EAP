/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.Proposal;
import cn.hanbell.eap.entity.ProposalAttach;
import cn.hanbell.eap.entity.SystemProgram;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class ProposalBean extends SuperEJBForEAP<Proposal> {

    @EJB
    private SystemProgramBean systemProgramBean;
    @EJB
    private ProposalAttachBean proposalAttachBean;
    private List<ProposalAttach> attachList;
    
    public ProposalBean() {
        super(Proposal.class);
    }

    public String getFormId(Date day) {
        SystemProgram sp = systemProgramBean.findBySystemAndAPI("HBEAP", "proposal");
        if (sp == null) {
            throw new NullPointerException("找不到应用接口_proposal");
        }
        return super.getFormId(day, sp.getNolead(), sp.getNoformat(), sp.getNoseqlen(),"proposalid");
    }

    public List<ProposalAttach> getAttachList() {
        return attachList;
    }

    public void setAttachList(List<ProposalAttach> attachList) {
        this.attachList = attachList;
    }
    
}
