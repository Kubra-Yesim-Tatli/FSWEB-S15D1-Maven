package org.example.models;

import java.util.*;

public class Grocery {

    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose an action: (0 to quit, 1 to add items, 2 to remove items)");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 0 -> running = false;
                case 1 -> {
                    System.out.println("Enter items to add (comma-separated): ");
                    String input = scanner.nextLine();
                    addItems(input);
                }
                case 2 -> {
                    System.out.println("Enter items to remove (comma-separated): ");
                    String input = scanner.nextLine();
                    removeItems(input);
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim();
            if (!checkItemIsInList(trimmed)) {
                groceryList.add(trimmed);
            }
        }
        sortList();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim();
            groceryList.remove(trimmed);
        }
        sortList();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        sortList();
        for (String item : groceryList) {
            System.out.println(item);
        }
    }

    private static void sortList() {
        Set<String> set = new HashSet<>(groceryList); // tekrarları engelle
        groceryList = new ArrayList<>(set);
        Collections.sort(groceryList);
    }
}
