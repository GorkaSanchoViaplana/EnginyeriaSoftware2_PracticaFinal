import java.util.Observer;
import java.util.ArrayList;

public class Entrenador extends Participants implements SubjectEntrenador {
    //private Equip meuEquip;
    //private Partit partitJugant;
    private ArrayList<ObserverEntrenador> llistaObservers; //Nomes seran els que estan al camp

    public Entrenador(String nom,String cognom,String numfed) {
       // this.meuEquip = meuEq;
        llistaObservers = new ArrayList<ObserverEntrenador>();
        this.Nom = nom;
        this.Cognom = cognom;
        this.NumFed = numfed;
        //this.partitJugant =partit;
    }

    public void donarOrdre(String missatge){
        notifica(missatge);
    }


    @Override
    public void notifica(String missatge) {
        for(ObserverEntrenador o : llistaObservers){
            o.actualitzaEntrenador(missatge);
        }
    }

    @Override
    public void donaAlta(ObserverEntrenador o) {
        if(!llistaObservers.contains(o)){
            llistaObservers.add(o);
        }
    }

    @Override
    public void donaBaixa(ObserverEntrenador o) {
        llistaObservers.remove(o);
    }
}
