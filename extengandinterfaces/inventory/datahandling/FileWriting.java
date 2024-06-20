package io.github.ndimovt.extengandinterfaces.inventory.datahandling;

import io.github.ndimovt.extengandinterfaces.inventory.entities.InventoryItem;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileWriting{
    private File forSale = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\extengandinterfaces\\inventory\\storage\\storage.txt");

    private File unfit = new File("C:\\Users\\Nikolai\\IdeaProjects\\SirmaAcademy\\src\\main\\java\\io\\github\\ndimovt\\extengandinterfaces\\inventory\\storage\\unfitForSale.txt");
    // Save inventory to a file
    public void saveInventory(Map<Integer, String> items) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(forSale))) {
            items.forEach((id,item) -> {
                pw.print(id);
                pw.print(item);
                pw.println();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load inventory from a file
    public Map<Integer, String> loadInventory() {
        Map<Integer, String> items = new HashMap<>();
        if (!forSale.exists()) return items;

        try (BufferedReader br = new BufferedReader(new FileReader(forSale))) {
            String line;
            while ((line = br.readLine()) != null) {
                String [] id = line.split(" ");
                int i = Integer.parseInt(id[0]);
                items.put(i, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }
    public void unfitForSale(InventoryItem item){
        try(PrintWriter pr = new PrintWriter(unfit)){
            pr.write(item.getDetails());
            pr.flush();
        }catch (FileNotFoundException fnf){
            fnf.printStackTrace();
        }
    }
}
