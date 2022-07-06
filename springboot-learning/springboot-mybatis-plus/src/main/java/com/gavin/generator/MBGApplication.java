package com.gavin.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.gavin.generator.engine.MyVelocityTemplateEngine;

import java.util.Collections;
import java.util.HashMap;

public class MBGApplication {

  public static final String URL = "jdbc:mysql://localhost:3306/cityo2o_admin?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
  public static final String USERNAME = "root";
  public static final String PASSWORD = "123456";

  public static void main(String[] args) {
    String pkgPath = System.getProperty("user.dir") + "/src/main/java";
    // 自己的模板
    HashMap<String, String> customFile = new HashMap<>();
    customFile.put("hi.txt", "/templates/hi.vm");
    customFile.put("sample.vue", "/templates/vue.vm");
    customFile.put("entityVo.java", "/templates/entityVo.java.vm");
    customFile.put("entityTo.java", "/templates/entityTo.java.vm");
    customFile.put("entityObjMapper.java", "/templates/entityMapper.java.vm");

    // 连接上数据库
    FastAutoGenerator.create(URL, USERNAME, PASSWORD)
            // 全局配置
            .globalConfig(builder ->
                    builder.fileOverride()
                            .outputDir(pkgPath)
                            .author("Gavin")
                            .enableSwagger()
                            .commentDate("yyyy-MM-dd")
                            .enableSwagger()
                            .fileOverride()
                            .disableOpenDir()
            )
            // 包配置
            .packageConfig(builder ->
                    builder.parent("com.gavin")
                            .moduleName("mbg")
            )
            // 注入配置
            .injectionConfig(builder ->
                    builder.customMap(Collections.singletonMap("test", "baomidou"))// 这里是自定义传入模板参数值
                            .customFile(customFile)
                            .build())
            // 策略配置 sample
            .strategyConfig((scanner, builder) ->
                    builder.entityBuilder() // 实体类策略
                            .enableChainModel() // 开启链式调用
                            .enableLombok()// 开启Lombok链式调用
                            .enableTableFieldAnnotation() // 开启 TableField 注解
                            .addSuperEntityColumns("id", "version", "is_deleted", "created_by", "created_time", "updated_by", "updated_time")
                            .addTableFills(new Column("create_time", FieldFill.INSERT))
                            .addTableFills(new Column("update_time", FieldFill.INSERT))

                            .controllerBuilder() // 前端控制器策略
                            .enableRestStyle() // 开启 RestController
                            .enableHyphenStyle() // 开启驼峰

                            .mapperBuilder()
                            .enableBaseResultMap()
                            .enableBaseColumnList()
                            .build()

            )
            // 模板引擎的某个方法
            .templateEngine(new MyVelocityTemplateEngine())
            .execute();
  }

}
