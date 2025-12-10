import RPG.Jugador;
import RPG.Trabajo;

public class Main {
    public static void main(String[] args) {
        Jugador j1 = new Jugador(50,23,4,3,4,5, new Trabajo("CAZADOR"));
        j1.atacar();
        System.out.println(j1 );
    }
}
