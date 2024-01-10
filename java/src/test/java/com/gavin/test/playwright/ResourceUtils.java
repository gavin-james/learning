package com.gavin.test.playwright;


import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * This class is for xxxx.
 *
 * @author com.gavin james
 */
public class ResourceUtils {
    public static String getFileStr(String filePath) {
        return FileUtil.readUtf8String(new File("src/test/resources/" + filePath));
    }

    public static void writeFile(String data, String filePath) {
        FileUtil.writeUtf8String(data, new File("src/test/resources/" + filePath));
    }
}
