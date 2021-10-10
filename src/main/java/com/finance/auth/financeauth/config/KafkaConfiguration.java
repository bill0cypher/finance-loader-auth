package com.finance.auth.financeauth.config;

import com.finance.auth.financeauth.dto.RegisterDTO;
import com.finance.auth.financeauth.props.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaConfiguration {

    private final ApplicationProperties applicationProperties;
    @Bean
    public KafkaAdmin kafkaAdminBean() {
        Map<String, Object> config = new HashMap<>();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, applicationProperties.getBootstrapServer());
        return new KafkaAdmin(config);
    }

    @Bean
    public NewTopic topicBean() {
        return TopicBuilder.name(applicationProperties.getTopicName()).partitions(1).replicas(1).build();
    }

    public ProducerFactory<String, RegisterDTO> producerFactory() {
        return new DefaultKafkaProducerFactory<>(Map.of(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, applicationProperties.getBootstrapServer(),
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, MessageSerializer.class
        ));
    }

    @Bean
    public KafkaTemplate<String, RegisterDTO> kafkaTemplateBean() {
        return new KafkaTemplate<>(producerFactory());
    }
}
