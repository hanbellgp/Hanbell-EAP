/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author C1587
 */
@Entity
@Table(name = "SERBQ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SERBQ.findAll", query = "SELECT s FROM SERBQ s"),
    @NamedQuery(name = "SERBQ.findByCompany", query = "SELECT s FROM SERBQ s WHERE s.company = :company"),
    @NamedQuery(name = "SERBQ.findByCreator", query = "SELECT s FROM SERBQ s WHERE s.creator = :creator"),
    @NamedQuery(name = "SERBQ.findByUsrGroup", query = "SELECT s FROM SERBQ s WHERE s.usrGroup = :usrGroup"),
    @NamedQuery(name = "SERBQ.findByCreateDate", query = "SELECT s FROM SERBQ s WHERE s.createDate = :createDate"),
    @NamedQuery(name = "SERBQ.findByModifier", query = "SELECT s FROM SERBQ s WHERE s.modifier = :modifier"),
    @NamedQuery(name = "SERBQ.findByModiDate", query = "SELECT s FROM SERBQ s WHERE s.modiDate = :modiDate"),
    @NamedQuery(name = "SERBQ.findByFlag", query = "SELECT s FROM SERBQ s WHERE s.flag = :flag"),
    @NamedQuery(name = "SERBQ.findByBq001", query = "SELECT s FROM SERBQ s WHERE s.bq001 = :bq001"),
    @NamedQuery(name = "SERBQ.findByBq002", query = "SELECT s FROM SERBQ s WHERE s.bq002 = :bq002"),
    @NamedQuery(name = "SERBQ.findByBq003", query = "SELECT s FROM SERBQ s WHERE s.bq003 = :bq003"),
    @NamedQuery(name = "SERBQ.findByBq004", query = "SELECT s FROM SERBQ s WHERE s.bq004 = :bq004"),
    @NamedQuery(name = "SERBQ.findByBq005", query = "SELECT s FROM SERBQ s WHERE s.bq005 = :bq005"),
    @NamedQuery(name = "SERBQ.findByBq006", query = "SELECT s FROM SERBQ s WHERE s.bq006 = :bq006"),
    @NamedQuery(name = "SERBQ.findByBq007", query = "SELECT s FROM SERBQ s WHERE s.bq007 = :bq007"),
    @NamedQuery(name = "SERBQ.findByBq008", query = "SELECT s FROM SERBQ s WHERE s.bq008 = :bq008"),
    @NamedQuery(name = "SERBQ.findByBq009", query = "SELECT s FROM SERBQ s WHERE s.bq009 = :bq009"),
    @NamedQuery(name = "SERBQ.findByBq010", query = "SELECT s FROM SERBQ s WHERE s.bq010 = :bq010"),
    @NamedQuery(name = "SERBQ.findByBq011", query = "SELECT s FROM SERBQ s WHERE s.bq011 = :bq011"),
    @NamedQuery(name = "SERBQ.findByBq012", query = "SELECT s FROM SERBQ s WHERE s.bq012 = :bq012"),
    @NamedQuery(name = "SERBQ.findByBq013", query = "SELECT s FROM SERBQ s WHERE s.bq013 = :bq013"),
    @NamedQuery(name = "SERBQ.findByBq014", query = "SELECT s FROM SERBQ s WHERE s.bq014 = :bq014"),
    @NamedQuery(name = "SERBQ.findByBq015", query = "SELECT s FROM SERBQ s WHERE s.bq015 = :bq015"),
    @NamedQuery(name = "SERBQ.findByBq016", query = "SELECT s FROM SERBQ s WHERE s.bq016 = :bq016"),
    @NamedQuery(name = "SERBQ.findByBq017", query = "SELECT s FROM SERBQ s WHERE s.bq017 = :bq017"),
    @NamedQuery(name = "SERBQ.findByBq018", query = "SELECT s FROM SERBQ s WHERE s.bq018 = :bq018"),
    @NamedQuery(name = "SERBQ.findByBq019", query = "SELECT s FROM SERBQ s WHERE s.bq019 = :bq019"),
    @NamedQuery(name = "SERBQ.findByBq020", query = "SELECT s FROM SERBQ s WHERE s.bq020 = :bq020"),
    @NamedQuery(name = "SERBQ.findByBq021", query = "SELECT s FROM SERBQ s WHERE s.bq021 = :bq021"),
    @NamedQuery(name = "SERBQ.findByBq022", query = "SELECT s FROM SERBQ s WHERE s.bq022 = :bq022"),
    @NamedQuery(name = "SERBQ.findByBq023", query = "SELECT s FROM SERBQ s WHERE s.bq023 = :bq023"),
    @NamedQuery(name = "SERBQ.findByBq024", query = "SELECT s FROM SERBQ s WHERE s.bq024 = :bq024"),
    @NamedQuery(name = "SERBQ.findByBq025", query = "SELECT s FROM SERBQ s WHERE s.bq025 = :bq025"),
    @NamedQuery(name = "SERBQ.findByBq026", query = "SELECT s FROM SERBQ s WHERE s.bq026 = :bq026"),
    @NamedQuery(name = "SERBQ.findByBq027", query = "SELECT s FROM SERBQ s WHERE s.bq027 = :bq027"),
    @NamedQuery(name = "SERBQ.findByBq028", query = "SELECT s FROM SERBQ s WHERE s.bq028 = :bq028"),
    @NamedQuery(name = "SERBQ.findByBq029", query = "SELECT s FROM SERBQ s WHERE s.bq029 = :bq029"),
    @NamedQuery(name = "SERBQ.findByBq030", query = "SELECT s FROM SERBQ s WHERE s.bq030 = :bq030"),
    @NamedQuery(name = "SERBQ.findByBq031", query = "SELECT s FROM SERBQ s WHERE s.bq031 = :bq031"),
    @NamedQuery(name = "SERBQ.findByBq032", query = "SELECT s FROM SERBQ s WHERE s.bq032 = :bq032"),
    @NamedQuery(name = "SERBQ.findByBq033", query = "SELECT s FROM SERBQ s WHERE s.bq033 = :bq033"),
    @NamedQuery(name = "SERBQ.findByBq034", query = "SELECT s FROM SERBQ s WHERE s.bq034 = :bq034"),
    @NamedQuery(name = "SERBQ.findByBq035", query = "SELECT s FROM SERBQ s WHERE s.bq035 = :bq035"),
    @NamedQuery(name = "SERBQ.findByBq036", query = "SELECT s FROM SERBQ s WHERE s.bq036 = :bq036"),
    @NamedQuery(name = "SERBQ.findByBq037", query = "SELECT s FROM SERBQ s WHERE s.bq037 = :bq037"),
    @NamedQuery(name = "SERBQ.findByBq038", query = "SELECT s FROM SERBQ s WHERE s.bq038 = :bq038"),
    @NamedQuery(name = "SERBQ.findByBq039", query = "SELECT s FROM SERBQ s WHERE s.bq039 = :bq039"),
    @NamedQuery(name = "SERBQ.findByBq040", query = "SELECT s FROM SERBQ s WHERE s.bq040 = :bq040"),
    @NamedQuery(name = "SERBQ.findByBq041", query = "SELECT s FROM SERBQ s WHERE s.bq041 = :bq041"),
    @NamedQuery(name = "SERBQ.findByBq042", query = "SELECT s FROM SERBQ s WHERE s.bq042 = :bq042"),
    @NamedQuery(name = "SERBQ.findByBq043", query = "SELECT s FROM SERBQ s WHERE s.bq043 = :bq043"),
    @NamedQuery(name = "SERBQ.findByBq044", query = "SELECT s FROM SERBQ s WHERE s.bq044 = :bq044"),
    @NamedQuery(name = "SERBQ.findByBq045", query = "SELECT s FROM SERBQ s WHERE s.bq045 = :bq045"),
    @NamedQuery(name = "SERBQ.findByBq046", query = "SELECT s FROM SERBQ s WHERE s.bq046 = :bq046"),
    @NamedQuery(name = "SERBQ.findByBq047", query = "SELECT s FROM SERBQ s WHERE s.bq047 = :bq047"),
    @NamedQuery(name = "SERBQ.findByBq048", query = "SELECT s FROM SERBQ s WHERE s.bq048 = :bq048"),
    @NamedQuery(name = "SERBQ.findByBq049", query = "SELECT s FROM SERBQ s WHERE s.bq049 = :bq049"),
    @NamedQuery(name = "SERBQ.findByBq050", query = "SELECT s FROM SERBQ s WHERE s.bq050 = :bq050"),
    @NamedQuery(name = "SERBQ.findByBq051", query = "SELECT s FROM SERBQ s WHERE s.bq051 = :bq051"),
    @NamedQuery(name = "SERBQ.findByBq052", query = "SELECT s FROM SERBQ s WHERE s.bq052 = :bq052"),
    @NamedQuery(name = "SERBQ.findByBq053", query = "SELECT s FROM SERBQ s WHERE s.bq053 = :bq053"),
    @NamedQuery(name = "SERBQ.findByBq054", query = "SELECT s FROM SERBQ s WHERE s.bq054 = :bq054"),
    @NamedQuery(name = "SERBQ.findByBq055", query = "SELECT s FROM SERBQ s WHERE s.bq055 = :bq055"),
    @NamedQuery(name = "SERBQ.findByBq056", query = "SELECT s FROM SERBQ s WHERE s.bq056 = :bq056"),
    @NamedQuery(name = "SERBQ.findByBq057", query = "SELECT s FROM SERBQ s WHERE s.bq057 = :bq057"),
    @NamedQuery(name = "SERBQ.findByBq058", query = "SELECT s FROM SERBQ s WHERE s.bq058 = :bq058"),
    @NamedQuery(name = "SERBQ.findByBq059", query = "SELECT s FROM SERBQ s WHERE s.bq059 = :bq059"),
    @NamedQuery(name = "SERBQ.findByBq060", query = "SELECT s FROM SERBQ s WHERE s.bq060 = :bq060"),
    @NamedQuery(name = "SERBQ.findByBq061", query = "SELECT s FROM SERBQ s WHERE s.bq061 = :bq061"),
    @NamedQuery(name = "SERBQ.findByBq062", query = "SELECT s FROM SERBQ s WHERE s.bq062 = :bq062"),
    @NamedQuery(name = "SERBQ.findByBq063", query = "SELECT s FROM SERBQ s WHERE s.bq063 = :bq063"),
    @NamedQuery(name = "SERBQ.findByBq064", query = "SELECT s FROM SERBQ s WHERE s.bq064 = :bq064"),
    @NamedQuery(name = "SERBQ.findByBq065", query = "SELECT s FROM SERBQ s WHERE s.bq065 = :bq065"),
    @NamedQuery(name = "SERBQ.findByBq066", query = "SELECT s FROM SERBQ s WHERE s.bq066 = :bq066"),
    @NamedQuery(name = "SERBQ.findByBq067", query = "SELECT s FROM SERBQ s WHERE s.bq067 = :bq067"),
    @NamedQuery(name = "SERBQ.findByBq068", query = "SELECT s FROM SERBQ s WHERE s.bq068 = :bq068"),
    @NamedQuery(name = "SERBQ.findByBq069", query = "SELECT s FROM SERBQ s WHERE s.bq069 = :bq069"),
    @NamedQuery(name = "SERBQ.findByBq070", query = "SELECT s FROM SERBQ s WHERE s.bq070 = :bq070"),
    @NamedQuery(name = "SERBQ.findByBq071", query = "SELECT s FROM SERBQ s WHERE s.bq071 = :bq071"),
    @NamedQuery(name = "SERBQ.findByBq072", query = "SELECT s FROM SERBQ s WHERE s.bq072 = :bq072"),
    @NamedQuery(name = "SERBQ.findByBq073", query = "SELECT s FROM SERBQ s WHERE s.bq073 = :bq073"),
    @NamedQuery(name = "SERBQ.findByBq074", query = "SELECT s FROM SERBQ s WHERE s.bq074 = :bq074"),
    @NamedQuery(name = "SERBQ.findByBq075", query = "SELECT s FROM SERBQ s WHERE s.bq075 = :bq075"),
    @NamedQuery(name = "SERBQ.findByBq076", query = "SELECT s FROM SERBQ s WHERE s.bq076 = :bq076"),
    @NamedQuery(name = "SERBQ.findByBq077", query = "SELECT s FROM SERBQ s WHERE s.bq077 = :bq077"),
    @NamedQuery(name = "SERBQ.findByBq078", query = "SELECT s FROM SERBQ s WHERE s.bq078 = :bq078"),
    @NamedQuery(name = "SERBQ.findByBq079", query = "SELECT s FROM SERBQ s WHERE s.bq079 = :bq079"),
    @NamedQuery(name = "SERBQ.findByBq080", query = "SELECT s FROM SERBQ s WHERE s.bq080 = :bq080"),
    @NamedQuery(name = "SERBQ.findByBq081", query = "SELECT s FROM SERBQ s WHERE s.bq081 = :bq081"),
    @NamedQuery(name = "SERBQ.findByBq082", query = "SELECT s FROM SERBQ s WHERE s.bq082 = :bq082"),
    @NamedQuery(name = "SERBQ.findByBq083", query = "SELECT s FROM SERBQ s WHERE s.bq083 = :bq083"),
    @NamedQuery(name = "SERBQ.findByBq084", query = "SELECT s FROM SERBQ s WHERE s.bq084 = :bq084"),
    @NamedQuery(name = "SERBQ.findByBq085", query = "SELECT s FROM SERBQ s WHERE s.bq085 = :bq085"),
    @NamedQuery(name = "SERBQ.findByBq086", query = "SELECT s FROM SERBQ s WHERE s.bq086 = :bq086"),
    @NamedQuery(name = "SERBQ.findByBq087", query = "SELECT s FROM SERBQ s WHERE s.bq087 = :bq087"),
    @NamedQuery(name = "SERBQ.findByBq088", query = "SELECT s FROM SERBQ s WHERE s.bq088 = :bq088"),
    @NamedQuery(name = "SERBQ.findByBq089", query = "SELECT s FROM SERBQ s WHERE s.bq089 = :bq089"),
    @NamedQuery(name = "SERBQ.findByBq090", query = "SELECT s FROM SERBQ s WHERE s.bq090 = :bq090"),
    @NamedQuery(name = "SERBQ.findByBq091", query = "SELECT s FROM SERBQ s WHERE s.bq091 = :bq091"),
    @NamedQuery(name = "SERBQ.findByBq092", query = "SELECT s FROM SERBQ s WHERE s.bq092 = :bq092"),
    @NamedQuery(name = "SERBQ.findByBq093", query = "SELECT s FROM SERBQ s WHERE s.bq093 = :bq093"),
    @NamedQuery(name = "SERBQ.findByBq094", query = "SELECT s FROM SERBQ s WHERE s.bq094 = :bq094"),
    @NamedQuery(name = "SERBQ.findByBq095", query = "SELECT s FROM SERBQ s WHERE s.bq095 = :bq095"),
    @NamedQuery(name = "SERBQ.findByBq096", query = "SELECT s FROM SERBQ s WHERE s.bq096 = :bq096"),
    @NamedQuery(name = "SERBQ.findByBq097", query = "SELECT s FROM SERBQ s WHERE s.bq097 = :bq097"),
    @NamedQuery(name = "SERBQ.findByBq098", query = "SELECT s FROM SERBQ s WHERE s.bq098 = :bq098"),
    @NamedQuery(name = "SERBQ.findByBq099", query = "SELECT s FROM SERBQ s WHERE s.bq099 = :bq099"),
    @NamedQuery(name = "SERBQ.findByBq100", query = "SELECT s FROM SERBQ s WHERE s.bq100 = :bq100"),
    @NamedQuery(name = "SERBQ.findByBq101", query = "SELECT s FROM SERBQ s WHERE s.bq101 = :bq101"),
    @NamedQuery(name = "SERBQ.findByBq102", query = "SELECT s FROM SERBQ s WHERE s.bq102 = :bq102"),
    @NamedQuery(name = "SERBQ.findByBq103", query = "SELECT s FROM SERBQ s WHERE s.bq103 = :bq103"),
    @NamedQuery(name = "SERBQ.findByBq104", query = "SELECT s FROM SERBQ s WHERE s.bq104 = :bq104"),
    @NamedQuery(name = "SERBQ.findByBq105", query = "SELECT s FROM SERBQ s WHERE s.bq105 = :bq105"),
    @NamedQuery(name = "SERBQ.findByBq106", query = "SELECT s FROM SERBQ s WHERE s.bq106 = :bq106"),
    @NamedQuery(name = "SERBQ.findByBq107", query = "SELECT s FROM SERBQ s WHERE s.bq107 = :bq107"),
    @NamedQuery(name = "SERBQ.findByBq108", query = "SELECT s FROM SERBQ s WHERE s.bq108 = :bq108"),
    @NamedQuery(name = "SERBQ.findByBq109", query = "SELECT s FROM SERBQ s WHERE s.bq109 = :bq109"),
    @NamedQuery(name = "SERBQ.findByBq110", query = "SELECT s FROM SERBQ s WHERE s.bq110 = :bq110"),
    @NamedQuery(name = "SERBQ.findByBq111", query = "SELECT s FROM SERBQ s WHERE s.bq111 = :bq111"),
    @NamedQuery(name = "SERBQ.findByBq112", query = "SELECT s FROM SERBQ s WHERE s.bq112 = :bq112"),
    @NamedQuery(name = "SERBQ.findByBq113", query = "SELECT s FROM SERBQ s WHERE s.bq113 = :bq113"),
    @NamedQuery(name = "SERBQ.findByCustomer", query = "SELECT s FROM SERBQ s WHERE s.customer = :customer"),
    @NamedQuery(name = "SERBQ.findByProduct", query = "SELECT s FROM SERBQ s WHERE s.product = :product"),
    @NamedQuery(name = "SERBQ.findByRegion", query = "SELECT s FROM SERBQ s WHERE s.region = :region"),
    @NamedQuery(name = "SERBQ.findByDealer", query = "SELECT s FROM SERBQ s WHERE s.dealer = :dealer"),
    @NamedQuery(name = "SERBQ.findByBq114", query = "SELECT s FROM SERBQ s WHERE s.bq114 = :bq114"),
    @NamedQuery(name = "SERBQ.findByBq115", query = "SELECT s FROM SERBQ s WHERE s.bq115 = :bq115"),
    @NamedQuery(name = "SERBQ.findByBq197", query = "SELECT s FROM SERBQ s WHERE s.bq197 = :bq197"),
    @NamedQuery(name = "SERBQ.findByBq198", query = "SELECT s FROM SERBQ s WHERE s.bq198 = :bq198"),
    @NamedQuery(name = "SERBQ.findByBq199", query = "SELECT s FROM SERBQ s WHERE s.bq199 = :bq199"),
    @NamedQuery(name = "SERBQ.findBySerbq01", query = "SELECT s FROM SERBQ s WHERE s.serbq01 = :serbq01"),
    @NamedQuery(name = "SERBQ.findBySerbq02", query = "SELECT s FROM SERBQ s WHERE s.serbq02 = :serbq02"),
    @NamedQuery(name = "SERBQ.findBySerbq03", query = "SELECT s FROM SERBQ s WHERE s.serbq03 = :serbq03"),
    @NamedQuery(name = "SERBQ.findBySerbq04", query = "SELECT s FROM SERBQ s WHERE s.serbq04 = :serbq04"),
    @NamedQuery(name = "SERBQ.findBySerbq05", query = "SELECT s FROM SERBQ s WHERE s.serbq05 = :serbq05"),
    @NamedQuery(name = "SERBQ.findBySerbq06", query = "SELECT s FROM SERBQ s WHERE s.serbq06 = :serbq06"),
    @NamedQuery(name = "SERBQ.findBySerbq07", query = "SELECT s FROM SERBQ s WHERE s.serbq07 = :serbq07"),
    @NamedQuery(name = "SERBQ.findBySerbq08", query = "SELECT s FROM SERBQ s WHERE s.serbq08 = :serbq08"),
    @NamedQuery(name = "SERBQ.findBySerbq09", query = "SELECT s FROM SERBQ s WHERE s.serbq09 = :serbq09"),
    @NamedQuery(name = "SERBQ.findBySerbq10", query = "SELECT s FROM SERBQ s WHERE s.serbq10 = :serbq10"),
    @NamedQuery(name = "SERBQ.findBySerbq11", query = "SELECT s FROM SERBQ s WHERE s.serbq11 = :serbq11"),
    @NamedQuery(name = "SERBQ.findBySerbq12", query = "SELECT s FROM SERBQ s WHERE s.serbq12 = :serbq12"),
    @NamedQuery(name = "SERBQ.findBySerbq13", query = "SELECT s FROM SERBQ s WHERE s.serbq13 = :serbq13"),
    @NamedQuery(name = "SERBQ.findBySerbq14", query = "SELECT s FROM SERBQ s WHERE s.serbq14 = :serbq14"),
    @NamedQuery(name = "SERBQ.findBySerbq15", query = "SELECT s FROM SERBQ s WHERE s.serbq15 = :serbq15"),
    @NamedQuery(name = "SERBQ.findBySerbq16", query = "SELECT s FROM SERBQ s WHERE s.serbq16 = :serbq16"),
    @NamedQuery(name = "SERBQ.findBySerbq17", query = "SELECT s FROM SERBQ s WHERE s.serbq17 = :serbq17"),
    @NamedQuery(name = "SERBQ.findBySerbq18", query = "SELECT s FROM SERBQ s WHERE s.serbq18 = :serbq18"),
    @NamedQuery(name = "SERBQ.findBySerbq19", query = "SELECT s FROM SERBQ s WHERE s.serbq19 = :serbq19"),
    @NamedQuery(name = "SERBQ.findBySerbq20", query = "SELECT s FROM SERBQ s WHERE s.serbq20 = :serbq20"),
    @NamedQuery(name = "SERBQ.findByBq116", query = "SELECT s FROM SERBQ s WHERE s.bq116 = :bq116"),
    @NamedQuery(name = "SERBQ.findByBq117", query = "SELECT s FROM SERBQ s WHERE s.bq117 = :bq117"),
    @NamedQuery(name = "SERBQ.findByBq118", query = "SELECT s FROM SERBQ s WHERE s.bq118 = :bq118"),
    @NamedQuery(name = "SERBQ.findByBq119", query = "SELECT s FROM SERBQ s WHERE s.bq119 = :bq119"),
    @NamedQuery(name = "SERBQ.findByBq120", query = "SELECT s FROM SERBQ s WHERE s.bq120 = :bq120"),
    @NamedQuery(name = "SERBQ.findByBq121", query = "SELECT s FROM SERBQ s WHERE s.bq121 = :bq121"),
    @NamedQuery(name = "SERBQ.findByBq122", query = "SELECT s FROM SERBQ s WHERE s.bq122 = :bq122"),
    @NamedQuery(name = "SERBQ.findByBq123", query = "SELECT s FROM SERBQ s WHERE s.bq123 = :bq123"),
    @NamedQuery(name = "SERBQ.findByBq124", query = "SELECT s FROM SERBQ s WHERE s.bq124 = :bq124"),
    @NamedQuery(name = "SERBQ.findByBq125", query = "SELECT s FROM SERBQ s WHERE s.bq125 = :bq125"),
    @NamedQuery(name = "SERBQ.findByBq126", query = "SELECT s FROM SERBQ s WHERE s.bq126 = :bq126"),
    @NamedQuery(name = "SERBQ.findByBq127", query = "SELECT s FROM SERBQ s WHERE s.bq127 = :bq127"),
    @NamedQuery(name = "SERBQ.findByBq128", query = "SELECT s FROM SERBQ s WHERE s.bq128 = :bq128")})
