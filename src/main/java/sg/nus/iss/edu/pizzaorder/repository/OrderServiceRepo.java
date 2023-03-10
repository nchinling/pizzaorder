package sg.nus.iss.edu.pizzaorder.repository;

import java.util.ArrayList;
import java.util.List;

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

    public DeliveryDetails save(final DeliveryDetails delivery) {
        System.out.println("Saving the order");
        redisTemplate.opsForList().leftPush(ORDER_LIST, delivery.getId());
        redisTemplate.opsForHash().put(ORDER_LIST +"_Map", delivery.getId(), delivery);
        System.out.println("Order saved successfully");

        return findById(delivery.getId());
    }

    public DeliveryDetails findById(final String contactId){
        DeliveryDetails result = (DeliveryDetails) redisTemplate.opsForHash()
                                    .get(ORDER_LIST + "_Map", contactId);
        return result;
    }

    //find all contacts
    public List<DeliveryDetails> findAll(int startIndex){
        List<Object> fromOrderList = redisTemplate.opsForList()
            .range(ORDER_LIST, startIndex, 10);

        List<DeliveryDetails> orders = new ArrayList<>();
        List<Object> objects = redisTemplate.opsForHash().multiGet(ORDER_LIST + "_Map", fromOrderList);
        for (Object object : objects) {
            if (object instanceof DeliveryDetails) {
            orders.add((DeliveryDetails) object);
            }
        }

        return orders;
    
        // List<Contact> ctcs = redisTemplate.opsForHash()
        //     .multiGet(CONTACT_LIST + "_Map", fromContactList)
        //     .stream()
        //     .filter(Contact.class::isInstance)
        //     .map(Contact.class::cast)
        //     .collect(Collectors.toList());

        // return ctcs;

    }

    
}
