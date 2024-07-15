package com.gavin.james;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.net.url.UrlQuery;
import cn.hutool.core.text.StrPool;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.dromara.x.file.storage.core.UploadPretreatment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.nio.charset.StandardCharsets;

@SpringBootTest
public class FileApplicationTest {
    @Autowired
    private FileStorageService fileStorageService;//注入实列
    @Autowired
    private ObjectMapper jackson;//注入实列

    @Test
    void upload() throws JsonProcessingException {
//        this.fileStorageService
        //手动构造文件信息，可用于其它操作
        File file = FileUtil.file("/Users/mac/Documents/研发服务器信息.docx");
        UploadPretreatment uploadPretreatment = this.fileStorageService.of(file);
        FileInfo upload = uploadPretreatment.upload();
        System.out.println(this.jackson.writeValueAsString(upload));
    }

    @Test
    void uploadByUrl() throws JsonProcessingException {
//        this.fileStorageService
        //手动构造文件信息，可用于其它操作
        String fileUrl = "https://dppt.shanghai.chinatax.gov.cn:8443/kpfw/fpjfzz/v1/exportDzfpwjEwm?Wjgs=PDF&Jym=522C&Fphm=23312000000079149234&Kprq=20230915140931&Czsj=1694758173603";
        System.out.println();
        UrlQuery urlQuery = UrlQuery.of(StrUtil.subAfter(fileUrl, '?', true), StandardCharsets.UTF_8);
        String fphm = (String) urlQuery.get("Fphm");
        String wjgs = (String) urlQuery.get("Wjgs");
        UploadPretreatment uploadPretreatment = this.fileStorageService.of(fileUrl);
        uploadPretreatment.setSaveFilename(fphm + StrPool.DOT + wjgs.toLowerCase());
        FileInfo upload = uploadPretreatment.upload();
        System.out.println(upload.getUrl());
    }
}