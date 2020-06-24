/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.PricingBean;
import cn.hanbell.erp.entity.Pricing;
import cn.hanbell.erp.entity.PricingPK;
import cn.hanbell.jrs.SuperRESTForERP;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author C0160
 */
@Path("shberp/pricing")
@javax.enterprise.context.RequestScoped
public class PricingFacadeREST extends SuperRESTForERP<Pricing> {

    @Inject
    private PricingBean pricingBean;

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        company = "C";
        return pricingBean;
    }

    private PricingPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;pricingid=pricingidValue;itnbr=itnbrValue;itemno=itemnoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        cn.hanbell.erp.entity.PricingPK key = new cn.hanbell.erp.entity.PricingPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> pricingid = map.get("pricingid");
        if (pricingid != null && !pricingid.isEmpty()) {
            key.setPricingid(pricingid.get(0));
        }
        java.util.List<String> itnbr = map.get("itnbr");
        if (itnbr != null && !itnbr.isEmpty()) {
            key.setItnbr(itnbr.get(0));
        }
        java.util.List<String> itemno = map.get("itemno");
        if (itemno != null && !itemno.isEmpty()) {
            key.setItemno(itemno.get(0));
        }
        return key;
    }

    public PricingFacadeREST() {
        super(Pricing.class);
    }

    @GET
    @Path("{itnbr}")
    @Produces({"application/json"})
    public Pricing findById(@PathParam("itnbr") PathSegment query) {
        Pricing entity = null;
        MultivaluedMap<String, String> mv = query.getMatrixParameters();
        Map<String, Object> filters = new HashMap<>();
        for (Map.Entry<String, List<String>> entrySet : mv.entrySet()) {
            String key = entrySet.getKey();
            String value = entrySet.getValue().get(0);
            filters.put(key, value);
        }
        try {
            entity = pricingBean.findByItnbrAndFilters(query.getPath(), filters);
        } catch (ParseException ex) {
            Logger.getLogger(PricingFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

}
