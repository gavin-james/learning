package com.gavin.entity;

import lombok.Data;

@Data
public class UniversityInfo {
    /**
     * 大学名称
     */
    private String name;
    /**
     * 招生简章
     */
    private String enrollmentGuide;
    /**
     * 招生简章地址
     */
    private String enrollmentGuideUrl;
    /**
     * 招生简章内容
     */
    private String enrollmentGuideContext;
}
