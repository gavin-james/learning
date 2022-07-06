package jxfp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bw.jxjc.util.EscapeUnescape;
import com.bw.jxjc.util.JackjsonUtil;
import com.bw.jxjc.util.ObjUtil;
import com.bw.jxjc.util.SjZhUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RpaJs {
	
	private String code;//0:成功，1：失败
	private RpaData data;
	private String msg;
	private String value;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public RpaData getData() {
		return data;
	}
	public void setData(RpaData data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "RpaJs [code=" + code + ", data=" + data + ", msg=" + msg + ", value=" + value + "]";
	}

	public RpaJs() {
		super();
	}


	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public RpaJs(String code, RpaData data, String msg, String value) {
		super();
		this.code = code;
		this.data = data;
		this.msg = msg;
		this.value = value;
	}
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@SuppressWarnings("unchecked")
	public static FpFpxx DataToFpxx(String data,String fplx) {
		FpFpxx fpFpxx = new FpFpxx();
		//发票信息字段
		Map<String, Object> fpxx = JackjsonUtil.praseJson(data, Map.class);
		//发票明细字段
		List<RpaDetail> fpmx = new ArrayList<RpaDetail>();
		if(fpxx.get("details")!=null) {

			ObjectMapper mapper = new ObjectMapper();
			fpmx = mapper.convertValue(fpxx.get("details"), new TypeReference<List<RpaDetail>>() { });
		}
		fpFpxx.setFplx(fplx);
		fpFpxx.setFpdm(ObjUtil.getS(fpxx.get("zpfpdm")));
		fpFpxx.setFphm(ObjUtil.getS(fpxx.get("zpfphm")));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fpFpxx.setKprq(sdf.parse(ObjUtil.getS(fpxx.get("zpkprq"))));
		} catch (Exception e) {
		}
		fpFpxx.setFpztms(ObjUtil.getS(fpxx.get("zpfpzt")));
		fpFpxx.setXfsh(ObjUtil.getS(fpxx.get("zpxfsh")));
		fpFpxx.setXfmc(ObjUtil.getS(fpxx.get("zpxfmc")));
		fpFpxx.setGfsh(ObjUtil.getS(fpxx.get("zpgfsh")));
		fpFpxx.setGfmc(ObjUtil.getS(fpxx.get("zpgfmc")));
		fpFpxx.setHjje(ObjUtil.getD(fpxx.get("zpje")));
		fpFpxx.setHjse(ObjUtil.getD(fpxx.get("zpse")));
		fpFpxx.setJshj(ObjUtil.getD(fpxx.get("zpjshj")));
		fpFpxx.setJym(ObjUtil.getS(fpxx.get("zpjym")));
		fpFpxx.setXfdzdh(ObjUtil.getS(fpxx.get("zpxfdzdh")));
		fpFpxx.setXfyhzh(ObjUtil.getS(fpxx.get("zpxfyhzh")));
		fpFpxx.setGfdzdh(ObjUtil.getS(fpxx.get("zpgfdzdh")));
		fpFpxx.setGfyhzh(ObjUtil.getS(fpxx.get("zpgfyhzh")));
		fpFpxx.setMmq(ObjUtil.getS(fpxx.get("mmq")));//无该信息
		fpFpxx.setBz(ObjUtil.getS(fpxx.get("zpbz")));
//		fpFpxx.setJqbh(String.valueOf(fpxx.get("fhr")));
		fpFpxx.setKpr(ObjUtil.getS(fpxx.get("zpkpr")));
		fpFpxx.setSkr(ObjUtil.getS(fpxx.get("zpskr")));
		fpFpxx.setFhr(ObjUtil.getS(fpxx.get("zpfhr")));
		List<FpFpmx> fpmxList = new ArrayList<FpFpmx>();
		for (RpaDetail detail : fpmx) {
			FpFpmx fpfpmx = new FpFpmx();
			fpfpmx.setDj(ObjUtil.getD(detail.getDj()));
			fpfpmx.setDw(ObjUtil.getS(detail.getDw()));
			fpfpmx.setGgxh(ObjUtil.getS(detail.getGgxh()));
			fpfpmx.setXmmc(ObjUtil.getS(detail.getHwhyslwmc()));
			fpfpmx.setJe(ObjUtil.getD(detail.getJe()));
			fpfpmx.setSe(ObjUtil.getD(detail.getSe()));
			fpfpmx.setSpsl(ObjUtil.getD(detail.getSl()));
			fpfpmx.setSl(ObjUtil.getD(detail.getSlv()));
			fpfpmx.setSpbm(ObjUtil.getS(detail.getSsflbm()));
			fpfpmx.setXh(ObjUtil.getI(detail.getXh()));
			fpfpmx.setFpdm(ObjUtil.getS(fpFpxx.getFpdm()));
			fpfpmx.setFphm(ObjUtil.getS(fpFpxx.getFphm()));
			fpmxList.add(fpfpmx);
		}
		fpFpxx.setFpmxList(fpmxList);
		return fpFpxx;
		
	}
	

	
	

}
