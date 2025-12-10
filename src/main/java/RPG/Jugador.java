package RPG;

public class Jugador extends Personaje {
    private int experiencia;
    private int sgteNivel;
    private Trabajo trabajo;

    public Jugador(int maxHp, int hpActual, int lv, int defensa, int critico, int ataque, Trabajo trabajo) {
        super(maxHp, hpActual, lv, defensa, critico, ataque);
        this.trabajo = trabajo;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "experiencia=" + experiencia +
                ", sgteNivel=" + sgteNivel +
                ", " + super.toString() +
                ", trabajo=" + trabajo +
                '}';
    }
}
