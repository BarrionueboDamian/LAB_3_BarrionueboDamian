import java.util.ArrayList;
        import java.util.List;
        import java.util.Map;
        import java.util.TreeMap;

public class ColeccionPosition {
    Map<String, List<Jugador>> position;


    public ColeccionPosition() {
        this.position = new TreeMap<String , List<Jugador> >();;
    }


    public void agregar(Jugador p){
        if(!this.position.containsKey(p.getPosition())){
            List<Jugador> lista = new ArrayList<Jugador>();
            lista.add(p);
            this.position.put(p.getPosition(),lista);
        }else{
            List<Jugador> lista = new ArrayList<Jugador>();
            lista.add((Jugador) this.position.get(p.getPosition()));
            lista.add(p);
            this.position.replace(p.getPosition(),lista);
        }
    }

    public List<Jugador> devolver(String e){
        return this.position.get(e);
    }

    public int contar(){
        return this.position.size();
    }

    public String listar() {
        return "JugadoresOjos{" +
                "lista=" + position.toString() +
                '}';
    }
    public Map<String, List<Jugador>> getPosition() {
        return position;
    }
}