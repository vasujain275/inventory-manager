package com.focp2.view;

import com.focp2.model.Product;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public Product createProduct() {
        System.out.println("Enter product ID:");
        String id = scanner.nextLine().trim();
        System.out.println("Enter product name:");
        String name = scanner.nextLine().trim();
        System.out.println("Enter product price:");
        double price = Double.parseDouble(scanner.nextLine().trim());
        System.out.println("Enter product quantity:");
        int quantity = Integer.parseInt(scanner.nextLine().trim());
        return new Product(id, name, price, quantity);
    }

    public Product updateProductDetails(Product existingProduct) {
        System.out.println("Enter new name for the product:");
        String name = scanner.nextLine().trim();
        System.out.println("Enter new price for the product:");
        double price = Double.parseDouble(scanner.nextLine().trim());
        System.out.println("Enter new quantity for the product:");
        int quantity = Integer.parseInt(scanner.nextLine().trim());
        existingProduct.setName(name);
        existingProduct.setPrice(price);
        existingProduct.setQuantity(quantity);
        return existingProduct;
    }

    public String getUserInput() {
        return scanner.nextLine().trim();
    }

    public void closeScanner() {
        scanner.close();
    }
}
