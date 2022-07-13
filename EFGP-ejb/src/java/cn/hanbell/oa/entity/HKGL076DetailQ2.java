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
@Table(name = "HK_GL076_detailQ2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL076DetailQ2.findAll", query = "SELECT h FROM HKGL076DetailQ2 h"),
    @NamedQuery(name = "HKGL076DetailQ2.findByTargetYear2", query = "SELECT h FROM HKGL076DetailQ2 h WHERE h.targetYear2 = :targetYear2"),
    @NamedQuery(name = "HKGL076DetailQ2.findByBenchmarkYear2", query = "SELECT h FROM HKGL076DetailQ2 h WHERE h.benchmarkYear2 = :benchmarkYear2"),
    @NamedQuery(name = "HKGL076DetailQ2.findByTargetHalfYear", query = "SELECT h FROM HKGL076DetailQ2 h WHERE h.targetHalfYear = :targetHalfYear"),
    @NamedQuery(name = "HKGL076DetailQ2.findByActualValueHalfYear", query = "SELECT h FROM HKGL076DetailQ2 h WHERE h.actualValueHalfYear = :actualValueHalfYear"),
    @NamedQuery(name = "HKGL076DetailQ2.findByBenchmarkQ2", query = "SELECT h FROM HKGL076DetailQ2 h WHERE h.benchmarkQ2 = :benchmarkQ2"),
    @NamedQuery(name = "HKGL076DetailQ2.findByOId", query = "SELECT h FROM HKGL076DetailQ2 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL076DetailQ2.findByAchievementRateHalfYear", query = "SELECT h FROM HKGL076DetailQ2 h WHERE h.achievementRateHalfYear = :achievementRateHalfYear"),
    @NamedQuery(name = "HKGL076DetailQ2.findByAchievementRateQ2", query = "SELECT h FROM HKGL076DetailQ2 h WHERE h.achievementRateQ2 = :achievementRateQ2"),
    @NamedQuery(name = "HKGL076DetailQ2.findByScoreHalfYear", query = "SELECT h FROM HKGL076DetailQ2 h WHERE h.scoreHalfYear = :scoreHalfYear"),
    @NamedQuery(name = "HKGL076DetailQ2.findByBenchmarkHalfYear", query = "SELECT h FROM HKGL076DetailQ2 h WHERE h.benchmarkHalfYear = :benchmarkHalfYear"),
    @NamedQuery(name = "HKGL076DetailQ2.findByContent2", query = "SELECT h FROM HKGL076DetailQ2 h WHERE h.content2 = :content2"),
    @NamedQuery(name = "HKGL076DetailQ2.findByActualValueQ2", query = "SELECT h FROM HKGL076DetailQ2 h WHERE h.actualValueQ2 = :actualValueQ2"),
    @NamedQuery(name = "HKGL076DetailQ2.findByFSN", query = "SELECT h FROM HKGL076DetailQ2 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKGL076DetailQ2.findByExplanation2", query = "SELECT h FROM HKGL076DetailQ2 h WHERE h.explanation2 = :explanation2"),
    @NamedQuery(name = "HKGL076DetailQ2.findByProportion2", query = "SELECT h FROM HKGL076DetailQ2 h WHERE h.proportion2 = :proportion2"),
    @NamedQuery(name = "HKGL076DetailQ2.findByTargetQ2", query = "SELECT h FROM HKGL076DetailQ2 h WHERE h.targetQ2 = :targetQ2"),
    @NamedQuery(name = "HKGL076DetailQ2.findByScoreQ2", query = "SELECT h FROM HKGL076DetailQ2 h WHERE h.scoreQ2 = :scoreQ2"),
    @NamedQuery(name = "HKGL076DetailQ2.findBySeq", query = "SELECT h FROM HKGL076DetailQ2 h WHERE h.seq = :seq"),
    @NamedQuery(name = "HKGL076DetailQ2.findByChange2", query = "SELECT h FROM HKGL076DetailQ2 h WHERE h.change2 = :change2")})
