package RPG;

import com.google.gson.Gson;

public class Trabajo {
    private double hpMod;
    private double defensaMod;
    private double ataqueMod;
    private int criticoMod;
    private String tipoTrabajo;


    public Trabajo(String tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
        switch (tipoTrabajo.toLowerCase()){
            case "guerrero":
                this.hpMod = 1.25;
                this.defensaMod = 1.1;
                this.ataqueMod = 1.60;
                this.criticoMod = 0;
                break;
            case "guardian":
                this.hpMod = 1.25;
                this.defensaMod = 1.60;
                this.ataqueMod = 1.1;
                this.criticoMod = 0;
                break;
            case "cazador":
                this.hpMod = 1.1;
                this.defensaMod = 1;
                this.ataqueMod = 1.25;
                this.criticoMod = 2;
                break;
        }


    }
    public double getHpMod() {
        return hpMod;
    }

    public double getDefensaMod() {
        return defensaMod;
    }

    public double getAtaqueMod() {
        return ataqueMod;
    }

    public int getCriticoMod() {
        return criticoMod;
    }

    public String getTipoTrabajo() {
        return tipoTrabajo;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
