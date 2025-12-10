package RPG;

import com.google.gson.Gson;

import java.util.Random;

public abstract class Personaje {
    private int maxHp;
    private int hpActual;
    private int Lv;
    private int defensa;
    private int critico;
    private int ataque;

    public Personaje(int maxHp, int hpActual, int lv, int defensa, int critico, int ataque) {
        this.maxHp = maxHp;
        this.hpActual = hpActual;
        Lv = lv;
        this.defensa = defensa;
        this.critico = critico;
        this.ataque = ataque;
    }

    public int atacar(){
        Random random = new Random();
        boolean crit = random.nextInt(100) < critico;
        if (crit){
            return (int) ataque+(ataque/2);
        }else
            return ataque;
    }
    public int calcularDamage(int n){
        double m = n - (defensa*(Math.random()) );
        int endDamage = (int) m;
        this.setHpActual( hpActual - endDamage );
        return  endDamage;
    }
    public boolean evadir(){
        return Math.random()<50;
    }
    public boolean isDead(){
        return hpActual<=0;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getHpActual() {
        return hpActual;
    }

    public void setHpActual(int hpActual) {
        this.hpActual = hpActual;
    }

    public int getLv() {
        return Lv;
    }

    public void setLv(int lv) {
        Lv = lv;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getCritico() {
        return critico;
    }

    public void setCritico(int critico) {
        this.critico = critico;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return  gson.toJson(this);
    }
}
