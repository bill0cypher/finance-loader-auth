package com.finance.auth.financeauth.config;

import com.finance.auth.financeauth.publisher.AuthPublisher;
import org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CsrfAuthenticationStrategy;

@Configuration
public class OAuth2Configurer extends WebSecurityConfigurerAdapter {

    private final AuthPublisher authPublisher;

    public OAuth2Configurer(AuthPublisher authPublisher) {
        this.authPublisher = authPublisher;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().anyRequest().authenticated().and()
                .oauth2Login().successHandler(new AuthSuccessHandler(authPublisher))
                .and()
                .logout().logoutSuccessHandler(new SignOutSuccessHandler(authPublisher));
    }
}
