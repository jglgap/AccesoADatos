package controlador;

import java.util.ArrayList;

import modelo.RepositorioTareas;
import modelo.Tarea;
import vista.Vista;

/**
 * Clase Controller encargada de gestionar la lógica de la aplicación.
 * 
 * Funciona como intermediario entre la vista y el repositorio de tareas,
 * manejando los eventos de los botones y coordinando las operaciones
 * como agregar, eliminar, mostrar y marcar tareas como completadas.
 * 
 * Implementa el patrón MVC (Modelo - Vista - Controlador).
 */
public class Controller {

    /**
     * Repositorio que gestiona el almacenamiento y manipulación de las tareas.
     */
    private RepositorioTareas repo;

    /**
     * Vista gráfica donde se muestran los datos y se capturan las acciones del usuario.
     */
    private Vista vista;

    /**
     * Construye el controlador y configura los listeners de los botones.
     * 
     * @param repo Repositorio que contiene las tareas.
     * @param vista Interfaz gráfica del usuario.
     */
    public Controller(RepositorioTareas repo, Vista vista){
        this.repo = repo;
        this.vista = vista;
        vista.setVisible(true);
        mostrarTodos();
        mostrarTarea();
        agreagarTarea();
        eliminarTarea();
        marcarCompletada();
    }

    /**
     * Muestra todas las tareas existentes en el área de resultados de la vista
     * cuando se presiona el botón correspondiente.
     */
    public void mostrarTodos(){
        
        ArrayList<Tarea> tareas = repo.obtenerTodas();
        vista.getBtnMostrarTodas().addActionListener(e -> {
            StringBuilder sb = new StringBuilder();

            for (Tarea tarea : tareas) {
               sb.append(tarea).append("\n");
            }

            vista.getAreaResultado().setText(sb.toString());
        });
    }

    /**
     * Muestra una tarea específica según el ID ingresado por el usuario.
     */
    public void mostrarTarea(){
        vista.getBtnMostrarPorId().addActionListener(e ->{
           int id = Integer.parseInt(vista.showInput("Introduce el id"));
            vista.getAreaResultado().setText(repo.obtenerPorID(id).toString());
        });
    }

    /**
     * Permite agregar una nueva tarea solicitando los datos al usuario.
     * 
     * Si ya existe una tarea con el mismo ID, se mostrará un mensaje de error.
     */
    public void agreagarTarea(){
        vista.getBtnAgregar().addActionListener(e -> {
            int id  = Integer.parseInt(vista.showInput("Introduce el id"));
            String titulo = vista.showInput("Introduce titulo");
            String descripcion = vista.showInput("introduce descripcion");

            try {
                repo.agregarTarea(new Tarea(id, titulo, descripcion, false));
            } catch (Exception Exception) {
                vista.showError("ya exite una tarea con ese id");
            }

        });
    }

    /**
     * Elimina una tarea según el ID introducido por el usuario.
     * 
     * Muestra un mensaje de confirmación si la eliminación fue exitosa,
     * o un mensaje de error si la tarea no existe.
     */
    public void eliminarTarea(){
        vista.getBtnEliminar().addActionListener(e -> {
             int id = Integer.parseInt(vista.showInput("Introduce el id"));

             if (repo.eliminar(id)) {
                vista.showConfirmation("Se ha eliminado correctamente");
             } else {
                vista.showError("No se encuentra dicha tarea, no se puede eliminar");
             }
        });
    }

    /**
     * Marca una tarea como completada según el ID ingresado por el usuario.
     */
    public void marcarCompletada(){
        vista.getBtnCompletar().addActionListener(e -> {
             int id = Integer.parseInt(vista.showInput("Introduce el id"));
            repo.marcarCompletada(id);
        });
    }
}
