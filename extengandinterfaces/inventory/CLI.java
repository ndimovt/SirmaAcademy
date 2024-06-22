package io.github.ndimovt.extengandinterfaces.inventory;

import io.github.ndimovt.extengandinterfaces.inventory.datahandling.DataBaseCRUD;
import io.github.ndimovt.extengandinterfaces.inventory.datahandling.SortOrder;
import io.github.ndimovt.extengandinterfaces.inventory.entities.ElectronicsItem;
import io.github.ndimovt.extengandinterfaces.inventory.entities.FragileItem;
import io.github.ndimovt.extengandinterfaces.inventory.entities.GrocerieItem;
import io.github.ndimovt.extengandinterfaces.inventory.entities.InventoryItem;
import io.github.ndimovt.extengandinterfaces.inventory.orderprocessing.Order;
import io.github.ndimovt.extengandinterfaces.inventory.orderprocessing.OrderItem;
import io.github.ndimovt.extengandinterfaces.inventory.orderprocessing.PaymentMethods;

import java.util.*;

public class CLI {
    private static Order order = new Order();
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, InventoryItem> items = new HashMap<>();
    private static Map<Integer, InventoryItem> unfitItems = new HashMap<>();
    private static Map<Integer, String> content = new HashMap<>();
    private static Map<Integer, Integer> available = new HashMap<>();
    private static DataBaseCRUD db = new DataBaseCRUD();

    public static void main(String[] args) {
        content = db.read();
        boolean running = true;
        System.out.println("Enter payment option(cash, paypal, visa mastercard)");
        String method = scanner.nextLine();
        System.out.println("Enter money you want to spend: ");
        double sum = scanner.nextDouble();scanner.nextLine();
        while (running) {
            System.out.println("Choose an option: add, remove item, delete, list, categorize, order, save, check order, pay, exit");
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
                    OrderItem oi = null;
                    System.out.println("Please check quantities carefully! For finalize order enter 'final'");

                    String product;
                    int quantity = 0;
                    int productId = 0;
                    do {
                        System.out.println("Enter product id: ");
                        product = scanner.nextLine();

                        if (product.equalsIgnoreCase("final")) {
                            break;
                        }
                        try {
                            productId = Integer.parseInt(product);
                            System.out.println("Enter quantity: ");
                            quantity = scanner.nextInt();
                            scanner.nextLine(); // Consume newline left by nextInt()

                        } catch (NumberFormatException e) {
                            System.err.println("Invalid product id. Please enter a valid integer.");
                            scanner.nextLine(); // Consume newline to avoid infinite loop
                        }

                        if(method.equalsIgnoreCase("visa")) {
                            oi = new OrderItem(Integer.parseInt(product), quantity, PaymentMethods.VISA, processOrder(productId , quantity));
                            order.insertOrder(oi);
                        } else if (method.equalsIgnoreCase("cash")) {
                            oi = new OrderItem(Integer.parseInt(product), quantity, PaymentMethods.Cash, processOrder(productId , quantity));
                            order.insertOrder(oi);
                        } else if (method.equalsIgnoreCase("mastercard")) {
                            oi = new OrderItem(Integer.parseInt(product), quantity, PaymentMethods.MASTERCARD, processOrder(productId, quantity));
                            order.insertOrder(oi);
                        } else if (method.equalsIgnoreCase("paypal")) {
                            oi = new OrderItem(Integer.parseInt(product), quantity, PaymentMethods.PayPal, processOrder(productId , quantity));
                            order.insertOrder(oi);
                        }
                    } while (!product.equalsIgnoreCase("final"));
            break;
                case "save":
                    System.out.println("Enter id: ");
                    int cid = scanner.nextInt();
                    System.out.println("Enter new quantity: ");
                    int q = scanner.nextInt();
                    db.updateQuantity(cid, q, content);
                    break;
                case "check":
                    order.print();
                    break;
                case "pay":
                    if(sum - order.totalCost() >= 0){
                        System.out.println("Order successfully payed!");
                    }else{
                        System.out.println("Not enough money!");
                        System.exit(0);
                    }
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
            return quantity * Double.parseDouble(arr[5]);
        }
        return 0.0;
    }
    private static void printMap(Map<?, String> map){
        map.forEach((k,v) -> System.out.println(v));
    }
}
