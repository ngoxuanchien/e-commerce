package nxc.hcmus.application.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nxc.hcmus.domain.model.enums.RequestStatus;
import nxc.hcmus.domain.model.enums.RequestType;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestEvent {

    @JsonProperty("request_id")
    private UUID requestId;

    private RequestType type;

    private Object payload;

    private ZonedDateTime timestamp;

    @JsonProperty("response_queue")
    private ResponseQueue responseQueue;
}
