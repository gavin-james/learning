package com.gavin.test.playwright;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrganizationTest {
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;
    String HOME_URL = "http://app.gjzwfw.gov.cn/jmopen/webapp/html5/dljzjgcx/index.html";
    String INTERFACE_URL = "http://app.gjzwfw.gov.cn/jimps/link.do";

    /**
     * 初始化
     */
    @BeforeAll
    void launchBrowser() {
        this.playwright = Playwright.create();
        this.browser = this.playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
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

    @Test
    void getOrganization() throws InterruptedException {
        this.context.onRequestFinished(request -> {
            if (request.url().equals(this.INTERFACE_URL)) {
                String resStr = request.response().text();
            }
        });
        this.page.navigate(this.HOME_URL);
        Thread.sleep(30000);
    }
}
