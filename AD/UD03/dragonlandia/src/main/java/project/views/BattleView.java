package project.views;

import java.util.Scanner;

import project.models.Mago;
import project.models.Monstruo;
import project.models.TipoMonstruo;

public class BattleView {

    

    public BattleView() {
    }


    Scanner sc = new Scanner(System.in);

    public Mago getValoresmago(){

        try {
            System.out.println("Nombre del mago");
            String nombreMago = sc.nextLine();
            System.out.println("Vida del mago");
            int vidaMago = Integer.parseInt(sc.nextLine());
            System.out.println("Nivel de magia");
            int nivelMagiaMago = Integer.parseInt(sc.nextLine());
            return new Mago(nombreMago,vidaMago,nivelMagiaMago);
        } catch (Exception e) {
            return null; 
       }
        
    }


    public Monstruo getValoresMonstruo(){
        try {
            System.out.println("Nombre del monstruo");
            String nombreMonstruo = sc.nextLine();
            System.out.println("Vida del monstruo");
            int vida = Integer.parseInt(sc.nextLine());
            System.out.println("Elige el tipo");
            System.out.println("1-Ogro   2-Troll    3-Espectro");
            TipoMonstruo tipo = null;
            int opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    tipo = TipoMonstruo.OGRO;
                    break;
                case 2:
                    tipo = TipoMonstruo.TROLL;
                    break;
                case 3:
                    tipo = TipoMonstruo.ESPECTRO;
                default:
                    break;
            }
            System.out.println("Fuerza del monstruo");
            int fuerza = Integer.parseInt(sc.nextLine());
            return new Monstruo(nombreMonstruo,vida,tipo,fuerza);

        } catch (Exception e) {
            System.out.println("Problemas creando el monstruo " + e.getMessage());
            return null;
        }
    }


}
