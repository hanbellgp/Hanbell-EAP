/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.wei.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.wei.entity.News;
import cn.hanbell.wei.entity.NewsDetail;
import com.lightshell.comm.BaseLib;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author kevindong
 */
@Stateless
public class NewsBean extends SuperEJBForEAP<News> {

    @EJB
    private NewsDetailBean newsDetailBean;

    private List<NewsDetail> detailList;

    public NewsBean() {
        super(News.class);
    }

    @Override
    public JsonObjectBuilder createJsonObjectBuilder(News entity) {
        JsonObjectBuilder job = Json.createObjectBuilder();
        if (entity != null) {
            job.add("id", entity.getId())
                    .add("title", entity.getTitle())
                    .add("content", entity.getContent())
                    .add("hits", entity.getHits());
            if (entity.getSubtitle() != null) {
                job.add("subtitle", entity.getSubtitle());
            } else {
                job.addNull("subtitle");
            }
            if (entity.getSubtitle() != null) {
                job.add("imgfile", entity.getImgfile());
            } else {
                job.addNull("imgfile");
            }
            if (entity.getCreator() != null) {
                job.add("creator", entity.getCreator());
            } else {
                job.addNull("creator");
            }
            if (entity.getCredate() != null) {
                job.add("credate", BaseLib.formatDate("yyyyMMdd", entity.getCredate()));
            } else {
                job.addNull("credate");
            }
            detailList = null;
            detailList = newsDetailBean.findByPId(entity.getId());
            if (detailList != null && !detailList.isEmpty()) {
                job.add("items", newsDetailBean.createJsonArrayBuilder(detailList));
            } else {
                job.addNull("items");
            }
        }
        return job;
    }
}
