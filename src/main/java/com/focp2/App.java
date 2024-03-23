package com.focp2;

import com.focp2.cli.AuthManager;
import com.focp2.cli.InputManager;
import com.focp2.cli.InventoryCLI;
import com.focp2.cli.OutputManager;
import com.focp2.controller.InventoryController;
import com.focp2.controller.LoginController;
import com.focp2.repository.ProductRepository;
import com.focp2.repository.UserRepository;
import com.focp2.service.AuthService;
import com.focp2.service.InventoryService;
import com.focp2.view.InventoryView;
import com.focp2.view.InputView;
import com.focp2.cli.WelcomeScreen;

public class App {
    public static void main(String[] args) {
        // Initialize repositories
        ProductRepository productRepository = new ProductRepository();
        UserRepository userRepository = new UserRepository();

        // Initialize services
        AuthService authService = new AuthService(userRepository);
        InventoryService inventoryService = new InventoryService(productRepository);

        // Initialize controllers
        LoginController loginController = new LoginController(authService);
        InventoryController inventoryController = new InventoryController(inventoryService,
                new InventoryView(), new InputView());

        // Initialize CLI components
        OutputManager outputManager = new OutputManager();
        InputManager inputManager = new InputManager();
        AuthManager authManager = new AuthManager(authService);
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        InventoryCLI inventoryCLI = new InventoryCLI(welcomeScreen, authManager, inputManager,
                outputManager, inventoryController);

        // Run the application
        inventoryCLI.start();

        // Clean up resources
        inputManager.closeScanner();
    }
}
