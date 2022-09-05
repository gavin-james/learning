package com.gavin.task.service;

import com.gavin.task.forest.SkpClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SkpService {

  final SkpClient skpClient;

  public void drzcm() {
    String reqXml = "<?xml version=\"1.0\" encoding=\"gbk\"?><service><sid>FPBQ</sid><data><record><nsrsbh>500310000SHBW15002</nsrsbh><skpbh>499000135664</skpbh><skpkl>88888888</skpkl><keypwd>12345678</keypwd><fplxdm>004</fplxdm><cxfs>0</cxfs><cxtj>11100100048972090189720901</cxtj><cxlx>0</cxlx></record></data></service>";
    String resXml = skpClient.skp(reqXml);
    log.info(resXml);
  }

  @Scheduled(cron = "0 0/20 * * * ? ")
  public void fpcx() {
    String reqXml = "<?xml version=\"1.0\" encoding=\"gbk\"?><service><sid>FPCX</sid><data><record><nsrsbh>500310000SHBW15002</nsrsbh><skpbh>499000135664</skpbh><skpkl>88888888</skpkl><keypwd>12345678</keypwd><fplxdm>004</fplxdm><cxfs>0</cxfs><cxtj>11100100048972090189720901</cxtj><cxlx>0</cxlx></record></data></service>";
    String resXml = skpClient.skp(reqXml);
    if (resXml.contains("注册码错误")) {
      log.error(resXml);
    } else {
      log.info(resXml);
    }
  }
}
