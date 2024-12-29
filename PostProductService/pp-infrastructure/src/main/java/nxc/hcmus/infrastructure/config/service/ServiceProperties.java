package nxc.hcmus.infrastructure.config.service;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
import java.util.UUID;

@Configuration
@Getter
@Setter
public class ServiceProperties {

    private String appId;

    private String queueName = "product_response";

    @PostConstruct
    public void init() {
        getAppId();
    }

    public String getAppId() {
        return Optional.ofNullable(appId)
                .orElseGet(() -> appId = UUID.randomUUID().toString());
    }
}
