package nxc.hcmus.application.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nxc.hcmus.domain.model.enums.EventType;
import nxc.hcmus.infrastructure.config.RabbitMQConfig;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostEvent {
    private Long id;
    private EventType type;
    private LocalDateTime timestamp;
    private Object payload;

    @Builder.Default
    @JsonProperty("routing_key")
    private String routingKey = RabbitMQConfig.ROUTING_KEY;
}
