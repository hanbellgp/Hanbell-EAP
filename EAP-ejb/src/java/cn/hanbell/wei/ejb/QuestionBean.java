/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.wei.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.wei.entity.Question;
import cn.hanbell.wei.entity.QuestionDetail;
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
public class QuestionBean extends SuperEJBForEAP<Question> {

    @EJB
    private QuestionDetailBean questionDetailBean;

    private List<QuestionDetail> detailList;

    public QuestionBean() {
        super(Question.class);
    }

    @Override
    public JsonObjectBuilder createJsonObjectBuilder(Question entity) {
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
            job.add("hits", entity.getHits());
            if (entity.getImgfile() != null) {
                job.add("imgfile", entity.getImgfile());
            } else {
                job.addNull("imgfile");
            }
            if (entity.getCredate() != null) {
                job.add("credate", BaseLib.formatDate("yyyyMMdd", entity.getCredate()));
            } else {
                job.addNull("credate");
            }
            detailList = null;
            detailList = questionDetailBean.findByPId(entity.getId());
            if (detailList != null && !detailList.isEmpty()) {
                job.add("items", questionDetailBean.createJsonArrayBuilder(detailList));
            } else {
                job.addNull("items");
            }
        }
        return job;
    }

    public List<Question> findByCategoryId(Object id) {
        Query query = getEntityManager().createNamedQuery("Question.findByCategoryId");
        query.setParameter("categoryid", id);
        return query.getResultList();
    }

}
