package RPG;

public class Enemigo extends Personaje {
    private String nombreEnemigo;
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
}
