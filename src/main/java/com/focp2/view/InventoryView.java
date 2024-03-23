package com.focp2.view;

import com.focp2.model.Product;
import java.util.List;

public class InventoryView {

    public void displayProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-40s | %-10s | %-8s |\n", "Product ID", "Product Name", "Price", "Quantity");
            System.out.println("-----------------------------------------------------------------------------");
            for (Product product : products) {
                System.out.printf("| %-10s | %-40s | $%-9.2f | %-8d |\n",
                        product.getId(), product.getName(), product.getPrice(), product.getQuantity());
            }
            System.out.println("-----------------------------------------------------------------------------");
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String errorMessage) {
        System.err.println(errorMessage);
    }
}
