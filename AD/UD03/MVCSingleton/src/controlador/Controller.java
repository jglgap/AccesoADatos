package controlador;

import java.util.ArrayList;

import modelo.RepositorioTareas;
import modelo.Tarea;
import vista.Vista;

public class Controller {

    private RepositorioTareas repo;
    private Vista vista;


    public Controller(RepositorioTareas repo, Vista vista){
        this.repo = repo;
        this.vista = vista;
        vista.setVisible(true);
        mostrarTodos();
        mostrarTarea();
        agreagarTarea();
    }

    public void mostrarTodos(){
        
        ArrayList<Tarea> tareas = repo.obtenerTodas();
        vista.getBtnMostrarTodas().addActionListener(e -> {
            StringBuilder sb = new StringBuilder();

            for (Tarea tarea : tareas) {
               sb.append(tarea).append("\n");
            }

            vista.getAreaResultado().setText(sb.toString());
        } );
    }

    public void mostrarTarea(){
        vista.getBtnMostrarPorId().addActionListener(e ->{
           int id = Integer.parseInt( vista.showInput("Introduce el id")) ;
            vista.getAreaResultado().setText(repo.obtenerPorID(id).toString());
        });
    }


    public void agreagarTarea(){
        vista.getBtnAgregar().addActionListener(e -> {
            
            
        });
    }

}
