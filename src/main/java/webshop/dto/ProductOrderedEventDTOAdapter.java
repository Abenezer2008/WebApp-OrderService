package webshop.dto;

import webshop.domain.CartItem;
import webshop.domain.ShoppingCart;

import java.util.HashMap;
import java.util.Map;

public class ProductOrderedEventDTOAdapter {
    public static ProductOrderedEventDTO toDTO(ShoppingCart shoppingCart){
        Map<String , Integer>  productMap = new HashMap<>();
        for(CartItem cartItem: shoppingCart.getCartItems()){
            productMap.put(cartItem.getProduct().getProductNumber(),cartItem.getQuantity());
        }
        return new ProductOrderedEventDTO(productMap);
    }
}
