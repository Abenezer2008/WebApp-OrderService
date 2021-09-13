package webshop.dto;


import webshop.domain.CartItem;
import webshop.domain.ShoppingCart;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCartAdapter {
    public static ShoppingCartDTO toDTO(ShoppingCart shoppingCart){
        return new ShoppingCartDTO(shoppingCart.getCardId(),shoppingCart.getCartItems());
    }
    public static ShoppingCart fromDTO(ShoppingCartDTO shoppingCartDTO){
        Map<String, CartItem> cartItemMap = new HashMap<>();
        for(CartItem cartItem: shoppingCartDTO.getCartItems()){
            cartItemMap.put(cartItem.getProduct().getProductNumber(),cartItem);
        }
        return new ShoppingCart(shoppingCartDTO.getCardId(),cartItemMap);
    }
}
