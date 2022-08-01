import org.junit.jupiter.api.Test;

public class MysqlTest {


  public static String translateSql(String startTime, String endTime, String xhdwdm) {
    String headSql = "SELECT t1.fplxdm AS fplx, ROUND(t2.sl, 2) AS sl , ROUND(sum(CASE  WHEN t2.spbm REGEXP '^1|2' THEN t2.je ELSE 0 END), 2) AS fpje_n , ROUND(sum(CASE  WHEN t2.spbm REGEXP '^1|2' THEN t2.se ELSE 0 END), 2) AS fpse_n , ROUND(sum(CASE  WHEN t2.spbm REGEXP '^3|4|5' THEN t2.je ELSE 0 END), 2) AS fpje_y , ROUND(sum(CASE  WHEN t2.spbm REGEXP '^3|4|5' THEN t2.se ELSE 0 END), 2) AS fpse_y FROM ";
    String nextSql = " t1 INNER JOIN ";
    String endSql = " t2 ON t1.fphm = t2.fphm AND t1.fpdm = t2.fpdm AND (t1.fpzt = '00' OR t1.fpzt = '01') WHERE t1.kprq >= \"" + startTime + "\" AND t1.kprq <= \"" + endTime + "\" AND t1.xhdwdm = \"" + xhdwdm + "\" GROUP BY t2.sl, t1.fplxdm ORDER BY t1.fplxdm";
    String unionSql = ") UNION (";
    return "(" + headSql + "pj_zzspdz_fpmx" + nextSql + "pj_zzspdz_fpmxzb" + endSql + unionSql + headSql + "pj_zzsp_fpmx" + nextSql + "pj_zzsp_fpmxzb" + endSql + unionSql + headSql + "pj_zzsz_fpmx" + nextSql + "pj_zzsz_fpmxzb" + endSql + ")";
  }

  @Test
  void testSql() {
    System.out.println(translateSql("20100109211327", "20220109211327", "91310105550043961D"));
  }


}
