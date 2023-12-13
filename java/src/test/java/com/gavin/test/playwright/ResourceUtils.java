package com.gavin.test.playwright;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ResourceUtil;

/**
 * This class is for xxxx.
 *
 * @author com.gavin james
 */
public class ResourceUtils {
    public static String getFileStr(String filePath) {
        return ResourceUtil.readUtf8Str(filePath);
    }

    public static void writeFile(String data, String filePath) {
        FileUtil.writeUtf8String(data, ResourceUtil.getResource(filePath).getFile());
    }
}
