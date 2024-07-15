package com.gavin.test.forest;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.json.JSONUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.converters.localdate.LocalDateStringConverter;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.dtflys.forest.Forest;
import com.gavin.test.playwright.PageInfo;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ForestTest {
    MyClient myClient;
    Integer currentPage = 1;
    Integer pageSize = 13000;
    Map<String, Object> bodyMap;
    String fileName = "全国机构信息.xlsx";
    List<PageInfo.ListDTO> data;

    /**
     * 爬取全国机构信息
     */
    @Test
    void httpUtilTest() {
        while (true) {
            PageInfo pageInfo = this.myClient.helloForest(this.buildBody());
            System.out.println("请求完成,共有 " + pageInfo.getTotal() + " 条数据,此次拉取到 " + pageInfo.getList().size() + " 条数据");
            this.data.addAll(pageInfo.getList());
            System.out.println("请求完成,共有 " + this.data.size() + " 条数据保存完成");
            if (pageInfo.getTotal() <= this.currentPage * this.pageSize) {
                break;
            }
            this.currentPage++;
        }
    }

    /**
     * 初始化
     */
    @BeforeAll
    void launchBrowser() {
        this.myClient = Forest.client(MyClient.class);
        this.data = new CopyOnWriteArrayList<>();
        this.bodyMap = new HashMap<>();
        this.bodyMap.put("from", "1");
        this.bodyMap.put("key", "74165095eeb0433db02c1b58ac57c642");
    }

    /**
     * 结束后关闭
     */
    @AfterAll
    void afterAll() {
        // 设置 excel 的样式
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy();
        // 表头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        headWriteCellStyle.setFillPatternType(FillPatternType.NO_FILL);
        horizontalCellStyleStrategy.setHeadWriteCellStyle(headWriteCellStyle);
        EasyExcel.write(this.fileName, PageInfo.ListDTO.class)
                // 设置自动列宽
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                // 覆盖默认表头样式
                .registerWriteHandler(horizontalCellStyleStrategy)
                .registerConverter(new LocalDateStringConverter())
                .sheet("").doWrite(this.data);
    }

    /**
     * 构建请求题
     */
    String buildBody() {
        String requestTime = String.valueOf(DateUtil.current());
        this.bodyMap.put("dljzProvince", "310000");
        this.bodyMap.put("dljzOrgType", "0");
        this.bodyMap.put("currentPage", this.currentPage);
        this.bodyMap.put("pageSize", this.pageSize);
        this.bodyMap.put("requestTime", requestTime);
        this.bodyMap.put("sign", MD5.create().digestHex("dljzjgcx" + requestTime));
        return JSONUtil.toJsonStr(this.bodyMap);
    }
}