package RPG;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JugadorRepositorio {
    public static boolean existeJugadorCreado(){
        try {
            File archivo = new File("src/main/resources/jugador.json");
            return archivo.exists() && archivo.length() > 0;
        } catch (Exception e) {
            return false;
        }
    }
    public static void guardarJson(Jugador j){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()  // For nicely formatted JSON
                .create();
        // Create or overwrite the JSON file
        FileWriter writer = null;
        try {
            writer = new FileWriter("src/main/resources/jugador.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Create your data object

        // Convert object to JSON and write to file
        gson.toJson(j, writer);
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("JSON file overwritten successfully!");


    }
}
