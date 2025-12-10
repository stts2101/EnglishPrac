package RPG;

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

    public void atacar(){}

    @Override
    public String toString() {
        return "maxHp=" + maxHp +
                ", hpActual=" + hpActual +
                ", Lv=" + Lv +
                ", defensa=" + defensa +
                ", critico=" + critico +
                ", ataque=" + ataque ;
    }
}