public class HKGL076DetailQ2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 4000)
    @Column(name = "targetYear2")
    private String targetYear2;
    @Size(max = 4000)
    @Column(name = "benchmarkYear2")
    private String benchmarkYear2;
    @Size(max = 4000)
    @Column(name = "targetHalfYear")
    private String targetHalfYear;
    @Size(max = 4000)
    @Column(name = "actualValueHalfYear")
    private String actualValueHalfYear;
    @Size(max = 4000)
    @Column(name = "benchmarkQ2")
    private String benchmarkQ2;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "achievementRateHalfYear")
    private String achievementRateHalfYear;
    @Size(max = 255)
    @Column(name = "achievementRateQ2")
    private String achievementRateQ2;
    @Size(max = 255)
    @Column(name = "scoreHalfYear")
    private String scoreHalfYear;
    @Size(max = 4000)
    @Column(name = "benchmarkHalfYear")
    private String benchmarkHalfYear;
    @Size(max = 255)
    @Column(name = "content2")
    private String content2;
    @Size(max = 4000)
    @Column(name = "actualValueQ2")
    private String actualValueQ2;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 4000)
    @Column(name = "explanation2")
    private String explanation2;
    @Size(max = 255)
    @Column(name = "proportion2")
    private String proportion2;
    @Size(max = 4000)
    @Column(name = "targetQ2")
    private String targetQ2;
    @Size(max = 255)
    @Column(name = "scoreQ2")
    private String scoreQ2;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "change2")
    private String change2;

    public HKGL076DetailQ2() {
    }

    public HKGL076DetailQ2(String oid) {
        this.oid = oid;
    }

    public String getTargetYear2() {
        return targetYear2;
    }

    public void setTargetYear2(String targetYear2) {
        this.targetYear2 = targetYear2;
    }

    public String getBenchmarkYear2() {
        return benchmarkYear2;
    }

    public void setBenchmarkYear2(String benchmarkYear2) {
        this.benchmarkYear2 = benchmarkYear2;
    }

    public String getTargetHalfYear() {
        return targetHalfYear;
    }

    public void setTargetHalfYear(String targetHalfYear) {
        this.targetHalfYear = targetHalfYear;
    }

    public String getActualValueHalfYear() {
        return actualValueHalfYear;
    }

    public void setActualValueHalfYear(String actualValueHalfYear) {
        this.actualValueHalfYear = actualValueHalfYear;
    }

    public String getBenchmarkQ2() {
        return benchmarkQ2;
    }

    public void setBenchmarkQ2(String benchmarkQ2) {
        this.benchmarkQ2 = benchmarkQ2;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getAchievementRateHalfYear() {
        return achievementRateHalfYear;
    }

    public void setAchievementRateHalfYear(String achievementRateHalfYear) {
        this.achievementRateHalfYear = achievementRateHalfYear;
    }

    public String getAchievementRateQ2() {
        return achievementRateQ2;
    }

    public void setAchievementRateQ2(String achievementRateQ2) {
        this.achievementRateQ2 = achievementRateQ2;
    }

    public String getScoreHalfYear() {
        return scoreHalfYear;
    }

    public void setScoreHalfYear(String scoreHalfYear) {
        this.scoreHalfYear = scoreHalfYear;
    }

    public String getBenchmarkHalfYear() {
        return benchmarkHalfYear;
    }

    public void setBenchmarkHalfYear(String benchmarkHalfYear) {
        this.benchmarkHalfYear = benchmarkHalfYear;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getActualValueQ2() {
        return actualValueQ2;
    }

    public void setActualValueQ2(String actualValueQ2) {
        this.actualValueQ2 = actualValueQ2;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getExplanation2() {
        return explanation2;
    }

    public void setExplanation2(String explanation2) {
        this.explanation2 = explanation2;
    }

    public String getProportion2() {
        return proportion2;
    }

    public void setProportion2(String proportion2) {
        this.proportion2 = proportion2;
    }

    public String getTargetQ2() {
        return targetQ2;
    }

    public void setTargetQ2(String targetQ2) {
        this.targetQ2 = targetQ2;
    }

    public String getScoreQ2() {
        return scoreQ2;
    }

    public void setScoreQ2(String scoreQ2) {
        this.scoreQ2 = scoreQ2;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getChange2() {
        return change2;
    }

    public void setChange2(String change2) {
        this.change2 = change2;
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
        if (!(object instanceof HKGL076DetailQ2)) {
            return false;
        }
        HKGL076DetailQ2 other = (HKGL076DetailQ2) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL076DetailQ2[ oid=" + oid + " ]";
    }
    
}
