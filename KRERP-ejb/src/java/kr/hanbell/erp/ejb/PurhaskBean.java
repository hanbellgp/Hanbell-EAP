/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.hanbell.erp.ejb;


import kr.hanbell.erp.comm.SuperEJBForERP;
import kr.hanbell.erp.entity.Purhask;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class PurhaskBean extends SuperEJBForERP<Purhask> {

    @EJB
    private PursysBean pursysBean;
    @EJB
    private InvmasBean invmasBean;
    @EJB
    private PurvdrBean purvdrBean;
    @EJB
    private MiscodeBean miscodeBean;
    @EJB
    private PurdaskBean purdaskBean;
    @EJB
    private PurqnamBean purqnamBean;
    @EJB
    private PurdaskdscBean purdaskdscBean;

    public PurhaskBean() {
        super(Purhask.class);
    }

    public Purhask findBySrcno(String srcno) {
        Query query = getEntityManager().createNamedQuery("Purhask.findBySrcno");
        query.setParameter("srcno", srcno);
        try {
            return (Purhask) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
}
