package com.gavin.test.playwright;

import com.dtflys.forest.annotation.*;

@Address(host = "oa.htjs.net")
@BaseRequest(sslProtocol = "TLS")
public interface RzClient {

    /**
     * 获取工作日志
     */
    @Get("/server/OA/bgyfy/gzlgl_fylr/index.jsp")
    String gzlgl_fylr();

    /**
     * 获取工作内容添加弹窗
     */
    @Get("/server/OA/bgyfy/gzlgl_fylr/insert.jsp")
    String gzrzInsert();

    /**
     * 添加工作日志请求
     */
    @Post("/server/OA/bgyfy/gzlgl_fylr/handleInsert.jsp")
    String gzrzHandleInsert(@Body("ACCOUNTID") String ACCOUNTID, @Body("JBDM") String JBDM, @Body("ID") String ID, @Body("GZXZ") String GZXZ, @Body("GZXZ_RADIO") String GZXZ_RADIO, @Body("HTHM") String HTHM, @Body("GZRQ") String GZRQ, @Body("nowTime") String nowTime, @Body("timezoon") String timezoon, @Body("STARTTIME") String STARTTIME, @Body("ENDTIME") String ENDTIME, @Body("GZSC") String GZSC, @Body("XXSC") String XXSC, @Body("GZNR") String GZNR);


    @Get("/server/OA/bgyfy/gzlgl_fylr/edit.jsp")
    String gzrzEdit(@Query("ID") String ID);

    @Post("/server/OA/bgyfy/gzlgl_fylr/handleEdit.jsp")
    String gzrzHandleEdit(@Body("JBDM") String JBDM, @Body("ID") String ID, @Body("GZXZ") String GZXZ, @Body("GZXZ_RADIO") String GZXZ_RADIO, @Body("GZRQ") String GZRQ, @Body("nowTime") String nowTime, @Body("timezoon") String timezoon, @Body("STARTTIME") String STARTTIME, @Body("ENDTIME") String ENDTIME, @Body("GZSC") String GZSC, @Body("XXSC") String XXSC, @Body("GZNR") String GZNR, @Body("bc") String bc);
}
