package RPG;

public class Jugador extends Personaje {
    private int experiencia;
    private int sgteNivel;
    private Trabajo trabajo;

    public Jugador(int maxHp, int hpActual, int lv, int defensa, int critico, int ataque) {
        super(maxHp, hpActual, lv, defensa, critico, ataque);
    }


}
