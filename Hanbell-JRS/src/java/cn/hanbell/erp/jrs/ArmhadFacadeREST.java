/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.ArmhadBean;
import cn.hanbell.erp.entity.Armhad;
import cn.hanbell.erp.entity.ArmhadPK;
import cn.hanbell.jrs.SuperRESTForERP;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author C0160
 */
@Stateless
@Path("shberp/armhad")
public class ArmhadFacadeREST extends SuperRESTForERP<Armhad> {

    @EJB
    private ArmhadBean armhadBean;

    private ArmhadPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;facno=facnoValue;cusno=cusnoValue;hadno=hadnoValue;hadseq=hadseqValue;accno=accnoValue;detno=detnoValue;hseq=hseqValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ArmhadPK key = new ArmhadPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> facno = map.get("facno");
        if (facno != null && !facno.isEmpty()) {
            key.setFacno(facno.get(0));
        }
        java.util.List<String> cusno = map.get("cusno");
        if (cusno != null && !cusno.isEmpty()) {
            key.setCusno(cusno.get(0));
        }
        java.util.List<String> hadno = map.get("hadno");
        if (hadno != null && !hadno.isEmpty()) {
            key.setHadno(hadno.get(0));
        }
        java.util.List<String> hadseq = map.get("hadseq");
        if (hadseq != null && !hadseq.isEmpty()) {
            key.setHadseq(new java.lang.Short(hadseq.get(0)));
        }
        java.util.List<String> accno = map.get("accno");
        if (accno != null && !accno.isEmpty()) {
            key.setAccno(accno.get(0));
        }
        java.util.List<String> detno = map.get("detno");
        if (detno != null && !detno.isEmpty()) {
            key.setDetno(detno.get(0));
        }
        java.util.List<String> hseq = map.get("hseq");
        if (hseq != null && !hseq.isEmpty()) {
            key.setHseq(new java.lang.Short(hseq.get(0)));
        }
        return key;
    }

    public ArmhadFacadeREST() {
        super(Armhad.class);
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Armhad findById(@PathParam("id") PathSegment id) {
        ArmhadPK key = getPrimaryKey(id);
        return null;
    }

    @GET
    @Path("list/{cusno}/{state}")
    @Produces({"application/json"})
    public List<Armhad> findByCustomer(@PathParam("cusno") String cusno, @PathParam("state") String state) {
        Query query;
        switch (state) {
            case "N":
                query = armhadBean.getEntityManager().createNamedQuery("Armhad.findByCusnoDefault");
                query.setParameter("cusno", cusno);
                break;
            case "Y":
                query = armhadBean.getEntityManager().createNamedQuery("Cdrschedule.findByCusnoClosed");
                query.setParameter("cusno", cusno);
                break;
            case "A":
                query = armhadBean.getEntityManager().createNamedQuery("Armhad.findByCusnoAll");
                query.setParameter("cusno", cusno);
                break;
            default:
                query = armhadBean.getEntityManager().createNamedQuery("Armhad.findByCusnoDefault");
                query.setParameter("cusno", cusno);
        }
        return query.getResultList();
    }

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        company = "C";
        return armhadBean;
    }

}
