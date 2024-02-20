package com.gavin.test.playwright;

import java.util.List;

public class Chapter {
    private String id;
    private String name;
    private String type;
    private Object url;
    private Object slides;
    private List<Chapter> nodes;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getUrl() {
        return this.url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public Object getSlides() {
        return this.slides;
    }

    public void setSlides(Object slides) {
        this.slides = slides;
    }

    public List<Chapter> getNodes() {
        return this.nodes;
    }

    public void setNodes(List<Chapter> nodes) {
        this.nodes = nodes;
    }
}
