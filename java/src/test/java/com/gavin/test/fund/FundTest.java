package com.gavin.test.fund;

import cn.hutool.core.convert.NumberChineseFormatter;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FundTest {
    @Test
    void test() {
        // 初始资金
        BigDecimal money = FundTest.convertToDecimal("110000");
        int month = 1;
        while (money.compareTo(FundTest.convertToDecimal("10000000")) < 0) {
            BigDecimal earnMoney = money.multiply(BigDecimal.valueOf(0.10));
            BigDecimal totalMoney = money.add(earnMoney.subtract(money.add(earnMoney).multiply(BigDecimal.valueOf(0.0001))));
            System.out.printf("当前已经过 %s 天\t本金为 %s\t总金额 %s\t当月挣到了%s", month, FundTest.convertToStr(money), FundTest.convertToStr(totalMoney), FundTest.convertToStr(earnMoney));
            money = totalMoney;
//            if (month % 12 == 0) {
////                money = totalMoney.subtract(new BigDecimal("30000"));
//            } else {
////                if (totalMoney.compareTo(new BigDecimal("200000")) < 0) {
////                    money = totalMoney.add(new BigDecimal("9000")).subtract(new BigDecimal("4000"));
////                } else {
//                money = totalMoney;
////                }
//            }
            System.out.println();
            DateTime dateTime = DateUtil.offsetMonth(DateUtil.date(), month);
            System.out.println("需要到达" + DateUtil.formatDateTime(dateTime) + "才能挣到" + FundTest.convertToChinese(money) + "一个花费 " + month + " 个天");
            month++;
        }
    }

    public static String convertToStr(BigDecimal money) {
        return NumberUtil.decimalFormat(",###.##", money, RoundingMode.HALF_UP);
    }

    public static BigDecimal convertToDecimal(String money) {
        return NumberUtil.toBigDecimal(money);
    }

    public static String convertToChinese(BigDecimal money) {
        return NumberChineseFormatter.formatSimple(money.longValue());
    }
}