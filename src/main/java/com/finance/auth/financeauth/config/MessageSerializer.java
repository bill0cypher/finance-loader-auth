package com.finance.auth.financeauth.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finance.auth.financeauth.dto.MessageDTO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

@NoArgsConstructor
@Slf4j
public class MessageSerializer implements Serializer<MessageDTO> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String s, MessageDTO messageDTO) {
        if (messageDTO == null) {
            log.info("No data for serializing is present.");
            return null;
        }
        try {
            return objectMapper.writeValueAsBytes(messageDTO);
        } catch (Exception e) {
            throw new SerializationException("");
        }
    }
}
