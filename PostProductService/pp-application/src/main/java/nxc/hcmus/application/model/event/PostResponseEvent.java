package nxc.hcmus.application.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseEvent {
    private Long id;

    @JsonProperty("request_id")
    private String requestId;

    private Object payload;
}
