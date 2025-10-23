package display.application;

import java.sql.Connection;

import display.connection.DBConnection;
import display.connection.MySqlConnection;

public class Main {


    public static void main(String[] args) {
        
      GestorLibro gl =  new GestorLibro();
      gl.crearLibro();

    }
}