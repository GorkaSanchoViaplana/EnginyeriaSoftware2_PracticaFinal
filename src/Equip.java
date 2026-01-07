public class Equip {
    private Jugador pista[];
    private Jugador banquillo[];
    private String Nom;
    private String Localitat;
    private EsquemaDefensa EsqDefensa;
    private EsquemaAtac EsqAtac;
    private Entrenador EntrenadorEquip;
    public Jugador retornaJugador(String numFed){
        return new Jugador();
    }
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
    Equip(String nom, String localitat,Entrenador entrenadorEquip){
        this.pista= new  Jugador[7];
        this.banquillo= new  Jugador[5];
        this.Nom = nom;
        this.Localitat = localitat;
        this.EntrenadorEquip = entrenadorEquip; //No ens es important qui sigui el entrenador per tant fem un placeholder
    }
    public void enviarMissatge(String miss){
        EntrenadorEquip.donarOrdre(miss);
    }
}
