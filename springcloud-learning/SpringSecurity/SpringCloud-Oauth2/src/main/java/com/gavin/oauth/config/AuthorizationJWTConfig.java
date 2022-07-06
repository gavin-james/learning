package com.gavin.oauth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@RequiredArgsConstructor
@EnableResourceServer
public class AuthorizationJWTConfig extends AuthorizationServerConfigurerAdapter {
  private final TokenStore tokenStore;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;
  private final JwtAccessTokenConverter jwtAccessTokenConverter;

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    super.configure(clients);
    clients.inMemory()
            .withClient("web")
            .secret(passwordEncoder.encode("web-secret"))
            .scopes("web-scopes")
            .authorizedGrantTypes("authorization_code", "password", "client_credentials", "implicit")
            .redirectUris("www.baidu.com")
            .accessTokenValiditySeconds(5000);
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints.tokenStore(tokenStore)
            .authenticationManager(authenticationManager)
    .accessTokenConverter(jwtAccessTokenConverter);
  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    super.configure(security);
  }
}
