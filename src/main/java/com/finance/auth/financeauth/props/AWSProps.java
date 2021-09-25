package com.finance.auth.financeauth.props;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "aws")
public class AWSProps {

    private String accessKey;
    private String secretKey;
    private String region;
    private String messagingChannel;

    public String getAccessKey() {
        return accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getRegion() {
        return region;
    }

    public String getMessagingChannel() {
        return messagingChannel;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setMessagingChannel(String messagingChannel) {
        this.messagingChannel = messagingChannel;
    }
}
