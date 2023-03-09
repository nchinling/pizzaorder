package sg.nus.iss.edu.pizzaorder.model;

import java.io.Serializable;
import java.security.SecureRandom;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class DeliveryDetails implements Serializable {
    
    private String id;

    //For view 1
    @NotNull(message = "Please provide a name")
    @Size(min = 3, message = "Minimum 3 characters")
    private String name;

    @NotNull(message = "Please provide an address")
    private String address;

    @NotNull(message="Phone number cannot be null")
    @Size(min = 8, message = "Must contain at least 8 digits")
    private String phoneNumber;

    private boolean rush = false;
    private String rushCost ="";

    String comments = "";


    public DeliveryDetails() {
        this.id = generateId(8);
    }

    public DeliveryDetails(String name, String address, String phoneNumber,
    boolean rush, String comments) {
        this.id = generateId(8);
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

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public boolean isRush() {return rush;}
    public void setRush(boolean rush) {this.rush = rush;}

    public String getComments() {return comments;}
    public void setComments(String comments) {this.comments = comments;}

    public String getRushCost() {return rushCost;}

    public void setRushCost(String rushCost) {
        this.rushCost = rushCost;
    }
    

    private synchronized String generateId(int numOfChar){
        SecureRandom sr = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        while(sb.length() < numOfChar) {
            sb.append(Integer.toHexString(sr.nextInt()));
        }
        
        return sb.toString().substring(0, numOfChar);
    }

}
