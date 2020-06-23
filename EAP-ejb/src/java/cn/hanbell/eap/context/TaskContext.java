/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.context;

import cn.hanbell.eap.entity.Task;

/**
 *
 * @author C0160
 * @param <T>
 */
public interface TaskContext<T> {

    Task updateTask(T context) throws Exception;

    void updateContext(Task task) throws Exception;

}
