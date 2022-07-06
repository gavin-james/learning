package jxfp;

import static com.bw.jxjc.util.FwptUtil.FPLX_ALL;
import static com.bw.jxjc.util.FwptUtil.FPZT_ALL;
import static com.bw.jxjc.util.FwptUtil.GLZT_ALL;
import static com.bw.jxjc.util.FwptUtil.GXZT_ALL;
import static com.bw.jxjc.util.FwptUtil.RZFS_ALL;
import static com.bw.jxjc.util.FwptUtil.YQZT_ALL;
import static com.bw.jxjc.util.FwptUtil._funType;
import static com.bw.jxjc.util.FwptUtil.bcdkgxqrqm;
import static com.bw.jxjc.util.FwptUtil.bdkgx;
import static com.bw.jxjc.util.FwptUtil.cxmxxz;
import static com.bw.jxjc.util.FwptUtil.dbsx;
import static com.bw.jxjc.util.FwptUtil.hqkg;
import static com.bw.jxjc.util.FwptUtil.dkgxqrqm;
import static com.bw.jxjc.util.FwptUtil.dkgxsqtj;
import static com.bw.jxjc.util.FwptUtil.dkgxtjcx;
import static com.bw.jxjc.util.FwptUtil.dpcx;
import static com.bw.jxjc.util.FwptUtil.fpxxww;
import static com.bw.jxjc.util.FwptUtil.fpxz;
import static com.bw.jxjc.util.FwptUtil.gxcx;
import static com.bw.jxjc.util.FwptUtil.gxtj;
import static com.bw.jxjc.util.FwptUtil.hqssq;
import static com.bw.jxjc.util.FwptUtil.login;
import static com.bw.jxjc.util.FwptUtil.slogin;
import static com.bw.jxjc.util.FwptUtil.query;
import static com.bw.jxjc.util.FwptUtil.rzfsA;
import static com.bw.jxjc.util.FwptUtil.wdqcx;
import static com.bw.jxjc.util.FwptUtil.xfxxQuery;
import static com.bw.jxjc.util.FwptUtil.zycx;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bw.jxjc.entry.FpFpxx;
import com.bw.jxjc.entry.FpcxEntry;
import com.bw.jxjc.entry.MsgEntry;
import com.bw.jxjc.entry.RpaFs;
import com.bw.jxjc.entry.RpaJs;
import com.bw.jxjc.entry.TBEntry;
import com.bw.jxjc.entry.WdqcxEntry;
import com.bw.jxjc.entry.Ymm;
import com.bw.jxjc.entry.ZycxEntry;
import com.bw.jxjc.exception.JxjcException;
import com.bw.jxjc.util.AoDataUtil;
import com.bw.jxjc.util.Digests;
import com.bw.jxjc.util.Encodes;
import com.bw.jxjc.util.EscapeUnescape;
import com.bw.jxjc.util.FormBuilder;
import com.bw.jxjc.util.HttpClientUtil;
import com.bw.jxjc.util.JackjsonUtil;
import com.bw.jxjc.util.JmcsUtil;
import com.bw.jxjc.util.OptionUtil;
import com.bw.jxjc.util.SecUtil;
import com.bw.jxjc.util.SjZhUtil;
import com.bw.jxjc.util.StatusHandle;
import com.bw.jxjc.util.YmbbUtil;
import com.bw.pt.platform.util.HttpUtil;
import com.bw.sk.isc.SkfwISC;
import com.bw.sk.isc.exception.AuthException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 发票选择确认平台 内部接口
 * 
 * @author administrator
 *
 */
public class ZqBean {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final Logger httplog = LoggerFactory.getLogger("com.bw.jxfp.http");

//	private int  = 0;
	
	/**
	 * 默认同步数据每页大小
	 */
	private int defaultPageSize = 15000;
	
//	private static String Rpafw = "http://192.168.154.213:8001/fpgx";
	private static String Rpafw = "http://127.0.0.1:8001/fpgx";


	/**
	 * 获取发票数据签名
	 * 
	 * @param fpdm
	 * @param fphm
	 * @param kprq
	 * @param zt
	 * @param yxse
	 * @return
	 */
	public static String getSign(String fpdms, String fphms, String kprqs, String zts, String yxse) {
		String _tmp = fpdms + fphms + kprqs + zts + yxse;
		return getSign(_tmp);
	}

	/**
	 * 获取当前所属期签名
	 * 
	 * @param dqssq
	 * @return
	 */
	public static String getSign(String dqssq) {
		String _tmp = dqssq;
		try {
			return Encodes.encodeHex(Digests.md5(URLEncoder.encode(_tmp, "utf-8").getBytes("utf-8")));
		} catch (UnsupportedEncodingException e) {
			throw new JxjcException("处理发票数据签名编码失败");
		}
	}

	/*
	 * public static void setPublicKeyUrl(String publicKeyUrl) { ZqBean.publicKeyUrl
	 * = publicKeyUrl; }
	 */

	/**
	 * 不同税号对应的请求实例存储Map
	 */
	private static Map<String, ZqBean> zqBeanMap = new HashMap<String, ZqBean>();
//	private static Map<String, String> ymbbMap = new HashMap<String, String>();//纳税人识别号和综合服务平台版本号

	/**
	 * 项目启动时初始化方法
	 * 
	 * @param baseUrl      纳税人识别号（key）和访问地址（value）
	 * @param ymbbMap      纳税人识别号（key）和版本号（value）
	 * @param publicKeyUrl 证书服务器地址
	 * @param skfwqlist    税控服务器地址密码list map:key=url(税控服务器地址);key=pass(证书密码)
	 * @param skpzlist     盘组服务器地址密码list map:key=url(税控服务器地址);key=pass(证书密码)
	 */
	public static void setBaseInfo(Map<String, String> baseUrl, Map<String, String> ymbbMap, String basePtUrl) {
//		ZqBean.ymbbMap = ymbbMap;
	}

	private SkfwISC instance;
	private CookieStore cookieStore = new BasicCookieStore();
	ObjectMapper objMapper;

	private ZqBean(String nsrsbh) {
		instance = SkfwISC.getInstance();
		String url = instance.getUrl(nsrsbh);
		if (StringUtils.isNotBlank(url)) {
			this.basePtUrl = url;
			try {
				this.host = new URL(url).getHost();
			} catch (MalformedURLException e) {
				log.warn("局端地址初始化解析失败：{}", url);
			}
		}
		this.NSRSBH = nsrsbh;
		httpClient = HttpClientUtil.createSSLClientDefault(cookieStore);

		//
		objMapper = JackjsonUtil.createMapper();

		loadProperties();
	}

	private String loadClientCookie = "false"; // 是否从客户端加载cookie，默认不加载

	private void loadProperties() {
		Properties pps = new Properties();
		try {
			pps.load(this.getClass().getClassLoader().getResourceAsStream("system.properties"));
			_ymbb = YmbbUtil.getVersionCache().get(basePtUrl); // 优先从缓存加载ymbb zby 2020-09-11
			if (StringUtils.isBlank(_ymbb)) { // 若缓存中没有则从配置文件加载
				log.debug("版本号在缓存中没有则从配置文件加载");
				_ymbb = pps.getProperty("zzs.ymbb", _ymbb);
				new YmbbUtil(null, basePtUrl); // 异步更新版本号
			}
			loadClientCookie = pps.getProperty("zzs.http.cookie.loadclient", "false");
			SecUtil.setPublicKeyUrl(pps.getProperty("zzs.pkserver.url", "http://127.0.0.1:9999"));
			SecUtil.setRtmUrl(pps.getProperty("zzs.rtmUrl", "http://127.0.0.1:8080/getrtm"));
			SecUtil.setDecodeUrl(pps.getProperty("zzs.decodeUrl", "http://127.0.0.1:8080/getdata"));
			log.debug("load _ymbb {}", _ymbb);
		} catch (Exception e) {
			log.warn("load system.properties error:{}", e.getMessage());
		}
	}

	private void reloadYmbb() {
		String ymbb = YmbbUtil.getVersionCache().get(basePtUrl);
		if (StringUtils.isNotBlank(ymbb) && ymbb.compareTo(_ymbb) > 0) { // 若缓存中ymbb发生改变则将ZqBean中的_ymbb更新
			_ymbb = ymbb;
			log.debug("更新ZqBean的版本号，原版本号{}，现版本号{}", _ymbb, ymbb);
		}
	}

	public static ZqBean getInstance(String nsrsbh) {
		ZqBean zqBean = zqBeanMap.get(nsrsbh);
		if (zqBean == null) {
			zqBean = new ZqBean(nsrsbh);
			zqBeanMap.put(nsrsbh, zqBean);
		} else {
			zqBean.reloadYmbb();
		}
		return zqBean;
	}

	private CloseableHttpClient httpClient;

	/**
	 * 企业税号（购方）
	 */
	private final String NSRSBH;

	/**
	 * 企业名称
	 */
	private String _NSRMC;

	public String getNsrmc() {
		return _NSRMC;
	}

	/**
	 * 当前日期
	 */
	private String _DQRQ;

	private String _ymbb = "4.0.07";

	private final Charset charset = Charset.forName("UTF-8");

	final ContentType contentType = ContentType.create(URLEncodedUtils.CONTENT_TYPE, charset);

	private static final String ACCEPT = "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9";
	private static final String ACCEPT_LANGUAGE = "zh,en;q=0.9";
	private static final String ACCEPT_ENCODING = "gzip, deflate, br";

	/**
	 * 选择确平台基础url 上海：https://fpdk.tax.sh.gov.cn/
	 */
//	private String basePtUrl = "https://fpdk.beijing.chinatax.gov.cn";
	private String basePtUrl = "https://fpdk.shanghai.chinatax.gov.cn";
//	private String basePtUrl = "https://fpdk.shaanxi.chinatax.gov.cn";
//	private String basePtUrl = "https://fpdk.henan.chinatax.gov.cn/";
	private String host = "fpdk.shanghai.chinatax.gov.cn";

	/**
	 * 登录超时时间设置
	 */
//	private String ot;

	public void setPtUrl(String ptUrl) {
		basePtUrl = ptUrl;
	}

	/**
	 * 最后操作日期
	 */
	private Date lastModify;

	private StatusHandle sh = new StatusHandle() {
		@Override
		public boolean not200status(CloseableHttpClient httpClient, CloseableHttpResponse httpResponse, String url) {
			if (!"true".equals(loadClientCookie)) {
				return false;
			}
			String cookieStr = SecUtil.getCookie(url);
			String[] cka = cookieStr.split(";");
			for (String kv : cka) {
				String[] kva = kv.split("=");
				addCookie(kva[0], kva.length == 2 ? kva[1] : null);
			}
			return true;
		}
	};

	public String test(String url, String string, String charset) {
		List<Header> headerList = new ArrayList<Header>();
		string = string.replace("=", ":");
		String s =HttpClientUtil.sendPostUrl(httpClient,url, string, charset,headerList, contentType, sh);

		return s;
	}

	
	/**
	 * https请求
	 */
	private String sendPostUrl(String url, FormBuilder paramsBuilder, String charset) {
		return sendPostUrl(url, paramsBuilder, charset, true);
	}

