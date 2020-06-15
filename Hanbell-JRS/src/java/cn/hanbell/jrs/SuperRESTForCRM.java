/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.jrs;

/**
 *
 * @author Administrator
 * @param <T>
 */
public abstract class SuperRESTForCRM<T> extends SuperREST<T> {

    public SuperRESTForCRM(Class<T> entityClass) {
        super(entityClass);
    }

}
