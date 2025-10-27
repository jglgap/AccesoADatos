import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.Gson;

public class GestorProductos {
    
    private static final String nombreFichero = "productos.json";

    public static void guardarProductos(ArrayList<Producto> productos) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(nombreFichero)) {
            gson.toJson(productos, writer);
            System.out.println("Archivo " + nombreFichero + " guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    
    public static void mostrarProductos() {
        try (FileReader reader = new FileReader(nombreFichero)) {
            int caracter;
            while ((caracter = reader.read()) != -1) {
                System.out.print((char) caracter);
            }
           
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    
    public static ArrayList<Producto> cargarProductos() {
        Gson gson = new Gson();
        ArrayList<Producto> productos = new ArrayList<>();
        try (FileReader reader = new FileReader(nombreFichero)) {
            Producto[] productosArray = gson.fromJson(reader, Producto[].class);
            if (productosArray != null) {
                productos.addAll(Arrays.asList(productosArray));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar productos: " + e.getMessage());
        }
        return productos;
    }
    
}
