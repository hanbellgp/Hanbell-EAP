/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.jrs;

import cn.hanbell.costctrl.app.MessageEnum;
import cn.hanbell.costctrl.app.MCResponseData;
import cn.hanbell.crm.jrs.model.JSONObject;
import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.PurcontractBean;
import cn.hanbell.erp.entity.Purcontract;
import cn.hanbell.jrs.SuperRESTForERP;
import cn.hanbell.oa.entity.HKCG007purDetail;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Administrator
 */
@Path("efgp/hkcg007")
public class PurcontractFacadeREST extends SuperRESTForERP<Purcontract> {

    @EJB
    private PurcontractBean purcontractBean;

    public PurcontractFacadeREST() {
        super(Purcontract.class);
    }

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        return purcontractBean;
    }

    @POST
    @Path("checkPurcontract/{facno}")
    @Consumes({"application/json"})
    @Produces({MediaType.APPLICATION_JSON})
    public MCResponseData checkPurcontract(HKCG007purDetail d, @PathParam("facno") String facno) {
        try {
            String contractno;
            BigDecimal unpris;
            BigDecimal disqy5, disqy4, disqy3, disqy2, disqy1;
            BigDecimal dispri5, dispri4, dispri3, dispri2, dispri1, dispri0;
            String prono = "1";
            String itnbr = d.getItnbr();
            String vdrno = d.getVdrno();
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            Date requestDate = format.parse(d.getRqtdateTxt());
            BigDecimal apmqty = BigDecimal.valueOf(Double.parseDouble(d.getPrqy1()));
            purcontractBean.setCompany(facno);

            Purcontract pc = purcontractBean.findByItnbrAndVdr(facno, prono, itnbr, vdrno, requestDate);
            if (null == pc) {
                return null;
            }
            contractno = pc.getPurcontractPK().getContractno();
            if (pc.getSelpricode().equals('1')) {
                unpris = pc.getUnpri();
            } else {
                disqy5 = pc.getDisqy5();
                dispri5 = pc.getDispri5();
                disqy4 = pc.getDisqy4();
                dispri4 = pc.getDispri4();
                disqy3 = pc.getDisqy3();
                dispri3 = pc.getDispri3();
                disqy2 = pc.getDisqy2();
                dispri2 = pc.getDispri2();
                disqy1 = pc.getDisqy1();
                dispri1 = pc.getDispri1();
                dispri0 = pc.getDispri0();
//                if (disqy5.compareTo(BigDecimal.ONE) > 0 && apmqty.compareTo(disqy5) >= 0) {
//                    unpris = dispri5;
//                }
                unpris = (disqy5.compareTo(BigDecimal.ZERO) > 0 && apmqty.compareTo(disqy5) >= 0) ? dispri5 : disqy4.compareTo(BigDecimal.ZERO) > 0 && apmqty.compareTo(disqy4) >= 0
                        ? dispri4 : disqy3.compareTo(BigDecimal.ZERO) > 0 && apmqty.compareTo(disqy3) >= 0 ? dispri3 : disqy2.compareTo(BigDecimal.ZERO) > 0 && apmqty.compareTo(disqy2) >= 0
                        ? dispri2 : disqy1.compareTo(BigDecimal.ZERO) > 0 && apmqty.compareTo(disqy1) >= 0 ? dispri1 : dispri0;

            }
            MCResponseData res = new MCResponseData(MessageEnum.SUCCESS.getCode(), MessageEnum.SUCCESS.getMsg());
            JSONObject js = new JSONObject();
            js.put("apno", contractno);
            js.put("unpris", unpris);
            res.setData(js);
            return res;
        } catch (Exception ex) {
            log4j.error(ex.toString());
            return new MCResponseData(MessageEnum.Failue_109.getCode(), MessageEnum.Failue_109.getMsg());
        }
    }

}
