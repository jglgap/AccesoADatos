package ej2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ManejoFichero {

       public void almacenar(Persona ...p) throws IOException{
            FileOutputStream fichero = new FileOutputStream("personas.bin");
            ObjectOutputStream out = new ObjectOutputStream(fichero);


            out.writeObject(p);
            out.flush();
            out.close();

        }

        public void leerFichero() throws IOException, ClassNotFoundException{
            try {
            FileInputStream fichero = new FileInputStream("personas.bin");
            ObjectInputStream in = new ObjectInputStream(fichero);
            Persona[] p;
            while ((p = (Persona[]) in.readObject()) !=  null) {
                for (int i = 0; i < p.length; i++) {
                    System.out.println(p[i].toString());
                }
                
            }
            } catch (EOFException e) {
               System.out.println("Final de fichero");
            }
          



        }

}
