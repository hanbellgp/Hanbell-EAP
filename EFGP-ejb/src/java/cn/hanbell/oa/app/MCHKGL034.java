/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.app;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@XmlRootElement
public class MCHKGL034 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private MCHKGL034Head head;
    private List<MCHKGL034Detail> body;

    public MCHKGL034() {

    }

    /**
     * @return the head
     */
    public MCHKGL034Head getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(MCHKGL034Head head) {
        this.head = head;
    }

    /**
     * @return the body
     */
    public List<MCHKGL034Detail> getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(List<MCHKGL034Detail> body) {
        this.body = body;
    }

}
