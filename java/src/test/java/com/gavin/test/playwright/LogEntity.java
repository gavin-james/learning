package com.gavin.test.playwright;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * This class is for xxxx.
 *
 * @author gavin james
 */
public class LogEntity {
    @ExcelProperty("日志内容")
    private String content;

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "LogEntity{" +
                "content='" + this.content + '\'' +
                '}';
    }
}
