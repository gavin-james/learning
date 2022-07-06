import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;

public class ExcelTest {
  public static void main(String[] args) {
//    String fileName = "E:\\JAVASpace\\learning\\java\\java-shbw\\src\\test\\resources\\工作簿1.xlsx";
//    // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//    DemoDataListener demoDataListener = new DemoDataListener();
//    EasyExcel.read(fileName, DemoData.class, demoDataListener).sheet().doRead();

//    new PageReadListener<DemoData>(dataList -> {
//      for (DemoData demoData : dataList) {
//        System.out.println(demoData);
//      }
//    })

    String invoiceDate = "20200815103244";
    System.out.println(invoiceDate.substring(0, 4) + "-" + invoiceDate.substring(4, 6) + "-" + invoiceDate.substring(6, 8));

    System.out.println(String.format("%.2f", Double.parseDouble("0.060000000000000000")));
  }
}
