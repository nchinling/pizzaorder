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
       
        // orderService.save(order);
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
       
        orderService.save(delivery);
        m.addAttribute("delivery", delivery);
        return "orderconfirmation";
    }

    @GetMapping(path="/pizza/order/{id}")
    public String getContactId(Model model, @PathVariable String id){
        
        DeliveryDetails order = orderService.findById(id);
        model.addAttribute("order", order);
        return "displayorder";
    }

    @GetMapping(path="/pizza/order/list")
    public String listAll(Model model, @RequestParam(defaultValue="0") Integer startIndex){
        List<DeliveryDetails> orders = orderService.findAll(startIndex);
        model.addAttribute("orders", orders);
        return "allorders";
    }

}
