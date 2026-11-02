package tacos.web;

import jakarta.validation.Valid;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import lombok.extern.slf4j.Slf4j;
import tacos.TacoOrder;
import tacos.User;
import tacos.data.OrderRepository;
import tacos.messaging.kitchen.RabbitOrderMessagingService;


@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderProps props;
    private final RabbitOrderMessagingService  rabbitOrderMessagingService;



    public OrderController(OrderRepository orderRepository ,  OrderProps props ,  RabbitOrderMessagingService rabbitOrderMessagingService) {
        this.orderRepository = orderRepository;
        this.props = props;
        this.rabbitOrderMessagingService = rabbitOrderMessagingService;
    }


    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @GetMapping
    public String ordersForUser( @AuthenticationPrincipal User user , Model model) {
        Pageable pageable = PageRequest.of(0 , props.getPageSize());
        model.addAttribute("orders" , orderRepository.findByUserOrderByPlacedAtDesc(user , pageable));
        return "orderList";
    }

    @PostMapping
    public String processOrder( @Valid TacoOrder order, Errors errors ,
                                SessionStatus sessionStatus , @AuthenticationPrincipal User user) {
        if(errors.hasErrors()) {
            return "orderForm";
        }

        order.setUser(user);
        orderRepository.save(order);
        sessionStatus.setComplete();
        rabbitOrderMessagingService.sendOrder(order);
        return "redirect:/";
    }

}
