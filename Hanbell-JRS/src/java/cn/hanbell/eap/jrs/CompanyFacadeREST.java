/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.CompanyBean;
import cn.hanbell.eap.entity.Company;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.SuperEJB;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author C0160
 */
@Path("eap/company")
@javax.enterprise.context.RequestScoped
public class CompanyFacadeREST extends SuperRESTForEAP<Company> {

    @EJB
    private CompanyBean companyBean;

    public CompanyFacadeREST() {
        super(Company.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return companyBean;
    }

}
