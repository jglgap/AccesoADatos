package Ej2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {
public static void main(String[] args) {
    ClasificaDirectorio cd = new ClasificaDirectorio();
    try {
        cd.segunExtension("archivos");
    } catch (IOException e) {
        
        System.out.println(e.getMessage());
    }
}
}
