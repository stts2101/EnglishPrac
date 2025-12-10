package RPG;

import com.google.gson.Gson;

import java.util.Random;

public class Jugador extends Personaje {
    private int experiencia;
    private int sgteNivel;
    private Trabajo trabajo;

    public Jugador(int maxHp, int hpActual, int lv, int defensa, int critico, int ataque, Trabajo trabajo) {
        super(maxHp, hpActual, lv, defensa, critico, ataque);
        this.trabajo = trabajo;
    }

    @Override
    public int atacar() {
        return super.atacar();
    }

    @Override
    public int calcularDamage(int n) {
        return super.calcularDamage(n);
    }

    @Override
    public boolean evadir() {
        return super.evadir();
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
