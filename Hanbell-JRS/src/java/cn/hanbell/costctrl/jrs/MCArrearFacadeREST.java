/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.jrs;

import cn.hanbell.costctrl.app.MCArrear;
import cn.hanbell.costctrl.app.MCResponseData;
import cn.hanbell.costctrl.app.MessageEnum;
import cn.hanbell.costctrl.app.RequestBody;
import cn.hanbell.jrs.SuperRESTForCRM;
import cn.hanbell.oa.ejb.HZCW017Bean;
import cn.hanbell.oa.entity.HZCW017;
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
@Path("costctrl/arrear")
public class MCArrearFacadeREST extends SuperRESTForCRM<HZCW017> {

    @EJB
    private HZCW017Bean hzcw017Bean;

    public MCArrearFacadeREST() {
        super(HZCW017.class);
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
            List<HZCW017> dataList = hzcw017Bean.findByUserno(userId);
            List<MCArrear> resList = new ArrayList<>();
            if (null != dataList) {
                for (HZCW017 l : dataList) {
                    MCArrear mcarrear = new MCArrear(l.getProcessSerialNumber(), l.getSrcno(), BaseLib.formatDate("yyyy/MM/dd", l.getLoanDate()), l.getLoanTotal(), l.getArrears());
                    resList.add(mcarrear);
                }
            }
            MCResponseData res = new MCResponseData(MessageEnum.SUCCESS.getCode(), MessageEnum.SUCCESS.getMsg());
            res.setData(resList);
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
