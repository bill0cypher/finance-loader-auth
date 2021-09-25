package com.finance.auth.financeauth.config;

import com.finance.auth.financeauth.enums.AuthStatus;
import com.finance.auth.financeauth.publisher.AuthPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    private final AuthPublisher authPublisher;

    public AuthSuccessHandler(AuthPublisher authPublisher) {
        this.authPublisher = authPublisher;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {


        if (authentication.isAuthenticated())
            authPublisher.sendShowApproval(AuthStatus.AUTHORIZED);
        else
            authPublisher.sendShowApproval(AuthStatus.FORBIDDEN);
    }
}
