package sg.nus.iss.edu.pizzaorder.model;

import java.io.Serializable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Order implements Serializable {
    
    //For view 0
    @NotNull(message = "Select a pizza type")
    private String pizzaType;

    @NotNull(message = "Select a size")
    @Size(min = 1, message = "Select a size")
    private String size;

    @Min(value = 1, message = "Minimum of 1 pizza")
    @Max(value = 10, message = "Maximum of 10 pizza")
    private String quantity;

    //Constructors
    public Order() {}

    public Order(String pizzaType, String size, String quantity) {
        this.pizzaType = pizzaType;
        this.size = size;
        this.quantity = quantity;
    }


    //setters and getters
    public String getSize() {return size;}
    public void setSize(String size) {this.size = size;}

    public String getPizzaType() {return pizzaType;}
    public void setPizzaType(String pizzaType) {this.pizzaType = pizzaType;}

    public String getQuantity() {return quantity;}
    public void setQuantity(String quantity) {this.quantity = quantity;}

}

