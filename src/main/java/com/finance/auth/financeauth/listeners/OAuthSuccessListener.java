package com.finance.auth.financeauth.listeners;

import com.finance.auth.financeauth.dto.RegisterDTO;
import com.finance.auth.financeauth.service.MessagePublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OAuthSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {

    private final MessagePublisher messagePublisher;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        log.info("User authenticated: {}", event.getAuthentication().isAuthenticated());
        if (event.getAuthentication().isAuthenticated()) {
            DefaultOidcUser auth2User = (DefaultOidcUser) event.getAuthentication().getPrincipal();
            messagePublisher.notifyRecipient(new RegisterDTO(auth2User.getFullName(), auth2User.getEmail()));
        }
    }
}
