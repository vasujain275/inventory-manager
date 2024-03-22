package com.focp2.cli;

import com.focp2.controller.InventoryController;

public class InventoryCLI {
    private final WelcomeScreen welcomeScreen;
    private final AuthManager authManager;
    private final InputManager inputManager;
    private final OutputManager outputManager;
    private final InventoryController inventoryController;

    public InventoryCLI(WelcomeScreen welcomeScreen, AuthManager authManager, InputManager inputManager, OutputManager outputManager, InventoryController inventoryController) {
        this.welcomeScreen = welcomeScreen;
        this.authManager = authManager;
        this.inputManager = inputManager;
        this.outputManager = outputManager;
        this.inventoryController = inventoryController;
    }

    public void start() {
        welcomeScreen.displayWelcomeMessage();
        outputManager.displayMessage("Please log in to continue.");
        boolean loggedIn = false;

        while (!loggedIn) {
            outputManager.displayMessage("Enter your email:");
            String email = inputManager.getUserInput();

            outputManager.displayMessage("Enter your password:");
            String password = inputManager.getUserInput();

            if (authManager.login(email, password) != null) {
                outputManager.displayMessage("Login successful!");
                loggedIn = true;
            } else {
                outputManager.displayError("Invalid email or password. Please try again.");
            }
        }

        boolean running = true;
        while (running) {
            outputManager.displayMessage("1. View Products");
            outputManager.displayMessage("2. Add Product");
            outputManager.displayMessage("3. Update Product");
            outputManager.displayMessage("4. Logout");
            outputManager.displayMessage("Enter your choice:");

            String choice = inputManager.getUserInput();
            switch (choice) {
                case "1":
                    inventoryController.displayProducts();
                    break;
                case "2":
                    inventoryController.addProduct();
                    break;
                case "3":
                    inventoryController.updateProduct();
                    break;
                case "4":
                    authManager.logout();
                    outputManager.displayMessage("Logged out successfully.");
                    running = false;
                    break;
                default:
                    outputManager.displayError("Invalid choice. Please try again.");
                    break;
            }
        }

        inputManager.closeScanner();
    }
}
