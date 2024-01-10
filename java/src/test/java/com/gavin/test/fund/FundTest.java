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
        BigDecimal money = FundTest.convertToDecimal("14000");
        int month = 1;
        while (money.compareTo(FundTest.convertToDecimal("20000000")) < 0) {
            BigDecimal earnMoney = money.multiply(BigDecimal.valueOf(0.05));
            BigDecimal totalMoney = money.add(earnMoney.subtract(money.add(earnMoney).multiply(BigDecimal.valueOf(0.005))));
            System.out.printf("当前已经过 %s 月\t本金为 %s\t总金额 %s\t当月挣到了%s", month / 2.0, FundTest.convertToStr(money), FundTest.convertToStr(totalMoney), FundTest.convertToStr(earnMoney));
            money = totalMoney.add(new BigDecimal("9000")).subtract(new BigDecimal("4000"));
            System.out.println();
            month++;
        }
        DateTime dateTime = DateUtil.offsetWeek(DateUtil.date(), month * 2);
        System.out.println("需要到达" + DateUtil.formatDateTime(dateTime) + "才能挣到" + FundTest.convertToChinese(money) + "一个花费 " + month + " 个月");
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
