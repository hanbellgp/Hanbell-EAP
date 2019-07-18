/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.model;

import java.io.Serializable;
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
public class GolfGame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String formid;
    private String name;
    private String gender;
    private String mobile;
    private String email;
    private String company;
    private String title;
    private String contacter;
    private int value1;
    private boolean value2;//是否用晚餐
    private boolean value3;//是否租球具
    private String value4;//衣服尺码
    private boolean value5;//是否坐巴士
    private boolean value6;//是否自己开车
    private String value7;
    private String value8;
    private String remark;

    public GolfGame() {

    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the formid
     */
    public String getFormid() {
        return formid;
    }

    /**
     * @param formid the formid to set
     */
    public void setFormid(String formid) {
        this.formid = formid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the contacter
     */
    public String getContacter() {
        return contacter;
    }

    /**
     * @param contacter the contacter to set
     */
    public void setContacter(String contacter) {
        this.contacter = contacter;
    }

    /**
     * @return the value1
     */
    public int getValue1() {
        return value1;
    }

    /**
     * @param value1 the value1 to set
     */
    public void setValue1(int value1) {
        this.value1 = value1;
    }

    /**
     * @return the value2
     */
    public boolean getValue2() {
        return value2;
    }

    /**
     * @param value2 the value2 to set
     */
    public void setValue2(boolean value2) {
        this.value2 = value2;
    }

    /**
     * @return the value3
     */
    public boolean getValue3() {
        return value3;
    }

    /**
     * @param value3 the value3 to set
     */
    public void setValue3(boolean value3) {
        this.value3 = value3;
    }

    /**
     * @return the value4
     */
    public String getValue4() {
        return value4;
    }

    /**
     * @param value4 the value4 to set
     */
    public void setValue4(String value4) {
        this.value4 = value4;
    }

    /**
     * @return the value5
     */
    public boolean getValue5() {
        return value5;
    }

    /**
     * @param value5 the value5 to set
     */
    public void setValue5(boolean value5) {
        this.value5 = value5;
    }

    /**
     * @return the value6
     */
    public boolean getValue6() {
        return value6;
    }

    /**
     * @param value6 the value6 to set
     */
    public void setValue6(boolean value6) {
        this.value6 = value6;
    }

    /**
     * @return the value7
     */
    public String getValue7() {
        return value7;
    }

    /**
     * @param value7 the value7 to set
     */
    public void setValue7(String value7) {
        this.value7 = value7;
    }

    /**
     * @return the value8
     */
    public String getValue8() {
        return value8;
    }

    /**
     * @param value8 the value8 to set
     */
    public void setValue8(String value8) {
        this.value8 = value8;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

}
