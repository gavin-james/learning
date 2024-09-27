package com.gavin.test.playwright;

import com.dtflys.forest.Forest;
import com.dtflys.forest.utils.RequestNameValue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ForestTest {
    @Test
    void testForest() {
        List<RequestNameValue> defaultHeaders = new ArrayList<>();
        RequestNameValue requestNameValue = new RequestNameValue("cookie", "JSESSIONID=2d469e70-10a4-91e5-e8d90c11621f", 0);
        defaultHeaders.add(requestNameValue);
        RzClient rzClient = Forest.config().setDefaultHeaders(defaultHeaders).client(RzClient.class);

        String index = rzClient.gzlgl_fylr();
        System.out.println(index);


//        String editHtmlStr = rzClient.gzrzEdit("2409050826020001");
//        System.out.println(editHtmlStr);

    }
}
