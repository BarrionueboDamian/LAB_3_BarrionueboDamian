import Exepciones.MasDeTresExeption;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        try {
            File file = new File("jugadores.json");
            ObjectMapper mapper = new ObjectMapper();
            Jugador[] listaDeJ = mapper.readValue(file, Jugador[].class);
            /*for (Jugador j : lista) {
                System.out.println(j);
            }*/
            ColeccionOjos listaOjos = new ColeccionOjos();
            ColeccionPosition listaPosition = new ColeccionPosition();
            ///8
            ///Ojos
            for (Jugador jug : lista) {
                listaOjos.agregar( jug );
            }
            ///position
            for (Jugador jug : lista) {
                listaPosition.agregar( jug );
            }
            ///9
            try{
                Integer cant1 = cantElementos(listaOjos.getColor(),"Blue",4);
                Integer cant2 = cantElementos(listaPosition.getPosition(),"Blue",4);
            }catch (MasDeTresExeption e){
                System.out.println(e.getMessage());
            }
            ///10
            try{
                pasarAJson(lista, "$2,200.00");
            }catch (IOException e){
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
    ///Punto 9:
    public static Integer cantElementos(Map<String,List<Jugador>> lista, String key, Integer z) throws MasDeTresExeption {
        Integer cant = 0;
        int canter = 0;
        List<Jugador> listitaInterna = new ArrayList<Jugador>();
        if( lista.containsKey(key) ){
            listitaInterna = lista.get(key);
            for (Jugador jug : listitaInterna) {
                cant = cant + 1;
            }
        }
        if(cant >= z){
            throw new MasDeTresExeption("Clave: " + key + " Diferencia: " + (z-cant)  );
        }
        return  cant;
    }
    public static void pasarAJson(List<Jugador> lista, String sueldo) throws IOException{
        File archivo = new File("C:\\Users\\usuario\\Desktop\\test");
        ObjectMapper buffer = new ObjectMapper();
        List<Jugador> adinerados = new ArrayList<Jugador>();
        for (Jugador jug : lista) {
            if (jug.getBalance().compareTo(sueldo) >= 0 ){
                adinerados.add(jug);
            }
        }
    }
}
