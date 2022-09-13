package service;

import model.Product;

public class ProductController {

    int totalQuantity = 0;

    public void totalValueInStock(Product product, double price, int quantity){
       product.setTotalValue(price * quantity);
    }

    public void addProducts(Product product, int quantity){
        totalQuantity = product.getQuantity() + quantity;
        product.setQuantity(totalQuantity);
    }

    public void removeProducts(Product product, int quantity){
        totalQuantity = product.getQuantity() - quantity;
        product.setQuantity(totalQuantity);
    }

    public void changeProductPrice(Product product, double priceChange){
        product.setPrice(priceChange);
    }
}
