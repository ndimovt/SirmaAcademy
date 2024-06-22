package io.github.ndimovt.extengandinterfaces.inventory;

import io.github.ndimovt.extengandinterfaces.inventory.datahandling.DataBaseCRUD;
import io.github.ndimovt.extengandinterfaces.inventory.datahandling.SortOrder;
import io.github.ndimovt.extengandinterfaces.inventory.entities.ElectronicsItem;
import io.github.ndimovt.extengandinterfaces.inventory.entities.FragileItem;
import io.github.ndimovt.extengandinterfaces.inventory.entities.GrocerieItem;
import io.github.ndimovt.extengandinterfaces.inventory.entities.InventoryItem;
import io.github.ndimovt.extengandinterfaces.inventory.orderprocessing.OrderItem;

import java.util.*;

public class CLI {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, InventoryItem> items = new HashMap<>();
    private static Map<Integer, InventoryItem> unfitItems = new HashMap<>();
    private static Map<Integer, String> content = new HashMap<>();
    private static Map<Integer, Integer> available = new HashMap<>();
    private static DataBaseCRUD db = new DataBaseCRUD();

    public static void main(String[] args) {
        content = db.read();
        boolean running = true;

        while (running) {
            System.out.println("Choose an option: add, remove item, delete, list, categorize, order, save, load, exit");
            String choice = scanner.nextLine();

            switch (choice.toLowerCase()) {
                case "add":
                    addItem();
                    break;
                case "remove item":
                    System.out.println("Enter id of item you want to remove: ");
                    int id = scanner.nextInt();
                    db.removeItem(content, id);
                    break;
                case "delete":
                    System.out.println("Enter id of item you want to delete from database: ");
                    int deleteId = scanner.nextInt();
                    db.delete(deleteId);
                case "list":
                    listItems();
                    break;
                case "categorize":
                    categorizeItems();
                    break;
                case "order":
                    System.out.println("Please check quantities carefully! For finalize order enter final");
                    System.out.println("Enter money sum: ");
                    double test = 0;
                    double sum = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Enter product id: ");
                    String product = scanner.nextLine();
                    while(!product.equalsIgnoreCase("final")) {
                        System.out.println("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        double cost = processOrder(Integer.parseInt(product), quantity);
                        sum -= cost;
                        System.out.println("Enter next product id (or 'final' to finish): ");
                        scanner.nextLine();
                        product = scanner.nextLine();
                    }
                    System.out.println(sum);

                    break;
                case "save":
                    System.out.println("Enter id: ");
                    int cid = scanner.nextInt();
                    System.out.println("Enter new quantity: ");
                    int q = scanner.nextInt();
                    db.updateQuantity(cid, q, content);
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
                System.out.println("Enter item details (id,quantity,name,description,weight,price,ready for celling):");
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
                if(!isFit){
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
                if(!isPerished){
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
        content.forEach((k,v) -> System.out.println(v));
    }

    private static void categorizeItems() {
        SortOrder so = new SortOrder();
        System.out.println("Choose how you want to sort items by: category, name or price");
        String choice = scanner.nextLine();
        if(choice.equalsIgnoreCase("category")){
            String category = scanner.nextLine();
            Map<Integer, String> sortedByCat = so.byCategory(content, category);
            printMap(sortedByCat);
        } else if (choice.equalsIgnoreCase("name")) {
            Map<String, String> sortedByName = so.byName();
            printMap(sortedByName);
        } else if (choice.equalsIgnoreCase("price")) {
            Map<Double, String> sortedByPrice = so.byPrice();
            printMap(sortedByPrice);
        }else{
            System.out.println("Invalid sorting criteria!");
        }
    }

    private static double processOrder(int id, int quantity) {
        db.updateQuantity(id,quantity, content);
        if(content.containsKey(id)){
            String value = content.get(id);
            String[] arr = value.split("/");
            System.out.println(Double.parseDouble(arr[5]));
            return quantity * Double.parseDouble(arr[5]);
        }
        return 0.0;
    }
    private static void printMap(Map<? extends Object, String> map){
        map.forEach((k,v) -> System.out.println(v));
    }

}
