
import controlador.Controller;
import modelo.RepositorioTareas;
import vista.Vista;

public class Main {

    public static void main(String[] args) {

        Controller controller = new controlador.Controller(RepositorioTareas.getInstance(), new Vista());
    
    }

}
