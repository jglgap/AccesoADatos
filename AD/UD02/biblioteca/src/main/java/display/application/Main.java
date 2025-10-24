package display.application;


public class Main {

  public static void main(String[] args) {

    GestorLibro gl = new GestorLibro();
    gl.crearTabla();
    gl.crearLibro();
    gl.getLibros();
    gl.getLibrosByAutor("Monica");
    gl.getLibrosByHigherYear(2018);
    gl.setNewTitle(1, "Not that bad");
    gl.setNewAuthorName(1, "Gerardo");
    gl.setNewPubYear(1, 2025);
    gl.deleteLibro(1);
    gl.deleteLibrosByYear(2019);
    gl.deleteAll();

  }
}