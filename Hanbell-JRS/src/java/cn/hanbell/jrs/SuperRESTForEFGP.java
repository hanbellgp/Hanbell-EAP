/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.jrs;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author C0160
 * @param <T>
 */
public abstract class SuperRESTForEFGP<T> {

    protected final Logger log4j = LogManager.getLogger("cn.hanbell.eap");
    protected Class<T> entityClass;
    protected Map<Integer, List<T>> data;

    protected abstract SuperEJBForEFGP getSuperEJB();

    @EJB
    protected cn.hanbell.eap.ejb.SystemNameBean systemNameBean;

    @EJB
    protected cn.hanbell.oa.ejb.WorkFlowBean workFlowBean;

    public SuperRESTForEFGP(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseMessage create(T entity) {
        throw new WebApplicationException(Response.Status.NOT_IMPLEMENTED);
    }

    @POST
    @Path("approve/{oid}/{userid}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseMessage completeWorkItem(T entity, @PathParam("oid") PathSegment oid, @PathParam("userid") PathSegment userid, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        throw new WebApplicationException(Response.Status.NOT_IMPLEMENTED);
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseMessage remove(@PathParam("id") PathSegment id) {
        throw new WebApplicationException(Response.Status.NOT_IMPLEMENTED);
    }

    public Map<Integer, List<T>> find(PathSegment filters, PathSegment sorts, Integer offset, Integer pageSize) {
        try {
            MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
            MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
            Map<String, Object> filterFields = new HashMap<>();
            Map<String, String> sortFields = new HashMap<>();
            String key, value;
            if (filtersMM != null) {
                for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                    key = entrySet.getKey();
                    value = entrySet.getValue().get(0);
                    filterFields.put(key, value);
                }
            }
            if (sortsMM != null) {
                for (Map.Entry<String, List<String>> entrySet : sortsMM.entrySet()) {
                    key = entrySet.getKey();
                    value = entrySet.getValue().get(0);
                    sortFields.put(key, value);
                }
            }
            int size = getSuperEJB().getRowCount(filterFields);
            List<T> list = getSuperEJB().findByFilters(filterFields, offset, pageSize, sortFields);
            Map<Integer, List<T>> map = new HashMap<>();
            map.put(size, list);
            return map;
        } catch (Exception ex) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<T> findAll(@QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                int size = getSuperEJB().getRowCount();
                return getSuperEJB().findAll();
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public T findById(@PathParam("id") PathSegment id, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                return (T) getSuperEJB().findById(id.getPath());
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("{filters}/{sorts}/{offset}/{pageSize}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<T> findByFilters(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, String> sortFields = new HashMap<>();
                String key, value;
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        filterFields.put(key, value);
                    }
                }
                if (sortsMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : sortsMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        sortFields.put(key, value);
                    }
                }
                return getSuperEJB().findByFilters(filterFields, offset, pageSize, sortFields);
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("message/wecom")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage sendWeComMessage(@QueryParam("psn") String psn, @QueryParam("step") String step, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        throw new WebApplicationException(Response.Status.NOT_IMPLEMENTED);
    }

    protected boolean isAuthorized(String appid, String token) {
        return systemNameBean.isAuthorized(appid, token);
    }

    // 优化抛转时件号相关字符问题
    public String filterString(String s) {
        if (s != null && !s.trim().equals("")) {
            String returnStr = s;
            try {
                //String regEx = "[\\s`!！@#￥$%^……&（()）\\+【\\[\\]】｛{}｝\\|、\\\\；;：:‘'“”\"，,《<。.》>、/？?]";
                String regEx = "[\\s`&²³\\t\\r\\n ]";
                Pattern p = Pattern.compile(regEx);
                Matcher m = p.matcher(returnStr);
                returnStr = m.replaceAll(" ");
                //returnStr = removeNonAscii(returnStr);
            } catch (Exception ex) {
                log4j.error(ex);
            }
            return returnStr;
        }
        return s;
    }

    //去除非ascii码字符
    public String removeNonAscii(String str) {
        return str.replaceAll("[^\\x00-\\x7F]", "");
    }

}
