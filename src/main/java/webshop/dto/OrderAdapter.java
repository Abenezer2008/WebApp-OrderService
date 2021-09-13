package webshop.dto;

import webshop.domain.Order;

public class OrderAdapter {
    public static OrderDTO toDTO(Order order){
        return new OrderDTO(order.getOrderId(),ShoppingCartAdapter.toDTO(order.getShoppingCart()), order.orderTotal(), CustomerAdapter.toDTO(order.getCustomer()),order.getOrderTime(),order.getCheckoutTime());
    }
}
