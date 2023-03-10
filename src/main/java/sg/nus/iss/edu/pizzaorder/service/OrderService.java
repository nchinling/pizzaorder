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

    public double totalCost(final DeliveryDetails delivery){


        String pizza = delivery.getPizzaType(); // name of the pizza
        double singleQuantityPrice;
        double totalPrice;
        int quantity = Integer.parseInt(delivery.getQuantity());
        
        String size = delivery.getSize();
        double multiplier;
        
        switch (pizza) {
            case "marinara":
            case "bella":
            case "spianatacalabrese":
                singleQuantityPrice = 30.00;
                break;
            case "margherita":
                singleQuantityPrice = 22.00;
                break;
            case "trioformaggio":
                singleQuantityPrice = 25.00;
                break;
            default:
                singleQuantityPrice = 0.00; // default price for unknown pizzas
                break;
        }


        switch (size) {
            case "sm":
                multiplier = 1;
                break;
            case "md":
                multiplier = 1.2;
                break;
            case "lg":
                multiplier = 1.5;
                break;
            default:
                multiplier = 0; 
                break;
        }

        totalPrice = singleQuantityPrice*(double)(quantity)*multiplier;

        if (delivery.isRush() == true){
            totalPrice += 2;
        }

        return totalPrice;
    }
}
