package com.gavin.oss;

import io.minio.*;
import io.minio.errors.MinioException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;
import plus.ojbk.minio.core.MinioTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@SpringBootTest

public class OSSTest {

  @Autowired
  private MinioTemplate minioTemplate;

  @Test
  void testMinio() throws Exception {
    System.out.println(minioTemplate);
    FileInputStream fileInputStream = new FileInputStream("D:\\Users\\Gavin\\Pictures\\20221423364839350.jpg");
//    MultipartFile multipartFile = fileInputStream;
//    UUID.randomUUID()
    MultipartFile multipartFile =null;
//    multipartFile.get
    String s = System.nanoTime() + "" + UUID.randomUUID();
    ObjectWriteResponse objectWriteResponse = minioTemplate.putObject("test-minio", "test.jpg", fileInputStream);
    System.out.println(objectWriteResponse.toString());
    //    minioTemplate.putObject();
  }

  @Test
  void test() {
    try {
      // Create a minioClient with the MinIO server playground, its access key and secret key.
      MinioClient minioClient =
              MinioClient.builder()
                      .endpoint("http://124.223.13.183:9000")
                      .credentials("admin", "admin123")
                      .build();

      // Make 'asiatrip' bucket if not exist.
      boolean found =
              minioClient.bucketExists(BucketExistsArgs.builder().bucket("test-minio").build());
      if (!found) {
        // Make a new bucket called 'asiatrip'.
        minioClient.makeBucket(MakeBucketArgs.builder().bucket("test-minio").build());
      } else {
        System.out.println("Bucket 'asiatrip' already exists.");
      }

      // Upload '/home/user/Photos/asiaphotos.zip' as object name 'asiaphotos-2015.zip' to bucket
      // 'asiatrip'.
      minioClient.uploadObject(
              UploadObjectArgs.builder()
                      .bucket("test-minio")
                      .object("20221423364839350.jpg")
                      .filename("D:\\Users\\Gavin\\Pictures\\20221423364839350.jpg")
                      .build());
      System.out.println(
              "'/home/user/Photos/asiaphotos.zip' is successfully uploaded as "
                      + "object 'asiaphotos-2015.zip' to bucket 'asiatrip'.");
    } catch (Exception e) {
      System.out.println("Error occurred: " + e);
      System.out.println("HTTP trace: " + e.getStackTrace());
    }
  }
}
