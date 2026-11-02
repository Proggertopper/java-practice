/*package tacos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tacos.messaging.JmsOrderMessagingService;
import tacos.messaging.kitchen.JmsOrderReceiver;


@SpringBootTest
public class JmsIntegrationTest {

    @Autowired
    private JmsOrderMessagingService jmsOrderMessagingService;

    @Autowired
    private JmsOrderReceiver jmsOrderReceiver;

    @Test
    void testSendAndReceiveOrder() throws Exception {

        TacoOrder order = new TacoOrder();
        order.setDeliveryName("Sasha");
        order.setDeliveryCity("Kyiv");
        order.setDeliveryStreet("Main Street 42");
        order.setDeliveryState("UA");
        order.setDeliveryZip("01001");
        order.setCcNumber("4111111111111111");
        order.setCcExpiration("12/30");
        order.setCcCVV("123");


       jmsOrderMessagingService.sendOrder(order);
        Thread.sleep(10000);

        jmsOrderReceiver.receiveOrder(order);


    }
}*/
