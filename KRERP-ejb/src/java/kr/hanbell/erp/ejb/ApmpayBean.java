/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.hanbell.erp.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import kr.hanbell.erp.comm.SuperEJBForERP;
import kr.hanbell.erp.entity.Apmpay;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class ApmpayBean extends SuperEJBForERP<Apmpay> {

    @EJB
    private ApmsysBean apmsysBean;
    @EJB
    private AccrnoBean accrnoBean;
    @EJB
    private AccacrBean accacrBean;
    @EJB
    private ApmpadBean apmpadBean;
    @EJB
    private BudgetDetailBean budgetDetailBean;
    @EJB
    private AccspedBean accspedBean;

    public ApmpayBean() {
        super(Apmpay.class);
    }

}
