package com.gavin.oauth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import java.security.KeyPair;

@Configuration
@RequiredArgsConstructor
public class Oauth2Bean {

//  private final RedisConnectionFactory redisConnectionFactory;

  @Bean
  public TokenStore tokenStore() {
//    return new RedisTokenStore(redisConnectionFactory);
    return new JwtTokenStore(jwtAccessTokenConverter());
  }

  @Bean
  public JwtAccessTokenConverter jwtAccessTokenConverter() {
    JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
//    jwtAccessTokenConverter.setSigningKey("gavin-oauth2");
    jwtAccessTokenConverter.setKeyPair(keyPair());
    return jwtAccessTokenConverter;
  }

  @Bean
  public KeyPair keyPair() {
    //从classpath下的证书中获取秘钥对
    KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt-gavin.jks"), "gavin123".toCharArray());
    return keyStoreKeyFactory.getKeyPair("jwt-gavin", "gavin123".toCharArray());
  }

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
