package nxc.hcmus.application.event;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostEvent {

    @JsonProperty("request_id")
    private String requestId;

    private EventType type;

    private ZonedDateTime timestamp;

    private Object payload;

    @JsonProperty("response_queue")
    private ResponseQueue responseQueue;
}
