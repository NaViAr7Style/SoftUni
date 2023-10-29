package org.softuni.mobilele.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "open.exchange.rates")
@Getter
@Setter
public class OpenExchangeRateConfig {

    private String appId;
    private List<String> symbols;
    private String host;
    private String path;
    private String schema;
    private boolean isEnabled;

    @Override
    public String toString() {
        return "OpenExchangeRateConfig{" +
                "appId='" + appId + '\'' +
                ", symbols=" + symbols +
                ", host='" + host + '\'' +
                ", path='" + path + '\'' +
                ", schema='" + schema + '\'' +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
