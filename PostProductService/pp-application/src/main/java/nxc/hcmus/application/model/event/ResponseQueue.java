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
public class ResponseQueue {
    private String exchange;
    @JsonProperty("routing_key")
    private String routingKey;
}
