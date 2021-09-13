package webshop.service;

import webshop.dto.CustomerDTO;
import webshop.dto.OrderDTO;
import webshop.dto.ShoppingCartDTO;

public interface OrderService {
    OrderDTO checkout(String orderId, ShoppingCartDTO cartDTO);
    OrderDTO putOrder(String orderId, CustomerDTO customerDTO);
    OrderDTO getOrder(String orderId);
    OrderDTO gerOrderByCustomer(String customerId);
    void cancelOrder(String orderId);
}
