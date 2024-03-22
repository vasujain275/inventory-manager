package com.focp2.view;

import com.focp2.model.Product;
import java.util.List;

public class InventoryView {
    public void displayProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("Product ID | Product Name | Price | Quantity");
            for (Product product : products) {
                System.out.println(product.getId() + " | " + product.getName() + " | " +
                        product.getPrice() + " | " + product.getQuantity());
            }
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String errorMessage) {
        System.err.println(errorMessage);
    }
}
