/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.mes.comm;

import com.lightshell.comm.SuperEJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 * @param <T>
 */
public abstract class SuperEJBForMES<T> extends SuperEJB<T> {

    @PersistenceContext(unitName = "SHBMES-ejbPU")
    private EntityManager em_shp;

    @PersistenceContext(unitName = "COMERMES-ejbPU")
    private EntityManager em_comer;

    protected String company = "C";

    public SuperEJBForMES(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    public EntityManager getEntityManager() {
        return getEntityManager(getCompany());
    }

    protected EntityManager getEntityManager(String facno) {
        switch (facno) {
            case "C":
                return em_shp;

            case "K":
                return em_comer;

            default:
                return em_shp;
        }
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }
}
