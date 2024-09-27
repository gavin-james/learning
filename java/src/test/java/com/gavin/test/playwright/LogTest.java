package com.gavin.test.playwright;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.Cookie;
import org.junit.jupiter.api.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is for xxxx.
 *
 * @author Gavin
 * @date 4/19/23 11:02 上午
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogTest {
    // Shared between all tests in this class.
    Playwright playwright;
    Browser browser;
    List<String> logContents;

    String LOGIN_URL = "https://oa.htjs.net/manage/index.jsp";
    String HOME_URL = "https://oa.htjs.net/server/oa_new/home/main.jsp";

    // New instance for each test method.
    BrowserContext context;
    Page page;

    /**
     * 初始化
     */
    @BeforeAll
    void launchBrowser() {
        this.playwright = Playwright.create();
        this.browser = this.playwright.firefox().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        this.logContents = new ArrayList<>();
        String logFileName = "日志内容.xlsx";
        File file = new ClassPathResource(logFileName).getFile();
        EasyExcel.read(file, LogEntity.class, new PageReadListener<LogEntity>(logEntities ->
                logEntities.forEach(logEntity -> this.logContents.add(logEntity.getContent()))
        )).sheet().doRead();
    }

    /**
     * 结束后关闭
     */
    @AfterAll
    void closeBrowser() {
        this.playwright.close();
    }

    /**
     * 初始化
     */
    @BeforeEach
    void createContextAndPage() {
        this.context = this.browser.newContext();
        this.page = this.context.newPage();
        // 设置等待时间
        this.page.setDefaultTimeout(300000);
    }

    @AfterEach
    void closeContext() {
        this.context.close();
        this.browser.close();
    }


    /**
     * 通过扫码登录
     */
    void login() {
        this.page.navigate(this.LOGIN_URL);
        this.page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("企业微信扫描二维码登录")).click();
        while (this.context.cookies().size() <= 1) {
        }
        List<Cookie> cookies = this.context.cookies();
        ResourceUtils.writeFile(JSONUtil.toJsonStr(cookies), "cookie.json");
    }

    /**
     * 通过设置 cookies 去进行登录
     */
    void loginByCookiesOrScanQR() {
        this.context.addCookies(JSONUtil.toList(ResourceUtils.getFileStr("cookie.json"), Cookie.class));
        this.page.navigate(this.HOME_URL);
        if (this.page.url().equals(this.LOGIN_URL)) {
            this.page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("企业微信扫描二维码登录")).click();
            while (this.context.cookies().size() <= 1) {
            }
            ResourceUtils.writeFile(JSONUtil.toJsonStr(this.context.cookies()), "cookie.json");
        }
    }

    @Test
    void fillLog() {
        this.loginByCookiesOrScanQR();

        List<String> needLogsDates = Util.needLogDates();

        System.out.println("本月待录入日志的日子：" + needLogsDates);
        while (needLogsDates.size() > 0) {
            this.page.navigate(this.HOME_URL);
            this.page.locator(".layui-tree-iconClick > .layui-icon").first().click();
            this.page.locator("#LAY-system-side-menu").getByText("工作日志", new Locator.GetByTextOptions().setExact(true)).click();

            // 获取日志内容
            FrameLocator frameLocator = this.page.frameLocator("iframe >> nth=1");

            // 1、首先去除当前有多少日志已经完成写入
            Locator locator = frameLocator.locator("#Tab1");
            // 这个为了防止加载不到数据
            locator.textContent();
            // 去除已经存在数据
            List<Locator> exitDates = locator.locator("input[type=\"radio\"]").all();

            exitDates.forEach(i -> needLogsDates.remove(i.getAttribute("rq")));
            System.out.println("本月剩余录入日志的日子：" + needLogsDates);
            if (CollUtil.isEmpty(needLogsDates)) {
                break;
            }

            Locator yesterDayLog = this.getYesterDayLog(exitDates);
            if (ObjectUtil.isNotNull(yesterDayLog)) {
                yesterDayLog.click();
                frameLocator.getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("修改")).click();
                FrameLocator editModel = frameLocator.frameLocator("iframe[name=\"OpenmyArtDialog\"]");
                String logDate = needLogsDates.get(0);
                Locator gzrqLocator = editModel.locator("#gzrq");
                // 去除只读选项
                gzrqLocator.evaluate("node => node.removeAttribute('readonly')");
                gzrqLocator.fill(logDate);
                Locator nowTimeLocator = editModel.locator("#nowTime");
                // 去除隐藏选项
                nowTimeLocator.evaluate("node => node.type = 'text'");
                nowTimeLocator.fill(logDate);

                editModel.getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("确 定")).click();
//                needLogsDates.remove(0);
//                page.waitForResponse(response -> response.url().contains("bgyfy/gzlgl_fylr/handleEdit.jsp"), new Page.WaitForResponseOptions().setTimeout(10_000), () -> {
//                    System.out.println("完成修改：" + logDate);
//                });
//                page.waitForRequest(req -> req.url().contains("bgyfy/gzlgl_fylr/handleEdit.jsp"), new Page.WaitForRequestOptions()
//                        .setTimeout(30_000), () -> {
//                    System.out.println("完成修改：" + logDate);
//                });
            } else {
                frameLocator.getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("添加")).click();
                FrameLocator editModel = frameLocator.frameLocator("iframe[name=\"OpenmyArtDialog\"]");
                editModel.locator("#rcswRadio").click();

                Locator gzrqLocator = editModel.locator("#gzrq");
                // 去除只读选项
                gzrqLocator.evaluate("node => node.removeAttribute('readonly')");
                gzrqLocator.fill(Util.yesLogDates());

                int i = Util.indexOfMonth(needLogsDates.get(0));
                // 拿到内容
                String logContent = this.logContents.get(i);

                System.out.println("content: " + logContent);
                editModel.locator("textarea[name=\"GZNR\"]").fill(logContent);

                editModel.getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("保存")).click();

