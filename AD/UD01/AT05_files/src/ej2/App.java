package ej2;

public class App {
public static void main(String[] args) {
    Persona p1 = new Persona("k", 2, "veneco");
    Persona p2 = new Persona("l", 3, "veneco");

    ManejoFichero mf = new ManejoFichero();


    try {
        mf.almacenar(p1,p2);
        mf.leerFichero();

    } catch (Exception e) {
        e.printStackTrace();

    }
    
}
}
