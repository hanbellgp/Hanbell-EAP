/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.edw.ejb;

import cn.hanbell.edw.comm.SuperEJBForEDW;
import cn.hanbell.edw.entity.SopInspectionDta;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C2079
 */
@Stateless
@LocalBean
public class SopInspectionDtaBean extends SuperEJBForEDW<SopInspectionDta> {

    public SopInspectionDtaBean() {
        super(SopInspectionDta.class);
    }

    public List<SopInspectionDta> getSopDtaList(String Company, String Post, String Factory) {
        String sqlStr = "";
        if (Post.equals("班长巡查")) {//查8点到20点为一班共二班,根据当前时间来筛选的逻辑
            sqlStr
                    = "DECLARE @Now DATETIME = GETDATE(); "
                    + "DECLARE @Today DATETIME = CONVERT(DATE, @Now); "
                    + "DECLARE @Hour INT = DATEPART(HOUR, @Now); "
                    + "DECLARE @Start DATETIME, @End DATETIME; "
                    + "IF @Hour >= 0 AND @Hour < 8 "
                    + "BEGIN "
                    + "    SET @Start = DATEADD(HOUR, 20, DATEADD(DAY, -1, @Today)); "
                    + "    SET @End = @Today; "
                    + "END "
                    + "ELSE IF @Hour >= 8 AND @Hour < 20 "
                    + "BEGIN "
                    + "    SET @Start = DATEADD(HOUR, 8, @Today); "
                    + "    SET @End = DATEADD(HOUR, 20, @Today); "
                    + "END "
                    + "ELSE "
                    + "BEGIN "
                    + "    SET @Start = DATEADD(HOUR, 20, @Today); "
                    + "    SET @End = DATEADD(DAY, 1, @Today); "
                    + "END "
                    + "SELECT * FROM SopInspectionDta "
                    + "WHERE CreateTime >= @Start AND CreateTime < @End "
                    + "AND Company = '" + Company + "' "
                    + "AND Post = '" + Post + "' "
                    + "AND Factory = '" + Factory + "' "
                    + "ORDER BY CheckType;";
        } else if (Post.equals("组长巡查")) {//每天只允许一个组有一张单子
            sqlStr
                    = "DECLARE @Today DATETIME = CONVERT(DATE, GETDATE()); "
                    + "SELECT * FROM SopInspectionDta "
                    + "WHERE CreateTime >= @Today AND CreateTime < DATEADD(DAY, 1, @Today) "
                    + "AND Company = '" + Company + "' "
                    + "AND Post = '" + Post + "' "
                    + "AND Factory = '" + Factory + "' "
                    + "ORDER BY CheckType;";
        } else if (Post.equals("课长巡查")) {//每周只能有一个单子。只要在这周内都不许生成新单子
            // 获取当前时区时间
            LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
            LocalDate today = now.toLocalDate();

            // 本周一 00:00
            LocalDateTime weekStart = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).atStartOfDay();
            // 下周一 00:00
            LocalDateTime weekEnd = weekStart.plusWeeks(1);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String startStr = weekStart.format(formatter);
            String endStr = weekEnd.format(formatter);

            sqlStr = "SELECT * FROM SopInspectionDta "
                    + "WHERE CreateTime >= '" + startStr + "' AND CreateTime < '" + endStr + "' "
                    + "AND Company = '" + Company + "' "
                    + "AND Post = '" + Post + "' "
                    + "AND Factory = '" + Factory + "' "
                    + "ORDER BY CheckType;";
        }
        if (sqlStr == "") {//当无SQL直接返回null
            return null;
        }
        try {
            Query query = getEntityManager().createNativeQuery(sqlStr, SopInspectionDta.class);
            List<SopInspectionDta> results = query.getResultList();
            return results;
        } catch (Exception ex) {
            return null;
        }
    }

}