public class SERBQ implements Serializable {

    @Size(max = 30)
    @Column(name = "BQ508")
    private String bq508;

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "COMPANY")
    private String company;
    @Size(max = 10)
    @Column(name = "CREATOR")
    private String creator;
    @Size(max = 10)
    @Column(name = "USR_GROUP")
    private String usrGroup;
    @Size(max = 8)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 10)
    @Column(name = "MODIFIER")
    private String modifier;
    @Size(max = 8)
    @Column(name = "MODI_DATE")
    private String modiDate;
    @Column(name = "FLAG")
    private Short flag;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "BQ001")
    private String bq001;
    @Size(max = 10)
    @Column(name = "BQ002")
    private String bq002;
    @Size(max = 10)
    @Column(name = "BQ003")
    private String bq003;
    @Size(max = 120)
    @Column(name = "BQ004")
    private String bq004;
    @Size(max = 3)
    @Column(name = "BQ005")
    private String bq005;
    @Size(max = 30)
    @Column(name = "BQ006")
    private String bq006;
    @Size(max = 50)
    @Column(name = "BQ007")
    private String bq007;
    @Size(max = 8)
    @Column(name = "BQ008")
    private String bq008;
    @Size(max = 20)
    @Column(name = "BQ009")
    private String bq009;
    @Size(max = 10)
    @Column(name = "BQ010")
    private String bq010;
    @Size(max = 20)
    @Column(name = "BQ011")
    private String bq011;
    @Size(max = 36)
    @Column(name = "BQ012")
    private String bq012;
    @Size(max = 8)
    @Column(name = "BQ013")
    private String bq013;
    @Size(max = 20)
    @Column(name = "BQ014")
    private String bq014;
    @Size(max = 8)
    @Column(name = "BQ015")
    private String bq015;
    @Size(max = 10)
    @Column(name = "BQ016")
    private String bq016;
    @Size(max = 10)
    @Column(name = "BQ017")
    private String bq017;
    @Size(max = 10)
    @Column(name = "BQ018")
    private String bq018;
    @Size(max = 10)
    @Column(name = "BQ019")
    private String bq019;
    @Size(max = 10)
    @Column(name = "BQ020")
    private String bq020;
    @Size(max = 8)
    @Column(name = "BQ021")
    private String bq021;
    @Size(max = 1)
    @Column(name = "BQ022")
    private String bq022;
    @Size(max = 10)
    @Column(name = "BQ023")
    private String bq023;
    @Size(max = 4000)
    @Column(name = "BQ024")
    private String bq024;
    @Size(max = 30)
    @Column(name = "BQ025")
    private String bq025;
    @Size(max = 40)
    @Column(name = "BQ026")
    private String bq026;
    @Size(max = 2)
    @Column(name = "BQ027")
    private String bq027;
    @Size(max = 1)
    @Column(name = "BQ028")
    private String bq028;
    @Size(max = 4)
    @Column(name = "BQ029")
    private String bq029;
    @Size(max = 11)
    @Column(name = "BQ030")
    private String bq030;
    @Size(max = 1)
    @Column(name = "BQ031")
    private String bq031;
    @Size(max = 10)
    @Column(name = "BQ032")
    private String bq032;
    @Size(max = 10)
    @Column(name = "BQ033")
    private String bq033;
    @Size(max = 1)
    @Column(name = "BQ034")
    private String bq034;
    @Size(max = 1)
    @Column(name = "BQ035")
    private String bq035;
    @Size(max = 1)
    @Column(name = "BQ036")
    private String bq036;
    @Size(max = 8)
    @Column(name = "BQ037")
    private String bq037;
    @Size(max = 10)
    @Column(name = "BQ038")
    private String bq038;
    @Size(max = 10)
    @Column(name = "BQ039")
    private String bq039;
    @Size(max = 8)
    @Column(name = "BQ040")
    private String bq040;
    @Size(max = 10)
    @Column(name = "BQ041")
    private String bq041;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BQ042")
    private BigDecimal bq042;
    @Column(name = "BQ043")
    private BigDecimal bq043;
    @Size(max = 1)
    @Column(name = "BQ044")
    private String bq044;
    @Size(max = 8)
    @Column(name = "BQ045")
    private String bq045;
    @Size(max = 10)
    @Column(name = "BQ046")
    private String bq046;
    @Size(max = 1)
    @Column(name = "BQ047")
    private String bq047;
    @Size(max = 15)
    @Column(name = "BQ048")
    private String bq048;
    @Size(max = 1)
    @Column(name = "BQ049")
    private String bq049;
    @Size(max = 8)
    @Column(name = "BQ050")
    private String bq050;
    @Size(max = 10)
    @Column(name = "BQ051")
    private String bq051;
    @Size(max = 1)
    @Column(name = "BQ052")
    private String bq052;
    @Size(max = 30)
    @Column(name = "BQ053")
    private String bq053;
    @Size(max = 255)
    @Column(name = "BQ054")
    private String bq054;
    @Size(max = 5)
    @Column(name = "BQ055")
    private String bq055;
    @Size(max = 10)
    @Column(name = "BQ056")
    private String bq056;
    @Size(max = 5)
    @Column(name = "BQ057")
    private String bq057;
    @Size(max = 1)
    @Column(name = "BQ058")
    private String bq058;
    @Size(max = 1)
    @Column(name = "BQ059")
    private String bq059;
    @Size(max = 5)
    @Column(name = "BQ060")
    private String bq060;
    @Size(max = 20)
    @Column(name = "BQ061")
    private String bq061;
    @Size(max = 10)
    @Column(name = "BQ062")
    private String bq062;
    @Size(max = 10)
    @Column(name = "BQ063")
    private String bq063;
    @Size(max = 1)
    @Column(name = "BQ064")
    private String bq064;
    @Size(max = 1)
    @Column(name = "BQ065")
    private String bq065;
    @Size(max = 1073741823)
    @Column(name = "BQ066")
    private String bq066;
    @Size(max = 50)
    @Column(name = "BQ067")
    private String bq067;
    @Column(name = "BQ068")
    private BigDecimal bq068;
    @Size(max = 50)
    @Column(name = "BQ069")
    private String bq069;
    @Size(max = 50)
    @Column(name = "BQ070")
    private String bq070;
    @Size(max = 50)
    @Column(name = "BQ071")
    private String bq071;
    @Size(max = 50)
    @Column(name = "BQ072")
    private String bq072;
    @Size(max = 50)
    @Column(name = "BQ073")
    private String bq073;
    @Size(max = 50)
    @Column(name = "BQ074")
    private String bq074;
    @Size(max = 50)
    @Column(name = "BQ075")
    private String bq075;
    @Size(max = 50)
    @Column(name = "BQ076")
    private String bq076;
    @Size(max = 50)
    @Column(name = "BQ077")
    private String bq077;
    @Size(max = 50)
    @Column(name = "BQ078")
    private String bq078;
    @Size(max = 50)
    @Column(name = "BQ079")
    private String bq079;
    @Size(max = 10)
    @Column(name = "BQ080")
    private String bq080;
    @Size(max = 10)
    @Column(name = "BQ081")
    private String bq081;
    @Size(max = 10)
    @Column(name = "BQ082")
    private String bq082;
    @Size(max = 1073741823)
    @Column(name = "BQ083")
    private String bq083;
    @Size(max = 1073741823)
    @Column(name = "BQ084")
    private String bq084;
    @Size(max = 15)
    @Column(name = "BQ085")
    private String bq085;
    @Size(max = 20)
    @Column(name = "BQ086")
    private String bq086;
    @Size(max = 40)
    @Column(name = "BQ087")
    private String bq087;
    @Size(max = 6)
    @Column(name = "BQ088")
    private String bq088;
    @Column(name = "BQ089")
    private BigDecimal bq089;
    @Size(max = 1)
    @Column(name = "BQ090")
    private String bq090;
    @Size(max = 4)
    @Column(name = "BQ091")
    private String bq091;
    @Column(name = "BQ092")
    private BigDecimal bq092;
    @Size(max = 1)
    @Column(name = "BQ093")
    private String bq093;
    @Size(max = 4)
    @Column(name = "BQ094")
    private String bq094;
    @Size(max = 1)
    @Column(name = "BQ095")
    private String bq095;
    @Size(max = 1)
    @Column(name = "BQ096")
    private String bq096;
    @Column(name = "BQ097")
    private BigDecimal bq097;
    @Column(name = "BQ098")
    private BigDecimal bq098;
    @Column(name = "BQ099")
    private BigDecimal bq099;
    @Column(name = "BQ100")
    private BigDecimal bq100;
    @Column(name = "BQ101")
    private BigDecimal bq101;
    @Column(name = "BQ102")
    private BigDecimal bq102;
    @Column(name = "BQ103")
    private BigDecimal bq103;
    @Size(max = 4)
    @Column(name = "BQ104")
    private String bq104;
    @Size(max = 11)
    @Column(name = "BQ105")
    private String bq105;
    @Size(max = 4)
    @Column(name = "BQ106")
    private String bq106;
    @Size(max = 1)
    @Column(name = "BQ107")
    private String bq107;
    @Size(max = 4)
    @Column(name = "BQ108")
    private String bq108;
    @Size(max = 11)
    @Column(name = "BQ109")
    private String bq109;
    @Size(max = 10)
    @Column(name = "BQ110")
    private String bq110;
    @Size(max = 10)
    @Column(name = "BQ111")
    private String bq111;
    @Size(max = 30)
    @Column(name = "BQ112")
    private String bq112;
    @Size(max = 10)
    @Column(name = "BQ113")
    private String bq113;
    @Size(max = 10)
    @Column(name = "CUSTOMER")
    private String customer;
    @Size(max = 10)
    @Column(name = "PRODUCT")
    private String product;
    @Size(max = 10)
    @Column(name = "REGION")
    private String region;
    @Size(max = 10)
    @Column(name = "DEALER")
    private String dealer;
    @Size(max = 10)
    @Column(name = "BQ114")
    private String bq114;
    @Size(max = 8)
    @Column(name = "BQ115")
    private String bq115;
    @Size(max = 10)
    @Column(name = "BQ197")
    private String bq197;
    @Size(max = 10)
    @Column(name = "BQ198")
    private String bq198;
    @Size(max = 10)
    @Column(name = "BQ199")
    private String bq199;
    @Size(max = 255)
    @Column(name = "SERBQ01")
    private String serbq01;
    @Size(max = 255)
    @Column(name = "SERBQ02")
    private String serbq02;
    @Size(max = 255)
    @Column(name = "SERBQ03")
    private String serbq03;
    @Size(max = 255)
    @Column(name = "SERBQ04")
    private String serbq04;
    @Size(max = 255)
    @Column(name = "SERBQ05")
    private String serbq05;
    @Size(max = 255)
    @Column(name = "SERBQ06")
    private String serbq06;
    @Size(max = 255)
    @Column(name = "SERBQ07")
    private String serbq07;
    @Size(max = 255)
    @Column(name = "SERBQ08")
    private String serbq08;
    @Size(max = 255)
    @Column(name = "SERBQ09")
    private String serbq09;
    @Size(max = 255)
    @Column(name = "SERBQ10")
    private String serbq10;
    @Size(max = 255)
    @Column(name = "SERBQ11")
    private String serbq11;
    @Size(max = 255)
    @Column(name = "SERBQ12")
    private String serbq12;
    @Size(max = 255)
    @Column(name = "SERBQ13")
    private String serbq13;
    @Size(max = 255)
    @Column(name = "SERBQ14")
    private String serbq14;
    @Size(max = 255)
    @Column(name = "SERBQ15")
    private String serbq15;
    @Size(max = 255)
    @Column(name = "SERBQ16")
    private String serbq16;
    @Size(max = 255)
    @Column(name = "SERBQ17")
    private String serbq17;
    @Size(max = 255)
    @Column(name = "SERBQ18")
    private String serbq18;
    @Size(max = 255)
    @Column(name = "SERBQ19")
    private String serbq19;
    @Size(max = 255)
    @Column(name = "SERBQ20")
    private String serbq20;
    @Size(max = 1)
    @Column(name = "BQ116")
    private String bq116;
    @Size(max = 4)
    @Column(name = "BQ117")
    private String bq117;
    @Size(max = 11)
    @Column(name = "BQ118")
    private String bq118;
    @Size(max = 8)
    @Column(name = "BQ119")
    private String bq119;
    @Size(max = 10)
    @Column(name = "BQ120")
    private String bq120;
    @Size(max = 1)
    @Column(name = "BQ121")
    private String bq121;
    @Column(name = "BQ122")
    private BigDecimal bq122;
    @Column(name = "BQ123")
    private BigDecimal bq123;
    @Column(name = "BQ124")
    private BigDecimal bq124;
    @Column(name = "BQ125")
    private BigDecimal bq125;
    @Column(name = "BQ126")
    private BigDecimal bq126;
    @Column(name = "BQ127")
    private BigDecimal bq127;
    @Column(name = "BQ128")
    private BigDecimal bq128;
    @Size(max = 2)
    @Column(name = "BQ500")
    private String bq500;
    @Size(max = 1)
    @Column(name = "BQ501")
    private String bq501;
    @Size(max = 10)
    @Column(name = "BQ502")
    private String bq502;
    @Size(max = 1000)
    @Column(name = "BQ503")
    private String bq503;
    @Size(max = 10)
    @Column(name = "BQ504")
    private String bq504;
    @Size(max = 10)
    @Column(name = "BQ505")
    private String bq505;
    @Size(max = 50)
    @Column(name = "BQ506")
    private String bq506;
    @Size(max = 50)
    @Column(name = "BQ507")
    private String bq507;
    @Size(max = 50)
    @Column(name = "BQ510")
    private String bq510;
    public SERBQ() {
    }

    public SERBQ(String bq001) {
        this.bq001 = bq001;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUsrGroup() {
        return usrGroup;
    }

    public void setUsrGroup(String usrGroup) {
        this.usrGroup = usrGroup;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModiDate() {
        return modiDate;
    }

    public void setModiDate(String modiDate) {
        this.modiDate = modiDate;
    }

    public Short getFlag() {
        return flag;
    }

    public void setFlag(Short flag) {
        this.flag = flag;
    }

    public String getBq001() {
        return bq001;
    }

    public void setBq001(String bq001) {
        this.bq001 = bq001;
    }

    public String getBq002() {
        return bq002;
    }

    public void setBq002(String bq002) {
        this.bq002 = bq002;
    }

    public String getBq003() {
        return bq003;
    }

    public void setBq003(String bq003) {
        this.bq003 = bq003;
    }

    public String getBq004() {
        return bq004;
    }

    public void setBq004(String bq004) {
        this.bq004 = bq004;
    }

    public String getBq005() {
        return bq005;
    }

    public void setBq005(String bq005) {
        this.bq005 = bq005;
    }

    public String getBq006() {
        return bq006;
    }

    public void setBq006(String bq006) {
        this.bq006 = bq006;
    }

    public String getBq007() {
        return bq007;
    }

    public void setBq007(String bq007) {
        this.bq007 = bq007;
    }

    public String getBq008() {
        return bq008;
    }

    public void setBq008(String bq008) {
        this.bq008 = bq008;
    }

    public String getBq009() {
        return bq009;
    }

    public void setBq009(String bq009) {
        this.bq009 = bq009;
    }

    public String getBq010() {
        return bq010;
    }

    public void setBq010(String bq010) {
        this.bq010 = bq010;
    }

    public String getBq011() {
        return bq011;
    }

    public void setBq011(String bq011) {
        this.bq011 = bq011;
    }

    public String getBq012() {
        return bq012;
    }

    public void setBq012(String bq012) {
        this.bq012 = bq012;
    }

    public String getBq013() {
        return bq013;
    }

    public void setBq013(String bq013) {
        this.bq013 = bq013;
    }

    public String getBq014() {
        return bq014;
    }

    public void setBq014(String bq014) {
        this.bq014 = bq014;
    }

    public String getBq015() {
        return bq015;
    }

    public void setBq015(String bq015) {
        this.bq015 = bq015;
    }

    public String getBq016() {
        return bq016;
    }

    public void setBq016(String bq016) {
        this.bq016 = bq016;
    }

    public String getBq017() {
        return bq017;
    }

    public void setBq017(String bq017) {
        this.bq017 = bq017;
    }

    public String getBq018() {
        return bq018;
    }

    public void setBq018(String bq018) {
        this.bq018 = bq018;
    }

    public String getBq019() {
        return bq019;
    }

    public void setBq019(String bq019) {
        this.bq019 = bq019;
    }

    public String getBq020() {
        return bq020;
    }

    public void setBq020(String bq020) {
        this.bq020 = bq020;
    }

    public String getBq021() {
        return bq021;
    }

    public void setBq021(String bq021) {
        this.bq021 = bq021;
    }

    public String getBq022() {
        return bq022;
    }

    public void setBq022(String bq022) {
        this.bq022 = bq022;
    }

    public String getBq023() {
        return bq023;
    }

    public void setBq023(String bq023) {
        this.bq023 = bq023;
    }

    public String getBq024() {
        return bq024;
    }

    public void setBq024(String bq024) {
        this.bq024 = bq024;
    }

    public String getBq025() {
        return bq025;
    }

    public void setBq025(String bq025) {
        this.bq025 = bq025;
    }

    public String getBq026() {
        return bq026;
    }

    public void setBq026(String bq026) {
        this.bq026 = bq026;
    }

    public String getBq027() {
        return bq027;
    }

    public void setBq027(String bq027) {
        this.bq027 = bq027;
    }

    public String getBq028() {
        return bq028;
    }

    public void setBq028(String bq028) {
        this.bq028 = bq028;
    }

    public String getBq029() {
        return bq029;
    }

    public void setBq029(String bq029) {
        this.bq029 = bq029;
    }

    public String getBq030() {
        return bq030;
    }

    public void setBq030(String bq030) {
        this.bq030 = bq030;
    }

    public String getBq031() {
        return bq031;
    }

    public void setBq031(String bq031) {
        this.bq031 = bq031;
    }

    public String getBq032() {
        return bq032;
    }

    public void setBq032(String bq032) {
        this.bq032 = bq032;
    }

    public String getBq033() {
        return bq033;
    }

    public void setBq033(String bq033) {
        this.bq033 = bq033;
    }

    public String getBq034() {
        return bq034;
    }

    public void setBq034(String bq034) {
        this.bq034 = bq034;
    }

    public String getBq035() {
        return bq035;
    }

    public void setBq035(String bq035) {
        this.bq035 = bq035;
    }

    public String getBq036() {
        return bq036;
    }

    public void setBq036(String bq036) {
        this.bq036 = bq036;
    }

    public String getBq037() {
        return bq037;
    }

    public void setBq037(String bq037) {
        this.bq037 = bq037;
    }

    public String getBq038() {
        return bq038;
    }

    public void setBq038(String bq038) {
        this.bq038 = bq038;
    }

    public String getBq039() {
        return bq039;
    }

    public void setBq039(String bq039) {
        this.bq039 = bq039;
    }

    public String getBq040() {
        return bq040;
    }

    public void setBq040(String bq040) {
        this.bq040 = bq040;
    }

    public String getBq041() {
        return bq041;
    }

    public void setBq041(String bq041) {
        this.bq041 = bq041;
    }

    public BigDecimal getBq042() {
        return bq042;
    }

    public void setBq042(BigDecimal bq042) {
        this.bq042 = bq042;
    }

    public BigDecimal getBq043() {
        return bq043;
    }

    public void setBq043(BigDecimal bq043) {
        this.bq043 = bq043;
    }

    public String getBq044() {
        return bq044;
    }

    public void setBq044(String bq044) {
        this.bq044 = bq044;
    }

    public String getBq045() {
        return bq045;
    }

    public void setBq045(String bq045) {
        this.bq045 = bq045;
    }

    public String getBq046() {
        return bq046;
    }

    public void setBq046(String bq046) {
        this.bq046 = bq046;
    }

    public String getBq047() {
        return bq047;
    }

    public void setBq047(String bq047) {
        this.bq047 = bq047;
    }

    public String getBq048() {
        return bq048;
    }

    public void setBq048(String bq048) {
        this.bq048 = bq048;
    }

    public String getBq049() {
        return bq049;
    }

    public void setBq049(String bq049) {
        this.bq049 = bq049;
    }

    public String getBq050() {
        return bq050;
    }

    public void setBq050(String bq050) {
        this.bq050 = bq050;
    }

    public String getBq051() {
        return bq051;
    }

    public void setBq051(String bq051) {
        this.bq051 = bq051;
    }

    public String getBq052() {
        return bq052;
    }

    public void setBq052(String bq052) {
        this.bq052 = bq052;
    }

    public String getBq053() {
        return bq053;
    }

    public void setBq053(String bq053) {
        this.bq053 = bq053;
    }

    public String getBq054() {
        return bq054;
    }

    public void setBq054(String bq054) {
        this.bq054 = bq054;
    }

    public String getBq055() {
        return bq055;
    }

    public void setBq055(String bq055) {
        this.bq055 = bq055;
    }

    public String getBq056() {
        return bq056;
    }

    public void setBq056(String bq056) {
        this.bq056 = bq056;
    }

    public String getBq057() {
        return bq057;
    }

    public void setBq057(String bq057) {
        this.bq057 = bq057;
    }

    public String getBq058() {
        return bq058;
    }

    public void setBq058(String bq058) {
        this.bq058 = bq058;
    }

    public String getBq059() {
        return bq059;
    }

    public void setBq059(String bq059) {
        this.bq059 = bq059;
    }

    public String getBq060() {
        return bq060;
    }

    public void setBq060(String bq060) {
        this.bq060 = bq060;
    }

    public String getBq061() {
        return bq061;
    }

    public void setBq061(String bq061) {
        this.bq061 = bq061;
    }

    public String getBq062() {
        return bq062;
    }

    public void setBq062(String bq062) {
        this.bq062 = bq062;
    }

    public String getBq063() {
        return bq063;
    }

    public void setBq063(String bq063) {
        this.bq063 = bq063;
    }

    public String getBq064() {
        return bq064;
    }

    public void setBq064(String bq064) {
        this.bq064 = bq064;
    }

    public String getBq065() {
        return bq065;
    }

    public void setBq065(String bq065) {
        this.bq065 = bq065;
    }

    public String getBq066() {
        return bq066;
    }

    public void setBq066(String bq066) {
        this.bq066 = bq066;
    }

    public String getBq067() {
        return bq067;
    }

    public void setBq067(String bq067) {
        this.bq067 = bq067;
    }

    public BigDecimal getBq068() {
        return bq068;
    }

    public void setBq068(BigDecimal bq068) {
        this.bq068 = bq068;
    }

    public String getBq069() {
        return bq069;
    }

    public void setBq069(String bq069) {
        this.bq069 = bq069;
    }

    public String getBq070() {
        return bq070;
    }

    public void setBq070(String bq070) {
        this.bq070 = bq070;
    }

    public String getBq071() {
        return bq071;
    }

    public void setBq071(String bq071) {
        this.bq071 = bq071;
    }

    public String getBq072() {
        return bq072;
    }

    public void setBq072(String bq072) {
        this.bq072 = bq072;
    }

    public String getBq073() {
        return bq073;
    }

    public void setBq073(String bq073) {
        this.bq073 = bq073;
    }

    public String getBq074() {
        return bq074;
    }

    public void setBq074(String bq074) {
        this.bq074 = bq074;
    }

    public String getBq075() {
        return bq075;
    }

    public void setBq075(String bq075) {
        this.bq075 = bq075;
    }

    public String getBq076() {
        return bq076;
    }

    public void setBq076(String bq076) {
        this.bq076 = bq076;
    }

    public String getBq077() {
        return bq077;
    }

    public void setBq077(String bq077) {
        this.bq077 = bq077;
    }

    public String getBq078() {
        return bq078;
    }

    public void setBq078(String bq078) {
        this.bq078 = bq078;
    }

    public String getBq079() {
        return bq079;
    }

    public void setBq079(String bq079) {
        this.bq079 = bq079;
    }

    public String getBq080() {
        return bq080;
    }

    public void setBq080(String bq080) {
        this.bq080 = bq080;
    }

    public String getBq081() {
        return bq081;
    }

    public void setBq081(String bq081) {
        this.bq081 = bq081;
    }

    public String getBq082() {
        return bq082;
    }

    public void setBq082(String bq082) {
        this.bq082 = bq082;
    }

    public String getBq083() {
        return bq083;
    }

    public void setBq083(String bq083) {
        this.bq083 = bq083;
    }

    public String getBq084() {
        return bq084;
    }

    public void setBq084(String bq084) {
        this.bq084 = bq084;
    }

    public String getBq085() {
        return bq085;
    }

    public void setBq085(String bq085) {
        this.bq085 = bq085;
    }

    public String getBq086() {
        return bq086;
    }

    public void setBq086(String bq086) {
        this.bq086 = bq086;
    }

    public String getBq087() {
        return bq087;
    }

    public void setBq087(String bq087) {
        this.bq087 = bq087;
    }

    public String getBq088() {
        return bq088;
    }

    public void setBq088(String bq088) {
        this.bq088 = bq088;
    }

    public BigDecimal getBq089() {
        return bq089;
    }

    public void setBq089(BigDecimal bq089) {
        this.bq089 = bq089;
    }

    public String getBq090() {
        return bq090;
    }

    public void setBq090(String bq090) {
        this.bq090 = bq090;
    }

    public String getBq091() {
        return bq091;
    }

    public void setBq091(String bq091) {
        this.bq091 = bq091;
    }

    public BigDecimal getBq092() {
        return bq092;
    }

    public void setBq092(BigDecimal bq092) {
        this.bq092 = bq092;
    }

    public String getBq093() {
        return bq093;
    }

    public void setBq093(String bq093) {
        this.bq093 = bq093;
    }

    public String getBq094() {
        return bq094;
    }

    public void setBq094(String bq094) {
        this.bq094 = bq094;
    }

    public String getBq095() {
        return bq095;
    }

    public void setBq095(String bq095) {
        this.bq095 = bq095;
    }

    public String getBq096() {
        return bq096;
    }

    public void setBq096(String bq096) {
        this.bq096 = bq096;
    }

    public BigDecimal getBq097() {
        return bq097;
    }

    public void setBq097(BigDecimal bq097) {
        this.bq097 = bq097;
    }

    public BigDecimal getBq098() {
        return bq098;
    }

    public void setBq098(BigDecimal bq098) {
        this.bq098 = bq098;
    }

    public BigDecimal getBq099() {
        return bq099;
    }

    public void setBq099(BigDecimal bq099) {
        this.bq099 = bq099;
    }

    public BigDecimal getBq100() {
        return bq100;
    }

    public void setBq100(BigDecimal bq100) {
        this.bq100 = bq100;
    }

    public BigDecimal getBq101() {
        return bq101;
    }

    public void setBq101(BigDecimal bq101) {
        this.bq101 = bq101;
    }

    public BigDecimal getBq102() {
        return bq102;
    }

    public void setBq102(BigDecimal bq102) {
        this.bq102 = bq102;
    }

    public BigDecimal getBq103() {
        return bq103;
    }

    public void setBq103(BigDecimal bq103) {
        this.bq103 = bq103;
    }

    public String getBq104() {
        return bq104;
    }

    public void setBq104(String bq104) {
        this.bq104 = bq104;
    }

    public String getBq105() {
        return bq105;
    }

    public void setBq105(String bq105) {
        this.bq105 = bq105;
    }

    public String getBq106() {
        return bq106;
    }

    public void setBq106(String bq106) {
        this.bq106 = bq106;
    }

    public String getBq107() {
        return bq107;
    }

    public void setBq107(String bq107) {
        this.bq107 = bq107;
    }

    public String getBq108() {
        return bq108;
    }

    public void setBq108(String bq108) {
        this.bq108 = bq108;
    }

    public String getBq109() {
        return bq109;
    }

    public void setBq109(String bq109) {
        this.bq109 = bq109;
    }

    public String getBq110() {
        return bq110;
    }

    public void setBq110(String bq110) {
        this.bq110 = bq110;
    }

    public String getBq111() {
        return bq111;
    }

    public void setBq111(String bq111) {
        this.bq111 = bq111;
    }

    public String getBq112() {
        return bq112;
    }

    public void setBq112(String bq112) {
        this.bq112 = bq112;
    }

    public String getBq113() {
        return bq113;
    }

    public void setBq113(String bq113) {
        this.bq113 = bq113;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getBq114() {
        return bq114;
    }

    public void setBq114(String bq114) {
        this.bq114 = bq114;
    }

    public String getBq115() {
        return bq115;
    }

    public void setBq115(String bq115) {
        this.bq115 = bq115;
    }

    public String getBq197() {
        return bq197;
    }

    public void setBq197(String bq197) {
        this.bq197 = bq197;
    }

    public String getBq198() {
        return bq198;
    }

    public void setBq198(String bq198) {
        this.bq198 = bq198;
    }

    public String getBq199() {
        return bq199;
    }

    public void setBq199(String bq199) {
        this.bq199 = bq199;
    }

    public String getSerbq01() {
        return serbq01;
    }

    public void setSerbq01(String serbq01) {
        this.serbq01 = serbq01;
    }

    public String getSerbq02() {
        return serbq02;
    }

    public void setSerbq02(String serbq02) {
        this.serbq02 = serbq02;
    }

    public String getSerbq03() {
        return serbq03;
    }

    public void setSerbq03(String serbq03) {
        this.serbq03 = serbq03;
    }

    public String getSerbq04() {
        return serbq04;
    }

    public void setSerbq04(String serbq04) {
        this.serbq04 = serbq04;
    }

    public String getSerbq05() {
        return serbq05;
    }

    public void setSerbq05(String serbq05) {
        this.serbq05 = serbq05;
    }

    public String getSerbq06() {
        return serbq06;
    }

    public void setSerbq06(String serbq06) {
        this.serbq06 = serbq06;
    }

    public String getSerbq07() {
        return serbq07;
    }

    public void setSerbq07(String serbq07) {
        this.serbq07 = serbq07;
    }

    public String getSerbq08() {
        return serbq08;
    }

    public void setSerbq08(String serbq08) {
        this.serbq08 = serbq08;
    }

    public String getSerbq09() {
        return serbq09;
    }

    public void setSerbq09(String serbq09) {
        this.serbq09 = serbq09;
    }

    public String getSerbq10() {
        return serbq10;
    }

    public void setSerbq10(String serbq10) {
        this.serbq10 = serbq10;
    }

    public String getSerbq11() {
        return serbq11;
    }

    public void setSerbq11(String serbq11) {
        this.serbq11 = serbq11;
    }

    public String getSerbq12() {
        return serbq12;
    }

    public void setSerbq12(String serbq12) {
        this.serbq12 = serbq12;
    }

    public String getSerbq13() {
        return serbq13;
    }

    public void setSerbq13(String serbq13) {
        this.serbq13 = serbq13;
    }

    public String getSerbq14() {
        return serbq14;
    }

    public void setSerbq14(String serbq14) {
        this.serbq14 = serbq14;
    }

    public String getSerbq15() {
        return serbq15;
    }

    public void setSerbq15(String serbq15) {
        this.serbq15 = serbq15;
    }

    public String getSerbq16() {
        return serbq16;
    }

    public void setSerbq16(String serbq16) {
        this.serbq16 = serbq16;
    }

    public String getSerbq17() {
        return serbq17;
    }

    public void setSerbq17(String serbq17) {
        this.serbq17 = serbq17;
    }

    public String getSerbq18() {
        return serbq18;
    }

    public void setSerbq18(String serbq18) {
        this.serbq18 = serbq18;
    }

    public String getSerbq19() {
        return serbq19;
    }

    public void setSerbq19(String serbq19) {
        this.serbq19 = serbq19;
    }

    public String getSerbq20() {
        return serbq20;
    }

    public void setSerbq20(String serbq20) {
        this.serbq20 = serbq20;
    }

    public String getBq116() {
        return bq116;
    }

    public void setBq116(String bq116) {
        this.bq116 = bq116;
    }

    public String getBq117() {
        return bq117;
    }

    public void setBq117(String bq117) {
        this.bq117 = bq117;
    }

    public String getBq118() {
        return bq118;
    }

    public void setBq118(String bq118) {
        this.bq118 = bq118;
    }

    public String getBq119() {
        return bq119;
    }

    public void setBq119(String bq119) {
        this.bq119 = bq119;
    }

    public String getBq120() {
        return bq120;
    }

    public void setBq120(String bq120) {
        this.bq120 = bq120;
    }

    public String getBq121() {
        return bq121;
    }

    public void setBq121(String bq121) {
        this.bq121 = bq121;
    }

    public BigDecimal getBq122() {
        return bq122;
    }

    public void setBq122(BigDecimal bq122) {
        this.bq122 = bq122;
    }

    public BigDecimal getBq123() {
        return bq123;
    }

    public void setBq123(BigDecimal bq123) {
        this.bq123 = bq123;
    }

    public BigDecimal getBq124() {
        return bq124;
    }

    public void setBq124(BigDecimal bq124) {
        this.bq124 = bq124;
    }

    public BigDecimal getBq125() {
        return bq125;
    }

    public void setBq125(BigDecimal bq125) {
        this.bq125 = bq125;
    }

    public BigDecimal getBq126() {
        return bq126;
    }

    public void setBq126(BigDecimal bq126) {
        this.bq126 = bq126;
    }

    public BigDecimal getBq127() {
        return bq127;
    }

    public void setBq127(BigDecimal bq127) {
        this.bq127 = bq127;
    }

    public BigDecimal getBq128() {
        return bq128;
    }

    public void setBq128(BigDecimal bq128) {
        this.bq128 = bq128;
    }

    public String getBq500() {
        return bq500;
    }

    public void setBq500(String bq500) {
        this.bq500 = bq500;
    }

    public String getBq501() {
        return bq501;
    }

    public void setBq501(String bq501) {
        this.bq501 = bq501;
    }

    public String getBq502() {
        return bq502;
    }

    public void setBq502(String bq502) {
        this.bq502 = bq502;
    }

    public String getBq503() {
        return bq503;
    }

    public void setBq503(String bq503) {
        this.bq503 = bq503;
    }

    public String getBq504() {
        return bq504;
    }

    public void setBq504(String bq504) {
        this.bq504 = bq504;
    }

    public String getBq505() {
        return bq505;
    }

    public void setBq505(String bq505) {
        this.bq505 = bq505;
    }

    public String getBq506() {
        return bq506;
    }

    public void setBq506(String bq506) {
        this.bq506 = bq506;
    }

    public String getBq507() {
        return bq507;
    }

    public String getBq510() {
        return bq510;
    }

    public void setBq510(String bq510) {
        this.bq510 = bq510;
    }

    public void setBq507(String bq507) {
        this.bq507 = bq507;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bq001 != null ? bq001.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SERBQ)) {
            return false;
        }
        SERBQ other = (SERBQ) object;
        if ((this.bq001 == null && other.bq001 != null) || (this.bq001 != null && !this.bq001.equals(other.bq001))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.crm.entity.SERBQ[ bq001=" + bq001 + " ]";
    }

    public String getBq508() {
        return bq508;
    }

    public void setBq508(String bq508) {
        this.bq508 = bq508;
    }

}
