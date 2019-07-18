/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.wei.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.wei.entity.MaintenanceDetail;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author kevindong
 */
@Stateless
public class MaintenanceDetailBean extends SuperEJBForEAP<MaintenanceDetail> {

    public MaintenanceDetailBean() {
        super(MaintenanceDetail.class);
    }

    @Override
    public JsonObjectBuilder createJsonObjectBuilder(MaintenanceDetail entity) {
        JsonObjectBuilder job = Json.createObjectBuilder();
        if (entity != null) {
            job.add("id", entity.getId())
                    .add("pid", entity.getPid())
                    .add("seq", entity.getSeq())
                    .add("resource", entity.getResource());
            if (entity.getSubject() != null) {
                job.add("subject", entity.getSubject());
            } else {
                job.addNull("subject");
            }
            if (entity.getContent() != null) {
                job.add("content", entity.getContent());
            } else {
                job.addNull("content");
            }
            if (entity.getImgfile() != null) {
                job.add("imgfile", entity.getImgfile());
            } else {
                job.addNull("imgfile");
            }
        }
        return job;
    }

}
