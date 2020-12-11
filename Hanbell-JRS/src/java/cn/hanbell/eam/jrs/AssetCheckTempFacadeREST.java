/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eam.jrs;

import javax.ejb.Stateless;
import javax.ws.rs.Path;
import cn.hanbell.eam.ejb.AssetCheckBean;
import cn.hanbell.eam.ejb.AssetCheckTempBean;
import cn.hanbell.eam.entity.AssetCheck;
import cn.hanbell.eam.entity.AssetCheckTemp;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEAM;
import com.lightshell.comm.SuperEJB;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

/**
 *
 * @author C2090
 */
@Stateless
@Path("shbeam/assetcheck")
public class AssetCheckTempFacadeREST extends SuperRESTForEAM<AssetCheckTemp> {
    @EJB
    private AssetCheckTempBean assetCheckTempBean;
    @EJB
    private AssetCheckBean assetCheckBean;
    
    protected SuperEJB superEJB;
    
    @Override
    protected SuperEJB getSuperEJB() {
        return assetCheckTempBean;
    }
    

    public AssetCheckTempFacadeREST() {
        super(AssetCheckTemp.class);
    }
    
    
    @POST
    @Path("startassetcheck")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage startAssetCheck(AssetCheckTemp entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            try {
                AssetCheckTemp assetCheckTemp = new AssetCheckTemp();
                List<AssetCheck> assetCheckList = new ArrayList<AssetCheck>();
                Map<String, Object> filterFields_assetCheckTemp = new HashMap<>();
                List<AssetCheckTemp> assetCheckTempList = new ArrayList<AssetCheckTemp>();
                //AssetCheck assetCheckObj = new AssetCheck();
                if(entity.getFormid() != null){
                    assetCheckList = assetCheckBean.findByFormid(entity.getFormid());
                    if(assetCheckList.size() < 1){
                        return new ResponseMessage("208", "无盘点单信息");
                    }
                }
                assetCheckTemp.setFormid(entity.getFormid());
                assetCheckTemp.setAssetno(entity.getAssetno());
                assetCheckTemp.setItimes(entity.getItimes());
                filterFields_assetCheckTemp.put("formid", entity.getFormid());
                filterFields_assetCheckTemp.put("assetno", entity.getAssetno());
                filterFields_assetCheckTemp.put("itimes", entity.getItimes());
                
                assetCheckTempList = assetCheckTempBean.findByFilters(filterFields_assetCheckTemp);
                if(assetCheckTempList.size() == 1)
                {
                    assetCheckTemp = assetCheckTempList.get(0);
                }
                else if(assetCheckTempList.size() > 1)
                {
                    return new ResponseMessage("209", "资产盘点数据异常");
                }

                assetCheckTemp.setCompany(entity.getCompany());
                assetCheckTemp.setFormid(entity.getFormid());
                assetCheckTemp.setAssetno(entity.getAssetno());
                assetCheckTemp.setItemno(entity.getItemno());
                assetCheckTemp.setAssetDesc(entity.getAssetDesc());
                assetCheckTemp.setAssetSpec(entity.getAssetSpec());
                assetCheckTemp.setQty(entity.getQty());
                assetCheckTemp.setIqty(entity.getQty());
                assetCheckTemp.setUserno(entity.getUserno());
                assetCheckTemp.setUsername(entity.getUsername());
                assetCheckTemp.setDeptno(entity.getDeptno());
                assetCheckTemp.setDeptname(entity.getDeptname());
                assetCheckTemp.setAddress(entity.getAddress());
                assetCheckTemp.setIaddress(entity.getIaddress());
                assetCheckTemp.setRemark(entity.getRemark());
                assetCheckTemp.setStatus("V");
                assetCheckTemp.setCreator(entity.getCreator());
                assetCheckTemp.setCredate(new Date());

                assetCheckTempBean.persist(assetCheckTemp);
                return new ResponseMessage("200", "Code=200");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Insert失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}


class AssetCheckTempResponseResult {

    private Integer size;
    private List<AssetCheckTemp> result;

    public AssetCheckTempResponseResult() {

    }

    /**
     * @return the size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * @return the result
     */
    public List<AssetCheckTemp> getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(List<AssetCheckTemp> result) {
        this.result = result;
    }

}