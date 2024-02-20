package com.gavin.test.playwright;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Cookie;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Qingshu {
    Playwright playwright;
    Browser browser;
    Map<String, String> courseHashMap;
    String COOKIE_FILE = "qingshu_cookie.json";
    String COURSE_FILE = "course.json";

    // 登录页面
    final static String LOGIN_URL = "https://www.qingshuxuetang.com/Login";
    // 课程页面
    final static String COURSE_LIST_URL = "https://degree.qingshuxuetang.com/jxust/Student/Course/CourseList";
    //
    final static String COURSE_URL = "https://degree.qingshuxuetang.com/jxust/Student/Course/CourseStudy";
    final static String COURSE_SHOW_URL = "https://degree.qingshuxuetang.com/jxust/Student/Course/CourseShow";
    final static String COURSE_DATA_URL = "https://degree.qingshuxuetang.com/jxust/Student/Course/CourseData";
    final static String COURSEWARE_TREE_URL = "https://degree.qingshuxuetang.com/jxust/Svc/GetCoursewareTree";
    final static String HOME_URL = "https://degree.qingshuxuetang.com/jxust/Home";

    // New instance for each test method.
    BrowserContext context;
    Page page;

    /**
     * 初始化
     */
    @BeforeAll
    void launchBrowser() {
        this.playwright = Playwright.create();
        this.browser = this.playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        this.courseHashMap = new ConcurrentHashMap<>();
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
    void createContextAndPage() throws Exception {
        this.context = this.browser.newContext();
        this.page = this.context.newPage();
        // 设置等待时间
        this.page.setDefaultTimeout(300000);
        this.loginByCookiesOrScanQR();
    }

    @AfterEach
    void closeContext() {
        this.context.close();
        this.browser.close();
    }

    /**
     * 通过设置 cookies 去进行登录
     */
    void loginByCookiesOrScanQR() throws Exception {
        this.context.addCookies(JSONUtil.toList(ResourceUtils.getFileStr(this.COOKIE_FILE), Cookie.class));
        this.page.navigate(Qingshu.COURSE_LIST_URL);
        if (this.page.url().equals(Qingshu.HOME_URL)) {
            this.page.navigate(Qingshu.LOGIN_URL);
            this.page.locator("#codeLoginBtn").click();
            List<Cookie> tokenCookie = null;
            do {
                tokenCookie = this.context.cookies().stream().filter(cookie -> cookie.name.equals("AccessToken") && cookie.expires > DateUtil.currentSeconds()).collect(Collectors.toList());
            } while (!CollUtil.isNotEmpty(tokenCookie));
            ResourceUtils.writeFile(JSONUtil.toJsonStr(tokenCookie), this.COOKIE_FILE);
        }
    }

    @Test
    void getCourseData() throws Exception {
        // 获取课程数据
        this.toCourseList();
    }

    public void toCourseList() {
        this.page.navigate(Qingshu.COURSE_LIST_URL);
        Request request = this.page.waitForRequestFinished(new Page.WaitForRequestFinishedOptions().setPredicate(req -> req.url().contains(Qingshu.COURSE_DATA_URL)), () -> {
        });
        if (request.response().status() != 200) {
            return;
        }
        List<Course> courseList = JSONUtil.toBean(request.response().text(), new TypeReference<Res<List<Course>>>() {
        }, true).getData();
        courseList.stream().filter(course -> course.getLearnStatus().equals(2)).forEach(this::toCourse);

        ResourceUtils.writeFile(JSONUtil.toJsonStr(this.courseHashMap), this.COURSE_FILE);
    }

    public void toCourse(Course course) {
        String queryParams = "?courseId=" + course.getCourseId() + "&teachPlanId=" + course.getTeachPlanId() + "&periodId=" + course.getPeriodId();
        this.page.navigate(Qingshu.COURSE_URL + queryParams);
        Request request = this.page.waitForRequestFinished(new Page.WaitForRequestFinishedOptions().setPredicate(req -> req.url().contains(Qingshu.COURSEWARE_TREE_URL)), () -> {
        });
        if (request.response().status() != 200) {
            return;
        }
        Chapter chapter = JSONUtil.toBean(request.response().text(), new TypeReference<Res<Chapter>>() {
        }, true).getData();

        this.getNode(chapter, queryParams);
    }

    public void getNode(Chapter node, String queryParams) {
        if (CollUtil.isEmpty(node.getNodes())) {
            return;
        }
        node.getNodes().forEach(chapter -> {
            if (chapter.getType().equals("chapter")) {
                this.getNode(chapter, queryParams);
                return;
            }
            String url = Qingshu.COURSE_SHOW_URL + queryParams + "&nodeId=" + chapter.getId();
            this.courseHashMap.put(chapter.getId() + chapter.getName(), url);
        });
    }
}
