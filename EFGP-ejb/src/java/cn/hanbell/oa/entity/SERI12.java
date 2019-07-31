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
 * @author C1587
 */
@Entity
@Table(name = "SERI12")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SERI12.findAll", query = "SELECT s FROM SERI12 s"),
    @NamedQuery(name = "SERI12.findById", query = "SELECT s FROM SERI12 s WHERE s.bq001 = :bq001"),
    @NamedQuery(name = "SERI12.findByBq044", query = "SELECT s FROM SERI12 s WHERE s.bq044 = :bq044"),
    @NamedQuery(name = "SERI12.findByBq043", query = "SELECT s FROM SERI12 s WHERE s.bq043 = :bq043"),
    @NamedQuery(name = "SERI12.findByBq046", query = "SELECT s FROM SERI12 s WHERE s.bq046 = :bq046"),
    @NamedQuery(name = "SERI12.findByBq045", query = "SELECT s FROM SERI12 s WHERE s.bq045 = :bq045"),
    @NamedQuery(name = "SERI12.findByBq048", query = "SELECT s FROM SERI12 s WHERE s.bq048 = :bq048"),
    @NamedQuery(name = "SERI12.findByBq047", query = "SELECT s FROM SERI12 s WHERE s.bq047 = :bq047"),
    @NamedQuery(name = "SERI12.findByBq052", query = "SELECT s FROM SERI12 s WHERE s.bq052 = :bq052"),
    @NamedQuery(name = "SERI12.findByBq057", query = "SELECT s FROM SERI12 s WHERE s.bq057 = :bq057"),
    @NamedQuery(name = "SERI12.findByBq056", query = "SELECT s FROM SERI12 s WHERE s.bq056 = :bq056"),
    @NamedQuery(name = "SERI12.findByBq055", query = "SELECT s FROM SERI12 s WHERE s.bq055 = :bq055"),
    @NamedQuery(name = "SERI12.findByBq054", query = "SELECT s FROM SERI12 s WHERE s.bq054 = :bq054"),
    @NamedQuery(name = "SERI12.findByBq058", query = "SELECT s FROM SERI12 s WHERE s.bq058 = :bq058"),
    @NamedQuery(name = "SERI12.findByBq060", query = "SELECT s FROM SERI12 s WHERE s.bq060 = :bq060"),
    @NamedQuery(name = "SERI12.findByBq046c", query = "SELECT s FROM SERI12 s WHERE s.bq046c = :bq046c"),
    @NamedQuery(name = "SERI12.findByBq061", query = "SELECT s FROM SERI12 s WHERE s.bq061 = :bq061"),
    @NamedQuery(name = "SERI12.findByBq017c", query = "SELECT s FROM SERI12 s WHERE s.bq017c = :bq017c"),
    @NamedQuery(name = "SERI12.findByBq014c1", query = "SELECT s FROM SERI12 s WHERE s.bq014c1 = :bq014c1"),
    @NamedQuery(name = "SERI12.findByBq014c2", query = "SELECT s FROM SERI12 s WHERE s.bq014c2 = :bq014c2"),
    @NamedQuery(name = "SERI12.findByBq027c", query = "SELECT s FROM SERI12 s WHERE s.bq027c = :bq027c"),
    @NamedQuery(name = "SERI12.findByBq110", query = "SELECT s FROM SERI12 s WHERE s.bq110 = :bq110"),
    @NamedQuery(name = "SERI12.findByBq033c", query = "SELECT s FROM SERI12 s WHERE s.bq033c = :bq033c"),
    @NamedQuery(name = "SERI12.findByBq091c", query = "SELECT s FROM SERI12 s WHERE s.bq091c = :bq091c"),
    @NamedQuery(name = "SERI12.findByBq113", query = "SELECT s FROM SERI12 s WHERE s.bq113 = :bq113"),
    @NamedQuery(name = "SERI12.findByEdBQ097", query = "SELECT s FROM SERI12 s WHERE s.edBQ097 = :edBQ097"),
    @NamedQuery(name = "SERI12.findByPSN", query = "SELECT s FROM SERI12 s WHERE s.processSerialNumber = :psn"),
    @NamedQuery(name = "SERI12.findByBq199c", query = "SELECT s FROM SERI12 s WHERE s.bq199c = :bq199c"),
    @NamedQuery(name = "SERI12.findByBq016c", query = "SELECT s FROM SERI12 s WHERE s.bq016c = :bq016c"),
    @NamedQuery(name = "SERI12.findByBq101", query = "SELECT s FROM SERI12 s WHERE s.bq101 = :bq101"),
    @NamedQuery(name = "SERI12.findByBq100", query = "SELECT s FROM SERI12 s WHERE s.bq100 = :bq100"),
    @NamedQuery(name = "SERI12.findByBq113c", query = "SELECT s FROM SERI12 s WHERE s.bq113c = :bq113c"),
    @NamedQuery(name = "SERI12.findByBq105", query = "SELECT s FROM SERI12 s WHERE s.bq105 = :bq105"),
    @NamedQuery(name = "SERI12.findByBq104", query = "SELECT s FROM SERI12 s WHERE s.bq104 = :bq104"),
    @NamedQuery(name = "SERI12.findByBq103", query = "SELECT s FROM SERI12 s WHERE s.bq103 = :bq103"),
    @NamedQuery(name = "SERI12.findByBq102", query = "SELECT s FROM SERI12 s WHERE s.bq102 = :bq102"),
    @NamedQuery(name = "SERI12.findByBq109", query = "SELECT s FROM SERI12 s WHERE s.bq109 = :bq109"),
    @NamedQuery(name = "SERI12.findByBq108", query = "SELECT s FROM SERI12 s WHERE s.bq108 = :bq108"),
    @NamedQuery(name = "SERI12.findByBq107", query = "SELECT s FROM SERI12 s WHERE s.bq107 = :bq107"),
    @NamedQuery(name = "SERI12.findByBq106", query = "SELECT s FROM SERI12 s WHERE s.bq106 = :bq106"),
    @NamedQuery(name = "SERI12.findByBq198c", query = "SELECT s FROM SERI12 s WHERE s.bq198c = :bq198c"),
    @NamedQuery(name = "SERI12.findByBq019c", query = "SELECT s FROM SERI12 s WHERE s.bq019c = :bq019c"),
    @NamedQuery(name = "SERI12.findByBq088", query = "SELECT s FROM SERI12 s WHERE s.bq088 = :bq088"),
    @NamedQuery(name = "SERI12.findByBq089", query = "SELECT s FROM SERI12 s WHERE s.bq089 = :bq089"),
    @NamedQuery(name = "SERI12.findByBq040", query = "SELECT s FROM SERI12 s WHERE s.bq040 = :bq040"),
    @NamedQuery(name = "SERI12.findByBq042", query = "SELECT s FROM SERI12 s WHERE s.bq042 = :bq042"),
    @NamedQuery(name = "SERI12.findByBq041", query = "SELECT s FROM SERI12 s WHERE s.bq041 = :bq041"),
    @NamedQuery(name = "SERI12.findByBq091", query = "SELECT s FROM SERI12 s WHERE s.bq091 = :bq091"),
    @NamedQuery(name = "SERI12.findByBq032", query = "SELECT s FROM SERI12 s WHERE s.bq032 = :bq032"),
    @NamedQuery(name = "SERI12.findByBq090", query = "SELECT s FROM SERI12 s WHERE s.bq090 = :bq090"),
    @NamedQuery(name = "SERI12.findByBq033", query = "SELECT s FROM SERI12 s WHERE s.bq033 = :bq033"),
    @NamedQuery(name = "SERI12.findByBq093", query = "SELECT s FROM SERI12 s WHERE s.bq093 = :bq093"),
    @NamedQuery(name = "SERI12.findByBq034", query = "SELECT s FROM SERI12 s WHERE s.bq034 = :bq034"),
    @NamedQuery(name = "SERI12.findByBq092", query = "SELECT s FROM SERI12 s WHERE s.bq092 = :bq092"),
    @NamedQuery(name = "SERI12.findByBq035", query = "SELECT s FROM SERI12 s WHERE s.bq035 = :bq035"),
    @NamedQuery(name = "SERI12.findByBq095", query = "SELECT s FROM SERI12 s WHERE s.bq095 = :bq095"),
    @NamedQuery(name = "SERI12.findByBq041c", query = "SELECT s FROM SERI12 s WHERE s.bq041c = :bq041c"),
    @NamedQuery(name = "SERI12.findByBq036", query = "SELECT s FROM SERI12 s WHERE s.bq036 = :bq036"),
    @NamedQuery(name = "SERI12.findByBq094", query = "SELECT s FROM SERI12 s WHERE s.bq094 = :bq094"),
    @NamedQuery(name = "SERI12.findByBq037", query = "SELECT s FROM SERI12 s WHERE s.bq035h = 'Y' AND s.bq110 = 'Y' AND  s.bq037 BETWEEN :begin and :end"),
    @NamedQuery(name = "SERI12.findByBq038", query = "SELECT s FROM SERI12 s WHERE s.bq038 = :bq038"),
    @NamedQuery(name = "SERI12.findByLbl002", query = "SELECT s FROM SERI12 s WHERE s.lbl002 = :lbl002"),
    @NamedQuery(name = "SERI12.findByBq096", query = "SELECT s FROM SERI12 s WHERE s.bq096 = :bq096"),
    @NamedQuery(name = "SERI12.findByBq039", query = "SELECT s FROM SERI12 s WHERE s.bq039 = :bq039"),
    @NamedQuery(name = "SERI12.findByBq005c", query = "SELECT s FROM SERI12 s WHERE s.bq005c = :bq005c"),
    @NamedQuery(name = "SERI12.findByBq094c", query = "SELECT s FROM SERI12 s WHERE s.bq094c = :bq094c"),
    @NamedQuery(name = "SERI12.findByBq098", query = "SELECT s FROM SERI12 s WHERE s.bq098 = :bq098"),
    @NamedQuery(name = "SERI12.findByBq099", query = "SELECT s FROM SERI12 s WHERE s.bq099 = :bq099"),
    @NamedQuery(name = "SERI12.findByBq018c", query = "SELECT s FROM SERI12 s WHERE s.bq018c = :bq018c"),
    @NamedQuery(name = "SERI12.findByBq031", query = "SELECT s FROM SERI12 s WHERE s.bq031 = :bq031"),
    @NamedQuery(name = "SERI12.findByBq023c", query = "SELECT s FROM SERI12 s WHERE s.bq023c = :bq023c"),
    @NamedQuery(name = "SERI12.findByBq023", query = "SELECT s FROM SERI12 s WHERE s.bq023 = :bq023"),
    @NamedQuery(name = "SERI12.findByBq024", query = "SELECT s FROM SERI12 s WHERE s.bq024 = :bq024"),
    @NamedQuery(name = "SERI12.findByBq021", query = "SELECT s FROM SERI12 s WHERE s.bq021 = :bq021"),
    @NamedQuery(name = "SERI12.findByBq022", query = "SELECT s FROM SERI12 s WHERE s.bq022 = :bq022"),
    @NamedQuery(name = "SERI12.findByBq027", query = "SELECT s FROM SERI12 s WHERE s.bq027 = :bq027"),
    @NamedQuery(name = "SERI12.findByBq025", query = "SELECT s FROM SERI12 s WHERE s.bq025 = :bq025"),
    @NamedQuery(name = "SERI12.findByBq026", query = "SELECT s FROM SERI12 s WHERE s.bq026 = :bq026"),
    @NamedQuery(name = "SERI12.findByBq032c", query = "SELECT s FROM SERI12 s WHERE s.bq032c = :bq032c"),
    @NamedQuery(name = "SERI12.findByOID", query = "SELECT s FROM SERI12 s WHERE s.oid = :oid"),
    @NamedQuery(name = "SERI12.findByBq002c", query = "SELECT s FROM SERI12 s WHERE s.bq002c = :bq002c"),
    @NamedQuery(name = "SERI12.findByBq014", query = "SELECT s FROM SERI12 s WHERE s.bq014 = :bq014"),
    @NamedQuery(name = "SERI12.findByBq016", query = "SELECT s FROM SERI12 s WHERE s.bq016 = :bq016"),
    @NamedQuery(name = "SERI12.findByBq017", query = "SELECT s FROM SERI12 s WHERE s.bq017 = :bq017"),
    @NamedQuery(name = "SERI12.findByBq010", query = "SELECT s FROM SERI12 s WHERE s.bq010 = :bq010"),
    @NamedQuery(name = "SERI12.findByBq011", query = "SELECT s FROM SERI12 s WHERE s.bq011 = :bq011"),
    @NamedQuery(name = "SERI12.findByBq012", query = "SELECT s FROM SERI12 s WHERE s.bq012 = :bq012"),
    @NamedQuery(name = "SERI12.findByBq038c", query = "SELECT s FROM SERI12 s WHERE s.bq038c = :bq038c"),
    @NamedQuery(name = "SERI12.findByBq013", query = "SELECT s FROM SERI12 s WHERE s.bq013 = :bq013"),
    @NamedQuery(name = "SERI12.findByBq197", query = "SELECT s FROM SERI12 s WHERE s.bq197 = :bq197"),
    @NamedQuery(name = "SERI12.findByBq018", query = "SELECT s FROM SERI12 s WHERE s.bq018 = :bq018"),
    @NamedQuery(name = "SERI12.findByBq003c", query = "SELECT s FROM SERI12 s WHERE s.bq003c = :bq003c"),
    @NamedQuery(name = "SERI12.findByBq198", query = "SELECT s FROM SERI12 s WHERE s.bq198 = :bq198"),
    @NamedQuery(name = "SERI12.findByBq019", query = "SELECT s FROM SERI12 s WHERE s.bq019 = :bq019"),
    @NamedQuery(name = "SERI12.findByBq199", query = "SELECT s FROM SERI12 s WHERE s.bq199 = :bq199"),
    @NamedQuery(name = "SERI12.findByBq197c", query = "SELECT s FROM SERI12 s WHERE s.bq197c = :bq197c"),
    @NamedQuery(name = "SERI12.findByBq005", query = "SELECT s FROM SERI12 s WHERE s.bq005 = :bq005"),
    @NamedQuery(name = "SERI12.findByBq006", query = "SELECT s FROM SERI12 s WHERE s.bq006 = :bq006"),
    @NamedQuery(name = "SERI12.findByBq003", query = "SELECT s FROM SERI12 s WHERE s.bq003 = :bq003"),
    @NamedQuery(name = "SERI12.findByBq039c", query = "SELECT s FROM SERI12 s WHERE s.bq039c = :bq039c"),
    @NamedQuery(name = "SERI12.findByBq001", query = "SELECT s FROM SERI12 s WHERE s.bq035h = 'Y' AND s.bq110 = 'Y' AND  s.bq001 = :bq001"),
    @NamedQuery(name = "SERI12.findByBq002", query = "SELECT s FROM SERI12 s WHERE s.bq002 = :bq002"),
    @NamedQuery(name = "SERI12.findByBq009", query = "SELECT s FROM SERI12 s WHERE s.bq009 = :bq009"),
    @NamedQuery(name = "SERI12.findByBq007", query = "SELECT s FROM SERI12 s WHERE s.bq007 = :bq007"),
    @NamedQuery(name = "SERI12.findByFSN", query = "SELECT s FROM SERI12 s WHERE s.formSerialNumber = :fsn"),
    @NamedQuery(name = "SERI12.findByBq008", query = "SELECT s FROM SERI12 s WHERE s.bq008 = :bq008"),
    @NamedQuery(name = "SERI12.findByFacno", query = "SELECT s FROM SERI12 s WHERE s.facno = :facno"),
    @NamedQuery(name = "SERI12.findByBq035h", query = "SELECT s FROM SERI12 s WHERE s.bq035h = :bq035h")})
