package webshop.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Document
public class ShoppingCart {
    @Id
    private String cardId;
    private Map<String  , CartItem> cartItems;

    public ShoppingCart(){}

    public ShoppingCart(String cardId,Map<String,CartItem> cartItems) {
        this.cardId = cardId;
        this.cartItems = cartItems;
    }


    public String getCardId() {
        return cardId;
    }

    public List<CartItem> getCartItems(){
        return this.cartItems.values().stream().collect(Collectors.toList());
    }
}
