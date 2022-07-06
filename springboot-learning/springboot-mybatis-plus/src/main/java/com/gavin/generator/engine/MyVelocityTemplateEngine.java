package com.gavin.generator.engine;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MyVelocityTemplateEngine extends VelocityTemplateEngine {
  @Override
  protected void outputCustomFile(@NotNull Map<String, String> customFile, @NotNull TableInfo tableInfo, @NotNull Map<String, Object> objectMap) {
    String entityName = tableInfo.getEntityName();
    String otherPath = getPathInfo(OutputFile.other);
    String entityPath = getPathInfo(OutputFile.entity);
    customFile.forEach((key, value) -> {
      String fileName = String.format((otherPath + File.separator + entityName + File.separator + "%s"), key);
      if (key == "entityVo.java") {
        fileName = String.format((entityPath + File.separator + "vo" + File.separator + entityName + "%s"), key);
      }
      if (key == "entityTo.java") {
        fileName = String.format((entityPath + File.separator + "to" + File.separator + entityName + "%s"), key);
      }
      if (key == "entityObjMapper.java") {
        fileName = String.format((entityPath + File.separator + "mapper" + File.separator + entityName + "%s"), key);
      }
      outputFile(new File(fileName), objectMap, value);
    });
  }
  //  private VelocityEngine velocityEngine;
//  private ZipOutputStream zip;
//
//  public MyVelocityTemplateEngine(ZipOutputStream zip) {
//    this.zip = zip;
//  }
//
//  {
//    try {
//      Class.forName("org.apache.velocity.util.DuckType");
//    } catch (ClassNotFoundException e) {
//      // velocity1.x的生成格式错乱 https://github.com/baomidou/generator/issues/5
//      logger.warn("Velocity 1.x is outdated, please upgrade to 2.x or later.");
//    }
//  }
//
//  @Override
//  public @NotNull MyVelocityTemplateEngine init(@NotNull ConfigBuilder configBuilder) {
//    if (null == velocityEngine) {
//      Properties p = new Properties();
//      p.setProperty(ConstVal.VM_LOAD_PATH_KEY, ConstVal.VM_LOAD_PATH_VALUE);
//      p.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, StringPool.EMPTY);
//      p.setProperty(Velocity.ENCODING_DEFAULT, ConstVal.UTF8);
//      p.setProperty(Velocity.INPUT_ENCODING, ConstVal.UTF8);
//      p.setProperty("file.resource.loader.unicode", StringPool.TRUE);
//      velocityEngine = new VelocityEngine(p);
//    }
//    return this;
//  }


//  @Override
//  public void writer(@NotNull Map<String, Object> objectMap, @NotNull String templatePath, @NotNull File outputFile) throws Exception {
//    Template template = velocityEngine.getTemplate(templatePath, ConstVal.UTF8);
//    try (StringWriter sw = new StringWriter()) {
//      template.merge(new VelocityContext(objectMap), sw);
//      //添加到zip
//      zip.putNextEntry(new ZipEntry(Objects.requireNonNull(outputFile.getPath())));
//      IOUtils.write(sw.toString(), zip, StandardCharsets.UTF_8);
//      IOUtils.closeQuietly(sw);
//      zip.closeEntry();
//    }
////    logger.debug("模板:" + templatePath + ";  文件:" + outputFile);
//  }


//  @Override
//  public @NotNull String templateFilePath(@NotNull String filePath) {
//    final String dotVm = ".vm";
//    return filePath.endsWith(dotVm) ? filePath : filePath + dotVm;
//  }
}