public class SERI12 implements Serializable {

    @Size(max = 255)
    @Column(name = "propotion")
    private String propotion;
    @Size(max = 255)
    @Column(name = "BQ135C")
    private String bq135c;
    @Size(max = 255)
    @Column(name = "BQ508")
    private String bq508;

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "BQ044")
    private String bq044;
    @Size(max = 255)
    @Column(name = "BQ043")
    private String bq043;
    @Size(max = 255)
    @Column(name = "BQ046")
    private String bq046;
    @Size(max = 255)
    @Column(name = "BQ045")
    private String bq045;
    @Size(max = 255)
    @Column(name = "BQ048")
    private String bq048;
    @Size(max = 255)
    @Column(name = "BQ047")
    private String bq047;
    @Size(max = 255)
    @Column(name = "BQ130H")
    private String bq130h;
    @Size(max = 255)
    @Column(name = "BQ052")
    private String bq052;
    @Size(max = 255)
    @Column(name = "BQ057")
    private String bq057;
    @Size(max = 255)
    @Column(name = "BQ056")
    private String bq056;
    @Size(max = 255)
    @Column(name = "BQ055")
    private String bq055;
    @Size(max = 255)
    @Column(name = "BQ054")
    private String bq054;
    @Size(max = 255)
    @Column(name = "BQ058")
    private String bq058;
    @Size(max = 255)
    @Column(name = "BQ060")
    private String bq060;
    @Size(max = 255)
    @Column(name = "BQ046C")
    private String bq046c;
    @Size(max = 255)
    @Column(name = "BQ061")
    private String bq061;
    @Size(max = 255)
    @Column(name = "BQ017C")
    private String bq017c;
    @Size(max = 255)
    @Column(name = "BQ014C1")
    private String bq014c1;
    @Size(max = 255)
    @Column(name = "BQ014C2")
    private String bq014c2;
    @Size(max = 255)
    @Column(name = "BQ027C")
    private String bq027c;
    @Size(max = 255)
    @Column(name = "BQ110")
    private String bq110;
    @Size(max = 255)
    @Column(name = "BQ033C")
    private String bq033c;
    @Size(max = 255)
    @Column(name = "BQ091C")
    private String bq091c;
    @Size(max = 255)
    @Column(name = "BQ113")
    private String bq113;
    @Size(max = 255)
    @Column(name = "edBQ097")
    private String edBQ097;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "BQ199C")
    private String bq199c;
    @Size(max = 255)
    @Column(name = "BQ016C")
    private String bq016c;
    @Size(max = 255)
    @Column(name = "BQ101")
    private String bq101;
    @Size(max = 255)
    @Column(name = "BQ100")
    private String bq100;
    @Size(max = 255)
    @Column(name = "BQ113C")
    private String bq113c;
    @Size(max = 255)
    @Column(name = "BQ105")
    private String bq105;
    @Size(max = 255)
    @Column(name = "BQ104")
    private String bq104;
    @Size(max = 255)
    @Column(name = "BQ103")
    private String bq103;
    @Size(max = 255)
    @Column(name = "BQ102")
    private String bq102;
    @Size(max = 255)
    @Column(name = "BQ109")
    private String bq109;
    @Size(max = 255)
    @Column(name = "BQ108")
    private String bq108;
    @Size(max = 255)
    @Column(name = "BQ107")
    private String bq107;
    @Size(max = 255)
    @Column(name = "BQ106")
    private String bq106;
    @Size(max = 255)
    @Column(name = "BQ198C")
    private String bq198c;
    @Size(max = 255)
    @Column(name = "BQ506C")
    private String bq506c;
    @Size(max = 255)
    @Column(name = "BQ019C")
    private String bq019c;
    @Size(max = 255)
    @Column(name = "BQ088")
    private String bq088;
    @Size(max = 255)
    @Column(name = "BQ089")
    private String bq089;
    @Size(max = 255)
    @Column(name = "BQ040")
    private String bq040;
    @Size(max = 255)
    @Column(name = "BQ042")
    private String bq042;
    @Size(max = 255)
    @Column(name = "BQ041")
    private String bq041;
    @Size(max = 255)
    @Column(name = "BQ091")
    private String bq091;
    @Size(max = 255)
    @Column(name = "BQ032")
    private String bq032;
    @Size(max = 255)
    @Column(name = "BQ090")
    private String bq090;
    @Size(max = 255)
    @Column(name = "BQ033")
    private String bq033;
    @Size(max = 255)
    @Column(name = "BQ093")
    private String bq093;
    @Size(max = 255)
    @Column(name = "BQ034")
    private String bq034;
    @Size(max = 255)
    @Column(name = "BQ092")
    private String bq092;
    @Size(max = 255)
    @Column(name = "BQ035")
    private String bq035;
    @Size(max = 255)
    @Column(name = "BQ095")
    private String bq095;
    @Size(max = 255)
    @Column(name = "BQ041C")
    private String bq041c;
    @Size(max = 255)
    @Column(name = "BQ036")
    private String bq036;
    @Size(max = 255)
    @Column(name = "BQ094")
    private String bq094;
    @Size(max = 255)
    @Column(name = "BQ037")
    private String bq037;
    @Size(max = 255)
    @Column(name = "BQ038")
    private String bq038;
    @Size(max = 255)
    @Column(name = "lbl002")
    private String lbl002;
    @Size(max = 255)
    @Column(name = "BQ096")
    private String bq096;
    @Size(max = 255)
    @Column(name = "BQ039")
    private String bq039;
    @Size(max = 255)
    @Column(name = "BQ506")
    private String bq506;
    @Size(max = 255)
    @Column(name = "BQ507")
    private String bq507;
    @Size(max = 255)
    @Column(name = "BQ005C")
    private String bq005c;
    @Size(max = 255)
    @Column(name = "BQ502")
    private String bq502;
    @Size(max = 255)
    @Column(name = "BQ503")
    private String bq503;
    @Size(max = 255)
    @Column(name = "BQ504")
    private String bq504;
    @Size(max = 255)
    @Column(name = "BQ505")
    private String bq505;
    @Size(max = 255)
    @Column(name = "BQ501")
    private String bq501;
    @Size(max = 255)
    @Column(name = "BQ507C")
    private String bq507c;
    @Size(max = 255)
    @Column(name = "BQ094C")
    private String bq094c;
    @Size(max = 255)
    @Column(name = "BQ098")
    private String bq098;
    @Size(max = 255)
    @Column(name = "BQ099")
    private String bq099;
    @Size(max = 255)
    @Column(name = "BQ018C")
    private String bq018c;
    @Size(max = 255)
    @Column(name = "BQ031")
    private String bq031;
    @Size(max = 255)
    @Column(name = "BQ023C")
    private String bq023c;
    @Size(max = 255)
    @Column(name = "BQ023")
    private String bq023;
    @Size(max = 255)
    @Column(name = "BQ024")
    private String bq024;
    @Size(max = 255)
    @Column(name = "BQ021")
    private String bq021;
    @Size(max = 255)
    @Column(name = "BQ022")
    private String bq022;
    @Size(max = 255)
    @Column(name = "BQ027")
    private String bq027;
    @Size(max = 255)
    @Column(name = "BQ025")
    private String bq025;
    @Size(max = 255)
    @Column(name = "BQ500")
    private String bq500;
    @Size(max = 255)
    @Column(name = "BQ026")
    private String bq026;
    @Size(max = 255)
    @Column(name = "BQ032C")
    private String bq032c;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "BQ002C")
    private String bq002c;
    @Size(max = 255)
    @Column(name = "BQ014")
    private String bq014;
    @Size(max = 255)
    @Column(name = "BQ016")
    private String bq016;
    @Size(max = 255)
    @Column(name = "BQ017")
    private String bq017;
    @Size(max = 255)
    @Column(name = "BQ010")
    private String bq010;
    @Size(max = 255)
    @Column(name = "BQ011")
    private String bq011;
    @Size(max = 255)
    @Column(name = "BQ012")
    private String bq012;
    @Size(max = 255)
    @Column(name = "BQ038C")
    private String bq038c;
    @Size(max = 255)
    @Column(name = "BQ013")
    private String bq013;
    @Size(max = 255)
    @Column(name = "BQ197")
    private String bq197;
    @Size(max = 255)
    @Column(name = "BQ018")
    private String bq018;
    @Size(max = 255)
    @Column(name = "BQ003C")
    private String bq003c;
    @Size(max = 255)
    @Column(name = "BQ198")
    private String bq198;
    @Size(max = 255)
    @Column(name = "BQ019")
    private String bq019;
    @Size(max = 255)
    @Column(name = "BQ199")
    private String bq199;
    @Size(max = 255)
    @Column(name = "BQ197C")
    private String bq197c;
    @Size(max = 255)
    @Column(name = "BQ005")
    private String bq005;
    @Size(max = 255)
    @Column(name = "BQ006")
    private String bq006;
    @Size(max = 255)
    @Column(name = "BQ003")
    private String bq003;
    @Size(max = 255)
    @Column(name = "BQ039C")
    private String bq039c;
    @Size(max = 255)
    @Column(name = "BQ001")
    private String bq001;
    @Size(max = 255)
    @Column(name = "BQ002")
    private String bq002;
    @Size(max = 255)
    @Column(name = "BQ009")
    private String bq009;
    @Size(max = 255)
    @Column(name = "BQ007")
    private String bq007;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "BQ008")
    private String bq008;
    @Size(max = 255)
    @Column(name = "BQ501H")
    private String bq501h;
    @Size(max = 255)
    @Column(name = "BQ504C")
    private String bq504c;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "BQ035H")
    private String bq035h;
    @Size(max = 255)
    @Column(name = "BQ129")
    private String bq129;
    @Size(max = 255)
    @Column(name = "BQ130")
    private String bq130;
    @Size(max = 255)
    @Column(name = "BQ131")
    private String bq131;
    @Size(max = 255)
    @Column(name = "BQ132")
    private String bq132;
    @Size(max = 255)
    @Column(name = "BQ133")
    private String bq133;
    @Size(max = 255)
    @Column(name = "BQ134")
    private String bq134;
    @Size(max = 255)
    @Column(name = "BQ135")
    private String bq135;
    @Size(max = 255)
    @Column(name = "BQ136")
    private String bq136;

    public SERI12() {
    }

    public SERI12(String oid) {
        this.oid = oid;
    }

    public String getBq044() {
        return bq044;
    }

    public void setBq044(String bq044) {
        this.bq044 = bq044;
    }

    public String getBq043() {
        return bq043;
    }

    public void setBq043(String bq043) {
        this.bq043 = bq043;
    }

    public String getBq046() {
        return bq046;
    }

    public void setBq046(String bq046) {
        this.bq046 = bq046;
    }

    public String getBq045() {
        return bq045;
    }

    public void setBq045(String bq045) {
        this.bq045 = bq045;
    }

    public String getBq048() {
        return bq048;
    }

    public void setBq048(String bq048) {
        this.bq048 = bq048;
    }

    public String getBq047() {
        return bq047;
    }

    public void setBq047(String bq047) {
        this.bq047 = bq047;
    }

    /**
     * @return the bq130h
     */
    public String getBq130h() {
        return bq130h;
    }

    /**
     * @param bq130h the bq130h to set
     */
    public void setBq130h(String bq130h) {
        this.bq130h = bq130h;
    }

    public String getBq052() {
        return bq052;
    }

    public void setBq052(String bq052) {
        this.bq052 = bq052;
    }

    public String getBq057() {
        return bq057;
    }

    public void setBq057(String bq057) {
        this.bq057 = bq057;
    }

    public String getBq056() {
        return bq056;
    }

    public void setBq056(String bq056) {
        this.bq056 = bq056;
    }

    public String getBq055() {
        return bq055;
    }

    public void setBq055(String bq055) {
        this.bq055 = bq055;
    }

    public String getBq054() {
        return bq054;
    }

    public void setBq054(String bq054) {
        this.bq054 = bq054;
    }

    public String getBq058() {
        return bq058;
    }

    public void setBq058(String bq058) {
        this.bq058 = bq058;
    }

    public String getBq060() {
        return bq060;
    }

    public void setBq060(String bq060) {
        this.bq060 = bq060;
    }

    public String getBq046c() {
        return bq046c;
    }

    public void setBq046c(String bq046c) {
        this.bq046c = bq046c;
    }

    public String getBq061() {
        return bq061;
    }

    public void setBq061(String bq061) {
        this.bq061 = bq061;
    }

    public String getBq017c() {
        return bq017c;
    }

    public void setBq017c(String bq017c) {
        this.bq017c = bq017c;
    }

    public String getBq014c1() {
        return bq014c1;
    }

    public void setBq014c1(String bq014c1) {
        this.bq014c1 = bq014c1;
    }

    public String getBq014c2() {
        return bq014c2;
    }

    public void setBq014c2(String bq014c2) {
        this.bq014c2 = bq014c2;
    }

    public String getBq027c() {
        return bq027c;
    }

    public void setBq027c(String bq027c) {
        this.bq027c = bq027c;
    }

    public String getBq110() {
        return bq110;
    }

    public void setBq110(String bq110) {
        this.bq110 = bq110;
    }

    public String getBq033c() {
        return bq033c;
    }

    public void setBq033c(String bq033c) {
        this.bq033c = bq033c;
    }

    public String getBq091c() {
        return bq091c;
    }

    public void setBq091c(String bq091c) {
        this.bq091c = bq091c;
    }

    public String getBq113() {
        return bq113;
    }

    public void setBq113(String bq113) {
        this.bq113 = bq113;
    }

    public String getEdBQ097() {
        return edBQ097;
    }

    public void setEdBQ097(String edBQ097) {
        this.edBQ097 = edBQ097;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getBq199c() {
        return bq199c;
    }

    public void setBq199c(String bq199c) {
        this.bq199c = bq199c;
    }

    public String getBq016c() {
        return bq016c;
    }

    public void setBq016c(String bq016c) {
        this.bq016c = bq016c;
    }

    public String getBq101() {
        return bq101;
    }

    public void setBq101(String bq101) {
        this.bq101 = bq101;
    }

    public String getBq100() {
        return bq100;
    }

    public void setBq100(String bq100) {
        this.bq100 = bq100;
    }

    public String getBq113c() {
        return bq113c;
    }

    public void setBq113c(String bq113c) {
        this.bq113c = bq113c;
    }

    public String getBq105() {
        return bq105;
    }

    public void setBq105(String bq105) {
        this.bq105 = bq105;
    }

    public String getBq104() {
        return bq104;
    }

    public void setBq104(String bq104) {
        this.bq104 = bq104;
    }

    public String getBq103() {
        return bq103;
    }

    public void setBq103(String bq103) {
        this.bq103 = bq103;
    }

    public String getBq102() {
        return bq102;
    }

    public void setBq102(String bq102) {
        this.bq102 = bq102;
    }

    public String getBq109() {
        return bq109;
    }

    public void setBq109(String bq109) {
        this.bq109 = bq109;
    }

    public String getBq108() {
        return bq108;
    }

    public void setBq108(String bq108) {
        this.bq108 = bq108;
    }

    public String getBq107() {
        return bq107;
    }

    public void setBq107(String bq107) {
        this.bq107 = bq107;
    }

    public String getBq106() {
        return bq106;
    }

    public void setBq106(String bq106) {
        this.bq106 = bq106;
    }

    public String getBq198c() {
        return bq198c;
    }

    public void setBq198c(String bq198c) {
        this.bq198c = bq198c;
    }

    public String getBq019c() {
        return bq019c;
    }

    public void setBq019c(String bq019c) {
        this.bq019c = bq019c;
    }

    public String getBq088() {
        return bq088;
    }

    public void setBq088(String bq088) {
        this.bq088 = bq088;
    }

    public String getBq089() {
        return bq089;
    }

    public void setBq089(String bq089) {
        this.bq089 = bq089;
    }

    public String getBq040() {
        return bq040;
    }

    public void setBq040(String bq040) {
        this.bq040 = bq040;
    }

    public String getBq042() {
        return bq042;
    }

    public void setBq042(String bq042) {
        this.bq042 = bq042;
    }

    public String getBq041() {
        return bq041;
    }

    public void setBq041(String bq041) {
        this.bq041 = bq041;
    }

    public String getBq091() {
        return bq091;
    }

    public void setBq091(String bq091) {
        this.bq091 = bq091;
    }

    public String getBq032() {
        return bq032;
    }

    public void setBq032(String bq032) {
        this.bq032 = bq032;
    }

    public String getBq090() {
        return bq090;
    }

    public void setBq090(String bq090) {
        this.bq090 = bq090;
    }

    public String getBq033() {
        return bq033;
    }

    public void setBq033(String bq033) {
        this.bq033 = bq033;
    }

    public String getBq093() {
        return bq093;
    }

    public void setBq093(String bq093) {
        this.bq093 = bq093;
    }

    public String getBq034() {
        return bq034;
    }

    public void setBq034(String bq034) {
        this.bq034 = bq034;
    }

    public String getBq092() {
        return bq092;
    }

    public void setBq092(String bq092) {
        this.bq092 = bq092;
    }

    public String getBq035() {
        return bq035;
    }

    public void setBq035(String bq035) {
        this.bq035 = bq035;
    }

    public String getBq095() {
        return bq095;
    }

    public void setBq095(String bq095) {
        this.bq095 = bq095;
    }

    public String getBq041c() {
        return bq041c;
    }

    public void setBq041c(String bq041c) {
        this.bq041c = bq041c;
    }

    public String getBq036() {
        return bq036;
    }

    public void setBq036(String bq036) {
        this.bq036 = bq036;
    }

    public String getBq094() {
        return bq094;
    }

    public void setBq094(String bq094) {
        this.bq094 = bq094;
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

    public String getLbl002() {
        return lbl002;
    }

    public void setLbl002(String lbl002) {
        this.lbl002 = lbl002;
    }

    public String getBq096() {
        return bq096;
    }

    public void setBq096(String bq096) {
        this.bq096 = bq096;
    }

    public String getBq039() {
        return bq039;
    }

    public void setBq039(String bq039) {
        this.bq039 = bq039;
    }

    public String getBq005c() {
        return bq005c;
    }

    public void setBq005c(String bq005c) {
        this.bq005c = bq005c;
    }

    public String getBq094c() {
        return bq094c;
    }

    public void setBq094c(String bq094c) {
        this.bq094c = bq094c;
    }

    public String getBq098() {
        return bq098;
    }

    public void setBq098(String bq098) {
        this.bq098 = bq098;
    }

    public String getBq099() {
        return bq099;
    }

    public void setBq099(String bq099) {
        this.bq099 = bq099;
    }

    public String getBq018c() {
        return bq018c;
    }

    public void setBq018c(String bq018c) {
        this.bq018c = bq018c;
    }

    public String getBq031() {
        return bq031;
    }

    public void setBq031(String bq031) {
        this.bq031 = bq031;
    }

    public String getBq023c() {
        return bq023c;
    }

    public void setBq023c(String bq023c) {
        this.bq023c = bq023c;
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

    public String getBq027() {
        return bq027;
    }

    public void setBq027(String bq027) {
        this.bq027 = bq027;
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

    public String getBq032c() {
        return bq032c;
    }

    public void setBq032c(String bq032c) {
        this.bq032c = bq032c;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getBq002c() {
        return bq002c;
    }

    public void setBq002c(String bq002c) {
        this.bq002c = bq002c;
    }

    public String getBq014() {
        return bq014;
    }

    public void setBq014(String bq014) {
        this.bq014 = bq014;
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

    public String getBq038c() {
        return bq038c;
    }

    public void setBq038c(String bq038c) {
        this.bq038c = bq038c;
    }

    public String getBq013() {
        return bq013;
    }

    public void setBq013(String bq013) {
        this.bq013 = bq013;
    }

    public String getBq197() {
        return bq197;
    }

    public void setBq197(String bq197) {
        this.bq197 = bq197;
    }

    public String getBq018() {
        return bq018;
    }

    public void setBq018(String bq018) {
        this.bq018 = bq018;
    }

    public String getBq003c() {
        return bq003c;
    }

    public void setBq003c(String bq003c) {
        this.bq003c = bq003c;
    }

    public String getBq198() {
        return bq198;
    }

    public void setBq198(String bq198) {
        this.bq198 = bq198;
    }

    public String getBq019() {
        return bq019;
    }

    public void setBq019(String bq019) {
        this.bq019 = bq019;
    }

    public String getBq199() {
        return bq199;
    }

    public void setBq199(String bq199) {
        this.bq199 = bq199;
    }

    public String getBq197c() {
        return bq197c;
    }

    public void setBq197c(String bq197c) {
        this.bq197c = bq197c;
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

    public String getBq003() {
        return bq003;
    }

    public void setBq003(String bq003) {
        this.bq003 = bq003;
    }

    public String getBq039c() {
        return bq039c;
    }

    public void setBq039c(String bq039c) {
        this.bq039c = bq039c;
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

    public String getBq009() {
        return bq009;
    }

    public void setBq009(String bq009) {
        this.bq009 = bq009;
    }

    public String getBq007() {
        return bq007;
    }

    public void setBq007(String bq007) {
        this.bq007 = bq007;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getBq008() {
        return bq008;
    }

    public void setBq008(String bq008) {
        this.bq008 = bq008;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getBq035h() {
        return bq035h;
    }

    public void setBq035h(String bq035h) {
        this.bq035h = bq035h;
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
        if (!(object instanceof SERI12)) {
            return false;
        }
        SERI12 other = (SERI12) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SERI12[ oid=" + oid + " ]";
    }

    public String getBq506c() {
        return bq506c;
    }

    public void setBq506c(String bq506c) {
        this.bq506c = bq506c;
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

    public void setBq507(String bq507) {
        this.bq507 = bq507;
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

    public String getBq507c() {
        return bq507c;
    }

    public void setBq507c(String bq507c) {
        this.bq507c = bq507c;
    }

    public String getBq501h() {
        return bq501h;
    }

    public void setBq501h(String bq501h) {
        this.bq501h = bq501h;
    }

    public String getBq504c() {
        return bq504c;
    }

    public void setBq504c(String bq504c) {
        this.bq504c = bq504c;
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

    public String getBq129() {
        return bq129;
    }

    public void setBq129(String bq129) {
        this.bq129 = bq129;
    }

    public String getBq130() {
        return bq130;
    }

    public void setBq130(String bq130) {
        this.bq130 = bq130;
    }

    public String getBq131() {
        return bq131;
    }

    public void setBq131(String bq131) {
        this.bq131 = bq131;
    }

    public String getBq132() {
        return bq132;
    }

    public void setBq132(String bq132) {
        this.bq132 = bq132;
    }

    public String getBq133() {
        return bq133;
    }

    public void setBq133(String bq133) {
        this.bq133 = bq133;
    }

    public String getBq134() {
        return bq134;
    }

    public void setBq134(String bq134) {
        this.bq134 = bq134;
    }

    public String getBq135() {
        return bq135;
    }

    public void setBq135(String bq135) {
        this.bq135 = bq135;
    }

    public String getBq136() {
        return bq136;
    }

    public void setBq136(String bq136) {
        this.bq136 = bq136;
    }

    public String getBq135c() {
        return bq135c;
    }

    public void setBq135c(String bq135c) {
        this.bq135c = bq135c;
    }

    public String getBq508() {
        return bq508;
    }

    public void setBq508(String bq508) {
        this.bq508 = bq508;
    }

    /**
     * @return the propotion
     */
    public String getPropotion() {
        return propotion;
    }

    /**
     * @param propotion the propotion to set
     */
    public void setPropotion(String propotion) {
        this.propotion = propotion;
    }

}
