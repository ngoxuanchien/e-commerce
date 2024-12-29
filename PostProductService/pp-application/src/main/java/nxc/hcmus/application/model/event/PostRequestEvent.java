package nxc.hcmus.application.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import nxc.hcmus.domain.model.enums.EventType;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestEvent {

    private Long id;

    private EventType type;
    private LocalDateTime timestamp;
    private Object payload;

    @JsonProperty("request_id")
    private String requestId;

    @JsonProperty("response_queue")
    private ResponseQueue responseQueue;
}
