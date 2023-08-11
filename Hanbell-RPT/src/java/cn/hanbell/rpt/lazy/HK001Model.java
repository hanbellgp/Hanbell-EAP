/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.lazy;

import cn.hanbell.oa.entity.HK001;
import cn.hanbell.rpt.web.SuperLazyModel;
import com.lightshell.comm.SuperEJB;

/**
 *
 * @author C2082
 */
public class HK001Model extends SuperLazyModel<HK001> {

    public HK001Model(SuperEJB superEJB) {
        this.superEJB = superEJB;
    }
}
