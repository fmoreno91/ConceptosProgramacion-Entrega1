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
                long numeroDoc = 1000000000L + (long) (rand.nextDouble() * 900000000L);
                String nombre = NOMBRES[rand.nextInt(NOMBRES.length)];
                String apellido = APELLIDOS[rand.nextInt(APELLIDOS.length)];

                // 1. Guardamos al vendedor en el archivo maestro
                writer.println(tipoDoc + ";" + numeroDoc + ";" + nombre + ";" + apellido);

                // 2. Le creamos su propio archivo de ventas (ej. entre 3 y 8 ventas)
                int ventasAleatorias = 3 + rand.nextInt(6);
                createSalesMenFile(ventasAleatorias, tipoDoc, numeroDoc);
            }
            System.out.println("Proceso completo de vendedores y ventas finalizado.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Crea un archivo de ventas para un vendedor específico.
     * Formato línea 1: TipoDocumento;NúmeroDocumento
     * Formato líneas siguientes: IDProducto;CantidadVendido
     */
    public static void createSalesMenFile(int randomSalesCount, String tipoDoc, long id) {
        // El nombre del archivo incluye el ID para que sea único
        File file = new File("data/ventas_" + id + ".txt");
        Random rand = new Random();

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            // Primera línea requerida: Info del vendedor
            writer.println(tipoDoc + ";" + id);

            // Generamos 'randomSalesCount' cantidad de ventas aleatorias
            for (int i = 0; i < randomSalesCount; i++) {
                int idProductoAleatorio = 1 + rand.nextInt(10); // Asumiendo que creamos 10 productos
                int cantidad = 1 + rand.nextInt(20); // Cantidad entre 1 y 20

                writer.println("PROD" + idProductoAleatorio + ";" + cantidad);
            }
            System.out.println("Archivo de ventas para el ID " + id + " creado.");
        } catch (IOException e) {
            System.err.println("Error al crear ventas del vendedor " + id + ": " + e.getMessage());
        }
    }

}