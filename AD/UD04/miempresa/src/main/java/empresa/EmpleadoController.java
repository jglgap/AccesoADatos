package empresa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.model.Filters;

public class EmpleadoController {

    private MongoProvider mongoProvider;

    

    public EmpleadoController(MongoProvider mongoProvider) {
        this.mongoProvider = mongoProvider;
    }



    public Empleados crearEmpleado(String nombre, int dep, int salario,String fechaAlta, String oficio, int comision){
        Empleados emp = new Empleados(nombre, dep, salario, fechaAlta, oficio, comision);
        Document documentEmp = new Document("nombre",emp.getNombre()).append("dep", emp.getDepartamento())
                                        .append("salario", emp.getSalario()).append("fechaAlta", emp.getFechaAlta());

        if (emp.getOficio() != null && !emp.getOficio().isBlank()) {
            documentEmp.append("oficio", emp.getOficio());
        }
        if (emp.getComision() != 0) {
            documentEmp.append("comision", emp.getComision());
        }
        mongoProvider.empleados().insertOne(documentEmp);
        return emp;
    }


    public void buscarEmpleados(List<Integer> departamentos, int salario, String oficio){
           List<Bson> filters = new ArrayList<>();

    // Department filter
    if (departamentos != null && departamentos.size() > 0) {
         
        filters.add(Filters.in("dep", departamentos));
    }

    // Salary filter
    if (salario > 0) {
        filters.add(Filters.gt("salario", salario));
    }

    // Job filter
    if (oficio != null && !oficio.isBlank()) {
        filters.add(Filters.eq("oficio", oficio));
    }

    if (filters.isEmpty()) {
        System.out.println("No filters provided");
        return;
    }

    Bson finalFilter = Filters.and(filters);

    mongoProvider.empleados()
        .find(finalFilter).into(new ArrayList<Document>())
        .forEach(System.out::println);
    }


}
