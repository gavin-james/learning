package com.gavin.task.forest;

import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.annotation.XMLBody;

public interface SkpClient {

  @Post("http://localhost:5000/api/skp")
  String skp(@XMLBody String reqXml);

}
