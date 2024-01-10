import cn.hutool.core.util.CharsetUtil;
import org.junit.jupiter.api.Test;

public class SHBWTest {
    @Test
    void zongkongText() {
        String str = "<?xml version=\"1.0\" encoding=\"gbk\"?>\n" +
                "<business id=\"30010\" comment=\"发票开具\">\n" +
                "\t<body yylxdm=\"1\">\n" +
                "\t\t<kpzdbs>499111002784</kpzdbs>\n" +
                "\t\t<fplxdm>007</fplxdm>\n" +
                "\t\t<fpqqlsh>SQ20231220001</fpqqlsh>\n" +
                "\t\t<kplx>0</kplx>\n" +
                "\t\t<tspz>00</tspz>\n" +
                "\t\t<xhdwsbh>50012345671180277</xhdwsbh>\n" +
                "\t\t<xhdwmc>上海百旺金赋科技有限公司24</xhdwmc>\n" +
                "\t\t<xhdwdzdh>住址电话13918787897</xhdwdzdh>\n" +
                "\t\t<xhdwyhzh>银行345211999878765678</xhdwyhzh>\n" +
                "\t\t<ghdwsbh>91310104057643445Y</ghdwsbh>\n" +
                "\t\t<ghdwmc>上海百旺金赋科技有限公司</ghdwmc>\n" +
                "\t\t<ghdwdzdh>上海市徐汇区古美路1528号A4幢7层021-23539199</ghdwdzdh>\n" +
                "\t\t<ghdwyhzh>工行漕河泾开发区支行1001266319200354344</ghdwyhzh>\n" +
                "\t\t<qdbz>0</qdbz>\n" +
                "\t\t <zsfs>0</zsfs>\n" +
                "\t\t <fyxm count=\"1\">\n" +
                "\t      <group xh=\"1\">\n" +
                "\t        <fphxz>0</fphxz>\n" +
                "\t        <spmc>铝制软管</spmc>\n" +
                "\t        <spsm></spsm>\n" +
                "\t        <ggxh></ggxh>\n" +
                "\t        <dw>支</dw>\n" +
                "\t        <spsl>800000.00</spsl>\n" +
                "\t        <dj>0.110619</dj>\n" +
                "\t        <je>88495.58</je>\n" +
                "\t        <sl>0.13</sl>\n" +
                "\t        <se>11504.42</se>\n" +
                "\t        <hsbz>1</hsbz>\n" +
                "\t        <spbm>1080306010000000000</spbm>\n" +
                "\t        <zxbm></zxbm>\n" +
                "\t        <yhzcbs>0</yhzcbs>\n" +
                "\t        <lslbs></lslbs>\n" +
                "\t        <zzstsgl></zzstsgl>\n" +
                "\t      </group>\n" +
                "\t    </fyxm>\n" +
                "\t\t <hjje>88495.58</hjje>\n" +
                "\t    <hjse>11504.42</hjse>\n" +
                "\t    <jshj>100000.00</jshj>\n" +
                "\t\t<bz>测试备注</bz>\n" +
                "\t\t<skr>测试</skr>\n" +
                "\t\t<fhr>测试</fhr>\n" +
                "\t\t<kpr>系统管理员</kpr>\n" +
                "\t\t<dqfpdm>050000000004</dqfpdm>\n" +
                "\t\t<dqfphm>79340185</dqfphm>\n" +
                "\t\t<gfyxdz></gfyxdz>\n" +
                "\t\t<gfsjhm></gfsjhm>\n" +
                "\t\t<tzdbh></tzdbh>\n" +
                "\t\t<yfpdm></yfpdm>\n" +
                "\t\t<yfphm></yfphm>\n" +
                "\t</body>\n" +
                "</business>";
        String convertGbk = CharsetUtil.convert(str, CharsetUtil.UTF_8, CharsetUtil.GBK);
        String convert = CharsetUtil.convert(convertGbk, CharsetUtil.GBK, CharsetUtil.UTF_8);
        System.out.println(convert);

    }
}


