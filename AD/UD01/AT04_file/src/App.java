import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
    
        Map<Character,Character> code = new HashMap<>();

        try {
            FileReader reader = new FileReader("codec.txt");
            BufferedReader buffer = new BufferedReader(reader);
            
            String abecedario = "";
            String encriptado = "";
            String line = buffer.readLine();

            while (line != null) {
                abecedario = line;
                line = buffer.readLine();
                encriptado = line;
                line = buffer.readLine();
                
            }

            // System.out.println("Esto es abecedario: " + abecedario);
            // System.out.println("Esto es encriptado: "+ encriptado);

            char[] letrasAbecedario =  abecedario.toCharArray();
            char[] caracteres = encriptado.toCharArray();
            for (int i = 0; i < letrasAbecedario.length; i++) {
                code.put(letrasAbecedario[i], caracteres[i]);
            }



            for (char key : code.keySet()) {
                System.out.println(key + " " + code.get(key));
            }
            
            buffer.close();
            reader.close();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
