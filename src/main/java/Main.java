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
        Jugador j2 = Jugador.crearNuevoJugador(23,3,3,3,3,3,new Trabajo("cazador"));
        j2.guardarJson();

    }
}
