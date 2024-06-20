package io.github.ndimovt.extengandinterfaces.inventory;

import io.github.ndimovt.extengandinterfaces.inventory.datahandling.FileWriting;
import io.github.ndimovt.extengandinterfaces.inventory.entities.ElectronicsItem;
import io.github.ndimovt.extengandinterfaces.inventory.entities.FragileItem;
import io.github.ndimovt.extengandinterfaces.inventory.entities.InventoryItem;

import java.util.*;

public class CLI {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, String> items = new HashMap<>();
    private static FileWriting fileWriting = new FileWriting();

    public static void main(String[] args) {
        items = fileWriting.loadInventory();
        boolean running = true;

        while (running) {
            System.out.println("Choose an option: add, remove, list, categorize, order, save, load, exit");
            String choice = scanner.nextLine();

            switch (choice.toLowerCase()) {
                case "add":
                    addItem();
                    break;
                case "remove":
                    removeItem();
                    break;
                case "list":
                    listItems();
                    break;
                case "categorize":
                    categorizeItems();
                    break;
                case "order":
                    processOrder();
                    break;
                case "save":
                    fileWriting.saveInventory(items);
                    break;
                case "load":
                    items = fileWriting.loadInventory();
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void addItem() {
        System.out.println("Enter item type (electronics, fragile):");
        String type = scanner.nextLine().toLowerCase();
        System.out.println("Enter item details (id,quantity,name,description,price,specificAttribute):");
        String[] details = scanner.nextLine().split(",");

        InventoryItem item = null;
        switch (type) {
            case "electronics":
                item = new ElectronicsItem(
                        Integer.parseInt(details[0]),
                        Integer.parseInt(details[1]),
                        details[2],
                        details[3],
                        Double.parseDouble(details[4]),
                        Double.parseDouble(details[5])
                );
                break;
            case "fragile":
                item = new FragileItem(
                        Integer.parseInt(details[0]),
                        Integer.parseInt(details[1]),
                        details[2],
                        details[3],
                        Double.parseDouble(details[4]),
                        Double.parseDouble(details[5]),
                        Boolean.parseBoolean(details[6])
                );
                break;
            default:
                System.out.println("Invalid item type.");
                return;
        }

        items.put(item.getId(), item.getDetails());
        System.out.println("Item added.");
    }

    private static void removeItem() {
        System.out.println("Enter item ID to remove:");
        int id = Integer.parseInt(scanner.nextLine());
        if (items.remove(id) != null) {
            System.out.println("Item removed.");
        } else {
            System.out.println("Item not found.");
        }
    }

    private static void listItems() {
        items.forEach((k,v) -> System.out.println(v));
    }

    private static void categorizeItems() {
        // This would involve more complex logic, such as sorting or filtering based on category
        System.out.println("Categorize items functionality not implemented yet.");
    }

    private static void processOrder() {
        System.out.println("Order processing functionality not implemented yet.");
    }
}
