import java.io.*;
import java.util.*;

/**
 * Class responsible for generating pseudo-random data files for the project.
 * Includes products, salesman info, and individual sales files.
 */
public class GenerateInfoFiles {

    // --- DATA SEEDS ---
    private static final String[] FIRST_NAMES = { "Felipe", "Claudia", "Juan", "Elena", "Diego", "Andres", "Rosa", "Luis" };
    private static final String[] LAST_NAMES = { "Moreno", "Gomez", "Rodriguez", "Perez", "Sanchez", "Lopez", "Ruiz" };
    private static final String[] PRODUCT_NAMES = { "Laptop", "Mouse", "Keyboard", "Monitor", "Camera", "USB", "Headphones" };
    private static final String[] DOC_TYPES = { "CC", "CE", "TI" };

    public static void main(String[] args) {
        // Execute the generation of all necessary files
        createProductsFile(10);
        createSalesManInfoFile(5);
    }

    /**
     * Creates a file with pseudo-random product information.
     * Format: ProductID;ProductName;PricePerUnit
     */
    public static void createProductsFile(int productsCount) {
        File file = new File("data/products_info.txt");
        Random rand = new Random();

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (int i = 1; i <= productsCount; i++) {
                String id = "PROD" + i;
                String name = PRODUCT_NAMES[rand.nextInt(PRODUCT_NAMES.length)];
                int price = 10000 + rand.nextInt(90000);

                writer.println(id + ";" + name + ";" + price);
            }
            System.out.println("Products file created successfully.");
        } catch (IOException e) {
            System.err.println("Error creating products file: " + e.getMessage());
        }
    }

    /**
     * Creates a file with salesman information and triggers individual sales files.
     * Format: DocumentType;DocumentNumber;FirstNames;LastNames
     */
    public static void createSalesManInfoFile(int salesmanCount) {
        File file = new File("data/salesmen_info.txt");
        Random rand = new Random();

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (int i = 0; i < salesmanCount; i++) {
                String docType = DOC_TYPES[rand.nextInt(DOC_TYPES.length)];
                long docNumber = 1000000000L + (long) (rand.nextDouble() * 900000000L);
                String firstName = FIRST_NAMES[rand.nextInt(FIRST_NAMES.length)];
                String lastName = LAST_NAMES[rand.nextInt(LAST_NAMES.length)];

                // 1. Save salesman to the master information file
                writer.println(docType + ";" + docNumber + ";" + firstName + ";" + lastName);

                // 2. Generate an individual sales file for this specific salesman
                int randomSalesCount = 3 + rand.nextInt(6);
                createSalesMenFile(randomSalesCount, docType, docNumber);
            }
            System.out.println("Full process for salesmen and sales files completed.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Creates a sales report file for a specific salesman.
     * Line 1: DocumentType;DocumentNumber
     * Following lines: ProductID;QuantitySold
     */
    public static void createSalesMenFile(int randomSalesCount, String docType, long id) {
        // File name includes the ID to ensure it is unique
        File file = new File("data/sales_" + id + ".txt");
        Random rand = new Random();

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            // First line: Salesman identification
            writer.println(docType + ";" + id);

            // Generate 'randomSalesCount' of random sales entries
            for (int i = 0; i < randomSalesCount; i++) {
                int randomProductId = 1 + rand.nextInt(10); 
                int quantity = 1 + rand.nextInt(20);

                writer.println("PROD" + randomProductId + ";" + quantity);
            }
            System.out.println("Sales file for ID " + id + " created.");
        } catch (IOException e) {
            System.err.println("Error creating sales file for salesman " + id + ": " + e.getMessage());
        }
    }
}