package con.gavin.forest.baidu;

import com.dtflys.forest.annotation.Get;

public interface BaiduService {

  @Get("http://www.baidu.com")
  String helloForest();
}
