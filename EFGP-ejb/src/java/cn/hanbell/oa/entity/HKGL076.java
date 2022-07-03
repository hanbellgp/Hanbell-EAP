/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@Entity
@Table(name = "HK_GL076")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL076.findAll", query = "SELECT h FROM HKGL076 h"),
    @NamedQuery(name = "HKGL076.findByPSN", query = "SELECT h FROM HKGL076 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKGL076.findByScoreYear", query = "SELECT h FROM HKGL076 h WHERE h.scoreYear = :scoreYear"),
    @NamedQuery(name = "HKGL076.findByActualValueYear", query = "SELECT h FROM HKGL076 h WHERE h.actualValueYear = :actualValueYear"),
    @NamedQuery(name = "HKGL076.findByAchievementRateHalfYear", query = "SELECT h FROM HKGL076 h WHERE h.achievementRateHalfYear = :achievementRateHalfYear"),
    @NamedQuery(name = "HKGL076.findByApplyUser", query = "SELECT h FROM HKGL076 h WHERE h.applyUser = :applyUser"),
    @NamedQuery(name = "HKGL076.findByApplyDept", query = "SELECT h FROM HKGL076 h WHERE h.applyDept = :applyDept"),
    @NamedQuery(name = "HKGL076.findByExplanation4", query = "SELECT h FROM HKGL076 h WHERE h.explanation4 = :explanation4"),
    @NamedQuery(name = "HKGL076.findByExplanation3", query = "SELECT h FROM HKGL076 h WHERE h.explanation3 = :explanation3"),
    @NamedQuery(name = "HKGL076.findByExplanation2", query = "SELECT h FROM HKGL076 h WHERE h.explanation2 = :explanation2"),
    @NamedQuery(name = "HKGL076.findByExplanation1", query = "SELECT h FROM HKGL076 h WHERE h.explanation1 = :explanation1"),
    @NamedQuery(name = "HKGL076.findByTargetHalfYear", query = "SELECT h FROM HKGL076 h WHERE h.targetHalfYear = :targetHalfYear"),
    @NamedQuery(name = "HKGL076.findByBenchmarkQ2", query = "SELECT h FROM HKGL076 h WHERE h.benchmarkQ2 = :benchmarkQ2"),
    @NamedQuery(name = "HKGL076.findByBenchmarkQ3", query = "SELECT h FROM HKGL076 h WHERE h.benchmarkQ3 = :benchmarkQ3"),
    @NamedQuery(name = "HKGL076.findByBenchmarkQ1", query = "SELECT h FROM HKGL076 h WHERE h.benchmarkQ1 = :benchmarkQ1"),
    @NamedQuery(name = "HKGL076.findByOId", query = "SELECT h FROM HKGL076 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL076.findByAssessmentDept", query = "SELECT h FROM HKGL076 h WHERE h.assessmentDept = :assessmentDept"),
    @NamedQuery(name = "HKGL076.findBySerialNumber", query = "SELECT h FROM HKGL076 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKGL076.findByBenchmarkHalfYear", query = "SELECT h FROM HKGL076 h WHERE h.benchmarkHalfYear = :benchmarkHalfYear"),
    @NamedQuery(name = "HKGL076.findByProportion1", query = "SELECT h FROM HKGL076 h WHERE h.proportion1 = :proportion1"),
    @NamedQuery(name = "HKGL076.findByActualValueQ3", query = "SELECT h FROM HKGL076 h WHERE h.actualValueQ3 = :actualValueQ3"),
    @NamedQuery(name = "HKGL076.findByProportion4", query = "SELECT h FROM HKGL076 h WHERE h.proportion4 = :proportion4"),
    @NamedQuery(name = "HKGL076.findByScoreQ4", query = "SELECT h FROM HKGL076 h WHERE h.scoreQ4 = :scoreQ4"),
    @NamedQuery(name = "HKGL076.findByActualValueQ2", query = "SELECT h FROM HKGL076 h WHERE h.actualValueQ2 = :actualValueQ2"),
    @NamedQuery(name = "HKGL076.findByScoreQ3", query = "SELECT h FROM HKGL076 h WHERE h.scoreQ3 = :scoreQ3"),
    @NamedQuery(name = "HKGL076.findByProportion2", query = "SELECT h FROM HKGL076 h WHERE h.proportion2 = :proportion2"),
    @NamedQuery(name = "HKGL076.findByActualValueQ4", query = "SELECT h FROM HKGL076 h WHERE h.actualValueQ4 = :actualValueQ4"),
    @NamedQuery(name = "HKGL076.findByProportion3", query = "SELECT h FROM HKGL076 h WHERE h.proportion3 = :proportion3"),
    @NamedQuery(name = "HKGL076.findByActualValueQ1", query = "SELECT h FROM HKGL076 h WHERE h.actualValueQ1 = :actualValueQ1"),
    @NamedQuery(name = "HKGL076.findByScoreQ2", query = "SELECT h FROM HKGL076 h WHERE h.scoreQ2 = :scoreQ2"),
    @NamedQuery(name = "HKGL076.findByAssessmentYear", query = "SELECT h FROM HKGL076 h WHERE h.assessmentYear = :assessmentYear"),
    @NamedQuery(name = "HKGL076.findByScoreQ1", query = "SELECT h FROM HKGL076 h WHERE h.scoreQ1 = :scoreQ1"),
    @NamedQuery(name = "HKGL076.findByBenchmarkYear2", query = "SELECT h FROM HKGL076 h WHERE h.benchmarkYear2 = :benchmarkYear2"),
    @NamedQuery(name = "HKGL076.findByBenchmarkYear3", query = "SELECT h FROM HKGL076 h WHERE h.benchmarkYear3 = :benchmarkYear3"),
    @NamedQuery(name = "HKGL076.findByBenchmarkYear4", query = "SELECT h FROM HKGL076 h WHERE h.benchmarkYear4 = :benchmarkYear4"),
    @NamedQuery(name = "HKGL076.findByAchievementRateYear", query = "SELECT h FROM HKGL076 h WHERE h.achievementRateYear = :achievementRateYear"),
    @NamedQuery(name = "HKGL076.findByAssessmentLevel", query = "SELECT h FROM HKGL076 h WHERE h.assessmentLevel = :assessmentLevel"),
    @NamedQuery(name = "HKGL076.findByBenchmarkYear1", query = "SELECT h FROM HKGL076 h WHERE h.benchmarkYear1 = :benchmarkYear1"),
    @NamedQuery(name = "HKGL076.findByScoreHalfYear", query = "SELECT h FROM HKGL076 h WHERE h.scoreHalfYear = :scoreHalfYear"),
    @NamedQuery(name = "HKGL076.findByBenchmarkQ4", query = "SELECT h FROM HKGL076 h WHERE h.benchmarkQ4 = :benchmarkQ4"),
    @NamedQuery(name = "HKGL076.findByFSN", query = "SELECT h FROM HKGL076 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKGL076.findByCreateDate", query = "SELECT h FROM HKGL076 h WHERE h.createDate = :createDate"),
    @NamedQuery(name = "HKGL076.findByPerformanceName", query = "SELECT h FROM HKGL076 h WHERE h.performanceName = :performanceName"),
    @NamedQuery(name = "HKGL076.findByTargetYear2", query = "SELECT h FROM HKGL076 h WHERE h.targetYear2 = :targetYear2"),
    @NamedQuery(name = "HKGL076.findByTargetYear3", query = "SELECT h FROM HKGL076 h WHERE h.targetYear3 = :targetYear3"),
    @NamedQuery(name = "HKGL076.findByTargetYear4", query = "SELECT h FROM HKGL076 h WHERE h.targetYear4 = :targetYear4"),
    @NamedQuery(name = "HKGL076.findByActualValueHalfYear", query = "SELECT h FROM HKGL076 h WHERE h.actualValueHalfYear = :actualValueHalfYear"),
    @NamedQuery(name = "HKGL076.findByTargetYear1", query = "SELECT h FROM HKGL076 h WHERE h.targetYear1 = :targetYear1"),
    @NamedQuery(name = "HKGL076.findByAchievementRateQ1", query = "SELECT h FROM HKGL076 h WHERE h.achievementRateQ1 = :achievementRateQ1"),
    @NamedQuery(name = "HKGL076.findByAchievementRateQ4", query = "SELECT h FROM HKGL076 h WHERE h.achievementRateQ4 = :achievementRateQ4"),
    @NamedQuery(name = "HKGL076.findByAchievementRateQ2", query = "SELECT h FROM HKGL076 h WHERE h.achievementRateQ2 = :achievementRateQ2"),
    @NamedQuery(name = "HKGL076.findByAchievementRateQ3", query = "SELECT h FROM HKGL076 h WHERE h.achievementRateQ3 = :achievementRateQ3"),
    @NamedQuery(name = "HKGL076.findByContent4", query = "SELECT h FROM HKGL076 h WHERE h.content4 = :content4"),
    @NamedQuery(name = "HKGL076.findByContent3", query = "SELECT h FROM HKGL076 h WHERE h.content3 = :content3"),
    @NamedQuery(name = "HKGL076.findByContent2", query = "SELECT h FROM HKGL076 h WHERE h.content2 = :content2"),
    @NamedQuery(name = "HKGL076.findByContent1", query = "SELECT h FROM HKGL076 h WHERE h.content1 = :content1"),
    @NamedQuery(name = "HKGL076.findByTargetQ1", query = "SELECT h FROM HKGL076 h WHERE h.targetQ1 = :targetQ1"),
    @NamedQuery(name = "HKGL076.findByTargetQ2", query = "SELECT h FROM HKGL076 h WHERE h.targetQ2 = :targetQ2"),
    @NamedQuery(name = "HKGL076.findByTargetQ3", query = "SELECT h FROM HKGL076 h WHERE h.targetQ3 = :targetQ3"),
    @NamedQuery(name = "HKGL076.findByTargetQ4", query = "SELECT h FROM HKGL076 h WHERE h.targetQ4 = :targetQ4"),
    @NamedQuery(name = "HKGL076.findByAssessmentQuarter", query = "SELECT h FROM HKGL076 h WHERE h.assessmentQuarter = :assessmentQuarter"),
    @NamedQuery(name = "HKGL076.findByScoreCord", query = "SELECT h FROM HKGL076 h WHERE h.scoreCord = :scoreCord"),
    @NamedQuery(name = "HKGL076.findByLevelCode", query = "SELECT h FROM HKGL076 h WHERE h.levelCode = :levelCode"),
    @NamedQuery(name = "HKGL076.findByChange3", query = "SELECT h FROM HKGL076 h WHERE h.change3 = :change3"),
    @NamedQuery(name = "HKGL076.findByChange2", query = "SELECT h FROM HKGL076 h WHERE h.change2 = :change2"),
    @NamedQuery(name = "HKGL076.findByChange1", query = "SELECT h FROM HKGL076 h WHERE h.change1 = :change1"),
    @NamedQuery(name = "HKGL076.findByChange4", query = "SELECT h FROM HKGL076 h WHERE h.change4 = :change4")})
