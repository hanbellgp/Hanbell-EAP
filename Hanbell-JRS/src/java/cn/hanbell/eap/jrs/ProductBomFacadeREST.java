/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.ProductBomBean;
import cn.hanbell.eap.entity.ProductBom;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.SuperEJB;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author C0160
 */
@Path("eap/productbom")
@javax.enterprise.context.RequestScoped
public class ProductBomFacadeREST extends SuperRESTForEAP<ProductBom> {

    @EJB
    private ProductBomBean productBomBean;

    public ProductBomFacadeREST() {
        super(ProductBom.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return productBomBean;
    }

}
