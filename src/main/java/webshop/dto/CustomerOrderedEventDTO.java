package webshop.dto;

public class CustomerOrderedEventDTO {
    private String customerId;
    private String orderSummary;

    public CustomerOrderedEventDTO(){}

    public CustomerOrderedEventDTO(String customerId, String orderSummary) {
        this.customerId = customerId;
        this.orderSummary = orderSummary;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getOrderSummary() {
        return orderSummary;
    }

    @Override
    public String toString() {
        return "CustomerOrderedEventDTO{" +
                "customerId='" + customerId + '\'' +
                ", orderSummary='" + orderSummary + '\'' +
                '}';
    }
}
