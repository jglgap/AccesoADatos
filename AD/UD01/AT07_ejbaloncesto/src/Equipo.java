import java.io.Serializable;

public class Equipo implements Serializable, Comparable<Equipo>{

    private String nombre;
    private int victorias;
    private int derrotas;
    private int puntosAFavor;
    private int puntosEnContra;

    // Constructor con solo el nombre
    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    // Constructor con todas las variables
    public Equipo(String nombre, int victorias, int derrotas) {
        this.nombre = nombre;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.puntosAFavor = this.victorias * 2;
        this.puntosEnContra = this.derrotas * 1;
    }


    public int getPartidosJugados(){
        return this.victorias + this.derrotas;
    }

    public int getPuntos(){
        return this.puntosAFavor + this.puntosEnContra;
    }


    @Override
    public String toString() {
        return this.nombre + ", victorias: " + this.victorias + ", derrotas: " + this.derrotas + ", puntos totales: " + this.getPuntos();

    }

    @Override
    public int compareTo(Equipo otro) {
        //Arrays.sort(equipos, Comparator.nullsLast(Comparator.naturalOrder()));
        
       return Integer.compare(otro.getPuntos(), this.getPuntos());
    }
 




}
