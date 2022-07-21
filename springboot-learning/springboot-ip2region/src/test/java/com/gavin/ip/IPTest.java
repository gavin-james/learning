package com.gavin.ip;

import com.github.hiwepy.ip2region.spring.boot.IP2regionTemplate;
import com.github.hiwepy.ip2region.spring.boot.ext.RegionAddress;
import com.github.hiwepy.ip2region.spring.boot.ext.RegionEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class IPTest {
  @Autowired
  IP2regionTemplate template;

  @Test
  void tesIp() throws Exception {
    System.out.println(template.btreeSearch("61.94.43.82"));
    System.out.println(template.binarySearch("61.94.43.82"));
    System.out.println(template.memorySearch("61.94.43.82"));
    System.out.println(template.binarySearch("127.0.0.1"));

    // 根据IP获取对应国家
    System.out.println(template.getCountryByIp("127.0.0.1"));

    // 根据IP获取对应地区
    System.out.println(template.getRegion("114.124.146.103"));

    // 根据IP获取对应地区详细信息对象
    RegionAddress adress1 = template.getRegionAddress("113.210.53.80");
    System.out.println(adress1);
    System.out.println(RegionEnum.getByRegionAddress(adress1));

    // 根据IP获取对应地区枚举
    RegionEnum regionEnum = template.getRegionByIp("102.42.140.162");
    System.out.println(regionEnum);
  }
}
