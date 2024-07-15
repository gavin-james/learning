import cn.hutool.core.util.CharsetUtil;
import com.gavin.shbw.HttpClientHelper;
import org.junit.jupiter.api.Test;

public class SHBWTest {
    @Test
    void ypjgText() {
        try {
            String res = HttpClientHelper.nowSaaSPost("http://api.baiwangjs.com/swgx-saas/agentinvoiceservice-cloudservice-cloudservice/agentiscloud/cloud/applyInvoice", "eyJxeUlkIjoiMjQwMzI3MTM1MzUyMDM2Mjk2OCIsImRkbHNoIjoiMDAwMDAwMDAwMjAyNDA0MDcwOTQ3NDgwMDA1Njk0NTAiLCJza3NiaCI6IjkxMzEwMDAwMDgwMDY2NTg2RCIsImZwbHhkbSI6IjAyIiwia3BseCI6IjAiLCJ0c3B6IjoiMDYiLCJ6c2ZzIjoiMCIsInFkYnoiOiIwIiwieHNmTWMiOiLkuIrmtbflqIHkuqzllYbkuJrnu4/okKXnrqHnkIbmnInpmZDlhazlj7giLCJ4c2ZOc3JzYmgiOiI5MTMxMDAwMDA4MDA2NjU4NkQiLCJ4c2ZEemRoIjoi5reu5rW35Lit6LevMzgx5Y+35Lit546v5bm/5Zy6MTh+fjIzMjk2OTA1IiwieHNmWWh6aCI6IuS4reWbvemTtuihjOS4remTtuWkp+WOpuaUr+ihjH5+NDU0NjY1MjQ3MzQ0IiwiZ21mTWMiOiLkuKrkuroiLCJnbWZOc3JzYmgiOiIiLCJnbWZEemRoIjoifn4iLCJnbWZZaHpoIjoifn4iLCJnbWZNb2JpbGUiOiIiLCJnbWZFbWFpbCI6IjI0OTU1Mzk4NzhAcXEuY29tIiwia3ByIjoi6JGj5L2z5oWnIiwianNoaiI6IjEuMDAiLCJoamplIjoiMC45MiIsImhqc2UiOiIwLjA4IiwiYnoiOiJUV09pdGPlgZzovablj5HnpagiLCJrY2UiOiIiLCJzcXIiOiLokaPkvbPmhaciLCJjaGVja0F1ZGl0IjoiMCIsImRsemgiOiIxODcyMTIwMjIxMyIsInpqaG0iOiIzMTAxMTMxOTk3MDcwMTE0MjYiLCJnbWZ6cnJicyI6IlkiLCJkZXRhaWxQYXJhbSI6W3siZnBoeHoiOiIwIiwiaHNieiI6IjAiLCJzcG1jIjoi5YGc6L2m6LS5Iiwic3BibSI6IjMwNDA1MDIwMjAyMDAwMDAwMDAiLCJkdyI6IuasoSIsImRqIjoiMC45MiIsInNsIjoiMSIsImplIjoiMC45MiIsInNlIjoiMC4wOCIsInNsdiI6IjAuMDkiLCJ5aHpjYnMiOiIxIiwienhibSI6IiJ9XSwiYmRjVGR5cyI6eyJiZGNkeiI6IuS4iua1t+W4guW+kOaxh+WMuiIsImZ1bGxBZGRyZXNzIjoi5oGt5Z+O6LevMTYw5Y+3IiwiemxxcXoiOiIyMDI0LTA0LTA3IDIwMjQtMDQtMDciLCJrZHNieiI6Ik4iLCJjcXpzaCI6IuaXoCIsImR3Ijoi5bmz5pa557GzIn19", "json", "36AwHga8HHYom8aXBlQe7536", "9J2Ge88mLvXZ4OYH2Qfhl2NGmKmK9g");
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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


