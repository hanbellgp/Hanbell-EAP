/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.hanbell.exch.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.persistence.Query;
import tw.hanbell.exch.comm.SuperEJBForEXCH;
import tw.hanbell.exch.entity.BPMEmployee;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class BPMEmployeeBean extends SuperEJBForEXCH<BPMEmployee> {

    public BPMEmployeeBean() {
        super(BPMEmployee.class);
    }

    public BPMEmployee findByUserid(String userid) {
        Query query = getEntityManager().createNamedQuery("BPMEmployee.findByUserid");
        query.setParameter("userid", userid);
        try {
            Object o = query.getSingleResult();
            return (BPMEmployee) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public JsonObjectBuilder createThbJsonObjectBuilder(int deptid,BPMEmployee entity) {
        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("userid", entity.getUserid()).add("name", entity.getCnName());
        //台湾沈里达课长要做兼职处理。由他抛转到中间库中
        if (entity != null) {
            String[] sa = entity.getSyscOrg().split(",");
            List<Integer> depts = new ArrayList<>();
            depts.add(deptid);
            List<Integer> sort = new ArrayList<>();
            sort.add(sa.length+1);
            for (int i = 0; i < sa.length; i++) {
                depts.add(Integer.valueOf(sa[i]));
                sort.add(sa.length - i);//倒序，大数字在前。
            }
            job.add("department", Json.createArrayBuilder(depts));
            job.add("order", Json.createArrayBuilder(sort));

        }
       System.out.print(job.toString());
        return job;
    }
}
