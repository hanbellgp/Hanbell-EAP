/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.ProposalAttach;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.json.Json;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class ProposalAttachBean  extends SuperEJBForEAP<ProposalAttach>{

    public ProposalAttachBean() {
        super(ProposalAttach.class);
    }

    @Override
    public JsonObjectBuilder createJsonObjectBuilder(ProposalAttach entity) {
        JsonObjectBuilder job = Json.createObjectBuilder();
        if (entity != null) {
            job.add("id", entity.getId())
                    .add("pid", entity.getPid())
                    .add("seq", entity.getSeq())
                    .add("resource",entity.getResource());
        
            if (entity.getContent() != null) {
                job.add("content", entity.getContent());
            } else {
                job.addNull("content");
            }
        }
        return job;
    }
    
}
