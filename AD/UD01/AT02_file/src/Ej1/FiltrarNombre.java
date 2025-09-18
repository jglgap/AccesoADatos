package Ej1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;

public class FiltrarNombre implements FilenameFilter{

    private String extension;
    public FiltrarNombre(String extension){
        this.extension = extension;
    } 

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(this.extension);
    }


}
