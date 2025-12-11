import MiniJuego.Dialogo;
import MiniJuego.MiniJuego;
import MiniJuego.Worlde;
import RPG.*;
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
        if (JugadorRepositorio.existeJugadorCreado()){
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
            Jugador jugador = Jugador.crearNuevoJugador(25,25,1,100,30,10,trabajo1);
            return jugador;
        }

    }
    public static boolean iniciarCombate(Jugador jugador, Enemigo enemigo){
        Combate combate = new Combate(jugador);
        combate.agregarEnemigo(enemigo);

        do {
            Scanner teclado = new Scanner(System.in);
            int randomAccionEnemigo = Math.random()<5?1:0;
            System.out.println("Hace una accion. 1. atackar 0. evadir");
            int accionPlayer = teclado.nextInt();
            combate.turnoCombate(accionPlayer,randomAccionEnemigo);
        }while(!combate.getFinCombate());
        System.out.println( "Player gano? " + combate.isVictoriaJugador());
        return true;
    }


    public static boolean jugarMiniJuego(MiniJuego mini1, Jugador j){
        boolean temp;
        do {
            mini1.play();
            temp = mini1.isFinMinijuego();
        }while (!temp);
        j.sumarExperiencia(mini1.isVictoria());
        return temp;

    }

//    public static Combate realizarCombate(){}


}
