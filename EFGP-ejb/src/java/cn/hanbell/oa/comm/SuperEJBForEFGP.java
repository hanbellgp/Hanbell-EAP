/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.comm;

import cn.hanbell.oa.ejb.FunctionsBean;
import cn.hanbell.oa.ejb.OrganizationUnitBean;
import cn.hanbell.oa.ejb.TitleBean;
import cn.hanbell.oa.ejb.UsersBean;
import cn.hanbell.oa.entity.Functions;
import cn.hanbell.oa.entity.OrganizationUnit;
import cn.hanbell.oa.entity.Title;
import cn.hanbell.oa.entity.Users;
import cn.hanbell.util.SuperEJB;
import java.math.BigDecimal;
import java.util.List;
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

    public Users findUserByUserno(String userno) {
        try {
            return usersBean.findById(userno);
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

    public void initUserInfo(String userid) {
        this.currentUser = usersBean.findById(userid);
        this.userFunction = functionsBean.findByUserOID(currentUser.getOid());
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

    /**
     * @return the currentUser
     */
    public Users getCurrentUser() {
        return currentUser;
    }

    /**
     * @return the userFunction
     */
    public Functions getUserFunction() {
        return userFunction;
    }

    /**
     * @return the organizationUnit
     */
    public OrganizationUnit getOrganizationUnit() {
        return organizationUnit;
    }

    /**
     * @return the userTitle
     */
    public Title getUserTitle() {
        return userTitle;
    }

}
