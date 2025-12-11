package MiniJuego;

import Api.GeminiTextGenerator;
import Api.GeminiTextGeneratorImpl;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Dialogo extends MiniJuego{
    private String contexto;
    private String respuesta;
    private String contextoRespuesta;


    public Dialogo(){
        super();
        Gson gson = new Gson();
        String json = "";
        try {
             json = Files.readString(Paths.get("src/main/resources/contexto.json"));
        }catch (IOException e){
            System.out.println("Error al leer el contexto.");
        }
        this.contexto = gson.fromJson(json,String.class);
        try {
            json = Files.readString(Paths.get("src/main/resources/contextoRespuesta.json"));
        }catch (IOException e){
            System.out.println("Error al leer el contexto.");
        }
        this.contextoRespuesta = gson.fromJson(json,String.class);

    }

    public String getContexto() {
        return contexto;
    }

    @Override
    public boolean play() {
        GeminiTextGenerator gemini1 = new GeminiTextGeneratorImpl();
        String toJugador = "";
        try {
            toJugador =  gemini1.generateText(contexto);
        }catch (Exception e){}
        System.out.println(toJugador);
        String resp = recivirResp();
        System.out.println(toJugador + "    ====     "+ resp);
        String contexto2 = "\"" + resp + "\" " + contextoRespuesta;
        try {
            this.respuesta =  gemini1.generateText(contexto2);
        }catch (Exception e){}
        this.setVictoria( respuesta.toLowerCase().startsWith("c")   );
        System.out.println(respuesta);
        System.out.println("Juego Ganado?: " + isVictoria() );
        this.setFinMinijuego(true);
        //is this answer correct (not counting spelling) in the previous context, don't count similar to "I don't know" or "yes", "no". Anser with one word (correct or incorrect) a line jump and 1 line explaining why
        return isVictoria();
    }
    public String recivirResp(){
        Scanner teclado = new Scanner(System.in);
        String resp = teclado.nextLine();
        return resp;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public String getContextoRespuesta() {
        return contextoRespuesta;
    }


}
