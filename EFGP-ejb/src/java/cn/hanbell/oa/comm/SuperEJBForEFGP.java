/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.comm;

import cn.hanbell.oa.ejb.FunctionsBean;
import cn.hanbell.oa.ejb.OrganizationUnitBean;
import cn.hanbell.oa.ejb.ProcessInstanceBean;
import cn.hanbell.oa.ejb.TitleBean;
import cn.hanbell.oa.ejb.UsersBean;
import cn.hanbell.oa.entity.Functions;
import cn.hanbell.oa.entity.OrganizationUnit;
import cn.hanbell.oa.entity.Title;
import cn.hanbell.oa.entity.Users;
import cn.hanbell.util.SuperEJB;
import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author C0160
 * @param <T>
 */
public abstract class SuperEJBForEFGP<T> extends SuperEJB<T> {

    @PersistenceContext(unitName = "EFGP-ejbPU")
    private EntityManager em;
    //电子章相关代码
    public static final String SS = "SS";//合同
    public static final String CS = "CS";//营业
    public static final String OD = "OD";//报价
    @EJB
    protected ProcessInstanceBean processInstanceBean;

    @EJB
    protected UsersBean usersBean;
    @EJB
    protected FunctionsBean functionsBean;
    @EJB
    protected OrganizationUnitBean organizationUnitBean;
    @EJB
    protected TitleBean titleBean;

    protected Users currentUser;
    protected Functions userFunction;
    protected OrganizationUnit organizationUnit;
    protected Title userTitle;

    protected final Logger log4j = LogManager.getLogger("cn.hanbell.eap");

