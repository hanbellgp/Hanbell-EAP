/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "HK_GL076_detailQ3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL076DetailQ3.findAll", query = "SELECT h FROM HKGL076DetailQ3 h"),
    @NamedQuery(name = "HKGL076DetailQ3.findByAchievementRateQ3", query = "SELECT h FROM HKGL076DetailQ3 h WHERE h.achievementRateQ3 = :achievementRateQ3"),
    @NamedQuery(name = "HKGL076DetailQ3.findByBenchmarkYear3", query = "SELECT h FROM HKGL076DetailQ3 h WHERE h.benchmarkYear3 = :benchmarkYear3"),
    @NamedQuery(name = "HKGL076DetailQ3.findByContent3", query = "SELECT h FROM HKGL076DetailQ3 h WHERE h.content3 = :content3"),
    @NamedQuery(name = "HKGL076DetailQ3.findByActualValueQ3", query = "SELECT h FROM HKGL076DetailQ3 h WHERE h.actualValueQ3 = :actualValueQ3"),
    @NamedQuery(name = "HKGL076DetailQ3.findByBenchmarkQ3", query = "SELECT h FROM HKGL076DetailQ3 h WHERE h.benchmarkQ3 = :benchmarkQ3"),
    @NamedQuery(name = "HKGL076DetailQ3.findByExplanation3", query = "SELECT h FROM HKGL076DetailQ3 h WHERE h.explanation3 = :explanation3"),
    @NamedQuery(name = "HKGL076DetailQ3.findByScoreQ3", query = "SELECT h FROM HKGL076DetailQ3 h WHERE h.scoreQ3 = :scoreQ3"),
    @NamedQuery(name = "HKGL076DetailQ3.findByFSN", query = "SELECT h FROM HKGL076DetailQ3 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKGL076DetailQ3.findByProportion3", query = "SELECT h FROM HKGL076DetailQ3 h WHERE h.proportion3 = :proportion3"),
    @NamedQuery(name = "HKGL076DetailQ3.findByTargetQ3", query = "SELECT h FROM HKGL076DetailQ3 h WHERE h.targetQ3 = :targetQ3"),
    @NamedQuery(name = "HKGL076DetailQ3.findByOId", query = "SELECT h FROM HKGL076DetailQ3 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL076DetailQ3.findBySeq", query = "SELECT h FROM HKGL076DetailQ3 h WHERE h.seq = :seq"),
    @NamedQuery(name = "HKGL076DetailQ3.findByTargetYear3", query = "SELECT h FROM HKGL076DetailQ3 h WHERE h.targetYear3 = :targetYear3"),
    @NamedQuery(name = "HKGL076DetailQ3.findByChange3", query = "SELECT h FROM HKGL076DetailQ3 h WHERE h.change3 = :change3")})
public class HKGL076DetailQ3 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "achievementRateQ3")
    private String achievementRateQ3;
    @Size(max = 4000)
    @Column(name = "benchmarkYear3")
    private String benchmarkYear3;
    @Size(max = 255)
    @Column(name = "content3")
    private String content3;
    @Size(max = 4000)
    @Column(name = "actualValueQ3")
    private String actualValueQ3;
    @Size(max = 4000)
    @Column(name = "benchmarkQ3")
    private String benchmarkQ3;
    @Size(max = 4000)
    @Column(name = "explanation3")
    private String explanation3;
    @Size(max = 255)
    @Column(name = "scoreQ3")
    private String scoreQ3;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "proportion3")
    private String proportion3;
    @Size(max = 4000)
    @Column(name = "targetQ3")
    private String targetQ3;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 4000)
    @Column(name = "targetYear3")
    private String targetYear3;
    @Size(max = 255)
    @Column(name = "change3")
    private String change3;

    public HKGL076DetailQ3() {
    }

    public HKGL076DetailQ3(String oid) {
        this.oid = oid;
    }

    public String getAchievementRateQ3() {
        return achievementRateQ3;
    }

    public void setAchievementRateQ3(String achievementRateQ3) {
        this.achievementRateQ3 = achievementRateQ3;
    }

    public String getBenchmarkYear3() {
        return benchmarkYear3;
    }

    public void setBenchmarkYear3(String benchmarkYear3) {
        this.benchmarkYear3 = benchmarkYear3;
    }

    public String getContent3() {
        return content3;
    }

    public void setContent3(String content3) {
        this.content3 = content3;
    }

    public String getActualValueQ3() {
        return actualValueQ3;
    }

    public void setActualValueQ3(String actualValueQ3) {
        this.actualValueQ3 = actualValueQ3;
    }

    public String getBenchmarkQ3() {
        return benchmarkQ3;
    }

    public void setBenchmarkQ3(String benchmarkQ3) {
        this.benchmarkQ3 = benchmarkQ3;
    }

    public String getExplanation3() {
        return explanation3;
    }

    public void setExplanation3(String explanation3) {
        this.explanation3 = explanation3;
    }

    public String getScoreQ3() {
        return scoreQ3;
    }

    public void setScoreQ3(String scoreQ3) {
        this.scoreQ3 = scoreQ3;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getProportion3() {
        return proportion3;
    }

    public void setProportion3(String proportion3) {
        this.proportion3 = proportion3;
    }

    public String getTargetQ3() {
        return targetQ3;
    }

    public void setTargetQ3(String targetQ3) {
        this.targetQ3 = targetQ3;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getTargetYear3() {
        return targetYear3;
    }

    public void setTargetYear3(String targetYear3) {
        this.targetYear3 = targetYear3;
    }

    public String getChange3() {
        return change3;
    }

    public void setChange3(String change3) {
        this.change3 = change3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKGL076DetailQ3)) {
            return false;
        }
        HKGL076DetailQ3 other = (HKGL076DetailQ3) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL076DetailQ3[ oid=" + oid + " ]";
    }
    
}
