import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {

    HashMap<Integer, Trabajador> trabajadores = new HashMap<Integer, Trabajador>();
    ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

    public static void main(String[] args) throws Exception {

        App app = new App();

        Scanner sc = new Scanner(System.in);
        
        Trabajador t1 = new Trabajador("Antonio", 1400.54);
        Trabajador t2 = new Trabajador("Marcos", 1200.54);
        Trabajador t3 = new Trabajador("Fernando", 855.54);
        app.trabajadores.put(1, t1);
        app.trabajadores.put(2, t2);
        app.trabajadores.put(3, t3);
        
        Alumno a1 = new Alumno("Fernando", 16, 1.68);
        Alumno a2 = new Alumno("Carlos", 19, 1.85);
        Alumno a3 = new Alumno("Axel", 23, 1.73);
        Alumno a4 = new Alumno("Gerardo", 14, 1.67);
        Alumno a5 = new Alumno("Dario", 21, 1.55);
        app.alumnos.add(a1);
        app.alumnos.add(a2);
        app.alumnos.add(a3);
        app.alumnos.add(a4);
        app.alumnos.add(a5);
        
        int numero = 0;
        while (numero != 4) {
            System.out.println("menu");
            System.out.println("1-Aumentar sueldo a trabajador \n 2-Alumnos mayores de edad \n 3-Alumnos mas altos de 1.75");
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    System.out.println("Trabajadores: ");
                    for (Integer i : app.trabajadores.keySet()) {
                        System.out.println(
                                "Clave del trabajador : " + i + " con nombre : " + app.trabajadores.get(i).getName()
                                        + " y sueldo es : " + app.trabajadores.get(i).getSalary());
                    }
                    System.out.println("Introduce el identificador del trabajador al que deseas aumentar el sueldo");
                    int id = Integer.parseInt(sc.nextLine());
                    app.trabajadores.get(id).incrementSalary();
                    System.out.println("El nuevo Salario del trabajador es = " + app.trabajadores.get(id).getSalary());
                    option = 0;
                    break;

                case 2:
                    int mayoresDeEdad = 0;
                    for (int i = 0; i < 5; i++) {
                        System.out.println(app.alumnos.get(i).getName() + " edad = " + app.alumnos.get(i).getAge());
                        if (app.alumnos.get(i).getAge() >= 18) {
                            mayoresDeEdad++;
                        }
                    }
                    System.out.println("El numero de alumnos mayores de 18 es " + mayoresDeEdad);
                    option = 0;
                    break;

                case 3:
                    int number = 0;
                    int estaturaSuperior = 0;
                    while (number < 4 && number < app.alumnos.size()) {
                        System.out.println(app.alumnos.get(number));
                        number++;

                        if (app.alumnos.get(number).getHeight() > 1.75) {
                            estaturaSuperior++;
                        }
                    }
                    System.out.println("El numero de alumnos con altura superior a 1.75 es = " + estaturaSuperior);
                    option = 0;
                    break;
                case 4: 
                    numero = 4;
                    break;
                default:
                    break;
            }

        }

    }
}
