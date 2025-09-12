import java.util.Scanner;
public class primerEjercicio {

    //punto uno 

    //mostrar mensaje introducido por teclado
    public String segundo() {
        //inicializacion del scanner
        Scanner teclado = new Scanner(System.in);
        //recogida del valor
        String value = teclado.nextLine();
        return value;
    }

    //mostrar un valor literal
    public String tercero(String str){
        return str;
    }
    //mostrar el valor de una variable
    public String cuarto(String str){
        return str;
    }

    //punto dos

    //recoger dos valores de numeros decimales, convertir a entero y devolver el resto de la division
    public int division(float primero, float segundo) {
        //convertir decimal a entero 
        int primerEntero = (int) Math.floor(primero);
        int segundoEntero = (int) Math.floor(segundo);
        System.out.println("primero = " + primerEntero);
        System.out.println("segundo = "+ segundoEntero);
        System.out.println("Resultado de la divisio");
        
        //devolver el resto 
        return primerEntero / segundoEntero;
    }

    //punto tres

    public boolean encontrarCaracter(String cadena, String caracter){
       int find = cadena.indexOf(caracter);
       if (find > -1 ) {
           System.out.println("si hay coincidencia");
           return true;
        }else{
           System.out.println("no hay coincidencia");
        return false;
       }
    }

    //punto cuatro
    public void suma(double primer, double segundo) {
        System.out.println("suma de = " + primer + " + " + segundo);
        double total = primer + segundo;
        System.out.println("El total es = " + total);
        int parteEntera = (int) Math.floor(total);
        System.out.println("La parte entera del resultado es = "  + parteEntera);
        System.out.println("la parte decimal es = " + (total - parteEntera));
    }



    public static void main(String[] args) {
        

        primerEjercicio p = new primerEjercicio();
        System.out.println("segundo metodo");
        System.out.println("Este es el texto recogido por teclado = " + p.segundo());

        System.out.println("tercer metodo");
        System.out.println("el texto literal recogido en el parametro es = "  + p.tercero("texto literal"));


        System.out.println("cuarto metodo");
        String texto = "este es el texto";
        System.out.println("el texto definido en una variable es = " + p.cuarto(texto));

        System.out.println("segundo ejercicio" );
        System.out.println( p.division(14.5f, 2.3f));


        System.out.println("tercer ejercicio");
        p.encontrarCaracter("sadasd", "asd");

        System.out.println("cuarto ejercicio");
        p.suma(13.2, 13.3);

    }
}