	/**
	 * https请求
	 */
	private String sendPostUrl(String url, FormBuilder paramsBuilder, String charset, boolean relogin) {
		String params = paramsBuilder.toString();
		long start = System.nanoTime();
		String realUrl = basePtUrl + url;
		String secparm = "";
		
		
		if (basePtUrl.indexOf("shaanxi") > -1) {
			secparm = "?" + JmcsUtil.jmcs1(url);
			if(realUrl.indexOf("?")>-1) {
				realUrl = realUrl.split("\\?")[0];
			}
			realUrl = realUrl+secparm;
		}

		long time = (System.nanoTime() - start);
		log.info("加密参数生成总用时 {} ms", time / 1000000);
	
		log.info("添加处理后的路径：{}", realUrl);

		List<Header> headerList = new ArrayList<Header>();
		headerList.add(new BasicHeader("Referer", basePtUrl + "/main.b2cfbe65.html?_=" + _ymbb));
		headerList.add(new BasicHeader("985689fk3Ku", SecUtil.getPublicKey(realUrl, params)));

		headerList.add(new BasicHeader("Origin", basePtUrl));
		if (realUrl.indexOf("yunnan") > -1) {
			String cookie = "g0DMc7f8wv2yO=5CJu65FDbNhr6umUKGPY_RTk5XIQeytlxNjdVvE2FGwNz2U8XKqwR3Lcv.OQkbs6d4tQ8sUfAU3JfFIL74vA1qq; SF_cookie_3=94712281; enable_g0DMc7f8wv2y=true;"
					+ ((url.indexOf("login")!=-1)?"":("token="+_token+";"))
					+ "g0DMc7f8wv2yP=53PMm9KEbSPqqqqmdR6Hryqiy9d9RFFdDR2vdKAy2dqtQUMYnXpTS5mC.edjiqF9Tj1c8HOdEAs6iIAP95tlXwdYiUe4ovbvlBm4LGluusz9pbwyXx1LifkAhvqLNJtPhdb41EpBfw6TTsw.ANN_DfGBWj8egklnzo_6yPBBJSiKLXyzkXV0v37JjKXrfPJYmITDFLeAi6oHGWQfXpgKPcuffmEGULEOjzDP8D72XEe.w8Athx15bmA_Ht6HyEDwq8QjZ1wHS1x8jYWxNmC38gK;";
			headerList.add(new BasicHeader("Cookie", cookie));
			log.info("加密参数添加固定cookie值：{}", cookie);
		}
		
		if (realUrl.indexOf("shaanxi") > -1) {
			String cookie = "aWmLEArSjH0jS=5z4Qv_FmFSPwmQIj4MwXpBXWt9EnCI5IZsXgIKGGNxx_hmoKixVDK2ZoWhdd2urB8mlQHlgWosOVQvBFjVtYZBA; token="
					+ _token
					+ "; aWmLEArSjH0jT=53RNoiCDFp6VqqqmeAj0bAa_xgT_xqQkqtBxx5XQNDtbP7fl7s7n0Z6duKLN.vFzHwAjG.anVtPVCm7qDbV2I7tZ5EQ4g8AKde0aG7j03b0NoJs5bh8c_aFjgPbOhr1QtJcIz7Plvmw5jju34_Tag3Pl7Mao1TMjYJ_.AG33.HgSFHsIP5zCB5doNdAoDZ6d0_VpYWDmabRcwZS48rh0zVnwN8AxHij.sjyLDIbFRHlsdotGaBwW.S8YVh5IJWk5D53pCFaKNDpCM3Dvx3UECRWFZ9YaRNpQoq3TNuqUwLla6SzEdLOVPVGOjSkEfWyicqQ_Kc8gP_T8_ZXh2uMIvsX";
			headerList.add(new BasicHeader("Cookie", cookie));
			log.info("加密参数添加固定cookie值：{}", cookie);
		}

		headerList.add(new BasicHeader("Host", basePtUrl.replace("https://", "")));
//		headerList.add(new BasicHeader("Sec-Fetch-Mode", "cors"));
//		headerList.add(new BasicHeader("Sec-Fetch-Site", "same-origin"));
//		headerList.add(new BasicHeader("X-Requested-With", "XMLHttpRequest"));
//		headerList.add(new BasicHeader("Accept", ACCEPT));
//		headerList.add(new BasicHeader("Accept-Encoding", ACCEPT_ENCODING));
//		headerList.add(new BasicHeader("Accept-Language", ACCEPT_LANGUAGE));
		String result = null;
		long start2 = System.nanoTime();
		result = HttpClientUtil.sendPostUrl(httpClient,realUrl, params, charset, headerList, contentType, sh);
//"http://127.0.0.1:8888/"
		long time2 = (System.nanoTime() - start2);
		log.info("信息交互用时 {} ms", time2 / 1000000);

		if (checkLogin(result)||StringUtils.isBlank(result)) {// 检查到登录失败或返回值为空
			if(checkLogin(result)) {
				log.info("检查到登录失败: {}", result);
				isLogin = false;
				if (!relogin) {
					log.warn("登录失败: {}", result);
					throw new JxjcException("登录失败");
				}
			}
			login();
			if (basePtUrl.indexOf("shaanxi") > -1||basePtUrl.indexOf("yunnan") > -1) {
				secparm = "?" + JmcsUtil.jmcs1(url);
				if(realUrl.indexOf("?")>-1) {
					realUrl = realUrl.split("\\?")[0];
				}
				realUrl = realUrl+secparm;
			}
			paramsBuilder.set("token", _token);
			params = paramsBuilder.toString();
			headerList.add(new BasicHeader("985689fk3Ku", SecUtil.getPublicKey(realUrl, params)));
			if (realUrl.indexOf("yunnan") > -1) {
				String cookie = "g0DMc7f8wv2yO=5CJu65FDbNhr6umUKGPY_RTk5XIQeytlxNjdVvE2FGwNz2U8XKqwR3Lcv.OQkbs6d4tQ8sUfAU3JfFIL74vA1qq; SF_cookie_3=94712281; enable_g0DMc7f8wv2y=true;"
						+ ((url.indexOf("login")!=-1)?"":("token="+_token+";"))
						+ "g0DMc7f8wv2yP=53PMm9KEbSPqqqqmdR6Hryqiy9d9RFFdDR2vdKAy2dqtQUMYnXpTS5mC.edjiqF9Tj1c8HOdEAs6iIAP95tlXwdYiUe4ovbvlBm4LGluusz9pbwyXx1LifkAhvqLNJtPhdb41EpBfw6TTsw.ANN_DfGBWj8egklnzo_6yPBBJSiKLXyzkXV0v37JjKXrfPJYmITDFLeAi6oHGWQfXpgKPcuffmEGULEOjzDP8D72XEe.w8Athx15bmA_Ht6HyEDwq8QjZ1wHS1x8jYWxNmC38gK;";
				headerList.add(new BasicHeader("Cookie", cookie));
				log.info("加密参数添加固定cookie值：{}", cookie);
			}
			
			if (realUrl.indexOf("shaanxi") > -1) {
				String cookie = "aWmLEArSjH0jS=5z4Qv_FmFSPwmQIj4MwXpBXWt9EnCI5IZsXgIKGGNxx_hmoKixVDK2ZoWhdd2urB8mlQHlgWosOVQvBFjVtYZBA; token="
						+ _token
						+ "; aWmLEArSjH0jT=53RNoiCDFp6VqqqmeAj0bAa_xgT_xqQkqtBxx5XQNDtbP7fl7s7n0Z6duKLN.vFzHwAjG.anVtPVCm7qDbV2I7tZ5EQ4g8AKde0aG7j03b0NoJs5bh8c_aFjgPbOhr1QtJcIz7Plvmw5jju34_Tag3Pl7Mao1TMjYJ_.AG33.HgSFHsIP5zCB5doNdAoDZ6d0_VpYWDmabRcwZS48rh0zVnwN8AxHij.sjyLDIbFRHlsdotGaBwW.S8YVh5IJWk5D53pCFaKNDpCM3Dvx3UECRWFZ9YaRNpQoq3TNuqUwLla6SzEdLOVPVGOjSkEfWyicqQ_Kc8gP_T8_ZXh2uMIvsX";
				headerList.add(new BasicHeader("Cookie", cookie));
				log.info("加密参数添加固定cookie值：{}", cookie);
			}
			int i = 3;
			do {
				if (StringUtils.isBlank(result)) {
					log.info("第{}次重新发送",4-i);
					try {
						result = HttpClientUtil.sendPostUrl(httpClient, realUrl, params, charset, headerList, contentType, sh);
					} catch (Exception e1) {
						
					}
					i--;
				} else {
					i = 0;
				}
			} while (i > 0);
		}

		lastModify = new Date();
		return result;
	}

	private boolean checkLogin(String result) {
		return result.contains("登录超时!") || result.contains("\"key1\":\"09\"") || result.contains("\"key1\":\"w400001\"")
				|| result.equals("window.location.href = './clearCache.html';");
	}

	/**
	 * 获取系统ts
	 * 
	 * @return
	 * @throws Exception
	 */
	private Ymm getYmm() {
		String param = "funType=" + _funType + "&cert=" + NSRSBH;
		String loginC = HttpClientUtil.sendPostUrl(httpClient, basePtUrl + query, param, "gbk", null, contentType, sh);
		log.info("ymm结果：{}", loginC);
		return praseJson(loginC, Ymm.class);
	}

	private String _token;

	public void setToken(String token) {
		_token = token;
	}

	private void addCookie(final String name, final String value) {
		addCookie(name, value, true);
	}

	private void addCookie(final String name, final String value, boolean endoce) {
		try {
			BasicClientCookie cookie = new BasicClientCookie(name, endoce ? EscapeUnescape.escape(value) : value);
//			BasicClientCookie cookie = new BasicClientCookie(name, endoce?URLEncoder.encode(value, "utf-8"):value);
			cookie.setDomain(host);
			cookieStore.addCookie(cookie);
		} catch (Exception e) {
		}
	}

	/**
	 * 判断是否登录或超时
	 * 
	 * @throws Exception
	 */
	private void checkLogin() throws Exception {
		if (StringUtils.isBlank(_token)) {
			login();
		}
		log.trace("上次访问时间：{}", lastModify != null ? new SimpleDateFormat("yyyyMMdd HHmmss").format(lastModify) : "");
	}

