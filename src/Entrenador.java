import java.util.Observer;

public class Entrenador extends Participants implements ObserverArbitre,ObserverPartit,SubjectEntrenador {
    private Equip meuEquip;
    private Partit partitJugant;
    private ObserverEntrenador llistaObservers;
    public Entrenador(Equip meuEquip) {

    }

    public void actualitzaArbitre(Posicio p){

    }
    public void actualitzaPartit(){

    }

    @Override
    public void notifica() {

    }

    @Override
    public void donaAlta(ObserverEntrenador o) {

    }

    @Override
    public void donaBaixa(ObserverEntrenador o) {

    }
}
