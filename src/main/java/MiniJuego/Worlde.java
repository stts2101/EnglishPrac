package MiniJuego;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.Proxy;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Worlde extends MiniJuego{
        private char[] palabra;
        private char[] respWordle;
        private String respuesta;
        private String palabraInicialWorlde;
    public boolean elegirPalabra(){
        Gson gson = new Gson();
        String json = "";
        try {
            json = Files.readString(Paths.get( "src/main/resources/bancoPalabras.json" ));
        }catch (IOException io){}
        Type type = new TypeToken<List<String>>(){}.getType();
        List<String> bancoPalabras = gson.fromJson(json,type);
        int randomNumber = (int) (Math.random() * 50);
        this.palabraInicialWorlde = bancoPalabras.get(randomNumber);
        return true;
    }


    @Override
    public boolean play(){
        // select a random word.
        String pal = "starship";
        this.palabra = pal.toLowerCase().toCharArray();
        setRespWordle(palabra.length);
        System.out.println("Word of " +palabra.length + " letters.");
        Scanner tecaldo = new Scanner(System.in);
        // que sea uno, que stenga que escribir separado?
        System.out.println( "Introduzca palabra wordle: ");
        setRespuesta( tecaldo.nextLine()  );
        char[] respChar = respuesta.toLowerCase().toCharArray();
        arrayToStringWordle(respChar);
        System.out.println(" ");
        if(Arrays.equals(palabra,respChar)){
            System.out.println("Respuesta correcta");
            return true;
        }
        if(palabra.length != respChar.length){
            System.out.println("Palabra largo incorrecto.");
            return false;}
        int n = 0;
        for (int i = 0;i<palabra.length;i++){
            if (palabra[i]==respChar[i]){
                n++;
                respWordle[i] = 'g';
            }else {
                respWordle[i] = 'r';
            }
        }
        // agregar los green grey o amarillos a un array
        System.out.println("Numero de letras acertadas = " + n);
        arrayToStringWordle(respWordle);

        return false;
    }
    public void arrayToStringWordle(char[] n){
        String[] n2 = new String[n.length ];
        for (int i = 0; i < n.length; i++) {
            n2[i] = String.valueOf(n[i]);
        }
        Arrays.stream(n2)
                .map(e -> "[" + e + "]")
                .forEach(element -> System.out.print(element + ", "));
    }

    public void setPalabra(char[] palabra) {
        this.palabra = palabra;
    }

    public void setRespWordle(int n) {
        this.respWordle = new char[n];
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getPalabraInicialWorlde() {
        return palabraInicialWorlde;
    }
}
