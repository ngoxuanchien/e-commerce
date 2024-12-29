package nxc.hcmus.application.brokermq.producer;

import io.smallrye.reactive.messaging.rabbitmq.OutgoingRabbitMQMetadata;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Metadata;

import java.time.ZonedDateTime;

@ApplicationScoped
public class PostProductProducer {

    @Channel("product-response")
    Emitter<String> emitter;

    public void sendEvent(String routingKey, String payload) {
        var metadata = OutgoingRabbitMQMetadata.builder()
                .withRoutingKey(routingKey)
                .withTimestamp(ZonedDateTime.now())
                .build();

        var message = Message.of(payload, Metadata.of(metadata));
        emitter.send(message);
    }

}
