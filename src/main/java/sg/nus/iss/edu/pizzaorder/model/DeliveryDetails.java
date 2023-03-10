package sg.nus.iss.edu.pizzaorder.model;

import java.io.Serializable;
import java.security.SecureRandom;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;


public class DeliveryDetails implements Serializable {
    
    private String id;

    //For view 1
    @NotNull(message = "Please provide a name")
    @Size(min = 3, message = "Minimum 3 characters")
    private String name;

    @NotNull(message = "Please provide an address")
    @Size(min = 1, message = "Please provide an address")
    @Size(min = 9, message = "Minimum of 9 characters")
    private String address;

    @NotNull(message="Phone number cannot be null")
    @Size(min = 8, message = "Must contain at least 8 digits")
    private String phoneNumber;

    private boolean rush = false;
    private String rushCost;

    String pizzaType;
    String quantity;
    String size;
    
    private double totalCost;

    String comments;


    public DeliveryDetails() {
        // this.id = generateId();
    }

    public DeliveryDetails(String id) {
        this.id = id;
    }

    public DeliveryDetails(String name, String address, String phoneNumber,
    boolean rush, String comments) {
        // this.id = generateId();
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.rush = rush;
        this.comments = comments;
    }


    public DeliveryDetails(String id, String name, String address, String phoneNumber,
            boolean rush, String comments) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.rush = rush;
        this.comments = comments;
    }


    public String getId() {return id;}

    

    public void setId(String id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public boolean isRush() {return rush;}
    public void setRush(boolean rush) {
        this.rush = rush;
        String surcharge = "$2";
        if (this.rush == true){
            this.rushCost = surcharge;
        }
    }

    public String getComments() {return comments;}
    public void setComments(String comments) {this.comments = comments;}

    public String getRushCost() {return rushCost;}
    public void setRushCost(String rushCost) {this.rushCost =rushCost;}

    public String getPizzaType() {return pizzaType;}
    public void setPizzaType(String pizzaType) {this.pizzaType = pizzaType;}

    public String getQuantity() {return quantity;}
    public void setQuantity(String quantity) {this.quantity = quantity;}

    public String getSize() {return size;}
    public void setSize(String size) {this.size = size;}

    public double getTotalCost() {return totalCost;}

    public void setTotalCost(double totalCost) {this.totalCost = totalCost;}
    

    // private synchronized String generateId(int numOfChar){
    //     SecureRandom sr = new SecureRandom();
    //     StringBuilder sb = new StringBuilder();
    //     while(sb.length() < numOfChar) {
    //         sb.append(Integer.toHexString(sr.nextInt()));
    //     }
        
    //     return sb.toString().substring(0, numOfChar);
    // }

    //using UUID approach
    // private synchronized String generateId(){
    //     UUID uuid = UUID.randomUUID();
    //     String uuidString = uuid.toString().substring(0, 8);
    //     return uuidString;
    // }

    

}
