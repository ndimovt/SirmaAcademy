package io.github.ndimovt.extengandinterfaces.inventory;

import io.github.ndimovt.extengandinterfaces.inventory.datahandling.DataBaseCRUD;
import io.github.ndimovt.extengandinterfaces.inventory.entities.ElectronicsItem;
import io.github.ndimovt.extengandinterfaces.inventory.entities.FragileItem;
import io.github.ndimovt.extengandinterfaces.inventory.entities.GrocerieItem;
import io.github.ndimovt.extengandinterfaces.inventory.entities.InventoryItem;

import java.util.*;

public class CLI {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, InventoryItem> items = new HashMap<>();
    private static Map<Integer, InventoryItem> unfitItems = new HashMap<>();
    private static List<String> content = new ArrayList<>();
    private static DataBaseCRUD db = new DataBaseCRUD();

    public static void main(String[] args) {
        content = db.read();
        boolean running = true;

        while (running) {
            System.out.println("Choose an option: add, remove, list, categorize, order, save, load, exit");
            String choice = scanner.nextLine();

            switch (choice.toLowerCase()) {
                case "add":
                    addItem();
                    break;
                case "remove":
                    System.out.println("Enter id of item you want to remove: ");
                    int id = scanner.nextInt();
                    db.delete(id);
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
                    //fileWriting.saveInventory(items);
                    break;
                case "load":
                    //items = fileWriting.loadInventory();
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
        System.out.println("Enter item type (electronics, fragile, groceries):");
        String type = scanner.nextLine().toLowerCase();

        InventoryItem item = null;
        switch (type) {
            case "electronics":
                System.out.println("Enter item details (id,quantity,name,description,price,warranty period in years):");
                String[] details = scanner.nextLine().split(",");
                item = new ElectronicsItem(
                        Integer.parseInt(details[0]),
                        Integer.parseInt(details[1]),
                        details[2],
                        details[3],
                        Double.parseDouble(details[4]),
                        Double.parseDouble(details[5])
                );
                items.put(item.getId(), item);
                break;
            case "fragile":
                System.out.println("Enter item details (id,quantity,name,description,weight,price,isbroken):");
                String[] fdetails = scanner.nextLine().split(",");
                boolean isFit = false;
                item = new FragileItem(
                        Integer.parseInt(fdetails[0]),
                        Integer.parseInt(fdetails[1]),
                        fdetails[2],
                        fdetails[3],
                        Double.parseDouble(fdetails[4]),
                        Double.parseDouble(fdetails[5]),
                        isFit = Boolean.parseBoolean(fdetails[6])
                );
                if(isFit){
                    unfitItems.put(item.getId(), item);

                }else{
                    items.put(item.getId(), item);
                }
                break;
            case "groceries":
                System.out.println("Enter item details (id,quantity,name,description,weight in kg,price per kg,ready for celling):");
                String[] groceries = scanner.nextLine().split(",");
                boolean isPerished = false;
                item = new GrocerieItem(
                        Integer.parseInt(groceries[0]),
                        Integer.parseInt(groceries[1]),
                        groceries[2],groceries[3],
                        Double.parseDouble(groceries[4]),
                        Double.parseDouble(groceries[5]),
                        isPerished = Boolean.parseBoolean(groceries[6])
                );
                if(isPerished){
                    unfitItems.put(item.getId(), item);

                }else{
                    items.put(item.getId(), item);
                }
                break;
            default:
                System.out.println("Invalid item type.");
                return;
        }
        db.itemUnfitForSale(unfitItems);
        db.create(items);
    }

    private static void listItems() {
        content.forEach(System.out::println);
    }

    private static void categorizeItems() {
        // This would involve more complex logic, such as sorting or filtering based on category
        System.out.println("Categorize items functionality not implemented yet.");
    }

    private static void processOrder() {
        System.out.println("Order processing functionality not implemented yet.");
    }

}
