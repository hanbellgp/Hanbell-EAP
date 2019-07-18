/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.CdrdmasBean;
import cn.hanbell.erp.entity.Cdrdmas;
import cn.hanbell.erp.entity.CdrdmasPK;
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
 * I
 *
 * @author C0160
 */
@Stateless
@Path("shberp/cdrdmas")
public class CdrdmasFacadeREST extends SuperRESTForERP<Cdrdmas> {

    @EJB
    private CdrdmasBean cdrdmasBean;

    private CdrdmasPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;facno=facnoValue;cdrno=cdrnoValue;trseq=trseqValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        CdrdmasPK key = new CdrdmasPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> facno = map.get("facno");
        if (facno != null && !facno.isEmpty()) {
            key.setFacno(facno.get(0));
        }
        java.util.List<String> cdrno = map.get("cdrno");
        if (cdrno != null && !cdrno.isEmpty()) {
            key.setCdrno(cdrno.get(0));
        }
        java.util.List<String> trseq = map.get("trseq");
        if (trseq != null && !trseq.isEmpty()) {
            key.setTrseq(new java.lang.Short(trseq.get(0)));
        }
        return key;
    }

    public CdrdmasFacadeREST() {
        super(Cdrdmas.class);
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Cdrdmas findById(@PathParam("id") PathSegment id) {
        CdrdmasPK key = getPrimaryKey(id);
        return null;
    }

    @GET
    @Path("{cusno}/{itnbrcus}/{count}")
    @Produces({"application/xml", "application/json"})
    public List<Cdrdmas> findByCustomerAndItnbrcus(@PathParam("cusno") String cusno, @PathParam("itnbrcus") String itnbrcus, @PathParam("count") int count) {
        Query query = cdrdmasBean.getEntityManager().createNamedQuery("Cdrdmas.findByCusnoAndItnbrcus").setFirstResult(0).setMaxResults(count);
        query.setParameter("cusno", cusno);
        query.setParameter("itnbrcus", "%" + itnbrcus + "%");
        return query.getResultList();
    }

    @Override
    protected SuperEJBForERP getERPEJB() {
        company = "C";
        return cdrdmasBean;
    }

}
