package com.gavin.test.forest;

import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.PostRequest;
import com.gavin.test.playwright.PageInfo;

public interface MyClient {

    @PostRequest(
            url = "http://app.gjzwfw.gov.cn/jimps/link.do",
            headers = {
                    "Origin: https://app.gjzwfw.gov.cn",
                    "Cookie: HWWAFSESID=9ec6b2027bb08197327; HWWAFSESTIME=1704941088632",
                    "Referer: https://app.gjzwfw.gov.cn/jmopen/webapp/html5/dljzjgcx/index.html",
            }
    )
    PageInfo helloForest(@Body("param") String param);

}