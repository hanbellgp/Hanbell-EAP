/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.wei.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.wei.entity.Gallery;
import cn.hanbell.wei.entity.GalleryDetail;
import com.lightshell.comm.BaseLib;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.persistence.Query;

/**
 *
 * @author kevindong
 */
@Stateless
public class GalleryBean extends SuperEJBForEAP<Gallery> {

    @EJB
    private GalleryDetailBean galleryDetailBean;

    private List<GalleryDetail> detailList;

    public GalleryBean() {
        super(Gallery.class);
    }

    @Override
    public JsonObjectBuilder createJsonObjectBuilder(Gallery entity) {
        JsonObjectBuilder job = Json.createObjectBuilder();
        if (entity != null) {
            job.add("id", entity.getId())
                    .add("categoryid", entity.getCategory().getId())
                    .add("category", entity.getCategory().getName())
                    .add("authorid", entity.getCreator())
                    .add("author", entity.getCreator())
                    .add("title", entity.getTitle());
            if (entity.getSubtitle() != null) {
                job.add("subtitle", entity.getSubtitle());
            } else {
                job.addNull("subtitle");
            }
            if (entity.getContent() != null) {
                job.add("content", entity.getContent());
            } else {
                job.addNull("content");
            }
            job.add("hits", entity.getHits())
                    .add("imgfile", entity.getImgfile());
            if (entity.getCredate() != null) {
                job.add("credate", BaseLib.formatDate("yyyyMMdd", entity.getCredate()));
            } else {
                job.addNull("credate");
            }
            detailList = null;
            detailList = galleryDetailBean.findByPId(entity.getId());
            if (detailList != null && !detailList.isEmpty()) {
                job.add("items", galleryDetailBean.createJsonArrayBuilder(detailList));
            } else {
                job.addNull("items");
            }
        }
        return job;
    }

    public List<Gallery> findByCategoryId(Object id) {
        Query query = getEntityManager().createNamedQuery("Gallery.findByCategoryId");
        query.setParameter("categoryid", id);
        return query.getResultList();
    }

}
