package sg.nus.iss.edu.pizzaorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import sg.nus.iss.edu.pizzaorder.model.DeliveryDetails;
import sg.nus.iss.edu.pizzaorder.model.Order;
// import sg.nus.iss.edu.pizzaorder.service.OrderService;


@Controller
@RequestMapping
public class PizzaOrderController {
    
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
       
        m.addAttribute("delivery", new DeliveryDetails());
        return "infoform";
    }

    @PostMapping(path="/pizza/order")
    public String submitOrder(DeliveryDetails delivery, BindingResult binding, Model m){
        if(binding.hasErrors()){
            return "infoform";
        }
       
        
        m.addAttribute("delivery", delivery);
        return "orderconfirmation";
    }

}
