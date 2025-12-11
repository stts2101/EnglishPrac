package RPG;

public class Combate {
    private Jugador jugador;
    private Enemigo enemigo;
    private boolean empiezaJugador;
    private boolean finCombate = false;
    private boolean victoriaJugador;
    public Combate(Jugador jugador) {
        this.jugador = jugador;
        this.empiezaJugador = Math.random() < 0.5;
    }
    public boolean agregarEnemigo(Enemigo enemigo){
        this.enemigo = enemigo;
        return true;
    }


    public void turnoCombate(int accionJugador, int accionEnemigo){
         if (accionJugador == 0 || accionEnemigo == 0){
             return;
         }
         if (empiezaJugador){
             int damage = jugador.atacar();
             enemigo.calcularDamage(damage);
             if(enemigo.isDead()){
                 setVictoriaJugador(true);
                 setFinCombate(true);
                 return;}
             damage = enemigo.atacar();
             jugador.calcularDamage(damage);
             if (jugador.isDead()){
                 setVictoriaJugador(false);
                 setFinCombate(true);
             }
         } else {
             int damage = enemigo.atacar();
             jugador.calcularDamage(damage);
             if (jugador.isDead()){
                 setVictoriaJugador(false);
                 setFinCombate(true);
                 return;
             }
             damage = jugador.atacar();
             enemigo.calcularDamage(damage);
             if(enemigo.isDead()){
                 setVictoriaJugador(true);
                 setFinCombate(true);
                 enemigo.setDerrotado(true);
             }
         }
    }

    public void setFinCombate(boolean finCombate) {
        this.finCombate = finCombate;
    }

    public void setVictoriaJugador(boolean victoriaJugador) {
        this.victoriaJugador = victoriaJugador;
    }
    // selctorDeTurno al.
    // iniciarBatalla
    // finBatalla
    // isBatleOver


    public boolean isEmpiezaJugador() {
        return empiezaJugador;
    }

    public boolean getFinCombate() {
        return finCombate;
    }

    public boolean isVictoriaJugador() {
        return victoriaJugador;
    }
}
