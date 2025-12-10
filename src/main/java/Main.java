import RPG.Jugador;
import RPG.Trabajo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Jugador jugador = Menu.elegirJugador();
        System.out.println(jugador);
//        Jugador j2 = Jugador.crearNuevoJugador(23,3,3,3,3,3,new Trabajo("cazador"));
//        j2.guardarJson(); // se guarda en jugador.json
        // necesito que al abrir el programa chekee si jugador.json tinene datos o no

    }
}
