package com.gavin.atguigu.jdk;

import java.io.InputStream;
import java.util.Calendar;

// 使用了工厂模式的源码g
public class Factory {
  public static void main(String[] args) {
    // 日期的静态方法
    Calendar cal = Calendar.getInstance();
    // 注意月份下标从 0 开始 所以月份要 + 1
    System.out.println("年：" + cal.get(Calendar.YEAR));
    System.out.println("月：" + (cal.get(Calendar.MONTH) + 1));
    System.out.println("日：" + cal.get(Calendar.DAY_OF_MONTH));
    System.out.println("时：" + cal.get(Calendar.HOUR_OF_DAY));
    System.out.println("分：" + cal.get(Calendar.MINUTE));
    System.out.println("秒：" + cal.get(Calendar.SECOND));

    System.out.println("0404a9c8fdb4ccd7dbb7fb038570e959be91d018c03bb258336af767c187e5bd1bd22b1de00cbb754ba9938157f64f51915bab8641e7610cd135ce0c0faeeaabe94210ecc77942768d1b79c862432d738f4b259d06acd20f808342715c392512a44771e5f689b43eb4424a1417af473de42d60cf851ea07ed4554f3252e480d4582b41bb168cc252f1985a45094bbcf949ce88337aab6af24f37724d13b732cb9e1e7507477c34c5912e137b9c4936b0f5d9b144010de678a68a92100966451aa0148c58e3fc258db7d8a6a0b51dc0a94475d6a4341170455d2eef6ce58b458a017ac408bad274081fdb6fb85c1a76465c8b55916ba328a3d391d3b52b1e892d20029dabc8cf937282f4afe9bc6ffb966fc49c8f08d131f16b761454478cdea512256b4e8c1eb58ffb131ae4a980a2720d81fa334640bb7758ef0b4fc1a48b112f7eb457ad77a0d8189e9383ce2a4ca11a3505fcfa2faad15ac03c899f7b73285e97a2e4ca41a5586558cbd48b9ff1ae9cb9f6dde604f40bc3762031c88ad91240a0f83ce5a17fad79fce0ca7f04bd954bce3c5e0e8c7a7770b4f6de92f672cc163b07835b6267b04e4b005dee6941888527b34d7e4b8e605420313d9433923c091bb20596001ff85693e6ac6bb7c6f46507ac8758fe4437dc8c9438a4be5eda59ab05fcfa2faad15ac02031c88ad91240a0f3a12762b39debe9603cb6f71de9ae50be080200b9e150af076decdba56c633f1ac9293b8cd3947c96ecaddc5df74781ea66a8b30a22132e3011f712b032e61e907bdefc3e19c62eabbed45eb72c6ac7db6c392fce523a85963de0cfb73824a16174b4e294f62ee78b77ddf97646a180774a4f137025db9e5c4e5bf665da0853d43c7ce4a08a0d594b1cc61c9bd74599a1b3d8d26fe7d8f81703f847386245e82706607ae73fa5f8975e5f1c0f6053289b965d3e3b5af9948fdc82a293f37ed3c6a477b1ff27e282245bbe4f4c298ee2accbe030b0346a9b7016cd09726894f943a4b584362b15775fd2e2b9e6270cc8314471531e72ca1b9d8dd235aca8b838ce5d892de2e31a50abf87330b3ffd6ac79064504".length());
  }
}
