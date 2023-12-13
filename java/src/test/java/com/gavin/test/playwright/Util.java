package com.gavin.test.playwright;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is for xxxx.
 *
 * @author Gavin
 * @date 4/19/23 11:24 上午
 */

public class Util {

    public static List<String> needLogDates() {
        // 获取当前日期
        Date now = new Date();
        // 获取昨天的日期
        Date oldDay = DateUtil.offsetDay(now, -1);
        // 获取当前月份的开始日期
        Date beginOfMonth = DateUtil.beginOfMonth(now);
        // 生成日期数组
        return DateUtil.rangeToList(beginOfMonth, oldDay, DateField.DAY_OF_MONTH)
                .stream()
                .map(i -> DateUtil.format(i, DatePattern.NORM_DATE_PATTERN))
                .collect(Collectors.toList());
    }

    public static String yesLogDates() {
        // 获取当前日期
        Date now = new Date();
        int hour = DateUtil.hour(now, true);
        if (hour >= 17) {
            return DateUtil.format(now, DatePattern.NORM_DATE_PATTERN);
        }
        // 获取三天前日期
        Date yesDay = DateUtil.offsetDay(now, -1);
        return DateUtil.format(yesDay, DatePattern.NORM_DATE_PATTERN);
    }

    public static Boolean yesIsWeek() {
        // 获取当前日期
        Date now = new Date();
        // 获取三天前日期
        Date yesDay = DateUtil.offsetDay(now, -1);
        return DateUtil.isWeekend(yesDay);
    }

    public static int indexOfMonth(String dateStr) {
        return DateUtil.dayOfMonth(DateUtil.parseDate(dateStr)) - 1;
    }
}
