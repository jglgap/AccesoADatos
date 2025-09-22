import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ManejoFicheros {

    public void crearFichero(String ruta) throws IOException {
        File fichero = new File(ruta);
        fichero.createNewFile();
        System.out.println("El fichero ha sido creado con exito");

    }

    public void borrarFichero(String ruta) throws FileNotFoundException {
        File fichero = new File(ruta);
        if (fichero.exists()) {
            fichero.delete();
            System.out.println("El fichero ha sido borrado con exito");
        } else {
            throw new FileNotFoundException("No se encuentra el fichero");
        }
    }

    public void crearDirectorio(String ruta) throws IOException {
        File directorio = new File(ruta);
        directorio.mkdir();
        System.out.println("El directorio ha sido creado con exito");
    }

    public void borrarDirectorio(String ruta) throws FileNotFoundException {
        File directorio = new File(ruta);

        if (!directorio.exists() || !directorio.isDirectory()) {
            throw new FileNotFoundException("Directorio no encontrado: " + ruta);
        }

        borrarRecursivo(directorio);
    }

    // Método auxiliar recursivo
    private void borrarRecursivo(File archivo) {
        if (archivo.isDirectory()) {
            File[] contenido = archivo.listFiles();
            if (contenido != null) {
                for (File f : contenido) {
                    borrarRecursivo(f); // Borrar el contenido primero
                }
            }
        }
        // Luego borrar el archivo o directorio vacío
        if (!archivo.delete()) {
            System.out.println("No se pudo borrar: " + archivo.getAbsolutePath());
        }
    }

    public void listarDirectorio(String ruta) throws FileNotFoundException {
        File directorio = new File(ruta);
        String[] lista = directorio.list();
        if (directorio.isDirectory() && directorio.exists()) {
            for (String entry : lista) {
                System.out.println(entry);
            }
        } else {
            throw new FileNotFoundException("no se encontro el directorio");
        }

    }

}
