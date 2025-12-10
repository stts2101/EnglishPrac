package MiniJuego;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Dialogo extends MiniJuego{
    private String contexto;
    private String respuesta;

    public Dialogo(){
        Gson gson = new Gson();
        String json = "";
        try {
             json = Files.readString(Paths.get("src/main/resources/contexto.json"));
        }catch (IOException e){
            System.out.println("Error al leer el contexto.");
        }
        this.contexto = gson.fromJson(json,String.class);

    }

    public String getContexto() {
        return contexto;
    }

    @Override
    public boolean play() {
        return super.play();
    }
}
