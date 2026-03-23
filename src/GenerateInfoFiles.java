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
        createProductsFile(10);
        createSalesManInfoFile(5);
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
    }

    /**
     * Crea un archivo con información de vendedores.
     * Formato: TipoDocumento;NúmeroDocumento;Nombres;Apellidos
     */
    public static void createSalesManInfoFile(int salesmanCount) {
        File file = new File("data/vendedores.txt");
        Random rand = new Random();

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (int i = 0; i < salesmanCount; i++) {
                String tipoDoc = TIPOS_DOC[rand.nextInt(TIPOS_DOC.length)];
                long numeroDoc = 1000000000L + (long) (rand.nextDouble() * 900000000L); // Genera un número de 10
                                                                                        // dígitos
                String nombre = NOMBRES[rand.nextInt(NOMBRES.length)];
                String apellido = APELLIDOS[rand.nextInt(APELLIDOS.length)];

                writer.println(tipoDoc + ";" + numeroDoc + ";" + nombre + ";" + apellido);
            }
            System.out.println("Archivo de información de vendedores creado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al crear archivo de vendedores: " + e.getMessage());
        }
    }

    // Método para crear las ventas de UN vendedor
    public static void createSalesMenFile(int randomSalesCount, String name, long id) {
        // Lógica pendiente...
    }

}