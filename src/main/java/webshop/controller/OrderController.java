package webshop.controller;

import webshop.dto.CustomerDTO;
import webshop.dto.OrderDTO;
import webshop.dto.ShoppingCartDTO;
import webshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/orders/{orderId}")
    public ResponseEntity<?> checkout(@PathVariable String orderId, @RequestBody ShoppingCartDTO shoppingCartDTO){
        OrderDTO orderDTO = orderService.checkout(orderId,shoppingCartDTO);
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }

    @PutMapping("/orders/{orderId}")
    public ResponseEntity<?> putOrder(@PathVariable String orderId, @RequestBody CustomerDTO customerDTO){
        OrderDTO orderDTO = orderService.putOrder(orderId,customerDTO);
        return new ResponseEntity<>(orderDTO,HttpStatus.OK);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<?> getOrder(@PathVariable String orderId){
        OrderDTO orderDTO = orderService.getOrder(orderId);
        return new ResponseEntity<>(orderDTO,HttpStatus.OK);
    }

    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<?> cancelOrder(@PathVariable String orderId){
        orderService.cancelOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT,HttpStatus.OK);
    }
}
