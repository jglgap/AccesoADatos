package empresa;



import org.bson.Document;

public class Main {
public static void main(String[] args) {
    
    try (MongoProvider mgp = new MongoProvider()) {
        EmpleadoController empleadoController = new EmpleadoController(mgp);
        // empleadoController.crearEmpleado("Juan", 10, 1000, "10/10/1999", null, 0);
        // empleadoController.crearEmpleado("Alicia", 10, 1400, "07/08/2000", "profesor", 0);
        // empleadoController.crearEmpleado("Maria Jesus", 20, 1500, "05/01/2005", "analista", 100);
        // empleadoController.crearEmpleado("Alberto", 20, 1100, "15/11/2001", null, 0);
        // empleadoController.crearEmpleado("Fernando", 30, 1400, "20/11/1999", "analista", 200);
        empleadoController.buscarEmpleados(new int[]{}, 1300, "profesor");

    
    } catch (Exception e) {
        System.out.println("Error conexion " + e.getMessage());
    }
    
    
 
}
}
