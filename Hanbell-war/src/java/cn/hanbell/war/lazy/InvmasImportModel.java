/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.lazy;

import cn.hanbell.eap.entity.InvmasImport;
import com.lightshell.comm.BaseLazyModel;
import com.lightshell.comm.SuperEJB;

/**
 *
 * @author C0160
 */
public class InvmasImportModel extends BaseLazyModel<InvmasImport> {

    public InvmasImportModel(SuperEJB superEJB) {
        this.superEJB = superEJB;
    }

}
