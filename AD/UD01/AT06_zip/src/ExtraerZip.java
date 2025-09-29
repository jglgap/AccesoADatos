import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ExtraerZip {

    public void descomprimir(String ficheroZip, String destino){
        File directorio = new File(destino);
        if (!directorio.exists()) {
            directorio.mkdir();
        }

        try (FileInputStream fis = new  FileInputStream(ficheroZip); ZipInputStream zis = new ZipInputStream(fis)) {
            ZipEntry entrada;
            
            while ((entrada = zis.getNextEntry()) != null) {
                System.out.println("extrayendo fichero" + entrada.getName());

                File newFile = new File(destino,entrada.getName());
                new File(newFile.getParent()).mkdir();

                try(FileOutputStream fos = new FileOutputStream(newFile)){
                    byte[] buffer= new byte[1024];
                    int bytesLeidos;
                    while ((bytesLeidos = zis.read(buffer)) > 0) {
                        fos.write(buffer,0,bytesLeidos);
                    }
                }
                zis.close();
            }


        } catch (IOException e) {
            System.out.println("ioeException");
        }



    }



}
