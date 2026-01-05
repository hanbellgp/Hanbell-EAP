/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.jrs;

import cn.hanbell.eam.ejb.AssetAdjustBean;
import cn.hanbell.eam.ejb.AssetDistributeBean;
import cn.hanbell.eam.ejb.AssetTransferBean;
import cn.hanbell.eam.entity.AssetAdjust;
import cn.hanbell.eam.entity.AssetDistribute;
import cn.hanbell.eam.entity.AssetTransfer;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.ejb.HKCW025Bean;
import cn.hanbell.oa.entity.HKCW025;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Administrator
 */
@Path("efgp/oaThrowEam")
@javax.enterprise.context.RequestScoped
public class HKCW025FacadeREST extends SuperRESTForEFGP<HKCW025> {

    @EJB
    private AssetAdjustBean assetAdjustBean;

    @EJB
    private AssetDistributeBean assetDistributeBean;

    @EJB
    private AssetTransferBean assetTransferBean;
    @EJB
    private HKCW025Bean hKCW025Bean;

    public HKCW025FacadeREST() {
        super(HKCW025.class);
    }

    //OA审核领用单时抛转EAM进行扣账及状态更新
    @POST
    @Path("oa025ThrowDebitEam")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String oa025ThrowEam(@QueryParam("psn") String psn) {
        Boolean ret = false;
        try {
            System.out.println("oa025ThrowEam抛转EAM审核" + psn);
            HKCW025 hkcw025 = hKCW025Bean.getOaPsn(psn);
            AssetDistribute assetDistribute = assetDistributeBean.findByOaformid(psn);
            if (assetDistribute == null) {
                throw new NullPointerException(psn + "不存在");
            }

            if (hkcw025.getIsERP().equals("Y")) {
                assetDistribute.setStatus("V");
            } else {
                assetDistribute.setStatus("T");
            }
            assetDistributeBean.verify(assetDistribute);
            ret = true;
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "oa025ThrowEam", psn), ex);
            throw new RuntimeException(ex);
        }
        if (ret) {
            System.out.println("oa025ThrowEam抛转EAM审核成功" + psn);
            return "200";
        } else {
            System.out.println("oa025ThrowEam抛转EAM审核失败" + psn);
            return "404";
        }
    }

    //OA审核调拨单时抛转EAM进行扣账及状态更新
    @POST
    @Path("oa026ThrowDebitEam")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String oa026ThrowEam(@QueryParam("psn") String psn) {
        Boolean ret = false;
        try {
            System.out.println("oa026ThrowEam抛转EAM审核" + psn);
            AssetAdjust assetAdjust = assetAdjustBean.findByOaformid(psn);
            if (assetAdjust == null) {
                throw new NullPointerException(psn + "不存在");
            }
            assetAdjust.setStatus("V");
            assetAdjustBean.verify(assetAdjust);
            ret = true;
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "oa026ThrowEam", psn), ex);
            throw new RuntimeException(ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }

    }

    //OA审核转移单时抛转EAM进行扣账及状态更新
    @POST
    @Path("oa027ThrowDebitEam")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String oa027ThrowEam(@QueryParam("psn") String psn) {
        Boolean ret = false;
        try {
            System.out.println("oa027ThrowEam抛转EAM审核" + psn);
            AssetTransfer assetTransfer = assetTransferBean.findByOaformid(psn);
            if (assetTransfer == null) {
                throw new NullPointerException(psn + "不存在");
            }
            assetTransfer.setStatus("V");
            assetTransferBean.verify(assetTransfer);
            ret = true;
        } catch (Exception ex) {
            log4j.error(String.format("执行%s:参数%s时异常", "oa027ThrowDebitEam", psn), ex);
            throw new RuntimeException(ex);
        }
        if (ret) {
            return "200";
        } else {
            return "404";
        }

    }

    //OA领用单撤销时抛转EAM状态还原可以在进行OA抛转
    @POST
    @Path("oa025RevocationThrowEam")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage oa025RevocationThrowEam(@QueryParam("psn") String psn) {
        System.out.println("OA抛转EAM撤销" + psn);
        AssetDistribute assetDistribute = assetDistributeBean.findByOaformid(psn);
        if (assetDistribute != null) {
            assetDistribute.setOaformid(psn + "OA已撤单");//将状态更新为撤单状态
            assetDistributeBean.update(assetDistribute);
        }
        return null;
    }

    //OA撤销调拨时抛转EAM状态还原可以在进行OA抛转
    @POST
    @Path("oa026RevocationThrowEam")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage oa026RevocationThrowEam(@QueryParam("psn") String psn) {
        System.out.println("OA抛转EAM撤销" + psn);
        AssetAdjust assetAdjust = assetAdjustBean.findByOaformid(psn);
        if (assetAdjust != null) {
            assetAdjust.setOaformid(psn + "OA已撤单");//将状态更新为撤单状态
            assetAdjustBean.update(assetAdjust);
        }
        return null;
    }

    //OA撤销转移时抛转EAM状态还原可以在进行OA抛转
    @POST
    @Path("oa027RevocationThrowEam")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage oa027RevocationThrowEam(@QueryParam("psn") String psn) {
        System.out.println("OA抛转EAM撤销" + psn);
        AssetTransfer assetTransfer = assetTransferBean.findByOaformid(psn);
        if (assetTransfer != null) {
            assetTransfer.setOaformid(psn + "OA已撤单");//将状态更新为撤单状态
            assetTransferBean.update(assetTransfer);
        }
        return null;
    }

    @Override
    protected SuperEJBForEFGP getSuperEJB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
