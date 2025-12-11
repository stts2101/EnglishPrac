import Api.DictionaryApiImpl;
import Api.GeminiTextGeneratorImpl;
import MiniJuego.*;
import RPG.*;
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
        Enemigo enemigo = new Enemigo("goblino",30,30,3,40,40,30);

        Scanner teclado = new Scanner(System.in);

        boolean fin = false;
        while (!fin) {
            System.out.println(jugador.getTrabajo());
            System.out.println("Nivel: " + jugador.getLv());
            System.out.println();
            System.out.println("Enemigo: " + enemigo.getNombreEnemigo());
            System.out.println("Nivel: " + enemigo.getLv());
            System.out.println("Elige una opcion.");
            System.out.println("1. Combate ");
            System.out.println("2. Worlde");
            System.out.println("3. Dialogo");
            System.out.println("0. Cerrar programa");
            int opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    Menu.iniciarCombate(jugador, enemigo);
                    break;
                case 2:
                    Menu.jugarMiniJuego(new Worlde(new DictionaryApiImpl()), jugador);
                    break;
                case 3:
                    Menu.jugarMiniJuego(new Dialogo(new GeminiTextGeneratorImpl()), jugador);
                    break;
                case 0:
                    fin = true;
                    break;
            }
        }


//        Enemigo enemigo2 = new Enemigo("eskileto",30,30,3,10,40,30);
//        Enemigo enemigo3 = new Enemigo("Duragon",30,30,10,10,40,30);
//        List<Personaje> litaEnemigos = Arrays.asList(enemigo,enemigo2,enemigo3) ;
//        Gson gson = new Gson();
//        String jsonString = gson.toJson(litaEnemigos);
//        System.out.println(" ");
//        System.out.println(jsonString);
//        enemigo.guardarJson();

//         Worlde mini1 = new Worlde();
//         mini1.elegirPalabra();
//         System.out.println( mini1.getPalabraInicialWorlde() );
//         Menu.jugarMiniJuego(mini1);




//         Dialogo dialogo = new Dialogo();
//        System.out.println( dialogo.getContexto() );

//        Jugador j2 = Jugador.crearNuevoJugador(23,3,3,3,3,3,new Trabajo("cazador"));
//        j2.guardarJson(); // se guarda en jugador.json
        // necesito que al abrir el programa chekee si jugador.json tinene datos o no

    }
}