//                page.waitForRequest(req -> req.url().contains("bgyfy/gzlgl_fylr/handleInsert.jsp"), new Page.WaitForRequestOptions()
//                        .setTimeout(30_000), () -> {
//                    System.out.println("完成添加" + i);
//                });
            }
        }

        if (!Util.yesIsWeek()) {
            this.page.navigate(this.HOME_URL);
            this.page.locator(".layui-tree-iconClick > .layui-icon").first().click();
            this.page.locator("#LAY-system-side-menu").getByText("工作日志", new Locator.GetByTextOptions().setExact(true)).click();

            // 获取日志内容
            FrameLocator frameLocator = this.page.frameLocator("iframe >> nth=1");

            // 1、首先去除当前有多少日志已经完成写入
            Locator locator = frameLocator.locator("#Tab1");
            // 这个为了防止加载不到数据
            locator.textContent();
            frameLocator.getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("添加")).click();
            FrameLocator editModel = frameLocator.frameLocator("iframe[name=\"OpenmyArtDialog\"]");
            editModel.locator("#rcswRadio").click();

            Locator gzrqLocator = editModel.locator("#gzrq");
            // 去除只读选项
            gzrqLocator.evaluate("node => node.removeAttribute('readonly')");

            int i = Util.indexOfMonth(Util.yesLogDates());
            // 拿到内容
            String logContent = this.logContents.get(i);

            System.out.println("index: " + i);
            System.out.println("content: " + logContent);
            editModel.locator("textarea[name=\"GZNR\"]").fill(logContent);

            editModel.getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("保存")).click();

//            this.page.waitForRequest(req -> req.url().contains("bgyfy/gzlgl_fylr/handleInsert.jsp"), new Page.WaitForRequestOptions()
//                    .setTimeout(30_000), () -> {
//                System.out.println("完成添加");
//            });
        }
    }

    Locator getYesterDayLog(List<Locator> exitDates) {
        List<Locator> threeLogs = exitDates.stream().filter(i -> i.getAttribute("rq").equals(Util.yesLogDates())).collect(Collectors.toList());

        if (CollUtil.isNotEmpty(threeLogs)) {
            return threeLogs.get(0);
        }
        return null;
    }

}
