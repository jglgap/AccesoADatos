package modelo;

/**
 * Representa una tarea con identificador, título, descripción y estado de completitud.
 * Esta clase se utiliza para modelar elementos dentro de una lista de tareas.
 */
public class Tarea {

    /** Identificador único de la tarea. */
    private int id;

    /** Título de la tarea. */
    private String titulo;

    /** Descripción detallada de la tarea. */
    private String descripcion;

    /** Indica si la tarea está completada. */
    private boolean completada;

    /**
     * Crea una nueva instancia de {@code Tarea}.
     *
     * @param id el identificador único de la tarea
     * @param titulo el título de la tarea
     * @param descripcion la descripción de la tarea
     * @param completada indica si la tarea ya está completada
     */
    public Tarea(int id, String titulo, String descripcion, boolean completada) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = completada;
    }

    /**
     * Obtiene el identificador de la tarea.
     *
     * @return el id de la tarea
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el título de la tarea.
     *
     * @return el título de la tarea
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene la descripción de la tarea.
     *
     * @return la descripción de la tarea
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la tarea.
     *
     * @param descripcion la nueva descripción de la tarea
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Establece el identificador de la tarea.
     *
     * @param id el nuevo id de la tarea
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece el título de la tarea.
     *
     * @param titulo el nuevo título de la tarea
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Marca la tarea como completada o no completada.
     *
     * @param completada {@code true} si la tarea está completada; {@code false} en caso contrario
     */
    public void setCompletada(boolean completada) {
        this.completada = completada;
    }


    @Override
    public String toString() {
        if (completada == true) {
            return "Id: " + this.getId() + " titulo: " +this.getTitulo() + " descripcion: " + this.getDescripcion() + " completada: " + "si";
            
        }else{
            return "Id: " + this.getId() + " titulo: " +this.getTitulo() + " descripcion: " + this.getDescripcion() + " completada: " + "no";
        }

    }
}
