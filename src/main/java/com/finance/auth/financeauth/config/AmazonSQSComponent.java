package com.finance.auth.financeauth.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.finance.auth.financeauth.props.AWSProps;
import org.springframework.cloud.aws.messaging.core.QueueMessageChannel;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AmazonSQSComponent {

    private final AWSProps awsProps;

    public AmazonSQSComponent(AWSProps awsProps) {
        this.awsProps = awsProps;
    }

    public AmazonSQSAsync sqsClientAsync() {
        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(
                "sqs.us-west-2.amazonaws.com",
                awsProps.getRegion()
        );

        return AmazonSQSAsyncClientBuilder.standard()
                .withEndpointConfiguration(endpointConfiguration)
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(
                                        awsProps.getAccessKey(),
                                        awsProps.getSecretKey()
                                )
                        )
                ).build();
    }
    @Bean
    public QueueMessagingTemplate messagingTemplate(AmazonSQSAsync sqsAsync) {
        QueueMessagingTemplate messagingTemplate = new QueueMessagingTemplate(sqsClientAsync());
        messagingTemplate.setDefaultDestination(new QueueMessageChannel(sqsClientAsync(), awsProps.getMessagingChannel()));
        return messagingTemplate;
    }
}