	private boolean isLogin = false;

	
	
	
	/**
	 * 登录系统获取token
	 * 
	 * @param gfsbh
	 * @return
	 * @throws Exception
	 */
	private synchronized void login() {
		if (isLogin)
			return;
		cookieStore.clear();
		String clientHello = instance.clientHello(NSRSBH);
		if (StringUtils.isBlank(clientHello)) {
			throw new JxjcException(NSRSBH + "的clientHello获取失败");
		}
		String param1 = "type=CLIENT-HELLO&clientHello=" + clientHello + "&alg=0&ymbb=" + _ymbb;
		String loginResult = HttpClientUtil.sendPostUrl(httpClient, basePtUrl + login, param1, "gbk", null, contentType,
				sh);

		
//		FormBuilder param1 = new FormBuilder("type","CLIENT-HELLO").add("clientHello", clientHello).add("alg","0")
//				.add("ymbb",_ymbb);
//		String loginResult =sendPostUrl(login, param1, "gbk", true);

		if (StringUtils.isBlank(loginResult)) {
			throw new JxjcException("登录异常,01结果为空");
		}
		log.info("第1次登陆结果：{}", loginResult);
		MsgEntry loginMsg = praseJson(loginResult, MsgEntry.class);// 登录01
		if (!"01".equals(loginMsg.getKey1())) {
			throw new JxjcException("登录异常");
		}
		String serverRandom = loginMsg.getKey2();
		Ymm ymm = getYmm();
		String clientAuthCode = instance.clientAuth(NSRSBH, serverRandom);
		FormBuilder formBuilder = new FormBuilder("type", "CLIENT-AUTH").add("clientAuthCode", clientAuthCode)
				.add("serverRandom", loginMsg.getKey3()).add("alg", "0").add("password").add("ts", ymm.getTs())
				.add("cert", NSRSBH).add("ymbb", getYmbb(login))
				.add("currdate", String.valueOf(System.currentTimeMillis()));

		// String result = sendPostUrl(login, formBuilder, "gbk", false);
		String result = HttpClientUtil.sendPostUrl(httpClient, basePtUrl + login, formBuilder.toString(), "gbk", null,
				contentType, sh);
		log.info("第2次登陆结果：{}", result);
		if (StringUtils.isBlank(result)) {
			throw new JxjcException("登录异常,02结果为空");
		}
		loginMsg = praseJson(result, MsgEntry.class);// 登录02
//		{"key1":"03","key2":"2~0~0~~1~0~0~0~0~0~0b0e5b71-3c0b-4561-a9ba-cafd9ae8d9c0","key3":"%E4%B8%8A%E6%B5%B7%E7%99%BE%E6%97%BA%E9%87%91%E8%B5%8B%E7%A7%91%E6%8A%80%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8","key4":"2019-02-21"}
//		{"key1":"00","key2":"[身份认证失败，身份解析不一致]"}
		if (!"03".equals(loginMsg.getKey1())) {
//			result = sendPostUrl(login, formBuilder, "gbk", false);//重试登录
			result = HttpClientUtil.sendPostUrl(httpClient, basePtUrl + login, formBuilder.toString(), "gbk", null,
					contentType, sh); // 重试登录
			log.info("第2次登陆结果2：{}", result);
			if (StringUtils.isBlank(result)) {
				throw new JxjcException("登录异常2,02结果为空");
			}
			loginMsg = praseJson(result, MsgEntry.class);// 登录02
			if (!"03".equals(loginMsg.getKey1())) {
				if (result.indexOf("证书") > -1) {
					throw new AuthException(
							"登录失败" + NSRSBH + ", code:" + loginMsg.getKey1() + "#" + loginMsg.getKey2());
				}
				throw new JxjcException("登录异常：" + NSRSBH + ", code:" + loginMsg.getKey1() + "#" + loginMsg.getKey2());
			}
		}
		_token = loginMsg.getKey2();
		try {
			_NSRMC = URLDecoder.decode(loginMsg.getKey3(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			log.warn("登录解析纳税人名称失败：{}", loginMsg.getKey3());
		}
		_DQRQ = loginMsg.getKey4();
		log.info("本次登录：{} :{}:{}", _token, _NSRMC, _DQRQ);
		setToken(_token);
		addCookie("token", EscapeUnescape.escape(_token), false);
		addCookie("alg", "0");
		addCookie("dqrq", _DQRQ, false);
		addCookie("nsrmc", EscapeUnescape.escape(_NSRMC), false);
		addCookie("wdqbz", loginMsg.getKey5());
		addCookie("skssq", "202103;20210420;202103");
		addCookie("gxrqfw", "20170101-20210331", false);
		isLogin = true;
	}

	/**
	 * 主页查询，获取主页数据
	 * 
	 * @param rznf 认证年份
	 * @return
	 * @throws Exception
	 */
	public ZycxEntry zycx(String rznf) throws Exception {
		checkLogin();
		FormBuilder formBuilder = new FormBuilder("cert", NSRSBH).add("token", _token).add("ymbb", getYmbb(zycx))
				.add("rznf", rznf).add("id", "qrgycx");
		String result = sendPostUrl(zycx, formBuilder, "gbk");
		log.info("主页查询结果：{}", result);
//		{"key1":"01","key2":"0","key3":"201901=79=359967.14=1;201902===0=0","key4":"2~0~0~~1~0~0~0~0~0~7247bddd-0bb6-4e1e-8816-0136ede40fc1","key5":"201902;20190315;201902","key6":"20180206-20190228"}
		ZycxEntry fpcx = praseJson(result, ZycxEntry.class);
		log.debug("主页查询结果:{}", fpcx);
		return fpcx;
	}

	/**
	 * 按日期和认证状态查询，其他条件默认为全部 分页查询
	 * 
	 * @param rq_q 开票日期起 格式：2018-12-31
	 * @param rq_z 开票日期止
	 * @param rzzt 认证状态（0：未认证；1：已认证）默认：0
	 * @return
	 * 
	 *         fpdm=&fphm=&rq_q=2019-01-01&rq_z=2019-01-31&xfsbh=&rzfs=&rzzt=0&gxzt=0&fpzt=0&fplx=-1&cert=91310104057643445Y&token=2~0~0~~1~0~0~0~0~0~173284fb-4607-474f-8414-9601fa7fce79&aoData=%5B%7B%22name%22%3A%22sEcho%22%2C%22value%22%3A1%7D%2C%7B%22name%22%3A%22iColumns%22%2C%22value%22%3A14%7D%2C%7B%22name%22%3A%22sColumns%22%2C%22value%22%3A%22%2C%2C%2C%2C%2C%2C%2C%2C%2C%2C%2C%2C%2C%22%7D%2C%7B%22name%22%3A%22iDisplayStart%22%2C%22value%22%3A0%7D%2C%7B%22name%22%3A%22iDisplayLength%22%2C%22value%22%3A50%7D%2C%7B%22name%22%3A%22mDataProp_0%22%2C%22value%22%3A0%7D%2C%7B%22name%22%3A%22mDataProp_1%22%2C%22value%22%3A1%7D%2C%7B%22name%22%3A%22mDataProp_2%22%2C%22value%22%3A2%7D%2C%7B%22name%22%3A%22mDataProp_3%22%2C%22value%22%3A3%7D%2C%7B%22name%22%3A%22mDataProp_4%22%2C%22value%22%3A4%7D%2C%7B%22name%22%3A%22mDataProp_5%22%2C%22value%22%3A5%7D%2C%7B%22name%22%3A%22mDataProp_6%22%2C%22value%22%3A6%7D%2C%7B%22name%22%3A%22mDataProp_7%22%2C%22value%22%3A7%7D%2C%7B%22name%22%3A%22mDataProp_8%22%2C%22value%22%3A8%7D%2C%7B%22name%22%3A%22mDataProp_9%22%2C%22value%22%3A9%7D%2C%7B%22name%22%3A%22mDataProp_10%22%2C%22value%22%3A10%7D%2C%7B%22name%22%3A%22mDataProp_11%22%2C%22value%22%3A11%7D%2C%7B%22name%22%3A%22mDataProp_12%22%2C%22value%22%3A12%7D%2C%7B%22name%22%3A%22mDataProp_13%22%2C%22value%22%3A13%7D%5D&ymbb=3.1.01
	 * @throws Exception
	 */
	public TBEntry gxcx(Date rq_q, Date rq_z, String rzzt, int sEcho, int start, int pageSize) throws Exception {
		return gxcx("", "", rq_q, rq_z, ""/* 税号 */, rzzt, GXZT_ALL, RZFS_ALL, FPZT_ALL, FPLX_ALL, GLZT_ALL, sEcho,
				start, pageSize, YQZT_ALL);
	}

	/**
	 * 按日期和勾选状态查询，其他条件默认为全部
	 * 
	 * @param rq_q
	 * @param rq_z
	 * @param rzzt 0：未勾选；1：已勾选
	 * @return
	 * @throws Exception
	 */
	public TBEntry gxcx(Date rq_q, Date rq_z, String rzzt) throws Exception {
		return gxcx(rq_q, rq_z, rzzt, FPLX_ALL);
	}

	/**
	 * 按日期、勾选状态、发票类型查询，其他条件默认为全部
	 * 
	 * @param rq_q
	 * @param rq_z
	 * @param rzzt
	 * @param fplx
	 * @return
	 * @throws Exception
	 */
	public TBEntry gxcx(Date rq_q, Date rq_z, String rzzt, String fplx) throws Exception {
		return gxcx("", "", rq_q, rq_z, ""/* 税号 */, rzzt, GXZT_ALL, RZFS_ALL, FPZT_ALL, fplx, GLZT_ALL, 1, 0,
				defaultPageSize, YQZT_ALL);
	}

	/**
	 * 勾选查询(专票同步) 基础方法
	 * 
	 * @param fpdm  发票代码
	 * @param fphm  发票号码
	 * @param rq_q  开票日期起 格式：2018-12-31
	 * @param rq_z  开票日期止
	 * @param xfsbh 销方税号
	 * @param rzzt  勾选状态（-1：全部(已取消该状态)；0：未勾选；1：已勾选）默认：0
	 *              (在勾选平台2.0的时候，rzzt:勾选状态，不存在gxzt这个字段)
	 * @param gxzt  已弃用
	 * @param rzfs  认证方式 （-1全部，0：勾选认证，1扫描认证）默认：0
	 * @param fpzt  发票状态（-1：全部；0：正常；1：失控；2：作废；3：红冲；4：异常；） 默认：0
	 * @param fplx  发票类型（-1：全部；01：专票；02：货运专用发票；03：机动车发票；14：通行费发票）默认：-1
	 * @param glzt  管理状态 （-1 :全部, 0：正常, 1：非正常）默认-1
	 * @return
	 * 
	 *         fpdm=&fphm=&rq_q=2019-01-01&rq_z=2019-01-31&xfsbh=&rzfs=&rzzt=0&gxzt=0&fpzt=0&fplx=-1&cert=91310104057643445Y&token=2~0~0~~1~0~0~0~0~0~173284fb-4607-474f-8414-9601fa7fce79&aoData=%5B%7B%22name%22%3A%22sEcho%22%2C%22value%22%3A1%7D%2C%7B%22name%22%3A%22iColumns%22%2C%22value%22%3A14%7D%2C%7B%22name%22%3A%22sColumns%22%2C%22value%22%3A%22%2C%2C%2C%2C%2C%2C%2C%2C%2C%2C%2C%2C%2C%22%7D%2C%7B%22name%22%3A%22iDisplayStart%22%2C%22value%22%3A0%7D%2C%7B%22name%22%3A%22iDisplayLength%22%2C%22value%22%3A50%7D%2C%7B%22name%22%3A%22mDataProp_0%22%2C%22value%22%3A0%7D%2C%7B%22name%22%3A%22mDataProp_1%22%2C%22value%22%3A1%7D%2C%7B%22name%22%3A%22mDataProp_2%22%2C%22value%22%3A2%7D%2C%7B%22name%22%3A%22mDataProp_3%22%2C%22value%22%3A3%7D%2C%7B%22name%22%3A%22mDataProp_4%22%2C%22value%22%3A4%7D%2C%7B%22name%22%3A%22mDataProp_5%22%2C%22value%22%3A5%7D%2C%7B%22name%22%3A%22mDataProp_6%22%2C%22value%22%3A6%7D%2C%7B%22name%22%3A%22mDataProp_7%22%2C%22value%22%3A7%7D%2C%7B%22name%22%3A%22mDataProp_8%22%2C%22value%22%3A8%7D%2C%7B%22name%22%3A%22mDataProp_9%22%2C%22value%22%3A9%7D%2C%7B%22name%22%3A%22mDataProp_10%22%2C%22value%22%3A10%7D%2C%7B%22name%22%3A%22mDataProp_11%22%2C%22value%22%3A11%7D%2C%7B%22name%22%3A%22mDataProp_12%22%2C%22value%22%3A12%7D%2C%7B%22name%22%3A%22mDataProp_13%22%2C%22value%22%3A13%7D%5D&ymbb=3.1.01
	 * @throws Exception
	 */
	public TBEntry gxcx(String fpdm, String fphm, Date rq_q, Date rq_z, String xfsbh, String rzzt, String gxzt,
			String rzfs, String fpzt, String fplx, String glzt, int sEcho, int start, int pageSize, String yqzt)
			throws Exception {
		checkLogin();
		if ("1".equals(rzzt)) {// 已勾选
//			gxzt = "";
			rzfs = OptionUtil.getOption(rzzt, rzfsA);//
		} else {// 未勾选
			rzzt = "0";
//			gxzt = OptionUtil.getOption(gxzt, gxztA);//
			rzfs = "";
		}
		// 获取rtm标签
		String rtm = SecUtil.getRtm();

		FormBuilder formBuilder = new FormBuilder("id", "dkgxquery").add("fpdm", fpdm).add("fphm", fphm)
				.add("rq_q", sd.format(rq_q)).add("rq_z", sd.format(rq_z)).add("xfsbh", xfsbh).add("rzzt", rzzt)
				.add("glzt", glzt = "-1").add("fpzt", fpzt = "0").add("fplx", fplx).add("cert", NSRSBH)
				.add("sjly", "-1").add("token", _token, true) // w400001
				.add("aoData", AoDataUtil.getAoDataGxcx(sEcho, start, pageSize), true).add("rtm", rtm)
				.add("ymbb", getYmbb(gxcx)).add("fply", "0");

		String data = sendPostUrl(gxcx, formBuilder, "utf-8");
		// 重试
		int i = 3;
		do {
			if (null == data || !data.startsWith("{\"data\":")) {
				data = sendPostUrl(gxcx, formBuilder, "utf-8");
				i--;
			} else {
				i = 0;
			}
		} while (i > 0);

		// 解密
		String result = SecUtil.deCodeData(data, rtm);

		log.debug("勾选同步参数：{}\n\t结果：{}", formBuilder, result);
		TBEntry rbj = praseJson(result, TBEntry.class);
		log.debug("勾选同步结果：{}", rbj.getKey1());
		return rbj;
	}

	/**
	 * 
	 * 2020-05-08 添加，勾选页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public MsgEntry getycfps() throws Exception {
		checkLogin();
		FormBuilder formBuilder = new FormBuilder("method", "getycfps").add("cert", NSRSBH).add("token", _token)// w400001
				.add("ymbb", getYmbb(dbsx));
		String result = sendPostUrl(dbsx, formBuilder, "gbk");
		log.info("勾选页面参数：{}\n\t结果：{}", formBuilder, result);
		MsgEntry rbj = praseJson(result, MsgEntry.class);
		log.debug("勾选页面结果：{}", rbj);
		return rbj;
	}

	/**
	 * 历史属期发票勾选查询
	 * 
	 * @param tjyf  统计月份
	 * @param fpdm  发票代码
	 * @param fphm  发票号码
	 * @param xfsbh 销方识别号
	 * @param gxrqq 勾选日期起
	 * @param gxrrz 勾选日期止
	 * @param fply  用途 0：全部 1：抵扣 2：不抵扣
	 * @return
	 * @throws Exception因之前有fply字段，故20211127税局更新添加的发票来源字段仅在当前功能下以fly表示 -1:全部 0：税控发票
	 *                                                                 1：全电发票
	 */
	public TBEntry lssqcx(String tjyf, String fpdm, String fphm, String xfsbh, String gxrqq, String gxrrz, String fply)
			throws Exception {
		checkLogin();
		FormBuilder formBuilder = new FormBuilder("id", "dkmx").add("cert", NSRSBH).add("token", _token)
				.add("tjyf", tjyf).add("fpdm", fpdm).add("fphm", fphm).add("xfsbh", xfsbh).add("qrrzrq_q", gxrqq)
				.add("qrrzrq_z", gxrrz).add("fply", fply).add("aoData", AoDataUtil.getAoDataLssqcx(1, 0, 15000), true)
				.add("ymbb", getYmbb(dkgxtjcx)).add("qt", "wq").add("fly", "0");
		String result = sendPostUrl(dkgxtjcx, formBuilder, "gbk");
		log.info("历史属期发票查询参数：{}\n结果：{}", formBuilder, result);
		TBEntry rbj = praseJson(result, TBEntry.class);
		log.info("历史属期发票查询：{}", rbj);
		return rbj;
	}

	/**
	 * 销方信息查询
	 * 
	 * @param xfsh 销方税号（加密）
	 * @return
	 * @throws Exception
	 */
	public FpcxEntry xfxxcx(String xfsh) throws Exception {
		checkLogin();
		FormBuilder formBuilder = new FormBuilder("id", "xfxxquery").add("cert", NSRSBH).add("token", _token)
				.add("xfsh", xfsh, true).add("ymbb", getYmbb(xfxxQuery));
		String result = sendPostUrl(xfxxQuery, formBuilder, "gbk");
		// 返回信息：{"key3":"正常=0=913205830880018839","key2":"1~0~0~~1~0~0~0~0~0~1~978c1b72-b91b-457e-834f-88966d1a0a46","key1":"200"}
		log.info("销方信息查询参数：{}\n结果：{}", formBuilder, result);
		FpcxEntry entry = praseJson(result, FpcxEntry.class);
		return entry;
	}

	/**
	 * 违法违章信息查询
	 * 
	 * @param xfsh 销方税号（加密）
	 * @return
	 * @throws Exception
	 */
	public WdqcxEntry wfwzxxcx(String xfsh) throws Exception {
		checkLogin();
		FormBuilder formBuilder = new FormBuilder("id", "wfwzquery").add("cert", NSRSBH).add("xfsh", xfsh, true)
				.add("token", _token).add("aoData", AoDataUtil.getAoDataWfwz(1, 0, 100), true)
				.add("ymbb", getYmbb(xfxxQuery));
		String result = sendPostUrl(xfxxQuery, formBuilder, "gbk");
		// 返回信息：{"key4":1,"key3":"1~0~0~~1~0~0~0~0~0~1~978c1b72-b91b-457e-834f-88966d1a0a46","key2":{"iTotalDisplayRecords":1,"iTotalRecords":1,"aaData":[["1","2019-10-17
		// 00:00:00","发票违法","丢失发票","2019-10-17 09:02:45"]],"sEcho":2},"key1":"200"}
		log.info("销方信息查询参数：{}\n结果：{}", formBuilder, result);
		WdqcxEntry entry = praseJson(result, WdqcxEntry.class);
		return entry;
	}

	/**
	 * 发票状态信息查询 （查询时间超长）
	 * 
	 * @param xfsh 销方税号（加密）
	 * @param fpdm 发票代码
	 * @param fphm 发票号码
	 * @param kprq 开票日期 yyyy-MM-dd
	 * @param fplx 发票类型
	 * @return
	 * @throws Exception
	 */
	public MsgEntry fpztxxcx(String xfsh, String fpdm, String fphm, String kprq, String fplx) throws Exception {
		checkLogin();
		FormBuilder formBuilder = new FormBuilder("id", "ztxxquery").add("cert", NSRSBH).add("token", _token)
				.add("fpdm", fpdm).add("fphm", fphm).add("kprq", kprq).add("fplx", fplx).add("type", "0")
				.add("xfsh", xfsh, true).add("ymbb", getYmbb(xfxxQuery)).add("fply", "0");
		String result = sendPostUrl(xfxxQuery, formBuilder, "gbk");
		// 返回信息：{"key3":"-=0=0=2019-11-26 09:23:55=0=2019-12-12
		// 09:54:08=0=-=-=-=-=-=-=-=-=-=-=-","key2":"1~0~0~~1~0~0~0~0~0~1~978c1b72-b91b-457e-834f-88966d1a0a46","key1":"200"}
		log.info("销方信息查询参数：{}\n结果：{}", formBuilder, result);
		MsgEntry entry = praseJson(result, MsgEntry.class);
		return entry;
	}

	/**
	 * 查询默认张数的发票
	 * 
	 * @param fpdm
	 * @param fphm
	 * @param rq_q
	 * @param rq_z
	 * @param xfsbh
	 * @param rzzt
	 * @param gxzt
	 * @param rzfs
	 * @param fpzt
	 * @param fplx
	 * @return
	 * @throws Exception
	 */
	public TBEntry gxcx(String fpdm, String fphm, Date rq_q, Date rq_z, String xfsbh, String rzzt, String gxzt,
			String rzfs, String fpzt, String fplx) throws Exception {
		return gxcx(fpdm, fphm, rq_q, rq_z, xfsbh, rzzt, gxzt, rzfs, fpzt, fplx, "-1", 1, 0, defaultPageSize, YQZT_ALL);
	}

	/**
	 * 勾选确认/勾选取消 单张发票操作
	 * 
	 * @param fpdm
	 * @param fphm
	 * @param kprq yyyy-MM-dd
	 * @param gxzt 1:勾选确认；0：取消勾选
	 * @param yxse 有效税额
	 * @return
	 * @throws Exception
	 */
	public MsgEntry gxtj1(String[] fpdms, String[] fphms, String[] kprqs, String[] gxzts, String[] yxses)
			throws Exception {
		int len = fpdms.length;
		if (len == 0 || len != fphms.length || len != kprqs.length || len != gxzts.length || len != yxses.length) {
			throw new JxjcException("2001", "发票认证参数长度不匹配：" + len);
		}
		String _fpdm = StringUtils.join(fpdms, "=");// 平台通过=分割发票信息内容
		String _fphm = StringUtils.join(fphms, "=");
		String _kprq = StringUtils.join(kprqs, "=");
		String _gxzt = StringUtils.join(gxzts, "=");
		String _yxse = StringUtils.join(yxses, "=");
		return gxtj1(_fpdm, _fphm, _kprq, _gxzt, _yxse);
	}

	/**
	 * 勾选确认/勾选取消 单/多张发票操作
	 * 
	 * @param fpdms 通过 = 分割多条数据
	 * @param fphms
	 * @param kprqs yyyy-MM-dd
	 * @param gxzts 1:勾选确认；0：取消勾选
	 * @param yxses 有效税额
	 * @return
	 * @beizhu fply:-1:全部 0：税控发票 1：全电发票
	 */
	public MsgEntry gxtj1(String fpdms, String fphms, String kprqs, String gxzts, String yxses) throws Exception {
		checkLogin();
		String sign = getSign(fpdms, fphms, kprqs, gxzts, yxses);
		Ymm ymm = getYmm();
		FormBuilder formBuilder = new FormBuilder("id", "dkgxcommit")// 勾选提交和撤销的id为同一个，只有zt不一样
				.add("fpdm", fpdms, true).add("fphm", fphms, true).add("kprq", kprqs, false).add("zt", gxzts, true)
				.add("yxse", yxses, true).add("cert", NSRSBH).add("token", _token).add("ymbb", getYmbb(gxtj))
				.add("ts", ymm.getTs()).add("publickey", "").add("sign", sign).add("fply", "0");
		String loginC = sendPostUrl(gxtj, formBuilder, "gbk");
		MsgEntry obj = praseJson(loginC, MsgEntry.class);
		return obj;
	}

	/**
	 * 不抵扣勾选确认/不抵扣勾选取消 多张发票操作
	 * 
	 * @param fpdmArr
	 * @param fphmArr
	 * @param kprqArr yyyy-MM-dd
	 * @param gxztArr 1:勾选确认；0：取消勾选
	 * @param yxseArr 有效税额
	 * @return
	 * @throws Exception
	 */
	public MsgEntry bdkgx(String[] fpdmArr, String[] fphmArr, String[] kprqArr, String[] gxztArr, String[] yxseArr)
			throws Exception {
		int len = fpdmArr.length;
		if (len == 0 || len != fphmArr.length || len != kprqArr.length || len != gxztArr.length
				|| len != yxseArr.length) {
			throw new JxjcException("2001", "发票认证参数长度不匹配：" + len);
		}
		String fpdms = StringUtils.join(fpdmArr, "=");// 平台通过=分割发票信息内容
		String fphms = StringUtils.join(fphmArr, "=");
		String kprqs = StringUtils.join(kprqArr, "=");
		String gxzts = StringUtils.join(gxztArr, "=");
		String yxses = StringUtils.join(yxseArr, "=");

		return bdkgx(fpdms, fphms, kprqs, gxzts, yxses);
	}

	/**
	 * 不抵扣勾选确认/不抵扣勾选取消 多张发票操作
	 * 
	 * @param fpdm
	 * @param fphm
	 * @param kprq  yyyy-MM-dd
	 * @param gxzt  1:勾选确认；0：取消勾选
	 * @param yxses 有效税额
	 * @return
	 * @throws Exception
	 */
	public MsgEntry bdkgx(String fpdms, String fphms, String kprqs, String gxzts, String yxses) throws Exception {
		checkLogin();

		String sign = getSign(fpdms + fphms + kprqs + gxzts);
		Ymm ymm = getYmm();
		FormBuilder formBuilder = new FormBuilder("method", "bdkgxcommit").add("fpdm", fpdms, true)// 勾选提交和撤销的id为同一个，只有zt不一样
				.add("fphm", fphms, true).add("kprq", kprqs, false).add("zt", gxzts, true).add("se", yxses, true)
				.add("cert", NSRSBH).add("token", _token).add("ymbb", getYmbb(bdkgx)).add("ts", ymm.getTs())
				.add("publickey", "").add("sign", sign).add("fply", "0");
		String loginC = sendPostUrl(bdkgx, formBuilder, "gbk");

		MsgEntry obj = praseJson(loginC, MsgEntry.class);
		return obj;
	}

	/**
	 * 发票不抵扣勾选查询
	 * 
	 * @param fpdm  发票代码
	 * @param fphm  发票号码
	 * @param rq_q  勾选日期起
	 * @param rq_z  勾选日期止
	 * @param xfsbh 销方识别号
	 * @param rzzt  勾选状态 0：未勾选；1：已勾选
	 * @param glzt  管理状态 0：全部；1：正常；2：非正常
	 * @param fplx  发票类型 -1：全部；01：增值税专用发票；03：机动车票；14：通行费电子发票
	 * @return
	 * @throws Exception
	 */
	public TBEntry bdkgxcx(String fpdm, String fphm, Date rq_q, Date rq_z, String xfsbh, String rzzt, String glzt,
			String fplx) throws Exception {
		checkLogin();
		// 获取rtm标签
		String rtm = SecUtil.getRtm();
		FormBuilder formBuilder = new FormBuilder("method", "fpquery").add("fpdm", fpdm).add("fphm", fphm)
				.add("rq_q", sd.format(rq_q)).add("rq_z", sd.format(rq_z)).add("xfsbh", xfsbh).add("rzzt", rzzt)
				.add("glzt", glzt).add("fplx", fplx).add("cert", NSRSBH).add("token", _token)
				.add("aoData", AoDataUtil.getAoDataBdkcx(1, 0, 15000), true).add("ymbb", getYmbb(bdkgx)).add("rtm", rtm)
				.add("sjly", "-1").add("fply", "0");
		String data = sendPostUrl(bdkgx, formBuilder, "gbk");
		// 解密
		String result = SecUtil.deCodeData(data, rtm);
		// 勾选结果
		TBEntry obj = praseJson(result, TBEntry.class);
		return obj;
	}

	/**
	 * 确认勾选首页 ---获取所属期
	 * 
	 * @return
	 * @throws Exception
	 */
	public MsgEntry hqssqNew() throws Exception {
		checkLogin();
//		cert=91310104057643445Y&token=2~0~0~~1~0~0~0~0~0~a4c30159-b579-46ea-9831-4990dfca572d&ymbb=3.1.01
		FormBuilder formBuilder = new FormBuilder("cert", NSRSBH).add("token", _token).add("ymbb", getYmbb(hqssq));
		String jsonStr = sendPostUrl(hqssq, formBuilder, "gbk");
		MsgEntry obj = praseJson(jsonStr, MsgEntry.class);
		log.info("确认勾选-首页：{}", jsonStr);
		return obj;
	}

	/**
	 * 进项发票查询--单票查询
	 * 
	 * @param fpdm
	 * @param fphm
	 * @throws Exception
	 */
	public FpcxEntry fpcx(String fpdm, String fphm) throws Exception {
		return fpcx(fpdm, fphm, "0");
	}

	/**
	 * 进项发票查询--单票查询
	 * 
	 * @param fpdm
	 * @param fphm
	 * @param cxfw 查询范围 默认0单票查询 未到期发票
	 * @param ssq  当前税款所属期 yyyyMM 在勾选平台2.0上，kprq_q，kprq_z 不需要，需要ssq
	 * 
	 * @throws Exception
	 */
	public FpcxEntry fpcx(String fpdm, String fphm, String cxfw) throws Exception {
		checkLogin();
		// 获取rtm标签
		String rtm = SecUtil.getRtm();

		FormBuilder formBuilder = new FormBuilder("fphm", fphm).add("fpdm", fpdm).add("cxfw", cxfw).add("cert", NSRSBH)
				.add("token", _token, true).add("ssq", "").add("aoData", AoDataUtil.getAoDataFpcx(1, 0, 50), true)
				.add("ymbb", getYmbb(dpcx)).add("rtm", rtm).add("fply", "0");

		String data = sendPostUrl(dpcx, formBuilder, "gbk");

		// 重试
		int i = 3;
		do {
			if (null == data || !data.startsWith("{\"data\":")) {
				data = sendPostUrl(dpcx, formBuilder, "gbk");
				i--;
			} else {
				i = 0;
			}
		} while (i > 0);

		// 解密
		String result = SecUtil.deCodeData(data, rtm);

		log.info("发票查询结果：{}", result);
		// "0" == t[9] ? o = "正常" : "1" == t[9] ? o = "已失控" : "2" == t[9] ? o = "已作废" :
		// "3" == t[9] ? o = "已红冲" : "4" == t[9] && (o = "异常"), $("#fpzt").val(o), "0"
		// == t[16] ? $("#yclb").val("发票状态变更") : "1" == t[16] ?
		// $("#yclb").val("申报用途变更（抵扣变代办退税）") : "2" == t[16] ? $("#yclb").val("管理状态异常") :
		// "3" == t[16] ? $("#yclb").val("重复认证") : $("#yclb").val("非异常"), "0" == t[19] ?
		// $("#glzt").val("正常") : "1" == t[19] ? $("#glzt").val("非正常") : "2" == t[19] &&
		// $("#glzt").val("疑似非正常"), $("#yxdkse").val(t[17]), "0" == t[11] ?
		// $("#xxly").val("扫描认证") : "1" == t[11] ? $("#xxly").val("系统推送") : "2" == t[11]
		// && $("#xxly").val("历史税控扫描认证"), "0" == t[12] ? ($("#gxbz").val("否"),
		// $("#skssql").hide(), $("#gxsjl").hide(), $("#gxytl").hide(),
		// $("#qrztl").hide(), $("#qrsjl").hide()) : "1" == t[12] &&
		// ($("#gxbz").val("是"), $("#gxsj").val(t[13]), $("#rzyfs").val(t[6]), "1" ==
		// t[18] || "4" == t[18] ? $("#gxyt").val("用于抵扣") : "2" == t[18] ?
		// $("#gxyt").val("用于退税") : "3" == t[18] || "5" == t[18] ?
		// $("#gxyt").val("用于代办退税") : "6" == t[18] ? $("#gxyt").val("不抵扣") : "7" ==
		// t[18] ? $("#gxyt").val("未准予退税") : "8" == t[18] && $("#gxyt").val("未准予代办退税"),
		// $("#skssql").show(), $("#gxsjl").show(), $("#gxytl").show(),
		// $("#qrztl").show(), $("#qrsjl").show(), "0" == t[14] && ($("#qrbz").val("否"),
		// $("#qrsjl").hide()), "1" != t[14] && "3" != t[18] && "5" != t[18] ||
		// ($("#qrbz").val("是"), $("#qrsjl").show(), $("#qrsj").val(t[15]), "3" != t[18]
		// && "5" != t[18] || $("#qrsj").val(t[13])))
		// 0:正常;1:已失控;2:已作废;3:已红冲;4:异常;5:;
		FpcxEntry obj = praseJson(result, FpcxEntry.class);
		obj.setFpdm(fpdm);
		obj.setFphm(fphm);
		return obj;
	}

	/**
	 * 未到勾选日期发票查询,不包含销防税号
	 * 
	 * @param fpdm 发票代码
	 * @param fphm 发票号码
	 * @param rq_q 开票日期起
	 * @param rq_z 开票日期始
	 * @throws Exception
	 */
	public WdqcxEntry wdqcx(String fpdm, String fphm, String rq_q, String rq_z) throws Exception {
		checkLogin();

		FormBuilder formBuilder = new FormBuilder("kprq_q", rq_q).add("kprq_z", rq_z).add("fphm", fphm)
				.add("fpdm", fpdm).add("cxfw", "0").add("cert", NSRSBH).add("token", _token)
				.add("aoData", AoDataUtil.getAoDataWdqcx(1, 0, 10000), true).add("ymbb", getYmbb(wdqcx))
				.add("ts", getYmm().getTs()).add("publickey").add("fply", "0");

		String result = sendPostUrl(wdqcx, formBuilder, "gbk");
		log.info("发票查询结果：{}", result);
		// 判断税款所属期是否为当月
		if (StringUtils.isNotBlank(result) && result.contains("n4000007")) {
			WdqcxEntry wdqcxEntry = new WdqcxEntry();
			wdqcxEntry.setKey1("n4000007");
			return wdqcxEntry;
		}
		WdqcxEntry obj = praseJson(result, WdqcxEntry.class);
		return obj;
	}

	/**
	 * 抵扣勾选统计查询
	 * 
	 * @throws Exception
	 */
	public MsgEntry cxtj() throws Exception {
		checkLogin();
		// 获取rtm标签
		String rtm = SecUtil.getRtm();

		FormBuilder formBuilder = new FormBuilder("id", "dktj").add("cert", NSRSBH).add("token", _token)
				.add("ymbb", getYmbb(dkgxtjcx)).add("qt", "dq").add("rtm", rtm);

		String data = sendPostUrl(dkgxtjcx, formBuilder, "gbk");
		// 解密
		String result = SecUtil.deCodeData(data, rtm);
		log.info("勾选统计查询结果：{}", result);
		MsgEntry obj = praseJson(result, MsgEntry.class);
		return obj;
	}

	/**
	 * 历史属期数据统计
	 * 
	 * @param bblx  报表类型：1--发票统计；2--异常发票统计
	 * @param skssq 税款所属期 yyyyMM
	 * @throws Exception
	 */
	public MsgEntry lssqsjtj(String bblx, String skssq) throws Exception {
		checkLogin();
		String id = "wqdktj";
		if ("2".equals(bblx)) {
			id = "dkycfptjbb";
		}
		FormBuilder formBuilder = new FormBuilder("id", id).add("cert", NSRSBH).add("token", _token).add("tjyf", skssq)
				.add("ymbb", getYmbb(dkgxtjcx)).add("qt", "wq");

		String result = sendPostUrl(dkgxtjcx, formBuilder, "gbk");
		log.info("勾选统计查询结果：{}", result);
		MsgEntry obj = praseJson(result, MsgEntry.class);
		return obj;
	}

	/**
	 * 抵扣勾选申请统计
	 * 
	 * @throws Exception
	 */
	public MsgEntry dkgxsqtj1() throws Exception {
		MsgEntry cxtj = cxtj();
		if (!"200".equals(cxtj.getKey1())) {
			log.warn("统计查询失败：{}", cxtj.getKey1());
			throw new JxjcException("统计查询败：" + cxtj.getKey1());
		}
		if (!"".equals(cxtj.getKey11())) {
			log.warn("已提交申请统计，申请统计时间：{}", cxtj.getKey11());
			throw new JxjcException("已提交申请统计，申请统计时间：" + cxtj.getKey11());
		}
		String key10 = cxtj.getKey10();
		String sign = getSign(key10);
		// 获取rtm标签
		String rtm = SecUtil.getRtm();

		FormBuilder formBuilder = new FormBuilder("id", "sqscdktjbb").add("cert", NSRSBH).add("token", _token)
				.add("tjyf", key10).add("ymbb", getYmbb(dkgxsqtj)).add("sign", sign).add("rtm", rtm);
		// 申请统计--直接完成统计
		// {"key4":"01=2=380.45=33.95=0=0=0;03=0=0=0=0=0=0;14=0=0=0=0=0=0;24=0=0=0=0=0=0;99=2=380.45=33.95=0=0=0;","key3":"2019-12-21
		// 03:57:02","key6":"00","key5":"01=2=380.45=33.95;03=0=0=0;14=0=0=0;99=2=380.45=33.95;","key2":"1~0~0~~1~0~0~0~0~0~1~08d00d9d-57fa-42e5-9867-e7d9ff162092","key1":"200"})
		String data = sendPostUrl(dkgxsqtj, formBuilder, "gbk");
		// 解密
		String result = SecUtil.deCodeData(data, rtm);
		log.info("勾选申请统计结果：{}", result);
		cxtj = praseJson(result, MsgEntry.class);
		if (!"200".equals(cxtj.getKey1())) {
			log.warn("申请统计失败：{}", cxtj.getKey1());
			throw new JxjcException("申请统计失败：" + cxtj.getKey1());
		}
		return cxtj;
	}

	/**
	 * 抵扣勾选确认签名
	 * 
	 * @throws Exception
	 */
	public MsgEntry dkgxqrqm(String password) throws Exception {
		MsgEntry cxtj = cxtj();
		if (!"200".equals(cxtj.getKey1()) || "".equals(cxtj.getKey5())) {
			log.warn("统计查询失败：{}", cxtj.getKey1());
			throw new JxjcException("统计查询败：" + cxtj.getKey1());
		}

		FormBuilder formBuilder01 = new FormBuilder("id", "hqbcsq")// 抵扣勾选确认签名
				.add("cert", NSRSBH).add("token", _token).add("ymbb", getYmbb(bcdkgxqrqm));

		String qrqm1 = sendPostUrl(bcdkgxqrqm, formBuilder01, "gbk");
		MsgEntry parse1 = praseJson(qrqm1, MsgEntry.class);
		if (!"201".equals(parse1.getKey1()) && !"200".equals(parse1.getKey1())) {// 200,当前存在可进行延期抵扣勾选的税款所属期；201，不存在可延期勾选
			log.warn("可延期勾选的属期信息查询失败：{}", parse1.getKey1());
			throw new JxjcException("可延期勾选的属期信息查询失败：" + parse1.getKey1());
		}
		FormBuilder formBuilder0 = new FormBuilder("id", "cxqrmmbz")// 抵扣勾选申请统计
				.add("cert", NSRSBH).add("token", _token).add("ymbb", getYmbb(dkgxqrqm));

		String qrqm0 = sendPostUrl(dkgxqrqm, formBuilder0, "gbk");
		MsgEntry parse0 = praseJson(qrqm0, MsgEntry.class);
		if (!"200".equals(parse0.getKey1())) {
			log.warn("公司税号查询失败：{}", parse0.getKey1());
			throw new JxjcException("公司税号查询失败：" + parse0.getKey1());
		}

		String key10 = cxtj.getKey10();
		String sign = getSign(key10 + "0");
		FormBuilder formBuilder = new FormBuilder("id", "qrsb")// 确认申报
				.add("cert", NSRSBH).add("token", _token).add("tjyf", key10).add("ymbb", getYmbb(dkgxsqtj))
				.add("rtype", "0").add("sign", sign);

		String result = sendPostUrl(dkgxsqtj, formBuilder, "gbk"); // 抵扣勾选申请统计
		log.info("认证结果：{}", result);
		MsgEntry parse = praseJson(result, MsgEntry.class);
		if (!"200".equals(parse.getKey1())) {
			log.warn("认证失败：{}", parse.getKey1());
			throw new JxjcException("认证失败：" + parse.getKey1());
		}
		String tjsjstr = cxtj.getKey9();
		String tjsjsign = "";
		String sign1 = getSign(key10 + tjsjsign + "1" + tjsjstr);
		FormBuilder formBuilder1 = new FormBuilder("id", "qrsb").add("cert", NSRSBH).add("token", _token)
				.add("tjyf", key10).add("tjsjsign", tjsjsign, true).add("tjsjstr", tjsjstr).add("password", password)
				.add("ymbb", getYmbb(dkgxsqtj)).add("rtype", "1").add("sign", sign1).add("alg", "0");
		String obj = sendPostUrl(dkgxsqtj, formBuilder1, "gbk"); // 抵扣勾选申请统计
		log.info("确认签名结果：{}", obj);
		MsgEntry parse2 = praseJson(obj, MsgEntry.class);
		if (!"200".equals(parse2.getKey1())) {
			log.warn("签名确认失败：{}", parse2.getKey1());
			throw new JxjcException("签名确认失败：" + parse2.getKey2());
		}
		if ("0".equals(parse2.getKey4())) {
			log.warn("确认密码输入错误！");
			throw new JxjcException("确认密码输入错误");
		}
		return parse2;
	}

	/**
	 * 抵扣勾选撤销统计/撤销签名
	 * 
	 * @throws Exception
	 */
	public MsgEntry dkgxcxtj() throws Exception {
		MsgEntry cxtj = cxtj();
		if (!"200".equals(cxtj.getKey1())) {
			log.warn("统计查询失败：{}", cxtj.getKey1());
			throw new JxjcException("统计查询失败：" + cxtj.getKey1());
		}
		// 未申请统计
		// {"key4":"","key3":"","key6":"01","key12":"","key5":"","key2":"1~0~0~~1~0~0~0~0~0~1~08d00d9d-57fa-42e5-9867-e7d9ff162092","key1":"200","key10":"201912","key11":"","key8":"","key7":"01","key9":""}
		if ("".equals(cxtj.getKey5())) {// TODO
			log.warn("统计未完成，申请统计时间：{}", cxtj.getKey11());
			throw new JxjcException("统计未完成，申请统计时间：" + cxtj.getKey11());
		}
		// 已申请统计
		// 已完成统计
		// {"key4":"01=2=380.45=33.95=0=0=0;03=0=0=0=0=0=0;14=0=0=0=0=0=0;24=0=0=0=0=0=0;99=2=380.45=33.95=0=0=0;","key3":"20","key6":"01","key12":"","key5":"2019-12-21
		// 03:57:02","key2":"1~0~0~~1~0~0~0~0~0~1~08d00d9d-57fa-42e5-9867-e7d9ff162092","key1":"200","key10":"201912","key11":"2019-12-21
		// 03:57:02","key8":"01","key7":"","key9":"01=2=380.45=33.95;03=0=0=0;14=0=0=0;99=2=380.45=33.95;"}
		String key10 = cxtj.getKey10();
		String sign = getSign(key10);
		FormBuilder formBuilder = new FormBuilder("id", "qxsb").add("cert", NSRSBH).add("token", _token)
				.add("tjyf", key10).add("ymbb", getYmbb(dkgxsqtj)).add("sign", sign);

		String result = sendPostUrl(dkgxsqtj, formBuilder, "gbk");
		log.info("撤销统计/撤销签名结果：{}", result);
		cxtj = praseJson(result, MsgEntry.class);
		if (!"200".equals(cxtj.getKey1())) {
			log.warn("撤销统计/撤销签名 失败：{}", cxtj.getKey1());
			throw new JxjcException("撤销统计/撤销签名 失败：" + cxtj.getKey1());
		}
		return cxtj;
	}

	/**
	 * 首页 - 抵扣勾选-抵扣勾选统计-历史属期数据统计-发票清单-查询明细下载（增值税专用发票）
	 * 
	 * @param skssq    税款所属期
	 * @param fpdm     发票代码
	 * @param fphm     发票号码
	 * @param xfsbh    销方识别号
	 * @param fply     用途 0：全部 1：抵扣 2：不抵扣
	 * @param qrrzrq_q 确认认证日期起
	 * @param qrrzrq_z 确认认证日期止
	 * @param bclj     下载保存路径
	 * @throws Exception 因之前有fply字段，故20211127税局更新添加的发票来源字段仅在当前功能下以fly表示 -1:全部 0：税控发票
	 *                   1：全电发票
	 */
	public void fpxz(String skssq, String fpdm, String fphm, String xfsbh, String fply, String qrrzrq_q,
			String qrrzrq_z, File bclj) throws Exception {
		checkLogin();
		// 第一次请求
		FormBuilder formBuilder = new FormBuilder("cert", NSRSBH).add("type", "HELLO").add("token", _token).add("ymbb",
				getYmbb(cxmxxz));
		String result = sendPostUrl(cxmxxz, formBuilder, "gbk");
		MsgEntry cxtj = praseJson(result, MsgEntry.class);
		if (!"200".equals(cxtj.getKey1())) {
			log.warn("查询明细下载 查询失败：{}", cxtj.getKey1());
			throw new JxjcException("查询明细下载 查询失败：" + cxtj.getKey1());
		}
		formBuilder = new FormBuilder("id", "dkfpmxxzsl").add("cert", NSRSBH).add("token", _token).add("tjyf", skssq)
				.add("fpdm", fpdm).add("fphm", fphm).add("xfsbh", xfsbh).add("fply", fply).add("qrrzrq_q", qrrzrq_q)
				.add("qrrzrq_z", qrrzrq_z).add("ymbb", getYmbb(cxmxxz)).add("qt", "wq").add("fly", "0");
		// 第二次请求
		result = sendPostUrl(cxmxxz, formBuilder, "gbk");
		cxtj = praseJson(result, MsgEntry.class);
		if (!"200".equals(cxtj.getKey1())) {
			log.warn("查询明细下载 查询失败：{}", cxtj.getKey1());
			throw new JxjcException("查询明细下载 查询失败：" + cxtj.getKey1());
		}

		formBuilder = new FormBuilder("randomKey", cxtj.getKey3()).add("token", _token).add("tjyf", skssq)
				.add("fpdm", fpdm).add("fphm", fphm).add("xfsbh", xfsbh).add("fply", fply).add("qrrzrq_q", qrrzrq_q)
				.add("qrrzrq_z", qrrzrq_z).add("cert", NSRSBH).add("num", "1");
		fpZipXz(cxtj.getKey4() + ".zip", bclj, formBuilder, cxmxxz + "?qt=wq&ymbb=" + _ymbb);
	}

	/**
	 * 发票下载查询（用于下载）
	 * 
	 * @param fplx  发票类型（0：全部；01：增值税专用发票；03：机动车销售统一发票；04：增值税普通发票；10：增值税普通发票（电子）；11：增值税普通发票（卷票）；15：二手车销售统一发票）
	 * @param sjlx  进销项 （0：全部；1：进项票；2：销项票）
	 * @param sqrqq 申请日期起
	 * @param sqrqz 申请日期止
	 * @throws Exception clzt -1:全部 0：待处理 1：正在处理 2：取消申请 3：处理完成
	 */
	public TBEntry fpxzcx(String fplx, String sjlx, String sqrqq, String sqrqz) throws Exception {
		checkLogin();
		FormBuilder formBuilder = new FormBuilder("id", "cxqq")
				.add("cert", NSRSBH)
				.add("token", _token)
				.add("fplx", fplx)
				.add("sjlx", sjlx)
				.add("clzt","-1")
				.add("sqrqq", sqrqq)
				.add("sqrqz", sqrqz)
				.add("aoData", AoDataUtil.getAoDataCxqq(1, 0, 500), true)
				.add("ymbb", getYmbb(fpxz));
		String result = sendPostUrl(fpxz, formBuilder, "gbk");
		TBEntry tbEntry = praseJson(result, TBEntry.class);
		return tbEntry;
	}

	/**
	 * 发票下载（单个文件）
	 * 
	 * @param wjm      文件路径
	 * @param filename 下载文件名
	 * @param bclj     保存路径
	 * @throws Exception
	 */
	public void fpxzmx(String wjm, String filename, File bclj,String lsh) throws Exception {
		checkLogin();
		FormBuilder formBuilder = new FormBuilder("id", "showyzm").add("cert", NSRSBH).add("token", _token)
				.add("ymbb", getYmbb(fpxz)).add("wjm", wjm).add("filename", filename).add("lsh",lsh);
		String result = sendPostUrl(fpxz, formBuilder, "gbk");
		MsgEntry cxtj = praseJson(result, MsgEntry.class);
		if (!"200".equals(cxtj.getKey1())) {
			log.warn("发票下载查询失败：{}", cxtj.getKey1());
			throw new JxjcException("发票下载查询失败：" + cxtj.getKey1() + cxtj.getKey2());
		}

//		formBuilder = new FormBuilder("wjm", wjm).add("filename", filename).add("yzmkey", "").add("yzmvalue", "");
//		fpZipXz(filename, bclj, formBuilder,
//				fpxz + "?id=xzexcel&cert=" + NSRSBH + "&token=" + _token + "&ymbb=" + getYmbb(fpxz)+"&lsh="+lsh);
		formBuilder = new FormBuilder("wjm", wjm).add("filename", filename).add("yzmkey", "").add("yzmvalue", "")
				.add("id","xzexcel").add("cert",NSRSBH).add("token",_token).add("ymbb",getYmbb(fpxz)).add("lsh",lsh);
		fpZipXz(filename, bclj, formBuilder,fpxz);
	}
	



	/**
	 * 发票下载--发票下载（批量）
	 * 
	 * @param fplx  发票类型（0：全部；01：增值税专用发票；03：机动车销售统一发票；04：增值税普通发票；10：增值税普通发票（电子）；11：增值税普通发票（卷票）；15：二手车销售统一发票）
	 * @param sjlx  进销项 （0：全部；1：进项票；2：销项票）
	 * @param sqrqq 申请日期起
	 * @param sqrqz 申请日期止
	 * @param bclj  保存路径
	 * @throws Exception
	 */
	public void fpxzmxpl1(String fplx, String sjlx, String sqrqq, String sqrqz, File bclj) throws Exception {
		// 发票查询
		TBEntry tbEntry = fpxzcx(fplx, sjlx, sqrqq, sqrqz);
		List<List<String>> aaData = tbEntry.getKey3().getAaData();
		System.out.println("aaData:"+aaData);
		for (List<String> list : aaData) {
			String string = list.get(8);
			if (!StringUtils.isNotBlank(string) || !string.contains("onclick")) {
				continue;
			}
			while (true) {
				if (!string.contains("replace")) {
					continue;
				}
				int indexOf = string.indexOf(".z");
				// 获取文件路径
				String substring = string.substring(string.indexOf("replace"), indexOf + 4);
				// 获取文件名
				String substring2 = substring.substring(substring.lastIndexOf("/") + 1);
				// 下载文件
				System.out.println("lsh:"+list.get(9));
				fpxzmx(substring, substring2, bclj,list.get(9));
				string = string.substring(indexOf + 5);
			}
		}

	}


	
	public MsgEntry qqxz1(String fplxs, String sjlxs, Date kprqq, Date kprqz, String password) throws Exception {
		checkLogin();
		String kprqqStr = sd.format(kprqq), kprqzStr = sd.format(kprqz);
		String timestamp = new Date().getTime() + "a";
		StringBuilder sb = new StringBuilder();
		sb.append(fplxs).append(sjlxs).append(kprqqStr).append(kprqzStr).append(password).append(timestamp);
		String sign = getSign(sb.toString());
		FormBuilder formBuilder = new FormBuilder("id", "qqxz").add("cert", NSRSBH).add("token", _token)
				.add("ymbb", getYmbb(fpxz)).add("fplxs", fplxs).add("sjlxs", sjlxs).add("kprqq", kprqqStr)
				.add("kprqz", kprqzStr).add("jymm", password).add("sign", sign).add("timestamp", timestamp);
		String result = sendPostUrl(fpxz, formBuilder, "gbk");
		MsgEntry cxtj = praseJson(result, MsgEntry.class);
		return cxtj;
	}

	public FpFpxx fpxzcxdp(String fpdm, String fphm, Date kprq, String sjlx, String fplx) throws Exception {
		FpFpxx fpFpxx = null;
			fpFpxx = fpxzcxdp(fpdm, fphm, sd.format(kprq), sjlx, fplx);
		return fpFpxx;
	}

	/**
	 * 发票下载--发票查询（带明细）
	 * 
	 * @param fpdm 发票代码
	 * @param fphm 发票号码
	 * @param kprq 开票日期
	 * @param sjlx 进销项 1：进项 2：销项
	 * @param fplx 发票类型 1：增值税专用发票 2：机动车销售统一发票 3：增值税普通发票 4：增值税普通发票（电子） 5：增值税普通发票（卷票）
	 *             6：二手车销售统一发票 8:通行费发票
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public FpFpxx fpxzcxdp1(String fpdm, String fphm, String kprq, String sjlx, String fplx) throws Exception {
		if (null == fplx)
			throw new JxjcException("发票下载查询-发票类型不能为空");
		if (!"2".equals(sjlx))
			sjlx = "1";
		checkLogin();
		FormBuilder formBuilder = new FormBuilder("id", "cxpmxx").add("cert", NSRSBH).add("token", _token)
				.add("fpdm", fpdm).add("fphm", fphm).add("kprq", kprq).add("sjlx", sjlx).add("fplx", fplx)
				.add("ymbb", getYmbb(fpxxww)).add("fply", "0");

		log.info("查询参数:{}", formBuilder.toString());
		log.info("传入前参数fpxxww:{}", fpxxww);
		String result = sendPostUrl(fpxxww, formBuilder, "gbk");
		log.debug("查询票面信息1：{}", result);
		
		Map<String, Object> fpxx = praseJson(result, Map.class);
		
		String errMsg;
		if (!"200".equals(fpxx.get("key1"))) {
			errMsg = "发票下载主信息查询失败：{}" + fpxx.get("key1") + fpxx.get("key2");
			log.warn(errMsg);
			throw new JxjcException(errMsg);
		}
		if ("0".equals(fpxx.get("key3"))) {
			errMsg = "没有符合条件的记录";
			log.warn(errMsg);
			throw new JxjcException(errMsg);
		}
		checkLogin();
		formBuilder = new FormBuilder("id", "cxhwxx").add("cert", NSRSBH).add("token", _token).add("fplx", fplx)
				.add("fpdm", fpdm).add("fphm", fphm).add("kprq", kprq).add("sjly", String.valueOf(fpxx.get("key5")))
				.add("aoData",
						"5".equals(fplx) ? AoDataUtil.getAoDataQpmJp(0, 0, 100) : AoDataUtil.getAoDataQpm(0, 0, 100),
						true)
				.add("ymbb", getYmbb(fpxxww)).add("fply", "0");
		String resultmx = sendPostUrl(fpxxww, formBuilder, "gbk");
		log.debug("查询票面信息2：{}", resultmx);
		TBEntry tbEntry = praseJson(resultmx, TBEntry.class);
		if (!"200".equals(tbEntry.getKey1())) {
			errMsg = "发票下载明细信息查询失败" + tbEntry.getKey1();
			log.warn(errMsg);
			throw new JxjcException(errMsg);
		}
		FpFpxx fpFpxx = tbEntry.fpcxZhFpxx(fpxx, fplx);
		return fpFpxx;
	}
	
	/**
	 * 发票下载--发票查询（带明细）
	 * 
	 * @param fpdm 发票代码
	 * @param fphm 发票号码
	 * @param kprq 开票日期
	 * @param sjlx 进销项 1：进项 2：销项
	 * @param fplx 发票类型 1：增值税专用发票 2：机动车销售统一发票 3：增值税普通发票 4：增值税普通发票（电子） 5：增值税普通发票（卷票）
	 *             6：二手车销售统一发票 8:通行费发票
	 * @throws Exception
	 */
	public FpFpxx fpxzcxdp(String fpdm, String fphm, String kprq, String sjlx, String fplx) throws Exception {
		if (null == fplx)
			throw new JxjcException("发票下载查询-发票类型不能为空");
		if (!"2".equals(sjlx))
			sjlx = "1";
		RpaFs rpaFs =new RpaFs();
		rpaFs.setGet_type("1");//请求类型 0下载，1查询
		rpaFs.setInv_code(fpdm);
		rpaFs.setInv_num(fphm);
		rpaFs.setInv_type1(SjZhUtil.rpaCyFplx(fplx));
		rpaFs.setInv_date(kprq);
		rpaFs.setTax_no(NSRSBH);
//		rpaFs.setTax_no("91530112662643371F");
		rpaFs.setInv_source("2");//发票来源0全部1全电2税控  默认为2
		String json =RpaFs.RpatoStr(rpaFs);
		log.info("发票查验发送的数据{}",json);
		
		String result =HttpUtil.sendPost(Rpafw, json,"utf-8");
		
		RpaJs rpaJs = praseJson(result,RpaJs.class);
		int i = 3;
		do {
			if (!"0".equals(rpaJs.getCode())&&(StringUtils.isBlank(result)||rpaJs.getMsg().contains("登录")||rpaJs.getMsg().contains("当前无可用浏览器"))) {
				log.info("查询异常：错误信息{}-{}，第{}次重新发送",rpaJs.getCode(),rpaJs.getMsg(),4-i);
				try {
					long start = System.currentTimeMillis();
					
					result =HttpUtil.sendPost(Rpafw, json,"utf-8");
					rpaJs = praseJson(result,RpaJs.class);
					long end = System.currentTimeMillis();
					System.out.println("第"+(4-i)+"次重发耗时："+(end-start)+"ms");
				} catch (Exception e1) {
					
				}
				i--;
			} else {
				i = 0;
			}
		} while (i > 0);
		if(!"0".equals(rpaJs.getCode())) {
			log.info("查询异常,错误信息{}-{}",rpaJs.getCode(),rpaJs.getMsg());
			throw new JxjcException("发票查询失败:"+rpaJs.getMsg());
		}
		String data = result.substring(result.indexOf("{\"details\""),result.indexOf(",\"msg\""));
		FpFpxx fpFpxx = RpaJs.DataToFpxx(data,fplx);
		return  fpFpxx;
	}
	
	/**
	 * 发票下载--请求下载（申请）Rpa方式
	 * 
	 * @param fplxs    发票类型 多种类型中间用“,”隔开 01（ 增值税专用发票）03（ 机动车销售统一发票）04（ 增值税普通发票）10（
	 *                 增值税普通发票（电子））11（ 增值税普通发票（卷票））15（ 二手车销售统一发票）
	 * @param sjlxs    进销项 inv_type，inv_source两个参数均使用0，1编码传参，按网站实际个数和 先后顺序对应0，1值，0表示不选，1表示选择
	 * @param kprqq    开票日期起
	 * @param kprqz    开票日期止
	 * @param password 解压密码
	 * @return MsgEntry 申请结果 key1=200 申请成功
	 * @throws Exception
	 */
	public RpaJs qqxz(String fplxs, String sjlxs, Date kprqq, Date kprqz, String password) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		RpaFs rpaFs =new RpaFs();
		rpaFs.setGet_type("2");//请求类型 0下载，1查询，2申请下载
		rpaFs.setTime_q(sdf.format(kprqq));
		rpaFs.setTime_z(sdf.format(kprqz));
//		rpaFs.setTax_no("91530112662643371F");
		rpaFs.setTax_no(NSRSBH);
		rpaFs.setInv_source("10");//进项
		rpaFs.setInv_type(SjZhUtil.rpaSqFplx(fplxs));//发票类型
		rpaFs.setPass_word1(password);
		String json =RpaFs.RpatoStr(rpaFs);
		log.info("发票申请发送的数据{}",json);
		String result =HttpUtil.sendPost(Rpafw, json,"utf-8");		
		RpaJs rpaJs = praseJson(result,RpaJs.class);
		if(!"0".equals(rpaJs.getCode())) {
			log.info("请求下载异常,错误信息{}-{}",rpaJs.getCode(),rpaJs.getMsg());
			throw new JxjcException("发票请求下载失败");
		}
		log.info("请求下载信息{}-{}",rpaJs.getCode(),rpaJs.getMsg());
		return rpaJs;
	}
	
	
	
	/**
	 * 发票下载--发票下载（批量）Rpa方式
	 * 
	 * @param fplx  发票类型（0：全部；01：增值税专用发票；03：机动车销售统一发票；04：增值税普通发票；10：增值税普通发票（电子）；11：增值税普通发票（卷票）；15：二手车销售统一发票）
	 * @param sjlx  进销项 （0：全部；1：进项票；2：销项票）
	 * @param sqrqq 申请日期起
	 * @param sqrqz 申请日期止
	 * @param bclj  保存路径
	 * @throws Exception
	 */
	public void fpxzmxpl(String fplx, String sjlx, String sqrqq, String sqrqz, File bclj) throws Exception {
		RpaFs rpaFs =new RpaFs();
		rpaFs.setGet_type("0");//请求类型 0下载，1查询
		rpaFs.setTime_q(sqrqq);
		rpaFs.setTime_z(sqrqz);
		rpaFs.setTax_no(NSRSBH);
//		rpaFs.setTax_no("91530112662643371F");
		String json =RpaFs.RpatoStr(rpaFs);
		log.info("发票下载发送的数据{}",json);
		String result =HttpUtil.sendPost(Rpafw, json,"utf-8");
		RpaJs rpaJs = praseJson(result,RpaJs.class);
		if(!"0".equals(rpaJs.getCode())) {
			log.info("下载异常,错误信息{}-{}",rpaJs.getCode(),rpaJs.getMsg());
			throw new JxjcException("发票下载失败");
		}
	}
	/**
	 * 勾选确认/勾选取消 单张发票操作
	 * 
	 * @param fpdm
	 * @param fphm
	 * @param kprq yyyy-MM-dd
	 * @param gxzt 1:勾选确认；0：取消勾选
	 * @param yxse 有效税额
	 * @return
	 * @throws Exception
	 */
	public List<RpaJs> gxtj(String[] fpdms, String[] fphms, String[] kprqs, String[] gxzts, String[] yxses)
			throws Exception {
		int len = fpdms.length;
		if (len == 0 || len != fphms.length || len != kprqs.length || len != gxzts.length || len != yxses.length) {
			throw new JxjcException("2001", "发票认证参数长度不匹配：" + len);
		}
		String _fpdm = StringUtils.join(fpdms, "=");// 平台通过=分割发票信息内容
		String _fphm = StringUtils.join(fphms, "=");
		String _kprq = StringUtils.join(kprqs, "=");
		String _gxzt = StringUtils.join(gxzts, "=");
		String _yxse = StringUtils.join(yxses, "=");
		return gxtj(_fpdm, _fphm, _kprq, _gxzt, _yxse);
	}
	
	/**
	 * 勾选确认/勾选取消 单/多张发票操作
	 * 
	 * @param fpdms 通过 = 分割多条数据
	 * @param fphms
	 * @param kprqs yyyy-MM-dd
	 * @param gxzts 1:勾选确认；0：取消勾选
	 * @param yxses 有效税额
	 * @return
	 * @beizhu fply:-1:全部 0：税控发票 1：全电发票
	 */
	public List<RpaJs> gxtj(String fpdms, String fphms, String kprqs, String gxzts, String yxses) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String[] fpdmList = fpdms.split("=");
		String[] fphmList = fphms.split("=");
		String[] kprqList = kprqs.split("=");
		String[] gxztList = gxzts.split("=");
		List<RpaJs> rpajsList = new ArrayList<RpaJs>();
		for(int i=0;i<fphmList.length;i++) {
			long start = System.currentTimeMillis();
			RpaFs rpaFs =new RpaFs();
			rpaFs.setGet_type("3");//请求类型 0下载，1查询
			rpaFs.setInv_code(fpdmList[i]);
			rpaFs.setInv_num(fphmList[i]);
			rpaFs.setIs_check(gxztList[i]);
			rpaFs.setInv_type("1");
			if("1".equals(gxztList[i])) {//1勾选，开票日期，0为取消勾选，勾选日期(开票日期起至今天)
				rpaFs.setTime_q(kprqList[i]);
				rpaFs.setTime_z(kprqList[i]);
			}else {
				rpaFs.setTime_q(kprqList[i]);
				rpaFs.setTime_z(sdf.format(new Date()));
			}
			rpaFs.setInv_source("2");
			rpaFs.setTax_no(NSRSBH);
//			rpaFs.setTax_no("91530112662643371F");
			String json =RpaFs.RpatoStr(rpaFs);
			log.info("发票勾选发送的数据{}",json);
			String result =HttpUtil.sendPost(Rpafw, json,"utf-8");
			RpaJs rpaJs = praseJson(result,RpaJs.class);
			if(!"-1".equals(rpaJs.getCode())) {
				log.info("勾选异常,错误信息{}-{}",rpaJs.getCode(),rpaJs.getMsg());
				continue;
			}
			long end = System.currentTimeMillis();
			log.info("第{}张发票变更勾选状态用时{}ms",i+1,end-start);
			rpajsList.add(rpaJs);
		}
		return rpajsList;
	}
	/**
	 * 抵扣勾选申请统计
	 * 
	 * @throws Exception
	 */
	public RpaJs dkgxsqtj(String tjzt) throws Exception {
		RpaFs rpaFs =new RpaFs();
		rpaFs.setGet_type("4");//请求类型 0下载，1查询，2申请下载,3抵扣勾选，4申请统计
		rpaFs.setTax_no(NSRSBH);
		rpaFs.setIs_statistic(tjzt);//0取消统计，1申请统计
		String json =RpaFs.RpatoStr(rpaFs);
		log.info("申请统计发送的数据{}",json);
		String result =HttpUtil.sendPost(Rpafw, json,"utf-8");		
		RpaJs rpaJs = praseJson(result,RpaJs.class);
		if(!"0".equals(rpaJs.getCode())) {
			log.info("申请统计状态变更异常,错误信息{}-{}",rpaJs.getCode(),rpaJs.getMsg());
			throw new JxjcException("申请统计状态变更异常"+rpaJs.getCode()+"-"+rpaJs.getMsg());
		}
		log.info("申请统计信息{}-{}",rpaJs.getCode(),rpaJs.getMsg());
		return rpaJs;
	}


