package sg.nus.iss.edu.pizzaorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import sg.nus.iss.edu.pizzaorder.model.DeliveryDetails;
import sg.nus.iss.edu.pizzaorder.model.Order;
import sg.nus.iss.edu.pizzaorder.service.OrderService;


@Controller
@RequestMapping
public class PizzaOrderController {

    @Autowired 
    private OrderService orderService;
    
    @GetMapping(path="/")
    public String getMain(Model m){
        m.addAttribute("order", new Order());
        return "index";
    }

    @PostMapping(path="/pizza")
    public String submit(@Valid Order order, BindingResult binding, Model m){
        if(binding.hasErrors()){
            return "index";
        }

        DeliveryDetails deliveryDetails = new DeliveryDetails();
        deliveryDetails.setId(order.getId());
        deliveryDetails.setPizzaType(order.getPizzaType());
        deliveryDetails.setSize(order.getSize());
        deliveryDetails.setQuantity(order.getQuantity());
       
        orderService.save(order);
        m.addAttribute("delivery", deliveryDetails);
        return "infoform";
        // return "displayorder";
        // return "delidis";
        
    }

    @PostMapping(path="/pizza/order")
    public String submitDelivery(@Valid @ModelAttribute("delivery") DeliveryDetails delivery, BindingResult binding, Model m){
        
        if(binding.hasErrors()){
            System.out.println(">>>>>>> There is an error.");
            return "infoform";
        }
       
        // String idString = Long.toString(id);
        // delivery.setId(idString);
        m.addAttribute("delivery", delivery);
        return "orderconfirmation";
    }

}
