import RPG.Jugador;
import RPG.Trabajo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Jugador j1 = new Jugador(50,23,4,3,4,5, new Trabajo("CAZADOR"));
        j1.atacar();
        System.out.println(j1 );

        Gson aiPromt = new Gson();
        String json = "";
        try {
            json = Files.readString(Paths.get("src/main/resources/contexto.json"));
        }catch (Exception e){
            System.out.println("wrong path.");
        }
        String ai1 = aiPromt.fromJson(json,String.class);
        System.out.println(ai1);
        try {
            json = Files.readString(Paths.get("src/main/resources/bancoPalabras.json") );
        }catch (Exception e){}
        String[] wordsArray = aiPromt.fromJson(json,String[].class);
        System.out.println(Arrays.toString(wordsArray));
        Type type = new TypeToken<List<String>>(){}.getType();
        List<String> wordAsList = aiPromt.fromJson(json,type);
        wordAsList.forEach(System.out::println);

    }
}
