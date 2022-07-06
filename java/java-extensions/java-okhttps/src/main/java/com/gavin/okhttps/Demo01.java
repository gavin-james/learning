package com.gavin.okhttps;

import com.ejlchina.okhttps.HTTP;
import com.ejlchina.okhttps.HttpResult;
import com.ejlchina.okhttps.OkHttps;
import com.ejlchina.okhttps.jackson.JacksonMsgConvertor;
import okhttp3.*;
import okhttp3.Request.Builder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Demo01 {

  public static void main(String[] args) throws IOException {

    String url = "https://ssxsuatexternal.companycn.net/api/Invoice";
    String jsonData = "qh5N9eTzrgFW1VSLtXtLr+SGo2L90HSuYND5W9w3W0elVFt2K4yTyfPuqTe4pAYIANmDBCVJHQBebXylEEnGHK6kOIpOUbKyxxn6OKmDU6rSmAgPUimmG97oOpyHlHXr5tHjAlGz+u86jkP7DjOdD05jHpkRb4MB+AhSxx+XXfjecgb4DDZ1gFanZs573pAJ3QCCjblV/ROAR+h+9vz5AJun+ArOvdMRLBwymXtfLmnA+5DeBkc/aFDA4t1RUH0sRNt6FF0ahMTeigfqi4nz2olJKnSb/mKllnRQcZrPsKv/Nb+V66+LCk1zQGa2ALozJUZNhPsclOJvQrnyd3xp1uOpx5KhQfTR+d3YhcrDdtseZp5QMfB5U78El/6DCM2YW66xc/xMZqebvZXB5zYkN/znGHx2k+Y+iDZ2IvlcfVHhnp8g+9ZftOoFHKD0vBKW+jcTvPcnwLNG/zTqdIcj3OrcWNFOALgGExKbcMJgbssMgjihhstQluJkwCykZV4CMml1Fq6jQZKgpSjHuv99Rb6StuW+ylFWZ+cpTnppoJy+pOjsdVAFXNloSZW8XrcuvjRbkch+V68siQ+dIbjp2FdWlzcGwuAskTpI5q7M2AV3JqMWKOnhJR/uuNStKkYeCyMqAK1mWwDkqqe0EtCgw1SRpmTBb3afJOvcV+qOLtMSJYhhqxIcWmU3BDHvRlAv";
//    jsonData = "{\"jsonData\":\"qh5N9eTzrgFW1VSLtXtLr+SGo2L90HSuYND5W9w3W0elVFt2K4yTyfPuqTe4pAYIANmDBCVJHQBebXylEEnGHK6kOIpOUbKyxxn6OKmDU6rSmAgPUimmG97oOpyHlHXr5tHjAlGz+u86jkP7DjOdD05jHpkRb4MB+AhSxx+XXfjecgb4DDZ1gFanZs573pAJ3QCCjblV/ROAR+h+9vz5AJun+ArOvdMRLBwymXtfLmnA+5DeBkc/aFDA4t1RUH0sRNt6FF0ahMTeigfqi4nz2olJKnSb/mKllnRQcZrPsKv/Nb+V66+LCk1zQGa2ALozJUZNhPsclOJvQrnyd3xp1uOpx5KhQfTR+d3YhcrDdtseZp5QMfB5U78El/6DCM2YW66xc/xMZqebvZXB5zYkN/znGHx2k+Y+iDZ2IvlcfVHhnp8g+9ZftOoFHKD0vBKW+jcTvPcnwLNG/zTqdIcj3OrcWNFOALgGExKbcMJgbssMgjihhstQluJkwCykZV4CMml1Fq6jQZKgpSjHuv99Rb6StuW+ylFWZ+cpTnppoJy+pOjsdVAFXNloSZW8XrcuvjRbkch+V68siQ+dIbjp2FdWlzcGwuAskTpI5q7M2AV3JqMWKOnhJR/uuNStKkYeCyMqAK1mWwDkqqe0EtCgw1SRpmTBb3afJOvcV+qOLtMSJYhhqxIcWmU3BDHvRlAv\"}";

    System.out.println(jsonData);

    String result = okhttps(url, jsonData);
    System.out.println("返回结果：" + result);
  }


  public static String okhttps(String url, String body) {
    ConnectionPool connectionPool = new ConnectionPool(10, 5, TimeUnit.MINUTES);
    HTTP http = HTTP.builder()
            .addMsgConvertor(new JacksonMsgConvertor())
            .config(e->{
              e.connectionPool(connectionPool);
            })
            .build();
    HttpResult httpResult = http.sync(url)
            .bodyType("json")
            .addBodyPara("jsonData", body)
            .post();
    connectionPool.evictAll();
    return httpResult.getBody().toString();
  }

  public static String okhttp3(String url, String body) {
    OkHttpClient okClient = new OkHttpClient.Builder().build();
    try {
      Request request = new Builder()
              .url(url)
              .post(RequestBody.create(MediaType.parse("application/json;charset=utf-8"), body))
              .build();
      Response execute = okClient.newCall(request).execute();
      assert execute.body() != null;
      return execute.body().string();
    } catch (IOException e) {
      e.printStackTrace();
      return "";
    }finally {
      okClient.connectionPool().evictAll();
    }
  }
}
