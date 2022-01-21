package com.gavin;

import com.github.yitter.contract.IIdGenerator;
import com.github.yitter.contract.IdGeneratorOptions;
import com.github.yitter.idgen.DefaultIdGenerator;
import com.github.yitter.idgen.YitIdHelper;
import com.github.yitter.test.GenTest;
import org.junit.jupiter.api.Test;

public class TestApplication {

  /**
   * 测试单机的时候用 YitIdHelper 生成
   */
  @Test
  void test() {
// 创建 IdGeneratorOptions 对象，请在构造函数中输入 WorkerId：
    short a = 1;
    IdGeneratorOptions options = new IdGeneratorOptions(a);
// options.WorkerIdBitLength = 10; // WorkerIdBitLength 默认值6，支持的 WorkerId 最大值为2^6-1，若 WorkerId 超过64，可设置更大的 WorkerIdBitLength
// ...... 其它参数设置参考 IdGeneratorOptions 定义，一般来说，只要再设置 WorkerIdBitLength （决定 WorkerId 的最大值）。

// 保存参数（必须的操作，否则以上设置都不能生效）：
    YitIdHelper.setIdGenerator(options);
// 以上初始化过程只需全局一次，且必须在第2步之前设置。

    // 初始化以后，即可在任何需要生成ID的地方，调用以下方法：
    long newId = YitIdHelper.nextId();

    System.out.println(newId);
  }

  /**
   * 测试使用 IIdGenerator 生成 id
   */
  @Test
  void genTest() {
    IdGeneratorOptions options = new IdGeneratorOptions();
//    options.WorkerIdBitLength = 6;
//    options.SeqBitLength = 6;
//    options.TopOverCostCount = 2000;
//    options.MinSeqNumber = 5;
//    options.MaxSeqNumber = 200;

    options.Method = 1;
    options.WorkerId = 30;

    IIdGenerator idGen = new DefaultIdGenerator(options);
    System.out.println("这是用方法  漂移算法  生成的 Id：" + idGen.newLong());

  }


}
