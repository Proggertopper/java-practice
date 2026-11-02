package tacos.messaging.kitchen;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tacos.TacoOrder;

import java.lang.reflect.Type;

@Component
public class RabbitOrderReceiver {

    /*private final RabbitTemplate rabbitTemplate;
    private final MessageConverter messageConverter;

    public RabbitOrderReceiver(RabbitTemplate rabbitTemplate ,  MessageConverter messageConverter) {
        this.rabbitTemplate = rabbitTemplate;
        this.messageConverter = messageConverter;
    }

    public TacoOrder receiveOrder(TacoOrder order) {
        //Message message = rabbitTemplate.receive("tacocloud.order" , 30000);
        //return message!=null ? (TacoOrder) messageConverter.fromMessage(message) : null;
        return  rabbitTemplate.receiveAndConvert("tacocloud.order.queue", new ParameterizedTypeReference<>() {});
    }*/

    private static final Logger log = LoggerFactory.getLogger(RabbitOrderReceiver.class);

    @KafkaListener(topics = "orders" , groupId = "tacoGroup")
    public void receiveOrder(TacoOrder order) throws InterruptedException {
        log.info("Получено сообщение: {}", order);
    }
}
