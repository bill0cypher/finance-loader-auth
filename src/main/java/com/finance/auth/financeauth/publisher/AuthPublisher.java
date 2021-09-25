package com.finance.auth.financeauth.publisher;

import com.finance.auth.financeauth.enums.AuthStatus;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class AuthPublisher {

    private final QueueMessagingTemplate template;

    public AuthPublisher(QueueMessagingTemplate template) {
        this.template = template;
    }

    public void sendShowApproval(AuthStatus authStatus) {
        template.convertAndSend(authStatus);
    }
}
