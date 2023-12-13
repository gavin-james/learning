import cn.hutool.core.io.file.FileReader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.stream.Collectors;

public class SHBWTest {
  @Test
  void test() {
    String nsrsbh = "91320412MA1WKD3445";
    String res = MD5Helper.Encode(nsrsbh);
    System.out.println(res + "   长度" + res.length());
  }

  @Test
  void testText() {
    FileReader fileReader = new FileReader("E:\\JAVASpace\\learning\\java\\java-shbw\\src\\test\\resources\\初始化.txt");
    List<String> strings = fileReader.readLines();
    List<DemoData> collect = strings.stream().map(i -> {
      String[] split = i.split("\\s");
      DemoData demoData = new DemoData();
      demoData.setServerIp(split[1]);
      demoData.setNsrsbh(split[2]);
      demoData.setQymc(split[3]);
      demoData.setPort(split[4]);
      demoData.setKey(split[5]);
      demoData.setAppKey(split[6]);
      demoData.setOpenid(split[7]);
      demoData.setAppsecret(split[8]);
      demoData.setType(split[9]);
      demoData.setValid(split[10]);
      return demoData;
    }).collect(Collectors.toList());
    System.out.println(collect.size());
    System.out.println(JSON.toJSONString(collect));

  }

}


