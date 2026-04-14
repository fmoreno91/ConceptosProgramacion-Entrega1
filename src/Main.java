import java.io.*;
import java.util.*;

public class Main {
    // Corrected: Added 'final' as it's initialized once
    private static final Map<String, Integer> productPrices = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("--- Starting Preliminary Sales Processing ---");
        
        // 1. Load products into memory
        loadProducts();

        // 2. Process sales files (Preliminary logic)
        processAllSales();

        System.out.println("--- Preliminary Processing Finished ---");
    }

    private static void loadProducts() {
        File file = new File("data/products_info.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(";");
                if (data.length == 3) {
                    // Corrected: Simplified parsing to avoid unnecessary temporary conversion
                    productPrices.put(data[0], Integer.valueOf(data[2]));
                }
            }
            System.out.println("Loaded " + productPrices.size() + " products.");
        } catch (FileNotFoundException e) {
            System.err.println("Error: products_info.txt not found.");
        }
    }

    private static void processAllSales() {
        File folder = new File("data");
        File[] files = folder.listFiles((dir, name) -> name.startsWith("sales_") && name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("No sales files found to process.");
            return;
        }

        for (File file : files) {
            System.out.println("Processing: " + file.getName());
            // Preliminary logic for Milestone 2
        }
    }
}