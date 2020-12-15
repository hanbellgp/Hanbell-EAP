/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.MiscodeBean;
import cn.hanbell.erp.entity.Miscode;
import cn.hanbell.jrs.ResponseData;
import cn.hanbell.jrs.SuperRESTForERP;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

/**
 *
 * @author C1491
 */
@Path("shberp/coin")
public class CoinFacadeREST extends SuperRESTForERP<Miscode> {

    @EJB
    private MiscodeBean miscodeBean;

    public CoinFacadeREST() {
        super(Miscode.class);
    }

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        return miscodeBean;
    }

    @Override
    public ResponseData findAll(PathSegment company, String appid, String token) {
        if (isAuthorized(appid, token)) {
            List<Miscode> miscodeList;
            try {
                this.company = company.getPath();
                miscodeBean.setCompany(this.company);
                miscodeList = miscodeBean.findByCkind("GA", 'Y');
                ResponseData res = new ResponseData<Miscode>("200", "success");
                res.setData(miscodeList);
                res.setCount(miscodeList.size());
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
