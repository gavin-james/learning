package com.gavin.test.playwright;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class JgTest {

    @Test
    void getInfo() {


        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            context.onRequestFinished(request -> {
                if (request.url().equals("/sszyfw/bulletinBoard/getBulletinBoardPage")) {
                    String resStr = request.response().text();
                    System.out.println(resStr);
                }
            });
            page.navigate("https://12366.chinatax.gov.cn/sszyfw/bulletinBoard/main");
            page.getByText("纳入监管的涉税专业服务机构").click();
            page.locator("span").filter(new Locator.FilterOptions().setHasText("全部")).click();
            page.getByText("代理记账机构").click();
            page.getByText("上海", new Page.GetByTextOptions().setExact(true)).click();
            page.locator("#load-dialog img").click();
            page.locator("#code").click();
            page.locator("#code").fill("8442");
            page.getByText("确定").click();
            page.getByText("下一页").click();
            page.getByText("下一页").click();
            page.getByText("下一页").click();
            page.getByText("下一页").click();
            page.getByText("下一页").click();
            page.getByText("下一页").click();
            page.getByText("下一页").click();
            page.getByText("下一页").click();
            page.getByText("下一页").click();
            page.getByText("下一页").click();
            page.getByText("请输入验证码 确定").click();
            page.locator("#code").click();
            page.locator("#code").fill("7622");
            page.getByText("确定").click();
            page.getByText("下一页").click();
        }
    }

}
