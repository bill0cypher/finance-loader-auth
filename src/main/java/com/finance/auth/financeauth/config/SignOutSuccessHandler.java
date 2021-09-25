package com.finance.auth.financeauth.config;

import com.finance.auth.financeauth.enums.AuthStatus;
import com.finance.auth.financeauth.publisher.AuthPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignOutSuccessHandler implements LogoutSuccessHandler {

    private final AuthPublisher authPublisher;

    public SignOutSuccessHandler(AuthPublisher authPublisher) {
        this.authPublisher = authPublisher;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        authPublisher.sendShowApproval(AuthStatus.FORBIDDEN);
    }
}
