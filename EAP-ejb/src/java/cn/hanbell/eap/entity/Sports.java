/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperEntity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "sports")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sports.findAll", query = "SELECT s FROM Sports s"),
    @NamedQuery(name = "Sports.findById", query = "SELECT s FROM Sports s WHERE s.id = :id"),
    @NamedQuery(name = "Sports.findByY", query = "SELECT s FROM Sports s WHERE s.y = :y"),
    @NamedQuery(name = "Sports.findByDept", query = "SELECT s FROM Sports s WHERE s.dept = :dept")})
public class Sports extends SuperEntity {

    @Basic(optional = false)
    @NotNull
    @Column(name = "y")
    private int y;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dept")
    private String dept;
    @Column(name = "s01")
    private Integer s01;
    @Column(name = "s02")
    private Integer s02;
    @Column(name = "s03")
    private Integer s03;
    @Column(name = "s04")
    private Integer s04;
    @Column(name = "s05")
    private Integer s05;
    @Column(name = "s11")
    private Integer s11;
    @Column(name = "s12")
    private Integer s12;
    @Column(name = "s13")
    private Integer s13;
    @Column(name = "s14")
    private Integer s14;
    @Column(name = "s15")
    private Integer s15;
    @Column(name = "s21")
    private Integer s21;
    @Column(name = "s22")
    private Integer s22;
    @Column(name = "s23")
    private Integer s23;
    @Column(name = "s24")
    private Integer s24;
    @Column(name = "s25")
    private Integer s25;
    @Column(name = "s31")
    private Integer s31;
    @Column(name = "s32")
    private Integer s32;
    @Column(name = "s33")
    private Integer s33;
    @Column(name = "s34")
    private Integer s34;
    @Column(name = "s35")
    private Integer s35;
    @Column(name = "s41")
    private Integer s41;
    @Column(name = "s42")
    private Integer s42;
    @Column(name = "s43")
    private Integer s43;
    @Column(name = "s44")
    private Integer s44;
    @Column(name = "s45")
    private Integer s45;
    @Column(name = "s51")
    private Integer s51;
    @Column(name = "s52")
    private Integer s52;
    @Column(name = "s53")
    private Integer s53;
    @Column(name = "s54")
    private Integer s54;
    @Column(name = "s55")
    private Integer s55;
    @Column(name = "score")
    private Integer score;

    public Sports() {
        this.s01 = 0;
        this.s02 = 0;
        this.s03 = 0;
        this.s04 = 0;
        this.s05 = 0;
        this.s11 = 0;
        this.s12 = 0;
        this.s13 = 0;
        this.s14 = 0;
        this.s15 = 0;
        this.s21 = 0;
        this.s22 = 0;
        this.s23 = 0;
        this.s24 = 0;
        this.s25 = 0;
        this.s31 = 0;
        this.s32 = 0;
        this.s33 = 0;
        this.s34 = 0;
        this.s35 = 0;
        this.s41 = 0;
        this.s42 = 0;
        this.s43 = 0;
        this.s44 = 0;
        this.s45 = 0;
        this.s51 = 0;
        this.s52 = 0;
        this.s53 = 0;
        this.s54 = 0;
        this.s55 = 0;
        this.score = 0;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getS01() {
        return s01;
    }

    public void setS01(Integer s01) {
        this.s01 = s01;
    }

    public Integer getS02() {
        return s02;
    }

    public void setS02(Integer s02) {
        this.s02 = s02;
    }

    public Integer getS03() {
        return s03;
    }

    public void setS03(Integer s03) {
        this.s03 = s03;
    }

    public Integer getS04() {
        return s04;
    }

    public void setS04(Integer s04) {
        this.s04 = s04;
    }

    public Integer getS05() {
        return s05;
    }

    public void setS05(Integer s05) {
        this.s05 = s05;
    }

    public Integer getS11() {
        return s11;
    }

    public void setS11(Integer s11) {
        this.s11 = s11;
    }

    public Integer getS12() {
        return s12;
    }

    public void setS12(Integer s12) {
        this.s12 = s12;
    }

    public Integer getS13() {
        return s13;
    }

    public void setS13(Integer s13) {
        this.s13 = s13;
    }

    public Integer getS14() {
        return s14;
    }

    public void setS14(Integer s14) {
        this.s14 = s14;
    }

    public Integer getS15() {
        return s15;
    }

    public void setS15(Integer s15) {
        this.s15 = s15;
    }

    public Integer getS21() {
        return s21;
    }

    public void setS21(Integer s21) {
        this.s21 = s21;
    }

    public Integer getS22() {
        return s22;
    }

    public void setS22(Integer s22) {
        this.s22 = s22;
    }

    public Integer getS23() {
        return s23;
    }

    public void setS23(Integer s23) {
        this.s23 = s23;
    }

    public Integer getS24() {
        return s24;
    }

    public void setS24(Integer s24) {
        this.s24 = s24;
    }

    public Integer getS25() {
        return s25;
    }

    public void setS25(Integer s25) {
        this.s25 = s25;
    }

    public Integer getS31() {
        return s31;
    }

    public void setS31(Integer s31) {
        this.s31 = s31;
    }

    public Integer getS32() {
        return s32;
    }

    public void setS32(Integer s32) {
        this.s32 = s32;
    }

    public Integer getS33() {
        return s33;
    }

    public void setS33(Integer s33) {
        this.s33 = s33;
    }

    public Integer getS34() {
        return s34;
    }

    public void setS34(Integer s34) {
        this.s34 = s34;
    }

    public Integer getS35() {
        return s35;
    }

    public void setS35(Integer s35) {
        this.s35 = s35;
    }

    public Integer getS41() {
        return s41;
    }

    public void setS41(Integer s41) {
        this.s41 = s41;
    }

    public Integer getS42() {
        return s42;
    }

    public void setS42(Integer s42) {
        this.s42 = s42;
    }

    public Integer getS43() {
        return s43;
    }

    public void setS43(Integer s43) {
        this.s43 = s43;
    }

    public Integer getS44() {
        return s44;
    }

    public void setS44(Integer s44) {
        this.s44 = s44;
    }

    public Integer getS45() {
        return s45;
    }

    public void setS45(Integer s45) {
        this.s45 = s45;
    }

    public Integer getS51() {
        return s51;
    }

    public void setS51(Integer s51) {
        this.s51 = s51;
    }

    public Integer getS52() {
        return s52;
    }

    public void setS52(Integer s52) {
        this.s52 = s52;
    }

    public Integer getS53() {
        return s53;
    }

    public void setS53(Integer s53) {
        this.s53 = s53;
    }

    public Integer getS54() {
        return s54;
    }

    public void setS54(Integer s54) {
        this.s54 = s54;
    }

    public Integer getS55() {
        return s55;
    }

    public void setS55(Integer s55) {
        this.s55 = s55;
    }

    /**
     * @return the score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(Integer score) {
        this.score = score;
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
        if (!(object instanceof Sports)) {
            return false;
        }
        Sports other = (Sports) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.Sports[ id=" + id + " ]";
    }

}
