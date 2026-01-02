import java.util.Observer;

public class Partit implements SubjectPartit, ObserverPilota,ObserverArbitre {
    private Pilota pilotaPartit;
    private ObserverPartit[] observerPartit;
    private Sancio[] sancions;
    private Equip equipLocal;
    //Fer canvi al diagrama, no fiquem als entrenadors aqui sino al equip i fem un getter
    private Equip equipRemot;
    private Arbitre[] arbitres;

    public void GestionarSancions(Sancio s){

    }
    public Posicio RetornaPosPilota(){
        Posicio p = new Posicio(1,1,1);
        return p;
    }
    public void ExpulsarJugador(Jugador j){

    }
    public void GestionaExpulsio(){

    }
    public Posicio retornaPosArbitre(){
        Posicio p = new Posicio(1,1,1);
        return p;
    }
    public Jugador retornaJugador(String numfed){
        Jugador j = new Jugador();
        return j;
    }

    @Override
    public void donaAlta(ObserverPartit o) {

    }

    @Override
    public void donaBaixa(ObserverPartit o) {

    }

    @Override
    public void notifica() {

    }

    @Override
    public void actualitzaPilota(Posicio p) {

    }

    @Override
    public void actualitzaArbitre(Posicio p) {

    }
}
