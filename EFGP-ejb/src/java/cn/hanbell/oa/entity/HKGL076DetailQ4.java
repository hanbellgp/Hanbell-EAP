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
@Table(name = "HK_GL076_detailQ4")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL076DetailQ4.findAll", query = "SELECT h FROM HKGL076DetailQ4 h"),
    @NamedQuery(name = "HKGL076DetailQ4.findByTargetYear4", query = "SELECT h FROM HKGL076DetailQ4 h WHERE h.targetYear4 = :targetYear4"),
    @NamedQuery(name = "HKGL076DetailQ4.findByBenchmarkYear4", query = "SELECT h FROM HKGL076DetailQ4 h WHERE h.benchmarkYear4 = :benchmarkYear4"),
    @NamedQuery(name = "HKGL076DetailQ4.findByAchievementRateYear", query = "SELECT h FROM HKGL076DetailQ4 h WHERE h.achievementRateYear = :achievementRateYear"),
    @NamedQuery(name = "HKGL076DetailQ4.findByScoreYear", query = "SELECT h FROM HKGL076DetailQ4 h WHERE h.scoreYear = :scoreYear"),
    @NamedQuery(name = "HKGL076DetailQ4.findByActualValueYear", query = "SELECT h FROM HKGL076DetailQ4 h WHERE h.actualValueYear = :actualValueYear"),
    @NamedQuery(name = "HKGL076DetailQ4.findByOId", query = "SELECT h FROM HKGL076DetailQ4 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL076DetailQ4.findByAchievementRateQ4", query = "SELECT h FROM HKGL076DetailQ4 h WHERE h.achievementRateQ4 = :achievementRateQ4"),
    @NamedQuery(name = "HKGL076DetailQ4.findByContent4", query = "SELECT h FROM HKGL076DetailQ4 h WHERE h.content4 = :content4"),
    @NamedQuery(name = "HKGL076DetailQ4.findByBenchmarkQ4", query = "SELECT h FROM HKGL076DetailQ4 h WHERE h.benchmarkQ4 = :benchmarkQ4"),
    @NamedQuery(name = "HKGL076DetailQ4.findByExplanation4", query = "SELECT h FROM HKGL076DetailQ4 h WHERE h.explanation4 = :explanation4"),
    @NamedQuery(name = "HKGL076DetailQ4.findByProportion4", query = "SELECT h FROM HKGL076DetailQ4 h WHERE h.proportion4 = :proportion4"),
    @NamedQuery(name = "HKGL076DetailQ4.findByScoreQ4", query = "SELECT h FROM HKGL076DetailQ4 h WHERE h.scoreQ4 = :scoreQ4"),
    @NamedQuery(name = "HKGL076DetailQ4.findByFSN", query = "SELECT h FROM HKGL076DetailQ4 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKGL076DetailQ4.findByActualValueQ4", query = "SELECT h FROM HKGL076DetailQ4 h WHERE h.actualValueQ4 = :actualValueQ4"),
    @NamedQuery(name = "HKGL076DetailQ4.findByTargetQ4", query = "SELECT h FROM HKGL076DetailQ4 h WHERE h.targetQ4 = :targetQ4"),
    @NamedQuery(name = "HKGL076DetailQ4.findBySeq", query = "SELECT h FROM HKGL076DetailQ4 h WHERE h.seq = :seq"),
    @NamedQuery(name = "HKGL076DetailQ4.findByChange4", query = "SELECT h FROM HKGL076DetailQ4 h WHERE h.change4 = :change4")})
public class HKGL076DetailQ4 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 4000)
    @Column(name = "targetYear4")
    private String targetYear4;
    @Size(max = 4000)
    @Column(name = "benchmarkYear4")
    private String benchmarkYear4;
    @Size(max = 255)
    @Column(name = "achievementRateYear")
    private String achievementRateYear;
    @Size(max = 255)
    @Column(name = "scoreYear")
    private String scoreYear;
    @Size(max = 4000)
    @Column(name = "actualValueYear")
    private String actualValueYear;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "achievementRateQ4")
    private String achievementRateQ4;
    @Size(max = 255)
    @Column(name = "content4")
    private String content4;
    @Size(max = 4000)
    @Column(name = "benchmarkQ4")
    private String benchmarkQ4;
    @Size(max = 4000)
    @Column(name = "explanation4")
    private String explanation4;
    @Size(max = 255)
    @Column(name = "proportion4")
    private String proportion4;
    @Size(max = 255)
    @Column(name = "scoreQ4")
    private String scoreQ4;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 4000)
    @Column(name = "actualValueQ4")
    private String actualValueQ4;
    @Size(max = 4000)
    @Column(name = "targetQ4")
    private String targetQ4;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "change4")
    private String change4;

    public HKGL076DetailQ4() {
    }

    public HKGL076DetailQ4(String oid) {
        this.oid = oid;
    }

    public String getTargetYear4() {
        return targetYear4;
    }

    public void setTargetYear4(String targetYear4) {
        this.targetYear4 = targetYear4;
    }

    public String getBenchmarkYear4() {
        return benchmarkYear4;
    }

    public void setBenchmarkYear4(String benchmarkYear4) {
        this.benchmarkYear4 = benchmarkYear4;
    }

    public String getAchievementRateYear() {
        return achievementRateYear;
    }

    public void setAchievementRateYear(String achievementRateYear) {
        this.achievementRateYear = achievementRateYear;
    }

    public String getScoreYear() {
        return scoreYear;
    }

    public void setScoreYear(String scoreYear) {
        this.scoreYear = scoreYear;
    }

    public String getActualValueYear() {
        return actualValueYear;
    }

    public void setActualValueYear(String actualValueYear) {
        this.actualValueYear = actualValueYear;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getAchievementRateQ4() {
        return achievementRateQ4;
    }

    public void setAchievementRateQ4(String achievementRateQ4) {
        this.achievementRateQ4 = achievementRateQ4;
    }

    public String getContent4() {
        return content4;
    }

    public void setContent4(String content4) {
        this.content4 = content4;
    }

    public String getBenchmarkQ4() {
        return benchmarkQ4;
    }

    public void setBenchmarkQ4(String benchmarkQ4) {
        this.benchmarkQ4 = benchmarkQ4;
    }

    public String getExplanation4() {
        return explanation4;
    }

    public void setExplanation4(String explanation4) {
        this.explanation4 = explanation4;
    }

    public String getProportion4() {
        return proportion4;
    }

    public void setProportion4(String proportion4) {
        this.proportion4 = proportion4;
    }

    public String getScoreQ4() {
        return scoreQ4;
    }

    public void setScoreQ4(String scoreQ4) {
        this.scoreQ4 = scoreQ4;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getActualValueQ4() {
        return actualValueQ4;
    }

    public void setActualValueQ4(String actualValueQ4) {
        this.actualValueQ4 = actualValueQ4;
    }

    public String getTargetQ4() {
        return targetQ4;
    }

    public void setTargetQ4(String targetQ4) {
        this.targetQ4 = targetQ4;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getChange4() {
        return change4;
    }

    public void setChange4(String change4) {
        this.change4 = change4;
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
        if (!(object instanceof HKGL076DetailQ4)) {
            return false;
        }
        HKGL076DetailQ4 other = (HKGL076DetailQ4) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL076DetailQ4[ oid=" + oid + " ]";
    }
    
}
