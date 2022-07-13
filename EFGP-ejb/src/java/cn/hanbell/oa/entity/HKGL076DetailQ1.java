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
@Table(name = "HK_GL076_detailQ1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL076DetailQ1.findAll", query = "SELECT h FROM HKGL076DetailQ1 h"),
    @NamedQuery(name = "HKGL076DetailQ1.findByTargetYear1", query = "SELECT h FROM HKGL076DetailQ1 h WHERE h.targetYear1 = :targetYear1"),
    @NamedQuery(name = "HKGL076DetailQ1.findByBenchmarkQ1", query = "SELECT h FROM HKGL076DetailQ1 h WHERE h.benchmarkQ1 = :benchmarkQ1"),
    @NamedQuery(name = "HKGL076DetailQ1.findByBenchmarkYear1", query = "SELECT h FROM HKGL076DetailQ1 h WHERE h.benchmarkYear1 = :benchmarkYear1"),
    @NamedQuery(name = "HKGL076DetailQ1.findByOId", query = "SELECT h FROM HKGL076DetailQ1 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL076DetailQ1.findByAchievementRateQ1", query = "SELECT h FROM HKGL076DetailQ1 h WHERE h.achievementRateQ1 = :achievementRateQ1"),
    @NamedQuery(name = "HKGL076DetailQ1.findByProportion1", query = "SELECT h FROM HKGL076DetailQ1 h WHERE h.proportion1 = :proportion1"),
    @NamedQuery(name = "HKGL076DetailQ1.findByContent1", query = "SELECT h FROM HKGL076DetailQ1 h WHERE h.content1 = :content1"),
    @NamedQuery(name = "HKGL076DetailQ1.findByTargetQ1", query = "SELECT h FROM HKGL076DetailQ1 h WHERE h.targetQ1 = :targetQ1"),
    @NamedQuery(name = "HKGL076DetailQ1.findByFSN", query = "SELECT h FROM HKGL076DetailQ1 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKGL076DetailQ1.findByExplanation1", query = "SELECT h FROM HKGL076DetailQ1 h WHERE h.explanation1 = :explanation1"),
    @NamedQuery(name = "HKGL076DetailQ1.findByActualValueQ1", query = "SELECT h FROM HKGL076DetailQ1 h WHERE h.actualValueQ1 = :actualValueQ1"),
    @NamedQuery(name = "HKGL076DetailQ1.findBySeq", query = "SELECT h FROM HKGL076DetailQ1 h WHERE h.seq = :seq"),
    @NamedQuery(name = "HKGL076DetailQ1.findByScoreQ1", query = "SELECT h FROM HKGL076DetailQ1 h WHERE h.scoreQ1 = :scoreQ1"),
    @NamedQuery(name = "HKGL076DetailQ1.findByChange1", query = "SELECT h FROM HKGL076DetailQ1 h WHERE h.change1 = :change1")})
public class HKGL076DetailQ1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 4000)
    @Column(name = "targetYear1")
    private String targetYear1;
    @Size(max = 4000)
    @Column(name = "benchmarkQ1")
    private String benchmarkQ1;
    @Size(max = 4000)
    @Column(name = "benchmarkYear1")
    private String benchmarkYear1;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "achievementRateQ1")
    private String achievementRateQ1;
    @Size(max = 255)
    @Column(name = "proportion1")
    private String proportion1;
    @Size(max = 255)
    @Column(name = "content1")
    private String content1;
    @Size(max = 4000)
    @Column(name = "targetQ1")
    private String targetQ1;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 4000)
    @Column(name = "explanation1")
    private String explanation1;
    @Size(max = 4000)
    @Column(name = "actualValueQ1")
    private String actualValueQ1;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "scoreQ1")
    private String scoreQ1;
    @Size(max = 255)
    @Column(name = "change1")
    private String change1;

    public HKGL076DetailQ1() {
    }

    public HKGL076DetailQ1(String oid) {
        this.oid = oid;
    }

    public String getTargetYear1() {
        return targetYear1;
    }

    public void setTargetYear1(String targetYear1) {
        this.targetYear1 = targetYear1;
    }

    public String getBenchmarkQ1() {
        return benchmarkQ1;
    }

    public void setBenchmarkQ1(String benchmarkQ1) {
        this.benchmarkQ1 = benchmarkQ1;
    }

    public String getBenchmarkYear1() {
        return benchmarkYear1;
    }

    public void setBenchmarkYear1(String benchmarkYear1) {
        this.benchmarkYear1 = benchmarkYear1;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getAchievementRateQ1() {
        return achievementRateQ1;
    }

    public void setAchievementRateQ1(String achievementRateQ1) {
        this.achievementRateQ1 = achievementRateQ1;
    }

    public String getProportion1() {
        return proportion1;
    }

    public void setProportion1(String proportion1) {
        this.proportion1 = proportion1;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getTargetQ1() {
        return targetQ1;
    }

    public void setTargetQ1(String targetQ1) {
        this.targetQ1 = targetQ1;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getExplanation1() {
        return explanation1;
    }

    public void setExplanation1(String explanation1) {
        this.explanation1 = explanation1;
    }

    public String getActualValueQ1() {
        return actualValueQ1;
    }

    public void setActualValueQ1(String actualValueQ1) {
        this.actualValueQ1 = actualValueQ1;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getScoreQ1() {
        return scoreQ1;
    }

    public void setScoreQ1(String scoreQ1) {
        this.scoreQ1 = scoreQ1;
    }

    public String getChange1() {
        return change1;
    }

    public void setChange1(String change1) {
        this.change1 = change1;
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
        if (!(object instanceof HKGL076DetailQ1)) {
            return false;
        }
        HKGL076DetailQ1 other = (HKGL076DetailQ1) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL076DetailQ1[ oid=" + oid + " ]";
    }
    
}
