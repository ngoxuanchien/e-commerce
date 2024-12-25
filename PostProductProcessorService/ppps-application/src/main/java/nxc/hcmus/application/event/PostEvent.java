package nxc.hcmus.application.event;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @JsonProperty("routing_key")
    private String routingKey;
}
