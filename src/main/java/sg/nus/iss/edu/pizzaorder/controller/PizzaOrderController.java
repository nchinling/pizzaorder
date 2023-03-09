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
import sg.nus.iss.edu.pizzaorder.model.Order;
// import sg.nus.iss.edu.pizzaorder.service.OrderService;


@Controller
@RequestMapping(path="/")
public class PizzaOrderController {
    
    @GetMapping
    public String getMain(Model m){
        m.addAttribute("order", new Order());
        return "index";
    }
}
