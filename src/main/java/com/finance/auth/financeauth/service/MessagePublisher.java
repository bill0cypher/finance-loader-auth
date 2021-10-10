package com.finance.auth.financeauth.service;

import com.finance.auth.financeauth.dto.RegisterDTO;
import com.finance.auth.financeauth.props.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessagePublisher {

    private final KafkaTemplate<String, RegisterDTO> kafkaTemplate;
    private final ApplicationProperties applicationProperties;

    public void notifyRecipient(RegisterDTO registerDTO) {
        log.info("Set user into a queue for greeting mailing...");
        kafkaTemplate.send(applicationProperties.getTopicName(), "greetings", registerDTO);
    }
}
