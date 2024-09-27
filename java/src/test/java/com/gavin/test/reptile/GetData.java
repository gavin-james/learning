package com.gavin.test.reptile;

import cn.hutool.http.HttpUtil;
import com.gavin.entity.UniversityInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GetData {
    String HOST = "https://yz.chsi.com.cn";

    // 爬取https://yz.chsi.com.cn/sch/search.do?ylgx=1&start=0的数据，并解析其中sch-item 的html对象
    @Test
    void getData() {
        List<UniversityInfo> universityInfoList = new ArrayList<>();

        String url = this.HOST + "/sch/search.do?ylgx=1&start=0";
        String html = HttpUtil.get(url);
        for (Element element : Jsoup.parse(html).select(".sch-item")) {
            UniversityInfo universityInfo = new UniversityInfo();
            String name = element.select(".name").get(0).val();
            universityInfo.setName(name);

        }
        System.out.println(universityInfoList);
    }
}
