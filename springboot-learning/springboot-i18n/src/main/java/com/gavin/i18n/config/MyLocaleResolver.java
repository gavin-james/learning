package com.gavin.i18n.config;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author Felix.Du
 * @Description: 自定义LocaleResolver
 * @Date: 2022/3/30 21:25
 */
@Configuration
@RequiredArgsConstructor
public class MyLocaleResolver implements LocaleResolver {

  private final HttpServletRequest request;

  public Locale getLocal() {
    return resolveLocale(request);
  }

  /**
   * 从HttpServletRequest中获取Locale
   *
   * @param request request
   * @return 语言Local
   */
  @Override
  public Locale resolveLocale(HttpServletRequest request) {
    //获取请求中的语言参数
    String language = request.getParameter("lang");
    //如果没有就使用默认的（根据主机的语言环境生成一个 Locale
    Locale locale = Locale.getDefault();
    //如果请求的链接中携带了 国际化的参数
    if (!StringUtils.isEmpty(language)) {
      //zh_CN
      String[] s = language.split("_");
      //国家，地区
      locale = new Locale(s[0], s[1]);
    }
    return locale;
  }

  @Override
  public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

  }
}
