package sg.nus.iss.edu.pizzaorder.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sg.nus.iss.edu.pizzaorder.model.DeliveryDetails;
import sg.nus.iss.edu.pizzaorder.model.Order;

@Repository
public class OrderServiceRepo {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    private static final String ORDER_LIST = "orderlist";

    public Order save(final Order order) {
        System.out.println("Saving the order");
        redisTemplate.opsForList().leftPush(ORDER_LIST, order.getId());
        redisTemplate.opsForHash().put(ORDER_LIST +"_Map", order.getId(), order);

        return findById(order.getId());
    }

    // public DeliveryDetails save(final DeliveryDetails delivery) {
    //     System.out.println("Saving the delivery details");
    //     redisTemplate.opsForList().leftPush(ORDER_LIST, delivery.getId());
    //     redisTemplate.opsForHash().put(ORDER_LIST +"_Map", delivery.getId(), delivery);

    //     return findById2(delivery.getId());
    // }

    public Order findById(final String contactId){
        Order result = (Order) redisTemplate.opsForHash()
        .get(ORDER_LIST + "_Map", contactId);
        return result;
    }

    // public DeliveryDetails findById2(final String Id){
    //     DeliveryDetails result = (DeliveryDetails) redisTemplate.opsForHash()
    //     .get(ORDER_LIST + "_Map", Id);
    //     return result;
    // }
    
}
