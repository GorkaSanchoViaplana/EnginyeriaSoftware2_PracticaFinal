import java.util.Observer;

public class Jugador extends Participants implements ObserverEntrenador {
    private Posicio Pos;
    private float Orientacio;
    private float Velocitat;
    private float Acceleracio;
    private char MaDominant;
    private float Pes;
    private float Alcada;
    private Boolean EstaExpulsat;
    private float forca;
    private float precisioXut;
    private float HabilitatFintant;
    private float PotenciaSalt;
    Jugador(){

    };
    Jugador(String numfed,String nom,String cognom,Posicio Pos){
        this.Pos=Pos;
        this.NumFed = numfed;
        this.Nom = nom;
        this.Cognom = cognom;
    }
    public void mostraMissatge(String missatge){
        System.out.println("Numero Federacio "+NumFed+" "+"Missatge: "+missatge);
    }

    @Override
    public void actualitzaEntrenador(String missatge) {
        mostraMissatge(missatge);
    }

}
