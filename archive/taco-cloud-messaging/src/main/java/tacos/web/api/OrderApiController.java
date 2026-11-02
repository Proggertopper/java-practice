package tacos.web.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tacos.TacoOrder;
import tacos.data.OrderRepository;
import tacos.messaging.kitchen.RabbitOrderMessagingService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path = "/api/orders" , produces = "application/json")
public class OrderApiController {

    private final OrderRepository repository;
    private final RabbitOrderMessagingService rabbitMessagingService;

    OrderApiController(OrderRepository repository ,  RabbitOrderMessagingService rabbitMessagingService ) {
        this.repository = repository;
        this.rabbitMessagingService = rabbitMessagingService;

    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TacoOrder postOrder(@RequestBody TacoOrder order) {
        // rabbitMessagingService.sendOrder(order);
        return repository.save(order);
    }// пока тут не работает код, я же убрал Jms сообщения
}