	protected <T> T praseJson(String content, Class<T> valueType) {
		try {
			//防止字符串中包含\n报错
			objMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
			return objMapper.readValue(content, valueType);
		} catch (JsonParseException e) {
			log.warn("Json数据解析失败-{}:{}", e.getMessage(), content);
			throw new JxjcException("Json数据解析失败");
		} catch (JsonMappingException e) {
			log.warn("Json数据解析映射失败-{}:{}", valueType.getName(), content, e);
			throw new JxjcException("Json数据解析映射失败");
		} catch (IOException e) {
			log.warn("Json数据解析IO异常-{}:{}", valueType.getName(), content, e);
			throw new JxjcException("Json数据解析IO异常");
		}
	}

	private SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 发票zip下载
	 * 
	 * @param filename    保存的文件名称
	 * @param bclj        保存路径
	 * @param formBuilder 请求参数
	 * @param url         请求路径
	 */
	public void fpZipXz(String filename, File bclj, FormBuilder formBuilder, String url) {
		CloseableHttpResponse httpResponse = null;
		InputStream ips = null;
		FileOutputStream ops = null;
		File downFile = new File(bclj, filename);
		httplog.info("准备下载文件：{}", downFile.getAbsoluteFile());
		try {
			String realUrl = basePtUrl + url;
			String secparm = "";
			if (basePtUrl.indexOf("shaanxi") > -1) {
				secparm = "?" + JmcsUtil.jmcs1(url);
				if(realUrl.indexOf("?")>-1) {
					realUrl = realUrl.split("\\?")[0];
				}
				realUrl = realUrl+secparm;
			}
			List<Header> headerList = new ArrayList<Header>();
			if (realUrl.indexOf("shaanxi") > -1) {
			headerList.add(new BasicHeader("Referer", basePtUrl + "/main.b332c51a.html?_=" + _ymbb));
			headerList.add(new BasicHeader("Origin", basePtUrl));
			String cookie = "aWmLEArSjH0jS=5wRvtmpOG4jXGbVU3jiEPQhsr0iOE0iPS2CV3k_YzBE53v54XUFc1.OpKH84f_LnIV3kwABtXvMB_6GfGm0r1Cq; SF_cookie_8=35013549; XCSFXS=@%23%24%25%21@%23; MMKXG=N; YZMKXG=N; alg=0; nsrmc=%u5A01%u6C83%u514B%u5546%u52A1%u4FE1%u606F%u54A8%u8BE2%uFF08%u897F%u5B89%uFF09%u6709%u9650%u516C%u53F8; dqrq=2022-03-04; wdqbz=true; skssq=202202%3B20220315%3B202203; gxrqfw=20170101-20220228; showmask=1; token="
					+ _token
					+ "; sqcs=24%3B5%3B30%3B7%3BY; aWmLEArSjH0jT=53PD8dbEfvT3qqqmdVTRbGGgj3Kglv1DYDXF9axKXtN87myqYd1PYXP59FctNw6dU1ps3HL7pEgaX9LuRlYrqM2_EUqNbh8qzrFFhluGmt9wq2lgvzoXqYcF7TfV_ctNuSi816zPweDzceZ3JUgcz3YcWU2pAKe5X1TzRJ_E2.OeVFg2z8PS4fnByp8JS_b5M9hMqUP3vIa3t2TUgUduzrg0MbYHjZlXpNbwcs5jfl.OSOrKPs__.UePwwiylzrIJJKvt_lmvVA9rCtLdUdkzfDSOoPTgOJ5zUYpmLAs2x2zb1NHkpxNSX0WiQPjXOoLtlveV8nq5.eAESQKRnH170k";
			headerList.add(new BasicHeader("985689fk3Ku", SecUtil.getPublicKey(realUrl, formBuilder.toString())));
			headerList.add(new BasicHeader("Cookie", cookie));
			log.info("加密参数添加固定cookie值：{}", cookie);
			
			headerList.add(new BasicHeader("Host", basePtUrl.replace("https://", "")));
			headerList.add(new BasicHeader("Sec-Fetch-Mode", "navigate"));
			headerList.add(new BasicHeader("Sec-Fetch-Site", "same-origin"));
			headerList.add(new BasicHeader("X-Requested-With", "XMLHttpRequest"));
			headerList.add(new BasicHeader("Accept", ACCEPT));
			headerList.add(new BasicHeader("Accept-Encoding", ACCEPT_ENCODING));
			headerList.add(new BasicHeader("Accept-Language", ACCEPT_LANGUAGE));
			}
			
			HttpPost httpRequest = new HttpPost(realUrl);
			httpRequest.setConfig(HttpClientUtil.getRequestConfig());
			StringEntity entity = new StringEntity(formBuilder.toString(), contentType);
			httpRequest.setEntity(entity);
			if (null != headerList && !headerList.isEmpty()) {
				for (Header header : headerList) {
					if (null != header)
						httpRequest.setHeader(header);
				}
				httpRequest.setHeader("User-Agent",
						"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36");
			}
			httpResponse = httpClient.execute(httpRequest);
			HttpEntity httpEntity = httpResponse.getEntity();
			ips = httpEntity.getContent();
			ops = new FileOutputStream(downFile);
			int size = 0;
			byte[] buffer = new byte[1024*4];
			while ((size = ips.read(buffer)) != -1) {
				ops.write(buffer, 0, size);
			}
			ips.close();
			ops.flush();
			ops.close();
			httpResponse.close();
			httplog.info("下载文件成功：{}", downFile.getAbsoluteFile());
		} catch (IOException e) {
			httplog.warn("发票下载请求IO异常, {}:{}", e.getClass().getName(), e.getMessage());
			throw new JxjcException("-2", "io异常，网络错误:" + e.getMessage());
		} catch (JxjcException e) {
			throw e;
		} catch (Exception e) {
			httplog.warn("发票下载请求失败", e);
			throw new JxjcException("-9", "发票下载请求服务异常" + e.getMessage());
		} finally {
			try {
				if (null != httpResponse)
					httpResponse.close();
				if (null != ips)
					ips.close();
				if (null != ops)
					ops.close();
			} catch (IOException e) {
				httplog.warn("查询明细下载请求流关闭出错:{}", e.getMessage());
			}
		}
	}
	
	

