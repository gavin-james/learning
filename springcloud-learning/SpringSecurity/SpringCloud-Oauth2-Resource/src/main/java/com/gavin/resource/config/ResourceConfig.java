package com.gavin.resource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

@Configuration
public class ResourceConfig extends ResourceServerConfigurerAdapter {

  @Bean
  public TokenStore tokenStore() {
    return new JwtTokenStore(jwtAccessTokenConverter());
  }

  @Bean
  public JwtAccessTokenConverter jwtAccessTokenConverter() {
    JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
//    jwtAccessTokenConverter.setSigningKey("gavin-oauth2");
    ClassPathResource resource = new ClassPathResource("jwt-public.key");
    // 2. 创建钥匙工厂
    KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(resource, "gavin123".toCharArray());
    // 3.通过别名拿到私钥
    KeyPair keyPair = keyStoreKeyFactory.getKeyPair("");
    // 4.设置进去
    jwtAccessTokenConverter.setKeyPair(keyPair);
    return jwtAccessTokenConverter;
  }

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    resources.tokenStore(tokenStore());
  }

}
