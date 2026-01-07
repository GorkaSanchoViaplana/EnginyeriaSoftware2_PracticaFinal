import java.util.Observer;
import java.util.ArrayList;

public class Entrenador extends Participants implements ObserverArbitre,ObserverPartit,SubjectEntrenador {
    private Equip meuEquip;
    private Partit partitJugant;
    private ArrayList<ObserverEntrenador> llistaObservers; //Nomes seran els que estan al camp

    public Entrenador(Equip meuEq,String nom,String cognom,String numfed,Partit partit) {
        this.meuEquip = meuEq;
        llistaObservers = new ArrayList<ObserverEntrenador>();
        this.Nom = nom;
        this.Cognom = cognom;
        this.NumFed = numfed;
        this.partitJugant =partit;
    }

    public void donarOrdre(String missatge){
        notifica(missatge);
    }

    public void actualitzaArbitre(Posicio p){

    }
    public void actualitzaPartit(){

    }

    @Override
    public void notifica(String missatge) {
        for(ObserverEntrenador o : llistaObservers){
            o.actualitzaEntrenador("Pinga");
        }
    }

    @Override
    public void donaAlta(ObserverEntrenador o) {
        llistaObservers.add(o);
    }

    @Override
    public void donaBaixa(ObserverEntrenador o) {

    }
}
