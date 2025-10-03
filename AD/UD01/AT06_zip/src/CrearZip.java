import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CrearZip {



    public void comprimir(String nombreFicheroZip, List<String> listaFicheros) throws FileNotFoundException, IOException{
       

        try(FileOutputStream fos = new FileOutputStream(nombreFicheroZip); ZipOutputStream zipOut = new ZipOutputStream(fos)){

            for (String nombre : listaFicheros) {
                File fileToZip = new File(nombre);
                FileInputStream fis = new FileInputStream(fileToZip);
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                zipOut.putNextEntry(zipEntry);

                byte[] buffer = new byte[1024];
                int byteLeidos;
                while ((byteLeidos = fis.read(buffer)) >=0 ) {
                    zipOut.write(buffer,0,byteLeidos);
                }
            }
            zipOut.close();

        }

    }

    public void comprimirDirectorioEntero(String nombreDirectorio)throws IOException{
        String nuevoFichero = nombreDirectorio + ".zip";

        File directorio = new File(nombreDirectorio);
        
       
        

        try (FileOutputStream fos = new FileOutputStream(nuevoFichero); ZipOutputStream zipOut = new ZipOutputStream(fos)) {
 
        for (File file : directorio.listFiles()) {
            //guardar subdirectorios
            
            // if (file.isDirectory()) {
            //     file.mkdir();
            // }

            File DirectoryToZip = new File(file.getPath());
            FileInputStream fis = new FileInputStream(DirectoryToZip);
            ZipEntry zipEntry = new ZipEntry(DirectoryToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int byteLeidos;
            while ((byteLeidos = fis.read(buffer)) >= 0) {
                zipOut.write(buffer, 0, byteLeidos);
            }
         }

            zipOut.close();

        } catch (IOException e) {
            System.out.println("Error!, IOException");
        }


    }


    public void introducirEnZip(){
        Map<String,String> env = new HashMap<>();

        env.put("create","true");

        Path path = Paths.get("a.zip");
        URI uri = URI.create("jar:"+path.toUri());

        String fileName = "ficheros/hola.txt";

        try (FileSystem fs = FileSystems.newFileSystem(uri,env)) {
            
            Path file = Paths.get(fileName);

            Path nf = fs.getPath("/" + file.getFileName());

            Files.write(nf, Files.readAllBytes(file), StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING); 

        } catch (IOException e) {
            System.out.println("problemas al añadir fichero");
        }


    }


}
