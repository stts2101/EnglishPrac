import MiniJuego.Dialogo;
import MiniJuego.Worlde;
import RPG.Combate;
import RPG.Jugador;
import RPG.Trabajo;
import com.google.gson.Gson;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Menu {
//    public static void main(String[] args) {
//        Dialogo dial1 = new Dialogo();
//        System.out.println( dial1.getContexto() );
//        // dial1.play();
//
//
//        Worlde w1 = new Worlde();
//        w1.elegirPalabra();
//        System.out.println(  w1.getPalabraInicialWorlde());
//    }
    public static Jugador elegirJugador(){
        if (Jugador.existeJugadorCreado()){
            System.out.println("Existe un jugador");
            Gson gson = new Gson();
            String json = "";
            try {
                json = Files.readString(Paths.get("src/main/resources/jugador.json"));
            }catch (Exception e){}
            Jugador jugador = gson.fromJson(json,Jugador.class);
            return jugador;

        } else {
            System.out.println("Elige el Trabajo del personaje: ");
            System.out.println("1. Guerrero 2.Guardian 3.Cazador");
            Scanner tecaldo = new Scanner(System.in);
            int eleccion = tecaldo.nextInt();
            Trabajo trabajo1;
            switch (eleccion){
                case 1:
                    trabajo1 = new Trabajo("Guerrero");
                    break;
                case 2:
                    trabajo1 = new Trabajo("Guardian");
                    break;
                case 3:
                    trabajo1 = new Trabajo("Cazador");
                    break;
                default: trabajo1 = new Trabajo("guerrero");
            }
            Jugador jugador = Jugador.crearNuevoJugador(25,25,1,10,30,10,trabajo1);
            return jugador;
        }

    }

    public static Combate realizarCombate(){}


}
