import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.Gson;

public class GestorProductos {
    
    ArrayList <Producto> listaProductos = new ArrayList<>();
    
    public void almacenar(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder = gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        JsonArray jsonArray = new JsonArray();
        for (Producto p : this.listaProductos) {
            jsonArray.add(gson.toJsonTree(p));
        }
        JsonObject jObject = new JsonObject();
        jObject.add("Productos",jsonArray);
        try (FileWriter writer = new FileWriter("producto.json")) {
            gson.toJson(jObject,writer);
        } catch (IOException e) {
            System.out.println("Problemas a la hora de crear el fichero");
        }

    }

    public void leerJson(){
        Gson gson = new Gson();

        try (FileReader fr = new FileReader("producto.json")) {
            


        } catch (Exception e) {
            System.out.println("problemas al leer");
        }
    }
    
}
