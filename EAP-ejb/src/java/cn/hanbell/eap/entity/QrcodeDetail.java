/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.FormDetailEntity;
import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@Entity
@Table(name = "qrcodedetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QrcodeDetail.findAll", query = "SELECT q FROM QrcodeDetail q"),
    @NamedQuery(name = "QrcodeDetail.findById", query = "SELECT q FROM QrcodeDetail q WHERE q.id = :id"),
    @NamedQuery(name = "QrcodeDetail.findByPId", query = "SELECT q FROM QrcodeDetail q WHERE q.pid = :pid order by q.seq asc"),
    @NamedQuery(name = "QrcodeDetail.findBySeq", query = "SELECT q FROM QrcodeDetail q WHERE q.seq = :seq"),
    @NamedQuery(name = "QrcodeDetail.findByContent1", query = "SELECT q FROM QrcodeDetail q WHERE q.content1 = :content1"),
    @NamedQuery(name = "QrcodeDetail.findByContent2", query = "SELECT q FROM QrcodeDetail q WHERE q.content2 = :content2"),
    @NamedQuery(name = "QrcodeDetail.findByContent3", query = "SELECT q FROM QrcodeDetail q WHERE q.content3 = :content3"),
    @NamedQuery(name = "QrcodeDetail.findByContent4", query = "SELECT q FROM QrcodeDetail q WHERE q.content4 = :content4"),
    @NamedQuery(name = "QrcodeDetail.findByContent5", query = "SELECT q FROM QrcodeDetail q WHERE q.content5 = :content5"),
    @NamedQuery(name = "QrcodeDetail.findByContent6", query = "SELECT q FROM QrcodeDetail q WHERE q.content6 = :content6"),
    @NamedQuery(name = "QrcodeDetail.findByContent7", query = "SELECT q FROM QrcodeDetail q WHERE q.content7 = :content7"),
    @NamedQuery(name = "QrcodeDetail.findByContent8", query = "SELECT q FROM QrcodeDetail q WHERE q.content8 = :content8"),
    @NamedQuery(name = "QrcodeDetail.findByContent9", query = "SELECT q FROM QrcodeDetail q WHERE q.content9 = :content9"),
    @NamedQuery(name = "QrcodeDetail.findByContent10", query = "SELECT q FROM QrcodeDetail q WHERE q.content10 = :content10"),
    @NamedQuery(name = "QrcodeDetail.findByContent11", query = "SELECT q FROM QrcodeDetail q WHERE q.content11 = :content11"),
    @NamedQuery(name = "QrcodeDetail.findByContent12", query = "SELECT q FROM QrcodeDetail q WHERE q.content12 = :content12")})
public class QrcodeDetail extends FormDetailEntity {

    private static final long serialVersionUID = 1L;

    
    
    @Basic(optional = false)
    @Size(min = 1, max = 200)
    @Column(name = "content1")
    private String content1;
    @Basic(optional = false)
    @Size(min = 1, max = 200)
    @Column(name = "content2")
    private String content2;
    @Basic(optional = false)
    @Size(min = 1, max = 200)
    @Column(name = "content3")
    private String content3;
    @Basic(optional = false)
    @Size(min = 1, max = 200)
    @Column(name = "content4")
    private String content4;
    @Basic(optional = false)
    @Size(min = 1, max = 200)
    @Column(name = "content5")
    private String content5;
    @Basic(optional = false)
    @Size(min = 1, max = 200)
    @Column(name = "content6")
    private String content6;
    @Basic(optional = false)
    @Size(min = 1, max = 200)
    @Column(name = "content7")
    private String content7;
    @Basic(optional = false)
    @Size(min = 1, max = 200)
    @Column(name = "content8")
    private String content8;
    @Basic(optional = false)
    @Size(min = 1, max = 200)
    @Column(name = "content9")
    private String content9;
    @Basic(optional = false)
    @Size(min = 1, max = 200)
    @Column(name = "content10")
    private String content10;
    @Basic(optional = false)
    @Size(min = 1, max = 200)
    @Column(name = "content11")
    private String content11;
    @Basic(optional = false)
    @Size(min = 1, max = 200)
    @Column(name = "content12")
    private String content12;
    
    @JoinColumn(name = "pid", referencedColumnName = "formid", insertable = false, updatable = false)
    @ManyToOne
    private Qrcode qrcode;


    public QrcodeDetail() {
    }

    public QrcodeDetail(Integer id) {
        this.id = id;
    }

    public QrcodeDetail(Integer id, String pid, int seq, String content1, String content2, String content3, String content4, String content5, String content6, String content7, String content8, String content9, String content10, String content11, String content12) {
        this.id = id;
        this.pid = pid;
        this.seq = seq;
        this.content1 = content1;
        this.content2 = content2;
        this.content3 = content3;
        this.content4 = content4;
        this.content5 = content5;
        this.content6 = content6;
        this.content7 = content7;
        this.content8 = content8;
        this.content9 = content9;
        this.content10 = content10;
        this.content11 = content11;
        this.content12 = content12;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getContent3() {
        return content3;
    }

    public void setContent3(String content3) {
        this.content3 = content3;
    }

    public String getContent4() {
        return content4;
    }

    public void setContent4(String content4) {
        this.content4 = content4;
    }

    public String getContent5() {
        return content5;
    }

    public void setContent5(String content5) {
        this.content5 = content5;
    }

    public String getContent6() {
        return content6;
    }

    public void setContent6(String content6) {
        this.content6 = content6;
    }

    public String getContent7() {
        return content7;
    }

    public void setContent7(String content7) {
        this.content7 = content7;
    }

    public String getContent8() {
        return content8;
    }

    public void setContent8(String content8) {
        this.content8 = content8;
    }

    public String getContent9() {
        return content9;
    }

    public void setContent9(String content9) {
        this.content9 = content9;
    }

    public String getContent10() {
        return content10;
    }

    public void setContent10(String content10) {
        this.content10 = content10;
    }

    public String getContent11() {
        return content11;
    }

    public void setContent11(String content11) {
        this.content11 = content11;
    }

    public String getContent12() {
        return content12;
    }

    public void setContent12(String content12) {
        this.content12 = content12;
    }

    public Qrcode getQrcode() {
        return qrcode;
    }

    public void setQrcode(Qrcode qrcode) {
        this.qrcode = qrcode;
    }

    
    public void setContent(int index, String content) {
        switch (index) {
            case 1:
                setContent1(content);
                break;
            case 2:
                setContent2(content);
                break;
            case 3:
                setContent3(content);
                break;
            case 4:
                setContent4(content);
                break;
            case 5:
                setContent5(content);
                break;
            case 6:
                setContent6(content);
                break;
            case 7:
                setContent7(content);
                break;
            case 8:
                setContent8(content);
                break;
            case 9:
                setContent9(content);
                break;
            case 10:
                setContent10(content);
                break;
            case 11:
                setContent11(content);
                break;
            case 12:
                setContent12(content);
                break;
        }

    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QrcodeDetail)) {
            return false;
        }
        QrcodeDetail other = (QrcodeDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.QrcodeDetail[ id=" + id + " ]";
    }

}
