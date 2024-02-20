package com.gavin.test.playwright;

public class Res<T> {

    private T data;
    private String message;
    private Object extraData;
    private Integer hr;

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getExtraData() {
        return this.extraData;
    }

    public void setExtraData(Object extraData) {
        this.extraData = extraData;
    }

    public Integer getHr() {
        return this.hr;
    }

    public void setHr(Integer hr) {
        this.hr = hr;
    }
}
