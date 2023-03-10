package sg.nus.iss.edu.pizzaorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.iss.edu.pizzaorder.model.DeliveryDetails;
import sg.nus.iss.edu.pizzaorder.repository.OrderServiceRepo;


@Service
public class OrderService {
    
    @Autowired
    private OrderServiceRepo orderServiceRepo;

    public void save(final DeliveryDetails delivery){
        orderServiceRepo.save(delivery);
    }

    public DeliveryDetails findById(final String contactId){
        return orderServiceRepo.findById(contactId);
    }

    public List<DeliveryDetails> findAll(int startIndex){
        return orderServiceRepo.findAll(startIndex);
    }
}
