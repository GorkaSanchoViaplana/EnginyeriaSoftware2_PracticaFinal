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
                }
            }
        } else if(estat.equals("b")){
            for(int i = 0; i < banquillo.length; i++){
                if(banquillo[i] == null){
                    banquillo[i] = jug;
                }
            }
        }

    }
    Equip(String nom, String localitat){
        this.pista= new  Jugador[7];
        this.banquillo= new  Jugador[5];
        this.Nom = nom;
        this.Localitat = localitat;
    }
}
