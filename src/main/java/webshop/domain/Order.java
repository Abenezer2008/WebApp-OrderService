package webshop.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Document
public class Order {
    @Id
    private String orderId;
    private ShoppingCart shoppingCart;
    private Customer customer;
    private LocalDateTime orderTime;
    private LocalDateTime checkoutTime;

    public Order(){}

    public Order(String orderId, ShoppingCart shoppingCart) {
        this.orderId = orderId;
        this.shoppingCart = shoppingCart;
        checkoutTime = LocalDateTime.now();
    }

    public void addCustomer(Customer customer){
        this.customer = customer;
        orderTime = LocalDateTime.now();
    }

    public double orderTotal(){
        return shoppingCart.getCartItems().stream().flatMap(cartItem -> Stream.of(cartItem.getProduct().getPrice() * cartItem.getQuantity())).mapToDouble(x -> x).sum();
    }

    public String getOrderId() {
        return orderId;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public LocalDateTime getCheckoutTime() {
        return checkoutTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", shoppingCart=" + shoppingCart +
                ", customer=" + customer +
                ", orderTime=" + orderTime +
                ", checkoutTime=" + checkoutTime +
                ", orderTotal=" + orderTotal() +
                '}';
    }


}
