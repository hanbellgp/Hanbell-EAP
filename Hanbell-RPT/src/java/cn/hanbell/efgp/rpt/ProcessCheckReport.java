/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.ProcessCheckBean;
import cn.hanbell.oa.entity.ProcessCheck;
import cn.hanbell.util.SuperSingleReportBean;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author C1491
 */
public class ProcessCheckReport extends SuperSingleReportBean<ProcessCheckBean, ProcessCheck> {

    public ProcessCheckReport() {

    }

    @Override
    public void setEJB(String JNDIName) throws NamingException {
        super.setEJB(JNDIName); 
    }
    

   
    public List<ProcessCheck> getDetail(String serialNumber) throws Exception {
        return this.superEJB.findByPSN(serialNumber);
    }


    @Override
    public ProcessCheck getEntity(Object o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
