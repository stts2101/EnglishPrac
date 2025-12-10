package RPG;

public class Trabajo {
    private double hpMod;
    private double defensaMod;
    private double ataqueMod;
    private double criticoMod;
    private short id;

    public Trabajo(String tipo) {
        switch (tipo){
            case "Guerrero":
                this.hpMod = 1;
                this.defensaMod = 1;
        }

    }
}
