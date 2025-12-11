package RPG;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Enemigo extends Personaje {
    private String nombreEnemigo;
    private boolean derrotado;
    public Enemigo(String nombreEnemigo, int maxHp, int hpActual, int lv, int defensa, int critico, int ataque) {
        super(maxHp, hpActual, lv, defensa, critico, ataque);
        this.nombreEnemigo = nombreEnemigo;

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
    public boolean isDead() {
        return super.isDead();
    }

    public boolean isDerrotado() {
        return derrotado;
    }

    public void setDerrotado(boolean derrotado) {
        this.derrotado = derrotado;
    }
    public void guardarJson(){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()  // For nicely formatted JSON
                .create();
        // Create or overwrite the JSON file
        FileWriter writer = null;
        try {
            writer = new FileWriter("src/main/resources/enemigos.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Create your data object
        Enemigo person = this;

        // Convert object to JSON and write to file
        gson.toJson(person, writer);
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("JSON file overwritten successfully!");


    }

    public String getNombreEnemigo() {
        return nombreEnemigo;
    }
}
