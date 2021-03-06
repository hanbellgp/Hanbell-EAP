/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.wei.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.wei.entity.MaintenanceCategory;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author kevindong
 */
@Stateless
public class MaintenanceCategoryBean extends SuperEJBForEAP<MaintenanceCategory> {

    public MaintenanceCategoryBean() {
        super(MaintenanceCategory.class);
    }

    @Override
    public JsonObjectBuilder createJsonObjectBuilder(MaintenanceCategory entity) {
        JsonObjectBuilder job = Json.createObjectBuilder();
        if (entity != null) {
            job.add("id", entity.getId())
                    .add("name", entity.getName());
            if (entity.getClassname() != null) {
                job.add("classname", entity.getClassname());
            } else {
                job.addNull("classname");
            }
            if (entity.getItemcount() != null) {
                job.add("itemcount", entity.getItemcount());
            } else {
                job.add("itemcount", 0);
            }
        }
        return job;
    }

}
