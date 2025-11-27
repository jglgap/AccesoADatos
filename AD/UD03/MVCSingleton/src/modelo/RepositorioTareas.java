package modelo;

import java.util.ArrayList;

/**
 * Repositorio de tareas que implementa el patrón Singleton.
 * <p>
 * Permite almacenar, consultar, eliminar y modificar tareas.  
 * Mantiene una única instancia a lo largo de la aplicación.
 * </p>
 */
public class RepositorioTareas {

   

    /** Lista que almacena las tareas del repositorio. */
    private ArrayList<Tarea> tareas ;
    

    /** Instancia única del repositorio (Singleton). */
    private static RepositorioTareas instance;

    /**
     * Constructor privado para implementar el patrón Singleton.
     */
    private RepositorioTareas() {

        this.tareas = new ArrayList<>();
        tareas.add(new Tarea(1, "tarea 1", "esta es la primera tarea", false));
        tareas.add(new Tarea(2, "tarea 2", "esta es la segunda tarea", true));

    }

    /**
     * Devuelve la instancia única del repositorio.
     * Si aún no existe, la crea.
     *
     * @return instancia única de {@code RepositorioTareas}
     */
    public synchronized static RepositorioTareas getInstance() {
        if (instance == null) {
            instance = new RepositorioTareas();
        }
        return instance;
    }

    /**
     * Devuelve todas las tareas almacenadas en el repositorio.
     *
     * @return {@code ArrayList} con todas las tareas
     */
    public ArrayList<Tarea> obtenerTodas() {
        return this.tareas;
    }

    /**
     * Busca y devuelve una tarea por su identificador.
     *
     * @param id identificador de la tarea a buscar
     * @return la tarea con el ID indicado, o {@code null} si no se encuentra
     */
    public Tarea obtenerPorID(int id) {
        Tarea tareaEncontrada = null;
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                tareaEncontrada = tarea;
            }
        }
        return tareaEncontrada;
    }

    /**
     * Agrega una nueva tarea al repositorio.
     * <p>
     * Si ya existe una tarea con el mismo ID, muestra un mensaje en consola.
     * </p>
     *
     * @param nuevaTarea la tarea que se desea agregar
     * @throws Exception 
     */
    public void agregarTarea(Tarea nuevaTarea) throws Exception {
        Boolean flag = false;
        for (Tarea tarea : tareas) {
            if (tarea.getId() == nuevaTarea.getId()) {
                flag = true;
            }
        }

        if (flag != true){

            this.tareas.add(nuevaTarea);    
        }
        else{

            throw new Exception("Ya hay una con ese id");
        }

                 
    }

    /**
     * Elimina una tarea del repositorio por su identificador.
     *
     * @param id identificador de la tarea a eliminar
     * @return {@code true} si se eliminó la tarea; {@code false} si no se encontró
     */
    public boolean eliminar(int id) {
        boolean eliminado = false;

        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                tareas.remove(tarea);
                eliminado = true;
            }
        }

        return eliminado;
    }

    /**
     * Marca como completada la tarea con el ID indicado.
     *
     * @param id identificador de la tarea a marcar como completada
     */
    public void marcarCompletada(int id) {
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                tarea.setCompletada(true);
            }
        }
    }

} 
