import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ColeccionOjos {
    private Map<String,List<Jugador> > color;

    public ColeccionOjos() {
        this.color = new TreeMap<String , List<Jugador> >();;
    }

    public void agregar(Jugador p){
        if(!this.color.containsKey(p.getEyeColor())){
            List<Jugador> lista = new ArrayList<Jugador>();
            lista.add(p);
            this.color.put(p.getEyeColor(),lista);
        }else{
            List<Jugador> lista = new ArrayList<Jugador>();
            lista.add((Jugador) this.color.get(p.getEyeColor()));
            lista.add(p);
            this.color.replace(p.getEyeColor(),lista);
        }
    }

    public List<Jugador> devolver(String e){
        return this.color.get(e);
    }

    public int contar(){
        return this.color.size();
    }

    public String listar() {
        return "JugadoresOjos{" +
                "lista=" + color.toString() +
                '}';
    }

    public Map<String, List<Jugador>> getColor() {
        return color;
    }

}
