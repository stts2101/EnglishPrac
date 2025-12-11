package MiniJuego;

public abstract class MiniJuego {
    private double experiencia;
    private boolean finMinijuego;
    private boolean victoria;

    public MiniJuego() {
        this.finMinijuego = false;
    }

    public boolean play(){return true;}

    public boolean isFinMinijuego() {
        return finMinijuego;
    }

    public void setFinMinijuego(boolean finMinijuego) {
        this.finMinijuego = finMinijuego;
    }
    public boolean isVictoria() {
        return victoria;
    }

    public void setVictoria(boolean victoria) {
        this.victoria = victoria;
    }
}
