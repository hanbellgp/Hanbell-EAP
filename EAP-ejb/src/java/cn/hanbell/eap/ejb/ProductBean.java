/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class ProductBean extends SuperEJBForEAP<Product> {

    public ProductBean() {
        super(Product.class);
    }

    public Product findByUID(String uid) {
        Query query = getEntityManager().createNamedQuery("Product.findByUID");
        query.setParameter("uid", uid);
        try {
            Object o = query.getSingleResult();
            return (Product) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Product> findByItemModel(String model) {
        Query query = getEntityManager().createNamedQuery("Product.findByItemModel");
        query.setParameter("itemModel", model);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

}
