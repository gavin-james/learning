//package jna;
//
//import cn.hutool.system.oshi.OshiUtil;
//import com.sun.jna.Library;
//import com.sun.jna.Native;
//import com.sun.jna.Platform;
//import org.junit.jupiter.api.Test;
//
//import java.nio.charset.StandardCharsets;
//
//public class JnaTes {
//  /**
//   * 声明解密的接口以及对应的方法
//   */
//  public interface CLibrary extends Library {
//
//    // DLL文件默认路径为项目根目录，若DLL文件存放在项目外，请使用绝对路径。（此处：(Platform.isWindows()?"DatEnDe":"c")指本地动态库DatEnDe.dll）
//    CLibrary INSTANCE = (CLibrary) Native.loadLibrary("C:/Program Files (x86)/税控盘组件接口/NISEC_SKPC.dll",
//            CLibrary.class);
//
//    // 声明将要调用的DLL中的方法,可以是多个方法(此处示例调用本地动态库DatEnDe.dll中的printf()方法)
//    int OperateDisk(String a, byte[] b);
//  }
//
//  @Test
//  void testJna() {
//    byte[] out = new byte[102400];
//
//    CLibrary.INSTANCE.OperateDisk("<?xml version=\"1.0\" encoding=\"gbk\"?>\n" +
//            "<business comment=\"税控盘信息查询\" id=\"SKPXXCX\">\n" +
//            "<body yylxdm=\"1\">\n" +
//            "<input>\n" +
//            "<skpkl>88888888</skpkl>\n" +
//            "</input>\n" +
//            "</body>\n" +
//            "</business>", out);
//
//    System.out.println(new String(out, StandardCharsets.UTF_8));
//  }
//}
