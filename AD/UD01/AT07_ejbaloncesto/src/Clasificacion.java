import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Clasificacion implements Serializable {

    private Equipo[] equipos;
    private int contador;

    // constructor con array de 18 equipos
    public Clasificacion() {
        this.equipos = new Equipo[18];
        this.contador = 0;
    }

    // constructor con array de x equipos
    public Clasificacion(int numeroDeEquipos) {
        this.equipos = new Equipo[numeroDeEquipos];
        this.contador = 0;

    }

    // metodo para añadir equipo al array
    public void addEquipo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del equipo:");
        String nombre = sc.nextLine();
        System.out.println("Introduce el numero de victorias:");
        int victorias = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce el numero de derrotas:");
        int derrotas = Integer.parseInt(sc.nextLine());
        Equipo nuevoEquipo = new Equipo(nombre, victorias, derrotas);

        if (this.contador < this.equipos.length) {
            this.equipos[this.contador] = nuevoEquipo;
            this.contador++;
            System.out.println("Equipo añadido correctamente");
        } else {
            System.out.println("No se a podido añadir al equipo");
        }
    }

    public static void loadClasificacion() throws ClassNotFoundException, FileNotFoundException, IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("clasificacion.dat"))) {
            TreeSet<Equipo> treeEquipos;
            while ((treeEquipos = (TreeSet<Equipo>) in.readObject()) != null) {
                for (Equipo equipo : treeEquipos) {
                    System.out.println(equipo);
                }
            }

        } catch (EOFException e) {
           System.out.println("No ha sido posible realizar el proceso");
        }
    }

    public static void saveClasificacion(Equipo[] equipos) {

        try (FileOutputStream stream = new FileOutputStream("clasificacion.dat");
                ObjectOutputStream out = new ObjectOutputStream(stream)) {
            TreeSet<Equipo> treeEquipos = new TreeSet<Equipo>(Arrays.asList(equipos));
            
            out.writeObject(treeEquipos);
            out.flush();
        } catch (IOException e) {
            System.out.println("Hubo problemas en la creacion del fichero");
        }
    }


    @Override
    public String toString() {
        Equipo[] copia = this.equipos.clone();

        // Ordenar con un comparador que pone nulls al final
        Arrays.sort(copia, Comparator.nullsLast(Comparator.naturalOrder()));

        return Arrays.toString(copia);
    }

    public Equipo[] getEquipos() {
        return equipos;
    }

}
