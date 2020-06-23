/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.comm;

import cn.hanbell.eap.context.DemandTaskContext;
import cn.hanbell.eap.context.TaskContext;

/**
 *
 * @author C0160
 */
public class TaskContextFactory {

    public static TaskContext createTaskContext(String context) {
        switch (context.toUpperCase()) {
            case "P":
            case "PROJECT":
                return null;
            case "D":
            case "DEMAND":
                return new DemandTaskContext();
            case "T":
            case "TASK":
                return null;
            default:
                return null;
        }
    }

}
