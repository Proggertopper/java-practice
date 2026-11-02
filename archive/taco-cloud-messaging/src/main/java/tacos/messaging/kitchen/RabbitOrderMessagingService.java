package tacos.messaging.kitchen;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tacos.TacoOrder;

@Service
public class RabbitOrderMessagingService implements OrderMessagingService{

    private final KafkaTemplate<String , TacoOrder> kafkaTemplate;

    public RabbitOrderMessagingService(KafkaTemplate<String , TacoOrder> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendOrder(TacoOrder order) {
            kafkaTemplate.send("orders", order);
    }

}
