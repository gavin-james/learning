package jxfp;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

public class RpaFs {
	private String get_type; //请求类型 0下载 1查询 2请求下载 3发票勾选/取消勾选 4：
	private String tax_no;   //税号
	private String time_q;	//截止日期起
	private String time_z;  //截止日期止
	private String inv_code;  //发票代码
	private String inv_num;	  //发票号码
	private String inv_type;	//发票类别
	private String inv_type1;//发票类型 1：增值税专用发票，7：增值税专用发票（电子），7xdp：电子发票（增值税专用发票），2：机动车销售统一发票，3：增值税普通发票，4：增值税普通发票（电子），4xdp：电子发票（普通发票），5：增值税普通发票（卷票），6：二手车销售统一发票，8：道路通行费电子普通发票，
	private String inv_date;  //开票日期
	private String inv_source; //发票来源  0：全部，1：全电发票，2：税控发票
	private String is_check;   //勾选属性，0：取消勾选 1：勾选
	private String is_statistic; //申请统计属性 0：取消统计 1：申请统计
	private String  pass_word1;//发票下载解压密码
	private static String  pass_word = "88888888";
	
	public RpaFs(String get_type, String tax_no, String time_q, String time_z, String inv_code, String inv_num,
			String inv_type,String inv_type1, String inv_date, String inv_source,String pass_word1,String is_check,String is_statistic) {
		super();
		this.get_type = get_type;
		this.tax_no = tax_no;
		this.time_q = time_q;
		this.time_z = time_z;
		this.inv_code = inv_code;
		this.inv_num = inv_num;
		this.inv_type = inv_type;
		this.inv_type1 = inv_type1;
		this.inv_date = inv_date;
		this.inv_source = inv_source;
		this.pass_word = pass_word;
		this.pass_word1 = pass_word1;
		this.is_check = is_check;
		this.is_statistic = is_statistic;
	}

	
	public String getGet_type() {
		return get_type;
	}
	public void setGet_type(String get_type) {
		this.get_type = get_type;
	}
	public String getTax_no() {
		return tax_no;
	}
	public void setTax_no(String tax_no) {
		this.tax_no = tax_no;
	}
	public String getTime_q() {
		return time_q;
	}
	public void setTime_q(String time_q) {
		this.time_q = time_q;
	}
	public String getTime_z() {
		return time_z;
	}
	public void setTime_z(String time_z) {
		this.time_z = time_z;
	}
	public String getInv_code() {
		return inv_code;
	}
	public void setInv_code(String inv_code) {
		this.inv_code = inv_code;
	}
	public String getInv_num() {
		return inv_num;
	}
	public void setInv_num(String inv_num) {
		this.inv_num = inv_num;
	}
	
	public String getInv_date() {
		return inv_date;
	}
	public void setInv_date(String inv_date) {
		this.inv_date = inv_date;
	}
	public String getInv_source() {
		return inv_source;
	}
	public void setInv_source(String inv_source) {
		this.inv_source = inv_source;
	}
	public String getInv_type() {
		return inv_type;
	}
	public void setInv_type(String inv_type) {
		this.inv_type = inv_type;
	}
	
	public String getInv_type1() {
		return inv_type1;
	}


	public void setInv_type1(String inv_type1) {
		this.inv_type1 = inv_type1;
	}


	public String getPass_word() {
		return pass_word;
	}
	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
	
	public  String getPass_word1() {
		return pass_word1;
	}


	public  void setPass_word1(String pass_word1) {
		this.pass_word1 = pass_word1;
	}
	
	


	/**
	 * @return the is_check
	 */
	public String getIs_check() {
		return is_check;
	}


	/**
	 * @param is_check the is_check to set
	 */
	public void setIs_check(String is_check) {
		this.is_check = is_check;
	}


	/**
	 * @return the is_statistic
	 */
	public String getIs_statistic() {
		return is_statistic;
	}


	/**
	 * @param is_statistic the is_statistic to set
	 */
	public void setIs_statistic(String is_statistic) {
		this.is_statistic = is_statistic;
	}


	public RpaFs() {
		
	}
	public static String RpatoStr(RpaFs rpafs) {
		ObjectMapper mapper = new ObjectMapper();

		//对象转String空值设定为""
        mapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException, JsonProcessingException {
                arg1.writeString("");
            }
        });
		String json = null;
		try {
			json = mapper.writeValueAsString(rpafs);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	

}
