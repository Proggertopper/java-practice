package tacos.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import tacos.data.OrderRepository;

@Service
public class OrderAdminService {

    private final OrderRepository orderRepository;

    OrderAdminService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }

}
