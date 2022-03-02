/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.app;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Administrator
 */
public class CheckData {

    /**
     * 校验日期格式是否为yyyy/MM/dd
     * @param timeStr 正确返回true
     * @return
     */
    public boolean valiDateFormat(String timeStr) {
        String format = "((19|20)[0-9]{2})/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])";
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(timeStr);
        if (matcher.matches()) {
            pattern = Pattern.compile("(\\d{4})/(\\d+)/(\\d+).*");
            matcher = pattern.matcher(timeStr);
            if (matcher.matches()) {
                int y = Integer.valueOf(matcher.group(1));
                int m = Integer.valueOf(matcher.group(2));
                int d = Integer.valueOf(matcher.group(3));
                if (d > 28) {
                    Calendar c = Calendar.getInstance();
                    c.set(y, m - 1, 1);
                    int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                    return (lastDay >= d);
                }
            }
            return true;
        }
        return false;
    }

}
