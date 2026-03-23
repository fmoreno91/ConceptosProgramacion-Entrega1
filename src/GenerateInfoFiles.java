import java.io.*;
import java.util.*;

public class GenerateInfoFiles {

    // --- SEMILLAS DE DATOS ---
    private static final String[] NOMBRES = { "Felipe", "Claudia", "Juan", "Elena", "Diego", "Andres", "Rosa", "Luis" };
    private static final String[] APELLIDOS = { "Moreno", "Gomez", "Rodriguez", "Perez", "Sanchez", "Lopez", "Ruiz" };
    private static final String[] PRODUCTOS_NOMBRES = { "Laptop", "Mouse", "Teclado", "Monitor", "Cámara", "USB",
            "Audifonos" };
    private static final String[] TIPOS_DOC = { "CC", "CE", "TI" };

    public static void main(String[] args) {
        // Por ahora probaremos solo el de productos
        createProductsFile(10);
    }

    /**
     * Crea un archivo con información pseudoaleatoria de productos.
     * Formato: IDProducto;NombreProducto;PrecioPorUnidad
     */
    public static void createProductsFile(int productsCount) {
        File file = new File("data/productos.txt");
        Random rand = new Random();

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (int i = 1; i <= productsCount; i++) {
                String id = "PROD" + i;
                String nombre = PRODUCTOS_NOMBRES[rand.nextInt(PRODUCTOS_NOMBRES.length)];
                int precio = 10000 + rand.nextInt(90000);

                writer.println(id + ";" + nombre + ";" + precio);
            }
            System.out.println("Archivo de productos creado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al crear archivo de productos: " + e.getMessage());
        }
    } // <-- Esta llave cierra el MÉTODO

    // Método para crear la info de los vendedores
    public static void createSalesManInfoFile(int salesmanCount) {
        // Lógica pendiente...
    }

    // Método para crear las ventas de UN vendedor
    public static void createSalesMenFile(int randomSalesCount, String name, long id) {
        // Lógica pendiente...
    }

}