/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.jrs;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author C0160
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(cn.hanbell.crm.jrs.CMSMEFacadeREST.class);
        resources.add(cn.hanbell.crm.jrs.CRMGGFacadeREST.class);
        resources.add(cn.hanbell.crm.jrs.DCSFacadeREST.class);
        resources.add(cn.hanbell.crm.jrs.DFWELFacadeREST.class);
        resources.add(cn.hanbell.crm.jrs.DJXFacadeREST.class);
        resources.add(cn.hanbell.crm.jrs.DSHFacadeREST.class);
        resources.add(cn.hanbell.crm.jrs.PORBGFacadeREST.class);
        resources.add(cn.hanbell.crm.jrs.REPMAFacadeREST.class);
        resources.add(cn.hanbell.crm.jrs.REPMBFacadeREST.class);
        resources.add(cn.hanbell.crm.jrs.REPMIFacadeREST.class);
        resources.add(cn.hanbell.crm.jrs.REPMQFacadeREST.class);
        resources.add(cn.hanbell.crm.jrs.REPPWFacadeREST.class);
        resources.add(cn.hanbell.crm.jrs.REPTAFacadeREST.class);
        resources.add(cn.hanbell.crm.jrs.REPTCFacadeREST.class);
        resources.add(cn.hanbell.crm.jrs.SERACFacadeREST.class);
        resources.add(cn.hanbell.crm.jrs.SERBQFacadeREST.class);
        resources.add(cn.hanbell.crm.jrs.WARMAFacadeREST.class);
        resources.add(cn.hanbell.crm.jrs.WARMJFacadeREST.class);
        resources.add(cn.hanbell.crm.jrs.WARMQFacadeREST.class);
        resources.add(cn.hanbell.eap.jrs.BookingFacadeREST.class);
        resources.add(cn.hanbell.eap.jrs.BookingKindFacadeREST.class);
        resources.add(cn.hanbell.eap.jrs.CompanyFacadeREST.class);
        resources.add(cn.hanbell.eap.jrs.DemandsFacadeREST.class);
        resources.add(cn.hanbell.eap.jrs.DepartmentFacadeREST.class);
        resources.add(cn.hanbell.eap.jrs.SystemNameFacadeREST.class);
        resources.add(cn.hanbell.eap.jrs.SystemUserFacadeREST.class);
        resources.add(cn.hanbell.eap.jrs.TaskFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.ArmhadFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.ArmhadSumFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.BudgetCenterAccFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.BudgetCenterFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.CdrcusFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.CdrdmasFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.CdrscheduleFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.CoinFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.InvbalFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.InvmasFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.InvwhFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.ItemCategoryFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.ItemFaultFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.ItemKindFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.ItemMasterFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.ItemModelFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.MiscodeFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.PricingFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.PricingGroupFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.PricingPolicyFacadeREST.class);
        resources.add(cn.hanbell.erp.jrs.SecuserFacadeREST.class);
        resources.add(cn.hanbell.jrs.CORSFilter.class);
        resources.add(cn.hanbell.oa.jrs.BizDestinationFacadeREST.class);
        resources.add(cn.hanbell.oa.jrs.BizKindFacadeREST.class);
        resources.add(cn.hanbell.oa.jrs.BizVehicleFacadeREST.class);
        resources.add(cn.hanbell.oa.jrs.FunctionsFacadeREST.class);
        resources.add(cn.hanbell.oa.jrs.HKGL004FacadeREST.class);
        resources.add(cn.hanbell.oa.jrs.HKGL034FacadeREST.class);
        resources.add(cn.hanbell.oa.jrs.HKGL037FacadeREST.class);
        resources.add(cn.hanbell.oa.jrs.HZCW017FacadeREST.class);
        resources.add(cn.hanbell.oa.jrs.HZGL004FacadeREST.class);
        resources.add(cn.hanbell.oa.jrs.LeaveKindFacadeREST.class);
        resources.add(cn.hanbell.oa.jrs.LoanPropertyFacadeREST.class);
        resources.add(cn.hanbell.oa.jrs.OrganizationUnitFacadeREST.class);
        resources.add(cn.hanbell.oa.jrs.UsersFacadeREST.class);
        resources.add(cn.hanbell.oa.jrs.WorkTypeFacadeREST.class);
    }

}
