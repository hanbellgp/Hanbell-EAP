/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.lazy;

import cn.hanbell.eap.entity.Proposal;
import com.lightshell.comm.BaseLazyModel;
import com.lightshell.comm.SuperEJB;

/**
 *
 * @author Administrator
 */
public class ProposalModel extends BaseLazyModel<Proposal> {

    public ProposalModel(SuperEJB superEJB) {
        this.superEJB = superEJB;
    }

}
