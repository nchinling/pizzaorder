package sg.nus.iss.edu.pizzaorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.iss.edu.pizzaorder.model.Order;
import sg.nus.iss.edu.pizzaorder.repository.OrderServiceRepo;

@Service
public class OrderService {
    
    @Autowired
    private OrderServiceRepo orderServiceRepo;

    public void save(final Order order){
        orderServiceRepo.save(order);
    }
}
