public class Equip {
    private Jugador[] pista;
    private Jugador[] banquillo;
    private Jugador[] expulsats; //Pel que fa aquest programa, l'expulsio indicara que han estat executats i mai tornaran
    private String Nom;
    private String Localitat;
    private EsquemaDefensa EsqDefensa;
    private EsquemaAtac EsqAtac;
    private Entrenador EntrenadorEquip;
    private int nFaltes;
    Equip(){
        this.pista= new  Jugador[7];
        this.banquillo= new  Jugador[5+7];
        this.expulsats= new  Jugador[12];
        nFaltes=0;
    }
    Equip(String nom, String localitat,Entrenador entrenadorEquip){
        this.pista= new  Jugador[7];
        this.banquillo= new  Jugador[5+7];
        this.expulsats= new  Jugador[12];
        this.Nom = nom;
        this.Localitat = localitat;
        this.EntrenadorEquip = entrenadorEquip;
        nFaltes=0;
    }
    public void setEntrenadorEquip(Entrenador entrenadorEquip){
        this.EntrenadorEquip=entrenadorEquip;
    }
    public void setNom(String nom){
        this.Nom=nom;
    }
    public void setLocalitat(String localitat){
        this.Localitat=localitat;
    }
    //public Jugador retornaJugador(String numFed){
    //      return new Jugador();
    //   }

    public void canviarFormacio(String Formacio){

    }

    public void inserirJugador(Jugador jug, String estat){
        if(estat.equals("p")){
            for(int i = 0; i < pista.length; i++){
                if(pista[i] == null){
                    pista[i] = jug;
                    EntrenadorEquip.donaAlta(jug);
                    break;
                }
            }
        } else if(estat.equals("b")){
            for(int i = 0; i < banquillo.length; i++){
                if(banquillo[i] == null){
                    banquillo[i] = jug;
                    break;
                }
            }
        }
    }

    public void mostarJugadorsEquip() {
        System.out.println("JUGADORS DE LA PISTA");
        for (Jugador jugador : pista) {
            if(jugador != null){
                jugador.mostrarJugador();
            }
            else{
                System.out.println("---Expulsat---");
            }
        }
        System.out.println("JUGADORS DEL BANQUILLO");
        for (Jugador jugador : banquillo) {
            if(jugador != null){
                jugador.mostrarJugador();
            }
        }
    }

    public void mostrarJugadorsCamp(){
        for (Jugador jugador : pista) {
            if(jugador != null){
                jugador.mostrarJugador();
            }
            else{
                System.out.println("---Expulsat---");
            }

        }
    }

    public Jugador retornaJugador(String numFed) {
        // Cerca a la pista
        for (Jugador j : pista) {
            if (j != null && j.getNumFed().equals(numFed)) {
                return j;
            }
        }
        // Cerca al banquillo
        for (Jugador j : banquillo) {
            if (j != null && j.getNumFed().equals(numFed)) {
                return j;
            }
        }
        return null;
    }

    public void intercanviarJugadors(String jugPista, String jugBanquillo) {

        int posPista = cercarJugador(pista, jugPista);
        if (posPista == -1) {
            System.out.println("Jugador de la pista no trobat.");
            return;
        }

        int posBanquillo = cercarJugador(banquillo, jugBanquillo);
        if (posBanquillo == -1) {
            System.out.println("Jugador del banquillo no trobat.");
            return;
        }

        if(banquillo[posBanquillo].getEstaExpulsat()){ // els jugadors de la pista no poden estar expulsats
            System.out.println("Un dels jugadors està expulsat");
            return;
        }

        // Intercanviar jugadors
        EntrenadorEquip.donaBaixa(pista[posPista]);
        EntrenadorEquip.donaAlta(pista[posBanquillo]);
        
        Jugador temp = pista[posPista];
        pista[posPista] = banquillo[posBanquillo];
        banquillo[posBanquillo] = temp;

        System.out.println("Jugadors intercanviats correctament.");
    }

    private int cercarJugador(Jugador[] array, String numFed) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].getNumFed().equals(numFed)) {
                return i;
            }
        }
        return -1;
    }

    public Jugador retornaJugPista(String numFed){
        for(Jugador jug : pista){
            if(jug.getNumFed().equals(numFed)){
                return jug;
            }
        }
        return null;
    }
    public void expulsarJugadorTemporalment(String numFed){
        int posPista = cercarJugador(pista, numFed);
        int posBanquillo = cercarJugador(banquillo, numFed); //Ho faig amb 2 pq encara q sigui ineficient no puc saber on esta el jugador
        if (posPista == -1 &&  posBanquillo == -1) {
            System.out.println("Jugador de la pista no trobat.");
            return;
        }
        else if(posBanquillo== -1){
            for(int j = 0; j < banquillo.length; j++){
                if(banquillo[j] == null){
                    banquillo[j] = pista[posPista];
                    pista[posPista] = null;
                    System.out.println("S'ha expulsat temporalment al jugador amb dorsal "+banquillo[j].getNumFed()); //faig aqui el print pq aixi ho demana el enunciat
                    banquillo[j].Expulsar();
                    EntrenadorEquip.donaBaixa(banquillo[j]); //En teoria aixo hauria de funcionar
                    return;
                }
            }
        }
        else{
            banquillo[posBanquillo].Expulsar();
        }

    }
    public void expulsarJugadorDefinitivament(String numFed){
        int posBanquillo = cercarJugador(banquillo, numFed); //Tal i com funciona el programa, sempre estara al banquillo
        if (posBanquillo == -1) {
            System.out.println("Jugador de la pista no trobat.");
            return;
        }
        for(int j = 0; j < expulsats.length; j++){
            if(expulsats[j] == null){
                expulsats[j] = banquillo[posBanquillo];
                banquillo[posBanquillo] = null;
                System.out.println("S'ha expulsat definitivament al jugador amb dorsal "+expulsats[j].getNumFed());
                return;
            }
        }
    }

    public void enviarMissatge(String miss){
        EntrenadorEquip.donarOrdre(miss);
    }

    public void afegirFalta(){
        this.nFaltes++;
    }
    public int getNFaltes(){
        return nFaltes;
    }
}
