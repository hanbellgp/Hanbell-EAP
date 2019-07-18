/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.ejb.MiscodeBean;
import cn.hanbell.erp.entity.Miscode;
import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.oa.app.KV;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author C1491
 */
@Path("erp/coin")
@javax.enterprise.context.RequestScoped
public class CoinFacadeREST extends SuperRESTForEFGP<KV> {

    @EJB
    private MiscodeBean miscodeBean;

    public CoinFacadeREST() {
        super(KV.class);
    }

    @Override
    protected SuperEJBForEFGP getSuperEJB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<KV> findAll(String appid, String token) {
        if (isAuthorized(appid, token)) {
            List<Miscode> miscodeList;
            try {
                List<KV> dataList = new ArrayList<>();
                miscodeBean.setCompany("C");
                miscodeList = miscodeBean.findByCkind("GA", 'Y');
                if (!miscodeList.isEmpty()) {
                    for (Miscode miscode : miscodeList) {
                        dataList.add(new KV(miscode.getMiscodePK().getCode(), miscode.getCdesc()));
                    }
                }
                return dataList;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
