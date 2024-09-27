package com.gavin.test.playwright;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.dtflys.forest.Forest;
import com.dtflys.forest.utils.RequestNameValue;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.Cookie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * This class is for xxxx.
 *
 * @author Gavin
 * @date 4/19/23 11:02 上午
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogTest2 {
    // Shared between all tests in this class.
    Playwright playwright;
    Browser browser;
    String LOGIN_URL = "https://oa.htjs.net/manage/index.jsp";
    // New instance for each test method.
    BrowserContext context;
    Page page;
    RzClient rzClient;

    String GZNR = "1：完成了新功能的开发，提高了自己的开发能力。\n2：修复了之前发现的 bug，提高了代码的质量。\n3：阅读了一些关于项目的文档，对相关技术有了更深入的了解。\n4：完善新功能，使其更加稳定和可靠。";

    @Test
    void fillLog() {
        AtomicReference<String> JSESSIONID = new AtomicReference<>("");
        JSONUtil.toList(ResourceUtils.getFileStr("cookie.json"), Cookie.class).stream().filter(cookie -> cookie.name.equals("JSESSIONID")).forEach(cookie -> JSESSIONID.set(cookie.value));
        this.rzClient = Forest.config().setDefaultHeaders(Collections.singletonList(new RequestNameValue("cookie", "JSESSIONID=" + JSESSIONID, 0))).client(RzClient.class);
        if (this.rzClient.gzlgl_fylr().contains("你没有登录系统，请登录后访问")) {
            this.playwright = Playwright.create();
            this.browser = this.playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            this.context = this.browser.newContext();
            this.page = this.context.newPage();
            // 设置等待时间
            this.page.setDefaultTimeout(300000);

            this.page.navigate(this.LOGIN_URL);
            this.page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("企业微信扫描二维码登录")).click();
            while (this.context.cookies().size() <= 1) {
            }
            ResourceUtils.writeFile(JSONUtil.toJsonStr(this.context.cookies()), "cookie.json");
            this.context.cookies().stream().filter(cookie -> cookie.name.equals("JSESSIONID")).forEach(cookie -> JSESSIONID.set(cookie.value));
            this.rzClient = Forest.config().setDefaultHeaders(Collections.singletonList(new RequestNameValue("cookie", "JSESSIONID=" + JSESSIONID, 0))).client(RzClient.class);
        }

        List<String> needLogsDates = Util.needLogDates();

        String yesDateStr = Util.yesLogDates();
        while (true) {
            // 1、第一步先干掉已经录入的日志
            Elements select = Jsoup.parse(this.rzClient.gzlgl_fylr()).select("#ID");
            select.stream().map(element -> element.attr("rq")).forEach(needLogsDates::remove);
            System.out.println("本月剩余录入日志的日子：" + needLogsDates);
            Element yesRq = select.stream().filter(element -> element.attr("rq").equals(yesDateStr)).findFirst().orElse(null);

            if (needLogsDates.isEmpty() && yesRq != null) {
                break;
            }

            if (ObjectUtil.isNotNull(yesRq)) {
                String rzId = yesRq.val();
                String dqrz = needLogsDates.get(0);
                Elements select1 = Jsoup.parse(this.rzClient.gzrzEdit(rzId)).select("#JBDM");
                String editRes = this.rzClient.gzrzHandleEdit(select1.get(0).val(), rzId, "rcsw", "rcsw", dqrz, dqrz, "on", "08:30", "17:30", "7.5", "1.5", this.GZNR, "确 定");
                if (editRes.contains("修改成功")) {
                    System.out.println("[" + dqrz + "]的日志添加成功.");
                }
            } else {
                Document insertHtmlDoc = Jsoup.parse(this.rzClient.gzrzInsert());
                Elements selectACCOUNTID = insertHtmlDoc.select("#ACCOUNTID");
                Elements selectJBDM = insertHtmlDoc.select("#JBDM");
                Elements selectID = insertHtmlDoc.select("input[name=\"ID\"]");
                String editRes = this.rzClient.gzrzHandleInsert(selectACCOUNTID.get(0).val(), selectJBDM.get(0).val(), selectID.get(0).val(), "rcsw", "rcsw", "", yesDateStr, yesDateStr, "on", "08:30", "17:30", "7.5", "1.5", this.GZNR);
                if (editRes.contains("添加成功")) {
                    System.out.println("[" + yesDateStr + "]的日志添加成功.");
                }
            }
        }

        System.out.println("日志添加完成");

        if (this.context != null) {
            this.context.close();
            this.browser.close();
        }
    }
}
