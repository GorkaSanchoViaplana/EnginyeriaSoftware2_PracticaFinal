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
        this.EstaExpulsat=false;
    }

    public void mostrarJugador(){
        System.out.println("Num Federacio: "+NumFed + " Nom: "+Nom + " "+Cognom);
    }

    public void mostraMissatge(String missatge){
        System.out.println(this.Nom+" "+this.Cognom+" "+this.NumFed+": "+"Missatge Rebut: "+missatge);
    }

    @Override
    public void actualitzaEntrenador(String missatge) {
        mostraMissatge(missatge);
    } //Una mica raro per un observer pero ho veig optim

    public boolean getEstaExpulsat(){ return this.EstaExpulsat; }

    public void Expulsar(){
        this.EstaExpulsat=true;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return NumFed.equals(jugador.NumFed);
    }
    @Override
    public int hashCode() {
        return NumFed != null ? NumFed.hashCode() : 0;
    }
}
