/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.ProductSeriesBean;
import cn.hanbell.eap.entity.ProductSeries;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.SuperEJB;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author C0160
 */
@Path("eap/productseries")
@javax.enterprise.context.RequestScoped
public class ProductSeriesFacadeREST extends SuperRESTForEAP<ProductSeries> {

    @EJB
    private ProductSeriesBean productSeriesBean;

    public ProductSeriesFacadeREST() {
        super(ProductSeries.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return productSeriesBean;
    }

}
