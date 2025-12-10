package RPG;

import MiniJuego.MiniJuego;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Jugador extends Personaje {
    private int experiencia;
    private int sgteNivel;
    private Trabajo trabajo;

    public Jugador() {
        super();
    }

    public Jugador(int maxHp, int hpActual, int lv, int defensa, int critico, int ataque, Trabajo trabajo,int experiencia,int sgteNivel) {
        super(maxHp, hpActual, lv, defensa, critico, ataque);
        this.trabajo = trabajo;
        this.experiencia = experiencia;
        this.sgteNivel = sgteNivel;
    }
    public Jugador(int maxHp, int hpActual, int lv, int defensa, int critico, int ataque, Trabajo trabajo){
        super(maxHp, hpActual, lv, defensa, critico, ataque);
        this.trabajo = trabajo;
        this.experiencia = 0;
        this.sgteNivel = 70;
    }
    public static Jugador crearNuevoJugador(int maxHp, int hpActual, int lv, int defensa, int critico, int ataque, Trabajo trabajo){
        return new Jugador( maxHp,  hpActual,  lv,  defensa,  critico,  ataque, trabajo);
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

    @Override
    public boolean isDead() {
        return super.isDead();
    }
    public void sumarExperiencia(boolean juegoGanado){
        if (!juegoGanado)
            return;
        this.experiencia += 40;
        this.sgteNivel -= 40;
        if (sgteNivel<=0){
            int n = this.getLv();
            this.setLv(n+1);
            this.sgteNivel = (sgteNivel<0)? 70+sgteNivel : 70;
        }
        guardarJson();

    }
    private void subirNivel() {
        // Mejorar estadísticas al subir de nivel
        this.setMaxHp(this.getMaxHp() + 10);
        this.setHpActual(this.getMaxHp()); // Curar completamente
        this.setAtaque(this.getAtaque() + 2);
        this.setDefensa(this.getDefensa() + 1);
    }

    public void guardarJson(){
         Gson gson = new GsonBuilder()
                .setPrettyPrinting()  // For nicely formatted JSON
                .create();
            // Create or overwrite the JSON file
        FileWriter writer = null;
        try {
            writer = new FileWriter("src/main/resources/jugador.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Create your data object
            Jugador person = this;

            // Convert object to JSON and write to file
            gson.toJson(person, writer);
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("JSON file overwritten successfully!");


    }
    public static boolean existeJugadorCreado(){
        try {
            File archivo = new File("src/main/resources/jugador.json");
            return archivo.exists() && archivo.length() > 0;
        } catch (Exception e) {
            return false;
        }
    }

}