	/**
	 * 税务数字账户
	 * 以导出功能替代文件下载
	 * @param rq_q    日期起
	 * @param rq_z    日期止
	 * @param fplxs   请求发票类型
	 * 
	 */
	public void swszzh(String kprqq, String kprqz,String fplxs) throws Exception {
		checkLogin();
		FormBuilder formBuilder = new FormBuilder("id", "count").add("cert", NSRSBH).add("token", _token)
				.add("ymbb", getYmbb(fpxz)).add("rq_q", kprqq).add("rq_z", kprqz).add("fplxs",fplxs)
				.add("fply","-1").add("zzhlx","1").add("nsrsbhs","").add("fpzt","-1");
		System.out.println("第一次请求"+formBuilder.toString());
		String result = sendPostUrl(fpxxww, formBuilder, "gbk");
		MsgEntry cxtj = praseJson(result, MsgEntry.class);
		if (!"200".equals(cxtj.getKey1())) {
			log.warn("发票下载查询失败：{}", cxtj.getKey1());
			throw new JxjcException("发票下载查询失败：" + cxtj.getKey1() + cxtj.getKey2());
		}
//		ymbb=4.0.19&token=2~0~0~~1~0~0~0~0~0~1~0~0~97051d6b-f855-4a31-b8be-c97cc0133def@@91610103MA6W5JB22G@@00&cert=91610103MA6W5JB22G
//				&id=export&fpdm=&fphm=&rq_q=2022-02-01&rq_z=2022-02-28&fplxs=14&fply=-1&zzhlx=1&fpzt=-1&nsrsbhs=
		formBuilder.set("id", "export");
		System.out.println("第二次请求"+formBuilder.toString());
	}

	public boolean netTest() {
		try {
			String index = HttpClientUtil.sendGet(httpClient, basePtUrl, "", "utf-8", null, contentType);
			log.debug("{}", index);
			if (index.indexOf("<title>增值税发票综合服务平台</title>") > -1) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public String toString() {
		return _NSRMC + " # " + NSRSBH + " # " + _DQRQ + " # " + _token;
	}

	/**
	 * 获取特定请求的ymbb
	 * 
	 * @param reqUrl
	 * @return
	 */
	private String getYmbb(String reqUrl) {
		String key = basePtUrl + reqUrl;
		if (StringUtils.isNotBlank(YmbbUtil.getReqVersionCache().get(key))) {
			return YmbbUtil.getReqVersionCache().get(key);
		}
		return _ymbb;
	}


}
