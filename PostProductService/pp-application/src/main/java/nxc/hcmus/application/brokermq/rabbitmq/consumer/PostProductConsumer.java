package nxc.hcmus.application.brokermq.rabbitmq.consumer;

public interface PostProductConsumer {
    void consumePostProductResponse(String message);
}
