package com.focp2.cli;

import java.util.Scanner;

public class InputManager {
    private final Scanner scanner;

    public InputManager() {
        this.scanner = new Scanner(System.in);
    }

    public String getUserInput() {
        return scanner.nextLine().trim();
    }

    public void closeScanner() {
        scanner.close();
    }
}
