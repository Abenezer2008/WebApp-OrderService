package webshop.dto;

import webshop.domain.Product;

public class ProductAdapter {
    public static ProductDTO toDTO(Product product){
        return new ProductDTO(product.getProductNumber(), product.getName(), product.getPrice(), "",0);
    }
}
