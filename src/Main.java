import java.io.*;
import java.util.*;

public class Main {
    // Corrección 1 y 2: Se agregó 'final' porque las colecciones no se reasignan
    private static final Map<String, Integer> productPrices = new HashMap<>();
    private static final List<Salesman> salesmenList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            loadProducts();
            loadSalesmen();
            processSales();
            generateFinalReport();
            System.out.println("Final report generated successfully.");
        } catch (IOException | NumberFormatException e) { 
            // Corrección 3: Reemplazado Exception genérica por multicatch específico
            System.err.println("An error occurred during processing: " + e.getMessage());
        }
    }

    private static void loadProducts() throws IOException {
        File file = new File("data/products_info.txt");
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(";");
                // Corrección 4: Se optimizó Integer.parseInt eliminando temporales innecesarios
                productPrices.put(data[0], Integer.valueOf(data[2]));
            }
        }
    }

    private static void loadSalesmen() throws IOException {
        File file = new File("data/salesmen_info.txt");
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(";");
                salesmenList.add(new Salesman(data[0], Long.parseLong(data[1]), data[2], data[3]));
            }
        }
    }

    private static void processSales() {
        for (Salesman s : salesmenList) {
            File file = new File("data/sales_" + s.id + ".txt");
            if (file.exists()) {
                try (Scanner sc = new Scanner(file)) {
                    sc.nextLine(); // Skip header
                    while (sc.hasNextLine()) {
                        String[] data = sc.nextLine().split(";");
                        int price = productPrices.getOrDefault(data[0], 0);
                        int quantity = Integer.parseInt(data[1]);
                        s.totalSales += (long) price * quantity;
                    }
                } catch (IOException e) {
                    System.err.println("Error reading sales for ID: " + s.id);
                }
            }
        }
        salesmenList.sort((s1, s2) -> Long.compare(s2.totalSales, s1.totalSales));
    }

    private static void generateFinalReport() throws IOException {
        File file = new File("data/final_report.txt");
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.println("--- FINAL SALES REPORT ---");
            writer.println("Name;ID;TotalCollected");
            for (Salesman s : salesmenList) {
                writer.println(s.firstName + " " + s.lastName + ";" + s.id + ";" + s.totalSales);
            }
        }
    }

    static class Salesman {
        String firstName, lastName; // Corrección 5: Se eliminó docType porque nunca se usaba
        long id, totalSales = 0;

        Salesman(String docType, long id, String firstName, String lastName) {
            // docType se recibe pero no se guarda para evitar la advertencia de "never read"
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }
}