    public SuperEJBForEFGP(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public T findByOID(Object value) {
        Query query = getEntityManager().createNamedQuery(getClassName() + ".findByOID");
        query.setParameter("oid", value);
        try {
            Object entity = query.getSingleResult();
            if (entity != null) {
                return (T) entity;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public T findByPSN(Object value) {
        Query query = getEntityManager().createNamedQuery(getClassName() + ".findByPSN");
        query.setParameter("psn", value);
        try {
            Object entity = query.getSingleResult();
            if (entity != null) {
                return (T) entity;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public List<T> findByFSN(Object value) {
        Query query = getEntityManager().createNamedQuery(getClassName() + ".findByFSN");
        query.setParameter("fsn", value);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Functions findFunctionsByUserOIDAndOrgUnitOID(String userOID, String orgUnitOID) {
        try {
            return functionsBean.findByUserOIDAndOrgUnitOID(userOID, orgUnitOID);
        } catch (Exception ex) {
            return null;
        }
    }

    public OrganizationUnit findOrgUnitByOID(String oid) {
        try {
            return organizationUnitBean.findByOID(oid);
        } catch (Exception ex) {
            return null;
        }
    }

    public OrganizationUnit findOrgUnitByDeptno(String deptno) {
        try {
            return organizationUnitBean.findById(deptno);
        } catch (Exception ex) {
            return null;
        }
    }

    public Users findUserByOID(String oid) {
        try {
            return usersBean.findByOID(oid);
        } catch (Exception ex) {
            return null;
        }
    }

    public Users findUserByUserno(String userno) {
        try {
            return usersBean.findById(userno);
        } catch (Exception ex) {
            return null;
        }
    }

    public String getCompanyByDeptId(String deptId) {
        switch (deptId.substring(0, 2)) {
            case "1C":
                return "J";
            case "1D":
                return "G";
            case "1E":
                return "N";
            case "1V":
                return "C4";
            case "1R":
                return "W";
            case "XA":
                return "C5";//银川
        }
        switch (deptId.substring(0, 1)) {
            case "1":
                return "C";
            case "2":
                return "H";
            case "3":
                return "VN";
            case "4":
                return "Q";
            case "5":
                return "K";
            case "6":
                return "R";
            case "7":
                return "Y";
            case "8":
                return "E";
            case "9":
                return "L";
            case "Y":
                return "F";//楚雄汉钟
            case "W":
                return "VB";//越南北宁
        }
        return "";
    }

    public String getCompanyName(String facno) {
        switch (facno) {
            case "C":
                return "上海汉钟";
            case "F":
                return "楚雄汉钟";
            case "G":
                return "广州分公司";
            case "J":
                return "济南分公司";
            case "N":
                return "南京分公司";
            case "C4":
                return "重庆分公司";
            case "C5":
                return "银川分公司";
           case "CH":
                return "珀罗普斯柯茂";
           case "XB":
                return "上海汉钟活塞";
            case "H":
                return "浙江汉声";
            case "Y":
                return "安徽汉扬";
            case "K":
                return "上海柯茂";
            case "E":
                return "浙江柯茂";
            case "Q":
                return "世纪东元";
            case "L":
                return "真空技术";
            case "X":
                return "香港汉钟";
            case "V":
                return "越南汉钟";
            case "R":
                return "韩国汉钟";
            case "W":
                return "顺德涡旋";
            case "A":
                return "台湾汉钟（观音厂）";
            case "B":
                return "台湾汉钟（台中厂）";
            case "P":
                return "台湾真空";
            case "HP":
                return "台湾汉力";
        }
        return "上海汉钟";
    }

    public void initUserInfo(String userid) {
        this.currentUser = usersBean.findById(userid);
        this.userFunction = functionsBean.findByUserOIDAndIsMain(currentUser.getOid());
        this.organizationUnit = userFunction.getOrganizationUnit();
        this.userTitle = titleBean.findByOUOIDAndUserOID(organizationUnit.getOid(), getCurrentUser().getOid());
        if (organizationUnit != null) {
            this.currentUser.setDeptno(organizationUnit.getId());
            this.currentUser.setDeptname(organizationUnit.getOrganizationUnitName());
        }
        if (userTitle != null) {
            this.currentUser.setTitle(userTitle);
        }
    }

    //金额大写
    public String number2CNMonetaryUnit(BigDecimal numberOfMoney) {
        /**
         * 汉语中数字大写
         */
        String[] CN_UPPER_NUMBER = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        /**
         * 汉语中货币单位大写，这样的设计类似于占位符
         */
        String[] CN_UPPER_MONETRAY_UNIT = {"分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾",
            "佰", "仟", "兆", "拾", "佰", "仟"};
        String CN_FULL = "整";
        String CN_NEGATIVE = "负";
        //金额的精度，默认值为2
        int MONEY_PRECISION = 2;
        String CN_ZEOR_FULL = "零元";

        StringBuilder sb = new StringBuilder();
        // 返回-1：表示该数小于0 0：表示该数等于0 1：表示该数大于0
        int signum = numberOfMoney.signum();
        // 零元的情况
        if (signum == 0) {
            return CN_ZEOR_FULL;
        }
        // 这里会进行金额的四舍五入
        long number = numberOfMoney.movePointRight(MONEY_PRECISION).setScale(0, 4).abs().longValue();
        // 得到小数点后两位值
        long scale = number % 100;
        int numUnit = 0;
        int numIndex = 0;
        boolean getZero = false;
        // 判断最后两位数，一共有四中情况：00 = 0, 01 = 1, 10, 11
        if (!(scale > 0)) {
            numIndex = 2;
            number = number / 100;
            getZero = true;
        }
        if ((scale > 0) && (!(scale % 10 > 0))) {
            numIndex = 1;
            number = number / 10;
            getZero = true;
        }
        int zeroSize = 0;
        while (true) {
            if (number <= 0) {
                break;
            }
            // 每次获取到最后一个数
            numUnit = (int) (number % 10);
            if (numUnit > 0) {
                if ((numIndex == 9) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
                }
                if ((numIndex == 13) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
                }
                sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                getZero = false;
                zeroSize = 0;
            } else {
                ++zeroSize;
                //"分", "角", "元","万", "亿","兆"位不会出现零
                if (numIndex != 0 && numIndex != 1 && numIndex != 2
                        && numIndex != 6 && numIndex != 10 && numIndex != 14) {
                    if (!(getZero)) {
                        sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                    }
                }
                if (numIndex == 2) {
                    if (number > 0) {
                        sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                    }
                } else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                }
                getZero = true;
            }
            // 让number每次都去掉最后一个数
            number = number / 10;
            ++numIndex;
        }
        // 如果signum == -1，则说明输入的数字为负数，就在最前面追加特殊字符：负
        if (signum == -1) {
            sb.insert(0, CN_NEGATIVE);
        }
        // 除了0.00其他数据都要带特殊字符：整
        sb.append(CN_FULL);
        return sb.toString();
    }

    // 优化抛转时件号相关字符问题
    public String filterString(String s) {
        if (s != null && !s.trim().equals("")) {
            String returnStr = s;
            try {
                //String regEx = "[\\s`!！@#￥$%^……&（()）\\+【\\[\\]】｛{}｝\\|、\\\\；;：:‘'“”\"，,《<。.》>、/？?]";
                String regEx = "[\\s`&²³\\t\\r\\n ]";
                Pattern p = Pattern.compile(regEx);
                Matcher m = p.matcher(returnStr);
                returnStr = m.replaceAll(" ");
                //returnStr = removeNonAscii(returnStr);
            } catch (Exception ex) {
                log4j.error(ex);
            }
            return returnStr;
        }
        return s;
    }

    //去除非ascii码字符
    public String removeNonAscii(String str) {
        return str.replaceAll("[^\\x00-\\x7F]", "");
    }

    /**
     * @return the currentUser
     */
    public Users getCurrentUser() {
        return currentUser;
    }

    /**
     * @return the organizationUnit
     */
    public OrganizationUnit getOrganizationUnit() {
        return organizationUnit;
    }

    /**
     * @return the userFunction
     */
    public Functions getUserFunction() {
        return userFunction;
    }

    /**
     * @return the userTitle
     */
    public Title getUserTitle() {
        return userTitle;
    }

}