public class HKGL076 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "scoreYear")
    private String scoreYear;
    @Size(max = 255)
    @Column(name = "actualValueYear")
    private String actualValueYear;
    @Size(max = 255)
    @Column(name = "achievementRateHalfYear")
    private String achievementRateHalfYear;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "explanation4")
    private String explanation4;
    @Size(max = 255)
    @Column(name = "explanation3")
    private String explanation3;
    @Size(max = 255)
    @Column(name = "explanation2")
    private String explanation2;
    @Size(max = 255)
    @Column(name = "explanation1")
    private String explanation1;
    @Size(max = 255)
    @Column(name = "targetHalfYear")
    private String targetHalfYear;
    @Size(max = 255)
    @Column(name = "benchmarkQ2")
    private String benchmarkQ2;
    @Size(max = 255)
    @Column(name = "benchmarkQ3")
    private String benchmarkQ3;
    @Size(max = 255)
    @Column(name = "benchmarkQ1")
    private String benchmarkQ1;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "assessmentDept")
    private String assessmentDept;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "benchmarkHalfYear")
    private String benchmarkHalfYear;
    @Size(max = 255)
    @Column(name = "proportion1")
    private String proportion1;
    @Size(max = 255)
    @Column(name = "actualValueQ3")
    private String actualValueQ3;
    @Size(max = 255)
    @Column(name = "proportion4")
    private String proportion4;
    @Size(max = 255)
    @Column(name = "scoreQ4")
    private String scoreQ4;
    @Size(max = 255)
    @Column(name = "actualValueQ2")
    private String actualValueQ2;
    @Size(max = 255)
    @Column(name = "scoreQ3")
    private String scoreQ3;
    @Size(max = 255)
    @Column(name = "proportion2")
    private String proportion2;
    @Size(max = 255)
    @Column(name = "actualValueQ4")
    private String actualValueQ4;
    @Size(max = 255)
    @Column(name = "proportion3")
    private String proportion3;
    @Size(max = 255)
    @Column(name = "actualValueQ1")
    private String actualValueQ1;
    @Size(max = 255)
    @Column(name = "scoreQ2")
    private String scoreQ2;
    @Size(max = 255)
    @Column(name = "assessmentYear")
    private String assessmentYear;
    @Size(max = 255)
    @Column(name = "scoreQ1")
    private String scoreQ1;
    @Size(max = 255)
    @Column(name = "benchmarkYear2")
    private String benchmarkYear2;
    @Size(max = 255)
    @Column(name = "benchmarkYear3")
    private String benchmarkYear3;
    @Size(max = 255)
    @Column(name = "benchmarkYear4")
    private String benchmarkYear4;
    @Size(max = 255)
    @Column(name = "achievementRateYear")
    private String achievementRateYear;
    @Size(max = 255)
    @Column(name = "assessmentLevel")
    private String assessmentLevel;
    @Size(max = 255)
    @Column(name = "benchmarkYear1")
    private String benchmarkYear1;
    @Size(max = 255)
    @Column(name = "scoreHalfYear")
    private String scoreHalfYear;
    @Size(max = 255)
    @Column(name = "benchmarkQ4")
    private String benchmarkQ4;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 255)
    @Column(name = "performanceName")
    private String performanceName;
    @Size(max = 255)
    @Column(name = "targetYear2")
    private String targetYear2;
    @Size(max = 255)
    @Column(name = "targetYear3")
    private String targetYear3;
    @Size(max = 255)
    @Column(name = "targetYear4")
    private String targetYear4;
    @Size(max = 255)
    @Column(name = "actualValueHalfYear")
    private String actualValueHalfYear;
    @Size(max = 255)
    @Column(name = "targetYear1")
    private String targetYear1;
    @Size(max = 255)
    @Column(name = "achievementRateQ1")
    private String achievementRateQ1;
    @Size(max = 255)
    @Column(name = "achievementRateQ4")
    private String achievementRateQ4;
    @Size(max = 255)
    @Column(name = "achievementRateQ2")
    private String achievementRateQ2;
    @Size(max = 255)
    @Column(name = "achievementRateQ3")
    private String achievementRateQ3;
    @Size(max = 255)
    @Column(name = "content4")
    private String content4;
    @Size(max = 255)
    @Column(name = "content3")
    private String content3;
    @Size(max = 255)
    @Column(name = "content2")
    private String content2;
    @Size(max = 255)
    @Column(name = "content1")
    private String content1;
    @Size(max = 255)
    @Column(name = "targetQ1")
    private String targetQ1;
    @Size(max = 255)
    @Column(name = "targetQ2")
    private String targetQ2;
    @Size(max = 255)
    @Column(name = "targetQ3")
    private String targetQ3;
    @Size(max = 255)
    @Column(name = "targetQ4")
    private String targetQ4;
    @Size(max = 255)
    @Column(name = "assessmentQuarter")
    private String assessmentQuarter;
    @Size(max = 255)
    @Column(name = "scoreCord")
    private String scoreCord;
    @Size(max = 255)
    @Column(name = "levelCode")
    private String levelCode;
    @Size(max = 255)
    @Column(name = "change3")
    private String change3;
    @Size(max = 255)
    @Column(name = "change2")
    private String change2;
    @Size(max = 255)
    @Column(name = "change1")
    private String change1;
    @Size(max = 255)
    @Column(name = "change4")
    private String change4;

    public HKGL076() {
    }

    public HKGL076(String oid) {
        this.oid = oid;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
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

    public String getAchievementRateHalfYear() {
        return achievementRateHalfYear;
    }

    public void setAchievementRateHalfYear(String achievementRateHalfYear) {
        this.achievementRateHalfYear = achievementRateHalfYear;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getExplanation4() {
        return explanation4;
    }

    public void setExplanation4(String explanation4) {
        this.explanation4 = explanation4;
    }

    public String getExplanation3() {
        return explanation3;
    }

    public void setExplanation3(String explanation3) {
        this.explanation3 = explanation3;
    }

    public String getExplanation2() {
        return explanation2;
    }

    public void setExplanation2(String explanation2) {
        this.explanation2 = explanation2;
    }

    public String getExplanation1() {
        return explanation1;
    }

    public void setExplanation1(String explanation1) {
        this.explanation1 = explanation1;
    }

    public String getTargetHalfYear() {
        return targetHalfYear;
    }

    public void setTargetHalfYear(String targetHalfYear) {
        this.targetHalfYear = targetHalfYear;
    }

    public String getBenchmarkQ2() {
        return benchmarkQ2;
    }

    public void setBenchmarkQ2(String benchmarkQ2) {
        this.benchmarkQ2 = benchmarkQ2;
    }

    public String getBenchmarkQ3() {
        return benchmarkQ3;
    }

    public void setBenchmarkQ3(String benchmarkQ3) {
        this.benchmarkQ3 = benchmarkQ3;
    }

    public String getBenchmarkQ1() {
        return benchmarkQ1;
    }

    public void setBenchmarkQ1(String benchmarkQ1) {
        this.benchmarkQ1 = benchmarkQ1;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getAssessmentDept() {
        return assessmentDept;
    }

    public void setAssessmentDept(String assessmentDept) {
        this.assessmentDept = assessmentDept;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBenchmarkHalfYear() {
        return benchmarkHalfYear;
    }

    public void setBenchmarkHalfYear(String benchmarkHalfYear) {
        this.benchmarkHalfYear = benchmarkHalfYear;
    }

    public String getProportion1() {
        return proportion1;
    }

    public void setProportion1(String proportion1) {
        this.proportion1 = proportion1;
    }

    public String getActualValueQ3() {
        return actualValueQ3;
    }

    public void setActualValueQ3(String actualValueQ3) {
        this.actualValueQ3 = actualValueQ3;
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

    public String getActualValueQ2() {
        return actualValueQ2;
    }

    public void setActualValueQ2(String actualValueQ2) {
        this.actualValueQ2 = actualValueQ2;
    }

    public String getScoreQ3() {
        return scoreQ3;
    }

    public void setScoreQ3(String scoreQ3) {
        this.scoreQ3 = scoreQ3;
    }

    public String getProportion2() {
        return proportion2;
    }

    public void setProportion2(String proportion2) {
        this.proportion2 = proportion2;
    }

    public String getActualValueQ4() {
        return actualValueQ4;
    }

    public void setActualValueQ4(String actualValueQ4) {
        this.actualValueQ4 = actualValueQ4;
    }

    public String getProportion3() {
        return proportion3;
    }

    public void setProportion3(String proportion3) {
        this.proportion3 = proportion3;
    }

    public String getActualValueQ1() {
        return actualValueQ1;
    }

    public void setActualValueQ1(String actualValueQ1) {
        this.actualValueQ1 = actualValueQ1;
    }

    public String getScoreQ2() {
        return scoreQ2;
    }

    public void setScoreQ2(String scoreQ2) {
        this.scoreQ2 = scoreQ2;
    }

    public String getAssessmentYear() {
        return assessmentYear;
    }

    public void setAssessmentYear(String assessmentYear) {
        this.assessmentYear = assessmentYear;
    }

    public String getScoreQ1() {
        return scoreQ1;
    }

    public void setScoreQ1(String scoreQ1) {
        this.scoreQ1 = scoreQ1;
    }

    public String getBenchmarkYear2() {
        return benchmarkYear2;
    }

    public void setBenchmarkYear2(String benchmarkYear2) {
        this.benchmarkYear2 = benchmarkYear2;
    }

    public String getBenchmarkYear3() {
        return benchmarkYear3;
    }

    public void setBenchmarkYear3(String benchmarkYear3) {
        this.benchmarkYear3 = benchmarkYear3;
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

    public String getAssessmentLevel() {
        return assessmentLevel;
    }

    public void setAssessmentLevel(String assessmentLevel) {
        this.assessmentLevel = assessmentLevel;
    }

    public String getBenchmarkYear1() {
        return benchmarkYear1;
    }

    public void setBenchmarkYear1(String benchmarkYear1) {
        this.benchmarkYear1 = benchmarkYear1;
    }

    public String getScoreHalfYear() {
        return scoreHalfYear;
    }

    public void setScoreHalfYear(String scoreHalfYear) {
        this.scoreHalfYear = scoreHalfYear;
    }

    public String getBenchmarkQ4() {
        return benchmarkQ4;
    }

    public void setBenchmarkQ4(String benchmarkQ4) {
        this.benchmarkQ4 = benchmarkQ4;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPerformanceName() {
        return performanceName;
    }

    public void setPerformanceName(String performanceName) {
        this.performanceName = performanceName;
    }

    public String getTargetYear2() {
        return targetYear2;
    }

    public void setTargetYear2(String targetYear2) {
        this.targetYear2 = targetYear2;
    }

    public String getTargetYear3() {
        return targetYear3;
    }

    public void setTargetYear3(String targetYear3) {
        this.targetYear3 = targetYear3;
    }

    public String getTargetYear4() {
        return targetYear4;
    }

    public void setTargetYear4(String targetYear4) {
        this.targetYear4 = targetYear4;
    }

    public String getActualValueHalfYear() {
        return actualValueHalfYear;
    }

    public void setActualValueHalfYear(String actualValueHalfYear) {
        this.actualValueHalfYear = actualValueHalfYear;
    }

    public String getTargetYear1() {
        return targetYear1;
    }

    public void setTargetYear1(String targetYear1) {
        this.targetYear1 = targetYear1;
    }

    public String getAchievementRateQ1() {
        return achievementRateQ1;
    }

    public void setAchievementRateQ1(String achievementRateQ1) {
        this.achievementRateQ1 = achievementRateQ1;
    }

    public String getAchievementRateQ4() {
        return achievementRateQ4;
    }

    public void setAchievementRateQ4(String achievementRateQ4) {
        this.achievementRateQ4 = achievementRateQ4;
    }

    public String getAchievementRateQ2() {
        return achievementRateQ2;
    }

    public void setAchievementRateQ2(String achievementRateQ2) {
        this.achievementRateQ2 = achievementRateQ2;
    }

    public String getAchievementRateQ3() {
        return achievementRateQ3;
    }

    public void setAchievementRateQ3(String achievementRateQ3) {
        this.achievementRateQ3 = achievementRateQ3;
    }

    public String getContent4() {
        return content4;
    }

    public void setContent4(String content4) {
        this.content4 = content4;
    }

    public String getContent3() {
        return content3;
    }

    public void setContent3(String content3) {
        this.content3 = content3;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
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

    public String getTargetQ2() {
        return targetQ2;
    }

    public void setTargetQ2(String targetQ2) {
        this.targetQ2 = targetQ2;
    }

    public String getTargetQ3() {
        return targetQ3;
    }

    public void setTargetQ3(String targetQ3) {
        this.targetQ3 = targetQ3;
    }

    public String getTargetQ4() {
        return targetQ4;
    }

    public void setTargetQ4(String targetQ4) {
        this.targetQ4 = targetQ4;
    }

    public String getAssessmentQuarter() {
        return assessmentQuarter;
    }

    public void setAssessmentQuarter(String assessmentQuarter) {
        this.assessmentQuarter = assessmentQuarter;
    }

    public String getScoreCord() {
        return scoreCord;
    }

    public void setScoreCord(String scoreCord) {
        this.scoreCord = scoreCord;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getChange3() {
        return change3;
    }

    public void setChange3(String change3) {
        this.change3 = change3;
    }

    public String getChange2() {
        return change2;
    }

    public void setChange2(String change2) {
        this.change2 = change2;
    }

    public String getChange1() {
        return change1;
    }

    public void setChange1(String change1) {
        this.change1 = change1;
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
        if (!(object instanceof HKGL076)) {
            return false;
        }
        HKGL076 other = (HKGL076) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL076[ oid=" + oid + " ]";
    }
    
}
