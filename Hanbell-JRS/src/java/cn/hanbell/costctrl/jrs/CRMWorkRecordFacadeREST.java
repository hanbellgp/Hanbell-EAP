/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.jrs;

import cn.hanbell.costctrl.app.CRMWorkRecord;
import cn.hanbell.costctrl.app.MCResponseData;
import cn.hanbell.costctrl.app.MessageEnum;
import cn.hanbell.costctrl.app.RequestBody;
import cn.hanbell.crm.ejb.REPTCBean;
import cn.hanbell.jrs.SuperRESTForCRM;
import cn.hanbell.util.BaseLib;
import cn.hanbell.util.SuperEJB;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Administrator
 */
@Path("costctrl/crm")
public class CRMWorkRecordFacadeREST extends SuperRESTForCRM<CRMWorkRecord> {
    
    @EJB
    private REPTCBean reptcBean;
    
    public CRMWorkRecordFacadeREST() {
        super(CRMWorkRecord.class);
    }
    
    @POST
    @Path("get")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public MCResponseData findAll(RequestBody entity) {
        try {
            //判断token 是否有效
            if (entity == null) {
                return new MCResponseData(MessageEnum.Failue_107.getCode(), MessageEnum.Failue_107.getMsg());
            }
            if (!entity.checkSign()) {
                return new MCResponseData(MessageEnum.Failue_102.getCode(), MessageEnum.Failue_102.getMsg());
            }
            
            String userId = entity.getUserId();
            if (null == userId || "".equals(userId)) {
                return new MCResponseData(MessageEnum.Failue_105.getCode(), MessageEnum.Failue_105.getMsg());
            }
            List<CRMWorkRecord> dataList = new ArrayList<>();
            List<Object> arr = reptcBean.getCRMWorkRecordList(userId);
            if (null != arr && !arr.isEmpty()) {
                CRMWorkRecord newEntity;
                for (int i = 0; i < arr.size(); i++) {
                    Object[] row = (Object[]) arr.get(i);
                    Date date;
                    if (null != row[2] && row[2].toString().length() >= 8) {
                        String date1 = row[2].toString();
                        date = BaseLib.getDate("yyyyMMdd", date1);
                    } else {
                        throw new ParseException("日期格式", i);
                    }
                    newEntity = new CRMWorkRecord(row[0].toString(), row[1].toString(), BaseLib.formatDate("YYYY/MM/dd", date), row[3] == null ? "" : row[3].toString(), row[4] == null ? "" : row[4].toString());
                    dataList.add(newEntity);
                }
            }
            MCResponseData res = new MCResponseData(MessageEnum.SUCCESS.getCode(), MessageEnum.SUCCESS.getMsg());
            res.setData(dataList);
            return res;
        } catch (Exception ex) {
            ex.printStackTrace();
            log4j.error(ex.toString());
            return new MCResponseData(MessageEnum.Failue_109.getCode(), MessageEnum.Failue_109.getMsg());
        }
        
    }
    
    @Override
    protected SuperEJB getSuperEJB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
