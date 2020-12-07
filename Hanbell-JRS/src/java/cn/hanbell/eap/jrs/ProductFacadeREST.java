/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.ProductBean;
import cn.hanbell.eap.entity.Product;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.ResponseObject;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.SuperEJB;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

/**
 *
 * @author C0160
 */
@Path("eap/product")
public class ProductFacadeREST extends SuperRESTForEAP<Product> {

    @EJB
    private ProductBean productBean;

    public ProductFacadeREST() {
        super(Product.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return productBean;
    }

    @Override
    public ResponseMessage create(Product entity, String appid, String token) {
        if (isAuthorized(appid, token)) {
            try {
                entity.setCredateToNow();
                entity.setUID(productBean.getUUID());
                productBean.persist(entity);
                return new ResponseMessage("200", "更新成功");
            } catch (Exception ex) {
                log4j.error(ex);
                return new ResponseMessage("500", "系统错误更新失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseMessage edit(PathSegment id, Product entity, String appid, String token) {
        if (isAuthorized(appid, token)) {
            try {
                Product t = productBean.findById(Integer.parseInt(id.getPath()));
                if (t == null) {
                    return new ResponseMessage("404", "找不到对象");
                }
                if (!Objects.equals(t.getOptdate(), entity.getOptdate())) {
                    return new ResponseMessage("409", "修改冲突");
                }
                entity.setOptdateToNow();
                productBean.update(entity);
                return new ResponseMessage("200", "更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误更新失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseObject findById(PathSegment id, String appid, String token) {
        if (isAuthorized(appid, token)) {
            try {
                Product t = productBean.findByUID(id.getPath());
                ResponseObject res = new ResponseObject<>("200", "success", t);
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
