package webshop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webshop.domain.Customer;
import webshop.domain.Order;
import webshop.domain.ShoppingCart;
import webshop.dto.*;
import webshop.integration.CustomerOrderedEventSender;
import webshop.integration.ProductOrderedEventSender;
import webshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class.getName());

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductOrderedEventSender productOrderedEventSender;
    @Autowired
    private CustomerOrderedEventSender customerOrderedEventSender;

    @Override
    public OrderDTO checkout(String orderId, ShoppingCartDTO cartDTO) {
        logger.info("Calling checkout");
        ShoppingCart shoppingCart = ShoppingCartAdapter.fromDTO(cartDTO);
        Order order = new Order(orderId,shoppingCart);
        orderRepository.save(order);
        OrderDTO orderDTO = OrderAdapter.toDTO(order);
        logger.info("Checking out");
        return orderDTO;
    }

    @Override
    public OrderDTO putOrder(String orderId, CustomerDTO customerDTO) {
        logger.info("Calling put order");
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isPresent()){
            Customer customer = CustomerAdapter.fromDTO(customerDTO);
            Order order = optionalOrder.get();
            order.addCustomer(customer);
            orderRepository.save(order);
            //update product in stock
            ProductOrderedEventDTO productOrderedEventDTO = ProductOrderedEventDTOAdapter.toDTO(order.getShoppingCart());
            productOrderedEventSender.send(productOrderedEventDTO);
            //send email to customer
            CustomerOrderedEventDTO customerOrderedEventDTO = new CustomerOrderedEventDTO(order.getCustomer().getCustomerId(),order.toString());
            customerOrderedEventSender.send(customerOrderedEventDTO);
            logger.info("Putting order");
            return OrderAdapter.toDTO(order);
        }
        logger.info("Putting order with invalid order id");
        return null;
    }

    @Override
    public OrderDTO getOrder(String orderId) {
        logger.info("Calling get Order");
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isPresent()){
            logger.info("Getting Order.");
            return OrderAdapter.toDTO(optionalOrder.get());
        }
        logger.info("Get order with invalid id");
        return null;
    }

    @Override
    public OrderDTO gerOrderByCustomer(String customerId) {
        return null;
    }

    @Override
    public void cancelOrder(String orderId) {
        logger.info("Calling cancel order");
        orderRepository.deleteById(orderId);
    }
}