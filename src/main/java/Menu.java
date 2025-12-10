import MiniJuego.Dialogo;
import MiniJuego.Worlde;

public class Menu {
    public static void main(String[] args) {
        Dialogo dial1 = new Dialogo();
        System.out.println( dial1.getContexto() );

        Worlde w1 = new Worlde();
        w1.elegirPalabra();
        System.out.println(  w1.getPalabraInicialWorlde());
    }
}
