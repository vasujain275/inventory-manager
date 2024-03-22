package com.focp2.controller;

import com.focp2.model.Product;
import com.focp2.service.InventoryService;
import com.focp2.view.InventoryView;
import com.focp2.view.InputView;

public class InventoryController {
    private final InventoryService inventoryService;
    private final InventoryView inventoryView;
    private final InputView inputView;

    public InventoryController(InventoryService inventoryService, InventoryView inventoryView, InputView inputView) {
        this.inventoryService = inventoryService;
        this.inventoryView = inventoryView;
        this.inputView = inputView;
    }

    public void displayProducts() {
        inventoryView.displayProducts(inventoryService.getAllProducts());
    }

    public void addProduct() {
        Product product = inputView.createProduct();
        inventoryService.addProduct(product);
        inventoryView.displayMessage("Product added successfully.");
    }

    public void updateProduct() {
        inventoryView.displayMessage("Enter the ID of the product you want to update:");
        String productId = inputView.getUserInput();
        Product existingProduct = inventoryService.getProductById(productId);

        if (existingProduct != null) {
            Product updatedProduct = inputView.updateProductDetails(existingProduct);
            inventoryService.updateProduct(updatedProduct);
            inventoryView.displayMessage("Product updated successfully.");
        } else {
            inventoryView.displayError("Product not found.");
        }
    }
}
