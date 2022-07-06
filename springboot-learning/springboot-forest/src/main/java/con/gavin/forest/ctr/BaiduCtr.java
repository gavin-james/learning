package con.gavin.forest.ctr;

import con.gavin.forest.baidu.BaiduService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BaiduCtr {

  @Resource
  BaiduService baiduService;

  @RequestMapping("hello")
  String search() {
    return baiduService.helloForest();
  }
}
