package com.gavin.knife4j.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @since:knife4j-springdoc-openapi-demo
 * @auth <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/8/6 16:26
 */
@Data
public class FileResp {

  @Schema(description = "随机名称")
  private String random;
  @Schema(description = "文件名称")
  private String name;
  @Schema(description = "文件大小")
  private Long size;
  @Schema(description = "是否上传成功")
  private Boolean success;
}
