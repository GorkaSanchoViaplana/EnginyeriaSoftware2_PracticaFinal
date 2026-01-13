import java.util.ArrayList;
public class Partit {
    private Pilota pilotaPartit;
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

    public Posicio RetornaPosPilota(){
        Posicio p = new Posicio(1,1,1);
        return p;
    }


    public Posicio retornaPosArbitre(){
        Posicio p = new Posicio(1,1,1);
        return p;
    }

    public void gestionarExpulsio(Boolean Local,String numJugador,int nArbitre ){
        if(Local){
            SancionarJugador(equipLocal,numJugador,nArbitre-1);
        }else{
            SancionarJugador(equipRemot,numJugador,nArbitre-1);
        }
    }

    private void SancionarJugador(Equip eq,String numJugador,int nArbitre){

        Jugador Sancionat =  eq.retornaJugador(numJugador);
        if(Sancionat==null){ //Control d'errors aixi ben duro
            System.out.println("El jugador de dorsal "+numJugador+" no existeix a aquest equip");
            return; //Si no existeix el player poc podem fer
        }
        Sancio sancio = arbitres[nArbitre].SancionarGroga(Sancionat); //La sancio la fica/crea el arbit
        afegirFalta(sancio);
        eq.afegirFalta();
        mostrarSancio(sancio);
        if(maxGrogues<eq.getNFaltes() || nFaltesJugador(Sancionat) ==2){ //falta un OR per veure si el player ja tenia groga i ferlo fora directament
            eq.expulsarJugadorTemporalment(numJugador);
        }else if(nFaltesJugador(Sancionat) >=3){ //No hauria de ser mes gran que 3 mai
            eq.expulsarJugadorDefinitivament(numJugador);
        }
    }

    private void mostrarSancio(Sancio sancio){
        System.out.println("S'ha afegit una falta "+sancio.getTipusSancio()+" al jugador amb dorsal "+sancio.getSancionat().getNumFed()+" a l'hora "+sancio.getHoraExpulsio()+" pel arbit amb numero de federacio "+sancio.getArbitIden());
    }
    private void afegirFalta(Sancio falta){
        this.sancions.add(falta);
    }
    private int nFaltesJugador(Jugador Sancionat){
        int nSancions=0;
        for(Sancio sancio:this.sancions){
            if(sancio.getSancionat().equals(Sancionat)){
                nSancions++;
            }
        }
        return nSancions;
    }

    public void enviarMissatge(boolean local,String missatge){
        if(local){
            equipLocal.enviarMissatge(missatge);
        }else{
            equipRemot.enviarMissatge(missatge);
        }
    }

    public void mostrarJugadors(boolean local){
        if(local){
            equipLocal.mostarJugadorsEquip();
        }else{
            equipRemot.mostarJugadorsEquip();
        }
    }
    public void intercanviarJugadors(boolean local, String JugPartit, String JugBanquillo,Rol r)
    {
        if(local){
            equipLocal.intercanviarJugadors(JugPartit,JugBanquillo,r);
            equipLocal.mostarJugadorsEquip();
        }else{
            equipRemot.intercanviarJugadors(JugPartit,JugBanquillo,r);
            equipRemot.mostarJugadorsEquip();
        }
    }

}
