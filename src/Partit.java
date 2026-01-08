import java.util.Observer;
import java.util.ArrayList;
public class Partit implements SubjectPartit,ObserverPilota,ObserverArbitre {
    private Pilota pilotaPartit;
    private ObserverPartit[] observerPartit;
    private ArrayList<Sancio> sancions;
    private Equip equipLocal;
    private Equip equipRemot;
    //Recordar tocar el diagrama que els entrenadors ara son al equip i no al partit !!
    private Arbitre[] arbitres;
    private static Partit instance;
    private int maxGrogues;
    private Partit(){
        this.pilotaPartit = new Pilota();
        this.sancions = new ArrayList<Sancio>(256); //Millor fer un arrayList de tamany n
        this.observerPartit = new ObserverPartit[28]; //Ha d'haber mes, seran uns 30
        this.arbitres = new Arbitre[2]; //Sempre tindrem 2 arbits
        this.maxGrogues = 3;
    }


    public static Partit GetInstance(){
        if(instance==null){
            instance = new Partit();
        }
        return instance;
    }


    public void setEquips(Equip remot, Equip local){
        this.equipRemot=remot;
        this.equipLocal=local;
    }
    public void setArbitres(Arbitre arbitrePrincipal,Arbitre arbitreSuplent){
        this.arbitres[0]=arbitrePrincipal;
        this.arbitres[1]=arbitreSuplent;
    }
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

    public void gestionarSancio(Boolean Local,String numJugador){
        if(Local){
            SancionarJugador(equipLocal,numJugador);
        }else{
            SancionarJugador(equipRemot,numJugador);
        }
    }
    private void SancionarJugador(Equip eq,String numJugador){

        Jugador Sancionat =  eq.retornaJugador(numJugador);
        if(Sancionat==null){ //Control d'errors aixi ben duro
            System.out.println("El jugador de numFed"+numJugador+" no existeix");
            return; //Si no existeix el player poc podem fer
        }
        Sancio sancio = arbitres[0].SancionarGroga(Sancionat);
        afegirFalta(sancio);
        eq.afegirFalta();
        if(maxGrogues<eq.getNFaltes()){ //falta un OR per veure si el player ja tenia groga i ferlo fora directament
            eq.expulsarJugador(numJugador);
        }
    }
    private void afegirFalta(Sancio falta){
        this.sancions.add(falta);
    }
    public Jugador retornaJugador(String numfed){
        Jugador j = new Jugador();
        return j;
    }

    @Override
    public void donaAlta(ObserverPartit o) {

    }

    @Override
    public void donaBaixa(ObserverPartit o) { //Els observers sempre tindran numFed

    }

    @Override
    public void notifica() { //Fem que sigui pull pq sino ens morim

    }

    @Override
    public void actualitzaPilota(Posicio p) {

    }

    @Override
    public void actualitzaArbitre(Posicio p) {

    }

}
