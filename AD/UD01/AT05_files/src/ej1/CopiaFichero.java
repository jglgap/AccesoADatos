package ej1;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class CopiaFichero {


    
    public void copiar(Path origen, Path destino) throws IOException{
        Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);

        Path backUpDir = Paths.get("backup");

        if (!Files.exists(backUpDir)){
            Files.createDirectory(backUpDir);
        }else{
            System.out.println("ya existe");
        }

         Files.move(destino , backUpDir.resolve(destino.getFileName()) );

    }




}
