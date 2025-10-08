import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class Clasificacion implements Serializable{
    
    private Equipo[] equipos;
    private int contador;

    //constructor con array de 18 equipos
    public Clasificacion(){
        this.equipos = new Equipo[18];
        this.contador = 0;
    }

    //constructor con array de x equipos
    public Clasificacion(int numeroDeEquipos){
        this.equipos = new Equipo[numeroDeEquipos];
        this.contador = 0;

    }

    public void ordenarArray(){
        Arrays.sort(equipos);
    }

    //metodo para añadir equipo al array
    public void addEquipo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del equipo:");
        String nombre = sc.nextLine();
        System.out.println("Introduce el numero de victorias:");
        int victorias = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce el numero de derrotas:");
        int derrotas = Integer.parseInt(sc.nextLine());
        Equipo nuevoEquipo = new Equipo(nombre,victorias,derrotas);
        
        if(this.contador < this.equipos.length) {
            this.equipos[this.contador] = nuevoEquipo;
            this.contador ++;
            System.out.println("Equipo añadido correctamente");
        }else{
            System.out.println("No se a podido añadir al equipo");
        }
    }


    public static void loadClasificacion(){

    }

    public static void saveClasificacion(){

    }


    @Override
    public String toString() {
        this.ordenarArray();
        return Arrays.toString(equipos);
    }


}
