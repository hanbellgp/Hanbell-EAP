/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author C1879
 * @param <T>
 */
public abstract class PagerBean<T> {

    protected List<T> list; //对象记录结果集
    protected List<T> totallist;//查询结果集
    protected int total; // 总记录数
    protected int pageSize; // 每页显示记录数
    protected int pages; // 总页数
    protected int nowpage; // 当前页数

    protected boolean isFirstPage;        //是否为首页
    protected boolean isLastPage;         //是否为尾页
    protected boolean hasPreviousPage;   //是否有上一页
    protected boolean hasNextPage;       //是否有下一页

    protected int navigatePages; //导航页码数
    protected int[] navigatePageNumbers;  //所有导航页号

    protected FacesContext fc;
    protected ExternalContext ec;

    protected String appDataPath;
    protected String appResPath;
    protected String fileName;
    protected String fileFullName;
    protected String reportPath;
    protected String reportOutputPath;
    protected String reportViewContext;
    protected String reportViewPath;

    protected Date queryDateBegin;
    protected Date queryDateEnd;

    protected LinkedHashMap<String, Object> map;

    protected final Logger log4j = LogManager.getLogger("cn.hanbell.eap");

    public PagerBean() {
    }

    public Calendar getNowDateBegin() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        return c;
    }

    public Calendar getNowDateEnd() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return c;
    }

    @PostConstruct
    public void construct() {
        //不需要进行操作权限设置
        fc = FacesContext.getCurrentInstance();
        ec = fc.getExternalContext();
        appDataPath = ec.getRealPath("/") + ec.getInitParameter("cn.hanbell.web.appdatapath");
        appResPath = ec.getRealPath("/") + ec.getInitParameter("cn.hanbell.web.apprespath");
        reportPath = ec.getRealPath("/") + ec.getInitParameter("cn.hanbell.web.reportpath");
        reportOutputPath = ec.getRealPath("/") + ec.getInitParameter("cn.hanbell.web.reportoutputpath");
        reportViewContext = ec.getInitParameter("cn.hanbell.web.reportviewcontext");
        init();
    }

    @PreDestroy
    public void destroy() {
        if (getList() != null) {
            getList().clear();
            setList(null);
        }
    }

    public void init() {
        map = new LinkedHashMap<>();
        navigatePages = 9;
        list = new ArrayList<>();
        totallist = new ArrayList<>();
        isFirstPage = true;
        isLastPage = true;
        hasPreviousPage = false;
        hasNextPage = false;
        queryDateBegin = getNowDateBegin().getTime();
        queryDateEnd = getNowDateEnd().getTime();
    }

    public void reset() {
        list.clear();
        totallist.clear();
        total = 0;
        pages = 0;
        nowpage = 0;
        navigatePageNumbers = new int[navigatePages];
        isFirstPage = true;
        isLastPage = true;
        hasPreviousPage = false;
        hasNextPage = false;
        queryDateBegin = getNowDateBegin().getTime();
        queryDateEnd = getNowDateEnd().getTime();
    }

    public void query() {
        list = new ArrayList<>();
        totallist = new ArrayList<>();
        nowpage=1;
         total = 0;
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        setIsFirstPage(getNowpage() == 1);
        setIsLastPage(getNowpage() == getPages() && getNowpage() != 1);
        setHasPreviousPage(getNowpage() > 1);
        setHasNextPage(getNowpage() < getPages());
    }

    /**
     * 计算导航页
     */
    private void calcNavigatePageNumbers() {
        //当总页数小于或等于导航页码数时
        if (getPages() <= getNavigatePages()) {
            setNavigatePageNumbers(new int[getPages()]);
            for (int i = 0; i < getPages(); i++) {
                getNavigatePageNumbers()[i] = i + 1;
            }
        } else { //当总页数大于导航页码数时
            setNavigatePageNumbers(new int[getNavigatePages()]);
            int startNum = getNowpage() - getNavigatePages() / 2;
            int endNum = getNowpage() + getNavigatePages() / 2;
            if (startNum < 1) {
                startNum = 1;
                //(最前navigatePages页
                for (int i = 0; i < getNavigatePages(); i++) {
                    getNavigatePageNumbers()[i] = startNum++;
                }
            } else if (endNum > getPages()) {
                endNum = getPages();
                //最后navigatePages页
                for (int i = getNavigatePages() - 1; i >= 0; i--) {
                    getNavigatePageNumbers()[i] = endNum--;
                }
            } else {
                //所有中间页
                for (int i = 0; i < getNavigatePages(); i++) {
                    getNavigatePageNumbers()[i] = startNum++;
                }
            }
        }
    }

    /**
     * 每页显示list
     */
    public void pageClick() {
        this.setPages((this.getTotal() - 1) / this.getPageSize() + 1);
        //根据输入可能错误的当前号码进行自动纠正
        if (getNowpage() < 1) {
            this.setNowpage(1);
        } else if (getNowpage() > this.getPages()) {
            this.setNowpage(this.getPages());
        }
        //基本参数设定之后进行导航页面的计算
        calcNavigatePageNumbers();
        //以及页面边界的判定
        judgePageBoudary();
        if (total > 0) {
            int firstIndex = (getNowpage() - 1) * getPageSize();
            int lastIndex = getNowpage() * getPageSize();
            int actualLastIndex = 0;
            if (totallist.size() >= lastIndex) {
                actualLastIndex = lastIndex;
            } else {
                actualLastIndex = totallist.size();
            }
            list = totallist.subList(firstIndex, actualLastIndex);
        }
    }

    public void clickFirstPage() {
        nowpage = 1;
        pageClick();
    }

    public void clickLastPage() {
        nowpage = pages;
        pageClick();
    }

    public void clickPreviousPage() {
        nowpage--;
        pageClick();
    }

    public void clickNextPage() {
        nowpage++;
        pageClick();
    }

    public void clickNowPage() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        nowpage = Integer.parseInt(request.getParameter("nowpage"));
        pageClick();
    }

    public void preview() throws Exception {
        FacesContext.getCurrentInstance().getExternalContext().redirect(reportViewPath);
    }

    public void print() {
    }

    public String getAppDataPath() {
        return this.appDataPath;
    }

    public String getAppImgPath() {
        return this.appResPath;
    }

    public String getAppResPath() {
        return this.appResPath;
    }

    /**
     * @return the queryDateBegin
     */
    public Date getQueryDateBegin() {
        return queryDateBegin;
    }

    /**
     * @param queryDateBegin the queryDateBegin to set
     */
    public void setQueryDateBegin(Date queryDateBegin) {
        this.queryDateBegin = queryDateBegin;
    }

    /**
     * @return the queryDateEnd
     */
    public Date getQueryDateEnd() {
        return queryDateEnd;
    }

    /**
     * @param queryDateEnd the queryDateEnd to set
     */
    public void setQueryDateEnd(Date queryDateEnd) {
        this.queryDateEnd = queryDateEnd;
    }

    /**
     * @return the list
     */
    public List<T> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<T> list) {
        this.list = list;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the pages
     */
    public int getPages() {
        return pages;
    }

    /**
     * @param pages the pages to set
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * @return the nowpage
     */
    public int getNowpage() {
        return nowpage;
    }

    /**
     * @param nowpage the nowpage to set
     */
    public void setNowpage(int nowpage) {
        this.nowpage = nowpage;
    }

    /**
     * @return the isFirstPage
     */
    public boolean isIsFirstPage() {
        return isFirstPage;
    }

    /**
     * @param isFirstPage the isFirstPage to set
     */
    public void setIsFirstPage(boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    /**
     * @return the isLastPage
     */
    public boolean isIsLastPage() {
        return isLastPage;
    }

    /**
     * @param isLastPage the isLastPage to set
     */
    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    /**
     * @return the hasPreviousPage
     */
    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    /**
     * @param hasPreviousPage the hasPreviousPage to set
     */
    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    /**
     * @return the hasNextPage
     */
    public boolean isHasNextPage() {
        return hasNextPage;
    }

    /**
     * @param hasNextPage the hasNextPage to set
     */
    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    /**
     * @return the navigatePages
     */
    public int getNavigatePages() {
        return navigatePages;
    }

    /**
     * @param navigatePages the navigatePages to set
     */
    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    /**
     * @return the navigatePageNumbers
     */
    public int[] getNavigatePageNumbers() {
        return navigatePageNumbers;
    }

    /**
     * @param navigatePageNumbers the navigatePageNumbers to set
     */
    public void setNavigatePageNumbers(int[] navigatePageNumbers) {
        this.navigatePageNumbers = navigatePageNumbers;
    }

    /**
     * @return the totallist
     */
    public List<T> getTotallist() {
        return totallist;
    }

    /**
     * @param totallist the totallist to set
     */
    public void setTotallist(List<T> totallist) {
        this.totallist = totallist;
    }

}
